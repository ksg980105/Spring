package mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class OrderMallController {
	private final String command = "order.mall";
	private final String viewPage = "shopList";
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(command)
	public String mall(HttpSession session, Model model) {
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		if(mb==null) {
			session.setAttribute("destination", "redirect:order.mall");
			return "redirect:loginForm.mb";
		} else {
			List<OrderBean> lists = orderDao.getMyOrder(mb.getId());
			model.addAttribute("lists", lists);
		}
		return viewPage;
	}
}
