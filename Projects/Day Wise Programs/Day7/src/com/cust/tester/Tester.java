package com.cust.tester;

import java.util.Scanner;
import com.cust.core.*;
import com.cust.customException.CheckValidityOfPassword;

public class Tester {

	static Scanner sc = new Scanner(System.in);
	static Stack objectStack = null;
	static int flag = 0;
	static int enter = 0;
	static int flag2 = 0;
	static boolean exit = true;
	static String name_login;
	static String pass_login;

	public static void main(String[] args) throws CheckValidityOfPassword
	{
		LoginCaller.menu_login();
		sc.close();
	}

}
