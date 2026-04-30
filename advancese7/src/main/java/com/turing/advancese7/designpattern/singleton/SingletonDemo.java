package com.turing.advancese7.designpattern.singleton;

public class SingletonDemo {
	public static void main(String[]args)
	{
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		System.out.println("Obj == obj2 "+(obj1==obj2));
		/*
		try {
			Class  clazz = Class.forName("com.turing.advancese7.designpattern.Singleton");
			//Singleton obj =(Singleton )( clazz.newInstance()); 
			//System.out.println("Obj "+obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		Runtime runtime = Runtime.getRuntime();
	}
}
