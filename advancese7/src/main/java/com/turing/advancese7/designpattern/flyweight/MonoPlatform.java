package com.turing.advancese7.designpattern.flyweight;

public class MonoPlatform implements Platform{

	MonoPlatform()
	{
		System.out.println("Mono platform created");
	}
	@Override
	public void execute(Code code) {
		System.out.println("Execute code on Mono "+code);
		
	}

}
