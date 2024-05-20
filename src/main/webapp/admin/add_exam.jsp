
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
<title>Create Exam</title>
<%@include file="admin_navbar.jsp"%>


</head>
<body>

	<div class="container my-3 py-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card shadow-lg p-3 mb-5 bg-body rounded">
					<div class="card-header">
						<p class="text-center fs-3">Add New Exam</p>

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
						<form action="../AddExamServlet" method="post">


							<div class="mb-3">
								<label class="form-label">Exam Name</label> <input
									class="form-control" name="exam_name" type="text">
							</div>

							<div class="mb-3">
								<label class="form-label">Instructions</label>
								<div class="form-floating">
									<textarea  name="instructions" class="form-control" 
										></textarea>
									<label for="floatingTextarea"></label>
								</div>
							</div>



							
							<div class="row g-3">
								<div class="col">
									<label class="form-label">Positive Marks</label> <input
										type="number" class="form-control" value="4" name="positive_marks">
								</div>
								<div class="col">
									<label class="form-label">Negative Marks</label> <input
										type="number" class="form-control"  value="1" name="negative_marks">
								</div>


								<div class="col">
									<label class="form-label">Exam Duration</label> <input
										type="text" class="form-control" placeholder="In minute"
										name="duration" >
								</div>

							</div>



							<div class="mb-3">
								<label class="form-label">Status</label> <select required
									class="form-control" name="status">
									<option disabled selected>---select---</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>

								</select>
							</div>




							<div class="text-center pt-4">
								<button class="btn btn-success col-md-10">Add Exam</button>
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>

	</div>



</body>
</html>