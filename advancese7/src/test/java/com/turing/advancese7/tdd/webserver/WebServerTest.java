package com.turing.advancese7.tdd.webserver;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
