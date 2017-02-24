/**
 * 
 */
package com.cox.bis.customer.account.api.model;

import java.io.Serializable;

import org.apache.camel.Exchange;

import com.cox.bis.customer.account.model.CustomerAccount;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * @author jahill
 *
 */

public class AccountsGetResponse  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6071209416041467530L;

	@JsonUnwrapped
	private CustomerAccount customerAccount;
	
	public AccountsGetResponse () {

	}

	public AccountsGetResponse (Exchange exchange) {
		setCustomerAccount(((AccountsGetResponse) exchange).getCustomerAccount());
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