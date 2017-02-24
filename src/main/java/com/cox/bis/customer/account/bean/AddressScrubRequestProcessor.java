package com.cox.bis.customer.account.bean;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangeException;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.cox.bis.customer.account.exception.FaultCodeException;
import com.cox.bis.customer.account.util.LocalConstants.AddressScrubConstants;

@Component("addressScrubRequestProcessor")
public class AddressScrubRequestProcessor {

	private SOAPMessage createSOAPRequest(Document inputData) throws Exception {
		SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
		SOAPHeader soapHeader = soapEnvelope.getHeader();
		soapHeader.addNamespaceDeclaration(soapEnvelope.getPrefix(), soapEnvelope.getNamespaceURI());
		SOAPBody soapBody = soapEnvelope.getBody();
		soapBody.addDocument(inputData);
		soapMessage.saveChanges();

		return soapMessage;
	}

	private Document toDocument(SOAPMessage soapMsg) throws TransformerConfigurationException, TransformerException,
	SOAPException, IOException {
		Source src = soapMsg.getSOAPPart().getContent();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMResult result = new DOMResult();
		transformer.transform(src, result);
		return (Document) result.getNode();
	}

	public void prepareSoapRequest(Exchange exchange) throws Exception {
		Document inputData = exchange.getIn().getBody(Document.class);
		SOAPMessage soapMessage = createSOAPRequest(inputData);
		Document serviceInput = toDocument(soapMessage);
		exchange.getIn().setBody(serviceInput, Document.class);
		exchange.getIn().setHeader(AddressScrubConstants.SOAPACTION, "service=SingleAddressTransactional");
	}

	public void inValidXMLDocument(@ExchangeException Exception exception,Exchange exchange) throws FaultCodeException {

		String exceptionMsg=exception.getMessage();
		if(exception.getMessage().length()>4000){
			exceptionMsg=exceptionMsg.substring(0, 4000);
		}

		throw new FaultCodeException(AddressScrubConstants.ERROR_MSG_STATUS+AddressScrubConstants.MSG_DELIMETER+exceptionMsg);
	}
}