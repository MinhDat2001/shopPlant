package com.minhdat.plant.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Account;
import com.minhdat.plant.service.AccountService;

@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {
	@Autowired
	AccountService accountService;
	@GetMapping("")
	public ModelAndView login(ModelMap model, HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")!=null)
			return new ModelAndView( "redirect:/admin", model);
		return new ModelAndView( "admin/admin-login", model);
	}
	@PostMapping("")
	public ModelAndView authen(ModelMap model,HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		List<Account> list=accountService.findAll();
		
		for(Account i:list) {
			if(i.getUsername().equals(username)&&i.getPassword().equals(password)) {
				HttpSession ss= request.getSession();
				ss.setAttribute("admin", username);
				return new ModelAndView( "redirect:/admin", model);
			}
		}
		model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
		return new ModelAndView( "admin/admin-login", model);
	}
}
