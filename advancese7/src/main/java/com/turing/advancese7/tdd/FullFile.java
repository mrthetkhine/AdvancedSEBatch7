package com.turing.advancese7.tdd;

import java.io.File;
import java.io.IOException;

public class FullFile extends File{

	public FullFile(String pathname) {
		super(pathname);
		
	}
	public boolean createNewFile()throws IOException
	{
		throw new IOException("Exception");
	}

	private static final long serialVersionUID = 1L;

}
