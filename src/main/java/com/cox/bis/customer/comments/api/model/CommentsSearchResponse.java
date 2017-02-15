package com.cox.bis.customer.comments.api.model;

import io.swagger.annotations.ResponseHeader;

import java.util.List;

import org.apache.camel.Exchange;

import com.cox.bis.customer.comments.model.CustomerComment;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class CommentsSearchResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7981124347136945658L;

	@JsonUnwrapped
	private List<CustomerComment> customerComments;

	public CommentsSearchResponse() {

	}

	public CommentsSearchResponse(Exchange exchange) {
		setCustomerComments(((CommentsSearchResponse) exchange).getCustomerComments());
	}

	public CommentsSearchResponse(Exchange exchange, ResponseHeader responseHeader) {
		setCustomerComments(((CommentsSearchResponse) exchange).getCustomerComments());
	}

	/**
	 * @return the customerComments
	 */
	public List<CustomerComment> getCustomerComments() {
		return customerComments;
	}
	
	/**
	 * @param customerComments
	 *            the customerComments to set
	 */
	public void setCustomerComments(List<CustomerComment> customerComments) {
		this.customerComments = customerComments;
	}
}
