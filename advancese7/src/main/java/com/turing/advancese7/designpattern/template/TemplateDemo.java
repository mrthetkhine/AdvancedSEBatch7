package com.turing.advancese7.designpattern.template;

public class TemplateDemo {
	public static void main(String[]args)
	{
		FrameworkAction action = new OrderController();
		action.process();
		
		action = new PaymentController();
		action.process();
	}
}
