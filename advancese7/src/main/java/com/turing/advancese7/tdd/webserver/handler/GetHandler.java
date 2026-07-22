package com.turing.advancese7.tdd.webserver.handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import com.turing.advancese7.tdd.webserver.io.HttpRequest;
import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public class GetHandler implements RequestHandler{
	

	private static final String INTERNAL_SERVER_500 = "500";

	private static final String OK_200 = "200";

	private static final String CONTENT_LENGTH = "Content-Length";

	private static final String CONTENT_TYPE = "Content-Type";

	static final String SERVER_ROOT = "/Users/Project/Turing/AdvancedSE/AdvancedSEBatch7/WebServerRoot";
	
	HashMap<String,String> extContentType = new HashMap<>();
			
	public GetHandler()
	{
		this.extContentType.put("html", "text/html");
		this.extContentType.put("htm", "text/html");
		this.extContentType.put("css", "text/css");
		this.extContentType.put("", "text/plain");
	}
	@Override
	public void handle(HttpRequest request,HttpResponse response) {
		Path path = resolvePath(request.getUrl());
		try 
		{
			System.out.println("Path "+path);
			
			resolveContent(response, path);
			resolveContentType(response, path);
		} catch (IOException e) {
			System.out.println("Exception "+e.getMessage());
			response.setStatusCode(INTERNAL_SERVER_500);
			//e.printStackTrace();
		}
	}
	private void resolveContentType(HttpResponse response, Path path) {
		String extension = this.getExtension(path);
		String contentType = this.extContentType.get(extension);
		response.setHeader(CONTENT_TYPE, contentType);
	}
	private void resolveContent(HttpResponse response, Path path) throws IOException {
		String content = Files.readString(path);
		response.setBody(content);
		response.setHeader(CONTENT_LENGTH,content.length()+"");
		response.setStatusCode(OK_200);
	}
	private Path resolvePath(String url) {
		Path path = null;
		if("/".equals(url))
		{
			System.out.println("handle get /");
			url = "index.html";

		}
		
		path = Path.of(SERVER_ROOT, url);
		return path;
	}
	String getExtension(Path path)
	{
		if (path == null) {
            return "";
        }
   
        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        
        if (dotIndex > 0) {
            return fileName.substring(dotIndex + 1);
        }     
        return ""; // No extension found
    
	}

}
