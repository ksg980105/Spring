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
		// mycart session ���� ��ġ: CartAddController
		if (mycart != null) {
			Map<Integer, Integer> mapLists = mycart.getAllOrderList();
			Set<Integer> keylist = mapLists.keySet();
			
			/*
			 * id: lee �ֹ� 
			 * 1ȸ��: 1,3 / 7,2 / 13,4
			 * 2ȸ��: 5,1 / 7,2
			 * 3ȸ��: 10,1
			 * 
			 * 1ȸ��: 3���� ��ǰ
			 * 2ȸ��: 2���� ��ǰ
			 * 3ȸ��: 1���� ��ǰ
			 */
			
			orderDao.insertOrder(mb.getId());
			int oid = orderDao.getMax();
			
			
			for(int pnum:keylist) {
				int qty = mapLists.get(pnum);
				productDao.updateStock(pnum, qty);
				
				orderDetailDao.insertDetail(oid, pnum, qty);
			}
			
			memberDao.updateMpoint(((MemberBean)session.getAttribute("loginInfo")).getId(), 100);
			// loginInfo session ���� ��ġ: MemberLoginController
		}
		return gotoPage;
	}

}
