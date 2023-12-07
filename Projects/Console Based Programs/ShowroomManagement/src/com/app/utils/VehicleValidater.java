package com.app.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.app.core.Color;
import com.app.core.Vehicle;
import com.app.customExceptions.VehicleExceptionHandling;

public class VehicleValidater {

	
	public static void chassisChecker(List<Vehicle> arr, String chasisNum) throws InterruptedException,VehicleExceptionHandling
	{
			Vehicle objVehicle = new Vehicle(chasisNum);
			if(arr.contains(objVehicle))
				throw new VehicleExceptionHandling("Vehicle with Same chassis Number Already Exists...!!!");
			System.out.print("\nChassis Check: ");
			Thread.sleep(800);
			System.err.print("PASSED");
			Thread.sleep(500);
	}
	
	
	
	public static LocalDate dateChecker(String manufactureDate) throws DateTimeParseException,VehicleExceptionHandling, InterruptedException
	{
		LocalDate manuDate = LocalDate.parse(manufactureDate);
		LocalDate expDate = LocalDate.of(2020,1,1);
		if(manuDate.isBefore(expDate))
			throw new VehicleExceptionHandling("Manufacturing Date is before 01-01-2001...!!!!");
		System.out.print("\nDate Check: ");
		Thread.sleep(800);
		System.err.println("PASSED");
		Thread.sleep(500);
		return manuDate;
	}
	
	
	
	public static Color checkColor(String color) throws IllegalArgumentException 
	{
		return Color.valueOf(color.toUpperCase());
	}
	
	
	
	public static Vehicle validateAllEntities(String chasisNum, String color, String manufactureDate, int basePrice, String company, List<Vehicle> arrList) throws VehicleExceptionHandling,IllegalArgumentException,DateTimeParseException,InterruptedException
	{
		chassisChecker(arrList, chasisNum);
		LocalDate date = dateChecker(manufactureDate);
		Color color2 = checkColor(color);
		System.err.print("\n-----------------------Vehicle Added Successfully------------------------\n\n");
		return new Vehicle(chasisNum, color2, date, basePrice, company);
		
	}
	
	public static void decor()
	{
		System.out.println("-----------------------------------------------------------------------");
	}
	
}







