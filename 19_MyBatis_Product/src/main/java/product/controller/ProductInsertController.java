package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductInsertController {
	
	private final String command = "/insert.pd";
	private final String viewPage = "productInsertForm";
	private final String gotoPage = "redirect:/list.pd";
	
	@Autowired
	ServletContext servletContext; //서버당 하나만 만들어지는 servletContext 객체 생성
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String insertGet() {
		
		return viewPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String insertPost(@Valid ProductBean pb, BindingResult bresult) {
		
		if(bresult.hasErrors()) {
			return viewPage;
		}
		
		//웹서버 폴더 위치
		// C:\Spring_ksg\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\19_MyBatis_Product\resources
		String uploadPath = servletContext.getRealPath("/resources/uploadFolder/");
		System.out.println("uploadPath:" + uploadPath); //문자열로 존재하는 폴더와 파일명
		
		productDao.insertProduct(pb); //데이터베이스에 삽입
		File destination = new File(uploadPath+File.separator+pb.getImage()); //진짜 파일로 변환
		
		MultipartFile multi = pb.getUpload();
		
		try {
			multi.transferTo(destination); //원하는 위치에 파일을 올리고 싶을 때 사용
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return gotoPage;
	}
}
