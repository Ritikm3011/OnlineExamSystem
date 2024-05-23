package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.db.FactoryProvider;

public class DeleteExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteExamServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int examId = Integer.parseInt(request.getParameter("exam_id"));
		AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());

		HttpSession session = request.getSession();
		if (dao.deleteExamById(examId)) {
			session.setAttribute("successMsg", "Exam Deleted Successfully");
			response.sendRedirect("admin/view_exam.jsp");
		} else {
			session.setAttribute("failMsg", "Exam contain questions can't be deleted");
			response.sendRedirect("admin/view_exam.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
