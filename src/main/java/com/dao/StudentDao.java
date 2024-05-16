package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Student;

public class StudentDao {

	private SessionFactory factory;
	private Session session;
	private Transaction txn;

	public StudentDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public boolean signUp(Student student) {
		boolean f = false;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();

			session.save(student);
			txn.commit();
			f = true;
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in StudentDao");
		}

		return f;
	}

}
