package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public interface BoardService {
	public PageDTO list(HashMap<String,String> map, int curPage);
	public int write(BoardDTO dto);
	public BoardDTO retrieve(int num);
	public int update(BoardDTO dto);
	public int delete(int num);
}
