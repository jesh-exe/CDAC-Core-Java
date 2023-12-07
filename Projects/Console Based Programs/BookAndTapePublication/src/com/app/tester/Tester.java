package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.core.Book;
import com.app.core.Publication;
import com.app.core.Tape;
import com.app.utils.SortByRating;

import static com.app.utils.PublicationExceptionValidators.*;
import static com.app.utils.BasicFunctionality.*;

public class Tester {

	public static void main(String[] args) throws InterruptedException
	{
		
		try(Scanner sc = new Scanner(System.in)){
			
			List<Publication> list = new ArrayList<>();
			boolean exit=false;
			list.add(new Book("Book100", 1400, LocalDate.parse("2021-01-01"), 9, 200));
			list.add(new Tape("Tape100", 1800, LocalDate.parse("2023-11-01"), 5, 40));
			list.add(new Book("Book200", 1100, LocalDate.parse("2018-10-17"), 8, 800));
			list.add(new Book("Book300", 1000, LocalDate.parse("2001-08-01"), 2, 200));
			list.add(new Tape("Tape200", 1900, LocalDate.parse("2018-10-17"), 1, 50));
			list.add(new Book("Book400", 1460, LocalDate.parse("2023-06-01"), 10, 800));
			
			while(!exit)
			{
				System.out.print("\n\n+-------------------------------------------------------------+\n"
								+"|                  Book and Tape Publication                  |\n"
								+"|                                                             |\n"
								+"|1. Publish Book                                              |\n"
								+"|2. Publish Tape                                              |\n"
								+"|3. Desc Order of Publish Date                                |\n"
								+"|4. List Top 5 Publications of Current Year by ratings        |\n"
								+"|5. Remove all publications which are 5 years old             |\n"
								+"|6. EXIT                                                      |\n"
								+"+-------------------------------------------------------------+\n"
								+ "CHOICE : ");

				try
				{
					switch (sc.nextInt())
					{
					
					case 1:
						System.out.println("\nEnter Title, Price, Date, Rating, PageCount:");
						list.add(validateBook(sc.next(), sc.nextDouble(), sc.next(), sc.nextInt(), sc.nextInt(), list));
						break;
						
						
					case 2:
						System.out.println("\nEnter Title, Price, Date, Rating, Minutes:");
						list.add(validateTape(sc.next(), sc.nextDouble(), sc.next(), sc.nextInt(), sc.nextInt(), list));
						break;
						
						
					case 3:
						Collections.sort(list);
						display(list);
						break;
						
						
					case 4:
						List<Publication> tempList = topFivePublications(list);
						Collections.sort(tempList, new SortByRating());
						display(tempList);
						break;
						
						
					case 5:
						removeFiveYearsOldPublications(list);
						display(list);
						break;

						
					default:
						break;
						
					}
				} catch (Exception e)
				{
					Thread.sleep(700);
					System.out.println("FAILED"+"\n\nReason: "+e.getMessage()+"\nPlease Try Again!\n");
//					System.err.println("\nReason: "+e.getMessage());
//					System.err.println("Please Try Again!\n");
				}
				
				
			}
			
			
		}
		
	}
	
}
