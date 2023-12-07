package com.app.utils;

import com.app.core.ServicePlan;
import com.app.customExceptions.CustomerCustomExceptions;
import com.app.customExceptions.LoginExceptions;

import static com.app.tester.Tester.*;
import static com.app.fileio.FileManagement.*;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class UserBasicFunctions {

	public static void checkBalanceLimitForPlan(ServicePlan plan) throws CustomerCustomExceptions{
		if(loggedInUser.getBalance()<plan.getCost())
			throw new CustomerCustomExceptions("Your Balance is Not Sufficient!");
	}
	
	public static void checkPlanExpiry() throws CustomerCustomExceptions {
		if(loggedInUser.getExpiryDate().isAfter(LocalDate.now()))
			throw new CustomerCustomExceptions("Your Plan is Not Expired");
	}
	
	public static void validatePaySubscription() throws CustomerCustomExceptions 
	{
		checkPlanExpiry();
		checkBalanceLimitForPlan(loggedInUser.getPlan());
		loggedInUser.setBalance(loggedInUser.getBalance()-loggedInUser.getPlan().getCost());
		loggedInUser.setSubsDate(LocalDate.now());
		loadToFile();
		JOptionPane.showMessageDialog(null, "Subscription Active!");
	}
	
	public static void validateChangePlan(ServicePlan plan) throws CustomerCustomExceptions
	{
		checkBalanceLimitForPlan(plan);
		loggedInUser.setPlan(plan);
		loggedInUser.setBalance(loggedInUser.getBalance()-loggedInUser.getPlan().getCost());
		loggedInUser.setSubsDate(LocalDate.now());
		loadToFile();
		JOptionPane.showMessageDialog(null, "Plan Changed!");
	}
	

	public static void validateChangePassword(String currPass,String newPass1,String newPass2) throws CustomerCustomExceptions,LoginExceptions
	{
		
		if(!loggedInUser.getPasssword().equals(currPass))
			throw new CustomerCustomExceptions("Original Password Does Not Match!");
		
		if(!newPass1.equals(newPass2))
			throw new CustomerCustomExceptions("New Password Do Not Match Eachother!");
		
		if(newPass1.equals(loggedInUser.getPasssword()))
			throw new CustomerCustomExceptions("New Password Cannot be Same as Old Password");
			
		if (!newPass1.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{3,}$"))
			throw new LoginExceptions("New Password Must contain Lower,Upper,Numeric and a Special Character");

		
		
		loggedInUser.setPasssword(newPass1);
		loadToFile();
		JOptionPane.showMessageDialog(null, "Password Changed!");
	}
	
}
