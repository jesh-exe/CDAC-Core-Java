package com.app.core;

import java.time.LocalDate;

/*
 * 1. Customer class (core class)
state  : customer id(int) ,first name, last name (string),email(string),password(string),
registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
idGenerator : static 
Must generate customer ids automatically : auto increment)
PK(UID) : email
 */
public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idGenerator;
	public Customer(String firstName, String lastName, String email, String password, double regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
		this.customerId=++idGenerator;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}
	//equals / hashCode : none ! since String : Key , it has alrdy imple the contract
	public String getEmail() {
		return email;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public LocalDate getDob() {
		return dob;
	}
	public ServicePlan getPlan() {
		return plan;
	}
	
	
	
}
