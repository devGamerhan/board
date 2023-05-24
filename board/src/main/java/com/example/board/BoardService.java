package com.example.board;

import java.util.List;

public interface BoardService {

	//글 등록
	void insertBoard(BoardVO vo);

	//글 수정
	void updateBoard(BoardVO vo);

	//글 삭제
	void deleteBoard(String[] vo);
	void deleteOneBoard(BoardVO vo);
	
	//글 상세조회
	BoardVO getBoard(BoardVO vo);

	//글 목록조회
	List<BoardVO> getBoardList(BoardVO vo);

	//페이징
	public List<Object> paging(BoardVO vo);
}