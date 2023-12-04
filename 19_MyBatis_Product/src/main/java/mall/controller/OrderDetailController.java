package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.ShoppingInfo;
import orderdetail.model.OrderDetailDao;

@Controller
public class OrderDetailController {
	private final String command = "orderDetail.mall";
	private final String viewPage = "shopResult";
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@RequestMapping(command)
	public String orderDetail(@RequestParam("oid") int oid, HttpSession session, Model model) {
		List<ShoppingInfo> lists = orderDetailDao.getMyOrderDetail(oid);
		model.addAttribute("lists", lists);
		return viewPage;
	}
}
