package com.app.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.customExceptions.CustomerCustomExceptions;

public class CustomerExceptionValidator {

	public static void emailCheck(List <Customer> customerList,String email) throws CustomerCustomExceptions,InterruptedException
	{
		Customer customer = new Customer(email);
		if(customerList.contains(customer))
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
	
	
	public static LocalDate dateCheck(String date) throws DateTimeParseException , InterruptedException
	{
		LocalDate dob = LocalDate.parse(date);
		System.out.print("Date Check: ");
		Thread.sleep(1000);
		System.err.println("PASSED");
		return dob;
	}
	
	
	public static Customer validateAll(String name, String email,String passsword,String city, double registrationAmount,String dobDate, String plan,String regisDate,String subsDate,List<Customer> customerList) throws CustomerCustomExceptions,InterruptedException,DateTimeParseException
	{
		emailCheck(customerList, email);
		ServicePlan planConvert = planCheck(plan);
		amountCheck(registrationAmount, planConvert);
		LocalDate dob = dateCheck(dobDate);
		System.out.println("----------------------------Customer Registered-------------------------");
		return new Customer(name,email, passsword, city,registrationAmount, dob, planConvert);
		
	}
	
}
