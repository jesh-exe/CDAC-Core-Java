package tester;

import java.util.ArrayList;
import java.util.Scanner;

import static utils.CustomerExceptionValidator.*;
import static utils.CustomerEntitiesValidator.*;
import static utils.RegexPatternCheck.*;

import core.Customer;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			ArrayList<Customer> custList = new ArrayList<>();
			boolean exit = true;

			while (exit) {
				
				System.out.print( "+----------------------------------------+\n" 
								+ "|       Welcome to CMS Portal            |\n"
								+ "|                                        |\n"
								+ "| 1. Sign Up                             |\n"
								+ "| 2. Sign In                             |\n"
								+ "| 3. Change Password                     |\n"
								+ "| 4. UnSubscribe                         |\n"
								+ "| 5. Display All Customers               |\n"
								+ "| 6. EXIT                                |\n"
								+ "+----------------------------------------+\n"
								+ " Choice: ");

				try {
					
					switch (sc.nextInt()) 
					{
					case 1:
						System.out.print("Enter Email: ");
						String mailCheckString = new String(checkEmailID(sc.next()));
						System.out.print("Enter Password: ");
						String passCheckString = new String(checkPassword(sc.next()));
						System.out.println("Enter Details [FirstName, LastName, Registration Amount, D.O.B [YYYY-MM-DD], ServicePlan");
						custList.add(validateAll(sc.next(), sc.next(), mailCheckString, passCheckString, sc.nextDouble(), sc.next(), sc.next(), custList));
						break;
						
					case 2:
						System.out.print("Enter Email: ");
						mailCheckString = new String(checkEmailID(sc.next()));
						System.out.print("Enter Password: ");
						passCheckString = new String(checkPassword(sc.next()));
						Customer customer = emailAndPasswordCheckExists(custList, mailCheckString, passCheckString);
						decoration(customer);
						break;
						
						
					case 3:
						System.out.print("Enter Email: ");
						mailCheckString = new String(checkEmailID(sc.next()));
						System.out.print("Enter Password: ");
						passCheckString = new String(checkPassword(sc.next()));
						System.out.print("Enter Password: ");
						String passCheckString1 = new String(checkPassword(sc.next()));
						
						changePassword(custList, mailCheckString, passCheckString, passCheckString1);
						break;
						
						
					case 4:
						System.out.print("Enter Mail : ");
						unsubscribe(custList, sc.next());
						break;
						
						
					case 5:
						for (Customer c : custList) {
							System.out.println(c);
						}
						break;
						
					case 6:
						exit=false;
						break;
						
						
					default:
						break;
					}
					

				} catch (Exception e) {
					System.err.println("\n"+e.getMessage());
					System.out.println("Try Again...!\n");
					sc.nextLine();
				}

			}

		}

	}

}
