<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../component/all_css_js.jsp"%>
<title>Admin Login</title>
</head>
<body>

	<%@include file="../component/navbar.jsp"%>


	<div class="container my-3 py-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card shadow-lg p-3 mb-5 bg-body rounded">
					<div class="card-header">
						<p class="text-center fs-3">Admin Login</p>
						
						 <c:if test="${not empty successMsg}">
                                <p class="text-center text-success ">${successMsg}</p>
                                <c:remove var="successMsg" scope="session"/>
                            </c:if>
						
						 <c:if test="${not empty failMsg}">
                                <p class="text-center text-danger ">${failMsg}</p>
                                <c:remove var="failMsg" scope="session"/>
                            </c:if>
					</div>

					<div class="card-body">
						<form action="AdminLoginServlet" method="post">

							<div class="mb-3">
								<label class="form-label">Enter Email</label> <input
									class="form-control" name="email" type="email">
							</div>
							<div class="mb-3">
								<label class="form-label">Enter Password</label> <input
									class="form-control" name="password" type="password">
							</div>


							<div class="text-center pt-4">
								<button class="btn btn-success col-md-10">Login</button>
							</div>

							<div class="text-center mt-2">
								Don't have account? <a href="register.jsp"
									class="text-decoration-none">create one</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>