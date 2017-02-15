/**
 * 
 */
package com.cox.bis.customer.comments.api.model;

import java.io.Serializable;
import java.util.List;

import com.cox.bis.customer.comments.model.CustomerComment;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * @author Jason Hill
 *
 */
public class CommentsDeleteResponse {

	/**
	 * 
	 */
	private List<CustomerComment> customerComments;

	public CommentsDeleteResponse() {

	}

	/*public CommentsDeleteResponse(CommentsDeleteContext context) {
		super(context);
		boolean hasSomeFailed = false;
		for(CustomerComment comment : context.getCustomerComments()){
			if("false".equals(comment.getSuccess())){
				hasSomeFailed = true;
				break;
			}
		}
		if(hasSomeFailed){
			this.getResponseHeader().setSuccess(false);
		}
		setCustomerComments(context.getCustomerComments());
	}*/

	/*public CommentsDeleteResponse(CommentsDeleteContext context, ResponseHeader responseHeader) {
		super(context, responseHeader);
		setCustomerComments(context.getCustomerComments());
	}*/

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