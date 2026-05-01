package com.turing.advancese7.designpattern.composite;

public class View extends UIWidget{

	public View(String id) {
		super(id);
		
	}

	@Override
	public void paint() {
		System.out.println("Paint view "+id);
		
	}

}
