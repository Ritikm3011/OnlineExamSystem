package com.admin.servlet;

import java.io.IOException;

import javax.persistence.ManyToOne;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.db.FactoryProvider;
import com.entity.Exam;
import com.entity.Question;

/**
 * Servlet implementation class AddQuestionServlet
 */
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQuestionServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);

		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String correctAnswer = request.getParameter("correct_answer");
		int examId = Integer.parseInt(request.getParameter("exam_id"));

		AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());

		Exam exam = dao.getExamById(examId);
		
		Question newQuestion = new Question(question, option1, option2, option3, option4, correctAnswer, exam);

		HttpSession session = request.getSession();
		
		if(dao.addQuestion(newQuestion)) {
			int questionId = newQuestion.getQuestionId();
			System.out.println(questionId);
		
			session.setAttribute("successMsg", "New Question Added Successfully");
			response.sendRedirect("admin/add_question.jsp?exam_id="+examId);
		} else {
			session.setAttribute("failMsg", "Something went wrong");
			response.sendRedirect("admin/add_qustion.jsp?exam_id"+examId);
		}
		
		
	}

}
