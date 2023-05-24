package com.example.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.BoardVO;
import com.example.board.impl.BoardDAO;

//@Controller
//public class GetBoardListController {
//
//	@RequestMapping(value="/getBoardList.do")
//	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		mav.setViewName("getBoardList");
//		mav.addObject("boardList",boardDAO.getBoardList(vo));
//		
//		return mav;
//	}
//}
