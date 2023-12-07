package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Comparable<Customer>,Serializable {
	int id;
	String name;
	String email;
	String passsword;
	String city;
	double balance;
	LocalDate dobDate;
	LocalDate registerDate;
	LocalDate subsDate;
	ServicePlan plan;
	LocalDate expiryDate;
	static int idGenerator;
	

	static {
		idGenerator = 1000;
	}

	public Customer(String firstName, String email, String passsword, String city, double registrationAmount,
			LocalDate dobDate, ServicePlan plan) {
		this.name = firstName;
		this.email = email;
		this.passsword = passsword;
		this.city = city;
		this.balance = registrationAmount;
		this.dobDate = dobDate;
		this.plan = plan;
		this.registerDate = LocalDate.now();
		id = ++idGenerator;
		this.subsDate = LocalDate.now();
		if(plan.name()=="PLATINUM")
			this.expiryDate = subsDate.plusMonths(6);
		if(plan.name()=="DIAMOND")
			this.expiryDate = subsDate.plusMonths(3);
		if(plan.name()=="GOLD")
			this.expiryDate = subsDate.plusMonths(2);
		if(plan.name()=="SILVER")
			this.expiryDate = subsDate.plusMonths(1);

	}

	public Customer(int id, String name, String email, String passsword, String city, double registrationAmount,
			LocalDate dobDate, LocalDate registerDate, LocalDate subsDate, ServicePlan plan) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passsword = passsword;
		this.city = city;
		this.balance = registrationAmount;
		this.dobDate = dobDate;
		this.registerDate = registerDate;
		this.subsDate = subsDate;
		this.plan = plan;
		
		
	}
	
	public Customer(String mail) {
		email = mail;
	}

	
	
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getFirstName()
	{
		String[] firstName = this.name.split(" ");
		return firstName[0];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getSubsDate() {
		return subsDate;
	}
	
	public void setExpiryDateAfterSub(LocalDate subsDate)
	{
		if(plan.name()=="PLATINUM")
			this.expiryDate = subsDate.plusMonths(6);
		if(plan.name()=="DIAMOND")
			this.expiryDate = subsDate.plusMonths(3);
		if(plan.name()=="GOLD")
			this.expiryDate = subsDate.plusMonths(2);
		if(plan.name()=="SILVER")
			this.expiryDate = subsDate.plusMonths(1);
	}

	public void setSubsDate(LocalDate subsDate) {
		this.subsDate = subsDate;
		setExpiryDateAfterSub(subsDate);
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double registrationAmount) {
		this.balance = registrationAmount;
	}

	public LocalDate getDobDate() {
		return dobDate;
	}

	public void setDobDate(LocalDate dobDate) {
		this.dobDate = dobDate;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public static int getCounter() {
		return idGenerator;
	}

	public static void setCounter(int counter) {
		Customer.idGenerator = counter;
	}

	@Override
	public String toString() {
		return "ID = " + id + "\nName = " + name + "\nEmail = " + email + "\nCity: " + city + "\nRegistration Amount = "
				+ balance + "\nDate of Birth = " + dobDate + "\nREGISTRATION DATE: " + registerDate
				+ "\nSUBSCRIPTION DATE: " + subsDate + "\nPlan = ";
	}

	@Override
	public int compareTo(Customer anotherCust) {
		return this.email.compareTo(anotherCust.email);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Customer) {
			return this.email.equals(((Customer) obj).email);
		}
		return false;
	}

}
