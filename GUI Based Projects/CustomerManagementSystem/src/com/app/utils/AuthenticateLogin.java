package com.app.utils;



import javax.swing.JOptionPane;

import com.app.core.Customer;
import com.app.customExceptions.LoginExceptions;
import com.app.gui.Login;
import static com.app.tester.Tester.*;


public class AuthenticateLogin {
	static Login loginObj = new Login();

	public static void checkCreds(String login, String pass) throws LoginExceptions {

		if (login.isEmpty() || pass.isEmpty())
			throw new LoginExceptions("Username/Password must Not be Empty!");
	
		if (!login.matches("^[\\w.+\\-]+@gmail\\.com$"))
			throw new LoginExceptions("Username Must Contain @gmail.com");		
		
		if (!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{3,}$"))
			throw new LoginExceptions("Password Must contain Lower,Upper,Numeric and a Special Character");
				
	}
	

	public static void matchCreds(String login, String pass) throws LoginExceptions {

		Customer obj = new Customer(login);
				if(!usersList.contains(obj))
					throw new LoginExceptions("User Not Found!");
				
				obj = usersList.get(usersList.indexOf(obj));
				
				if(!obj.getPasssword().equals(pass))
					throw new LoginExceptions("Password Does Not Match!");
				
				loggedInUser = obj;

	}

}
