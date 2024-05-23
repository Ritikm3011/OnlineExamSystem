
<%@page import="com.entity.Question"%>
<%@page import="com.entity.Exam"%>
<%@page import="com.dao.AdminDao"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.db.FactoryProvider"%>
<%@page
	import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>
<%@page import="com.dao.StudentDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>All Questions</title>

<%@include file="../component/all_css_js.jsp"%>
</head>
<body>
	<%@include file="admin_navbar.jsp"%>

	<!-- all Questions List -->
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary shadow-lg">
					<div class="card-header">
						<h1 class="display-5 text-center">Questions</h1>
						<c:if test="${not empty successMsg}">
							<p class="text-center text-success ">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<c:if test="${not empty failMsg}">
							<p class="text-center text-danger ">${failMsg}</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>
					</div>

					<div class="card-body">

						<table class="table table-striped ">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Question</th>
									<th scope="col">Option 1</th>
									<th scope="col">Option 2</th>
									<th scope="col">Option 3</th>



									<th scope="col">Option 4</th>
									<th scope="col">Correct Option</th>
									<th scope="col">Actions</th>

									

								</tr>
							</thead>
							<tbody>
								<%
								String exam_id = request.getParameter("exam_id");
								int examId = Integer.parseInt(exam_id);
								AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
								List<Question> list = dao.getQuestionByExamId(examId);

								int i = 0;
								for (Question question : list) {
									i++;
								%>
								<tr>
									<th scope="row"><%=i%></th>
									<td><%=question.getQuestion()%></td>
									
									<td><%=question.getOption1() %></td>
									<td><%=question.getOption2() %></td>
									<td><%=question.getOption3() %></td>
									<td><%=question.getOption4() %></td>
									<td><%=question.getCorrectAnswer() %></td>
									
									<td><a href="#" type="button"
										class="btn btn-outline-success btn-sm">View</a> <a href="#"
										type="button" class="btn btn-outline-info btn-sm">Edit</a> <a
										href="../DeleteQuestionServlet?question_id=<%=question.getQuestionId()%>"
										type="button" class="btn btn-outline-danger btn-sm">Delete</a>
									</td>
								</tr>
								<%
								}
								%>
								
								
							</tbody>
						</table>

					</div>
				</div>
			</div>




		</div>
	</div>



</body>
</html>