package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Student;


public class ExamSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExamSubmitServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();

		int examId = Integer.parseInt(request.getParameter("exam_id"));
		int resultId = Integer.parseInt(request.getParameter("result_id"));
		Student student = (Student) session.getAttribute("studentObj");
		response.getWriter().print(student.getName() + "\n" + examId + "\n" + resultId);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 doGet(request, response);

	}

}
