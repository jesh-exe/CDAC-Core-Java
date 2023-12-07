package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import custom_exceptions.CustomerHandlingException;

public class CustomerValidationRules {
//add a method for checking dup customers
	public static void checkForDup(String email, Map<String, Customer> custMap) throws CustomerHandlingException {
		if (custMap.containsKey(email))
			throw new CustomerHandlingException("Dup email !!!!!");
		System.out.println("no dups !");// added only for understanding
	}

	// add a static method to validate the service plan
	public static ServicePlan parseAndValidatePlan(String plan) throws IllegalArgumentException {
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	// add a static method to validate reg amount as per chosen plan
	public static void validateRegAmount(double regAmount, ServicePlan plan) throws CustomerHandlingException {
		if (regAmount != plan.getCostOfPlan())
			throw new CustomerHandlingException("Reg amount doesn't match with the chosen plan !!!!!!");
	}

	// add a method to parse DoB
	public static LocalDate parseDob(String date) throws DateTimeParseException {
		return LocalDate.parse(date);
	}

	// add a method to invoke all validation rules
	public static Customer validateAllInputs(String firstName, String lastName, String email, String password,
			double regAmount, String dob, String plan, Map<String, Customer> map) throws CustomerHandlingException {
		checkForDup(email, map);
		ServicePlan validPlan = parseAndValidatePlan(plan);
		validateRegAmount(regAmount, validPlan);
		LocalDate dob2 = parseDob(dob);
		return new Customer(firstName, lastName, email, password, regAmount, dob2, validPlan);
	}

	// add a method for signin
	public static Customer authenticateCustomer(String email, String pwd, Map<String, Customer> customers)
			throws CustomerHandlingException {
		Customer customer = customers.get(email);
		if (customer == null)
			throw new CustomerHandlingException("Invalid Email !!!");
		// => email ok --chk pwd
		if (!customer.getPassword().equals(pwd))
			throw new CustomerHandlingException("Invalid Password!!!");
		return customer;

	}

}
