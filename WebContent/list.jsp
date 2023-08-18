<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 목록보기</h2>

<%
	List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("boardList");
%>
<table border="1">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
<%
	for(BoardDTO dto : list){
%>
	<tr>
		<td><%=dto.getNum() %></td>
		<td><a href="retrieve?num=<%=dto.getNum()%>"><%= dto.getTitle() %></a></td>
		<td><%= dto.getAuthor() %></td>
		<td><%=dto.getWriteday() %></td>
		<td><%=dto.getReadcnt() %></td>
	</tr>
<%
	} 
%>
</table>
<a href="writeui">글쓰기</a>
</body>
</html>