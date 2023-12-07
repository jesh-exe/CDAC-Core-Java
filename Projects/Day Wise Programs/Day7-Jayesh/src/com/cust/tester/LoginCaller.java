package com.cust.tester;

import static com.cust.utils.PasswordCheck.checkPassword;

import com.cust.customException.CheckValidityOfEmailId;

import static com.cust.utils.EmailCheck.*;

public class LoginCaller {

	public static void setPassword()
	{
		System.out.print("Enter Password: ");
		Tester.pass_login = Tester.sc.next();
		if (checkPassword(Tester.pass_login))
		{
			System.out.println("\nLogged in to the System");
			StackCallerMain.menu_main();
		}
	}
	
	public static void setMail()
	{
		System.out.print("Enter Mail-ID: ");
		Tester.name_login = Tester.sc.next();
		if(checkEmailID(Tester.name_login))
		{
			setPassword();
		}
	}

	static void menu_login()
	{
		System.out.println("-----------Welcome to the Program-------------");
		System.out.print("\n1.Login\n2.Sign-up\n\nCHOICE: ");
		switch (Tester.sc.nextInt())
		{
		case 1:
			setMail();
			System.out.println("END OF PROGRAM........");
			break;

		default:
			break;
		}
	}

}
