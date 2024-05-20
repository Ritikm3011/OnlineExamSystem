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
import com.helper.DateTime;

/**
 * Servlet implementation class StudentSignupServlet
 */
public class StudentSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentSignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String securityQuestion = request.getParameter("security_question");
		String securityAnswer = request.getParameter("security_answer");
		String address = request.getParameter("address");

		int active = 0;
		String enrollmentDate = DateTime.getDateTime();
		String lastLogin = DateTime.getDateTime();

		Student student = new Student(name, email, phone, dob, gender, password, securityQuestion, securityAnswer,
				active, address, enrollmentDate, lastLogin);

		StudentDao dao = new StudentDao(FactoryProvider.getSessionFactory());

		HttpSession session = request.getSession();

		if (dao.signUp(student)) {
			session.setAttribute("successMsg", "Register Successfully");
			response.sendRedirect("student_login.jsp");

		} else {
			session.setAttribute("failMsg", "Someting went wrong");
			response.sendRedirect("student_signup.jsp");
			
		}
	}

}
