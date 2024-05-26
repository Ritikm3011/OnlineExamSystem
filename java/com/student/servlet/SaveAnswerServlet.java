package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.ExamDao;
import com.db.FactoryProvider;
import com.entity.CheckQuestion;
import com.entity.Exam;
import com.entity.Question;
import com.entity.Student;

public class SaveAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveAnswerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession seession = request.getSession();
		
		ExamDao dao = new ExamDao(FactoryProvider.getSessionFactory());

		int examId = Integer.parseInt(request.getParameter("exam_id"));
		int questionId = Integer.parseInt(request.getParameter("question_id"));
		int questionIndex = Integer.parseInt(request.getParameter("question_index"));
		String studentOption = request.getParameter("answer");
		String action = request.getParameter("action");
		Student student = (Student) request.getSession().getAttribute("studentObj");
		String status = "attempted";
	//	String correctOption = dao.getCorrectOptionByQuestionId(questionId);
		

		Question question = dao.getQuestionObject(questionId);
		Exam exam = dao.getExamObject(examId);
		
		String correctOption = question.getCorrectAnswer();
		double positiveMarks = exam.getPositiveMarks();
		double negativeMarks = exam.getNegativeMarks();
		
		double marks = dao.getMark(correctOption, studentOption, positiveMarks, negativeMarks);

		CheckQuestion checkQuestion = new CheckQuestion(student, question, exam, status, correctOption, studentOption, marks);
		boolean f = dao.saveStudentAnswer(checkQuestion);

		
		

        if ("next".equals(action)) {
            response.sendRedirect("student/exam.jsp?exam_id=" + examId + "&q=" + (questionIndex + 1));
        } else if ("submit".equals(action)) {
            response.sendRedirect("student/submit.jsp?exam_id=" + examId);
        }
		
		
		

	}

}
