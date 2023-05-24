<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update board</title>
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
	<form action="updateBoard.do" method="post" name="updateForm">
		<input type="hidden" name="seq" value="${param.seq}">
  		<label for="exampleFormControlInput1" class="form-label">제목</label>
  		<input type="text" name="title" class="form-control" id="exampleFormControlInput1" placeholder="수정할 제목을 입력해주세요.">
		<label for="exampleFormControlTextarea1" class="form-label">내용</label>
		<textarea class="form-control" name="content" id="exampleFormControlTextarea1" placeholder="내용을 입력해주세요." rows="3"></textarea>
		<button class="btn btn-light" onclick="updateForm(); return false;">수정하기</button>
		<button class="btn btn-light" onclick="history.back(); return false;">돌아가기</button>
	</form>
</div>
	
</body>
<script type="text/javascript">
	function updateForm(){
		document.updateForm.submit();
	}
</script>
</html>