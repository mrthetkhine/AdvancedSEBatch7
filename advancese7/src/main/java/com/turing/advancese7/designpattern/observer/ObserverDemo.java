package com.turing.advancese7.designpattern.observer;

public class ObserverDemo {
	public static void main(String[]args)
	{
		Model model = new Model();
		View v1 = new View("View1");
		model.attach(v1);
		
		View v2 = new View("View 2");
		model.attach(v2);
		
		model.change("hello");
		model.remove(v2);
		
		model.change("Another");
	}
}
