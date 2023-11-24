package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import movie.model.MovieDao;

@Controller
public class MovieCheckController {
	
	private final String command = "title_check_proc.mv";
	private final String viewPage = "movieInsertForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(value = command)
	@ResponseBody
	public String check(@RequestParam(value="inputtitle") String inputtitle) {
		
		int cnt = movieDao.findTitle(inputtitle);
		if(cnt == 0) {
			return "YES";
		}else {
			return "NO";
		}
	}
}
