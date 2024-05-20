
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
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="../component/all_css_js.jsp"%>
</head>
<body>
	<%@include file="admin_navbar.jsp"%>

	<!-- all Students List -->
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary shadow-lg">
					<div class="card-header">
						<h1 class="display-5 text-center">Exam Details</h1>
					</div>

					<div class="card-body">

						<table class="table table-striped ">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Name</th>
									<th scope="col">Positive Marks</th>
									<th scope="col">Negative Marks</th>
									<th scope="col">Duration</th>



									<th scope="col">Created At</th>
									<th scope="col">Total Questions</th>

									<th scope="col">Status</th>
									<th scope="col">Action</th>

								</tr>
							</thead>
							<tbody>
								<%
								StudentDao stdDao = new StudentDao(FactoryProvider.getSessionFactory());

								AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
								List<Exam> list = dao.getAllExam();

								int i = 0;
								for (Exam exam : list) {
									i++;
								%>
								<tr>
									<th scope="row"><%=i%></th>
									<td><%=exam.getName()%></td>
									<td><%=exam.getPositiveMarks()%></td>
									<td><%=exam.getNegativeMarks()%></td>
									<td><%=exam.getDuration()%></td>
									<td><%=exam.getCreationTimestamp()%></td>
									<td>xx</td>
									<td><%=exam.getActive()%></td>
									<td>xx</td>
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