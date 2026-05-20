package com.turing.advancese7.designpattern.strategy;

public class StrategyDemo {
	public static void main(String[]args)
	{
		SortingAlgorithm algo = new SortingAlgorithm();
		
		algo.setStrategy(new NumberComparatorStrategy());
		algo.sort();
		
		algo.setStrategy(new StringComparatorStrategy());
		algo.sort();
	}
}
