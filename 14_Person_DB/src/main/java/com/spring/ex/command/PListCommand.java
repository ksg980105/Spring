package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.pDao;
import com.spring.ex.dto.pDto;

public class PListCommand implements PCommand{

	@Override
	public void execute(Model model) {
		pDao dao = pDao.getInstance();
		ArrayList<pDto> lists = dao.list();
		model.addAttribute("lists", lists);
	}

}
