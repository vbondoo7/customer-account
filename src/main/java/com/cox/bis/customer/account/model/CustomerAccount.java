package com.cox.bis.customer.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CustomerAccount {

	//General Account
	private String siteId;
	private String accountNumber9;
	private String houseNumber;
	private String houseResidentNumber;
	private String companyNumber;
	private String divisionNumber;
	private String franchiseNumber;
	private String customerType;
	private String customerTypeDescription;
	private String customerStatusCode;
	private String customerStatusCodeDescription;
	private String customerStatusDate;
	private String customerCategory;
	private String customerCategoryDescription;
	private String customerComment;
	private String vipCode;
	private String transferredFromAccountNumber9;
	private String transferredFromSiteId;
	private String languageCode;
	private Name name;
	private Phone phone;
	private Email email;
	private Address address;
	private BillingAddress billingAddress;
	private Security security;
	private Service service;
	private CpniQuestions cpniQuestions;
	private CpniAnswers cpniAnswers;
	
	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = String.format("%03d", Integer.parseInt(siteId));
	}
	/**
	 * @return the accountNumber9
	 */
	public String getAccountNumber9() {
		return accountNumber9;
	}
	/**
	 * @param accountNumber9 the accountNumber9 to set
	 */
	public void setAccountNumber9(String accountNumber9) {
		this.accountNumber9 = String.format("%09d", Integer.parseInt(accountNumber9));
	}
	/**
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}
	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = String.format("%07d", Integer.parseInt(houseNumber));
	}
	/**
	 * @return the houseResidentNumber
	 */
	public String getHouseResidentNumber() {
		return houseResidentNumber;
	}
	/**
	 * @param houseResidentNumber the houseResidentNumber to set
	 */
	public void setHouseResidentNumber(String houseResidentNumber) {
		this.houseResidentNumber = String.format("%02d", Integer.parseInt(houseResidentNumber));
	}
	/**
	 * @return the companyNumber
	 */
	public String getCompanyNumber() {
		return companyNumber;
	}
	/**
	 * @param companyNumber the companyNumber to set
	 */
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = String.format("%02d", Integer.parseInt(companyNumber));
	}
	/**
	 * @return the divisionNumber
	 */
	public String getDivisionNumber() {
		return divisionNumber;
	}
	/**
	 * @param divisionNumber the divisionNumber to set
	 */
	public void setDivisionNumber(String divisionNumber) {
		this.divisionNumber = String.format("%02d", Integer.parseInt(divisionNumber));
	}
	/**
	 * @return the franchiseNumber
	 */
	public String getFranchiseNumber() {
		return franchiseNumber;
	}
	/**
	 * @param franchiseNumber the franchiseNumber to set
	 */
	public void setFranchiseNumber(String franchiseNumber) {
		this.franchiseNumber = String.format("%03d", Integer.parseInt(franchiseNumber));
	}
	/**
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}
	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	/**
	 * @return the customerTypeDescription
	 */
	public String getCustomerTypeDescription() {
		return customerTypeDescription;
	}
	/**
	 * @param customerTypeDescription the customerTypeDescription to set
	 */
	public void setCustomerTypeDescription(String customerTypeDescription) {
		this.customerTypeDescription = customerTypeDescription;
	}
	/**
	 * @return the customerStatusCode
	 */
	public String getCustomerStatusCode() {
		return customerStatusCode;
	}
	/**
	 * @param customerStatusCode the customerStatusCode to set
	 */
	public void setCustomerStatusCode(String customerStatusCode) {
		this.customerStatusCode = customerStatusCode;
	}
	/**
	 * @return the customerStatusCodeDescription
	 */
	public String getCustomerStatusCodeDescription() {
		return customerStatusCodeDescription;
	}
	/**
	 * @param customerStatusCodeDescription the customerStatusCodeDescription to set
	 */
	public void setCustomerStatusCodeDescription(String customerStatusCodeDescription) {
		this.customerStatusCodeDescription = customerStatusCodeDescription;
	}
	/**
	 * @return the customerStatusDate
	 */
	public String getCustomerStatusDate() {
		return customerStatusDate;
	}
	/**
	 * @param customerStatusDate the customerStatusDate to set
	 */
	public void setCustomerStatusDate(String customerStatusDate) {
		this.customerStatusDate = customerStatusDate;
	}
	/**
	 * @return the customerCategory
	 */
	public String getCustomerCategory() {
		return customerCategory;
	}
	/**
	 * @param customerCategory the customerCategory to set
	 */
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	/**
	 * @return the customerCategoryDescription
	 */
	public String getCustomerCategoryDescription() {
		return customerCategoryDescription;
	}
	/**
	 * @param customerCategoryDescription the customerCategoryDescription to set
	 */
	public void setCustomerCategoryDescription(String customerCategoryDescription) {
		this.customerCategoryDescription = customerCategoryDescription;
	}
	/**
	 * @return the customerComment
	 */
	public String getCustomerComment() {
		return customerComment;
	}
	/**
	 * @param customerComment the customerComment to set
	 */
	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}
	/**
	 * @return the vipCode
	 */
	public String getVipCode() {
		return vipCode;
	}
	/**
	 * @param vipCode the vipCode to set
	 */
	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}
	/**
	 * @return the transferredFromAccountNumber9
	 */
	public String getTransferredFromAccountNumber9() {
		return transferredFromAccountNumber9;
	}
	/**
	 * @param transferredFromAccountNumber9 the transferredFromAccountNumber9 to set
	 */
	public void setTransferredFromAccountNumber9(String transferredFromAccountNumber9) {
		this.transferredFromAccountNumber9 = transferredFromAccountNumber9;
	}
	/**
	 * @return the transferredFromSiteId
	 */
	public String getTransferredFromSiteId() {
		return transferredFromSiteId;
	}
	/**
	 * @param transferredFromSiteId the transferredFromSiteId to set
	 */
	public void setTransferredFromSiteId(String transferredFromSiteId) {
		this.transferredFromSiteId = transferredFromSiteId;
	}
	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}
	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	/**
	 * @return the phone
	 */
	public Phone getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(Email email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the billingAddress
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	/**
	 * @return the security
	 */
	public Security getSecurity() {
		return security;
	}
	/**
	 * @param security the security to set
	 */
	public void setSecurity(Security security) {
		this.security = security;
	}
	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}
	/**
	 * @return the cpniQuestions
	 */
	public CpniQuestions getCpniQuestions() {
		return cpniQuestions;
	}
	/**
	 * @param cpniQuestions the cpniQuestions to set
	 */
	public void setCpniQuestions(CpniQuestions cpniQuestions) {
		this.cpniQuestions = cpniQuestions;
	}
	/**
	 * @return the cpniAnswers
	 */
	public CpniAnswers getCpniAnswers() {
		return cpniAnswers;
	}
	/**
	 * @param cpniAnswers the cpniAnswers to set
	 */
	public void setCpniAnswers(CpniAnswers cpniAnswers) {
		this.cpniAnswers = cpniAnswers;
	}
	
}