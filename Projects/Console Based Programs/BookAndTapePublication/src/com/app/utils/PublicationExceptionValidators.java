package com.app.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.app.core.Book;
import com.app.core.Publication;
import com.app.core.Tape;
import com.app.customExceptions.PublicationCustomExceptionsHandling;


public class PublicationExceptionValidators {

	
	public static void titleCheck(List<Publication> arr,String title) throws PublicationCustomExceptionsHandling,InterruptedException
	{
		System.out.print("\nTitle Uniqueness Check : ");
		Publication objPublication = new Publication(title);
		if(arr.contains(objPublication))
			throw new PublicationCustomExceptionsHandling("Title for the Publication Already Exists");
		Thread.sleep(700);
		System.out.println("PASSED");
	}
	
	public static LocalDate dateCheck(String date) throws DateTimeParseException,InterruptedException
	{
		System.out.print("Date Format Check : ");
		LocalDate parsedDate = LocalDate.parse(date);
		Thread.sleep(700);
		System.out.println("PASSED");
		return parsedDate;
	}
	
	public static void ratingsCheck(int ratings) throws PublicationCustomExceptionsHandling,InterruptedException
	{
		System.out.print("Ratings Limit Check : ");
		if(ratings>10 || ratings<=0)
			throw new PublicationCustomExceptionsHandling("Ratings should be within range of 1 to 10");
		
		
		Thread.sleep(700);
		System.out.println("PASSED");
	}
	
	
	
	public static Book validateBook(String title, double price, String publishDate, int ratings, int pageCount, List<Publication> arr) throws PublicationCustomExceptionsHandling,DateTimeParseException,InterruptedException 
	{
		titleCheck(arr, title);
		LocalDate date = dateCheck(publishDate);
		ratingsCheck(ratings);
		
		System.out.println("\n-----------------------Data Inserted--------------------------\n");
		
		return new Book(title, price, date, ratings, pageCount);
	}
	
	
	public static Tape validateTape(String title, double price, String publishDate, int ratings, int minutes, List<Publication> arr) throws PublicationCustomExceptionsHandling,DateTimeParseException,InterruptedException 
	{
		titleCheck(arr, title);
		LocalDate date = dateCheck(publishDate);
		ratingsCheck(ratings);
		
		System.out.println("\n-----------------------Data Inserted--------------------------\n");
		
		return new Tape(title, price, date, ratings, minutes);
	}
	
}
