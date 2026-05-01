package com.turing.advancese7.designpattern.prototype;

public class PrototypeDemo {
	public static void main(String[]args)
	{
		HeavyObject obj =new HeavyObject();
		Prototype clone= obj.reproduce();
		System.out.println("Obj == clone "+(obj==clone));
	}
}
