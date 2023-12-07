package com.app.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.app.core.KYC;
import com.app.customExceptions.BankAccountExceptionAHandling;

public class KYCValidator {

	
	public static LocalDate dobCheck(String date) throws DateTimeParseException
	{
		return LocalDate.parse(date);
	}
	
	public static void phoneCheck(long phn) throws BankAccountExceptionAHandling
	{
		if(Long.toString(phn).length()!=10)
			throw new BankAccountExceptionAHandling("Phone Number Must have only 10 Digits!");
	}
	
	public static void aadharCheck(String aadhar) throws BankAccountExceptionAHandling
	{
		if(aadhar.length()!=12)
			throw new BankAccountExceptionAHandling("Aadhar Number must contain 12 Digits");
	}
	
	public static KYC validateAllKYC(String addr, long phone, String aadharNo, String dob) throws BankAccountExceptionAHandling,InterruptedException
	{
		System.out.print("\nD.O.B Check: ");
		Thread.sleep(800);
		LocalDate dobdate = dobCheck(dob);
		System.out.println("Passed");
		
		System.out.print("Aadhaar Check: ");
		Thread.sleep(800);
		aadharCheck(aadharNo);
		System.out.println("Passed");

		System.out.print("Mobile Check: ");
		Thread.sleep(800);
		phoneCheck(phone);
		System.out.println("Passed");
		return new KYC(addr, phone, aadharNo, dobdate);
	}
}
