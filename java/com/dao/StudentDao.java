package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
			System.out.println("problem in StudentDao.signUp");
		}

		return f;
	}

	public Student login(String email, String password) {
		Student student = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Student where email=:em and password=:ps");
			query.setParameter("em", email);
			query.setParameter("ps", password);

			student = (Student) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in StudentDao.login");
		}
		return student;
	}
	
	
	public List<Student> getAllStudent() {
		List<Student> studentList = null;
		
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Student");
			
			studentList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in StudentDao.allStudent");
		}
		
		return studentList;
		
	}
	
	public int totalStudent() {
		int count = 0;
		List<Student> std = getAllStudent();
		count = std.size();
		
		return count;
	}
	
	
	public List<Student> getActiveStudent() {
		List<Student> studentList = null;
		
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Student where active=1");
			
			studentList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in StudentDao.allStudent");
		}
		
		return studentList;
		
	}
	
	public int totalActiveStudent() {
		int count = 0;
		List<Student> std = getActiveStudent();
		count = std.size();
		
		return count;
	}

}
