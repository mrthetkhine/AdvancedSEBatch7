package com.turing.advancese7.designpattern.template;

public abstract class FrameworkAction {
	public void process() {
		this.authenticate();
		this.businessLogic();
		this.log();
	}

	void authenticate() {
		System.out.println("Authenticate");
	}

	abstract void businessLogic();

	void log() {
		System.out.println("Log Action");
	}
}
