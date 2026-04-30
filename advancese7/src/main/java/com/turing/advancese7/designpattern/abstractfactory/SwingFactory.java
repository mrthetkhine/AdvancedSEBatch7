package com.turing.advancese7.designpattern.abstractfactory;

public class SwingFactory implements UIFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new SwingButton();
	}

	@Override
	public TextField createTextField() {
		// TODO Auto-generated method stub
		return new SwingTextField();
	}

}
