package com.turing.advancese7.designpattern.flyweight;

import java.util.HashMap;

public class PlatformFactory {

	HashMap<String,Platform> cache = new HashMap<>();
	Platform getPlatform(String name)
	{
		if(cache.containsKey(name))
		{
			return cache.get(name);
		}
		else
		{
			Platform p = null;
			if(name.equals("JVM"))
			{
				p = new JVMPlatform();
			}
			else if(name.equals("Mono"))
			{
				p = new MonoPlatform();
			}
			cache.put(name, p);
			return cache.get(name);
		}
	}
}
