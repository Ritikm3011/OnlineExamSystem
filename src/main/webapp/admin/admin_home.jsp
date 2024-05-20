
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="../component/all_css_js.jsp"%>
<title>Admin Home</title>



</head>
<body>
	<%@include file="admin_navbar.jsp"%>
	<c:if test="${not empty adminObj}">


	</c:if>

	<%-- Display a message if studentObj is not found in the session --%>
	<c:if test="${empty adminObj}">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>


	<!-- Admin Dashboard -->



	<div class="container p-5 ">

		<h1 class="display-5 text-center mb-3">Admin Dashboard</h1>
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
				<a href="view_students.jsp" class="text-decoration-none">
					<div class="card">
						<div class="card-body text-center text-success ">
							<h5 class="text-center display-5">Total Students</h5>
							<h4>xx</h4>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="view_exam.jsp" class="text-decoration-none">
					<div class="card ">
						<div class="card-body text-center text-success ">
							<h5 class="text-center display-5">Total Exam</h5>
							<h4>xx</h4>
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-4">
				<a href="add_exam.jsp" class="text-decoration-none">
					<div class="card ">
						<div class="card-body text-center text-success ">

							<h5 class="text-center display-5">Add Exam</h5>

							<h4>xx</h4>
						</div>
					</div>


				</a>
			</div>


			<div class="col-md-4 mt-2" data-bs-toggle="modal"
				data-bs-target="#exampleModal">
				<a href="#" class="text-decoration-none">
					<div class="card ">
						<div class="card-body text-center text-success ">
							<h5 class="text-center display-5">Active Students</h5>
							<h4>xxx</h4>
						</div>
					</div>
				</a>
			</div>
			
			
			
			<div class="col-md-4 mt-2" data-bs-toggle="modal"
				data-bs-target="#exampleModal">
				<a href="#" class="text-decoration-none">
					<div class="card ">
						<div class="card-body text-center text-success ">
							<h5 class="text-center display-5">Active Exam</h5>
							<h4>xxx</h4>
						</div>
					</div>
				</a>
			</div>

		</div>

	</div>



</body>
</html>