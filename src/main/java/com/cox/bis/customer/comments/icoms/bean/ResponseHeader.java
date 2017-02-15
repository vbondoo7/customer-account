package com.cox.bis.customer.comments.icoms.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jahill
 *
 */
public class ResponseHeader {

	/***
	 * Operation status flag (Success/Failure)
	 * NOTE: This flag denotes success of the operation and not ICOMS response. 
	 * If icoms-api is successfull in communicating with ICOMS, this flag should be marked as success.
	 * ICOMS response is NOT evaluated to populate this flag as success of failure.
	 */
	private String success;
	private String serviceName;
	private String operationName;
	private String transactionId;
	private String sessionId;
	private String duration;
	private List<ResponseMessage> messages;

	public ResponseHeader () {
		setSuccess(true);
	}

	public ResponseHeader (boolean success) {
		setSuccess(success);
	}

	public ResponseHeader (boolean success, String code, String message) {
		setSuccess(success);
		setCode(code);
		setMessage(message);
	}

	public ResponseHeader (boolean success, String code, String message, String detail) {
		setSuccess(success);
		setCode(code);
		setMessage(message);
		setDetail(detail);
	}
	
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		if (this.success == null || this.success.isEmpty()) this.success = "false";
		return new Boolean(success).booleanValue();
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = new Boolean(success).toString();
	}

	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the operationName
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * @param operationName the operationName to set
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		
		return (getMessages().isEmpty()) ? null : getMessages().get(getMessages().size()-1).getCode();
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		if (!getMessages().isEmpty()) getMessages().get(getMessages().size()-1).setCode(code);
		else getMessages().add(new ResponseMessage(code, null, null));
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return (getMessages().isEmpty()) ? null : getMessages().get(getMessages().size()-1).getMessage();
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		if (!getMessages().isEmpty()) getMessages().get(getMessages().size()-1).setMessage(message);
		else getMessages().add(new ResponseMessage(null, message, null));
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return (getMessages().isEmpty()) ? null : getMessages().get(getMessages().size()-1).getDetail();
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		if (!getMessages().isEmpty()) getMessages().get(getMessages().size()-1).setDetail(detail);
		else getMessages().add(new ResponseMessage(null, null, detail));
	}

	/**
	 * @return the messages
	 */
	public List<ResponseMessage> getMessages() {
		if (this.messages == null) this.messages = new ArrayList<ResponseMessage>();
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<ResponseMessage> messages) {
		this.messages = messages;
	}
}