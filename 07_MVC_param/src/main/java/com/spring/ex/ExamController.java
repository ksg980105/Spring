package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bean.MemberBean;
import bean.PersonBean;

@Controller
public class ExamController {
	
	@RequestMapping(value = "/person/input", method = RequestMethod.GET)
	public String result(HttpServletRequest request) {
		
		// http://localhost:8080/ex/person/input?name=suji&age=30
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		request.setAttribute("name", name);
		return "person/result";
	}
	
	@RequestMapping(value = "/person/input2", method = RequestMethod.GET)
	public String result2(@RequestParam("name") String name, @RequestParam("age") String age, HttpServletRequest request) {
		// http://localhost:8080/ex/person/input2?name=suji&age=30
		
		PersonBean pb = new PersonBean();
		pb.setName(name);
		pb.setAge(Integer.parseInt(age));
		pb.setAddr("seoul");
		
		request.setAttribute("pb", pb);
		
		return "person/result2";
	}
	
	@RequestMapping("person/form")
	public String input3() {
		return "person/form";
	}
	
	@RequestMapping(value = "/person/input3", method = RequestMethod.POST)
	public String view4(
							@RequestParam("id") String id, 
							@RequestParam("pw") String pw,
							@RequestParam("name") String name, 
							@RequestParam("age") String age,
							HttpServletRequest request
						) {
		
		MemberBean mb = new MemberBean();
		mb.setId(id);
		mb.setPw(pw);
		mb.setName(name);
		mb.setAge(Integer.parseInt(age));
		
		request.setAttribute("mb", mb);
		
		return "person/result3";
	}
	
	@RequestMapping(value = "/person/input4", method = RequestMethod.POST)
	public String input4(MemberBean mb, HttpServletRequest request) {
		
		return "person/result4";
	}
	
	@RequestMapping(value = "/person/input5", method = RequestMethod.POST)
	public String input5(@ModelAttribute("mBean") MemberBean mb) {
		
		//request.setAttribute("mBean",mb);
		return "person/result5";
	}
}
