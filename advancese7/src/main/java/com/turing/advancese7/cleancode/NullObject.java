package com.turing.advancese7.cleancode;

import java.util.Optional;

class Employee
{
	String name;
	public Employee(String name)
	{
		this.name = name;
	}
	void display()
	{
		System.out.println("Name is "+this.name); 
	}
}
class NullEmployee extends Employee
{
	public NullEmployee()
	{
		super("");
	}
	void display()
	{
		//System.out.println("Name is "+this.name); 
	}
}
class Repository
{
	Employee findById(int id)
	{
		if(id==1)
		{
			return new Employee(null);
		}
		else
		{
			return new NullEmployee();
		}
	}
	Optional<Employee> findById2(int id)
	{
		if(id==1)
		{
			return Optional.of(new Employee("one"));
		}
		else
		{
			return Optional.empty();
		}
	}
}
public class NullObject {
	
	
	public static void main(String[]args)
	{
		Repository rep = new Repository();
		Employee emp = rep.findById(1);
		/*
		if(emp !=null)
		{
			String name = emp.name;
			if(name !=null)
			{
				System.out.println("Name "+name.toUpperCase());
			}
			
		}
		*/
		
		
		Optional<Employee> result = rep.findById2(1);
		result.map(e->e.name)
			  .map(name->name.toUpperCase())
			  .map(name->{
				  System.out.println("name is "+name); 
				  return name;
			  });
	}
}
