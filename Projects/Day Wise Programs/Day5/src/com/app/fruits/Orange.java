package com.app.fruits;

public class Orange extends Fruit {

	public Orange(String color, double weight, String name)
	{
		super(color, weight, name);
	}

	@Override
	public String taste()
	{
		return "Sour..!";
	}

	final public void juice()
	{
		System.out.println("Extracting Juice of " + getName() + " Weighing " + getWeight());
	}

}
