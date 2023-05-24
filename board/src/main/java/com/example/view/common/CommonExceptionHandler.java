package com.example.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.example.view")
public class CommonExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView NullPointerHandler(Exception e) {
		System.out.println("null point");
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("redirect:/common/nullPointerError.jsp");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView ExceptionHandler(Exception e) {
		System.out.println("exception - "+e);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.getMessage());
		mav.setViewName("redirect:/common/error.jsp");
		return mav;
	}
}
