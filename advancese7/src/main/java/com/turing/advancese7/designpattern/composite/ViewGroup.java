package com.turing.advancese7.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class ViewGroup extends UIWidget{

	List<UIWidget> children = new ArrayList<>();
	
	public ViewGroup(String id) {
		super(id);
	}
	void addWidget(UIWidget widget)
	{
		this.children.add(widget);
	}

	@Override
	public void paint() {
		System.out.println("Paint view group "+id);
		for(UIWidget widget : this.children)
		{
			widget.paint();
		}
		
	}

}
