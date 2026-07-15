package com.turing.advancese7.tdd.webserver;

import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	int port;
	ServerSocket socket;
	
	public HttpServer(int port)
	{
		this.port = port;
		
	}
	void init()
	{
		try
		{
			this.socket = new ServerSocket(this.port);
			System.out.println("Server listen at "+this.port);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	void start()
	{
		this.init();
		try
		{
			Socket clientSocket= this.socket.accept();
			System.out.println("Client connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Start done");
	}
}
