<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<style type="text/css">
	#context{
		margin:auto;
		width:600px;
	}
</style>
</head>
<body>
	<div id="context">
		<h1><spring:message code="message.user.login.title" /></h1>
		<a href="login.do?lang=en"><spring:message code="message.user.login.language.en" /></a>
		<a href="login.do?lang=ko"><spring:message code="message.user.login.language.ko" /></a>
		<form action="login.do" method="post">
			<spring:message code="message.user.login.id" />
			<input type="text" name="id" class="form-control" placeholder="ID를 입력해주세요."><br>
			<spring:message code="message.user.login.password" />
			<input type="password" name="password" class="form-control" placeholder="PASSWORD를 입력해주세요."><br>
			<input type="submit" value='<spring:message code="message.user.login.loginBtn" />'>
		</form>
	</div>
</body>
</html>