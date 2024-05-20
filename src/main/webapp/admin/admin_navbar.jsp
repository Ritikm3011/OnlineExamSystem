<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp">ExamShala</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="admin_home.jsp">Home</a></li>
					
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="view_exam.jsp">Exams</a></li>
					
					
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="view_students.jsp">Students</a></li>

				<li class="nav-item dropdown "><a
					class="nav-link dropdown-toggle active" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						${adminObj.name} </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="../AdminLogoutServlet">Log Out</a></li>
				
						
					</ul></li>
				
			</ul>

		</div>
	</div>
</nav>