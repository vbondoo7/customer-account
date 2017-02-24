/**
 * 
 */
package com.cox.bis.customer.account.api.model;

import java.io.Serializable;


 


/**
 * @author jahill
 *
 */
public class AccountsGetRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7411353610119572233L;
	private String siteId;
	private String accountNumber;
	private String directives;

	public AccountsGetRequest () {
		
	}
	
	

	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}
	
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	/**
	 * @return the directives
	 */
	public String getDirectives() {
		return directives;
	}

	/**
	 * @param directives the directives to set
	 */
	public void setDirectives(String directives) {
		this.directives = directives;
	}
	
}
