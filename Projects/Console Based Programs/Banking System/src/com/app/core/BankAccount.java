package com.app.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankAccount {

	private int accNo;
	private String firstName;
	private String lastName;
	private AccountTypes accType;
	private double balance;
	private LocalDate creationDate;
	private LocalDateTime lastTransDate;
	private boolean isActive;
	public static int accNoGenerator = 1000;
	private KYC kycCheck;
	private boolean kycDone;

	public BankAccount(String firstName, String lastName, AccountTypes accType, double balance) {
		this.accNo = ++accNoGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accType = accType;
		this.balance = balance;
		this.creationDate = LocalDate.now();
		this.isActive = true;
		kycDone = false;
		kycCheck = null;
	}

	public KYC getKycCheck() {
		return kycCheck;
	}

	public void setKycCheck(KYC kycCheck) {
		this.kycCheck = kycCheck;
	}

	public boolean isKycDone() {
		return kycDone;
	}

	public void setKycDone(boolean kycDone) {
		this.kycDone = kycDone;
	}

	public int getAccNo() {
		return accNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AccountTypes getAccType() {
		return accType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public LocalDateTime getLastTransDate() {
		return lastTransDate;
	}

	public void setLastTransDate(LocalDateTime lastTransDate) {
		this.lastTransDate = lastTransDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		String isKycDone = this.isKycDone() == true ? "Done" : "Not Done";
		System.out.println("_________________________________________________________________________");
		return "Account Number: " + accNo + "\nName:  " + firstName + " " + lastName + "\nAccount Type: " + accType
				+ "\nBalance: " + balance + "\nAccount Creation Date: " + creationDate + "\nLast Transaction Date: "
				+ lastTransDate + "\nKYC: " + isKycDone;
	}

}
