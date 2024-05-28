<%@page import="com.entity.Question"%>
<%@page import="com.entity.Exam"%>
<%@page import="java.util.List"%>
<%@page import="com.db.FactoryProvider"%>
<%@page import="com.dao.AdminDao"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../component/all_css_js.jsp"%>
<%
int examId = Integer.parseInt(request.getParameter("exam_id"));
AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
Exam exam = dao.getExamById(examId);
%>


<title><%=exam.getName()%></title>
<body>
	<%@include file="exam_navbar.jsp"%>

	<div class="container p-3 m-3">
		<div class="row ">
			<div class="col-10 offset-2">
				<div class="card">
					<div class="card-header"></div>

					<div class="card-body">

						<form action="#" method="post">
							
							<p>Exam : <%=exam.getName()%></p>
							<p>Total Question : <%=dao.getTotalQuestionByExamId(examId) %></p>
							
							<p>Attempted Question : </p>
							
							

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>


					</div>

				</div>


			</div>

		</div>


	</div>


</body>
</html>