package album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumDetailController {
	
	private final String command = "detail.ab";
	private final String viewPage = "albumDetail";
	
	@Autowired
	private AlbumDao albumDao;
	
	@RequestMapping(value = command)
	public String detail(Model model, @RequestParam("num") int num) {
		
		AlbumBean album = albumDao.getAlbum(num);
		model.addAttribute("album", album);
		return viewPage;
	}
}
