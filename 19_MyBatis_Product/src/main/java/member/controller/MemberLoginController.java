package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberLoginController {
	private final String command = "/loginForm.mb";
	private final String viewPage = "memberLoginForm";
	private final String gotoPage = "";

	@Autowired
	private MemberDao memberDao;

	// ProductInsertController GET
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return viewPage;
	}

	// memberLoginForm.jsp
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(MemberBean memberBean, HttpServletResponse response, HttpSession session)
			throws IOException {
		ModelAndView mav = new ModelAndView();

		MemberBean memberBean2 = memberDao.getMemberById(memberBean.getId());
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (memberBean2 == null) {
			out.append("<script>alert('�������� �ʴ� ���̵��Դϴ�.')</script>");
			out.flush();
			mav.setViewName(viewPage);
		} else { // ���̵� ������
			if (memberBean2.getPassword().equals(memberBean.getPassword())) { // ����� ��ġ��
				session.setAttribute("loginInfo", memberBean2);
				mav.addObject("num", session.getAttribute("num"));
				mav.setViewName((String) session.getAttribute("destination"));
				// "destination", "redirect: insert.pd"
				// "destination", "redirect: detail.pd?num=3&pageNumber=2"
				// "destination", "redirect: order.mall"
				// -> �Ź� �ٲ��.
			} else { // ����� ��ġ����
				out.append("<script>alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.')</script>");
				out.flush();
				mav.setViewName(viewPage);
			}
		}
		return mav;
	}
}
