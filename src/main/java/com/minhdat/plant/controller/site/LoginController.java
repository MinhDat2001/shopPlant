package com.minhdat.plant.controller.site;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.minhdat.plant.domain.Customer;
import com.minhdat.plant.service.CustomerService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	CustomerService customerService;
	@RequestMapping("")
	public ModelAndView login(ModelMap model, HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("username")!=null)
			return new ModelAndView( "redirect:/", model);
		return new ModelAndView( "site/login", model);
	}
	@PostMapping("/authen")
	public ModelAndView authen(ModelMap model,HttpServletRequest request) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		List<Customer> list=customerService.findAll();
		
		for(Customer i:list) {
			if(i.getEmail().equals(email)&&i.getPassword().equals(password)) {
				HttpSession ss= request.getSession();
				ss.setAttribute("username", email);
				return new ModelAndView( "redirect:/", model);
			}
		}
		model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
		return new ModelAndView( "forward:/login", model);
	}
	
}
