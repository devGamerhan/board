<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>table page</title>
</head>
<body>
	<table border="1">
		<c:forEach items="${tList }" var="t">
			<tr>
				<td>${t.pnum}</td>
				<td>${t.name}</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="paging.jsp">
		<jsp:param name="totalCount" value="${totalCount}"/>
		<jsp:param name="page" value="${page}"/>
	</jsp:include>
</body>
</html>