package com.minhdat.plant.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.History;
import com.minhdat.plant.service.HistoryService;

@Controller
@RequestMapping("admin/histories")
public class HistoryController {
	@Autowired
	HistoryService historyService;
	@RequestMapping("")
	public ModelAndView show(ModelMap model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return new ModelAndView( "redirect:/admin/login", model);
		List<History> list=historyService.findAll();
		model.addAttribute("histories",list);
		
		return new ModelAndView("admin/histories/history", model);
	}
}
