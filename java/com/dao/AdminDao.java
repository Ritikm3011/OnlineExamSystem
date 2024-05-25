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
			query.setParameter("ac", "Active");

			examList = query.list();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.getAllExam");
		}

		return examList;
	}
	
	public int countActiveExam() {
		int count = 0;
		List<Exam> examList = getActiveExam();
		count = examList.size();
		return count;
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

	public boolean deleteQuestionById(int questionId) {
		boolean f = false;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();

			Query query = session.createQuery("delete from Question where questionId=:id");
			query.setParameter("id", questionId);
			int status = query.executeUpdate();
			txn.commit();
			if (status == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.deleteQuestionById");
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

	public int getExamIdByQuestionId(int questionId) {
		int id = 0;

		try {
			session = factory.openSession();
			Query query = session.createQuery("SELECT q.exam.examId FROM Question q WHERE q.questionId = :id");
			query.setParameter("id", questionId);
			id = (int) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.getExamIdByQuestionId");
		}

		return id;
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
	
	
	public boolean editExam(int examId, String name, String instructions, double positiveMarks, double negativeMarks, String duration, String active) {
		boolean f = false;
		try {
			
			session = factory.openSession();
			txn = session.beginTransaction();
			
			String hql = "UPDATE Exam e SET e.name = :name, e.instructions = :instructions, e.positiveMarks = :positiveMarks, e.negativeMarks = :negativeMarks, e.duration = :duration, e.active = :active WHERE e.examId = :examId";
	        Query query = session.createQuery(hql);
	        
	     // Set the parameters
	        query.setParameter("name", name);
	        query.setParameter("instructions", instructions);
	        query.setParameter("positiveMarks", positiveMarks);
	        query.setParameter("negativeMarks", negativeMarks);
	        query.setParameter("duration", duration);
	        query.setParameter("active", active);
	        query.setParameter("examId", examId);
	        
	        int result = query.executeUpdate();
	        System.out.println("row affected:" + result);
	        txn.commit();
	        
			if(result == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in AdminDao.editExam");
		}
		return f;
	}
	
	

}
