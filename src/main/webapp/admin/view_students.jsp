
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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../component/all_css_js.jsp"%>
<title>All Student</title>
</head>
<body>
	<%@include file="admin_navbar.jsp"%>

	<!-- all Students List -->
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary shadow-lg">
					<div class="card-header">
						<h1 class="display-5 text-center">Students Details</h1>
					</div>

					<div class="card-body">

						<table class="table table-striped ">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									<th scope="col">Phone No.</th>
									<th scope="col">Gender</th>
									<th scope="col">D.O.B</th>


									<th scope="col">Enrollment Date</th>
									<th scope="col">Last Login</th>
									<th scope="col">Status</th>

								</tr>
							</thead>
							<tbody>
								<%
								StudentDao stdDao = new StudentDao(FactoryProvider.getSessionFactory());
								List<Student> list = stdDao.getAllStudent();

								int i = 0;
								for (Student student : list) {
									i++;
									String status = "";
									if (student.getActive() == 0) {
										status = "Inactive";
									} else {
										status = "Active";
									}
								%>


								<tr>
									<th scope="row"><%=i%></th>
									<td><%=student.getName()%></td>
									<td><%=student.getEmail()%></td>
									<td><%=student.getPhone()%></td>
									<td><%=student.getGender()%></td>
									<td><%=student.getDob()%></td>
									<td><%=student.getEnrollmentDate()%></td>
									<td><%=student.getlastLogin()%></td>
									<td><%=status%></td>





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