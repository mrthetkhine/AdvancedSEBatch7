package com.turing.advancese7.designpattern.flyweight;

public class FlyweightDemo {
	
	public static void main(String[]args)
	{
		/*
		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println(str1==str2);
		
		Integer i = 127;
		Integer j = 127;
		
		System.out.println("i==j "+(i==j));
		
		i = 128;
		j = 128;
		System.out.println("i==j "+(i.intValue()==j.intValue()));*/
		Code code = new Code("i=0");
		PlatformFactory factory = new PlatformFactory();
		Platform p = factory.getPlatform("JVM");
		p.execute(code);
		
		p = factory.getPlatform("Mono");
		p.equals(code);
		
		p = factory.getPlatform("JVM");
		p.execute(code);
		
		
	}
}
