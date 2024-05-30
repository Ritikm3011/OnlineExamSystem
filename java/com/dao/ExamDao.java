package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.CheckQuestion;
import com.entity.Exam;
import com.entity.Question;
import com.entity.Result;

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

	public double getMark(String correctOption, String studentOption, String status, double positveMark,
			double negativeMarks) {
		double marks = 0.0;
		if (status.equals("attempted")) {
			if (correctOption.equals(studentOption)) {
				marks = positveMark;
			} else {
				marks = -(negativeMarks);
			}
		} else {
			marks = 0.0;
		}

		return marks;

	}

	public boolean createResult(Result result) {
		boolean f = false;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();

			session.save(result);
			txn.commit();
			f = true;
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.createResult");
		}
		return f;

	}

	public Result getResultObject(int resultId) {
		Result result = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Result where resultId =: id");
			query.setParameter("id", resultId);
			result = (Result) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.getResultObject");
		}

		return result;
	}

	public int attemptedQuestion(int resultId) {
		long x = 0;
		int attemptedQuestion = 0;

		try {
			session = factory.openSession();
			Query query = session.createQuery(
					"select count(cq) from CheckQuestion cq where cq.result.resultId = :rId and cq.status = :st");
			query.setParameter("rId", resultId);
			query.setParameter("st", "attempted");
			x = (long) query.uniqueResult();
			attemptedQuestion = (int) x;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.attemptedQuestion");
		}

		return attemptedQuestion;

	}

	public double scoredMarks(int resultId) {
		double scoredMarks = 0.0;
		try {
			session = factory.openSession();
			Query query = session
					.createQuery("select sum(cq.marks) from CheckQuestion cq where cq.result.resultId = :rId");
			query.setParameter("rId", resultId);
			scoredMarks = (double) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.scoredMarks");
		}

		return scoredMarks;
	}
	
	public boolean sumbitExam(int resultId, String submitTime, int attemptedQuestion, double scoredMarks) {
		boolean f = false;
		try {
			session = factory.openSession();
			txn = session.beginTransaction();
			
			Query query = session.createQuery("update Result set scoredMarks = :scoredMarks, submitTime = :submitTime, attemptedQuestion = :attemptedQuestion where resultId = :rId");
			query.setParameter("scoredMarks", scoredMarks);
			query.setParameter("submitTime", submitTime);
			query.setParameter("attemptedQuestion", attemptedQuestion);
			query.setParameter("rId", resultId);
			int result = query.executeUpdate();
			txn.commit();
			session.close();
			if(result == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.sumbitExam");
		}
		
		return f;
	}
	
	
	public Result getResult(int resultId) {
		Result result = null;
		
		try {
			session = factory.openSession();
			Query query = session.createQuery("from Result where resultId =: id");
			query.setParameter("id", resultId);
			result = (Result) query.uniqueResult();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in ExamDao.getResult");
		}
		
		return result;
	}
}
