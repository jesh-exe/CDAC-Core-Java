package com.app.utils;

import java.time.LocalDate;
import java.util.Comparator;

import com.app.core.Publication;

public class SortByRating implements Comparator<Publication>{
	
	@Override
	public int compare(Publication obj1, Publication obj2)
	{
		if(obj1.getRatings()>obj2.getRatings())
			return 1;
		else if(obj1.getRatings()<obj2.getRatings())
			return -1;
		return 0;
	}
	
}
