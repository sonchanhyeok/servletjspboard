package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.dto.PageDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//list.jsp에서 1 2 3 4 페이지 번호를 클릭할 때 전달된 현재 페이지 번호 얻기
		// <a href="list?cruPage=2>2</a>
		String curPage=request.getParameter("curPage");
		if(curPage==null) { //맨 처음 실행한 경우
			curPage="1";
		}
		
		
		//검색 파라미터 얻기
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		
		// 2개의 값을 서비스 거쳐서 DAO에 전달
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		
		//BoardService 연동
		BoardService service = new BoardServiceImpl();
		PageDTO pageDTO = service.list(map, Integer.parseInt(curPage));
		
		//이전에는 서블릿에서 응답처리를 했음. ==> list.jsp 위임
		//list.jsp에서 List<BoardDTO> list 보여주기 위해서는
		// List<BoardDTO> list를 scope에 저장해야 된다. 목록보기는 request scope가 가장 최적임.
		/*
		 * request scope
		 * session scope
		 * application scope
		 */
		
		request.setAttribute("pageDTO", pageDTO);
		
		//요청위임 ==> 목록보기는 request scope에 저장했기 때문에 포워드로 사용해야 된다.  
		/*
		 * 포워드 (forward)
		 * 리다이렉트 (redirect)
		 */
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
