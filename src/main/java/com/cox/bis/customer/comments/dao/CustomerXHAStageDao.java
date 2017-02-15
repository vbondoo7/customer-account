package com.cox.bis.customer.comments.dao;

import org.apache.camel.Exchange;

import com.cox.bis.customer.comments.api.model.SearchCustomerCommentsResponse;

public interface CustomerXHAStageDao {
	public SearchCustomerCommentsResponse searchCustomerComment(Exchange exchange) throws Exception;
}