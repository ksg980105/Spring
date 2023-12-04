package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductUpdateController {

	private final String command = "/update.pd";
	private final String viewPage = "productUpdateForm";
	private final String gotoPage = "redirect:/list.pd";

	@Autowired
	ServletContext servletContext;

	@Autowired
	ProductDao productDao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String update(HttpSession session, @RequestParam("num") int num, Model model) {

		if (session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/update.pd");
			session.setAttribute("num", num);
			return "redirect:/loginForm.mb";
		} else {
			ProductBean productBean = productDao.getProductByNum(num);
			model.addAttribute("productBean", productBean);
			return viewPage;
		}
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String update(@Valid ProductBean pb, BindingResult bresult, @RequestParam("pageNumber") String pageNumber) {

		if (bresult.hasErrors()) {
			return viewPage;
		}

		String uploadPath = servletContext.getRealPath("/resources/uploadFolder/");
		System.out.println("uploadPath:" + uploadPath);

		File img = new File(uploadPath + File.separator + pb.getUpload2());
		img.delete(); // 웹서버폴더의 기존 이미지 삭제

		productDao.updateProduct(pb);
		File destination = new File(uploadPath + File.separator + pb.getImage()); 

		MultipartFile multi = pb.getUpload(); 

		try {
			multi.transferTo(destination); // 웹서버폴더의 새 이미지 업로드
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return gotoPage + "?pageNumber=" + pageNumber;
	}
}
