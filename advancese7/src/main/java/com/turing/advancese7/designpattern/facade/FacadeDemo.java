package com.turing.advancese7.designpattern.facade;

class ComputerFacade
{
	HardDisk disk = new HardDisk();
	Memory memory = new Memory();
	Cpu cpu = new Cpu();
	
	void start()
	{
		disk.readBootSector();
		memory.load();
		cpu.execute();
	}
}
public class FacadeDemo {
	public static void main(String[]args)
	{
		/*
		HardDisk disk = new HardDisk();
		Memory memory = new Memory();
		Cpu cpu = new Cpu();
		
		disk.readBootSector();
		memory.load();
		cpu.execute();
		*/
		ComputerFacade facade = new ComputerFacade();
		facade.start();
	}
}
