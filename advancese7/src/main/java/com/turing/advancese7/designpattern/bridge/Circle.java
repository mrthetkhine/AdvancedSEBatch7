package com.turing.advancese7.designpattern.bridge;

public class Circle extends Shape{

	Circle(DrawingApi api) {
		super(api);
		
	}

	@Override
	void draw() {
		this.api.drawCircle();
	}

}
