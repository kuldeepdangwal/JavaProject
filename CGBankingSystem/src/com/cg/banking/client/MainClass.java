package com.cg.banking.client;

import java.util.List;
import java.util.Scanner;
import com.cg.banking.beans.Account;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args) {
//		BankingServices bankingService = new BankingServicesImpl();
//		System.out.println(bankingService.openAccount("Savings" , 40000));
//		
//		BankingServices bankingService1 = new BankingServicesImpl();
//		System.out.println(bankingService1.openAccount("Current" , 100000));
//		
		Scanner sc = new Scanner(System.in);
		System.out.println("******************Banking System********************");
		boolean flag=true;
		while(flag) {
			System.out.println("Enter your choice:\n1. Open Account\n2. Get Account Details\n3. Get All Account Details"
					+ "\n4."+"\n5. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				BankingServices bankingService = new BankingServicesImpl();
				System.out.println("Enter your Account type:\n1. Savings \n2. Current");
				int in = sc.nextInt();
				System.out.println("Enter initial balance:");
				int initBalance = sc.nextInt();
				if(in==1)
					System.out.println(bankingService.openAccount("Savings" , initBalance));
				else
					System.out.println(bankingService.openAccount("Current" , initBalance));
				break;
			case 2: 
				bankingService = new BankingServicesImpl();
				System.out.println("Enter Account number to find details: ");
				int accountNo = sc.nextInt();
				Account accountDetails = bankingService.getAccountDetails(accountNo);
				System.out.println(accountDetails);
				break;
			case 3:
				bankingService = new BankingServicesImpl();
				List<Account> allAccountDetails = bankingService.getAllAccountsDetails();		
				System.out.println(allAccountDetails);
				break;
			case 4:
				
				break;
			case 5:
				flag =false;
				break;
		default:
			System.out.println("Please enter a valid number");
			break;
		}
//			System.out.println("Do you want to continue(y/n): ");
//			ch = sc.next().charAt(0);
		}
	}
}
