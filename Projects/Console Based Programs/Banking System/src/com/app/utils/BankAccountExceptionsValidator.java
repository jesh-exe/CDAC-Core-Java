package com.app.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

import com.app.core.AccountTypes;
import com.app.core.BankAccount;
import com.app.customExceptions.BankAccountExceptionAHandling;

public class BankAccountExceptionsValidator {

	public static BankAccount accNumberCheck(int accno, Map<Integer, BankAccount> list)
			throws BankAccountExceptionAHandling {
		if (!list.containsKey(accno))
			throw new BankAccountExceptionAHandling("No such Account Exists!");

		return list.get(accno);

	}

	public static AccountTypes accTypeCheck(String accType) throws IllegalArgumentException {
		return AccountTypes.valueOf(accType.toUpperCase());
	}

	public static LocalDate checkDate() throws DateTimeParseException, IllegalArgumentException {
		LocalDate date2 = LocalDate.now();
		return date2;
	}

	public static void checkBalanceLimit(double balance, AccountTypes type)
			throws BankAccountExceptionAHandling, InterruptedException {
		System.out.print("Balance Check: ");
		Thread.sleep(800);
		if (balance < type.getLimit())
			throw new BankAccountExceptionAHandling("Initial Deposit Should be greater than " + type.getLimit()
					+ " to create " + type.name() + " Account");

		System.out.println("PASSED");
	}

	public static BankAccount kycCheck(int accno, Map<Integer, BankAccount> list) throws BankAccountExceptionAHandling {
		BankAccount obj = accNumberCheck(accno, list);
		if (!obj.isKycDone())
			throw new BankAccountExceptionAHandling("Your KYC is not Done! Please Complete KYC First");
		return obj;
	}

	public static BankAccount validateAll(String firstName, String lastName, String accType, double balance)
			throws DateTimeParseException, BankAccountExceptionAHandling, IllegalArgumentException,
			InterruptedException {

		System.out.print("\nAccount Type Check: ");
		Thread.sleep(800);
		AccountTypes type = accTypeCheck(accType);
		System.out.println("PASSED");

		checkBalanceLimit(balance, type);
		LocalDate creationDate2 = checkDate();

		System.out.println("Setting up Account....");
		Thread.sleep(800);
		return new BankAccount(firstName, lastName, type, balance);
	}

}
