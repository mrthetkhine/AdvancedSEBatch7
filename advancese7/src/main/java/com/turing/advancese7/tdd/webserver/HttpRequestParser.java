package com.turing.advancese7.tdd.webserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import com.turing.advancese7.tdd.webserver.io.HttpRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpRequestParser {

	private static final String HEADER_KEY_VALUE_SEPERATOR = ": ";

	public HttpRequest parse(DataInputStream dIn) {
		
		StringBuffer rawString = bufferToRawString(dIn);
		HttpRequest request = this.parse(rawString.toString());
		return request;
	}
	private StringBuffer bufferToRawString(DataInputStream dIn) {
		StringBuffer rawString = new StringBuffer();
		
		try {
			String statusLine = dIn.readLine();
			System.out.println("status line "+statusLine);
			rawString.append(statusLine+"\r\n");
			
			String header = dIn.readLine();
			Integer contentLength =null;
			if(header !=null)
			{
				while( !header.isEmpty())
				{
					String keyValues[] = header.split(": ");
					String key = keyValues[0];
					String value = keyValues[1];
					
					if(key.equals("Content-Length"))
					{
						contentLength = Integer.parseInt(value);
					}
					rawString.append(header+"\r\n");
					header = dIn.readLine();
					
					if(header==null)
					{
						break;
					}
					
				}
				if(header!=null)//header is empty
				{
					rawString.append("\r\n");
					System.out.println("Content Length ==> "+contentLength);
					
					if(contentLength!=null)
					{
						int ch;
						String body="";
						while( (ch = dIn.read())!= -1)
						{
							body+= ((char)ch);
							System.out.println("read char "+(char)ch);
						}
						
						rawString.append(body);
					}
					
					
					System.out.println("Done parsing body");
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rawString;
	}
	public HttpRequest parse(String rawString) {
		HttpRequest request = new HttpRequest();
		
		String lines[] = rawString.split("\r\n");
		String startLine = lines[0];
		
		parseStatusLine(request, startLine);
		parseHeadersAndBody(request, lines);
		
		return request;
	}

	private void parseStatusLine(HttpRequest request, String startLine) 
	{
		
		String startLinesData[] = startLine.split(" ");
		
		String httpMethod = startLinesData[0];
		String url = startLinesData[1];
		String httpVersion = startLinesData[2];
		
		request.setHttpMethod(httpMethod);
		request.setUrl(url);
		request.setHttpVersion(httpVersion);
	}

	private void parseHeadersAndBody(HttpRequest request, String[] lines) {
		String line;
		int i ;
		for(i=1;i< lines.length;i++)
		{
			line = lines[i]; 
			if(line.isEmpty())
			{
				i++;//skip blank line,after it is body
				break;
			}
			String headerData[] = line.split(HEADER_KEY_VALUE_SEPERATOR);
			String key = headerData[0];
			String value = headerData[1];
			
			request.setHeader(key, value);
		}
		/*
		 * it is body after blank line, just make sure it is body 
		 * and do not index out of bound
		 */
		if(i <lines.length)
		{
			String body = lines[i];
			request.setBody(body);
		}
		
	}

}
