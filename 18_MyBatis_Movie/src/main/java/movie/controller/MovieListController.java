package movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieBean;
import movie.model.MovieDao;
import utility.Paging;

@Controller
public class MovieListController {
	
	private final String command = "/list.mv";
	private final String viewPage = "movieList";
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(value = command)
	public String list(Model model,
						@RequestParam(value = "whatColumn", required = false) String whatColumn,
						@RequestParam(value = "keyword", required = false) String keyword,
						@RequestParam(value="pageNumber",required=false) String pageNumber,
						HttpServletRequest request) {

		
		//검색어
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = movieDao.getTotalCount(map);
		
		//페이지처리
		String url = request.getContextPath()+command;
		String pageSize = "2";
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		
		//리스트 출력
		List<MovieBean> lists = movieDao.getAllMovie(map, pageInfo);
		model.addAttribute("lists", lists);
		model.addAttribute("pageInfo", pageInfo);
		
		return viewPage;
	}
}
