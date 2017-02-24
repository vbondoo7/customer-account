package com.cox.bis.customer.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author jahill
 *
 */
@JsonInclude(Include.NON_NULL)
public class Email {

	//Email
	private String email;
	private String emailType;
	private String emailAlternate1;
	private String emailAlternate2;
	private String emailAlternate3;
	private String emailAlternate4;
	private String emailAlternate5;
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the emailType
	 */
	public String getEmailType() {
		return emailType;
	}
	/**
	 * @param emailType the emailType to set
	 */
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	/**
	 * @return the emailAlternate1
	 */
	public String getEmailAlternate1() {
		return emailAlternate1;
	}
	/**
	 * @param emailAlternate1 the emailAlternate1 to set
	 */
	public void setEmailAlternate1(String emailAlternate1) {
		this.emailAlternate1 = emailAlternate1;
	}
	/**
	 * @return the emailAlternate2
	 */
	public String getEmailAlternate2() {
		return emailAlternate2;
	}
	/**
	 * @param emailAlternate2 the emailAlternate2 to set
	 */
	public void setEmailAlternate2(String emailAlternate2) {
		this.emailAlternate2 = emailAlternate2;
	}
	/**
	 * @return the emailAlternate3
	 */
	public String getEmailAlternate3() {
		return emailAlternate3;
	}
	/**
	 * @param emailAlternate3 the emailAlternate3 to set
	 */
	public void setEmailAlternate3(String emailAlternate3) {
		this.emailAlternate3 = emailAlternate3;
	}
	/**
	 * @return the emailAlternate4
	 */
	public String getEmailAlternate4() {
		return emailAlternate4;
	}
	/**
	 * @param emailAlternate4 the emailAlternate4 to set
	 */
	public void setEmailAlternate4(String emailAlternate4) {
		this.emailAlternate4 = emailAlternate4;
	}
	/**
	 * @return the emailAlternate5
	 */
	public String getEmailAlternate5() {
		return emailAlternate5;
	}
	/**
	 * @param emailAlternate5 the emailAlternate5 to set
	 */
	public void setEmailAlternate5(String emailAlternate5) {
		this.emailAlternate5 = emailAlternate5;
	}

}