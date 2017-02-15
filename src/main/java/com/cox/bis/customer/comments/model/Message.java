package com.cox.bis.customer.comments.model;

public class Message {
	
	private String code;
	private String message;
	private String detail;
	
	public Message(String code, String message) {
		setCode(code);
		setMessage(message);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}