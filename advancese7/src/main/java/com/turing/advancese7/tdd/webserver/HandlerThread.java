package com.turing.advancese7.tdd.webserver;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import com.turing.advancese7.tdd.webserver.handler.HandlerFactory;
import com.turing.advancese7.tdd.webserver.io.HttpRequest;
import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public class HandlerThread extends Thread{
	Socket socket;
	
	HttpRequestParser requestParser;
	HttpRequestProcessor processor;
	HttpResponseWriter writer;
	
	public HandlerThread(HttpRequestParser requestParser,
			HttpRequestProcessor processor,
			HttpResponseWriter writer,
			Socket socket
			)
	{
		this.requestParser = requestParser;
		this.processor = processor;
		this.writer = writer;
		this.socket = socket;
	}
	public void run()
	{
		//Read request
		//Send response
		
		try {
			System.out.println("Before parse");
			HttpRequest request = requestParser.parse(new DataInputStream(this.socket.getInputStream()));
			System.out.println("HttpRequest "+request);
			
			HttpResponse response = processor.handle(request);
			System.out.println("HttpResponse "+response);
			
			
			HttpResponseWriter writer = new HttpResponseWriter();
			writer.writeBufferedOutput(response, new BufferedOutputStream(this.socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private HttpResponse createHttpResponse() {
		HttpResponse response = new HttpResponse();
		
		String body = "<html><h1>hello</h1></html>";
		response.setHttpVersion("HTTP/1.1");
		response.setHeader("Content-Type", "text/html");
		response.setHeader("Connection", "Closed");
		response.setHeader("Content-Length",""+ body.length());
		response.setStatusCode("200");
		
		
		response.setBody(body);
		return response;
	}
}
