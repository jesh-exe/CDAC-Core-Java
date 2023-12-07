package com.cust.tester;

import java.util.*;
import com.cust.core.*;


public class Tester {

	public static void menu() {
		System.out.print("\n\t\t\t\t 1.Push\n\t\t\t\t 2.Pop\n\t\t\t\t 3.Display\n\t\t\t\t 4.Back\n\t\t\t\t CHOICE: ");
	}

	
	
	public static void setStack(Object obje) {
		Scanner sc = new Scanner(System.in);
		Boolean flag1 = true;
		while (flag1) {
			System.out.println("\n\n\t\t\t\t----------In Fixed Array Stack----------");
			menu();
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.print("\t\t\t\t Enter the ID, Name, Address of Customer: ");
				Customer obj = new Customer(sc.nextInt(), sc.next(), sc.next());
				if (obje instanceof FixedStack)
					((FixedStack) obje).push(obj);
				else
					((GrowableStack) obje).push(obj);

				break;

			case 2:
				if (obje instanceof FixedStack)
					((FixedStack) obje).pop();
				else
					((GrowableStack) obje).pop();
				break;

			case 3:
				if (obje instanceof FixedStack)
					((FixedStack) obje).display();
				else
					((GrowableStack) obje).display();
				break;

			case 4:
				flag1 = false;
				break;

			default:
				System.out.println("\t\t\t\t Invalid Input");
			}
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean exit = true;
		String str = "Not Chosen";
		Scanner sc = new Scanner(System.in);

		FixedStack fs = new FixedStack();
		GrowableStack gs = new GrowableStack();

		while (exit) {

			System.out.print(
					"\n1.Fixed Array\n2.Growable Array\n3.EXIT\n" + "Current Array ---->>> " + str + "\nChoice: ");
			int choice = sc.nextInt();
			str = choice == 1 ? "Fixed Array" : choice == 2 ? "Growable Array" : "Not Chosen";

			switch (str) {
			
				case "Fixed Array":
					setStack(fs);
					break;
	
				case "Growable Array":
					setStack(gs);
					break;
	
				default:
					exit = false;
					break;
			}
			

		}
		sc.close();
	}

}
