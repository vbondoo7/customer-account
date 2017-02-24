/**
 * 
 */
package com.cox.bis.customer.account.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jahill
 *
 */
public class AccountsSearchRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4332508214903302368L;
	private String siteId;
	private String accountNumber;
	private String accountNumbers;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String unit;
	private String city;
	private String state;
	private String zip5;
	private String deepSearch;
	
	public static void main(String[] args) throws JsonProcessingException {
		AccountsSearchRequest accountsSearchRequest = new AccountsSearchRequest();
		accountsSearchRequest.setSiteId("609");
		accountsSearchRequest.setAccountNumber("003613604");
		accountsSearchRequest.setFirstName("Jeffrey");
		accountsSearchRequest.setLastName("Smith");
		accountsSearchRequest.setCity("ROCKY RIVER");
		accountsSearchRequest.setZip5("44116");
		accountsSearchRequest.setState("OH");
		accountsSearchRequest.setAddressLine1("3289 FAIRHILL DR");
		accountsSearchRequest.setAddressLine2("ROCKY RIVER, OH 44116-4211");
		
		ObjectMapper mapper = new ObjectMapper();

		//Object to JSON in String
		String jsonInString = mapper.writeValueAsString(accountsSearchRequest);
		System.out.println(jsonInString);
	}

	public AccountsSearchRequest() {
	}

	/*public AccountsSearchRequest(CommonsContext context) {
		super(context);
		setSiteId(context.getAccount().getSiteId());
		setAccountNumber(context.getAccount().getAccountNumberIn());
	}*/

	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountNumbers
	 */
	public String getAccountNumbers() {
		return accountNumbers;
	}

	/**
	 * @param accountNumbers
	 *            the accountNumbers to set
	 */
	public void setAccountNumbers(String accountNumbers) {
		this.accountNumbers = accountNumbers;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1
	 *            the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2
	 *            the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip5
	 */
	public String getZip5() {
		return zip5;
	}

	/**
	 * @param zip5
	 *            the zip5 to set
	 */
	public void setZip5(String zip5) {
		this.zip5 = zip5;
	}

	/**
	 * @return the deepSearch
	 */
	public String getDeepSearch() {
		return deepSearch;
	}

	/**
	 * @param deepSearch
	 *            the deepSearch to set
	 */
	public void setDeepSearch(String deepSearch) {
		this.deepSearch = deepSearch;
	}
}
