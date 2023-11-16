package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value = "memberForm", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "memberForm", method = RequestMethod.POST)
	public String result(@Valid MemberBean mb, BindingResult bresult) {
		System.out.println("bresult.hasErrors():" + bresult.hasErrors());
		
		String page = "result";
		if(bresult.hasErrors()) { //에러 발생
			page = "form";
		}
		return page;
	}
}
