package com.cox.bis.customer.comments.bean;

import java.util.ArrayList;
import java.util.List;


import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.api.model.CommentsCreateResponse;
import com.cox.bis.customer.comments.api.model.CommentsDeleteResponse;
import com.cox.bis.customer.comments.api.model.CommentsSearchRequest;
import com.cox.bis.customer.comments.api.model.CommentsUpdateResponse;
import com.cox.bis.customer.comments.api.model.SearchCustomerCommentsRequest;
import com.cox.bis.customer.comments.api.model.SearchCustomerCommentsResponse;
import com.cox.bis.customer.comments.dao.impl.CustomerXHAStageDaoImpl;
import com.cox.bis.customer.comments.exception.BusinessException;
import com.cox.bis.customer.comments.model.CustomerComment;
import com.cox.bis.customer.comments.util.Configuration;
import com.cox.bis.customer.comments.util.LocalConstants.L_ErrorCodes;
import com.cox.bis.customer.comments.util.LocalConstants.L_Errors;
import com.cox.bis.customer.comments.util.Util;

@Component("commentsProcessor")
public class CommentsProcessor {

	@Autowired
	private CustomerXHAStageDaoImpl customerXHAStageDaoImpl;

	/***
	 * Method: searchComments
	 * Description: search xHastage for CommentsProcessor within parameters
	 * @category method
	 * @author ksaurav
	 * @param exchange
	 * @throws BusinessException
	 * @throws Exception
	 */
	public List<CustomerComment> search(Exchange exchange) throws Exception {

		SearchCustomerCommentsRequest searchCustomerCommentsRequest=new SearchCustomerCommentsRequest();
		Configuration configuration=new Configuration();
		searchCustomerCommentsRequest.setAccountNumber(exchange.getIn().getBody(CommentsSearchRequest.class).getAccountNumber());
		searchCustomerCommentsRequest.setSiteId(exchange.getIn().getBody(CommentsSearchRequest.class).getSiteId());
		searchCustomerCommentsRequest.setSort("desc");
		searchCustomerCommentsRequest.setMax(configuration.getDefaultMax());
		if (Util.isNotNullEmpty(exchange.getIn().getBody(CommentsSearchRequest.class).getStartDate())) searchCustomerCommentsRequest.setStartDate(DateTimeProcessor.toCenturyDate(exchange.getIn().getBody(CommentsSearchRequest.class).getStartDate()));
		if (Util.isNotNullEmpty(exchange.getIn().getBody(CommentsSearchRequest.class).getEndDate())) searchCustomerCommentsRequest.setEndDate(DateTimeProcessor.toCenturyDate(exchange.getIn().getBody(CommentsSearchRequest.class).getEndDate()));
		if (Util.isNotNullEmpty(exchange.getIn().getBody(CommentsSearchRequest.class).getStartDate()) && Util.isNotNullEmpty(exchange.getIn().getBody(CommentsSearchRequest.class).getEndDate())) {
			if (Integer.parseInt(exchange.getIn().getBody(CommentsSearchRequest.class).getStartDate()) > Integer.parseInt(exchange.getIn().getBody(CommentsSearchRequest.class).getEndDate())) throw new BusinessException(L_ErrorCodes.CUSTOMER_COMMENTS_SEARCH_FAILED + " -- " + L_Errors.CUSTOMER_COMMENTS_SEARCH_FAILED + ": startDate cannot be greater than endDate");
		}
		exchange.getIn().setBody(searchCustomerCommentsRequest);
		List<CustomerComment> customerCommentsList = new ArrayList<>();
		SearchCustomerCommentsResponse response = customerXHAStageDaoImpl.searchCustomerComment(exchange);
		for (int i = 0; i < response.getCustomerComments().size(); i++) {		
			CustomerComment customerComment = new CustomerComment();
			customerComment.setCommentId(response.getCustomerComments().get(i).getCommentId());
			if (response.getCustomerComments().get(i).getEntryDate().contains("999") || response.getCustomerComments().get(i).getEntryDate().equals("0")) customerComment.setEntryDate(response.getCustomerComments().get(i).getEntryDate());
			else customerComment.setEntryDate(DateTimeProcessor.fromCenturyDate(response.getCustomerComments().get(i).getEntryDate())); 
			customerComment.setSequenceNumber(response.getCustomerComments().get(i).getSequenceNumber());
			customerComment.setCommentLineText(response.getCustomerComments().get(i).getCommentLineText());
			customerComment.setUserId(response.getCustomerComments().get(i).getUserId());
			if (response.getCustomerComments().get(i).getExpirationDate().contains("999") || response.getCustomerComments().get(i).getExpirationDate().equals("0")) customerComment.setExpirationDate(null);
			else customerComment.setExpirationDate(DateTimeProcessor.fromCenturyDate(response.getCustomerComments().get(i).getExpirationDate())); 
			customerCommentsList.add(customerComment);
		}
		if (customerCommentsList.isEmpty()) {
			return null;
		} else {
			return customerCommentsList;
		}
	}

	@SuppressWarnings("unchecked")
	public CommentsCreateResponse create(Exchange exchange) {
		CommentsCreateResponse commentsCreateResponse = new CommentsCreateResponse();
		commentsCreateResponse.setCustomerComments((List<CustomerComment>)exchange.getIn().getBody());
		return commentsCreateResponse;	
	}

	@SuppressWarnings("unchecked")
	public CommentsUpdateResponse update(Exchange exchange) {
		CommentsUpdateResponse commentsUpdateResponse = new CommentsUpdateResponse();
		commentsUpdateResponse.setCustomerComments((List<CustomerComment>)exchange.getIn().getBody());
		return commentsUpdateResponse;
	}

	@SuppressWarnings("unchecked")
	public CommentsDeleteResponse delete(Exchange exchange) {
		CommentsDeleteResponse commentsDeleteResponse = new CommentsDeleteResponse();
		commentsDeleteResponse.setCustomerComments((List<CustomerComment>)exchange.getIn().getBody());
		return commentsDeleteResponse;
	}
}