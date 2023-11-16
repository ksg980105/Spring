package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping(value = "form")
	public String form() {
		return "redirect/form";
	}
	
	@RequestMapping(value = "input")
	public String input(HttpServletRequest request,
						@RequestParam("name") String name2,
						@RequestParam("age") int age,
						RedirectAttributes rAttr) {
		
		System.out.println("input()");
		System.out.println("name:" + name2);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mname", name2);
		map.put("mage", age);
		rAttr.addFlashAttribute("map1",map);
		
		
		request.setAttribute("name2", name2);
		
		//return "redirect/result";
		return "redirect:/last";
	}
	
	@RequestMapping("last")
	public String last(HttpServletRequest request) {
		System.out.println("last()");
		String name = request.getParameter("name");
		System.out.println("name:" + name);
		return "redirect/result";
	}
}
