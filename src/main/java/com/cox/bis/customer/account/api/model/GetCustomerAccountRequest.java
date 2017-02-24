package com.cox.bis.customer.account.api.model;

public class GetCustomerAccountRequest {
	private String siteId;
	private String accountNumber9;
	private boolean returnNameFlag;
	private boolean returnAddressFlag;
	private boolean returnBillingAddressFlag;
	private boolean returnEmailFlag;
	private boolean returnPhoneFlag;
	private boolean returnSecurityFlag;
	private boolean returnCPNIQuestionFlag;
	private boolean returnCPNIAnswerFlag;
	private boolean returnServiceFlag;
	private boolean returnActiveAccountsFlag;
	private boolean returnFormerAccountsFlag;
	private boolean returnNeverAccountsFlag;
	private boolean deepSearchFlag;

	public GetCustomerAccountRequest () {
		super();
	}


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
		this.siteId = siteId;
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
		this.accountNumber9 = accountNumber9;
	}

	/**
	 * @return the returnNameFlag
	 */
	public boolean getReturnNameFlag() {
		return returnNameFlag;
	}

	/**
	 * @param returnNameFlag the returnNameFlag to set
	 */
	public void setReturnNameFlag(boolean returnNameFlag) {
		this.returnNameFlag = returnNameFlag;
	}

	/**
	 * @return the returnAddressFlag
	 */
	public boolean getReturnAddressFlag() {
		return returnAddressFlag;
	}

	/**
	 * @param returnAddressFlag the returnAddressFlag to set
	 */
	public void setReturnAddressFlag(boolean returnAddressFlag) {
		this.returnAddressFlag = returnAddressFlag;
	}

	/**
	 * @return the returnBillingAddressFlag
	 */
	public boolean getReturnBillingAddressFlag() {
		return returnBillingAddressFlag;
	}

	/**
	 * @param returnBillingAddressFlag the returnBillingAddressFlag to set
	 */
	public void setReturnBillingAddressFlag(boolean returnBillingAddressFlag) {
		this.returnBillingAddressFlag = returnBillingAddressFlag;
	}

	/**
	 * @return the returnEmailFlag
	 */
	public boolean getReturnEmailFlag() {
		return returnEmailFlag;
	}

	/**
	 * @param returnEmailFlag the returnEmailFlag to set
	 */
	public void setReturnEmailFlag(boolean returnEmailFlag) {
		this.returnEmailFlag = returnEmailFlag;
	}

	/**
	 * @return the returnPhoneFlag
	 */
	public boolean getReturnPhoneFlag() {
		return returnPhoneFlag;
	}

	/**
	 * @param returnPhoneFlag the returnPhoneFlag to set
	 */
	public void setReturnPhoneFlag(boolean returnPhoneFlag) {
		this.returnPhoneFlag = returnPhoneFlag;
	}

	/**
	 * @return the returnSecurityFlag
	 */
	public boolean getReturnSecurityFlag() {
		return returnSecurityFlag;
	}

	/**
	 * @param returnSecurityFlag the returnSecurityFlag to set
	 */
	public void setReturnSecurityFlag(boolean returnSecurityFlag) {
		this.returnSecurityFlag = returnSecurityFlag;
	}

	/**
	 * @return the returnCPNIQuestionFlag
	 */
	public boolean getReturnCPNIQuestionFlag() {
		return returnCPNIQuestionFlag;
	}

	/**
	 * @param returnCPNIQuestionFlag the returnCPNIQuestionFlag to set
	 */
	public void setReturnCPNIQuestionFlag(boolean returnCPNIQuestionFlag) {
		this.returnCPNIQuestionFlag = returnCPNIQuestionFlag;
	}

	/**
	 * @return the returnCPNIAnswerFlag
	 */
	public boolean getReturnCPNIAnswerFlag() {
		return returnCPNIAnswerFlag;
	}

	/**
	 * @param returnCPNIAnswerFlag the returnCPNIAnswerFlag to set
	 */
	public void setReturnCPNIAnswerFlag(boolean returnCPNIAnswerFlag) {
		this.returnCPNIAnswerFlag = returnCPNIAnswerFlag;
	}

	/**
	 * @return the returnServiceFlag
	 */
	public boolean getReturnServiceFlag() {
		return returnServiceFlag;
	}

	/**
	 * @param returnServiceFlag the returnServiceFlag to set
	 */
	public void setReturnServiceFlag(boolean returnServiceFlag) {
		this.returnServiceFlag = returnServiceFlag;
	}

	/**
	 * @return the returnActiveAccountsFlag
	 */
	public boolean getReturnActiveAccountsFlag() {
		return returnActiveAccountsFlag;
	}

	/**
	 * @param returnActiveAccountsFlag the returnActiveAccountsFlag to set
	 */
	public void setReturnActiveAccountsFlag(boolean returnActiveAccountsFlag) {
		this.returnActiveAccountsFlag = returnActiveAccountsFlag;
	}

	/**
	 * @return the returnFormerAccountsFlag
	 */
	public boolean getReturnFormerAccountsFlag() {
		return returnFormerAccountsFlag;
	}

	/**
	 * @param returnFormerAccountsFlag the returnFormerAccountsFlag to set
	 */
	public void setReturnFormerAccountsFlag(boolean returnFormerAccountsFlag) {
		this.returnFormerAccountsFlag = returnFormerAccountsFlag;
	}

	/**
	 * @return the returnNeverAccountsFlag
	 */
	public boolean getReturnNeverAccountsFlag() {
		return returnNeverAccountsFlag;
	}

	/**
	 * @param returnNeverAccountsFlag the returnNeverAccountsFlag to set
	 */
	public void setReturnNeverAccountsFlag(boolean returnNeverAccountsFlag) {
		this.returnNeverAccountsFlag = returnNeverAccountsFlag;
	}

	/**
	 * @return the deepSearchFlag
	 */
	public boolean getDeepSearchFlag() {
		return deepSearchFlag;
	}

	/**
	 * @param deepSearchFlag the deepSearchFlag to set
	 */
	public void setDeepSearchFlag(boolean deepSearchFlag) {
		this.deepSearchFlag = deepSearchFlag;
	}
}
