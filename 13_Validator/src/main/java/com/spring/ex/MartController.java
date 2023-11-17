package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MartController {
	
	@RequestMapping(value = "insertProc", method = RequestMethod.GET)
	public String form() {
		return "insertForm";
	}
	
	@RequestMapping(value = "insertProc", method = RequestMethod.POST)
	public String result(@Valid MartBean mb, BindingResult result) {
		
		String page = "result";
		if(result.hasErrors()) {
			page = "insertForm";
		}
		return page;
	}
}
