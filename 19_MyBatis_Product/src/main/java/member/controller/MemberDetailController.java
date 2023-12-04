package member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberDetailController {
	
	private final String command = "detail.mb";
	private final String viewPage = "memberDetailView";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(command)
	public ModelAndView detail(@RequestParam("id") String id) {
		MemberBean memberBean = memberDao.getMemberById(id);
		
		ModelAndView mav = new ModelAndView(viewPage);
		mav.addObject("memberBean", memberBean);
		return mav;
	}
	
}
