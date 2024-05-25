package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.db.FactoryProvider;
import com.entity.Student;

/**
 * Servlet implementation class StudentLoginServlet
 */
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentLoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		doGet(request, response);
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		StudentDao dao = new StudentDao(FactoryProvider.getSessionFactory());

		Student student = dao.login(email, password);
		HttpSession session = request.getSession();

		if (student == null) {
			session.setAttribute("failMsg", "Invalid email & password");
			response.sendRedirect("student_login.jsp");

		} else {
			session.setAttribute("studentObj", student);
			response.sendRedirect("student/student_home.jsp");

		}

	}

}
