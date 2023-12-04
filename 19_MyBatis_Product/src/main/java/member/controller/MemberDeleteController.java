package member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {
	
	private final String command = "delete.mb";
	private final String gotoPage = "redirect:memberList.mb";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(command)
	public ModelAndView delete(@RequestParam("id") String id, @RequestParam("pageNumber") String pageNumber) {
		memberDao.deleteMember(id);
		
		ModelAndView mav = new ModelAndView(gotoPage+"?pageNumber="+pageNumber);
		return mav;
	}
	
}
