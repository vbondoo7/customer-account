package com.cox.bis.customer.comments.icoms.bean;

import com.cox.bis.customer.comments.icoms.response.IcomsResponse;

public class IcomsApiResponse {
	
	/***
	 * Icoms Response Header object
	 */
	private ResponseHeader responseHeader;

	/***
	 * Icoms Response object (Response or Error from ICOMS)
	 */
	private IcomsResponse icomsResponse;
	
	public IcomsApiResponse(IcomsResponse icomsResponse) {
		setResponseHeader(new ResponseHeader(true));
		setIcomsResponse(icomsResponse);
	}

	/**
	 * @return the icomsResponse
	 */
	public IcomsResponse getIcomsResponse() {
		return icomsResponse;
	}

	/**
	 * @param icomsResponse the icomsResponse to set
	 */
	public void setIcomsResponse(IcomsResponse icomsResponse) {
		this.icomsResponse = icomsResponse;
	}
	
	/**
	 * @return the responseHeader
	 */
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	/**
	 * @param responseHeader the responseHeader to set
	 */
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}
	
}