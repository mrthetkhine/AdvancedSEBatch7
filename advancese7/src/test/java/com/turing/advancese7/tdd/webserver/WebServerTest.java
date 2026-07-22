package com.turing.advancese7.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	@Test
	public void testServerCanReturnResponse()
	{
		String httpRequest = "GET / HTTP/1.1\r\n"
							+"\r\n";
		
		Socket socket;
		try {
			socket = new Socket("localhost",9000);
			assertTrue(socket.isBound());
			//send data to socket
			DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
			dOut.write(httpRequest.getBytes());
			dOut.flush();
			
			DataInputStream bIn = new DataInputStream(socket.getInputStream());
			
			String statusLine = bIn.readLine();
			
			String header = bIn.readLine();
			while(! header.isEmpty())
			{
				String keyValue[] = header.split(": " );
				
				System.out.println("Header "+keyValue[0] +" value "+keyValue[1]);
				header = bIn.readLine();
				
				System.out.println("Header "+header);
			}
			String body = bIn.readLine();
			if(body != null)
			{
				System.out.println("Body "+body);
			}
			System.out.println("Read body done");
			String httpResponse = "HTTP/1.1 200 OK";
			assertEquals(httpResponse,statusLine);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
