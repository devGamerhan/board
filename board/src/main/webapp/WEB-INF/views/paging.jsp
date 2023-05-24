<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
 	String searchCondition = request.getParameter("searchCondition");
 	String searchKeyword = request.getParameter("searchKeyword");
 	
 	if(searchCondition == null){
 		searchCondition = "title";
 	}
 	if(searchKeyword == null){
 		searchKeyword = "";
 	}
 	
 	
	int currentButton = Integer.parseInt(request.getParameter("page"));

 	//한 페이지에 몇 개를 보여줄 지
 	int howManyListInPage = 10;		
	
 	//한 화면에 보여줄 페이지 버튼 수 5
 	int buttonCount = 5;

 	//게시글 총량
 	int totalListCount = Integer.parseInt(request.getParameter("totalCount"));
	
 	//페이지 버튼 총량
 	int totalButton = totalListCount / howManyListInPage;
	
 	//0으로 떨어지지 않을 경우
 	if((totalListCount%howManyListInPage) > 0){
 		totalButton++;
 	}
	
 	// 현재 위치가 최대치를 넘어설 경우
 	if(currentButton > totalListCount){
 		currentButton = totalListCount;
 	}
	
 	// 버튼 리스트 시작 위치
 	// ( (현재 위치 - 1) / 보여줄 버튼 갯수 ) * 보여줄 버튼 갯수 + 1
 	int startButton = ((currentButton-1) / buttonCount) * buttonCount + 1;
	
 	//버튼 리스트 끝 위치
 	//마지막 버튼이 버튼 최댓값보다 커지지 않게 막아주기
 	int endButton = startButton + buttonCount - 1;
	
 	if(endButton > totalButton){
 		endButton = totalButton;
 	}
 	//처음 버튼이 활성화 되었을 때(현재 위치가 2 이상일 때)
 	if(currentButton > 1){
%>
 		<a href="getBoardList.do?page=1&searchCondition=<%=searchCondition %>">처음</a>
 <%	} 
	
 	//이전 버튼이 활성화 되었을 때(현재 위치가 2 이상일 때)
 	if(currentButton > 1){
 %> 
 		<a href="getBoardList.do?page=<%=currentButton-1%>&searchCondition=<%=searchCondition %>&searchKeyword=<%=searchKeyword%>">이전</a> 
 <%	} 
	
 	//페이지 리스트
 	for(int i=startButton; i<=endButton; i++){
 		if(currentButton != i){
 %> 
		<a href="getBoardList.do?page=<%=i%>&searchCondition=<%=searchCondition %>&searchKeyword=<%=searchKeyword%>">[<%=i %>]</a>	 
 <%		} 
 		else{
 %> 
 		[<b><%=i %></b>] 
 <% 
 		}
 	}
	
 	//다음 버튼이 활성화 되었을 떄(현재 위치가 끝이 아닐 때)
 	if(currentButton < totalButton){
 %> 
 		<a href="getBoardList.do?page=<%=currentButton+1%>&searchCondition=<%=searchCondition %>&searchKeyword=<%=searchKeyword%>">다음</a> 
 <%
 	}
	
 	//마지막으로 이동
 	if(currentButton < totalButton){
 %>
 		<a href="getBoardList.do?page=<%=totalButton%>&searchCondition=<%=searchCondition %>&searchKeyword=<%=searchKeyword%>">끝</a>
<%
 	}
%>
