package member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {

	private final String command = "update.mb";
	private final String viewPage = "memberUpdateForm";
	private final String gotoPage = "redirect:memberList.mb";

	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String updateForm(Model model, @RequestParam("id") String id) {
		model.addAttribute("memberBean", memberDao.getMemberById(id));
		return viewPage;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String update(@RequestParam("pageNumber") String pageNumber, @Valid MemberBean memberBean,
			BindingResult result, HttpServletResponse response) {

		if (result.hasErrors()) {
			return viewPage;
		}

		int cnt = memberDao.updateMember(memberBean);
		if (cnt == -1) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().write("<script>alert('DB 테이블 형식에 맞지 않습니다')</script>");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return viewPage;
		} else {
			return gotoPage + "?pageNumber=" + pageNumber;
		}
	}

}
