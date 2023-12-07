package com.app.fruits;

public abstract class Fruit {

	private String color;
	private double weight;
	private String name;
	private boolean fresh;

	public Fruit(String color, double weight, String name)
	{
		this.color = color;
		this.weight = weight;
		this.name = name;
		fresh = true;
	}

	// GETTERS
	final public String getColor()
	{
		return color;
	}

	final public String getName()
	{
		return name;
	}

	final public double getWeight()
	{
		return weight;
	}

	final public boolean getFresh()
	{
		return fresh;
	}

	// SETTERS
	final public void setFresh(boolean flag)
	{
		this.fresh = flag;
	}

	final public String toString()
	{
		return "Name: " + name + "\nColor: " + color + "\nWeight: " + weight;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this instanceof Orange)
		{
			((Fruit) obj).setFresh(false);
			return true;
		}
		return false;
	}

	public abstract String taste();

}
