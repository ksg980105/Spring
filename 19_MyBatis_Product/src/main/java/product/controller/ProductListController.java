package product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.ProductBean;
import product.model.ProductDao;
import utility.Paging;

@Controller
public class ProductListController {

	private final String command = "/list.pd";
	private final String viewPage = "productList";
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = command)
	public String list(Model model, 
						@RequestParam(value = "whatColumn",required = false) String whatColumn,
						@RequestParam(value = "keyword",required = false) String keyword,
						@RequestParam(value = "pageNumber",required = false) String pageNumber,
						HttpServletRequest request){
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = productDao.getTotalCount(map);
		
		String url = request.getContextPath()+command;
		Paging pageInfo = new Paging(pageNumber, null, totalCount, url, whatColumn, keyword);
		
		List<ProductBean> lists = productDao.getAllProduct(map, pageInfo);
		model.addAttribute("lists", lists);
		model.addAttribute("pageInfo",pageInfo);
		return viewPage;
	}
}
