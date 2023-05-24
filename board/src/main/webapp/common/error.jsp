<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
	<h1>에러 화면</h1>
	<p>${param.exception }</p>
	<hr>
	<p>${exception2.message }</p>
</body>
</html>