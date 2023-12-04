package member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberInsertController {
	
	private final String command = "/memberInsert.mb";
	private final String viewPage = "memberInsertForm";
	private final String gotoPage = "redirect:/memberList.mb";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String insertForm() {
		return viewPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView insert(@Valid MemberBean memberBean, BindingResult result, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(viewPage);
			return mav;
		}
		
		
		int cnt = memberDao.insertMember(memberBean);
		if(cnt == -1) { // 아이디 중복됨
			mav.setViewName(viewPage);
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append("<script>alert('아이디가 중복됐습니다.')</script>");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return mav;
		} if(cnt == -2) { // DB 테이블 형식에 맞지 않음
			mav.setViewName(viewPage);
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append("<script>alert('DB 테이블 형식에 맞지 않음')</script>");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return mav;
		} else { // insert 성공
			mav.setViewName(gotoPage);
			return mav;
		}
	}
	
}
