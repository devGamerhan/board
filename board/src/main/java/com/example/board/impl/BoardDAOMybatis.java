package com.example.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.BoardVO;


@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//글 등록
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);	// board-mapping.xml의 namespace.id
	}
	
	//글 수정
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	//글 다수 삭제
	public void deleteBoard(String[] adminDelete) {
		for(int i=0; i<adminDelete.length; i++) {
			mybatis.delete("BoardDAO.deleteBoard", Integer.parseInt(adminDelete[i]));
		}
	}
	
	//글 삭제
	public void deleteOneBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard",vo.getSeq());
	}
	
	//글 상세조회
	public BoardVO getBoard(BoardVO vo) {
		mybatis.update("BoardDAO.cntPlus", vo);
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	//글 목록조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		if(vo.getPage() == 0) {
			vo.setPage(1);
		}
		return mybatis.selectList("BoardDAO.pagingBoardList", vo);
		//return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
	
	//페이징 처리
	public List<Object> paging(BoardVO vo){
		if(vo.getPage() == 0) {
			vo.setPage(1);
		}
		vo.setTotalCount(mybatis.selectOne("BoardDAO.boardCount",vo));
		
		System.out.println("getSearchCondition:"+vo.getSearchCondition());
		System.out.println("getSearchKeyword:"+vo.getSearchKeyword());
		
		List<Object> pageInfo = new ArrayList<Object>();
		pageInfo.add(vo.getPage());
		pageInfo.add(vo.getTotalCount());
		pageInfo.add(vo.getSearchCondition());
		pageInfo.add(vo.getSearchKeyword());
		
		System.out.println("page:"+vo.getPage());
		System.out.println("total:"+vo.getTotalCount());
		return pageInfo;
	}
	
}
