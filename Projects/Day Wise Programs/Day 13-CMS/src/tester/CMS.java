package tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Customer;

import custom_exceptions.CustomerHandlingException;

import static utils.CustomerValidationRules.*;

public class CMS {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// D.S : exam tip : start with populated sample data
			Map<String, Customer> customers = new HashMap<>();
			while (!exit) {
				System.out.println("1. SignUP 2. Signin 3.Change Password 4.Un subscribe 0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // reg
						System.out.println(
								"Enter firstName,  lastName,  email,  password, regAmount,  dob(yr-mon-day),  plan");
						Customer customer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.put(customer.getEmail(), customer);
						System.out.println("customer signed up !");
						break;
					case 2: // sign in
						System.out.println("Enter email n pwd");
						customer=authenticateCustomer(sc.next(), sc.next(), customers);
						System.out.println("Login successful , your details " + customer);

						break;
					case 3:

						break;
					case 4:

						break;

					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}

		}

	}

}
