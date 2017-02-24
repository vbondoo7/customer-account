/**
 * 
 */
package com.cox.bis.customer.account.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.account.addrsscrub.model.SingleAddressTransactionalIn;
import com.cox.bis.customer.account.addrsscrub.model.SingleAddressTransactionalOut;
import com.cox.bis.customer.account.api.model.AccountsGetRequest;
import com.cox.bis.customer.account.api.model.AccountsGetResponse;
import com.cox.bis.customer.account.api.model.AccountsSearchRequest;
import com.cox.bis.customer.account.api.model.AccountsSearchResponse;
import com.cox.bis.customer.account.api.model.GetCustomerAccountRequest;
import com.cox.bis.customer.account.api.model.GetCustomerAccountResponse;
import com.cox.bis.customer.account.api.model.SearchCustomerAccountsRequest;
import com.cox.bis.customer.account.api.model.SearchCustomerAccountsResponse;
import com.cox.bis.customer.account.dao.impl.AccountsDaoImpl;
import com.cox.bis.customer.account.exception.AddressScrubClientException;
import com.cox.bis.customer.account.exception.BusinessException;
import com.cox.bis.customer.account.exception.FaultCodeException;
import com.cox.bis.customer.account.exception.RequiredFieldException;
import com.cox.bis.customer.account.model.CustomerAccount;
import com.cox.bis.customer.account.model.house.Address;
import com.cox.bis.customer.account.util.LocalConstants;
import com.cox.bis.customer.account.util.Util;

/**
 * @author jahill
 *
 */
@Component("accountsProcessor")
public class AccountsProcessor implements LocalConstants {
	
	@Autowired
	AccountsDaoImpl accountsDaoImpl; 
	
	@Autowired
    private Environment env;
	
	@EndpointInject(uri = "direct:addressScrubServiceEndpoint")
	private Endpoint addressScrubServiceEndpoint;
	
	public SingleAddressTransactionalOut scrubAddresswithFaultCodeException(Exchange exchanges, SingleAddressTransactionalIn request) 
			throws FaultCodeException, AddressScrubClientException {
		Exchange exchange = addressScrubServiceEndpoint.createExchange();
		
		exchange.setProperty("OPERATION", "scrubAddresswithFaultCodeException");
		exchange.setPattern(ExchangePattern.InOut);
		exchange.getIn().setBody(request);

		ProducerTemplate producerTemplate = exchange.getContext().createProducerTemplate();
		try {
			Exchange response = producerTemplate.send(addressScrubServiceEndpoint, exchange);
			
			if (response.getException() != null) {
				throw response.getException();
			}

			SingleAddressTransactionalOut singleAddressTransactionalOut = (SingleAddressTransactionalOut) response.getOut().getBody();
			
			String faultCodeScrub = singleAddressTransactionalOut.getFaultCodeScrub();
			
			boolean isFaultCodeScrub = StringUtils.isEmpty(faultCodeScrub);
			
			if (!isFaultCodeScrub) {
				String faultMessage = env.getProperty(faultCodeScrub);
				FaultCodeException faultCodeException = new FaultCodeException(faultMessage);
				faultCodeException.setFaultCode(faultCodeScrub);
				throw faultCodeException;
			}
			
			return singleAddressTransactionalOut;
			
		} catch (FaultCodeException e) {
			throw new FaultCodeException(e);
		} catch (Exception e) {
			throw new AddressScrubClientException(e);
		}
	}
	
	public void scrubAddress(Exchange exchange, AccountsSearchRequest accountsSearchRequest) {
		//Build SAP DataServices addressScrubRequest
		SingleAddressTransactionalIn request = new SingleAddressTransactionalIn();
		//if (((String) properties.get(L_Properties.ADDRESS_LINE_1_KEY)) != null) addressScrubRequest.setAddress1((String) properties.get(L_Properties.ADDRESS_LINE_1_KEY));
		request.setAddress1(accountsSearchRequest.getAddressLine1());
		request.setAddress2(accountsSearchRequest.getAddressLine2());
		request.setAddress3(accountsSearchRequest.getUnit());
		request.setAddress4(accountsSearchRequest.getCity());
		request.setAddress5(accountsSearchRequest.getState());
		request.setAddress6(accountsSearchRequest.getZip5());
		request.setCountry("USA");
		//Call SAP DataServices Address Scrub
		if (Util.isNotNullEmpty(accountsSearchRequest.getAddressLine1()) && Util.isNotNullEmpty(accountsSearchRequest.getCity()) && Util.isNotNullEmpty(accountsSearchRequest.getState())
				|| (Util.isNotNullEmpty(accountsSearchRequest.getAddressLine1())) && Util.isNotNullEmpty(accountsSearchRequest.getZip5())) {
			SingleAddressTransactionalOut response = null;
			try {
				response = scrubAddresswithFaultCodeException(exchange, request);
				exchange.getOut().setBody(response);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void searchAddress(AccountsSearchRequest accountsSearchRequest, SingleAddressTransactionalOut singleAddressTransactionalOut) throws Exception {
		if (singleAddressTransactionalOut == null) {
			throw new Exception("SERVICEABILITY_SKIPPED" + " -- " + "Skipping Address Search(Serviceability) due to missing 'CleanAddress' from Data Services (SAP) Address Scrub.");
		}
		List<Address> addresses = new ArrayList<Address>();
		try {
			addresses = accountsDaoImpl.addressSearch(singleAddressTransactionalOut.getStreetNumberScrub(), singleAddressTransactionalOut.getPreDirScrub(), singleAddressTransactionalOut.getStreetNameScrub(), singleAddressTransactionalOut.getPostDirScrub(), singleAddressTransactionalOut.getStreetTypeScrub(), singleAddressTransactionalOut.getUnitScrub(), singleAddressTransactionalOut.getZip5Scrub(), "exactmatch|streetnamesoundex|streetnamesimilar");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		//Loop through returned Addresses from Serviceability Search and add to the accountNumbers variable
		for (Address address : addresses) {
			accountsSearchRequest.setAccountNumbers((Util.isNullEmpty(accountsSearchRequest.getAccountNumbers()) ? address.getAccountNumber9() : accountsSearchRequest.getAccountNumbers() + "," + address.getAccountNumber9()));
		}
	}
	
	public AccountsSearchResponse search(Exchange exchange) throws Exception {
		AccountsSearchRequest accountsSearchRequest = (AccountsSearchRequest) exchange.getIn().getBody();
		/*List<String> dirList = new ArrayList<String>();
		Directives directives = new Directives();
		for (String string : directiveArr) {
			dirList.add(string);
		}
		directives.setDirectives(dirList);*/
		//Validate zip5 and map to siteId
		if (Util.isNotNullEmpty(accountsSearchRequest.getZip5()) && Util.isNullEmpty(accountsSearchRequest.getSiteId())) {
			try {
				accountsSearchRequest.setSiteId(accountsDaoImpl.zipToSiteId(accountsSearchRequest.getZip5()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//SAP Address Scrubber
		scrubAddress(exchange, accountsSearchRequest);
		SingleAddressTransactionalOut singleAddressTransactionalOut =  (SingleAddressTransactionalOut) exchange.getOut().getBody();
		//Last attempt to get siteId from AddressSearch
		if (Util.isNullEmpty(accountsSearchRequest.getSiteId()) && Util.isNotNullEmpty(singleAddressTransactionalOut) && Util.isNotNullEmpty(singleAddressTransactionalOut.getZip5Scrub())) {
			try {
				accountsSearchRequest.setSiteId(accountsDaoImpl.zipToSiteId(singleAddressTransactionalOut.getZip5Scrub()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 //Call Serviceability DB for AddressSearch functionality
		searchAddress(accountsSearchRequest, singleAddressTransactionalOut);
		//Validate siteId and map to siteCode
		// TODO accountsSearchRequest.setSiteCode(Util.mapSiteIdToSiteCode(accountsSearchRequest.getSiteId()));
		if (Util.isNotNullEmpty(accountsSearchRequest.getFirstName()) && Util.isNullEmpty(accountsSearchRequest.getLastName())) throw new RequiredFieldException("lastName");
		AccountsSearchResponse accountsSearchResponse  = searchCustomerMaster(exchange, accountsSearchRequest);
		if (accountsSearchResponse.getCustomerAccounts().isEmpty())
			throw new Exception("CUSTOMER account was null.");
		else 
			return accountsSearchResponse;
	}
	
	public AccountsSearchResponse searchCustomerMaster(Exchange exchange, AccountsSearchRequest accountsSearchRequest) throws Exception {
		//Build xHAStageSearchRequest
		SearchCustomerAccountsRequest request = new SearchCustomerAccountsRequest();
		String directives = exchange.getIn().getHeader("directives").toString();
		request.setSiteId(accountsSearchRequest.getSiteId());
		if (accountsSearchRequest.getAccountNumber() != null) request.setAccountNumber9(accountsSearchRequest.getAccountNumber());
		else if (Util.isNotNullEmpty(accountsSearchRequest.getLastName())) {
			if (Util.isNotNullEmpty(accountsSearchRequest.getFirstName())) request.setFirstName(accountsSearchRequest.getFirstName());
			request.setLastName(accountsSearchRequest.getLastName());
		}
		if (Util.isNotNullEmpty(accountsSearchRequest.getPhone())) request.setPhone(accountsSearchRequest.getPhone());
		if (Util.isNotNullEmpty(accountsSearchRequest.getEmail())) request.setEmail(accountsSearchRequest.getEmail());
		if (Util.isNotNullEmpty(exchange.getIn().getHeader("max"))) request.setMax(exchange.getIn().getHeader("max").toString());
		if (Util.isNotNullEmpty(accountsSearchRequest.getDeepSearch())) request.setDeepSearchFlag(accountsSearchRequest.getDeepSearch().equalsIgnoreCase("true"));
		if (Util.isNotNullEmpty(directives)) {
			request.setReturnAddressFlag(directives.toLowerCase().contains("address"));
			request.setReturnBillingAddressFlag(directives.toLowerCase().contains("billing"));
			request.setReturnNameFlag(directives.toLowerCase().contains("name"));
			request.setReturnEmailFlag(directives.toLowerCase().contains("email"));
			request.setReturnPhoneFlag(directives.toLowerCase().contains("phone"));
			request.setReturnSecurityFlag(directives.toLowerCase().contains("security"));
			request.setReturnCPNIQuestionFlag(directives.toLowerCase().contains("question"));
			request.setReturnCPNIAnswerFlag(directives.toLowerCase().contains("answer"));
			request.setReturnServiceFlag(directives.toLowerCase().contains("service"));
			request.setReturnActiveAccountsFlag(directives.toLowerCase().contains("active"));
			request.setReturnFormerAccountsFlag(directives.toLowerCase().contains("former"));
			request.setReturnNeverAccountsFlag(directives.toLowerCase().contains("never"));
		}
		//Set AccountNumbers search list based on addressSearch or input parameters
		if (Util.isNotNullEmpty(accountsSearchRequest.getAccountNumbers())) request.setAccountNumbers(accountsSearchRequest.getAccountNumbers());
		// Call xHASTAGE Database to search for accounts and detail (based on directives input)
		List <CustomerAccount> customerAccountList = ((SearchCustomerAccountsResponse)accountsDaoImpl.searchCustomerAccount(request)).getCustomerAccounts();
		List <CustomerAccount> customerAccountListZip5Filtered = new ArrayList<CustomerAccount>();
		//Loop through accounts to convert from Century Date to yyyyMMdd and filter by zip5
		if (customerAccountList.isEmpty()) {
			System.out.println("Customer not found OR further information required in your search parameters.");
		} else {
			for (CustomerAccount account : customerAccountList) {
				if (Util.isNotNullEmpty(account.getCustomerStatusDate()) && !account.getCustomerStatusDate().equalsIgnoreCase("0") && !account.getCustomerStatusDate().contains("9999")) account.setCustomerStatusDate(DateTimeProcessor.fromCenturyDate(account.getCustomerStatusDate()));
				if (Util.isNotNullEmpty(account.getService()) && Util.isNotNullEmpty(account.getService().getConnectDate()) && !account.getService().getConnectDate().equalsIgnoreCase("0") && !account.getService().getConnectDate().contains("9999")) account.getService().setConnectDate(DateTimeProcessor.fromCenturyDate(account.getService().getConnectDate()));
				if (Util.isNotNullEmpty(account.getService()) && Util.isNotNullEmpty(account.getService().getInstallDate()) && !account.getService().getInstallDate().equalsIgnoreCase("0") && !account.getService().getInstallDate().contains("9999")) account.getService().setInstallDate(DateTimeProcessor.fromCenturyDate(account.getService().getInstallDate()));
				if (Util.isNotNullEmpty(accountsSearchRequest.getZip5()) && Util.isNotNullEmpty(account.getAddress()) && account.getAddress().getZip5().equals(accountsSearchRequest.getZip5())) customerAccountListZip5Filtered.add(account); 
			}
		}
		//if zip5 filtered list is empty, use original accountList as a best effort search
		AccountsSearchResponse accountsSearchResponse = new AccountsSearchResponse();
		accountsSearchResponse.setCustomerAccounts((customerAccountListZip5Filtered.size() == 0) ? customerAccountList : customerAccountListZip5Filtered);
		return accountsSearchResponse;
	}
	
	public AccountsGetResponse get(Exchange exchange) throws Exception {
		AccountsGetRequest request= new AccountsGetRequest();
		AccountsGetResponse accountsGetResponse= new AccountsGetResponse();
		 request = exchange.getIn().getBody(AccountsGetRequest.class);
		 String directives=(String) exchange.getIn().getHeader("directives");
		GetCustomerAccountRequest getCustomerAccountRequest = new GetCustomerAccountRequest();
		getCustomerAccountRequest.setSiteId(request.getSiteId());
		getCustomerAccountRequest.setAccountNumber9(request.getAccountNumber());
		
		if (directives!= null) {
			getCustomerAccountRequest.setReturnNameFlag(directives.toLowerCase().contains("name"));
			getCustomerAccountRequest.setReturnAddressFlag(directives.toLowerCase().contains("address"));
			getCustomerAccountRequest.setReturnBillingAddressFlag(directives.toLowerCase().contains("billing"));
			getCustomerAccountRequest.setReturnEmailFlag(directives.toLowerCase().contains("email"));
			getCustomerAccountRequest.setReturnPhoneFlag(directives.toLowerCase().contains("phone"));
			getCustomerAccountRequest.setReturnSecurityFlag(directives.toLowerCase().contains("security"));
			getCustomerAccountRequest.setReturnCPNIQuestionFlag(directives.toLowerCase().contains("question"));
			getCustomerAccountRequest.setReturnCPNIAnswerFlag(directives.toLowerCase().contains("answer"));
			getCustomerAccountRequest.setReturnServiceFlag(directives.toLowerCase().contains("service"));
		}
		exchange.getIn().setBody(getCustomerAccountRequest);
		GetCustomerAccountResponse response = accountsDaoImpl.getCustomerAccount(getCustomerAccountRequest);
		accountsGetResponse.setCustomerAccount(response.getCustomerAccount());
		exchange.getIn().setBody(accountsGetResponse.getCustomerAccount());
		if (exchange.getIn().getBody(GetCustomerAccountResponse.class).getCustomerAccount() == null) throw new BusinessException("CUSTOMER_ACCOUNT_NOT_FOUND"+"Customer account '" + request.getAccountNumber() + "' not found.");
		else 
			
			return  accountsGetResponse;
	}
}