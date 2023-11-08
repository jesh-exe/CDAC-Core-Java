package com.app.tester;

import java.util.ArrayList;
import java.util.List;

import com.app.core.Customer;
import com.app.gui.Login;
import static com.app.fileio.FileManagement.*;
import static com.app.tester.Tester.loggedInUser;

public class Tester{

	public static List<Customer> usersList = null;
	public static Customer loggedInUser = null;

	public static void main(String[] args) {

//		System.out.println(loggedInUser.getExpiryDate().toString());
		loadtoList();
		Login login = new Login();
		login.setVisible(true);
		
	}
}