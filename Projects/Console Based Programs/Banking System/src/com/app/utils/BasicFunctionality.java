package com.app.utils;

import java.time.LocalDateTime;
import java.util.Map;

import com.app.core.BankAccount;
import com.app.customExceptions.BankAccountExceptionAHandling;

public class BasicFunctionality {

	public static void display(Map<Integer, BankAccount> list) {
		for (Map.Entry<Integer, BankAccount> arr : list.entrySet()) {
			System.out.println(arr.getValue());
			if (arr.getValue().isKycDone()) {
				System.out.println(arr.getValue().getKycCheck().toString());
			}
		}
	}

	public static boolean checkBalance(BankAccount objAccount, double bal) throws BankAccountExceptionAHandling {
		if (objAccount.getBalance() < bal)
			throw new BankAccountExceptionAHandling("Balance is not Sufficient!");

		if (objAccount.getBalance() - bal < objAccount.getAccType().getLimit())
			throw new BankAccountExceptionAHandling("Account Balance Limit Not Sufficient!");

		return true;
	}

	public static void setTransactionDate(BankAccount objAccount) {
		objAccount.setLastTransDate(LocalDateTime.now());
	}

	public static void withdrawal(Map<Integer, BankAccount> mapper, int accNo, double withdraw)
			throws BankAccountExceptionAHandling {
		if (!mapper.containsKey(accNo))
			throw new BankAccountExceptionAHandling("Account Number Does Not Exists");

		BankAccount objAccount = mapper.get(accNo);

		if (checkBalance(objAccount, withdraw))
			objAccount.setBalance(objAccount.getBalance() - withdraw);

		setTransactionDate(objAccount);

	}

	public static void depositAmount(Map<Integer, BankAccount> mapper, int accNo, double deposit)
			throws BankAccountExceptionAHandling {
		if (!mapper.containsKey(accNo))
			throw new BankAccountExceptionAHandling("Account Number Does Not Exists");

		BankAccount objAccount = mapper.get(accNo);
		objAccount.setBalance(objAccount.getBalance() + deposit);

		setTransactionDate(objAccount);

	}

	public static void fundTransfer(Map<Integer, BankAccount> list, int src, int dest, double amt)
			throws BankAccountExceptionAHandling {
		withdrawal(list, src, amt);
		depositAmount(list, dest, amt);
		System.out.println("Funds Transferred!");
	}

}
