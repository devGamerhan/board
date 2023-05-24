<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<h1>게시판</h1>
	<p>${sessionScope.name}님 환영합니다.</p>
	<hr>
	<div class="w-75 p-3">
		<ul class="list-group list-group-horizontal">
			<li class="list-group-item" style="width:50%">${board.title}</li>
			<li class="list-group-item" style="width:15%">작성자 ${board.writer}</li>
			<li class="list-group-item" style="width:15%">조회수 ${board.cnt}</li>
			<li class="list-group-item" style="width:20%">${board.regDate}</li>
		</ul>
		<ul class="list-group list-group-horizontal" id="content">
			<li class="list-group-item" style="width:100%">
				<p style="word-break:break-all">${board.content}</p>
			</li>
		</ul>
	</div>
	<button onclick="location.href='getBoardList.do'; return false;">돌아가기</button>
	<c:if test="${sessionScope.name eq board.writer }">
		<a href="./updateBoard.jsp?seq=${board.seq}">수정</a>
		<a href="./deleteOneBoard.jsp?seq=${board.seq}">삭제</a>
	</c:if>
</body>
</html>