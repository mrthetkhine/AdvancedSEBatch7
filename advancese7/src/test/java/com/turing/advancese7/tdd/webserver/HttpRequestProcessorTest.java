package com.turing.advancese7.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.advancese7.tdd.webserver.handler.HandlerFactory;
import com.turing.advancese7.tdd.webserver.io.HttpRequest;
import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public class HttpRequestProcessorTest {
	
	@Test
	public void testHandleRequestDefaultRoot()
	{
		HttpRequest request = createHttpGetRequest();
		request.setUrl("/");
		
		HttpRequestProcessor handler =  getHttpRequestProcessor();
		HttpResponse response = handler.handle(request);
		
		String body = response.getBody();
		
		assertEquals("200",response.getStatusCode());
		assertEquals("OK",response.getStatusCodeDescription());
		assertEquals("text/html",response.getHeader("Content-Type"));
		assertTrue(body.contains("Hello"));
	}
	@Test
	public void testHandleRequest()
	{
		HttpRequest request = createHttpGetRequest();
		request.setUrl("/index.html");

		
		HttpRequestProcessor handler =  getHttpRequestProcessor();
		HttpResponse response = handler.handle(request);
		
		String body = response.getBody();
		
		assertEquals("200",response.getStatusCode());
		assertEquals("OK",response.getStatusCodeDescription());
		assertEquals("text/html",response.getHeader("Content-Type"));
		assertTrue(body.contains("Hello"));
	}
	@Test
	public void testHandleCSS()
	{
		HttpRequest request = createHttpGetRequest();
		request.setUrl("/style.css");
		
		
		HttpRequestProcessor handler =  getHttpRequestProcessor();
		HttpResponse response = handler.handle(request);
		
		String body = response.getBody();
		
		assertEquals("200",response.getStatusCode());
		assertEquals("OK",response.getStatusCodeDescription());
		assertEquals("text/css",response.getHeader("Content-Type"));
		assertTrue(body.contains("color:green"));
	}
	
	
	@Test
	public void testHandleNotFound()
	{
		HttpRequest request = createHttpGetRequest();
		request.setUrl("/none.css");
		
		HttpRequestProcessor handler =  getHttpRequestProcessor();
		HttpResponse response = handler.handle(request);
		
		assertEquals("500",response.getStatusCode());
		assertEquals("Internal Server Error",response.getStatusCodeDescription());
		
	}
	private HttpRequest createHttpGetRequest() {
		HttpRequest request = new HttpRequest();
		request.setHttpMethod("GET");
		request.setHttpVersion("HTTP/1.1");
		return request;
	}
	private HttpRequest createHttpPostRequest() {
		HttpRequest request = new HttpRequest();
		request.setHttpMethod("POST");
		request.setHttpVersion("HTTP/1.1");
		return request;
	}
	@Test
	public void testHandlePost()
	{
		HttpRequest request = createHttpPostRequest();
		request.setUrl("/HelloWorld");
		
		HttpRequestProcessor handler =  getHttpRequestProcessor();
		HttpResponse response = handler.handle(request);
		
		String body = response.getBody();
		
		assertEquals("200",response.getStatusCode());
		assertEquals("OK",response.getStatusCodeDescription());
		assertEquals("text/html",response.getHeader("Content-Type"));
		assertTrue(body.contains("Hello World"));
	}
	@Test
	public void testHandlePostAnother()
	{
		HttpRequest request = createHttpPostRequest();
		request.setUrl("/Another");
		
		HttpRequestProcessor handler = getHttpRequestProcessor();
		HttpResponse response = handler.handle(request);
		
		String body = response.getBody();
		
		assertEquals("200",response.getStatusCode());
		assertEquals("OK",response.getStatusCodeDescription());
		assertEquals("text/html",response.getHeader("Content-Type"));
		assertTrue(body.contains("Another"));
	}
	private HttpRequestProcessor getHttpRequestProcessor() {
		HandlerFactory factory = new HandlerFactory();
		
		HttpRequestProcessor handler = new HttpRequestProcessor(factory);
		return handler;
	}
}
