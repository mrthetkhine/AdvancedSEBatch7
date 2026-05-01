package com.turing.advancese7.designpattern.bridge;

public class CanvasApi implements DrawingApi{

	@Override
	public void drawRectangle() {
		System.out.println("Draw Canvas Rectangle");
		
	}

	@Override
	public void drawCircle() {
		System.out.println("Draw Canvas Circle");
		
	}

}
