package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	
	private final String command = "/list.tv";
	private final String viewPage = "travelList";
	
	@Autowired
	@Qualifier("myTravelDao")
	private TravelDao travelDao;
	
	@RequestMapping(value = command)
	public String list(Model model,
					   @RequestParam(value = "whatColumn", required = false) String whatColumn,
					   @RequestParam(value = "keyword", required = false) String keyword,
					   @RequestParam(value="pageNumber",required=false) String pageNumber,
					   HttpServletRequest request) {
		
		//검색한 항목만 출력
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		//전체 레코드 갯수
		int totalCount = travelDao.getTotalCount(map);
		
		//페이지 설정
		String url = request.getContextPath()+command;
		String pageSize = "2";
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		
		//전체 리스트 출력
		List<TravelBean> lists = travelDao.getAllTravel(map, pageInfo);
		model.addAttribute("lists",lists);
		model.addAttribute("pageInfo",pageInfo);
		return viewPage;
		
	}
}
