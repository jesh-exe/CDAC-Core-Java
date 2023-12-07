package com.cust.tester;

import com.cust.core.*;
import static com.cust.tester.Tester.*;

public class StackCallerMain {

	public static void menu_main()
	{

		while (exit)
		{

			System.out.print("\n1.Fixed Array\n2.Growable Array\n3.Push\n4.Pop\n5.Display\n6.EXIT\nCHOICE: ");
			int choice = sc.nextInt();

			switch (choice)
			{

			case 1:
				if (enter == 2)
				{
					System.out.println("You are already in Growable Array");
					break;
				}
				if (enter == 1 || flag == 0)
				{
					flag = 1;
					enter = 1;
					if (flag2 == 0) objectStack = new FixedStack();
					else System.out.println("Already Stack Selected....!!!");
					flag2 = 1;
					System.out.println("\n----------------Inside FIXED STACK--------------------");
				}
				else
				{
					System.out.println("Please select a Array...!");
				}
				break;

			case 2:
				if (enter == 1)
				{
					System.out.println("You are already in Fixed Array");
					break;
				}
				if (enter == 2 || flag == 0)
				{
					flag = 1;
					enter = 2;
					if (flag2 == 0) objectStack = new GrowableStack();
					else System.out.println("Already Stack Selected....!!!");
					flag2 = 1;
					System.out.println("\n----------------Inside GROWABLE STACK--------------------");
				}
				else
				{
					System.out.println("Please select a Array...!");
				}
				break;

			case 3:
				if(objectStack instanceof FixedStack)
					System.out.println("-------------PUSH in FIXED STACK-------------");
				else
					System.out.println("-------------PUSH in GROWABLE STACK-------------");
					
				System.out.print("Enter ID, NAME, ADDRESS : ");
				Customer customer1 = new Customer(sc.nextInt(), sc.next(), sc.next());
				objectStack.push(customer1);
				break;

			case 4:
				if(objectStack instanceof FixedStack)
					System.out.println("-------------POP in FIXED STACK-------------");
				else
					System.out.println("-------------POP in GROWABLE STACK-------------");
				
				objectStack.pop();
				break;

			case 5:
				if(objectStack instanceof FixedStack)
					System.out.println("-------------DISPLAY ELEMENTS OF FIXED STACK-------------");
				else
					System.out.println("-------------DISPLAY ELEMENTS OF GROWABLE STACK-------------");
				objectStack.display();
				break;

			case 6:
			default:
				System.exit(0);
				break;
			}

		}

	}
}
