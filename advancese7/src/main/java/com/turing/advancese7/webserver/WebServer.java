package com.turing.advancese7.webserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ClientHandler extends Thread
{
	Socket socket;
	ClientHandler(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		try
		{
			DataInputStream din= new DataInputStream(this.socket.getInputStream());
			
			String startLine = din.readLine();
			System.out.println("StartLine "+startLine);
			DataOutputStream dOut = new DataOutputStream(this.socket.getOutputStream());
			
			String body = "<h1>Hello from our server</h1>";
			String response = "HTTP/1.1 200 OK\r\n"
					+	"Content-Type: text/html\r\n"
					//+	"Connection: Closed\r\n"
					+	"Content-Length: "+body.length()+"\r\n\r\n"
					+ body;
			System.out.println("Response "+response);
			dOut.write(response.getBytes());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class WebServer {
	
	ServerSocket serverSocket;
	int port = 9000;
	void start()
	{
		System.out.println("listen on port "+port);
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{
			try {
				Socket socket= this.serverSocket.accept();
				System.out.println("Client connected");
				ClientHandler handler = new ClientHandler(socket);
				handler.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[]args)
	{
		WebServer webServer = new WebServer();
		webServer.start();
	}
}
