package com.turing.advancese7.designpattern.factory;

public class MySQLConnection implements Connection {

	@Override
	public void open() {
		System.out.println("MySQL connection open");
		
	}

	@Override
	public void close() {
		System.out.println("MySQL connection closed");
		
	}

}
