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
	<h2>게시판 자세히 보기</h2>
	<%
	// BoardRetrieveServlet에서
	// request.setAttribute("boardRetrieve", dto) 값 얻기
	BoardDTO dto = (BoardDTO) request.getAttribute("boardRetrieve");
	int num = dto.getNum();
	String title = dto.getTitle();
	String author = dto.getAuthor();
	String content = dto.getContent();
	String writeday = dto.getWriteday();
	int readcnt = dto.getReadcnt();
	%>
	<form action="" method="">
		글번호:<%=num%><br> 작성일:<%=writeday%><br> 조회수:<%=readcnt%><br>
		제목:<input type="text" name="title" value="<%=title%>"><br>
		작성자:<input type="text" name="author" value="<%=author%>"><br>
		내용:
		<textarea rows="10" cols="10" name="content"><%=content%></textarea>
		<input type="submit" value="수정">
	</form>

</body>
</html>