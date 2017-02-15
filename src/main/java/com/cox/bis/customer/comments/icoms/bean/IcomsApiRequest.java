package com.cox.bis.customer.comments.icoms.bean;

import com.cox.bis.customer.comments.icoms.request.IcomsRequest;

/***
 * IcomsApiRequest class
 * @author dvasmatk
 *
 */
public class IcomsApiRequest {
	
	/***
	 * Icoms Request Object
	 */
	private IcomsRequest icomsRequest;

	/***
	 * Default Constructor
	 */
	public IcomsApiRequest(){
		
	}
	
	/***
	 * Object initializer
	 * @param icomsRequest
	 * @param logEntry
	 * @param operation
	 */
	public IcomsApiRequest(IcomsRequest icomsRequest, String operationNameOverride){
		this.icomsRequest = icomsRequest;
	}
	
	/***
	 * Object initializer
	 * @param icomsRequest
	 * @param logEntry
	 * @param operation
	 */
	public IcomsApiRequest(IcomsRequest icomsRequest){
		this.icomsRequest = icomsRequest;
	}
	
	/**
	 * @return the icomsRequest
	 */
	public IcomsRequest getIcomsRequest() {
		return icomsRequest;
	}

	/**
	 * @param icomsRequest the icomsRequest to set
	 */
	public void setIcomsRequest(IcomsRequest icomsRequest) {
		this.icomsRequest = icomsRequest;
	}
}