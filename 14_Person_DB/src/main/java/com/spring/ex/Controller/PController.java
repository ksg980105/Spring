package com.spring.ex.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.PCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PWriteCommand;

@Controller
public class PController {
	
	PCommand command = null;
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Model model, HttpServletRequest request) {
		model.addAttribute("req", request);
		
		command = new PWriteCommand();
		command.execute(model);
		
		return "redirect:/list"; //list.jsp
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new PListCommand();
		command.execute(model);
		return "list";
	}
}
