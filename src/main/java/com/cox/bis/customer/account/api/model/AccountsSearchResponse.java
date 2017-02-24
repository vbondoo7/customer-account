/**
 * 
 */
package com.cox.bis.customer.account.api.model;

import java.io.Serializable;
import java.util.List;

import com.cox.bis.customer.account.model.CustomerAccount;

/**
 * @author jahill
 *
 */
public class AccountsSearchResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1987236399181943206L;

	private List<CustomerAccount> customerAccounts;
	
	public AccountsSearchResponse () {

	}

	/*public AccountsSearchResponse (AccountsSearchContext context) {
		super(context);
		this.customerAccounts = context.getCustomerAccounts();
	}
	
	public AccountsSearchResponse (AccountsSearchContext context, String code, String message) {
		super(context, new ResponseHeader(context, code, message));
		setCustomerAccounts(context.getCustomerAccounts());
	}
	
	public AccountsSearchResponse (AccountsSearchContext context, ResponseHeader responseHeader) {
		super(context, responseHeader);
		setCustomerAccounts(context.getCustomerAccounts());
	}*/
	
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