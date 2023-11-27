package movie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieUpdateController {
	
	private final String command = "/update.mv";
	private final String viewPage = "movieUpdateForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String updateGet(@RequestParam("num") int num,
			 				@RequestParam("pageNumber") int pageNumber,
			 				Model model) {
		
		MovieBean movieBean = movieDao.getDetail(num);
		model.addAttribute("movieBean", movieBean);
		model.addAttribute("pageNumber", pageNumber);
		return viewPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String updatePost(@Valid MovieBean movieBean, BindingResult bresult,
								@RequestParam("num") int num,
								@RequestParam("pageNumber") int pageNumber,
								Model model) {
		
		if(bresult.hasErrors()) {
			model.addAttribute("pageNumber", pageNumber);
			return viewPage;
		}
		int cnt = movieDao.updateMovie(movieBean);
		if(cnt != -1) {
			return gotoPage + "?pageNumber="+pageNumber;
		}else {
			return viewPage;
		}
	}
}
