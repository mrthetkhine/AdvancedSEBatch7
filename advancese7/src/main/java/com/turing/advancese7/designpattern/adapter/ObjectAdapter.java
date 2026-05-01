package com.turing.advancese7.designpattern.adapter;

public class ObjectAdapter implements Api{

	OldApi api = new OldApi();
	@Override
	public void api() {
		api.oldApi();
		
	}

}
