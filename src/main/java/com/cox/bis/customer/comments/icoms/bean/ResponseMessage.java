package com.cox.bis.customer.comments.icoms.bean;

/**
 * @author jahill
 *
 */
public class ResponseMessage {
	
	private String code;
	private String message;
	private String detail;
	
	public ResponseMessage(String code, String message) {
		setCode(code);
		setMessage(message);
	}

	public ResponseMessage(String code, String message, String detail) {
		setCode(code);
		setMessage(message);
		setDetail(detail);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

}