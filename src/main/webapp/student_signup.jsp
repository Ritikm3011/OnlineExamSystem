<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../component/all_css_js.jsp"%>
<title>Student Sign Up</title>
</head>
<body>

	<%@include file="../component/navbar.jsp"%>


	<div class="container my-3 py-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card shadow-lg p-3 mb-5 bg-body rounded">
					<div class="card-header">
						<p class="text-center fs-3">Student Sign Up</p>

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
						<form action="StudentSignupServlet" method="post">


							<div class="mb-3">
								<label class="form-label">Full Name</label> <input
									class="form-control" name="name" type="text">
							</div>

							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									class="form-control" name="email" type="email">
							</div>

							<div class="mb-3">
								<label class="form-label">Phone No.</label> <input
									class="form-control" name="phone" type="text">
							</div>

							<div class="mb-3">
								<label class="form-label">Date Of Birth </label> <input
									class="form-control" name="dob" type="date">
							</div>
							<div class="mb-3">
								<label class="form-label">Gender</label> <select required
									class="form-control" name="gender">
									<option disabled selected>---select---</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
									<option value="Other">Other</option>
								</select>
							</div>


							<div class="mb-3">
								<label class="form-label">Password</label> <input
									class="form-control" name="password" type="password">
							</div>

							<div class="mb-3">
								<label class="form-label">Security Question</label> <select
									required class="form-control" name="security_question">
									<option disabled selected>---select---</option>
									<option value="In what city were you born?">In what
										city were you born?</option>
									<option
										value="What year was your father (or
										mother) born?">What
										year was your father (or mother) born?</option>
									<option value="What is your mother's maiden name?">What
										is your mother's maiden name?</option>
									<option
										value="What was your favorite food as a
										child?">What
										was your favorite food as a child?</option>
								</select>
							</div>


							<div class="mb-3">
								<label class="form-label">Security Question</label> <input
									class="form-control" name="security_answer" type="text">
							</div>

							<div class="mb-3">
								<label class="form-label">Address</label> <input
									class="form-control" name="address" type="text">
							</div>



							<div class="text-center pt-4">
								<button class="btn btn-success col-md-10">Sign Up</button>
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>