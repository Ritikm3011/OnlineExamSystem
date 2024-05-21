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
<title>Insert title here</title>
</head>
<body>
	<%@include file="admin_navbar.jsp"%>

	<%
	String exam_id = request.getParameter("exam_id");
	int examId = Integer.parseInt(exam_id);
	AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
	Exam exam = dao.getExamById(examId);
	String name = exam.getName();
	%>
       
	<button type="button" class="btn btn-warning m-2">
		Exam Id :
		<%=exam_id%></button>
	<button type="button" class="btn btn-warning m-2">
		Title :
		<%=exam.getName()%></button>





	<div class="container my-3 py-3">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card shadow-lg p-3 mb-5 bg-body rounded">
					<div class="card-header">
						<p class="text-center fs-3">Add New Question</p>

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
						<form action="../AddQuestionServlet" method="post">


							<div class="mb-3">
								<label class="form-label">Question</label> <input
									class="form-control" name="question" type="text">
							</div>

							<div class="mb-3">
								<label class="form-label">Option 1</label> <input
									class="form-control" name="option1" type="text">
							</div>

							<div class="mb-3">
								<label class="form-label">Option 2</label> <input
									class="form-control" name="option2" type="text">
							</div>

							<div class="mb-3">
								<label class="form-label">Option 3</label> <input
									class="form-control" name="option3" type="text">
							</div>
							<div class="mb-3">
								<label class="form-label">Option 4</label> <input
									class="form-control" name="option4" type="text">
							</div>






							<div class="mb-3">
								<label class="form-label">Correct Answer</label> <select
									required class="form-control" name="correct_answer">
									<option disabled selected>---select---</option>
									<option value="option1">Option 1</option>
									<option value="option2">Option 2</option>
									<option value="option3">Option 3</option>
									<option value="option4">Option 4</option>
								</select>
							</div>


							<input type="hidden" class="form-control" name="exam_id"  value="<%=exam.getExamId()%>">


							<div class="text-center pt-4">
								<button class="btn btn-success col-md-10">Save</button>
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>