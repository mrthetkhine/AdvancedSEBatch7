package com.turing.advancese7.designpattern.composite;

public class CompositeDemo {
	public static void main(String[]args)
	{
		ViewGroup viewGroup1 = new ViewGroup("viewGroup1");
		viewGroup1.addWidget(new View("Textbox 1 of view group 1"));
		viewGroup1.addWidget(new View("Label 1 of view group 1"));
		
		ViewGroup childViewGroup = new ViewGroup("SubChild of view group1");
		childViewGroup.addWidget(new View("Textbox view of child container"));
		childViewGroup.addWidget(new View("Label view of child container"));
		
		viewGroup1.addWidget(childViewGroup);
		
		viewGroup1.paint();
	}
}
