package com.turing.advancese7.designpattern.adapter;

public class ClassAdapter extends OldApi implements Api {

	@Override
	public void api() {
		super.oldApi();
	}
}
