package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String update(Model model, @RequestParam("num") int num) {
		
		AlbumBean album = albumDao.getAlbum(num);
		model.addAttribute("album",album);
		return viewPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String update(@Valid AlbumBean album, BindingResult result) {
		
		if(result.hasErrors()) {
			return viewPage;
		}
		albumDao.updateAlbum(album);
		return gotoPage;
	}
}
