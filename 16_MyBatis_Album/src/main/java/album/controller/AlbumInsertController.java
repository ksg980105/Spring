package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {
	
	private final String command = "insert.ab";
	private final String viewPage = "albumInsertForm";
	private final String gotoPage = "redirect:/list.ab";
	
	@Autowired
	private AlbumDao albumdao; //AlbumDao 객체 주입
	
	//albumList.jsp에서 insert.ab GET방식 요청
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String actionGet() {
		
		return viewPage;
	}
	
	//albumInsertForm.jsp에서 insert.ab POST방식 요청
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String actionPost(@Valid AlbumBean ab, BindingResult result) {
		
		if(result.hasErrors()) {
			return viewPage;
		}
		
		int cnt = albumdao.insertAlbum(ab);
		return gotoPage;
	}
}
