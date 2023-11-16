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
	
	/* form요청에 따라 form.jsp로 이동 */
	@RequestMapping("form")
	public String form() {
		return "form";
	}
	
	/* getParameter로 받아서 model 속성 설정 */
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
	
	/* @RequestParam으로 MusicBean 객체를 model 속성 설정 */
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
	
	/* MusicBean 객체를 ModelAndView로 만들어서 result3 출력 */
	@RequestMapping(value="input3", method = RequestMethod.POST)
	public ModelAndView view3(HttpServletRequest request) {
		
		MusicBean mb = new MusicBean();
		
		mb.setTitle(request.getParameter("title"));
		mb.setSinger(request.getParameter("singer"));
		mb.setPrice(Integer.parseInt(request.getParameter("price")));

		ModelAndView mav = new ModelAndView();

		mav.addObject("mb", mb);	//무엇을 가지고 갈지
		mav.setViewName("result3");	//어디로 갈지
		
		return mav;
	}
	
	/* command 객체를 이용해서 출력 */
	@RequestMapping(value="input4", method = RequestMethod.POST)
	public String view4(MusicBean mb) {
		
		return "result4";
	}
	
	/* command객체 별칭 설정해서 출력 */
	@RequestMapping(value="input5", method = RequestMethod.POST)
	public String view5(@ModelAttribute("mbean") MusicBean mb) {
		
		//System.out.println(mb.getTitle()); 별칭은 jsp에서만 mbean으로 사용
		return "result5";
	}
	
}
