package utils;

import java.util.List;

import core.Customer;
import customException.CustomerCustomExceptions;

public class CustomerEntitiesValidator {

	public static void decoration(Customer cust1) throws InterruptedException
	{
		System.out.print("Logging in ");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");System.out.println("\nWelcome ,"+cust1.getFirstName());
	}
	
	
	public static void unsubscribe(List<Customer> arr, String mail) throws CustomerCustomExceptions,InterruptedException
	{
		Customer customer = new Customer(mail);
		int index = arr.indexOf(customer);
		if(index==-1)
			throw new CustomerCustomExceptions("Email does not Exists.....!!!!");
		
		arr.remove(index);
		
		System.out.print("Removing Customer ");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");System.out.println("\nRemoval Successfull....!");

	}
	
	
	public static Customer emailAndPasswordCheckExists(List <Customer> arr,String email,String password) throws CustomerCustomExceptions
	{
		Customer customer = new Customer(email);
		int index = arr.indexOf(customer);
		if(index==-1)
			throw new CustomerCustomExceptions("Email does not Exists.....!!!!");
		
		Customer cust1 = arr.get(index);
		
		
		if(!cust1.getPasssword().equals(password))
			throw new CustomerCustomExceptions("Password does not Match......!!!!");
		
		return cust1;
		
	}
	
	
	
	public static void changePassword(List<Customer> arr, String mail, String oldPass, String NewPass) throws CustomerCustomExceptions,InterruptedException
	{
		Customer passwordChangeCustomer =  emailAndPasswordCheckExists(arr, mail, oldPass);
		passwordChangeCustomer.setPasssword(NewPass);
		System.out.print("Changing Password ");
		Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");Thread.sleep(500);System.err.print(".");
		System.out.println("\nPassword Changed....!!!");
	}
	
	
}
