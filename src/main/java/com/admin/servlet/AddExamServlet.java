package com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.db.FactoryProvider;
import com.entity.Exam;
import com.entity.Question;
import com.helper.DateTime;

public class AddExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddExamServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		doGet(request, response);

		String name = request.getParameter("exam_name");
		String instructions = request.getParameter("instructions");
		double positiveMarks =  Double.parseDouble(request.getParameter("positive_marks")); 
		double negativeMarks = Double.parseDouble(request.getParameter("negative_marks")); 
		String duration = request.getParameter("duration");
		String active = request.getParameter("status");

		String creationTimestamp = DateTime.getDateTime();
		List<Question> question = null;
		
		Exam exam = new Exam(name, instructions, positiveMarks, negativeMarks, duration, active, creationTimestamp);
	
		AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
		
		HttpSession session = request.getSession();
		if(dao.addExam(exam)) {
		
			session.setAttribute("successMsg", "New Exam Added Successfully");
			response.sendRedirect("admin/exam_actions.jsp");
		} else {
			session.setAttribute("failMsg", "Something went wrong");
			response.sendRedirect("admin/add_exam.jsp");
		}
		
		
		
	
	
	}

}
