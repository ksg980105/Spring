package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("testForm")
	public String form() {
		return "test/form";
	}
	
	@RequestMapping("test/insert")
	public String result(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		
		request.setAttribute("rid", id);
		request.setAttribute("rpw", pw);
		return "test/result";
	}
}
