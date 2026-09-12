package com.app.braindata.bankmanagement.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	@Id
	private int accNo;
	private String name;
	private String mobno;
	private String adharNo;
	private String gender;
	private int age;
	private double balance;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "accNo")
	private List<TransactionHistory> list = new ArrayList<TransactionHistory>();

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<TransactionHistory> getList() {
		return list;
	}

	public void setList(List<TransactionHistory> list) {
		this.list = list;
	}

}
