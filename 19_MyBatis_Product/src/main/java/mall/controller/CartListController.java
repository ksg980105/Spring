package mall.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class CartListController {
	private final String command = "/list.mall";
	private final String viewPage = "mallList";
	
	@Autowired
	private ProductDao productDao;
	
	//CartAddController¿¡¼­ ³Ñ¾î¿È
	@RequestMapping(command)
	public String list(HttpSession session, Model model) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		
		Map<Integer, Integer> mapList = mycart.getAllOrderList();
		List<ShoppingInfo> shopLists = new ArrayList<ShoppingInfo>();
		// int totalAmount = 0;
		for(int key : mapList.keySet()) {
			ShoppingInfo shopInfo = new ShoppingInfo();
			ProductBean productBean = productDao.getProductByNum(key);
			shopInfo.setPnum(key);
			shopInfo.setPname(productBean.getName());
			shopInfo.setQty(mapList.get(key));
			shopInfo.setPrice(Integer.parseInt(productBean.getPrice()));
			shopInfo.setAmount(shopInfo.getPrice()*shopInfo.getQty());
			// totalAmount += mapList.get(key) * Integer.parseInt(productBean.getPrice());
			
			shopLists.add(shopInfo);
		}
		
		model.addAttribute("shopLists", shopLists);
		// model.addAttribute("totalAmount", totalAmount);
		return viewPage;
	}
}
