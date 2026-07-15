package com.turing.advancese7.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HttpRequestHandlerTest {
	
	@Test
	public void testHandleRequest()
	{
		HttpRequest request = new HttpRequest();
		request.setHttpMethod("GET");
		request.setUrl("/");
		request.setHttpMethod("HTTP/1.1");
		
		HttpRequestHandler handler = new HttpRequestHandler();
		HttpResponse response = handler.handle(request);
		
		String body = response.getBody();
		assertTrue(body.contains("Hello"));
	}
}
