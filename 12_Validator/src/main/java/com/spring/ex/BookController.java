package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
	@RequestMapping(value = "bookForm", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "bookForm", method = RequestMethod.POST)
	public String result(@Valid BookBean bb, BindingResult bresult) {
		
		String page = "result";
		if(bresult.hasErrors()) {
			page = "form";
		}
		return page;
	}
}
