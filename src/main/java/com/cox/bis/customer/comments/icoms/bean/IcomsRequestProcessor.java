package com.cox.bis.customer.comments.icoms.bean;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.api.model.CommentsCreateRequest;
import com.cox.bis.customer.comments.api.model.CommentsDeleteRequest;
import com.cox.bis.customer.comments.api.model.CommentsUpdateRequest;
import com.cox.bis.customer.comments.datasource.DataSources;
import com.cox.bis.customer.comments.exception.BusinessException;
import com.cox.bis.customer.comments.icoms.request.IcomsRequest;
import com.cox.bis.customer.comments.icoms.request.IcomsRequest.MAC00141;
import com.cox.bis.customer.comments.icoms.request.IcomsRequest.MAC00141.INL01000;
import com.cox.bis.customer.comments.icoms.request.IcomsRequest.MAC00141.INL01001;
import com.cox.bis.customer.comments.icoms.request.IcomsRequest.MAC00141.INL01002;
import com.cox.bis.customer.comments.model.CustomerComment;
import com.cox.bis.customer.comments.util.LocalConstants.L_ErrorCodes;
import com.cox.bis.customer.comments.util.LocalConstants.L_Errors;
import com.cox.bis.customer.comments.util.SimpleCrypto;
import com.cox.bis.customer.comments.util.Util;

/***
 * RequestProcessor : Generates requests for ICOMS bundle
 * @author jahill
 *
 */
@Component
public class IcomsRequestProcessor{
	
	@Autowired
    private Environment env;
	
	@Autowired
	private DataSources dataSource;
	
	private Credential icomsCredential(String clientId){
		Credential credential = new Credential();
		try (Connection con = dataSource.getIcoms().primaryDataSource().getConnection()) {
			String preparedStatement = "{? = call spGetIcomsCredentialByClientId(?,?,?)}"; 

			int parameter1 = Types.INTEGER;
			int parameter3 = Types.VARCHAR;
			int parameter4 = Types.VARCHAR;
			try (CallableStatement stmt = con.prepareCall(preparedStatement)) {
				stmt.registerOutParameter(1, parameter1);
				stmt.setString(2, clientId);
				stmt.registerOutParameter(3, parameter3);
				stmt.registerOutParameter(4, parameter4);
				stmt.executeUpdate();
				credential.setUsername(stmt.getString(3));
				credential.setPassword(stmt.getString(4));
				credential.setDecryptedPassword(SimpleCrypto.decrypt(stmt.getString(4)));
				credential.setIsValidated(stmt.getInt(1)==0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return credential;
	}

	/***
	 * Create Customer CommentsProcessor (Multiple) - request generator
	 * MAC00141 - Work with Customer CommentsProcessor 
	 * INL01000 - Add Customer Comment
	 * @param properties Exchange Properties
	 * @return ICOMSRequest Generated ICOMS Request
	 * @throws Exception
	 */
	public IcomsApiRequest createComments(Exchange exchange) throws Exception{
		List<CustomerComment> customerComments = new ArrayList<CustomerComment>();
		CommentsCreateRequest commentsCreateRequest = (CommentsCreateRequest) exchange.getIn().getBody();
		if (Util.isNotNullEmpty(commentsCreateRequest.getCustomerCommentsText())) {
			if (commentsCreateRequest.getCustomerCommentsText().length() > 4600) 
				throw new BusinessException(L_ErrorCodes.CUSTOMER_COMMENTS_CREATE_FAILED + " -- " + L_Errors.CUSTOMER_COMMENTS_CREATE_FAILED + ": CustomerCommentsBlock length is greater than maximum 4600 character limit!: "+ commentsCreateRequest.getCustomerCommentsText().length());
			for (String splitTextItem : Util.splitText(commentsCreateRequest.getCustomerCommentsText(), 40)) 
				customerComments.add(new CustomerComment(splitTextItem));
		} else {
			customerComments = commentsCreateRequest.getCustomerComments();
		}
		IcomsRequest icomsRequest = new IcomsRequest();
		MAC00141 createCommentsMacro = new MAC00141();
		createCommentsMacro.setSITEID(new BigInteger(commentsCreateRequest.getSiteId()));
		createCommentsMacro.setACNTNMBR(new BigInteger(commentsCreateRequest.getAccountNumber()));
		INL01000 createCommentsInline = null;
		for (CustomerComment customerComment : customerComments) {
			if (customerComment.getCommentLineText().length() > 40) throw new BusinessException(L_ErrorCodes.CUSTOMER_COMMENTS_CREATE_FAILED + " -- " + L_Errors.CUSTOMER_COMMENTS_CREATE_FAILED + "Comment length is greater than maximum " + 40 + " character limit!: "+ customerComment.getCommentLineText().length());
			createCommentsInline = new INL01000();
			createCommentsInline.setCMNTLINE(customerComment.getCommentLineText());
			createCommentsMacro.getINL01000().add(createCommentsInline);
		}
		Credential credential = icomsCredential("test");
		icomsRequest.setMAC00141(createCommentsMacro);
		icomsRequest.setUSERID(credential.getUsername());
		icomsRequest.setPASSWORD(credential.getDecryptedPassword());
		icomsRequest.setENVIRONMENT(env.getProperty(commentsCreateRequest.getSiteId()));
		return new IcomsApiRequest(icomsRequest);
	}
	
	public IcomsApiRequest updateComments(Exchange exchange) throws Exception{
		CommentsUpdateRequest commentsUpdateRequest = (CommentsUpdateRequest) exchange.getIn().getBody();
		List<CustomerComment> customerComments = commentsUpdateRequest.getCustomerComments();
		IcomsRequest icomsRequest = new IcomsRequest();
		MAC00141 updateCommentsMacro = new MAC00141();
		updateCommentsMacro.setSITEID(new BigInteger(commentsUpdateRequest.getSiteId()));
		updateCommentsMacro.setACNTNMBR(new BigInteger(commentsUpdateRequest.getAccountNumber()));
		INL01001 updateCommentsInline = null;
		for (CustomerComment customerComment : customerComments) {
			updateCommentsInline = new INL01001();
			if (Util.isNotNullEmpty(customerComment.getCommentId())) {
				updateCommentsInline.setCMNTENTRDDATE(new BigInteger(customerComment.getCommentId().substring(0, customerComment.getCommentId().length() - 3)));
				updateCommentsInline.setCMNTSQNCNMBR(new BigInteger(customerComment.getCommentId().substring(customerComment.getCommentId().length() - 3, customerComment.getCommentId().length())));;
			} else if (Util.isNotNullEmpty(customerComment.getSequenceNumber()) && Util.isNotNullEmpty(customerComment.getEntryDate())) {
				updateCommentsInline.setCMNTENTRDDATE(new BigInteger(customerComment.getEntryDate()));
				updateCommentsInline.setCMNTSQNCNMBR(new BigInteger(customerComment.getSequenceNumber().toString()));;
			} else  {
				throw new BusinessException(L_ErrorCodes.CUSTOMER_COMMENTS_UPDATE_FAILED + " -- " + L_Errors.CUSTOMER_COMMENTS_UPDATE_FAILED + "Missing commentId or entryDate/sequence.");
			}
			if (customerComment.getCommentLineText().length() > 40) throw new BusinessException(L_ErrorCodes.CUSTOMER_COMMENTS_UPDATE_FAILED + " -- " + L_Errors.CUSTOMER_COMMENTS_UPDATE_FAILED + "Comment length is greater than maximum " + 40 + " character limit!: "+ customerComment.getCommentLineText().length());
			updateCommentsInline.setCMNTLINE(customerComment.getCommentLineText());
			updateCommentsMacro.getINL01001().add(updateCommentsInline);
		}
		Credential credential = icomsCredential("test");
		icomsRequest.setMAC00141(updateCommentsMacro);
		icomsRequest.setUSERID(credential.getUsername());
		icomsRequest.setPASSWORD(credential.getDecryptedPassword());
		icomsRequest.setENVIRONMENT(env.getProperty(commentsUpdateRequest.getSiteId()));
		return new IcomsApiRequest(icomsRequest);
	}
	
	public IcomsApiRequest deleteComments(Exchange exchange) throws Exception{
		CommentsDeleteRequest commentsDeleteRequest = (CommentsDeleteRequest) exchange.getIn().getBody();
		List<CustomerComment> customerComments = commentsDeleteRequest.getCustomerComments();
		IcomsRequest icomsRequest = new IcomsRequest();
		MAC00141 deleteCommentsMacro = new MAC00141();
		deleteCommentsMacro.setSITEID(new BigInteger(commentsDeleteRequest.getSiteId()));
		deleteCommentsMacro.setACNTNMBR(new BigInteger(commentsDeleteRequest.getAccountNumber()));
		INL01002 deleteCommentsInline = null;
		for (CustomerComment customerComment : customerComments) {
			deleteCommentsInline = new INL01002();
			if (Util.isNotNullEmpty(customerComment.getSequenceNumber()) && Util.isNotNullEmpty(customerComment.getEntryDate())) {
				deleteCommentsInline.setCMNTENTRDDATE(new BigInteger(customerComment.getEntryDate()));
				deleteCommentsInline.setCMNTSQNCNMBR(new BigInteger(customerComment.getSequenceNumber()));;
			} else if (Util.isNotNullEmpty(customerComment.getCommentId())) {
				deleteCommentsInline.setCMNTENTRDDATE(new BigInteger(customerComment.getCommentId().substring(0, customerComment.getCommentId().length() - 3)));
				deleteCommentsInline.setCMNTSQNCNMBR(new BigInteger(customerComment.getCommentId().substring(customerComment.getCommentId().length() - 3, customerComment.getCommentId().length())));;
			} else  {
				throw new BusinessException(L_ErrorCodes.CUSTOMER_COMMENTS_DELETE_FAILED + " -- " + L_Errors.CUSTOMER_COMMENTS_DELETE_FAILED + "Missing commentId or entryDate/sequence.");
			}
			deleteCommentsMacro.getINL01002().add(deleteCommentsInline);
		}
		icomsRequest.setMAC00141(deleteCommentsMacro);
		Credential credential = icomsCredential("test");
		icomsRequest.setUSERID(credential.getUsername());
		icomsRequest.setPASSWORD(credential.getDecryptedPassword());
		icomsRequest.setENVIRONMENT(env.getProperty(commentsDeleteRequest.getSiteId()));
		return new IcomsApiRequest(icomsRequest);
	}
}