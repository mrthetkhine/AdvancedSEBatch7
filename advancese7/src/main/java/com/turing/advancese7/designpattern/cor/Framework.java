package com.turing.advancese7.designpattern.cor;
import java.util.*;

public class Framework {
	List<Handler> handlers = new ArrayList<>();
	
	void addHandler(Handler handler)
	{
		this.handlers.add(handler);
		
	}
	void processRequest(Request req,Response resp)
	{
		try
		{
			for(Handler handler : this.handlers)
			{
				handler.handle(req, resp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
