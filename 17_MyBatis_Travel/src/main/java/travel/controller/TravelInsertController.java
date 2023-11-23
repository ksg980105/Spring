package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {
	
	private final String command = "/insert.tv";
	private final String viewPage = "travelInsertForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String insertGet() {
		
		return viewPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String insertPost(@Valid TravelBean tb, BindingResult bresult) {
		
		if(bresult.hasErrors()) {
			return viewPage;
		}
		travelDao.insertTravel(tb);
		return gotoPage;
	}
}
