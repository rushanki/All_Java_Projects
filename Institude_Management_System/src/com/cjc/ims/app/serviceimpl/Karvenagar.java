package com.cjc.ims.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cjc.ims.app.model.Batch;
import com.cjc.ims.app.model.Cource;
import com.cjc.ims.app.model.Faculty;
import com.cjc.ims.app.model.Student;
import com.cjc.ims.app.servicei.Cjc;

public class Karvenagar implements Cjc {
	List<Cource> clist = new ArrayList<>();
	List<Faculty> flist = new ArrayList<>();
	List<Batch> blist = new ArrayList<>();
	List<Student> slist = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	@Override
	public void addCource() {
		Cource c = new Cource();

		System.out.println("Enter cource Id : ");
		int ci = sc.nextInt();
		c.setCid(ci);

		System.out.println("Enter cource Name : ");
		String cn = sc.next();
		c.setCname(cn);

		clist.add(c);

	}

	@Override
	public void viewCource() {
		for (Cource c : clist) {

			System.out.println("courceid : " + c.getCid() + " " + " courcename : " + c.getCname());

		}

	}

	@Override
	public void addFaculty() {
		if (clist.isEmpty()) {
			System.out.println("add course first");
			return;
		}
		Faculty f = new Faculty();

		System.out.println("Enter Faculty Id : ");
		int fid = sc.nextInt();
		f.setFid(fid);

		System.out.println("Enter Faculty Name : ");
		String fn = sc.next();
		f.setFname(fn);

		for (Cource c : clist) {

			System.out.println("cource id: " + c.getCid() + " " + "cource name :" + c.getCname());

		}

		System.out.println("Enter a course id to set course perticular faculty");
		int cid = sc.nextInt();
		for (Cource c : clist) {
			if (c.getCid() == cid) {
				f.setCource(c);
			}
		}
		flist.add(f);

	}

	@Override
	public void viewFaculty() {

		for (Faculty f : flist) {
			System.out.println("faculty id : " + f.getFid() + " " + "faculty name :" + f.getFname() + " "
					+ f.getCource().getCid() + " " + f.getCource().getCname());
		}

	}

	@Override
	public void addBatch() {

		if (flist.isEmpty()) {
			System.out.println("add faculty first");
			return;
		}

		Batch b = new Batch();

		System.out.println("Enter Batch Id : ");
		int bid = sc.nextInt();
		b.setBid(bid);

		System.out.println("Enter Batch Name : ");
		String bn = sc.next();
		b.setBname(bn);

		for (Faculty f : flist) {

			System.out.println("Faculty id: " + f.getFid() + " " + "faulty name" + f.getFname());

		}
		System.out.println("Enter a Faculty id to set Faculty perticular Batch: ");
		int fid = sc.nextInt();
		for (Faculty f : flist) {
			if (f.getFid() == fid) {
				b.setFaculty(f);
			}
		}
		blist.add(b);

	}

	@Override
	public void viewBatch() {
		for (Batch b : blist) {
			System.out.println(
					b.getBid() + " " + b.getBname() + " " + b.getFaculty().getFid() + " " + b.getFaculty().getFname()
							+ " " + b.getFaculty().getCource().getCid() + " " + b.getFaculty().getCource().getCname());

		}

	}

	@Override
	public void addStudent() {
		if (blist.isEmpty()) {
			System.out.println("add Batch first");
			return;
		}

		Student s = new Student();

		System.out.println("Enter Student Id : ");
		int sid = sc.nextInt();
		s.setSid(sid);

		System.out.println("Enter Student Name : ");
		String sn = sc.next();
		s.setSname(sn);

		for (Batch b : blist) {

			System.out.println("Batch id: " + b.getBid() + " " + "Batch name" + b.getBname());

		}
		System.out.println("Enter a Batch id to set batch perticular Student");
		int bid = sc.nextInt();
		for (Batch b : blist) {
			if (b.getBid() == bid) {
				s.setBatch(b);
			}
		}
		slist.add(s);

	}

	@Override
	public void viewStudent() {
		for (Student s : slist) {

			System.out.println(s.getSid() + " " + s.getSname() + " " + s.getBatch().getBid() + " "
					+ s.getBatch().getBname() + " " + s.getBatch().getFaculty().getFid() + " "
					+ s.getBatch().getFaculty().getFname() + " " + s.getBatch().getFaculty().getCource().getCid() + " "
					+ s.getBatch().getFaculty().getCource().getCname());

		}

	}

}
