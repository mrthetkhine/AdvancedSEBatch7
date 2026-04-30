package com.turing.advancese7.designpattern.factory;

public class FactoryDemo {
	public static void main(String[]args)
	{
		ConnectionFactory factory = new MySQLFactory();
		factory = new OracleFactory();
		Connection con = factory.openConnection();
		con.open();
		con.close();
	}
}
