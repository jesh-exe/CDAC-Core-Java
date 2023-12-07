package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Publication implements Comparable<Publication>{

	int id;
	String title;
	double price;
	LocalDate publishDate;
	int ratings;
	static int idGenerator = 1000;
	
	public Publication(String title, double price, LocalDate publishDate, int ratings)
	{
		super();
		this.id = ++idGenerator;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
		this.ratings = ratings;
	}
	
	public Publication(String title)
	{
		this.title = title;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public LocalDate getPublishDate()
	{
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate)
	{
		this.publishDate = publishDate;
	}

	public int getRatings()
	{
		return ratings;
	}

	public void setRatings(int ratings)
	{
		this.ratings = ratings;
	}

	@Override
	public String toString()
	{
		System.out.println("----------------------------------------------------------");
		return "ID = " + id + "\nTitle = " + title + "\nPrice = " + price + "\nPublishDate = " + publishDate
				+ "\nRatings = " + ratings;
	}
	
	
	@Override
	public int compareTo(Publication obj)
	{
		if(obj instanceof Book)
		{
			return (-1)*this.getPublishDate().compareTo(((Book)obj).getPublishDate());
		}
		return (-1)*this.getPublishDate().compareTo(((Tape)obj).getPublishDate());
	}


	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Book)
		{
			return this.title.equals(((Book)obj).title);
		}
		
		return this.title.equals(((Tape)obj).title);
	}
	
	
}
