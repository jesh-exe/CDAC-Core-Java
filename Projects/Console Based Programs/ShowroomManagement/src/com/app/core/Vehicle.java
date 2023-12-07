package com.app.core;

import java.time.LocalDate;

public class Vehicle {
	private String chasisNum;
	private Color color;
	private LocalDate manufactureDate;
	private int basePrice;
	private String company;
	private boolean available;
	
	public Vehicle(String chasisNum, Color color, LocalDate manufactureDate, int basePrice, String company)
	{
		super();
		this.chasisNum = chasisNum;
		this.color = color;
		this.manufactureDate = manufactureDate;
		this.basePrice = basePrice;
		this.company = company;
		this.available = true;
	}
	
	public Vehicle(String chasisNum)
	{
		this.chasisNum = chasisNum;
	}

	public String getChasisNum()
	{
		return chasisNum;
	}

	public void setChasisNum(String chasisNum)
	{
		this.chasisNum = chasisNum;
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public LocalDate getManufactureDate()
	{
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate)
	{
		this.manufactureDate = manufactureDate;
	}

	public int getBasePrice()
	{
		return basePrice;
	}

	public void setBasePrice(int basePrice)
	{
		this.basePrice = basePrice;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public boolean isAvailable()
	{
		return available;
	}

	public void setAvailable(boolean available)
	{
		this.available = available;
	}

	@Override
	public String toString()
	{
		return "Chasis Number = " + chasisNum +"\n"+ color + "\nManufacture Date = " + manufactureDate
				+ "\nNet Price = " + (basePrice + color.getAdditionalCost()) + "\nCompany = " + company;
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Vehicle)
			return this.chasisNum.equals(((Vehicle)obj).chasisNum);
		return false;
	}
	
	
	
	
	
	
}
