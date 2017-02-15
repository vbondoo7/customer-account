/**
 * 
 */
package com.cox.bis.customer.comments.api.model;

import java.io.Serializable;
import java.util.List;

import org.apache.camel.Exchange;

import com.cox.bis.customer.comments.model.CustomerComment;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * @author Jason Hill
 *
 */
public class CommentsCreateResponse{

	/**
	 * 
	 */
	private List<CustomerComment> customerComments;

	public CommentsCreateResponse() {

	}

	/**
	 * @return the customerComments
	 */
	public List<CustomerComment> getCustomerComments() {
		return customerComments;
	}

	/**
	 * @param customerComments the customerComments to set
	 */
	public void setCustomerComments(List<CustomerComment> customerComments) {
		this.customerComments = customerComments;
	}
}