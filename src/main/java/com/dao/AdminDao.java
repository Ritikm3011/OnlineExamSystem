package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Exam;
import com.entity.Question;

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

	public int totalExam() {
		int count = 0;
		List<Exam> examList = getAllExam();
		count = examList.size();

		return count;
	}
	
	
	public List<Exam> getActiveExam() {
		List<Exam> examList = null;

		try {
			session = factory.openSession();
			Query query = session.createQuery("from Exam where active=:ac");
			query.setParameter("ac","Active");

			examList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.getAllExam");
		}

		return examList;
	}
	
	
	public int totalActiveExam() {
		int count = 0;
		List<Exam> examList = getActiveExam();
		count = examList.size();

		return count;
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
			System.out.println("problem in AdminDao.getExamById");
		}

		return exam;
	}

	public boolean addQuestion(Question question) {

		boolean f = false;

		try {
			session = factory.openSession();
			txn = session.beginTransaction();

			session.save(question);
			txn.commit();
			f = true;
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.addQuestion");
		}

		return f;
	}

	public boolean deleteExamById(int examId) {
		boolean f = false;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();

			Query query = session.createQuery("delete from Exam where examId=:id");
			query.setParameter("id", examId);
			int status = query.executeUpdate();
			txn.commit();
			if (status == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.deleteExamById");
		}

		return f;
	}

	public List<Question> getQuestionByExamId(int examId) {
		List<Question> list = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Question where exam.examId=:id");
			query.setParameter("id", examId);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.getQuestionByExamId");
		}

		return list;
	}

	public int getTotalQuestionByExamId(int examId) {
		int count = 0;
		try {
//			session = factory.openSession();
//			Query query = session.createQuery("select count(Question) from Question  where exam.examId = :id", Integer.class);
//			query.setParameter("id", examId);
//			count =(int) query.uniqueResult();

			List<Question> list = getQuestionByExamId(examId);
			count = list.size();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.getTotalQuestionByExamId");
		}

		return count;
	}

	public int editExam(int examId, String name, String instructions, double positiveMarks, double negativeMarks,
			String duration, String active) {
		int status = 10;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery(
					"update Exam e set e.name=: nm, e.instructions=: ins, e.positiveMarks=: pm, e.negativeMarks=: nm, e.duration=: du, e.active=: ac where e.examId=: id");
			query.setParameter("nm", name);
			query.setParameter("ins", instructions);
			query.setParameter("pm", positiveMarks);
			query.setParameter("nm", negativeMarks);
			query.setParameter("du", duration);
			query.setParameter("ac", active);
			query.setParameter("id", examId);

			status = query.executeUpdate();
			txn.commit();
			System.out.println(status);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.editExam");
			System.out.println(status);

		}
		return status;

	}
}
