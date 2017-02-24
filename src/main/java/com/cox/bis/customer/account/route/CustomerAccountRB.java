/**
 * 
 */
package com.cox.bis.customer.account.route;

/**
 * @author mkrishna
 *
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.account.addrsscrub.model.SingleAddressTransactionalOut;
import com.cox.bis.customer.account.api.model.AccountsGetRequest;
import com.cox.bis.customer.account.api.model.AccountsSearchRequest;
import com.cox.bis.customer.account.util.LocalConstants;


@SpringBootApplication
@ComponentScan("com.cox.bis")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class CustomerAccountRB extends SpringBootServletInitializer implements LocalConstants {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountRB.class, args);
	}

	private void interceptMessage(Exchange exchange) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n *** Gateway Message *** \n");
		Integer httpResponseCode = (Integer)exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE);
		if(httpResponseCode != null) {
			sb.append("Http Response Code: " + httpResponseCode + "\n");
		}
		String contentLength = (String)exchange.getIn().getHeader(Exchange.CONTENT_LENGTH);
		if(StringUtils.isNotEmpty(contentLength)) {
			sb.append("Content Length: " + contentLength + "\n");
		}
		String contentType = (String)exchange.getIn().getHeader(Exchange.CONTENT_TYPE);
		if(StringUtils.isNotEmpty(contentType)) {
			sb.append("Content Type: " + contentType + "\n");
		}
		String breadcrumbId = (String)exchange.getIn().getHeader(Exchange.BREADCRUMB_ID);
		if(StringUtils.isNotEmpty(breadcrumbId)) {
			sb.append("Breadcrumb Id: " + breadcrumbId + "\n");
		}
		Object obj = exchange.getIn().getBody();
		if(obj instanceof byte[]) {
			String message = new String((byte[]) obj);
			sb.append("Message: \n");
			sb.append(message);
			exchange.getIn().setBody(message, String.class);
		}
		if( obj instanceof InputStream) {
			InputStream is = (InputStream) obj;

			try {	
				StringWriter writer = new StringWriter();
				IOUtils.copy(is, writer);
				sb.append("Message: \n");
				sb.append(writer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	private void interceptGatewayMessage(Exchange exchange) {
		StringBuilder message = null;
		try{
			message = new StringBuilder(ICOMS_GATEWAY_MESSAGE_HEADER);
			// Logging Http Response Code from ICOMS Gateway
			message.append(HTTP_RESPONSE_CODE).append(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE)).append(LINE_BREAK);
			// Logging Content Length of response message
			message.append(CONTENT_LENGTH).append(exchange.getIn().getHeader(Exchange.CONTENT_LENGTH)).append(LINE_BREAK);
			// Logging Content Type of response message
			message.append(CONTENT_TYPE).append(exchange.getIn().getHeader(Exchange.CONTENT_TYPE)).append(LINE_BREAK);
			// Logging Breadcrumb Id of response message
			message.append(BREADCRUMB_ID).append(exchange.getIn().getHeader(Exchange.BREADCRUMB_ID)).append(LINE_BREAK);
			// Getting the response body from exchange
			Object responseBody = exchange.getIn().getBody();
			// Check to see if response body is byte array. This is generally when we have an Object
			if(responseBody instanceof byte[]){
				String responseMessage = new String((byte[]) responseBody);
				message.append(RESPONSE_MESSAGE).append(responseMessage).append(LINE_BREAK);
				exchange.getIn().setBody(responseMessage, String.class);
			}				
			// Check to see if response body is WrappedInputStream class (socket.io)
			if(responseBody.getClass().getSimpleName().equalsIgnoreCase(WRAPPED_INPUT_STREAM_CLASS_NAME)){
				InputStream inputStream = (InputStream)responseBody;
				try{
					StringWriter writer = new StringWriter();
					IOUtils.copy(inputStream, writer);
					message.append(RESPONSE_MESSAGE).append(writer.toString()).append(LINE_BREAK);
				}
				finally{
					inputStream.reset();
				}
			}
		}
		catch(Exception ex){
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
		}
		finally{
			if(message != null){
				// Write the message to log
				message = null;
			}
		}
	}

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(
				new CamelHttpTransportServlet(), "/customer/account/v1/*");
		servlet.setName("CamelServlet");
		return servlet;
	}

	@Component
	class CustomerCommentsRoute extends RouteBuilder {

		@Override
		public void configure() throws Exception {

			JaxbDataFormat jaxbDataFormatMarshall = new JaxbDataFormat("com.cox.bis.customer.account.addrsscrub.model");
			jaxbDataFormatMarshall.setPrettyPrint(true);
			jaxbDataFormatMarshall.setFragment(true);

			JAXBContext jaxbContext = JAXBContext.newInstance(SingleAddressTransactionalOut.class);
			JaxbDataFormat jaxbDataFormatUnmarshall=  new JaxbDataFormat(jaxbContext);
			jaxbDataFormatUnmarshall.setPrettyPrint(false);
			jaxbDataFormatUnmarshall.setFragment(true);
			jaxbDataFormatUnmarshall.setPartClass("com.cox.bis.customer.account.addrsscrub.model.SingleAddressTransactionalOut");

			CamelContext camelContext = getContext();

			CxfEndpoint cxfEndpoint = new CxfEndpoint();
			cxfEndpoint.setAddress("https://dataquality.qa.cox.com/DataServices/servlet/webservices?ver=2.1");
			cxfEndpoint.setWsdlURL("wsdl/AddressScrub.wsdl");
			cxfEndpoint.setEndpointNameString("{http://www.businessobjects.com}Real-time_Services");
			cxfEndpoint.setServiceNameString("{http://www.businessobjects.com}DataServices_Server");
			cxfEndpoint.setCamelContext(camelContext);
			cxfEndpoint.setDataFormat(DataFormat.MESSAGE);
			cxfEndpoint.setDefaultBus(true);

			camelContext.addEndpoint("addressScrubServiceEndpoint", cxfEndpoint);

			restConfiguration()
			.contextPath("/customer/account/v1").apiContextPath("/api-doc")
			.apiProperty("api.title", "Camel REST API")
			.apiProperty("api.version", "1.0")
			.apiProperty("cors", "true")
			.apiContextRouteId("doc-api")
			.bindingMode(RestBindingMode.json);

			rest("/accounts/search").description("Accounts search REST service")
			.post("/").type(AccountsSearchRequest.class).description("account search")
			.route().routeId("accounts-search-api")
			.to("direct:accountsSearch-route");

			rest("/accounts/get").description("Account get REST service")
			.post("/").type(AccountsGetRequest.class).description("get a user account")
			.route().routeId("account-get-api")
			.to("direct:accountsGet-route");

			//Resource: AccountProcessor
			//Operation: accountsGet
			from("direct:accountsGet-route")
			.routeId("accountsGet-route").description("accountsGet-route")
			.to("bean:accountsProcessor?method=get");

			//Resource: AccountsProcessor
			//Operation: accountsSearch
			from("direct:accountsSearch-route")
			.routeId("accountsSearch-route").description("accountsSearch-route")
			.to("bean:accountsProcessor?method=search");

			from("direct:addressScrubServiceEndpoint")
			.routeId("Address-Scrub-Route")
			.marshal(jaxbDataFormatMarshall)
			.to("direct:validateXML")
			.to("bean:addressScrubRequestProcessor?method=prepareSoapRequest")
			.to("addressScrubServiceEndpoint")
			.convertBodyTo(org.w3c.dom.Node.class)
			.to("bean:dataServicesUtil?method=transform")
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					interceptMessage(exchange);
				}
			})
			.unmarshal(jaxbDataFormatUnmarshall)
			.end();

			from("direct:validateXML")
			.doTry()
			.to("validator:xsd/SAPDataServicesV2.xsd")
			.endDoTry()	       
			.doCatch(org.apache.camel.ValidationException.class)
			.to("bean:addressScrubRequestProcessor?method=inValidXMLDocument")	
			.end();
		}
	}
}