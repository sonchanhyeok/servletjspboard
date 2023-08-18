<%@page import="com.dto.PageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>   

	// DOM Tree가 모두 완료된후 호출
	$(document).ready(function(){
	 
		// button 이벤트 처리
		$("button").on("click", function(){
			var num = $(this).attr("data-num");
			//alert("button"+num);
			location.href="delete?num="+num;
		});
	 	   
	});
</script>

</head>
<body>
	<h2>게시판 목록보기</h2>

	<%
		PageDTO pageDTO = (PageDTO) request.getAttribute("pageDTO");
	%>
	<table border="1">
		<!-- 검색화면  -->
		<tr>
			<td colspan="6">
				<form action="list">
					<select name="searchName">
						<option value="title">제목</option>
						<option value="author">작성자</option>
						<input type="text" name="searchValue">
						<input type="submit" value="검색">
					</select>
				</form>
			</td>
		</tr>
		<!-- 검색화면  -->
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>삭제</th>
		</tr>
		<%
			for (BoardDTO dto : pageDTO.getList()) {
		%>
		<tr>
			<td><%=dto.getNum()%></td>
			<td><a href="retrieve?num=<%=dto.getNum()%>"><%=dto.getTitle()%></a></td>
			<td><%=dto.getAuthor()%></td>
			<td><%=dto.getWriteday()%></td>
			<td><%=dto.getReadcnt()%></td>
			<td><button data-num="<%=dto.getNum()%>">삭제</button></td>
		</tr>
		<%
			}//end for
		%>
		<!-- 페이지 번호 출력 -->
		<%
			int perPage = pageDTO.getPerPage();
			int curPage = pageDTO.getCurPage();
			int totalCount = pageDTO.getTotalCount();
			
			//page 숫자 만들기
			int totalNum = totalCount/perPage;
			if(totalCount%perPage!=0){
				totalNum++;
			}
		%>
		<tr>
			<td colspan="6">
				<%
					for(int i=1; i<=totalNum;i++){
						if(curPage==i){
				%>
							<%=i%>
						<%
						}else{
						%>
						<a href="list?curPage=<%=i%>"><%=i%></a>
						<%
						}
						%>
				<%
					}//end for
				%>
			</td>
		</tr>
		<!-- 페이지 번호 출력 -->
	</table>
	<a href="writeui">글쓰기</a>
</body>
</html>