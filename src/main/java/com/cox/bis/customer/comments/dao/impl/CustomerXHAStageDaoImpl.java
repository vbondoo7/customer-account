package com.cox.bis.customer.comments.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.api.model.SearchCustomerCommentsRequest;
import com.cox.bis.customer.comments.api.model.SearchCustomerCommentsResponse;
import com.cox.bis.customer.comments.dao.CustomerXHAStageDao;
import com.cox.bis.customer.comments.datasource.DataSources;
import com.cox.bis.customer.comments.model.CustomerComment;

@Component
public class CustomerXHAStageDaoImpl implements CustomerXHAStageDao{
	@Autowired
	private DataSources dataSource;
	public SearchCustomerCommentsResponse searchCustomerComment(Exchange exchange) throws Exception {
		List<CustomerComment> customerCommentList=new ArrayList<CustomerComment>();
		try (Connection connection = dataSource.getXhastage().primaryDataSource().getConnection()) {
			CallableStatement callableStatement = connection.prepareCall("{call CRM.WS_SEARCH_CUSTOMERCOMMENTS(?,?,?,?,?,?,?,?,?)}");
			callableStatement.setString(1, exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getSiteId());
			callableStatement.setString(2,exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getAccountNumber());
			callableStatement.setString(3, exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getMax() != null ? exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getMax() : null);
			callableStatement.setString(4, exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getStartDate() != null ? exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getStartDate() : null);
			callableStatement.setString(5, exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getEndDate() != null ? exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getEndDate() : null);
			callableStatement.setString(6, exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getSort() != null ? exchange.getIn().getBody(SearchCustomerCommentsRequest.class).getSort() : null);
			callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(9, OracleTypes.CURSOR);
			callableStatement.executeUpdate();

			if (callableStatement.getObject(9) != null) {
				ResultSet rs = (ResultSet) callableStatement.getObject(9);
				while (rs.next()) {
					CustomerComment xhastageCustomerComment = new CustomerComment();
					xhastageCustomerComment.setSequenceNumber((rs.getString("SEQUENCE_NUMBER")));
					xhastageCustomerComment.setCommentLineText((rs.getString("COMMENT_TEXT")));
					xhastageCustomerComment.setUserId((rs.getString("USER_ID")));
					xhastageCustomerComment.setEntryDate((rs.getString("COMMENT_ENTER_DATE")));
					xhastageCustomerComment.setExpirationDate((rs.getString("COMMENT_EXPIRATION_DATE")));
					xhastageCustomerComment.setCommentId((rs.getString("COMMENT_ID")));
					customerCommentList.add(xhastageCustomerComment);
				}
			}
		} catch (Exception e) {
			return new SearchCustomerCommentsResponse(e);
		}
		return new SearchCustomerCommentsResponse(customerCommentList);
	}
}