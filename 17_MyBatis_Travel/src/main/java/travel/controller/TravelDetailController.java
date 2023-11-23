package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelDetailController {
	
	private final String command = "/detail.tv";
	private final String viewPage = "travelDetailView";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value = command)
	public String detail(@RequestParam("num") int num,
						 @RequestParam(value = "pageNumber", required = false) int PageNumber,
						 Model model) {
		
		TravelBean travelBean = travelDao.getTravel(num);
		
		model.addAttribute("travelBean",travelBean);
		model.addAttribute("pageNumber",PageNumber);
		return viewPage;
	}
}
