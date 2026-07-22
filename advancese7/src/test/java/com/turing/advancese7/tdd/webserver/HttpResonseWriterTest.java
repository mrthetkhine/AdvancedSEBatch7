package com.turing.advancese7.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public class HttpResonseWriterTest {

	static HttpServer webServer;
	
	@BeforeAll
	static void beforeAll(){
	
		webServer = new HttpServer(9000);
		
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stubwebserver.start();
				webServer.start();
				System.out.println("Server started");
			}
			
		});
	}
	
	@Test
	public void test200Response()
	{
		String body = "<html><h1>HelloWorld</h1></html>";
		HttpResponse response = createHttp200Response();
		response.setBody(body);
		
		HttpResponseWriter writer = new HttpResponseWriter();
		String data = writer.writeString(response);
		
		String output = "HTTP/1.1 200 OK\r\n"
				+"Content-Type: text/html\r\n\r\n"
				+body;
		assertEquals(output,data);
	}
	@Test
	public void test200ResponseWithNoBody()
	{
		
		HttpResponse response = createHttp200Response();
		response.setHeader("Connection", "Closed");
		
		HttpResponseWriter writer = new HttpResponseWriter();
		String data = writer.writeString(response);
		
		String output = "HTTP/1.1 200 OK\r\n"
				+"Content-Type: text/html\r\n"
				+"Connection: Closed\r\n"
				+ "\r\n";
			
		assertEquals(output,data);
	}

	private HttpResponse createHttp200Response() {
		HttpResponse response = new HttpResponse();
		response.setHttpVersion("HTTP/1.1");
		response.setStatusCode("200");
		response.setHeader("Content-Type","text/html");
		return response;
	}
	@Test
	public void test4000ResponseWithNoBody()
	{
		String body = "<html>Bad Request</html>";
		HttpResponse response = new HttpResponse();
		response.setHttpVersion("HTTP/1.1");
		response.setStatusCode("400");
		
		response.setHeader("Content-Type", "text/html");
		
		response.setBody(body);
		
		HttpResponseWriter writer = new HttpResponseWriter();
		String data = writer.writeString(response);
		
		String output = "HTTP/1.1 400 Bad Request\r\n"
				+"Content-Type: text/html\r\n"
				+ "\r\n"
				+body;
			
		assertEquals(output,data);
	}

	//@Test
	public void testBufferOutupt(String input)
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        // Small buffer size of 5 bytes for testing behavior
        BufferedOutputStream bOut = new BufferedOutputStream(stream);
        
        String message = input;
        try {
			bOut.write(message.getBytes());
			bOut.flush();
			
			assertEquals(message, stream.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	@Test
	public void test200ResponseToOutputStream()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		BufferedOutputStream bOut = new BufferedOutputStream(stream);
		 
		String body = "<html><h1>HelloWorld</h1></html>";
		HttpResponse response = createHttp200Response();
		response.setBody(body);
		
		HttpResponseWriter writer = new HttpResponseWriter();
		
		
		writer.writeBufferedOutput(response,bOut);
		
		String output = "HTTP/1.1 200 OK\r\n"
				+"Content-Type: text/html\r\n\r\n"
				+body;
		assertEquals(output,stream.toString());
	}
	//@Test
	public void test200ResponseToSocket() throws UnknownHostException, IOException
	{
		
		Socket socket = new Socket("localhost",9000);
		
		String body = "<html><h1>HelloWorld</h1></html>";
		HttpResponse response = createHttp200Response();
		response.setBody(body);
		
		HttpResponseWriter writer = new HttpResponseWriter();
		
		DataInputStream bIn = new DataInputStream(socket.getInputStream());
		try {
			writer.writeBufferedOutput(response,new BufferedOutputStream(socket.getOutputStream()));
			
			System.out.println("Write done");
			String output = "HTTP/1.1 200 OK\r\n"
					+"Content-Type: text/html\r\n\r\n"
					+body+"\r\n";
			
			socket.getOutputStream().flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("Socket isBound "+socket.isBound());
			System.out.println("is closed "+socket.isClosed());
			
			
			String output = bIn.readUTF();
			System.out.println("After read "+output);
			int data ;
			while((data= bIn.read())!=-1)
			{
				System.out.println((char)data);
				output += (char)data;
			}
			System.out.println("Output "+output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
