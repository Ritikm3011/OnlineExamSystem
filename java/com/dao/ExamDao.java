package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.CheckQuestion;
import com.entity.Exam;
import com.entity.Question;

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

	public boolean saveStudentAnswer(CheckQuestion checkQuestion) {
		boolean f = false;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			session.save(checkQuestion);
			txn.commit();
			f = true;
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.saveStudentAnswer");
		}

		return f;
	}

	public Question getQuestionObject(int questionId) {
		Question question = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("FROM Question Q WHERE Q.questionId = :id");
			query.setParameter("id", questionId);
			question = (Question) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.getQuestionObjectByQuestionId");
		}
		return question;
	}

	public Exam getExamObject(int ExamId) {
		Exam exam = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Exam where examId =: id");
			query.setParameter("id", ExamId);
			exam = (Exam) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.getExamObjectByQuestionId");
		}
		return exam;
	}

	public String getCorrectOptionByQuestionId(int questionId) {
		String correctOption = "";

		try {
			session = factory.openSession();
			Query query = session.createQuery("select correctAnswer from Question where questionId = : id");
			query.setParameter("id", questionId);
			correctOption = (String) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.getCorrectOptionByQuestionId");
		}
		return correctOption;
	}

	public double getMark(String correctOption, String studentOption, double positveMark, double negativeMarks) {
		double marks = 0.0;

		if (correctOption.equals(studentOption)) {
			marks = positveMark;
		} else {
			marks = -(negativeMarks);
		}
		return marks;

	}
}
