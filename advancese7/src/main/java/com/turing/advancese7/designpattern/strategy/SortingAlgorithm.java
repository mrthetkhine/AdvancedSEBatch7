package com.turing.advancese7.designpattern.strategy;

public class SortingAlgorithm {
	ComparableStrategy strategy;
	
	void setStrategy(ComparableStrategy strategy)
	{
		this.strategy = strategy;
	}
	void sort()
	{
		System.out.println("Sort with strategy");
		this.strategy.compare();
	}
}
