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
	ServletContext servletContext; //������ �ϳ��� ��������� servletContext ��ü ����
	
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
		
		//������ ���� ��ġ
		// C:\Spring_ksg\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\19_MyBatis_Product\resources
		String uploadPath = servletContext.getRealPath("/resources/uploadFolder/");
		System.out.println("uploadPath:" + uploadPath); //���ڿ��� �����ϴ� ������ ���ϸ�
		
		productDao.insertProduct(pb); //�����ͺ��̽��� ����
		File destination = new File(uploadPath+File.separator+pb.getImage()); //��¥ ���Ϸ� ��ȯ
		
		MultipartFile multi = pb.getUpload();
		
		try {
			multi.transferTo(destination); //���ϴ� ��ġ�� ������ �ø��� ���� �� ���
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return gotoPage;
	}
}
