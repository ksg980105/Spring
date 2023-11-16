package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamController {
	
	@RequestMapping(value = "/board/form")
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id","kim");
		mav.setViewName("board/form");
		return mav;
	}
	
	@RequestMapping(value = "/board/form1")
	public String view1(HttpServletRequest request) {
		request.setAttribute("id", "kim");
		return "form1";
	}
}
