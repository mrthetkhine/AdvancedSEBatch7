package com.turing.advancese7.designpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
	public static void main(String[]args)
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		
		Range range = new Range(0,6);
		Iterator<Integer> iterator = range.iterator();
		//iterator = list.iterator();
		/*
		while(iterator.hasNext())
		{
			System.out.println("Next "+iterator.next());
		}
		*/
		for(Integer item : range)
		{
			System.out.println("Item "+item);
		}
		
	}
}
