<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert board</title>
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
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="writer" value="<%=session.getAttribute("name")%>">
			<div class="mb-3">
	  			<label for="exampleFormControlInput1" class="form-label">제목</label>
	  			<input type="text" name="title" class="form-control" id="exampleFormControlInput1" placeholder="제목을 입력해주세요." required="required">
			</div>
			<div class="mb-3">
			  	<label for="exampleFormControlTextarea1" class="form-label">내용</label>
			  	<textarea class="form-control" name="content" id="exampleFormControlTextarea1" rows="3" required="required"></textarea>
			</div>
			<div class="mb-3">
	  			<label for="exampleFormControlInput1" class="form-label">업로드</label>
	  			<input type="file" name="uploadFile" class="form-control" id="exampleFormControlInput1">
			</div>
			<input type="submit" class="btn btn-light" value="글쓰기">
			<button class="btn btn-light" onclick="history.back(); return false;">돌아가기</button>
		</form>
	</div>
</body>
</html>