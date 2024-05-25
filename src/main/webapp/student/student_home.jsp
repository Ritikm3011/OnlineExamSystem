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
<title>Student Home</title>
</head>
<body>
	<%@include file="student_navbar.jsp"%>




	<%-- Check if studentObj is available in the session --%>
	<c:if test="${not empty studentObj}">
		<h1>Welcome, ${studentObj.name}!</h1>

	</c:if>

	<%-- Display a message if studentObj is not found in the session --%>
	<c:if test="${empty studentObj}">
		<c:redirect url="../student_login.jsp"></c:redirect>
	</c:if>

	<%
	AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
	int examCount = dao.countActiveExam();
	List<Exam> examList = dao.getAllExam();
	
	%>


	<div class="container ">
		<div class="row">

			<div class="col-md-3">
				<a href="#" class="text-decoration-none">
					<div class="card border-none">
						<div class="card-body text-center text-secondary">
							<h5 class="text-center display-5">Exam</h5>
							<h4><%=examCount %></h4>
						</div>
					</div>

				</a>
			</div>

			<div class="col-md-3">
				<a href="#" class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center text-secondary">
							<h5 class="text-center display-5">Attempted</h5>
							<h4>no of exam</h4>
						</div>
					</div>

				</a>
			</div>


			<div class="col-md-3">
				<a href="#" class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center text-secondary">
							<h5 class="text-center display-5">Passed</h5>
							<h4>no of exam</h4>
						</div>
					</div>

				</a>
			</div>

			<div class="col-md-3">
				<a href="#" class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center text-secondary">
							<h5 class="text-center display-5">Failed</h5>
							<h4>no of exam</h4>
						</div>
					</div>

				</a>
			</div>



		</div>



		<div class="row p-4 m-4">
			<div class="col-md-12">

				<div class="card">
					<div class="card-header text-secondary">
						<h5>My Exams</h5>
					</div>

					<div class="card-body  text-secondary">

						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Exam</th>
									<th scope="col">Exam marks</th>
									<th scope="col">My marks</th>
									<th scope="col">Status</th>
									<th scope="col">Date</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								int i = 0;
								for (Exam exam : examList) {
									i++;
								%>

								<tr>
									<th scope="row"><%=i%></th>
									<td><%=exam.getName()%></td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>@mdo</td>
									<td>@mdo</td>
									<td><a href="instruction.jsp?exam_id=<%=exam.getExamId() %>"class="btn btn-secondary">Attempt</a></td>
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