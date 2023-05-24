<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoardList</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<h2>${sessionScope.name} 님 환영합니다.</h2>
	<form action="getBoardList.do" method="post">
		<table>
			<tr>
				<td align="right">
					<select name="searchCondition">
					<c:forEach items="${conditionMap}" var="option">
						<option value="${option.value }">${option.key }</option>
					</c:forEach>
					</select>
					<input type="text" name="searchKeyword">
					<input type="submit" value='<spring:message code="message.board.search.condition.btn" />'>
				</td>
			</tr>
		</table>
	</form>
	
	
	
	<hr>
	
	
	
	<form action="deleteBoard.do">
	<table class="table" border="1">
		<tr>
			<th><spring:message code="message.board.list.table.head.seq" /></th>
			<th><spring:message code="message.board.list.table.head.title" /></th>
			<th><spring:message code="message.board.list.table.head.writer" /></th>
			<th><spring:message code="message.board.list.table.head.cnt" /></th>
			<th><spring:message code="message.board.list.table.head.regDate" /></th>
			<c:if test="${sessionScope.role eq 'admin' }">
				<th><spring:message code="message.board.list.table.head.delete" /></th>
			</c:if>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.seq }</td>
				<td><a href="getBoard.do?seq=${board.seq}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.cnt }</td>
				<td>${board.regDate }</td>
				<c:if test="${sessionScope.role eq 'admin' }">
					<td><input type="checkbox" name="adminDelete" value="${board.seq}"></td>
				</c:if>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
			<jsp:include page="paging.jsp">
				<jsp:param name="page" value="${paging.get(0)}"/>
				<jsp:param name="totalCount" value="${paging.get(1)}"/>
				<jsp:param name="searchCondition" value="${paging.get(2)}"/>
				<jsp:param name="searchKeyword" value="${paging.get(3)}"/>
			</jsp:include>
			</td>
		</tr>
	</table>
	
	
	
	<c:if test="${sessionScope.role eq 'admin' }">
		<input type="submit" value="일괄 삭제">
	</c:if>
	</form>
	<a href="insertBoard.jsp"><spring:message code="message.board.list.insertBoard" /></a>
	<a href="./logout.do"><spring:message code="message.board.logout.logoutBtn" /></a>
</body>
</html>