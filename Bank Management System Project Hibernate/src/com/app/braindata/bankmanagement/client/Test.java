package com.app.braindata.bankmanagement.client;

import java.util.Scanner;
import com.app.braindata.bankmanagement.model.serviceimpl.Sbi;

import java.util.Scanner;

import com.app.braindata.bankmanagement.model.service.Rbi;

public class Test {
	public static void main(String[] args) {
		
		Rbi bank= new Sbi();

		while (true) {
			System.out.println(
					"Enter 1 for create account\n Enter 2 for displayAllDetails\n Enter 3 for deposite money\n Enter 4 for withdrawl\nEnter 5 for balance check\n Enter 6 for Total transaction \nEnter 7 for exit ");

			Scanner sc = new Scanner(System.in);

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
                
				bank.createAccount();
                
				break;

			case 2:

				bank.displayAllDetails();
				break;

			case 3:

				bank.depositeMoney();

				break;

			case 4:
				bank.withdrawl();

				break;

			case 5:
				bank.balanceCheck();

				break;
				
			case 6:
				bank.totalTransaction();

				break;
				
			case 7:
				System.out.println("thank you for visitig");

				System.exit(0);

			default:
				System.out.println("invalid choice");

			}

		}

	}
}
