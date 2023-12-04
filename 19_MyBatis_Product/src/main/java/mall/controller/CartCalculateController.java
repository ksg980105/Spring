package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {
	private final String command = "/calculate.mall";
	private final String gotoPage = "redirect:/list.pd";

	@Autowired
	private ProductDao productDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@RequestMapping(command)
	public String calculate(HttpSession session) {
		MyCartList mycart = (MyCartList) session.getAttribute("mycart");
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		// mycart session 설정 위치: CartAddController
		if (mycart != null) {
			Map<Integer, Integer> mapLists = mycart.getAllOrderList();
			Set<Integer> keylist = mapLists.keySet();
			
			/*
			 * id: lee 주문 
			 * 1회차: 1,3 / 7,2 / 13,4
			 * 2회차: 5,1 / 7,2
			 * 3회차: 10,1
			 * 
			 * 1회차: 3가지 상품
			 * 2회차: 2가지 상품
			 * 3회차: 1가지 상품
			 */
			
			orderDao.insertOrder(mb.getId());
			int oid = orderDao.getMax();
			
			
			for(int pnum:keylist) {
				int qty = mapLists.get(pnum);
				productDao.updateStock(pnum, qty);
				
				orderDetailDao.insertDetail(oid, pnum, qty);
			}
			
			memberDao.updateMpoint(((MemberBean)session.getAttribute("loginInfo")).getId(), 100);
			// loginInfo session 설정 위치: MemberLoginController
		}
		return gotoPage;
	}

}
