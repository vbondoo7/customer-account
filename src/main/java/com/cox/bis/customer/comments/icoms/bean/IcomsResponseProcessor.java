/**
 * 
 */
package com.cox.bis.customer.comments.icoms.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.commons.lang.StringUtils;

import com.cox.bis.customer.comments.exception.BusinessException;
import com.cox.bis.customer.comments.exception.SystemException;
import com.cox.bis.customer.comments.icoms.response.IcomsResponse;
import com.cox.bis.customer.comments.icoms.response.IcomsResponse.MAC00141.INL01000;
import com.cox.bis.customer.comments.icoms.response.IcomsResponse.MAC00141.INL01001;
import com.cox.bis.customer.comments.icoms.response.IcomsResponse.MAC00141.INL01002;
import com.cox.bis.customer.comments.model.CustomerComment;
import com.cox.bis.customer.comments.model.Message;
import com.cox.bis.customer.comments.util.LocalConstants;

/***
 * ResponseProcessor - Parses response from ICOMS bundle
 * 
 * @author jahill
 *
 */
public class IcomsResponseProcessor implements LocalConstants {

	/***
	 * Add Customer CommentsProcessor (Multiple) - response processor
	 * MAC00141 - Work with Customer CommentsProcessor 
	 * INL01000 - Add Customer Comment
	 * 
	 * @param properties
	 *            Exchange Properties
	 * @param icomsResponse
	 * @throws Exception
	 */
	public void createComments(Exchange exchange, IcomsApiResponse icomsApiResponse) throws Exception {
		if (!icomsApiResponse.getResponseHeader().isSuccess()) throw new Exception();//throw new SystemException(icomsApiResponse.getResponseHeader().getCode(), icomsApiResponse.getResponseHeader().getMessage(), icomsApiResponse.getResponseHeader().getDetail());
		com.cox.bis.customer.comments.icoms.response.IcomsResponse icomsResponse = icomsApiResponse.getIcomsResponse();
		try {
			if (icomsResponse != null) {
				if (icomsResponse.getERROR() != null) {
					throw new BusinessException(icomsResponse.getERROR().getMSGNO() + " :: " + icomsResponse.getERROR().getMSGTEXT());
				} else {
					if (icomsResponse.getMAC00141() != null && icomsResponse.getMAC00141().getERROR() != null) {
						throw new BusinessException(icomsResponse.getMAC00141().getERROR().getMSGNO() + " :: " + icomsResponse.getMAC00141().getERROR().getMSGTEXT());
					} else {
						List<CustomerComment> customerComments = new ArrayList<CustomerComment>();
						for (INL01000 addCommentsInline : icomsResponse.getMAC00141().getINL01000()) {
							CustomerComment customerComment = new CustomerComment();
							if (addCommentsInline.getINLNMESGTEXT().contains("IGI0125:IGI0004")) throw new BusinessException("CUSTOMER_COMMENTS_CREATE_FAILURE" + " -- " + "BusinessException wrapping(ICOMS_API_FAILURE): " + customerComment.getCommentId() + ":" + addCommentsInline.getINLNRTRNCODE() + " :: " + addCommentsInline.getINLNMESGTEXT());
							customerComment.setCommentLineText(addCommentsInline.getCMNTLINE().toString());
							customerComment.setCommentId(addCommentsInline.getCMNTENTRDDATE().toString() + StringUtils.leftPad(addCommentsInline.getCMNTSQNCNMBR().toString(),3,'0'));
							customerComment.setSequenceNumber(StringUtils.leftPad(addCommentsInline.getCMNTSQNCNMBR().toString(),3,'0'));
							customerComment.setEntryDate(addCommentsInline.getCMNTENTRDDATE().toString());
							customerComment.setExpirationDate(addCommentsInline.getCMNTEXPRTNDATE().toString());
							customerComments.add(customerComment);
						}
						exchange.getOut().setBody(customerComments);
						// Mark step as success
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateComments(Exchange exchange, IcomsApiResponse icomsApiResponse) throws Exception {
		int successCount = 0;
		int failCount = 0;
		if (!icomsApiResponse.getResponseHeader().isSuccess()){
			throw new SystemException(icomsApiResponse.getResponseHeader().getCode() + " -- " + icomsApiResponse.getResponseHeader().getMessage() + " -- " + icomsApiResponse.getResponseHeader().getDetail());
		}
		IcomsResponse icomsResponse = icomsApiResponse.getIcomsResponse();
		try {
			if (icomsResponse != null) {
				if (icomsResponse.getERROR() != null) {
					throw new BusinessException(icomsResponse.getERROR().getMSGNO() + " :: " + icomsResponse.getERROR().getMSGTEXT());
				} else {
					if (icomsResponse.getMAC00141() != null && icomsResponse.getMAC00141().getERROR() != null) {
						throw new BusinessException(icomsResponse.getMAC00141().getERROR().getMSGNO() + " :: " + icomsResponse.getMAC00141().getERROR().getMSGTEXT());
					} else {
						List<CustomerComment> customerComments = new ArrayList<CustomerComment>();
						for (INL01001 updateCommentsInline : icomsResponse.getMAC00141().getINL01001()) {
							CustomerComment customerComment = new CustomerComment();
							if (updateCommentsInline.getINLNMESGTEXT().contains("IGI0125:IGI0004")){
								failCount++;
								customerComment.setSuccess("false");
								customerComment.getMessages().add(new Message("ICOMS_API_FAILURE","INLNRTRNCODE=" + updateCommentsInline.getINLNRTRNCODE() + "; INLNMSGTEXT=" + updateCommentsInline.getINLNMESGTEXT()));
							}
							else{
								successCount++;
								customerComment.setSuccess("true");
							}
							customerComment.setCommentLineText(updateCommentsInline.getCMNTLINE().toString());
							customerComment.setCommentId(updateCommentsInline.getCMNTENTRDDATE().toString()+ StringUtils.leftPad(updateCommentsInline.getCMNTSQNCNMBR().toString(),3,'0'));
							customerComment.setSequenceNumber(StringUtils.leftPad(updateCommentsInline.getCMNTSQNCNMBR().toString(),3,'0'));
							customerComment.setEntryDate(updateCommentsInline.getCMNTENTRDDATE().toString());
							customerComment.setExpirationDate(updateCommentsInline.getCMNTEXPRTNDATE().toString());
							customerComments.add(customerComment);
						}
						exchange.getOut().setBody(customerComments);
						// Mark step as success
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteComments(Exchange exchange, IcomsApiResponse icomsApiResponse) throws Exception {
		int successCount = 0;
		int failCount = 0;
		if (!icomsApiResponse.getResponseHeader().isSuccess()) throw new SystemException(icomsApiResponse.getResponseHeader().getCode() + " -- " + icomsApiResponse.getResponseHeader().getMessage() + " -- " + icomsApiResponse.getResponseHeader().getDetail());
		IcomsResponse icomsResponse = icomsApiResponse.getIcomsResponse();
		try {
			if (icomsResponse != null) {
				if (icomsResponse.getERROR() != null) {
					throw new BusinessException(icomsResponse.getERROR().getMSGNO() + " :: " + icomsResponse.getERROR().getMSGTEXT());
				} else {
					if (icomsResponse.getMAC00141() != null && icomsResponse.getMAC00141().getERROR() != null) {
						throw new BusinessException(icomsResponse.getMAC00141().getERROR().getMSGNO() + " :: " + icomsResponse.getMAC00141().getERROR().getMSGTEXT());
					} else {
						List<CustomerComment> customerComments = new ArrayList<CustomerComment>();
						for (INL01002 deleteCommentsInline : icomsResponse.getMAC00141().getINL01002()) {
							CustomerComment customerComment = new CustomerComment();
							if (deleteCommentsInline.getINLNMESGTEXT().contains("IGI0125:IGI0004")){
								failCount++;
								customerComment.setSuccess("false");
								customerComment.getMessages().add(new Message("ICOMS_API_FAILURE","INLNRTRNCODE=" + deleteCommentsInline.getINLNRTRNCODE() + "; INLNMSGTEXT=" + deleteCommentsInline.getINLNMESGTEXT()));
							}
							else{
								successCount++;
								customerComment.setSuccess("true");
							}
							customerComment.setCommentId(deleteCommentsInline.getCMNTENTRDDATE().toString()+StringUtils.leftPad(deleteCommentsInline.getCMNTSQNCNMBR().toString(),3,'0'));
							customerComment.setSequenceNumber(StringUtils.leftPad(deleteCommentsInline.getCMNTSQNCNMBR().toString(),3,'0'));
							customerComment.setEntryDate(deleteCommentsInline.getCMNTENTRDDATE().toString());
							customerComments.add(customerComment);
						}
						exchange.getOut().setBody(customerComments);
						// Mark step as success
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}