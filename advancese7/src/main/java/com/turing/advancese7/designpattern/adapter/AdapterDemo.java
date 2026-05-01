package com.turing.advancese7.designpattern.adapter;

public class AdapterDemo {
	public static void main(String[]args)
	{
		Api api = new ClassAdapter();
		api = new ObjectAdapter();
		api.api();
	}
}
