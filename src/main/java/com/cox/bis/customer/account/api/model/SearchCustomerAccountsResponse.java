package com.cox.bis.customer.account.api.model;

import java.util.List;

import com.cox.bis.customer.account.model.CustomerAccount;

/**
 * @author Jason Hill
 *
 * 
 */
public class SearchCustomerAccountsResponse{
	
	private List<CustomerAccount> customerAccounts;
	
	public SearchCustomerAccountsResponse() {
	}

	public SearchCustomerAccountsResponse(List<CustomerAccount> customerAccounts) {
		setCustomerAccounts(customerAccounts);
	}

	/**
	 * @return the customerAccounts
	 */
	public List<CustomerAccount> getCustomerAccounts() {
		return customerAccounts;
	}

	/**
	 * @param customerAccounts the customerAccounts to set
	 */
	public void setCustomerAccounts(List<CustomerAccount> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}

}