package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import music.MusicBean;

@Controller
public class MusicController {
	
	/* form��û�� ���� form.jsp�� �̵� */
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	/* getParameter�� �޾Ƽ� model �Ӽ� ���� */
	@RequestMapping(value="input1", method = RequestMethod.POST)
	public String view1(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		int price = Integer.parseInt(request.getParameter("price"));
		
		model.addAttribute("title", title);
		model.addAttribute("singer", singer);
		model.addAttribute("price", price);
		
		return "result1";
	}
	
	/* @RequestParam���� MusicBean ��ü�� model �Ӽ� ���� */
	@RequestMapping(value="input2", method = RequestMethod.POST)
	public String view2(@RequestParam("title") String title,
						@RequestParam("singer") String singer,
						@RequestParam("price") int price,
						Model model) {
		
		MusicBean mb = new MusicBean();
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(price);
		
		model.addAttribute("mb", mb);
		
		return "result2";
	}
	
	/* MusicBean ��ü�� ModelAndView�� ���� result3 ��� */
	@RequestMapping(value="input3", method = RequestMethod.POST)
	public ModelAndView view3(HttpServletRequest request) {
		
		MusicBean mb = new MusicBean();
		
		mb.setTitle(request.getParameter("title"));
		mb.setSinger(request.getParameter("singer"));
		mb.setPrice(Integer.parseInt(request.getParameter("price")));

		ModelAndView mav = new ModelAndView();

		mav.addObject("mb", mb);	//������ ������ ����
		mav.setViewName("result3");	//���� ����
		
		return mav;
	}
	
	/* command ��ü�� �̿��ؼ� ��� */
	@RequestMapping(value="input4", method = RequestMethod.POST)
	public String view4(MusicBean mb) {
		
		return "result4";
	}
	
	/* command��ü ��Ī �����ؼ� ��� */
	@RequestMapping(value="input5", method = RequestMethod.POST)
	public String view5(@ModelAttribute("mbean") MusicBean mb) {
		
		//System.out.println(mb.getTitle()); ��Ī�� jsp������ mbean���� ���
		return "result5";
	}
	
}
