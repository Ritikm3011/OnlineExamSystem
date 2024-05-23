package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.db.FactoryProvider;

/**
 * Servlet implementation class DeleteQuestionServlet
 */
public class DeleteQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionId = Integer.parseInt(request.getParameter("question_id"));
		AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
		
		int examId = dao.getExamIdByQuestionId(questionId);

		HttpSession session = request.getSession();
		if (dao.deleteQuestionById(questionId)) {
			session.setAttribute("successMsg", "Question Deleted Successfully");
			response.sendRedirect("admin/view_question.jsp?exam_id="+examId);
		} else {
			session.setAttribute("failMsg", "Something went wrong");
			response.sendRedirect("admin/view_question.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
