package com.turing.advancese7.designpattern.composite;

public abstract class UIWidget {
	String id;
	public UIWidget(String id)
	{
		this.id = id;
	}
	public abstract void paint();
}
