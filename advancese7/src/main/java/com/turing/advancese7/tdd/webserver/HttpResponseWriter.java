package com.turing.advancese7.tdd.webserver;

import java.io.BufferedOutputStream;
import java.io.IOException;

import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public class HttpResponseWriter {

	public String writeString(HttpResponse response) {
		StringBuffer buffer = new StringBuffer();
		
		//Status Line
		buffer.append(response.getHttpVersion()+ " "+response.getStatusCode()+" "+response.getStatusCodeDescription()+"\r\n");
		
		//header
		for(String header : response.getHeaders().keySet())
		{
			buffer.append(header+": "+response.getHeader(header)+"\r\n");
		}
		//body new line
		buffer.append("\r\n");
		if(response.getBody()!=null)
		{
			buffer.append(response.getBody()+"\r\n");
		}
		return buffer.toString();
	}

	public void writeBufferedOutput(HttpResponse response, BufferedOutputStream bOut) {
		String message = this.writeString(response);
		try {
			bOut.write(message.getBytes());
			bOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
