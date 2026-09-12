package com.app.braindata.bankmanagement.model.serviceimpl;

import java.util.Scanner;

import com.app.braindata.bankmanagement.model.Account;
import com.app.braindata.bankmanagement.model.service.Rbi;

public class Sbi implements Rbi {
	Scanner sc = new Scanner(System.in);
	Account acc = new Account();

	@Override
	public void createAccount() {

		while (true) {

			try {
				System.out.println(" Enter AccountNumber: ");
				String accn = sc.next();
				if (accn.length() == 12) {
					acc.setAccNo(accn);
					break;
				} else {
					throw new InvalidAccountNumberException("Invalid Account Number!!! ");
				}
			} catch (InvalidAccountNumberException e) {
				System.out.println(e.getMessage());
			}
		}

		while (true) {
			try {
				System.out.println(" Enter your Name: ");
				String nm = sc.next();
				if (Character.isUpperCase(nm.charAt(0))) {
					acc.setName(nm);
					break;
				} else {
					throw new InvalisNameException("first letter of name should be upper case");
				}
			} catch (InvalisNameException e) {
				System.out.println(e.getMessage());
			}
		}

		while (true) {
			try {
				System.out.println(" Enter Mobno: ");
				String mobn = sc.next();
				if (mobn.length() == 10) {
					acc.setMobno(mobn);
					break;
				} else {
					throw new InvalidMobileNumberException("Moble number should be ten digit");
				}
			} catch (InvalidMobileNumberException e) {
				System.out.println(e.getMessage());
			}
		}

		while (true)
			try {
				System.out.println(" Enter Adharno: ");
				String adharn = sc.next();

				if (adharn.length() == 12) {
					acc.setAdharNo(adharn);
					break;
				} else {
					throw new InvalidAdharNoException(" Aadhar number shoild be 12 digit :  ");
				}
			} catch (InvalidAdharNoException e) {
				System.out.println(e.getMessage());
			}

		System.out.println(" Enter gender: ");
		String gn = sc.next();
		acc.setGender(gn);

		while (true)
			try {
				System.out.println(" Enter age: ");
				int age = sc.nextInt();
				if (age >= 18) {
					acc.setAge(age);
					break;
				} else {
					throw new InvalidAgeException("age is invalid");
				}
			} catch (InvalidAgeException e) {
				System.out.println(e.getMessage());
			}

		while (true)
			try {
				System.out.println(" Enter balance ");
				double bal = sc.nextDouble();
				if (bal >= 1000) {
					acc.setBalance(bal);

					System.out.println("Sufficiant Balance is");
					break;
				} else {
					throw new InvalidBalnaceException("insufficiant balance");
				}
			} catch (InvalidBalnaceException e) {
				System.out.println(e.getMessage());
			}

	}

	@Override
	public void displayAllDetails() {
		System.out.println("your Account Number : " + acc.getAccNo());
		System.out.println("your  Name : " + acc.getName());
		System.out.println("your  Mobile Number : " + acc.getMobno());
		System.out.println("your AadharNo : " + acc.getAdharNo());
		System.out.println("your gender : " + acc.getGender());
		System.out.println("your age : " + acc.getAge());
		System.out.println("your balance : " + acc.getBalance());// get balance=10000

	}

	@Override
	public void depositeMoney() {

		System.out.println("Enter Amount to Deposit : ");// amount=5000
		double amount = sc.nextDouble();

		double newbalanace = acc.getBalance() + amount;// (store) newbalance=10000+5000=150000;
		acc.setBalance(newbalanace);

		System.out.println("your new balance is : " + acc.getBalance());// 15000

	}

	@Override
	public void withdrawl() {
		while (true) {
			try {
				System.out.println("Enter Amount to Withdraw : ");
				double amount = sc.nextDouble();

				if (acc.getBalance() >= amount) {
					double withdrwawbalance = acc.getBalance() - amount;
					acc.setBalance(withdrwawbalance);
					System.out.println("total balance after withdraw money is :" + acc.getBalance());

					break;

				} else {
					throw new InsufficiantBalanceException("insufficiant Blance");
				}
			} catch (InsufficiantBalanceException e) {
				System.out.println(e.getMessage());
			}
		}
		// System.out.println("your Withdraw balance is : "+acc.getBalance());

	}

	@Override
	public void balanceCheck() {
		System.out.println("current Balance : " + acc.getBalance());

	}

}
