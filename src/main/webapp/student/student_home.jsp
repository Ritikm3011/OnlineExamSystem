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
		<h4>${studentObj.phone}</h4>
	</c:if>

	<%-- Display a message if studentObj is not found in the session --%>
	<c:if test="${empty studentObj}">
		<h1>Student information not found. Please log in again.</h1>
	</c:if>




</body>
</html>