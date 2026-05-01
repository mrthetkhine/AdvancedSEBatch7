package com.turing.advancese7.designpattern.prototype;

public class HeavyObject implements Prototype{
	String heavyProp;
	
	HeavyObject()
	{
		heavyProp = "HeavyProp";
		System.out.println("HeayObject constructor");
	}

	@Override
	public Prototype reproduce() {
		Prototype clone =null;
		try {
			clone = (Prototype)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clone;
	}
}
