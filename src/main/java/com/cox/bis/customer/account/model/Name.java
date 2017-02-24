package com.cox.bis.customer.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author jahill
 *
 */
@JsonInclude(Include.NON_NULL)
public class Name {
	
    //Name
	private String title;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String customerName;
	private String customerNameFormat;
	private String titleOfLineage;
	private String customerBusinessName;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleInitial
	 */
	public String getMiddleInitial() {
		return middleInitial;
	}
	/**
	 * @param middleInitial the middleInitial to set
	 */
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerNameFormat
	 */
	public String getCustomerNameFormat() {
		return customerNameFormat;
	}
	/**
	 * @param customerNameFormat the customerNameFormat to set
	 */
	public void setCustomerNameFormat(String customerNameFormat) {
		this.customerNameFormat = customerNameFormat;
	}
	/**
	 * @return the titleOfLineage
	 */
	public String getTitleOfLineage() {
		return titleOfLineage;
	}
	/**
	 * @param titleOfLineage the titleOfLineage to set
	 */
	public void setTitleOfLineage(String titleOfLineage) {
		this.titleOfLineage = titleOfLineage;
	}
	/**
	 * @return the customerBusinessName
	 */
	public String getCustomerBusinessName() {
		return customerBusinessName;
	}
	/**
	 * @param customerBusinessName the customerBusinessName to set
	 */
	public void setCustomerBusinessName(String customerBusinessName) {
		this.customerBusinessName = customerBusinessName;
	}

}