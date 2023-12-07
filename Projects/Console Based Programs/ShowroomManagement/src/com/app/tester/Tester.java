package com.app.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Vehicle;

import static com.app.utils.VehicleValidater.*;
import static com.app.utils.VehicleSearcher.*;

public class Tester {

	public static void main(String[] args)
	{

		try(Scanner sc = new Scanner(System.in)){
			
			List<Vehicle> vehicleArr = new ArrayList<>();
			boolean exit = false;
			while(!exit)
			{
				System.out.print( "+----------------------------------------+\n"
								+ "|       Welcome to Showroom Sir!         |\n"
								+ "|                                        |\n"	
								+ "| 1. Add Vehicle                         |\n"
								+ "| 2. Display All Vehicle                 |\n"
								+ "| 3. Get Specific Vehicle Details        |\n"
								+ "| 4. Apply Discount                      |\n"
								+ "| 5. EXIT                                |\n"
								+ "|                                        |\n"
								+ "+----------------------------------------+\n"
								+ "Choice: ");
				try
				{
					switch (sc.nextInt())
					{
					case 1:
						System.out.println("\nEnter Vehicle Detail [Chassis No, Color, Manufactured Date[YYYY-MM-DD], Price, Company]");
						vehicleArr.add(validateAllEntities(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.next(), vehicleArr));
						break;
					
					
					case 2:
						System.out.println("\nDetails of All Vehicles");
						for (Vehicle vehicle : vehicleArr)
						{
							decor();
							System.out.println(vehicle);
							decor();
						}
						System.out.println();
						break;
					
						
					case 3:
						System.out.print("Enter Chasis Number: ");
						String chassiString = sc.next();
						System.out.println("\nDetail of the Vehicle");
						decor();
					 	System.out.println(searchVehicle(vehicleArr, chassiString));
					 	decor();
					 	System.out.println();
						break;
					
					case 4:
						System.out.print("Enter Chasis Number: ");
						Vehicle vehicle = searchVehicle(vehicleArr, sc.next());
						System.out.print("Enter Discount Amount : ");
						int discount = sc.nextInt();
						vehicle.setBasePrice((vehicle.getBasePrice()-discount));
						System.out.println("--------------------------------Price Updated-----------------------------");
						break;
					
					case 5:
						System.err.println("\n\t\t\t\tEND OF PROGRAM");
						exit = true;
						break;

					default:
						break;
					}
				} catch (Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println("Try Again");
					sc.nextLine();
				}
				
			}
			
			
		}
		
	}

}
