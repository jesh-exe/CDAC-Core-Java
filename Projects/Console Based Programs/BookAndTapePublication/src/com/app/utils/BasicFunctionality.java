package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.core.Publication;

public class BasicFunctionality {

	
	public static void display(List<Publication> arr)
	{
		for (Publication publication : arr)
		{
			System.out.println(publication);
		}
	}
	
	
	public static List<Publication> topFivePublications(List<Publication> list)
	{
		List<Publication> tempList = new ArrayList<Publication>();
		String currDate = Integer.toString(LocalDate.now().getYear());
		for (Publication pub : list)
		{
			if(Integer.toString(pub.getPublishDate().getYear()).equals(currDate))
			{
				tempList.add(pub);
			}
		}
		return tempList;
	}
	
	public static void removeFiveYearsOldPublications(List<Publication> list)
	{
		LocalDate currentdate = LocalDate.now().minusYears(5);
		Iterator<Publication> itr = list.iterator();
		while(itr.hasNext())
		{
			Publication obj = itr.next();
			if(obj.getPublishDate().equals(currentdate))
			{
				itr.remove();
			}
		}
	}
	
	
	
	
}
