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
		List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("boardList");
	%>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>삭제</th>
		</tr>
		<%
			for (BoardDTO dto : list) {
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
			}
		%>
	</table>
	<a href="writeui">글쓰기</a>
</body>
</html>