package com.example.view.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.user.UserVO;
import com.example.user.impl.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@Controller
//public class LoginController {
//
//	@RequestMapping(value="/login.do")
//	public ModelAndView login(UserVO vo, UserDAO userDAO, HttpServletRequest request) {
//		UserVO user = userDAO.getUser(vo);
//		ModelAndView mav = new ModelAndView();				// request에 저장됨
//		
//		if(user != null) {
//			System.out.println("유저 정보 있음");
//			System.out.println("세션 : "+user.toString());
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("id",user.getId());
//			session.setAttribute("name",user.getName());
//			session.setAttribute("role",user.getRole());
//			
//			mav.setViewName("redirect:getBoardList.do");
//		}
//		else {
//			mav.setViewName("login.jsp");
//		}
//		return mav;
//	}
//
//}
