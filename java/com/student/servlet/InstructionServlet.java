package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.dao.ExamDao;
import com.db.FactoryProvider;
import com.entity.Exam;
import com.entity.Result;
import com.entity.Student;
import com.helper.DateTime;

/**
 * Servlet implementation class InstructionServlet
 */
public class InstructionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstructionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		try {

			HttpSession session = request.getSession();
			String agree = request.getParameter("instruction_agree");
			int examId = Integer.parseInt(request.getParameter("exam_id"));

			AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
			ExamDao examDao = new ExamDao(FactoryProvider.getSessionFactory());

			Exam exam = dao.getExamById(examId);
			Student student = (Student) session.getAttribute("studentObj");
			int totalQuestion = dao.getTotalQuestionByExamId(examId);
			int attemptedQuestion = 0;
			String startTime = DateTime.getDateTime();
			String submitTime = "N/A";

			double positiveMarks = exam.getPositiveMarks();
			double negativeMarks = exam.getNegativeMarks();

			double totalMarks = (totalQuestion) * (positiveMarks);
			double scoredMarks = 0.0;

			if (agree.equals("on")) {
				Result result = new Result(exam, student, totalQuestion, attemptedQuestion, startTime, submitTime,
						totalMarks, positiveMarks, negativeMarks, scoredMarks);
				if (examDao.createResult(result)) {
					int resultId = result.getResultId();
					response.sendRedirect("student/exam.jsp?exam_id=" + examId + "&result_id=" + resultId);
				}
			} else {
				session.setAttribute("failMsg", "Agree on term & condition");
				response.sendRedirect("insturction.jsp?exam_id=" + examId);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
