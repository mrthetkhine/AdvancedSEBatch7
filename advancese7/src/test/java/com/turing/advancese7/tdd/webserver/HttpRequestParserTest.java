package com.turing.advancese7.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HttpRequestParserTest {

	HttpRequestParser parser = new HttpRequestParser();
	
	@Test
	void testStartLine()
	{
		
		String httpRequest = "GET / HTTP/1.1\r\n";
		HttpRequest request = parser.parse(httpRequest);
		
		assertEquals("GET",request.getHttpMethod());
		assertEquals("/",request.getUrl());
		assertEquals("HTTP/1.1",request.getHttpVersion());
	}
	@Test
	void testStartLinePost()
	{
		
		String httpRequest = "POST /hello HTTP/1.1\r\n";
		HttpRequest request = parser.parse(httpRequest);
		
		assertEquals("POST",request.getHttpMethod());
		assertEquals("/hello",request.getUrl());
		assertEquals("HTTP/1.1",request.getHttpVersion());
	}
	
	@Test
	void testStartLinePostWithHeaders()
	{
		
		String httpRequest = "POST /hello HTTP/1.1\r\n"
							+"Content-Length: 345\r\n"
							+"Content-Type: application/json\r\n";
		HttpRequest request = parser.parse(httpRequest);
		
		assertEquals("POST",request.getHttpMethod());
		assertEquals("/hello",request.getUrl());
		assertEquals("HTTP/1.1",request.getHttpVersion());
		
		assertEquals("application/json",request.getHeader("Content-Type"));
		assertEquals("345",request.getHeader("Content-Length"));
	}
	@Test
	void testParseWithBody()
	{
		String body = "{data:123}";
		String httpRequest = "POST /hello HTTP/1.1\r\n"
							+"Content-Length: 345\r\n"
							+"Content-Type: application/json\r\n"
							+"\r\n"
							+body;
		HttpRequest request = parser.parse(httpRequest);
		
		assertEquals("POST",request.getHttpMethod());
		assertEquals("/hello",request.getUrl());
		assertEquals("HTTP/1.1",request.getHttpVersion());
		
		assertEquals("application/json",request.getHeader("Content-Type"));
		assertEquals("345",request.getHeader("Content-Length"));
		assertEquals(body,request.getBody());
	}
}
