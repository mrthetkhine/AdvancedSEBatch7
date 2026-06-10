package com.turing.advancese7.tdd;

import java.io.File;

import org.junit.jupiter.api.Test;

public class CrashTest {

	@Test
	void testCrash()
	{
		try
		{
			File file = new FullFile("demo.txt");
			file.createNewFile();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
