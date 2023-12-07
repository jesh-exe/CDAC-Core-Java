package com.cust.utils;

import com.cust.customException.CheckValidityOfPassword;
import com.cust.tester.LoginCaller;

public class PasswordCheck {

	static int counter = 3;

	public static boolean checkPassword(String str)
	{
		if (counter == 0)
		{
			return false;
		}
		try
		{
			if (!str.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{3,}$"))
				throw new CheckValidityOfPassword(
						"Password must contain atleast a Lower, Upper, Numeric and a Special Character");
			return true;
		} catch (CheckValidityOfPassword e)
		{
			// TODO: handle exception
			System.out.println("\n" + e.getMessage());
			System.out.println("CHANCES LEFT : " + counter-- + "\n");
			LoginCaller.setPassword();
		}
		return false;
	}

}
