package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public class BoardDAO {
	
	//전체 목록
	public List<BoardDTO> list(SqlSession session){
		List<BoardDTO> list = session.selectList("BoardMapper.list");
		return list;
	}
	
	//글저장
	public int write(SqlSession session, BoardDTO dto){
		int n = session.insert("BoardMapper.write", dto);
		return n;
	}
	
	// 글자세히 보기
	public BoardDTO retrieve(SqlSession session, int num) {
		BoardDTO dto = session.selectOne("BoardMapper.retrieve", num);
		return dto;
	}
	
	// 조회수 증가
	public int readcnt(SqlSession session, int num) {
		int n = session.update("BoardMapper.readcnt",num);
		return n;
	}
	
	// 글 수정
	public int update(SqlSession session, BoardDTO dto) {
		int n = session.update("BoardMapper.update", dto);
		return n;
	}
	
	// 글 삭제
	public int delete(SqlSession session, int num) {
		int n = session.delete("BoardMapper.delete", num);
		return n;
	}
	
}
