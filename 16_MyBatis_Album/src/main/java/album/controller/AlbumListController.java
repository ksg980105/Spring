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
		
		//�˻�� �ش��ϴ� �����͸� ���
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		//��ü ���ڵ� ����
		int totalcount = albumDao.getTotalCount(map);
		System.out.println("totalcount:"+totalcount);
		
		String url = request.getContextPath()+command;
		System.out.println("url: "+url);
		
		String pageSize = "2"; //�ѹ��� ���������� ������
		Paging pageInfo = new Paging(pageNumber,pageSize,totalcount,url,whatColumn,keyword);
		
		//��ü ������ ���
		List<AlbumBean> lists = albumDao.getAlbumList(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumLists", lists);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("totalCount",totalcount);
		mav.setViewName(viewPage);
		return mav;
	}
}
