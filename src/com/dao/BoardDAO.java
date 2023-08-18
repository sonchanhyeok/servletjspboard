package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {
	
	//전체 목록
	public PageDTO list(SqlSession session, HashMap<String,String> map, int curPage){
		PageDTO pageDTO = new PageDTO();
		
		int offset = (curPage-1)*pageDTO.getPerPage(); // 시작위치
		int limit = pageDTO.getPerPage(); // 한페이지당 보여줄 개수, perPage
		
		List<BoardDTO> list = session.selectList("BoardMapper.list", map, new RowBounds(offset, limit));
		
		//list 저장
		pageDTO.setList(list);
		//curPage 저장
		pageDTO.setCurPage(curPage);
		
		//totalCount 저장
		int totalCount=0;
		if(map.get("searchValue")==null) {
			// 검색 안한 경우
			totalCount = session.selectOne("BoardMapper.totalCount");
		}else {
			// 검색 한 경우
			totalCount = session.selectOne("BoardMapper.totalCountSearch", map);
		}
		pageDTO.setTotalCount(totalCount);
		
		//searchName과 searchValue 모두 PageDTO에 저장 필요
		
		return pageDTO;
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
