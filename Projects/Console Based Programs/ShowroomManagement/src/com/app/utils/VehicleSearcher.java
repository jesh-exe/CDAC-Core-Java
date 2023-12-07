package com.app.utils;

import java.util.List;
import java.util.Scanner;

import com.app.core.Vehicle;
import com.app.customExceptions.VehicleExceptionHandling;

public class VehicleSearcher {
	
	public static Vehicle searchVehicle(List<Vehicle> arrList,String chasisNum) throws VehicleExceptionHandling
	{
		Vehicle v1 = new Vehicle(chasisNum);
		int index = arrList.indexOf(v1);
		if(index == -1)
			throw new VehicleExceptionHandling("Enter Valid Chasis Number.......!!");
		return arrList.get(index);
	}
}
