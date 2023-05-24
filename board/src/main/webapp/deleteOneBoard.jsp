<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
	<p>삭제하시겠습니까?</p>
	<button onclick="deleteOneBoard(); return false;">삭제</button>
	<button onclick="location.href='getBoardList.do'; return false;">아니오</button>
</body>
<script type="text/javascript">
	function deleteOneBoard(){
		location.href="./deleteOneBoard.do?seq="+${param.seq};
	}
</script>
</html>