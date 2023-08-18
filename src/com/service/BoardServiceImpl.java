package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<BoardDTO> list() {
		
		SqlSession session = MySqlSessionFactory.getSession();
		List<BoardDTO> list = null;
		try {
			BoardDAO dao = new BoardDAO();
			list = dao.list(session);
			
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public int write(BoardDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			BoardDAO dao = new BoardDAO();
			n = dao.write(session, dto);
			session.commit();
			
		}finally {
			session.close();
		} 
		return n;
	}

}

/*
	SqlSession session = MySqlSessionFactory.getSession();
	try {
		//DAO 연동코드
		
	}finally {
		session.close();
	} 
 */