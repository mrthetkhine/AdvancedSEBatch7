package com.turing.advancese7.designpattern.decorator;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class DecoratorDemo {
	public static void main(String[]args)
	{
		Logger logger = new HtmlDecorator( (new BasicLogger()));
		System.out.println(logger.log("hello"));
		/**/
		
		//DataInputStream din = new DataInputStream(new FileInputStream(new File("")));
		//BufferedInputStream bin  = new BufferedInputStream(new DataInputStream(new FileInputStream(new File(""))));
	}
}
