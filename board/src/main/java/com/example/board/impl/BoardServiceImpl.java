package com.example.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.board.BoardService;
import com.example.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOMybatis boardDAO;
	
	//@Autowired
	//private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteOneBoard(BoardVO vo) {
		boardDAO.deleteOneBoard(vo);
	}
	
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	@Override
	public void deleteBoard(String[] vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public List<Object> paging(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.paging(vo);
	}
}
