package com.turing.advancese7.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

class Response
{
	String statusLine;
	String headers;
	String body;
	public String getStatusLine() {
		return statusLine;
	}
	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}
	public String getHeaders() {
		return headers;
	}
	public void setHeaders(String headers) {
		this.headers = headers;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
@Slf4j
public class WebServerTest {
	
	static HttpServer webServer;
	
	@BeforeAll
	static void beforeAll(){
	
		webServer = new HttpServer(9000);
		
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stubwebserver.start();
				webServer.start();
				log.info("After start");
			}
			
		});
	}
	@Test
	public void testServerCanAcceptConnection()
	{
		
		Socket clientSocket;
		try {
			clientSocket = new Socket("localhost",9000);
			assertTrue(clientSocket.isBound());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testServerCanAcceptAnotherConnection()
	{
		
		Socket clientSocket;
		try {
			clientSocket = new Socket("localhost",9000);
			assertTrue(clientSocket.isBound());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private Socket createSocketAndSendRequest(String httpRequest) throws UnknownHostException, IOException {
		Socket socket;
		socket = new Socket("localhost",9000);
		//send data to socket
		
		DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
		dOut.write((httpRequest+"\r\n").getBytes());

		dOut.flush();
		return socket;
	}
	Response parseResponse(Socket socket) throws Exception
	{
		DataInputStream bIn = new DataInputStream(socket.getInputStream());
		Response response = new Response();
		
		String statusLine = bIn.readLine();
		response.setStatusLine(statusLine);
		
		String allHeader = "";
		String header = bIn.readLine();
		while(! header.isEmpty())
		{
			
			allHeader += (header+"\r\n");
			//System.out.println("Append "+allHeader + " header "+header);
			String keyValue[] = header.split(": " );
			
			//System.out.println("Header "+keyValue[0] +" ==> "+keyValue[1]);
			header = bIn.readLine();
			
			
		}
		//System.out.println("All Headers ==> "+allHeader);
		response.setHeaders(allHeader);
		
		System.out.println("Available before body "+bIn.available());
		byte bytes[] = new byte[bIn.available()];
		
		bIn.read(bytes);
		
		String body = new String(bytes);
		
		System.out.println("Done parsing response body");
		response.setBody(body);
		return response;
	}
	@Test
	public void testServerCanReturnResponse() 
	{
		String httpRequest = "GET / HTTP/1.1\r\n"
							+"\r\n";
		
		Socket socket;
		try {
			socket = createSocketAndSendRequest(httpRequest);
			Response response = this.parseResponse(socket);
			
			System.out.println("Read done "+response.getBody());
			String httpResponse = "HTTP/1.1 200 OK";
			
			assertEquals(httpResponse,response.getStatusLine());
			assertTrue(response.getHeaders().contains("Content-Type: text/html"));
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testServerCanReturn200ResponseToDefaultRoute()
	{
		String httpRequest = "GET / HTTP/1.1\r\n"
				+"\r\n";

		Socket socket;
		try {
			socket = createSocketAndSendRequest(httpRequest);

			Response response = this.parseResponse(socket);
			
			String httpResponse = "HTTP/1.1 200 OK";
			assertEquals(httpResponse,response.getStatusLine());
			assertTrue(response.getHeaders().contains("Content-Type: text/html"));
			
			assertNotNull(response.body);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testServerCanReturn200ResponseToIndexHtml()
	{
		String httpRequest = "GET /index.html HTTP/1.1\r\n"
				+"\r\n";

		Socket socket;
		try {
			socket = createSocketAndSendRequest(httpRequest);

			Response response = this.parseResponse(socket);
			
			String httpResponse = "HTTP/1.1 200 OK";
			assertEquals(httpResponse,response.getStatusLine());
			assertTrue(response.getHeaders().contains("Content-Type: text/html"));
			
			assertNotNull(response.body);
			System.out.println("Body==> "+response.getBody());
			assertTrue(response.body.contains("Hello from index"));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
