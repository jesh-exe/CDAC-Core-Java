package com.cust.utils;
import static com.cust.tester.LoginCaller.*;
import com.cust.customException.CheckValidityOfEmailId;

public class EmailCheck {

	static int counter=3;
	
	public static boolean checkEmailID(String str)
	{
		if(counter==0)
			return false;
		
		try {
			if(!str.matches("^[\\w.+\\-]+@gmail\\.com$"))
				throw new CheckValidityOfEmailId("Email ID must contain @gmail.com");
			return true;
			
		} catch (CheckValidityOfEmailId e) {
			System.out.println(e.getMessage());
			System.out.println("CHANCES LEFT: "+ --counter+"\n");
			setMail();
		}
		return false;
	}
	
}
