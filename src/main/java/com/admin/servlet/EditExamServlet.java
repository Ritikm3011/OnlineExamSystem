package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.db.FactoryProvider;
import com.helper.Convert;

public class EditExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditExamServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(request, response);
		int examId = Integer.parseInt(request.getParameter("exam_id"));
		String name = request.getParameter("exam_name");
		String instructions = request.getParameter("instructions");
		double positiveMarks = Convert.getDouble(request.getParameter("positive_marks"));
		double negativeMarks = Convert.getDouble(request.getParameter("negative_marks"));
		String duration = request.getParameter("duration");
		String active = request.getParameter("status");

		HttpSession session = request.getSession();
		AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
		boolean f = dao.editExam(examId, name, instructions, positiveMarks, negativeMarks, duration, active);
		
		if (f) {
			session.setAttribute("successMsg", "Exam Details Updated Successfully.");
			response.sendRedirect("admin/view_exam.jsp");
		} else {
			session.setAttribute("failMsg", "Something went wrong");
			response.sendRedirect("admin/view_exam.jsp");
		}

	}

}
