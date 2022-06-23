package com.minhdat.plant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public ModelAndView login(ModelMap model, HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("username")!=null)
			model.addAttribute("email", ss.getAttribute("username"));
		return new ModelAndView( "site/index", model);
	}
}
