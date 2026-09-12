package com.app.braindata.bankmanagement.model.serviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.braindata.bankmanagement.model.Account;
import com.app.braindata.bankmanagement.model.TransactionHistory;
import com.app.braindata.bankmanagement.model.service.Rbi;
import com.app.config.HibernatUtil;

public class Sbi implements Rbi {
	Scanner sc = new Scanner(System.in);
	Account acc = new Account();

	Session session = HibernatUtil.getSessionFactory().openSession();

	@Override
	public void createAccount() {

	while (true) {

			try {
				session.clear();
				System.out.println(" Enter Account Number: ");
				int accn = sc.nextInt();
				if (accn > 99999 && accn < 1000000) 
				{
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
				System.out.println(" Enter youe Name: ");
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
				System.out.println("enter balance ");
				double bal = sc.nextDouble();
				if (bal >= 1000) {
					acc.setBalance(bal);

					System.out.println("sufficiant balance is");
					break;
				} else {
					throw new InvalidBalnaceException("insufficiant balance");
				}
			} catch (InvalidBalnaceException e) {
				System.out.println(e.getMessage());
			}

		Transaction tx = session.beginTransaction();
		session.persist(acc);

		tx.commit();
		System.out.println("Account Created Successfully...");

	}

	@Override
	public void displayAllDetails() {
		System.out.println("Enter Account number :");
		int accNo = sc.nextInt();
		Account acc = session.get(Account.class, accNo);

		if (acc != null) {
			System.out.println("your Account Number : " + acc.getAccNo());
			System.out.println("your  Name : " + acc.getName());
			System.out.println("your  Mobile Number : " + acc.getMobno());
			System.out.println("your AadharNo : " + acc.getAdharNo());
			System.out.println("your gender : " + acc.getGender());
			System.out.println("your age : " + acc.getAge());
			System.out.println("your balance : " + acc.getBalance());// get balance=10000
		} else {

			System.out.println("Account not Found");
		}
	}

	@Override
	public void depositeMoney() {
		System.out.println("Enter account number :");
		int accNo = sc.nextInt();

		Account acc = session.get(Account.class, accNo);
		if (acc != null) {

			System.out.println("Enter Amount to Deposit : ");// amount=5000
			double amount = sc.nextDouble();

			double newbalanace = acc.getBalance() + amount;// (store) newbalance=10000+5000=150000;
			acc.setBalance(newbalanace);

			TransactionHistory th = new TransactionHistory();

			th.setTransactionType("deposit");
			th.setTransactionAmount(amount);

			acc.getList().add(th); // transaction is added to the Account

			Transaction tx = session.beginTransaction();
			session.merge(acc); // update
			tx.commit();

			System.out.println("your new balance is : " + acc.getBalance());// 15000
		} else {

			System.out.println("Account Not Found");
		}
	}

	@Override
	public void withdrawl() {
		while (true) {
			System.out.println("Enter account number :");
			int accNo = sc.nextInt();
			Account acc = session.get(Account.class, accNo);
			if (acc == null) {
				System.out.println("Account Not Found");
				return;
			}

			try {
				System.out.println("Enter Amount to Withdraw : ");
				double amount = sc.nextDouble();

				if (acc.getBalance() >= amount) {
					double withdrwawbalance = acc.getBalance() - amount;
					acc.setBalance(withdrwawbalance);

					TransactionHistory th = new TransactionHistory();
					th.setTransactionType("withdraw");
					th.setTransactionAmount(amount);

					acc.getList().add(th); // withdral is added to acc

					Transaction tx = session.beginTransaction();
					session.merge(acc);
					tx.commit();
					System.out.println("total balance after withdraw money is :" + acc.getBalance());

					break;

				} else {
					throw new InsufficiantBalanceException("insufficiant Balance");
				}
			} catch (InsufficiantBalanceException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void balanceCheck() {
		System.out.println("Enter Account Number :");
		String accNo = sc.next();
		Account acc = session.get(Account.class, accNo);

		if (acc != null) {

			System.out.println("current Balance : " + acc.getBalance());
		} else {
			System.out.println("Account Not Found :");
		}

	}

	@Override
	public void totalTransaction() {
		System.out.println("Enter Account Number");
		String accNo = sc.next();

		Account acc = session.get(Account.class, accNo);

		if (accNo == null) {

			System.out.println("Account Not Found:");
			return;
		}
		if (acc.getList().isEmpty()) {
			System.out.println("No transaction Found");
			return;
		}

		for (TransactionHistory th : acc.getList()) {
			System.out.println("Transaction Id :"+th.getTid());
			System.out.println("Transaction Type :"+ th.getTransactionAmount());
			System.out.println("Transaction Amuont"+th.getTransactionType());

		}

	}

}
