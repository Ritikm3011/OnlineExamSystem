<%@page import="com.dao.ExamDao"%>
<%@page import="com.entity.Exam"%>
<%@page import="java.util.List"%>
<%@page import="com.db.FactoryProvider"%>
<%@page import="com.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../component/all_css_js.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%
	int examId = Integer.parseInt(request.getParameter("exam_id"));
	ExamDao dao = new ExamDao(FactoryProvider.getSessionFactory());
	Exam exam = dao.getExamById(examId);
	String instruction = exam.getInstructions();
	%>


	<%@include file="exam_navbar.jsp"%>



	<div class="container p-5 m-3">
		<div class="row">
			<div class="col-md-10">
				<div class="card">
					<div class="card-header">
						<p class="fs-5 fst-italic text-decoration-underline">Please go
							through the Exam Related Instructions Carefully before
							Proceeding.</p>
					</div>
					<div class="card-body">

						<p><%=instruction%></p>



						<form action="../InstructionServlet" method="post">
							<input type="hidden" name="exam_id" value=<%=examId%>>
							<div class="mb-3 form-check">
								<input required="required" name="instruction_agree" type="checkbox"
									class="form-check-input" id="exampleCheck1"> <label
									class="form-check-label" for="exampleCheck1">I have
									read and understood the instruction. I agree that in case of
									not adhering to the instructions, I will be disqualified from
									giving the exam</label>
							</div>

							<div class="text-end">
								<button type="submit" class="btn btn-primary ">Start
									Test</button>

							</div>
						</form>




					</div>

				</div>
			</div>
		</div>

	</div>




</body>
</html>