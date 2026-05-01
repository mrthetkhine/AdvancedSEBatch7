package com.turing.advancese7.designpattern.bridge;

public class Rectangle extends Shape{

	Rectangle(DrawingApi api) {
		super(api);
	}

	@Override
	void draw() {
		this.api.drawRectangle();
	}

}
