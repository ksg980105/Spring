package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {

	private final String command = "update.ab";
	private final String viewPage = "albumUpdateForm";
	private final String gotoPage = "redirect:/list.ab";
	
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String update(Model model, 
						@RequestParam("num") int num, 
						@RequestParam("pageNumber") int pageNumber) {
		
		AlbumBean album = albumDao.getAlbum(num);
		model.addAttribute("albumBean",album);
		model.addAttribute("pageNumber",pageNumber);
		return viewPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update(@Valid AlbumBean album, BindingResult result, 
								@RequestParam("pageNumber") int pageNumber, 
								@RequestParam("num") int num) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(viewPage);
			return mav;
		}
		albumDao.updateAlbum(album);
		mav.setViewName(gotoPage+"?pageNumber="+pageNumber);
		return mav;
	}
}
