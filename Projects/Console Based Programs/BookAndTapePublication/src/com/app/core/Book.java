package com.app.core;

import java.time.LocalDate;

public class Book extends Publication{

	int pageCount;

	public Book (String title, double price, LocalDate publishDate, int ratings, int pageCount)
	{
		super(title, price, publishDate, ratings);
		this.pageCount = pageCount;
	}

	public int getPageCount()
	{
		return pageCount;
	}

	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}

	@Override
	public String toString()
	{
		return super.toString()+ "\nPageCount=" + pageCount;
	}
	
	
	
}
