package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {
	
	private final String command = "/list.ab";
	private final String viewPage = "albumList";
	
	@Autowired
	@Qualifier("myAlbumDao")
	private AlbumDao albumDao;
	
	@RequestMapping(value=command)
	public ModelAndView list(@RequestParam(value="whatColumn",required=false) String whatColumn,
							 @RequestParam(value="keyword",required=false) String keyword,
							 @RequestParam(value="pageNumber",required=false) String pageNumber,
							 HttpServletRequest request) {
		
		System.out.println("whatColumn:" + whatColumn);
		System.out.println("keyword:" + keyword);
		System.out.println("pageNumber:" + pageNumber);
		
		//검색어에 해당하는 데이터만 출력
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		//전체 레코드 갯수
		int totalcount = albumDao.getTotalCount(map);
		System.out.println("totalcount:"+totalcount);
		
		String url = request.getContextPath()+command;
		System.out.println("url: "+url);
		
		String pageSize = "2"; //한번에 몇페이지씩 보일지
		Paging pageInfo = new Paging(pageNumber,pageSize,totalcount,url,whatColumn,keyword);
		
		//전체 데이터 출력
		List<AlbumBean> lists = albumDao.getAlbumList(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumLists", lists);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("totalCount",totalcount);
		mav.setViewName(viewPage);
		return mav;
	}
}
