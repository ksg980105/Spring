package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@RequestMapping(value = "a")
	public String a() {
		return "sample/a";
	}
	
	@RequestMapping(value = "/b")
	public String b() {
		return "sample/b";
	}
	
	@RequestMapping(value = "/c")
	public String c() {
		return "sample/c";
	}
}
