package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductDetailController {
	
	private final String command = "/detail.pd";
	private final String viewPage = "productDetail";
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = command)
	public String detail(@RequestParam("num") int num,
						 @RequestParam("pageNumber") int pageNumber,
						 Model model) {
		
		ProductBean productBean = productDao.getProductByNum(num);
		model.addAttribute("productBean",productBean);
		model.addAttribute("pageNumber",pageNumber);
		return viewPage;
	}
}
