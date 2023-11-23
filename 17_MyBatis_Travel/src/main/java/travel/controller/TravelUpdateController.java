package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	
	private final String command = "/update.tv";
	private final String viewPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String updateGet(@RequestParam("num") int num,
							@RequestParam(value = "pageNumber", required = false) int pageNumber,
							Model model) {
		
		TravelBean travelBean = travelDao.getTravel(num);
		model.addAttribute("travelBean",travelBean);
		model.addAttribute("pageNumber",pageNumber);
		
		return viewPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String updatePost(@Valid TravelBean tb, BindingResult bresult,
							 @RequestParam("num") int num,
							 @RequestParam("pageNumber") int pageNumber,
							 Model model) {
		
		if(bresult.hasErrors()) {
			model.addAttribute("pageNumber", pageNumber);
			return viewPage;
		}
		
		travelDao.updateTravel(tb);
		return gotoPage+"?pageNumber="+pageNumber;
	}
}
