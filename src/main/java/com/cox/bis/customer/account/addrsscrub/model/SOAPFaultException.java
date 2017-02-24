package com.cox.bis.customer.account.addrsscrub.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Fault",namespace="http://schemas.xmlsoap.org/soap/envelope/")
public class SOAPFaultException {
	@XmlElement(name="faultcode")
	String faultCode;
	
	@XmlElement(name="faultstring")
	String faultString;
	
	public String getFaultCode() {
		return faultCode;
	}
	public String getFaultString() {
		return faultString;
	}

}