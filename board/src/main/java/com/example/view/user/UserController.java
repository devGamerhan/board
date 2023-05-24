package com.example.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.user.UserService;
import com.example.user.UserVO;
import com.example.user.impl.UserDAO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("do 요청으로 로그인 화면");
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("login");
		return mav;
	}
		
	//로그인
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public ModelAndView login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		if(vo.getId()==null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디 반드시 입력");
		}
		
		UserVO user = userService.getUser(vo);
		ModelAndView mav = new ModelAndView();				// request에 저장됨
		
		if(user != null) {
			System.out.println("유저 정보 있음");
			System.out.println("세션 : "+user.toString());
			
			session.setAttribute("id",user.getId());
			session.setAttribute("name",user.getName());
			session.setAttribute("role",user.getRole());
			
			mav.setViewName("redirect:getBoardList.do");
		}
		else {
			mav.setViewName("redirect:login.do");
		}
		return mav;
	}
	
	//로그아웃
	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}
}
