package com.cox.bis.customer.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author jahill
 *
 */
@JsonInclude(Include.NON_NULL)
public class CpniAnswers {

	//CPNI Answers
	private String driversLicenseNumber;
	private String pin;
	private String ssn4;
	private String secretAnswer;
	
	/**
	 * @return the driversLicenseNumber
	 */
	public String getDriversLicenseNumber() {
		return driversLicenseNumber;
	}
	/**
	 * @param driversLicenseNumber the driversLicenseNumber to set
	 */
	public void setDriversLicenseNumber(String driversLicenseNumber) {
		this.driversLicenseNumber = driversLicenseNumber;
	}
	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	/**
	 * @return the ssn4
	 */
	public String getSsn4() {
		return ssn4;
	}
	/**
	 * @param ssn4 the ssn4 to set
	 */
	public void setSsn4(String ssn4) {
		this.ssn4 = ssn4;
	}
	/**
	 * @return the secretAnswer
	 */
	public String getSecretAnswer() {
		return secretAnswer;
	}
	/**
	 * @param secretAnswer the secretAnswer to set
	 */
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

}