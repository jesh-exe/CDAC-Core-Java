package utils;

import customException.CustomerCustomExceptions;

public class RegexPatternCheck {

	public static String checkPassword(String str) throws CustomerCustomExceptions
	{

		if (!str.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{3,}$"))
			throw new CustomerCustomExceptions(
					"Password must contain atleast a Lower, Upper, Numeric and a Special Character");

		return str;
	}

	public static String checkEmailID(String str) throws CustomerCustomExceptions
	{

		if (!str.matches("^[\\w.+\\-]+@gmail\\.com$"))
			throw new CustomerCustomExceptions("Email ID must contain @gmail.com");
		
		return str;

	}

}
