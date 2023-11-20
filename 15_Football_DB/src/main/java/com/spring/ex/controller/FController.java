package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.FCommand;
import com.spring.ex.command.FDeleteCommand;
import com.spring.ex.command.FListCommand;
import com.spring.ex.command.FUpdateCommand;
import com.spring.ex.command.FUpdateFormCommand;
import com.spring.ex.command.FWriteCommand;
import com.spring.ex.dto.FDto;

@Controller
public class FController {

	FCommand command;
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String form() {
		return "write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Model model, @ModelAttribute("fDto") @Valid FDto fDto, BindingResult result) {
		model.addAttribute("fDto", fDto);
		
		command = new FWriteCommand();
		command.execute(model);
		
		if(result.hasErrors()) {
			return "write";
		}
		
		return "redirect:/list";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new FListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("delete")
	public String delete(Model model, HttpServletRequest request) {
		model.addAttribute("req", request);
		
		command = new FDeleteCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateForm(Model model, FDto fDto) {
		model.addAttribute("fDto", fDto);
		
		command = new FUpdateFormCommand();
		command.execute(model);
		
		return "updateForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute("fdto") @Valid FDto fDto, BindingResult result) {
		model.addAttribute("fDto", fDto);
		
		command = new FUpdateCommand();
		command.execute(model);
		
		if(result.hasErrors()) {
			return "updateForm";
		}
		
		return "redirect:/list";
	}
	
}
