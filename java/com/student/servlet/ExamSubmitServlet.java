package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExamDao;
import com.db.FactoryProvider;
import com.entity.Student;
import com.helper.DateTime;

public class ExamSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExamSubmitServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		ExamDao dao = new ExamDao(FactoryProvider.getSessionFactory());

		int examId = Integer.parseInt(request.getParameter("exam_id"));
		int resultId = Integer.parseInt(request.getParameter("result_id"));
		Student student = (Student) session.getAttribute("studentObj");
		String submitTime = DateTime.getDateTime();
	

		int atemptedQuestion = dao.attemptedQuestion(resultId);
		double scoredMarks = dao.scoredMarks(resultId);
		
		boolean f = dao.sumbitExam(resultId, submitTime, atemptedQuestion, scoredMarks);
		
		response.getWriter().print(student.getName() + "\n" + examId + "\n" + resultId + "\n" + atemptedQuestion+"\n"+scoredMarks+"\n"+ submitTime+"\n"+f);
		
		response.sendRedirect("student/result.jsp?exam_id="+examId+"&result_id=" + resultId);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
