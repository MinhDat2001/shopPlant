package com.minhdat.plant.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.service.CustomerService;
import com.minhdat.plant.service.ProductService;


@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	@Autowired
	CustomerService customerService;
	@Autowired
	ProductService productService;
	@RequestMapping("")
	public ModelAndView list(ModelMap model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return new ModelAndView( "redirect:/admin/login", model);
		long customer=customerService.count();
		long product=productService.count();
		model.addAttribute("customer", customer);
		model.addAttribute("product", product);
		System.out.println("customer:"+customer);
		return new ModelAndView( "admin/home", model);
	}
}
