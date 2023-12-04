package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;
import product.model.ProductBean;

@Controller
public class CartAddController {
	private final String command = "/add.mall";
	private final String gotoPage = "redirect:/list.mall";
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public String doAction(ProductBean productBean, HttpSession session,
							@RequestParam("pageNumber") String pageNumber) {
		System.out.println(productBean.getNum());
		System.out.println(productBean.getOrderqty());
		
		if(session.getAttribute("loginInfo") == null) { // 로그인x
			session.setAttribute("destination", "redirect:/detail.pd?num="+productBean.getNum()+"&pageNumber="+pageNumber);
			return "redirect:/loginForm.mb";
		} else { // 로그인o
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			if(mycart == null) {
				mycart = new MyCartList();
			}
			mycart.addOrder(productBean.getNum(), productBean.getOrderqty());
			session.setAttribute("mycart", mycart);
		}
		return gotoPage;
	}
}
