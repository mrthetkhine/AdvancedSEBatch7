package com.turing.advancese7.tdd.webserver;

import java.net.ServerSocket;
import java.net.Socket;

import com.turing.advancese7.tdd.webserver.handler.HandlerFactory;

public class HttpServer {

	int port;
	ServerSocket socket;
	
	Socket clientSocket;
	HttpRequestParser requestParser;
	HttpRequestProcessor processor;
	HttpResponseWriter writer;
	
	public HttpServer(int port)
	{
		this.port = port;
		this.requestParser = new HttpRequestParser();
		HandlerFactory factory = new HandlerFactory();
		
		this.processor = new HttpRequestProcessor(factory);
		this.writer = new HttpResponseWriter();
		
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
			while(true)
			{
				Socket socket = this.socket.accept();
				System.out.println("Client connected");
				HandlerThread thread = new HandlerThread(this.requestParser,
						this.processor,
						this.writer,
						socket);
				thread.start();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Start done");
	}
	public static void main(String[]args)
	{
		HttpServer server = new HttpServer(8000);
		server.start();
	}
}
