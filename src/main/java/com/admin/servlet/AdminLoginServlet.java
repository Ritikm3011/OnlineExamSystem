package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Admin;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Resolution;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Admin admin = new Admin();
		HttpSession session = request.getSession();
		if (email.equals(admin.getEmail()) && password.equals(admin.getPassword())) {
			session.setAttribute("adminObj", admin);
			response.sendRedirect("admin/admin_home.jsp");
		} else {
			session.setAttribute("failMsg", "Invalid Email & Password");
			response.sendRedirect("admin/admin_login.jsp");
		}

	}

}
