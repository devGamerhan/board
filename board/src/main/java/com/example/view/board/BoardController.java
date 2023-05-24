package com.example.view.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.BoardService;
import com.example.board.BoardVO;
import com.example.board.impl.BoardDAO;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//글 다수 삭제
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(String[] adminDelete,BoardDAO boardDAO) {
		boardService.deleteBoard(adminDelete);
		return "redirect:getBoardList.do";
	}
	
	//글 단일 삭제
	@RequestMapping(value="/deleteOneBoard.do")
	public String deleteOneBoard(BoardVO vo, BoardDAO boardDAO) {
		boardService.deleteOneBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	//글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws Exception,IOException {
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/hgo-spring/upload/"+fileName));
			System.out.println("파일 업로드 처리 완료");
		}
		
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	//글 수정
	@RequestMapping(value="/updateBoard.do")
	public void updateBoard(BoardVO vo,BoardDAO boardDAO, HttpServletResponse response){
		boardService.updateBoard(vo);
		PrintWriter out=null;
		try {
			out = response.getWriter();
			out.print("<script>"
					+ "alert('수정되었습니다.');"
					+ "location.href='getBoardList.do';"
					+ "</script>");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	//글 상세보기
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}	
	
	//글 목록
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		//검색 유무 확인
		if(vo.getSearchCondition() == null) vo.setSearchCondition("title");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList",boardService.getBoardList(vo));
		model.addAttribute("paging",boardService.paging(vo));
		return "getBoardList";
	}
	
	//	jsp 에서 conditionMap 이라는 이름으로 사용 가능
	//	model 에서 보낼 때 함께 보내짐
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "title");
		conditionMap.put("내용", "content");
		return conditionMap;
	}
	
	
	//json 으로 변환
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo){
		vo.setSearchCondition("title");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
}
