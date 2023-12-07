package com.app.tester;

import static com.app.utils.BankAccountExceptionsValidator.accNumberCheck;
import static com.app.utils.BankAccountExceptionsValidator.kycCheck;
import static com.app.utils.BankAccountExceptionsValidator.validateAll;
import static com.app.utils.BasicFunctionality.depositAmount;
import static com.app.utils.BasicFunctionality.display;
import static com.app.utils.BasicFunctionality.fundTransfer;
import static com.app.utils.BasicFunctionality.withdrawal;
import static com.app.utils.KYCValidator.validateAllKYC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.core.AccountTypes;
import com.app.core.BankAccount;
import com.app.core.KYC;

public class Tester {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			Map<Integer, BankAccount> listMap = new HashMap<>();
			
			listMap.put(1001, new BankAccount("Jayesh", "Murodiya", AccountTypes.SAVINGS, 100000));
			listMap.put(1002, new BankAccount("Mandeep", "Sharma", AccountTypes.FD, 160000));
			listMap.put(1003, new BankAccount("Aishwarya", "Chaudhar", AccountTypes.CURRENT, 90000));
			listMap.put(1004, new BankAccount("Trupti", "Jawale", AccountTypes.SAVINGS, 195700));
			listMap.put(1005, new BankAccount("Arpit", "Patidar", AccountTypes.SAVINGS, 145500));
			listMap.put(1006, new BankAccount("Pushkar", "Suke", AccountTypes.CURRENT, 187400));
			
			boolean exit = false;
			while (!exit) {
				
				System.out.print( " ________________________________________\n" 
								+ "|       Welcome to Banking Portal        |\n"
								+ "|                                        |\n"
								+ "|  1. Create Account                     |\n"
								+ "|  2. Withdraw Amount                    |\n"
								+ "|  3. Deposit Amount                     |\n"
								+ "|  4. KYC Validation                     |\n"
								+ "|  5. Fund Transfer                      |\n"
								+ "|  6. Check Balance                      |\n"
								+ "|  7. Delete Accounts with Trans Date<1Y |\n"
								+ "|  8. Display All Accounts               |\n"
								+ "|  9. Display Specific Account           |\n"
								+ "| 10. Sort by ID                         |\n"
								+ "|  0. EXIT                               |\n"
								+ "|________________________________________|\n"
								+ " Choice: ");
				
				try {
					switch (scanner.nextInt()) {
					case 1:
						System.out.println("Enter First Name,Last Name,Account Type, Deposit Amount: ");
						listMap.put(BankAccount.accNoGenerator + 1,
								validateAll(scanner.next(), scanner.next(), scanner.next(), scanner.nextDouble()));
						System.out.println("\nAccount Created Successfully!");
						System.out.println("ACCOUNT NUMBER ALLOCATED : " + BankAccount.accNoGenerator + "\n");
						break;

					case 2:
						System.out.print("\nEnter Account Number, Amount(Withdraw): ");
						withdrawal(listMap, scanner.nextInt(), scanner.nextDouble());
						System.out.println("Money Withrawed!");
						break;

					case 3:
						System.out.print("\nEnter Account Number, Amount(Deposit): ");
						depositAmount(listMap, scanner.nextInt(), scanner.nextDouble());
						System.out.println("Money Deposited!");
						break;

					case 4:
						System.out.print("Enter Account Number: ");
						BankAccount objAccount = accNumberCheck(scanner.nextInt(), listMap);
						if (!objAccount.isKycDone()) {
							System.out.println("Enter Address, Phone Number, Aadhar Card, Date of Birth");
							KYC kyc = validateAllKYC(scanner.next(), scanner.nextLong(), scanner.next(),
									scanner.next());
							objAccount.setKycCheck(kyc);
							objAccount.setKycDone(true);
							System.out.println("\nKYC Done!");
						} else {
							System.out.println("KYC is Done Already!");
						}
						break;

					case 5:
						System.out.print("Enter your Account Number: ");
						int src = scanner.nextInt();
						kycCheck(src, listMap);
						System.out.print("Enter Receiver's Account Number & Amount: ");
						fundTransfer(listMap, src, scanner.nextInt(), scanner.nextDouble());
						break;

					case 6:
						System.out.println("Enter Account Number: ");
						BankAccount obj = listMap.get(scanner.nextInt());
						System.out.println("Current Balance : " + obj.getBalance());
						break;

					case 7:

						break;

					case 8:
						display(listMap);
						break;

					case 9:
						System.out.print("Enter Account Number: ");
						objAccount = accNumberCheck(scanner.nextInt(), listMap);
						System.out.println(objAccount);
						if (objAccount.isKycDone()) {
							System.out.println(objAccount.getKycCheck().toString());
						}
						break;
						
					case 10:
						

					case 0:
						exit = true;
						break;
					}

				} catch (IllegalArgumentException typeErr) {
					System.out.println("FAILED " + "\nReason: No such Account Type Exists!\nTRY AGAIN!");
				} catch (Exception e) {
					System.out.println("FAILED" + "\nReason: " + e.getMessage() + "\nTRY AGAIN!");
					scanner.nextLine();
				}

			}

		}

	}

}
