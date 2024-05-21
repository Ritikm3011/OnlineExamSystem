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
<%@include file="../component/all_css_js.jsp"%>
<title>Exam Action</title>
</head>
<body>
	<%@include file="admin_navbar.jsp"%>

	<%
	String exam_id = request.getParameter("exam_id");
	%>

	<button type="button" class="btn btn-warning m-2">
		Exam Id :
		<%=exam_id%></button>


	<!-- Admin Dashboard -->



	<div class="container p-5 ">

		<h1 class="display-5 text-center mb-3">Exam Dashboard</h1>
		<c:if test="${not empty successMsg}">

			<div class="text-center text-success mb-3" role="alert">${successMsg}</div>

			<c:remove var="successMsg" scope="session" />
		</c:if>


		<c:if test="${not empty failMsg}">
			<p class="text-center text-danger ">${failMsg}</p>
			<c:remove var="failMsg" scope="session" />
		</c:if>
		<%

		%>

		<div class="row">

			<div class="col-md-4">
				<a href="add_question.jsp?exam_id=<%=exam_id%>"
					class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center text-success ">
							<h5 class="text-center display-5">Add Question</h5>
							<h4>xx</h4>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="view_question.jsp?exam_id=<%=exam_id %>" class="text-decoration-none">
					<div class="card ">
						<div class="card-body text-center text-success ">
							<h5 class="text-center display-5">View Question</h5>
							<h4>xx</h4>
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-4">
				<a href="#" class="text-decoration-none">
					<div class="card ">
						<div class="card-body text-center text-success ">

							<h5 class="text-center display-5">Import</h5>

							<h4>xx</h4>
						</div>
					</div>


				</a>
			</div>






		</div>

	</div>


</body>
</html>