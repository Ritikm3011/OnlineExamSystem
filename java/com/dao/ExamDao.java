package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Exam;

public class ExamDao {

	private SessionFactory factory;
	private Session session;
	private Transaction txn;

	public ExamDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public Exam getExamById(int examId) {
		Exam exam = null;

		try {
			session = factory.openSession();
			Query query = session.createQuery("from Exam where examId=:id");
			query.setParameter("id", examId);
			exam = (Exam) query.uniqueResult();
//			System.out.println(exam.getName());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.getExamById");
		}

		return exam;
	}

}
