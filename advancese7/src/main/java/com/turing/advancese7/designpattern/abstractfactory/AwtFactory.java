package com.turing.advancese7.designpattern.abstractfactory;

public class AwtFactory implements UIFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new AwtButton();
	}

	@Override
	public TextField createTextField() {
		// TODO Auto-generated method stub
		return new AwtTextField();
	}

}
