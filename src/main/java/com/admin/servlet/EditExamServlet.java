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

//		doGet(request, response);

		String exam_id = request.getParameter("exam_id");
		String name = request.getParameter("exam_name");
		String instructions = request.getParameter("instructions");
		String positive_marks = request.getParameter("positive_marks");
		String negative_marks = request.getParameter("negative_marks");
		String duration = request.getParameter("duration");
		String active = request.getParameter("status");

		int examId = Integer.parseInt(exam_id);
		double positiveMarks = Convert.getDouble(positive_marks);
		
		double negativeMarks = Convert.getDouble(negative_marks);
		

		HttpSession session = request.getSession();

		AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());

		int f = dao.editExam(1, "Test", "Test", 5.0, 0.0, "30", "active");
		response.getWriter().print(f);
		response.getWriter().print("<br>");
		response.getWriter().print(positiveMarks);

	}

}
