package com.app.fruits;

public class Apple extends Fruit {

	public Apple(String color, double weight, String name)
	{
		super(color, weight, name);
	}

	@Override
	public String taste()
	{
		return "Sweet and Sour..!";
	}

	final public void jam()
	{
		System.out.println("Making Jam of " + getName());
	}

}
