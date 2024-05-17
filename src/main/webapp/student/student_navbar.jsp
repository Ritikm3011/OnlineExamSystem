<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
	<div class="container-fluid">
		<a class="navbar-brand" href="../index.jsp">ExamShala</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="student_home.jsp">Home</a></li>

				<li class="nav-item dropdown "><a
					class="nav-link dropdown-toggle active" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						${studentObj.name} </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="../StudentLogoutServlet">Log Out</a></li>
						<li><a class="dropdown-item" href="admin_login.jsp">${studentObj.name}</a></li>
						
					</ul></li>
				
			</ul>

		</div>
	</div>
</nav>