package com.cox.bis.customer.account.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.account.api.model.GetCustomerAccountRequest;
import com.cox.bis.customer.account.api.model.GetCustomerAccountResponse;
import com.cox.bis.customer.account.api.model.SearchCustomerAccountsRequest;
import com.cox.bis.customer.account.api.model.SearchCustomerAccountsResponse;
import com.cox.bis.customer.account.dao.AccountsDao;
import com.cox.bis.customer.account.model.BillingAddress;
import com.cox.bis.customer.account.model.CpniAnswers;
import com.cox.bis.customer.account.model.CpniQuestions;
import com.cox.bis.customer.account.model.CustomerAccount;
import com.cox.bis.customer.account.model.Email;
import com.cox.bis.customer.account.model.Name;
import com.cox.bis.customer.account.model.Phone;
import com.cox.bis.customer.account.model.Security;
import com.cox.bis.customer.account.model.Service;
import com.cox.bis.customer.account.model.house.Address;

@Component
public class AccountsDaoImpl implements AccountsDao {

	/*@Autowired
	private DataSources dataSource;*/
	
	@Autowired
	@Qualifier(value = "serviceabilitySql")
	javax.sql.DataSource serviceabilitySql;
	
	@Autowired
	@Qualifier(value = "xhastageSql")
	javax.sql.DataSource xhastageSql;

	public String zipToSiteId(String zip5) throws Exception {
		String siteId = null;
		try (Connection con = serviceabilitySql.getConnection()) {
			String preparedStatement = "SELECT TOP 1 [SiteId]  FROM [Serviceability].[dbo].[ScrubbedAllHouseMaster] WHERE [ZIP5] ="
					+ zip5 + ";";
			try (Statement stmt = con.createStatement()) {
				ResultSet rs = stmt.executeQuery(preparedStatement);
				while (rs.next()) {
					siteId = String.format("%03d", rs.getInt(1));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return siteId;
	}
	
	public List<Address> addressSearch(String streetNumber, String preDirectional, String streetName,
			String postDirectional, String streetType, String unit, String zip5, String matchMethods)  throws Exception {
		List<Address> addresses = new ArrayList<Address>();
		try (Connection con = serviceabilitySql.getConnection()) {
			String preparedStatement = "DECLARE @RC int EXECUTE @RC = [Serviceability].[dbo].[spSearchAddress] '"
					+ streetNumber + "', '" + preDirectional + "', '" + streetName + "', '" + postDirectional + "', '"
					+ streetType + "', '" + unit + "', '" + zip5 + "', '" + matchMethods + "';";
			try (Statement stmt = con.createStatement()) {
				ResultSet rs = stmt.executeQuery(preparedStatement);
				while (rs.next()) {
					Address address = new Address();
					address.setSiteId(rs.getString("SITEID"));
					address.setHouseNumber(rs.getString("HOUSENUMBER"));
					address.setOccupancyCode(rs.getString("HOUSERESIDENTNUMBER"));
					address.setFranchiseNumber(rs.getString("FRANCHISENUMBER"));
					address.setAddressLine1(rs.getString("ADDRESS1"));
					address.setAddressLine2(rs.getString("ADDRESS2"));
					address.setCity(rs.getString("CITY"));
					address.setState(rs.getString("STATE"));
					address.setZip5(rs.getString("ZIP5"));
					address.setZip4(rs.getString("ZIP4"));
					address.setPreDirectional(rs.getString("PREDIR"));
					address.setStreetNumber(rs.getString("STREETNUMBER"));
					address.setStreetName(rs.getString("STREETNAME"));
					address.setStreetType(rs.getString("STREETTYPE"));
					address.setPostDirectional(rs.getString("POSTDIR"));
					address.setUnit(rs.getString("APARTMENT"));
					// address.setDwellingType(rs.getString("DWELLINGTYPE"));
					// address.setBillTypeCode(rs.getString("BILLTYPECODE"));
					address.setCompanyNumber(rs.getString("COMPANYNUMBER"));
					address.setDivisionNumber(rs.getString("DIVISIONNUMBER"));
					// address.setHouseAddressable(rs.getString("HOUSEADDRESSABLE"));
					// address.setHouseStatus(rs.getString("HOUSESTATUS"));
					address.setLatitiude(rs.getString("LATITUDE"));
					address.setLongitude(rs.getString("LONGITUDE"));
					address.setUnitType(rs.getString("UNITTYPE"));
					address.setUnitCode(rs.getString("UNIT"));
					address.setBuilding(rs.getString("BUILDING"));
					address.setAccountNumber9(rs.getString("ACCOUNTNUMBER9"));
					addresses.add(address);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return addresses;
	}
	
	public SearchCustomerAccountsResponse searchCustomerAccount(SearchCustomerAccountsRequest request) throws Exception {
		//CommonsDataSource dataSource = getAssignedDataSource(request.getRequestHeader().getLogEntry());
		List<CustomerAccount> customerAccountList = new ArrayList<>();
		request.setReturnNameFlag(true);
		try (Connection connection = xhastageSql.getConnection()) {
			CallableStatement callableStatement = connection.prepareCall("{call CRM.WS_SEARCH_CUSTOMERACCOUNT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			callableStatement.setString(1, request.getSiteId());
			callableStatement.setString(2, request.getAccountNumber9());
			callableStatement.setString(3, request.getAccountNumbers());
			callableStatement.setString(4, request.getAccountNumber9() == null ? request.getFirstName() : null);
			callableStatement.setString(5, request.getAccountNumber9() == null ? request.getLastName() : null);
			callableStatement.setString(6, request.getAccountNumber9() == null ? request.getPhone() : null);
			callableStatement.setString(7, request.getAccountNumber9() == null ? request.getEmail() : null);
			callableStatement.setString(8, request.getMax() != null ? request.getMax() : null);
			callableStatement.setString(9, request.getReturnNameFlag() ? "y" : "n");
			callableStatement.setString(10, request.getReturnAddressFlag() ? "y" : "n");
			callableStatement.setString(11, request.getReturnBillingAddressFlag() ? "y" : "n");
			callableStatement.setString(12, request.getReturnEmailFlag() ? "y" : "n");
			callableStatement.setString(13, request.getReturnPhoneFlag() ? "y" : "n");
			callableStatement.setString(14, request.getReturnSecurityFlag() ? "y" : "n");
			callableStatement.setString(15, request.getReturnCPNIQuestionFlag() ? "y" : "n");
			callableStatement.setString(16, request.getReturnCPNIAnswerFlag() ? "y" : "n");
			callableStatement.setString(17, request.getReturnServiceFlag() ? "y" : "n");
			callableStatement.setString(18, request.getReturnActiveAccountsFlag() ? "y" : "n");
			callableStatement.setString(19, request.getReturnFormerAccountsFlag() ? "y" : "n");
			callableStatement.setString(20, request.getReturnNeverAccountsFlag() ? "y" : "n");
			callableStatement.setString(21, request.getDeepSearchFlag() ? "y" : "n");
			callableStatement.registerOutParameter(22, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(23, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(24, OracleTypes.CURSOR);
			callableStatement.executeUpdate();
			if (callableStatement.getObject(24) != null) {
				ResultSet rs = (ResultSet) callableStatement.getObject(24);
				while (rs.next()) {
					CustomerAccount customerAccount = new CustomerAccount();
					customerAccount.setSiteId(rs.getString("SITE_ID"));
					customerAccount.setAccountNumber9(rs.getString("ACCOUNT_NUMBER"));
					customerAccount.setHouseNumber(rs.getString("HOUSE_NUMBER"));
					customerAccount.setHouseResidentNumber(rs.getString("HOUSE_RESIDENT_NUMBER"));
					customerAccount.setCompanyNumber(rs.getString("COMPANY_NUMBER"));
					customerAccount.setDivisionNumber(rs.getString("DIVISION_NUMBER"));
					customerAccount.setFranchiseNumber(rs.getString("FRANCHISE_NUMBER"));
					customerAccount.setCustomerType(rs.getString("CUSTOMER_TYPE_CODE"));
					customerAccount.setCustomerTypeDescription(rs.getString("CUSTOMER_TYPE_DESCRIPTION"));
					customerAccount.setCustomerStatusCode(rs.getString("CUSTOMER_STATUS_CODE"));
					customerAccount.setCustomerStatusCodeDescription(rs.getString("CUSTOMER_STATUS_DESC"));
					customerAccount.setCustomerStatusDate(rs.getString("STATUS_DATE"));
					customerAccount.setCustomerCategory(rs.getString("CUSTOMER_CATEGORY"));
					customerAccount.setCustomerCategoryDescription(rs.getString("CUSTOMER_CATEGORY_DESC"));
					customerAccount.setCustomerComment(rs.getString("CUSTOMER_COMMENT"));
					customerAccount.setVipCode(rs.getString("VIP_CODE"));
					customerAccount.setTransferredFromAccountNumber9(rs.getString("OLD_TRAN_ACCOUNT_NUMBER"));
					customerAccount.setTransferredFromSiteId(rs.getString("OLD_TRAN_SITE_ID"));
					if (request.getReturnNameFlag()) {
						Name name = new Name();
						name.setCustomerNameFormat(rs.getString("CUSTOMER_NAME_FORMAT"));
						name.setCustomerName(rs.getString("CUSTOMER_NAME"));
						name.setFirstName(rs.getString("FIRST_NAME"));
						name.setMiddleInitial(rs.getString("MIDDLE_INITIAL"));
						name.setLastName(rs.getString("LAST_NAME"));
						name.setTitleOfLineage(rs.getString("TITLE_OF_LINEAGE"));
						name.setCustomerBusinessName(rs.getString("CUSTOMER_BUSINESS_NAME"));
						customerAccount.setName(name);
					}
					if (request.getReturnAddressFlag()) {
						com.cox.bis.customer.account.model.Address address = new com.cox.bis.customer.account.model.Address();
						address.setAddressLine1(rs.getString("ADDRESS_LINE_1"));
						address.setAddressLine2(rs.getString("ADDRESS_LINE_2"));
						address.setCity(rs.getString("ADDR_CITY"));
						address.setState(rs.getString("ADDR_STATE"));
						address.setZip5(rs.getString("ADDR_ZIP_5"));
						address.setZip4(rs.getString("ADDR_ZIP_4"));
						address.setLatitude(rs.getString("LATITUDE"));
						address.setLongitude(rs.getString("LONGITUDE"));
						customerAccount.setAddress(address);
					}
					if (request.getReturnBillingAddressFlag()) {
						BillingAddress billingAddress = new BillingAddress();
						billingAddress.setBillingAddressLine1(rs.getString("BILLING_ADDRESS_LINE_1"));
						billingAddress.setBillingAddressLine2(rs.getString("BILLING_ADDRESS_LINE_2"));
						billingAddress.setBillingCity(rs.getString("BILLING_ADDR_CITY"));
						billingAddress.setBillingState(rs.getString("BILLING_ADDR_STATE"));
						billingAddress.setBillingZip5(rs.getString("BILLING_ADDR_ZIP_5"));
						billingAddress.setBillingZip4(rs.getString("BILLING_ADDR_ZIP_4"));
						billingAddress.setBillingLatitude(rs.getString("BILLING_LATITUDE"));
						billingAddress.setBillingLongitude(rs.getString("BILLING_LONGITUDE"));
						customerAccount.setBillingAddress(billingAddress);
					}
					if (request.getReturnEmailFlag()) {
						Email email = new Email();
						email.setEmail(rs.getString("EMAIL_ADDRESS"));
						email.setEmailType(rs.getString("EMAIL_TYPE"));
						if (request.getAccountNumber9() != null && request.getAccountNumbers() == null) {
							email.setEmailAlternate1(rs.getString("EMAIL_ADDRESS_1"));
							email.setEmailAlternate2(rs.getString("EMAIL_ADDRESS_2"));
							email.setEmailAlternate3(rs.getString("EMAIL_ADDRESS_3"));
							email.setEmailAlternate4(rs.getString("EMAIL_ADDRESS_4"));
							email.setEmailAlternate5(rs.getString("EMAIL_ADDRESS_5"));
						}
						customerAccount.setEmail(email);
					}
					if (request.getReturnPhoneFlag()) {
						Phone phone = new Phone();
						// phone.setAreaCodeHome(rs.getString("HOME_AREA_CODE"));
						if (rs.getString("HOME_PHONE") != null) phone.setTelephoneHome((rs.getString("HOME_PHONE").length() == 10) ? rs.getString("HOME_PHONE") : null);
						// phone.setAreaCodeBusiness(rs.getString("BUSINESS_AREA_CODE"));
						if (rs.getString("BUSINESS_PHONE") != null) phone.setTelephoneBusiness((rs.getString("BUSINESS_PHONE").length() == 10) ? rs.getString("BUSINESS_PHONE") : null);
						// phone.setAreaCodeOther(rs.getString("OTHER_AREA_CODE"));
						if (rs.getString("OTHER_PHONE2") != null) phone.setTelephoneOther((rs.getString("OTHER_PHONE2").length() == 10) ? rs.getString("OTHER_PHONE2") : null);
						// phone.setTelephoneDirectory(rs.getString("DIR_PHONE_NUMBER") == null ? null : rs.getString("DIR_PHONE_NUMBER"));
						customerAccount.setPhone(phone);
					}
					if (request.getReturnSecurityFlag()) {
						Security security = new Security();
						security.setSocialSecurityNumber(rs.getString("SOCIAL_SECURITY_NBR"));
						security.setPrivacyCode(rs.getString("PRIVACY_CODE"));
						customerAccount.setSecurity(security);
					}
					if (request.getReturnCPNIQuestionFlag()) {
						CpniQuestions cpniQuestions = new CpniQuestions();
						cpniQuestions.setPinAvailableFlag((rs.getString("ALLOW_PIN") == null ? "false" : rs.getString("ALLOW_PIN")).toUpperCase().equals("Y") ? "true" : "false");
						cpniQuestions.setDriversLicenseNumberAvailableFlag((rs.getString("ALLOW_DL_NBR") == null ? "false" : rs.getString("ALLOW_DL_NBR")).toUpperCase().equals("Y") ? "true" : "false");
						cpniQuestions.setSsn4AvailableFlag((rs.getString("ALLOW_SSN4") == null ? "false" : rs.getString("ALLOW_SSN4")).toUpperCase().equals("Y") ? "true" : "false");
						cpniQuestions.setSecretQuestionFlag((rs.getString("ALLOW_SECRET_ANSWER") == null ? "false" : rs.getString("ALLOW_SECRET_ANSWER")).toUpperCase().equals("Y") ? "true" : "false");
						cpniQuestions.setSecretQuestion(rs.getString("SECRET_QUESTION"));
						customerAccount.setCpniQuestions(cpniQuestions);
					}
					if (request.getReturnCPNIAnswerFlag()) {
						CpniAnswers cpniAnswers = new CpniAnswers();
						cpniAnswers.setDriversLicenseNumber(rs.getString("DRIVERS_LICENSE_NBR"));
						cpniAnswers.setSsn4(rs.getString("SSN4"));
						cpniAnswers.setPin(rs.getString("PIN"));
						cpniAnswers.setSecretAnswer(rs.getString("SECRET_ANSWER"));
						customerAccount.setCpniAnswers(cpniAnswers);
					}
					if (request.getReturnServiceFlag()) {
						Service service = new Service();
						service.setConnectDate(rs.getString("CONNECT_DATE"));
						service.setInstallDate(rs.getString("INSTALL_DATE"));
						service.setExternalCreditScore(rs.getString("EXTERNAL_CREDIT_SCORE"));
						service.setBillMonthlyAmount(rs.getString("MONTHLY_AMOUNT"));
						service.setBillMonthlyRate(rs.getString("MONTHLY_RATE_BILLED"));
						service.setTaxExemptCode(rs.getString("TAX_EXEMPT_CODE"));
						service.setVideoRatingCode(rs.getString("VIDEO_RATING_CODE"));
						customerAccount.setService(service);
					}
					customerAccountList.add(customerAccount);
				}
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return new SearchCustomerAccountsResponse(customerAccountList);
	}
	
	@Override
	public GetCustomerAccountResponse getCustomerAccount(GetCustomerAccountRequest request) throws Exception {
			SearchCustomerAccountsRequest searchRequest = new SearchCustomerAccountsRequest();
			searchRequest.setSiteId(request.getSiteId());
			searchRequest.setAccountNumber9(request.getAccountNumber9());
			searchRequest.setReturnNameFlag(request.getReturnNameFlag());
			searchRequest.setReturnAddressFlag(request.getReturnAddressFlag());
			searchRequest.setReturnBillingAddressFlag(request.getReturnBillingAddressFlag());
			searchRequest.setReturnEmailFlag(request.getReturnEmailFlag());
			searchRequest.setReturnPhoneFlag(request.getReturnPhoneFlag());
			searchRequest.setReturnSecurityFlag(request.getReturnSecurityFlag());
			searchRequest.setReturnCPNIQuestionFlag(request.getReturnCPNIQuestionFlag());
			searchRequest.setReturnCPNIAnswerFlag(request.getReturnCPNIAnswerFlag());
			searchRequest.setReturnServiceFlag(request.getReturnServiceFlag());
			List<CustomerAccount> customerAccountList = ((SearchCustomerAccountsResponse) searchCustomerAccount(searchRequest)).getCustomerAccounts();
			if (customerAccountList.isEmpty()) return new GetCustomerAccountResponse();
			return new GetCustomerAccountResponse((CustomerAccount) customerAccountList.get(0));
		
		}
}