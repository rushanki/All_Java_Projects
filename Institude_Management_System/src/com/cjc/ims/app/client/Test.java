package com.cjc.ims.app.client;

import java.util.Scanner;

import com.cjc.ims.app.serviceimpl.Karvenagar;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Karvenagar k = new Karvenagar();

		while (true) {

			System.out.println(
					"Enter 1 to add Cource\nEnter 2 to add viewCource\nEnter 3 to add faculty\nEnter 4 to add viewFaculty\nEnter 5 to add Batch \nEnter 6 to add viewbatch\nEnter 7 to add student\nEnter 8 to add viewStudent");

			int a = sc.nextInt();

			switch (a) {
			case 1:
				k.addCource();
				break;

			case 2:
				k.viewCource();
				break;

			case 3:
				k.addFaculty();
				break;

			case 4:
				k.viewFaculty();
				break;

			case 5:
				k.addBatch();
				break;

			case 6:
				k.viewBatch();
				break;

			case 7:
				k.addStudent();
				break;

			case 8:
				k.viewStudent();
				break;
			
			default:
				System.out.println("Invalid choice");

			}

		}
	}
}
