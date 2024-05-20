package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Exam;

public class AdminDao {
	private SessionFactory factory;
	private Session session;
	private Transaction txn;

	public AdminDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	
	public boolean addExam(Exam exam) {
		
		boolean f = false;
		
		try {
			session = factory.openSession();
			txn = session.beginTransaction();

			session.save(exam);
			txn.commit();
			f = true;
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.addExam");
		}
		
		
		return f;
	}
	
	public List<Exam> getAllExam() {
		List<Exam> examList = null;
		
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Exam");
			
			examList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.getAllExam");
		}
		
		return examList;
	}
	
}
