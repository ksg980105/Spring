package movie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieInsertController {
	
	private final String command = "/insert.mv";
	private final String viewPage = "movieInsertForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String insertGet() {
		
		return viewPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String insertPost(@Valid MovieBean movieBean, BindingResult bresult) {
		
		if(bresult.hasErrors()) {
			return viewPage;
		}
		movieDao.insertMovie(movieBean);
		return gotoPage;
	}
}
