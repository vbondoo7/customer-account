/**
 * 
 */
package com.cox.bis.customer.comments.icoms.bean;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cox.bis.customer.comments.icoms.response.IcomsResponse;
import com.cox.bis.customer.comments.util.LocalConstants;

@Component("icomsWrapperProcessor")
public class IcomsWrapperProcessor implements LocalConstants{
	
	@Autowired
	IcomsRequestProcessor icomsRequestProcessor;

	//public CommentsCreateContext createComments(Exchange exchange) throws Exception {
	public void createComments(Exchange exchange) throws Exception {
		IcomsApiRequest icomsApiRequest = icomsRequestProcessor.createComments(exchange);
		exchange.setProperty(REQUEST_OBJECT_KEY, icomsApiRequest);
		exchange.setPattern(ExchangePattern.InOut);
		exchange.getIn().setBody(icomsApiRequest.getIcomsRequest());
		ProducerTemplate template = exchange.getContext().createProducerTemplate();
		template.send("direct:apiGateway", exchange);
		IcomsResponse response = exchange.getOut().getBody(IcomsResponse.class);
		new IcomsResponseProcessor().createComments(exchange, new IcomsApiResponse(response));
	}
	
	//public CommentsUpdateContext updateComments(CommentsUpdateContext context) throws BusinessException, Exception {
	public void updateComments(Exchange exchange) throws Exception {
		IcomsApiRequest icomsApiRequest = icomsRequestProcessor.updateComments(exchange);
		exchange.setProperty(REQUEST_OBJECT_KEY, icomsApiRequest);
		exchange.setPattern(ExchangePattern.InOut);
		exchange.getIn().setBody(icomsApiRequest.getIcomsRequest());
		ProducerTemplate template = exchange.getContext().createProducerTemplate();
		template.send("direct:apiGateway", exchange);
		IcomsResponse response = exchange.getOut().getBody(IcomsResponse.class);
		new IcomsResponseProcessor().updateComments(exchange, new IcomsApiResponse(response));
	}
	
	//public CommentsDeleteContext deleteComments(CommentsDeleteContext context) throws BusinessException, Exception {
	public void deleteComments(Exchange exchange) throws Exception {
		IcomsApiRequest icomsApiRequest = icomsRequestProcessor.deleteComments(exchange);
		exchange.setProperty(REQUEST_OBJECT_KEY, icomsApiRequest);
		exchange.setPattern(ExchangePattern.InOut);
		exchange.getIn().setBody(icomsApiRequest.getIcomsRequest());
		ProducerTemplate template = exchange.getContext().createProducerTemplate();
		template.send("direct:apiGateway", exchange);
		IcomsResponse response = exchange.getOut().getBody(IcomsResponse.class);
		new IcomsResponseProcessor().deleteComments(exchange, new IcomsApiResponse(response));
	}
}