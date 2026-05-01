package com.turing.advancese7.designpattern.bridge;

public class SvgApi implements DrawingApi{

	@Override
	public void drawRectangle() {
		System.out.println("Draw SVG Rectangle");
		
	}

	@Override
	public void drawCircle() {
		System.out.println("Draw SVG Circle");
		
	}

}
