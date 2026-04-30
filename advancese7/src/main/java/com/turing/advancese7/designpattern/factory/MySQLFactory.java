package com.turing.advancese7.designpattern.factory;

public class MySQLFactory implements ConnectionFactory{

	@Override
	public Connection openConnection() {
		return new MySQLConnection();
	}

}
