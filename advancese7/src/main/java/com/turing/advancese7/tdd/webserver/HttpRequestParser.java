package com.turing.advancese7.tdd.webserver;

import java.util.StringTokenizer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpRequestParser {

	private static final String HEADER_KEY_VALUE_SEPERATOR = ": ";

	public HttpRequest parse(String rawString) {
		HttpRequest request = new HttpRequest();
		
		String lines[] = rawString.split("\r\n");
		
		System.out.println("lines count "+lines.length);
		for(String line :lines)
		{
			System.out.println("line "+line);
		}
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
