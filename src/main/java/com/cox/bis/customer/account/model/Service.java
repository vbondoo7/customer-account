package com.cox.bis.customer.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author jahill
 *
 */
@JsonInclude(Include.NON_NULL)
public class Service {

	//Service
	private String connectDate;
	private String installDate;
	private String externalCreditScore;
	private String billMonthlyAmount;
	private String billMonthlyRate;
	private String taxExemptCode;
	private String videoRatingCode;
	/**
	 * @return the connectDate
	 */
	public String getConnectDate() {
		return connectDate;
	}
	/**
	 * @param connectDate the connectDate to set
	 */
	public void setConnectDate(String connectDate) {
		this.connectDate = connectDate;
	}
	/**
	 * @return the installDate
	 */
	public String getInstallDate() {
		return installDate;
	}
	/**
	 * @param installDate the installDate to set
	 */
	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}
	/**
	 * @return the externalCreditScore
	 */
	public String getExternalCreditScore() {
		return externalCreditScore;
	}
	/**
	 * @param externalCreditScore the externalCreditScore to set
	 */
	public void setExternalCreditScore(String externalCreditScore) {
		this.externalCreditScore = externalCreditScore;
	}
	/**
	 * @return the billMonthlyAmount
	 */
	public String getBillMonthlyAmount() {
		return billMonthlyAmount;
	}
	/**
	 * @param billMonthlyAmount the billMonthlyAmount to set
	 */
	public void setBillMonthlyAmount(String billMonthlyAmount) {
		this.billMonthlyAmount = billMonthlyAmount;
	}
	/**
	 * @return the billMonthlyRate
	 */
	public String getBillMonthlyRate() {
		return billMonthlyRate;
	}
	/**
	 * @param billMonthlyRate the billMonthlyRate to set
	 */
	public void setBillMonthlyRate(String billMonthlyRate) {
		this.billMonthlyRate = billMonthlyRate;
	}
	/**
	 * @return the taxExemptCode
	 */
	public String getTaxExemptCode() {
		return taxExemptCode;
	}
	/**
	 * @param taxExemptCode the taxExemptCode to set
	 */
	public void setTaxExemptCode(String taxExemptCode) {
		this.taxExemptCode = taxExemptCode;
	}
	/**
	 * @return the videoRatingCode
	 */
	public String getVideoRatingCode() {
		return videoRatingCode;
	}
	/**
	 * @param videoRatingCode the videoRatingCode to set
	 */
	public void setVideoRatingCode(String videoRatingCode) {
		this.videoRatingCode = videoRatingCode;
	}

}