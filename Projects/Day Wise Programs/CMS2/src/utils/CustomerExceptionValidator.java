package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;


import core.*;
import customException.CustomerCustomExceptions;

public class CustomerExceptionValidator {

	public static void emailCheck(List <Customer> arr,String email) throws CustomerCustomExceptions,InterruptedException
	{
		Customer customer = new Customer(email);
		if(arr.contains(customer))
			throw new CustomerCustomExceptions("Email Already exists....!!!!");
		
		System.out.print("Email Check: ");
		Thread.sleep(1000);
		System.err.println("PASSED");
	}
	
	
	public static ServicePlan planCheck(String plan) throws IllegalArgumentException
	{
		return ServicePlan.valueOf(plan.toUpperCase());
	}
	
	
	public static void amountCheck(double amount,ServicePlan plan) throws CustomerCustomExceptions,InterruptedException
	{
		if(plan.getCost()>amount)
			throw new CustomerCustomExceptions("Amount is not Sufficient for the Plan........!!!!");
		
		System.out.print("Amount Check: ");
		Thread.sleep(1000);
		System.err.println("SUFFICIENT");
	}
	
	
	public static LocalDate dateCheck(String date) throws DateTimeParseException 
	{
		LocalDate dob = LocalDate.parse(date);
		return dob;
	}
	
	
	public static Customer validateAll(String firstName, String lastName, String email, String passsword, double registrationAmount,String dobDate, String plan,List<Customer> arr) throws CustomerCustomExceptions,InterruptedException,DateTimeParseException
	{
		emailCheck(arr, email);
		ServicePlan planConvert = planCheck(plan);
		amountCheck(registrationAmount, planConvert);
		LocalDate dob = dateCheck(dobDate);
		System.out.println("----------------------------Customer Registered-------------------------");
		return new Customer(firstName, lastName, email, passsword, registrationAmount, dob, planConvert);
		
	}
	
}
