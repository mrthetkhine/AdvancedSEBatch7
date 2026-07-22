package com.turing.advancese7.tdd.webserver;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public class HandlerThread extends Thread{
	Socket socket;
	
	public HandlerThread(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		//Read request
		//Send response
		HttpResponse response = createHttpResponse();
		
		HttpResponseWriter writer = new HttpResponseWriter();
		try {
			writer.writeBufferedOutput(response, new BufferedOutputStream(this.socket.getOutputStream()));
			//this.socket.close();
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
