/**
 * 
 */
package com.cox.bis.customer.comments.route;

/**
 * @author mkrishna
 *
 */
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.api.model.CommentsCreateRequest;
import com.cox.bis.customer.comments.api.model.CommentsCreateResponse;
import com.cox.bis.customer.comments.api.model.CommentsDeleteRequest;
import com.cox.bis.customer.comments.api.model.CommentsDeleteResponse;
import com.cox.bis.customer.comments.api.model.CommentsSearchRequest;
import com.cox.bis.customer.comments.api.model.CommentsUpdateRequest;
import com.cox.bis.customer.comments.api.model.CommentsUpdateResponse;
import com.cox.bis.customer.comments.util.LocalConstants;


@SpringBootApplication
@ComponentScan("com.cox.bis")
public class CustomerCommentsRB extends SpringBootServletInitializer implements LocalConstants {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCommentsRB.class, args);
	}

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

			//getContext().setTracing(true);

			restConfiguration()
			.contextPath("/customer/account/v1").apiContextPath("/api-doc")
			.apiProperty("api.title", "Camel REST API")
			.apiProperty("api.version", "1.0")
			.apiProperty("cors", "true")
			.apiContextRouteId("doc-api")
			.bindingMode(RestBindingMode.json);

			rest("/comments/search").description("Comments Search REST service")
			.post("/").type(CommentsSearchRequest.class)
			.route().routeId("comments-search-api")
			.to("direct:commentsSearch-route")
			.endRest();

			rest("/comments/create").description("Comments create REST service")
			.post("/").type(CommentsCreateRequest.class).description("Creating a user comment")
			.route().routeId("comments-create-api")
			.to("direct:commentsCreate-route");

			rest("/comments/update").description("Comments update REST service")
			.post("/").type(CommentsUpdateRequest.class).description("Updating a user comment")
			.route().routeId("comments-update-api")
			.to("direct:commentsUpdate-route");

			rest("/comments/delete").description("Comments delete REST service")
			.post("/").type(CommentsDeleteRequest.class).description("Deleting a user comment")
			.route().routeId("comments-delete-api")
			.to("direct:commentsDelete-route");

			//Resource: CommentsProcessor
			// Operation: commentsSearch
			from("direct:commentsSearch-route")
			.routeId("commentsSearch-route").description("commentsSearch-route")
			.to("bean:commentsProcessor?method=search");

			//Resource: Preferences
			// Operation: preferencesSearch
			from("direct:commentsCreate-route")
			.routeId("commentsCreate-route").description("commentsCreate-route")
			.to("bean:icomsWrapperProcessor?method=createComments")
			.to("bean:commentsProcessor?method=create").marshal().json(CommentsCreateResponse.class, CommentsCreateResponse.class);

			// Operation: commentsUpdate
			from("direct:commentsUpdate-route")
			.routeId("commentsUpdate-route").description("commentsUpdate-route")
			.to("bean:icomsWrapperProcessor?method=updateComments")
			.to("bean:commentsProcessor?method=update").marshal().json(CommentsUpdateResponse.class, CommentsUpdateResponse.class);

			// Operation: commentsDelete
			from("direct:commentsDelete-route")
			.routeId("commentsDelete-route").description("commentsDelete-route")
			.to("bean:icomsWrapperProcessor?method=deleteComments")
			.to("bean:commentsProcessor?method=delete").marshal().json(CommentsDeleteResponse.class, CommentsDeleteResponse.class);

			from("direct:apiGateway")
			.routeId("icoms-api-gateway")
			.marshal()
			.jaxb("com.cox.bis.customer.comments.icoms.request")
			.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					interceptGatewayMessage(exchange);
				}
			})
			.to("https4://connmgrwebservices.qa.cox.com:5040?httpClient.socketTimeout=40000&bridgeEndpoint=true&throwExceptionOnFailure=false")
			.process(new Processor() {			
				@Override
				public void process(Exchange exchange) throws Exception {
					interceptGatewayMessage(exchange);
				}
			})
			.unmarshal()
			.jaxb("com.cox.bis.customer.comments.icoms.response");
		}
	}
}