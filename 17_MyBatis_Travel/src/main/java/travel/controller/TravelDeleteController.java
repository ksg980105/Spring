package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {

	private final String command = "/delete.tv";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value = command)
	public String delete(@RequestParam("num") int num,
						 @RequestParam(value = "pageNumber", required = false) int pageNumber) {
		
		travelDao.deleteTravel(num);
		return gotoPage+"?pageNumber="+pageNumber;
	}
}
