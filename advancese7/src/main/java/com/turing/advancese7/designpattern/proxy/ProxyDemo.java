package com.turing.advancese7.designpattern.proxy;

public class ProxyDemo {
	public static void main(String[]args)
	{
		CommandExecutor executor = new AccessProxy("admin","admin1");
		
		executor.runCommand("rm rf");
	}
}
