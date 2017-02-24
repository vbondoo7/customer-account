package com.cox.bis.customer.account.api.model;

import com.cox.bis.customer.account.model.CustomerAccount;

public class GetCustomerAccountResponse {
	private CustomerAccount customerAccount;
	
	public GetCustomerAccountResponse () {
	}

	public GetCustomerAccountResponse (Exception exception) {
		super();
	}

	public GetCustomerAccountResponse (CustomerAccount customerAccount) {
		setCustomerAccount(customerAccount);
	}

	/**
	 * @return the customerAccount
	 */
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	/**
	 * @param customerAccount the customerAccount to set
	 */
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

}
