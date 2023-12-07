package com.exception.core;

import come.exception.customException.SpeedCheckForVehicle;
import come.exception.customException.VehicleLicenseValidater;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SpeedTester {

	public static void main(String[] args) throws SpeedCheckForVehicle,ParseException,VehicleLicenseValidater{		//to handle checked exception we write throws
																			//keyword with custom exc name
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); 

		System.out.println("You are Driving a Car.....!!!");
		try(Scanner scanner = new Scanner(System.in)){						//this is try with resource 
																			//this will auto. close scanner
			int speed = scanner.nextInt();
			if(speed<40)
				throw new SpeedCheckForVehicle("Slow Speed.....!!!");		//we write throw keyword to throw the error creating new instance of custom exc. with string passed to it
			if(speed>100)
				throw new SpeedCheckForVehicle("Speed Too Fast.....!!!");
			System.out.println("Speed is Okay....!!!");
			
			System.out.print("Enter your License Expiry Date (DD/MM/YYYY) : ");
			String dateexp = scanner.next();
			
			Date currdate = new Date();
			String datecurr = sdf.format(currdate);
			
			if(sdf.parse(datecurr).before(sdf.parse(dateexp)))
				throw new VehicleLicenseValidater("License Expired.......!");
			System.out.println("License is Okay");
			
		}catch (SpeedCheckForVehicle e) {
			System.out.println(e.getMessage());
		}
		catch (VehicleLicenseValidater ef) {
			// TODO: handle exception
			System.out.println(ef.getMessage());
		}
	
			
	}

}
