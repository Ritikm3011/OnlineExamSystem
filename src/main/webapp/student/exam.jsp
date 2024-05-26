<%@page import="com.entity.Question"%>
<%@page import="com.entity.Exam"%>
<%@page import="java.util.List"%>
<%@page import="com.db.FactoryProvider"%>
<%@page import="com.dao.AdminDao"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../component/all_css_js.jsp"%>
<%
int examId = Integer.parseInt(request.getParameter("exam_id"));
AdminDao dao = new AdminDao(FactoryProvider.getSessionFactory());
Exam exam = dao.getExamById(examId);
int questionIndex = request.getParameter("q") != null ? Integer.parseInt(request.getParameter("q")) : 0;
List<Question> questions = dao.getQuestionByExamId(examId);
Question currentQuestion = questions.get(questionIndex);
%>


<title><%=exam.getName()%></title>
</head>
<body>
	<%@include file="exam_navbar.jsp"%>


	<div class="container-fluid">

		<div class="row mt-3 pt-3">
			<div class="col-md-8">
				<div class="card">

					<div class="card-header">
						<p>
							Question No.
							<%=(questionIndex + 1)%></p>

					</div>
					<div class="card-body">
						<form action="../SaveAnswerServlet" method="post">
							  <p><%= currentQuestion.getQuestion() %></p>
                            <input type="radio" name="answer" value="option1"> <%= currentQuestion.getOption1() %><br>
                            <input type="radio" name="answer" value="option2"> <%= currentQuestion.getOption2() %><br>
                            <input type="radio" name="answer" value="option3"> <%= currentQuestion.getOption3() %><br>
                            <input type="radio" name="answer" value="option4"> <%= currentQuestion.getOption4() %><br>

                            <input type="hidden" name="exam_id" value="<%= examId %>">
                            <input type="hidden" name="question_id" value="<%= currentQuestion.getQuestionId() %>">
                            <input type="hidden" name="question_index" value="<%= questionIndex %>">

                            <div class="mt-3">
                                <% if (questionIndex > 0) { %>
                                    <a href="exam.jsp?exam_id=<%= examId %>&q=<%= questionIndex - 1 %>" class="btn btn-primary">Previous</a>
                                <% } %>

                                <% if (questionIndex < questions.size() - 1) { %>
                                    <button type="submit" name="action" value="next" class="btn btn-primary">Save and Next</button>
                                <% } else { %>
                                    <button type="submit" name="action" value="submit" class="btn btn-success">Submit</button>
                                <% } %>
                            </div>
						</form>
					</div>

					<div class="card-footer"></div>

				</div>
			</div>

			<div class="col-md-4">
				<div class="card">

					<div class="card-header">Exam Info</div>
					<div class="card-body"><p>Exam: <%= exam.getName() %></p>
						<p>Instructions: <br><%= exam.getInstructions() %></p>
						<p>Duration: <%= exam.getDuration() %></p></div>

				</div>
			</div>


		</div>

	</div>



</body>
</html>