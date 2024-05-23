package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ExamDao {

	private SessionFactory factory;
	private Session session;
	private Transaction txn;

	public ExamDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

}
