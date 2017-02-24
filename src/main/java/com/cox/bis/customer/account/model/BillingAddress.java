package com.cox.bis.customer.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author jahill
 *
 */
@JsonInclude(Include.NON_NULL)
public class BillingAddress {

	//BillingAddress
	private String billToAddress;
	private String billingAddressLine1;
	private String billingAddressLine2;
	private String billingAddressLine3;
	private String billingAddressLine4;
	private String billingUnit;
	private String billingCity;
	private String billingState;
	private String billingZip5;
	private String billingZip4;
	private String billingLatitude;
	private String billingLongitude;
	/**
	 * @return the billToAddress
	 */
	public String getBillToAddress() {
		return billToAddress;
	}
	/**
	 * @param billToAddress the billToAddress to set
	 */
	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress;
	}
	/**
	 * @return the billingAddressLine1
	 */
	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}
	/**
	 * @param billingAddressLine1 the billingAddressLine1 to set
	 */
	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}
	/**
	 * @return the billingAddressLine2
	 */
	public String getBillingAddressLine2() {
		return billingAddressLine2;
	}
	/**
	 * @param billingAddressLine2 the billingAddressLine2 to set
	 */
	public void setBillingAddressLine2(String billingAddressLine2) {
		this.billingAddressLine2 = billingAddressLine2;
	}
	/**
	 * @return the billingCity
	 */
	public String getBillingCity() {
		return billingCity;
	}
	/**
	 * @param billingCity the billingCity to set
	 */
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	/**
	 * @return the billingState
	 */
	public String getBillingState() {
		return billingState;
	}
	/**
	 * @param billingState the billingState to set
	 */
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	/**
	 * @return the billingZip5
	 */
	public String getBillingZip5() {
		return billingZip5;
	}
	/**
	 * @param billingZip5 the billingZip5 to set
	 */
	public void setBillingZip5(String billingZip5) {
		this.billingZip5 = billingZip5;
	}
	/**
	 * @return the billingZip4
	 */
	public String getBillingZip4() {
		return billingZip4;
	}
	/**
	 * @param billingZip4 the billingZip4 to set
	 */
	public void setBillingZip4(String billingZip4) {
		this.billingZip4 = billingZip4;
	}
	/**
	 * @return the billingLatitude
	 */
	public String getBillingLatitude() {
		return billingLatitude;
	}
	/**
	 * @param billingLatitude the billingLatitude to set
	 */
	public void setBillingLatitude(String billingLatitude) {
		this.billingLatitude = billingLatitude;
	}
	/**
	 * @return the billingLongitude
	 */
	public String getBillingLongitude() {
		return billingLongitude;
	}
	/**
	 * @param billingLongitude the billingLongitude to set
	 */
	public void setBillingLongitude(String billingLongitude) {
		this.billingLongitude = billingLongitude;
	}
	/**
	 * @return the billingUnit
	 */
	public String getBillingUnit() {
		return billingUnit;
	}
	/**
	 * @param billingUnit the billingUnit to set
	 */
	public void setBillingUnit(String billingUnit) {
		this.billingUnit = billingUnit;
	}
	/**
	 * @return the billingAddressLine3
	 */
	public String getBillingAddressLine3() {
		return billingAddressLine3;
	}
	/**
	 * @param billingAddressLine3 the billingAddressLine3 to set
	 */
	public void setBillingAddressLine3(String billingAddressLine3) {
		this.billingAddressLine3 = billingAddressLine3;
	}
	/**
	 * @return the billingAddressLine4
	 */
	public String getBillingAddressLine4() {
		return billingAddressLine4;
	}
	/**
	 * @param billingAddressLine4 the billingAddressLine4 to set
	 */
	public void setBillingAddressLine4(String billingAddressLine4) {
		this.billingAddressLine4 = billingAddressLine4;
	}

}