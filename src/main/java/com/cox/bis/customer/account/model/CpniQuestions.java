package com.cox.bis.customer.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author jahill
 *
 */
@JsonInclude(Include.NON_NULL)
public class CpniQuestions {

	//CPNI Questions
	private String driversLicenseNumberAvailableFlag;
	private String pinAvailableFlag;
	private String ssn4AvailableFlag;
	private String secretQuestionFlag;
	private String secretQuestion;

	/**
	 * @return the driversLicenseNumberAvailableFlag
	 */
	public String getDriversLicenseNumberAvailableFlag() {
		return driversLicenseNumberAvailableFlag;
	}
	/**
	 * @param driversLicenseNumberAvailableFlag the driversLicenseNumberAvailableFlag to set
	 */
	public void setDriversLicenseNumberAvailableFlag(String driversLicenseNumberAvailableFlag) {
		this.driversLicenseNumberAvailableFlag = driversLicenseNumberAvailableFlag;
	}
	/**
	 * @return the pinAvailableFlag
	 */
	public String getPinAvailableFlag() {
		return pinAvailableFlag;
	}
	/**
	 * @param pinAvailableFlag the pinAvailableFlag to set
	 */
	public void setPinAvailableFlag(String pinAvailableFlag) {
		this.pinAvailableFlag = pinAvailableFlag;
	}
	/**
	 * @return the ssn4AvailableFlag
	 */
	public String getSsn4AvailableFlag() {
		return ssn4AvailableFlag;
	}
	/**
	 * @param ssn4AvailableFlag the ssn4AvailableFlag to set
	 */
	public void setSsn4AvailableFlag(String ssn4AvailableFlag) {
		this.ssn4AvailableFlag = ssn4AvailableFlag;
	}
	/**
	 * @return the secretQuestionFlag
	 */
	public String getSecretQuestionFlag() {
		return secretQuestionFlag;
	}
	/**
	 * @param secretQuestionFlag the secretQuestionFlag to set
	 */
	public void setSecretQuestionFlag(String secretQuestionFlag) {
		this.secretQuestionFlag = secretQuestionFlag;
	}
	/**
	 * @return the secretQuestion
	 */
	public String getSecretQuestion() {
		return secretQuestion;
	}
	/**
	 * @param secretQuestion the secretQuestion to set
	 */
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

}