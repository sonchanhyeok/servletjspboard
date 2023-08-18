package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> list();
	public int write(BoardDTO dto);
	public BoardDTO retrieve(int num);
	public int update(BoardDTO dto);
}
