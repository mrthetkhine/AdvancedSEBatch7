package com.turing.advancese7.designpattern.bridge;

public class BridgeDemo {
	public static void main(String[]args)
	{
		DrawingApi api = new CanvasApi();
		Shape shape = new Rectangle(api);
		shape.draw();
	}
}
