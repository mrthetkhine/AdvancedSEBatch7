package com.turing.advancese7.designpattern.command.functional;

public class Demo {

	public static void main(String[]args)
	{
		Callback cb =()->{
			System.out.println("Callback one");
		};
		Receiver receiver =new Receiver(cb);
		receiver.run();
	}
}
