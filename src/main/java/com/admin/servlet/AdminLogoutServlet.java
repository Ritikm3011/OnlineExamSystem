package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLogoutServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		session.removeAttribute("adminObj");
		session.setAttribute("successMsg", "Admin Logout Successfully.");
		response.sendRedirect("admin_login.jsp");
	}

	

}
