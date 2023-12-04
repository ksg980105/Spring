package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {
	
	private final String command = "/delete.pd";
	private final String gotoPage = "redirect:/list.pd";
	
	@Autowired
	ProductDao productDao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command)
	public String delete(@RequestParam("num") int num,
						 @RequestParam("pageNumber") int pageNumber,
						 @RequestParam("image") String image,
						 Model model) {
		
		productDao.deleteProduct(num);
		
		File img = new File(servletContext.getRealPath("resources/uploadFolder/")+File.separator+image);
		img.delete();
		
		return gotoPage + "?pageNumber=" + pageNumber;
	}
}
