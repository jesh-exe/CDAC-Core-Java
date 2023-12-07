package com.app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.customExceptions.SignUpExceptions;
import com.app.gui.SignUp;
import static com.app.tester.Tester.*;
import static com.app.fileio.FileManagement.*;

public class AuthenticateSignUp {
	static SignUp signUpObj = new SignUp();

	
	public static void checkMailExists(String email) throws SignUpExceptions, IOException {
		if(usersList.contains(new Customer(email)))
			throw new SignUpExceptions("Email ID Already Registered!");
	}

	
	public static double amountCheck(String amount, ServicePlan plan) throws SignUpExceptions {
		double amt = Double.parseDouble(amount);
		if (plan.getCost() > amt)
			throw new SignUpExceptions("Amount is Not Sufficient for Plan: " + plan.name());
		return amt;
	}
	

	public static LocalDate checkDate(String date) {
		return LocalDate.parse(date);
	}

	
	
	public static boolean checkSignUpCreds(String name, String email, String password, String city, String amount,String dob, String plan) {
		try {
			checkMailExists(email);
			ServicePlan planSelect = ServicePlan.valueOf(plan);
			double amt = amountCheck(amount, planSelect);
			LocalDate dobDate = checkDate(dob);
			Customer cm = new Customer(name, email, password, city, amt, dobDate, planSelect);
			
			usersList.add(cm);
			loadToFile();
			
			JOptionPane.showMessageDialog(null,"Signed Up!");
			return true;
		} catch (SignUpExceptions e) {
			JOptionPane.showMessageDialog(signUpObj.contentPane, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(signUpObj.contentPane, "Amount Must Contain Numeric Value!", "",
					JOptionPane.ERROR_MESSAGE);
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(signUpObj.contentPane, "Date of Birth is not in Proper Format!", "",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
