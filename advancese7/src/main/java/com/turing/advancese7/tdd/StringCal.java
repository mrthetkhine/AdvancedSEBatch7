package com.turing.advancese7.tdd;

public class StringCal {

	public static double sum(String input) {
		
		if(input == null || input.isEmpty())
		{
			return 0;
		}
		else
		{
			return Double.parseDouble(input);
		}
	}

}
