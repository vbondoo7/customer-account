package com.cox.bis.customer.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author jahill
 *
 */
@JsonInclude(Include.NON_NULL)
public class Security {

	//Security  
	private String socialSecurityNumber;
	private String privacyCode;
	/**
	 * @return the socialSecurityNumber
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	/**
	 * @param socialSecurityNumber the socialSecurityNumber to set
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	/**
	 * @return the privacyCode
	 */
	public String getPrivacyCode() {
		return privacyCode;
	}
	/**
	 * @param privacyCode the privacyCode to set
	 */
	public void setPrivacyCode(String privacyCode) {
		this.privacyCode = privacyCode;
	}

}