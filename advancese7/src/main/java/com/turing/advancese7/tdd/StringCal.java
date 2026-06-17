package com.turing.advancese7.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class StringCal {

	static final int INITIAL_STATE =0;
	static final int INPUT_READING_STATE =1;
	
	List<Character> seperators = new ArrayList<>();
	public StringCal()
	{
		seperators.add(',');
		seperators.add('\n');
	}
	boolean isSeperator(char ch)
	{
		for(char sep : this.seperators)
		{
			if(ch==sep)
			{
				
				return true;
			}
		}
		return false;
	}
	boolean isValidInput(char ch)
	{
		return Character.isDigit(ch) || ch =='.';
	}
	List<String> parseToken(String input)
	{
		List<String> numberList = new ArrayList<>();
		String numberToken = "";
		
		int state = INITIAL_STATE;//Input reading
		System.out.println("Input ==> "+input);
		
		for(int i=0;i<input.length();i++)
		{
			char ch = input.charAt(i);
			System.out.println("Current ch "+ch);
			switch(state)
			{
				case INITIAL_STATE://input accept
					
					if(this.isValidInput(ch))
					{
						System.out.println("Valid input "+ch);
						numberToken+= ch;
					}
					else if(this.isSeperator(ch))
					{
						System.out.println("seperator case "+ch);
						numberList.add(numberToken);
						state = INPUT_READING_STATE;
						numberToken="";
					}
					else
					{
						throw new RuntimeException(this.seperators.get(0) +" expected but found "+ch+" at position "+i);
					}
				break;	
				case INPUT_READING_STATE://seperator
					if(isSeperator(ch))
					{
						//Problem
						System.out.println("Error state position "+i);
						throw new RuntimeException("Number expected but "+ch+" found at position "+i);
					}
					else if(this.isValidInput(ch))
					{
						state = INITIAL_STATE;
						numberToken= ""+ch;
					}
					else
					{
						throw new RuntimeException(this.seperators.get(0) +" expected but found "+ch+" at position "+i);
					}
			}
		}
		System.out.println("State "+state+ " token "+numberToken);
		if(!numberToken.isEmpty())
		{
			numberList.add(numberToken);
		}
		else if(state==INPUT_READING_STATE && numberToken.isEmpty())
		{
			System.out.println("This case");
			throw new RuntimeException("Number expected but EOF found.");
		}
		return numberList;
	}
	public String sum(String input) {
		
		if(input == null || input.isEmpty())
		{
			return 0+"";
		}
		else if(input.startsWith("//"))
		{
			return sumWithCustomSeperator(input);
		}
		else
		{
			return sumListOfNumber(input);
			
		}
	}
	private String sumWithCustomSeperator(String input) {
		int indexOfNewLine = input.indexOf('\n');
				
		String sep = input.substring(2,indexOfNewLine);
		
		System.out.println("Sep==> "+sep);
		seperators = new ArrayList<>();
		seperators.add(';');
		
		String numList=input.substring(indexOfNewLine+1).replace(sep, ";");
		System.out.println("Remaining input ==> "+numList);
		return sumListOfNumber(numList);
	}
	private String sumListOfNumber(String input) {
		try
		{
			double total = sumNumber(input);
			return removeDotZeroSuffix(total);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	private String removeDotZeroSuffix(double total) {
		String output = String.valueOf(total);
		if(output.endsWith(".0"))
		{
			return output.substring(0,output.indexOf("."));
		}
		else
		{
			return output;
		}
	}
	private double sumNumber(String input) {
		List<String> tokens = parseToken(input);
		double total = 0;
		
		for(String token : tokens)
		{
			System.out.println("Token "+token);
			total += Double.parseDouble(token);
		}
		return total;
	}

}
