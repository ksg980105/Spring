package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieDetailController {
	
	private final String command = "/detail.mv";
	private final String viewPage = "movieDetailView";
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(value = command)
	public String detail(@RequestParam("num") int num,
						 @RequestParam("pageNumber") int pageNumber,
						 Model model) {
		
		MovieBean movieBean = movieDao.getDetail(num);
		model.addAttribute("movieBean", movieBean);
		model.addAttribute("pageNumber", pageNumber);
		return viewPage;
	}
}
