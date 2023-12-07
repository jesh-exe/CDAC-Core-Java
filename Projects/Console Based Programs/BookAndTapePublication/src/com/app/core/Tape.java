package com.app.core;

import java.time.LocalDate;

public class Tape extends Publication {

	int minutes;

	public Tape(String title, double price, LocalDate publishDate, int ratings, int minutes)
	{
		super(title, price, publishDate, ratings);
		this.minutes = minutes;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	@Override
	public String toString()
	{
		return super.toString() +"\nMinutes = "+ minutes;
	}
	
	

	
	
	
}
