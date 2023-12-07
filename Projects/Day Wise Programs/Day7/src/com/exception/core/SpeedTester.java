package com.exception.core;

import come.exception.customException.SpeedCheckForVehicle;
import java.util.Scanner;

public class SpeedTester {

	public static void main(String[] args) throws SpeedCheckForVehicle{		//to handle checked exception we write throws
																			//keyword with custom exc name

		System.out.println("You are Driving a Car.....!!!");
		try(Scanner scanner = new Scanner(System.in)){						//this is try with resource 
																			//this will auto. close scanner
			int speed = scanner.nextInt();
			if(speed<40)
				throw new SpeedCheckForVehicle("Slow Speed.....!!!");		//we write throw keyword to throw the error creating new instance of custom exc. with string passed to it
			if(speed>100)
				throw new SpeedCheckForVehicle("Speed Too Fast.....!!!");
			System.out.println("Speed is Okay....!!!");
			
			
		}catch (SpeedCheckForVehicle e) {
			System.out.println(e.getMessage());
		}
	
			
	}

}
