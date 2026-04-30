package com.turing.advancese7.designpattern.abstractfactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractFactoryDemo {
	public static void main(String[]args)
	{
		UIFactory factory = new SwingFactory();
		Button button = factory.createButton();
		TextField textField = factory.createTextField();
		
		button.draw();
		textField.draw();
		
		//Connection con = Connection;
		//DriverManager.getConnection("");
	}
}
