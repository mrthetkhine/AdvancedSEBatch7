package com.turing.advancese7.designpattern.abstractfactory;

public class AwtButton implements Button{

	@Override
	public void draw() {
		System.out.println("Awt Button");
		
	}

}
