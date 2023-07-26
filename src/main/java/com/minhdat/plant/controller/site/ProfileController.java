package com.minhdat.plant.controller.site;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Customer;
import com.minhdat.plant.service.CustomerService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	CustomerService customerService;
	@RequestMapping("")
	public ModelAndView login(ModelMap model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("username")==null)
			return new ModelAndView( "redirect:/login", model);
		String email=(String) ss.getAttribute("username");
		Long id=null;
		List<Customer> list=customerService.findAll();
		for(Customer i: list) {
			if(i.getEmail().equals(email)) {
				id=i.getCustomerId();
			}
		}
		Customer customer= customerService.getById(id);
		model.addAttribute("customer",customer);
		return new ModelAndView( "site/profile", model);
	}
	@RequestMapping("/save")
	public ModelAndView save(ModelMap model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("username")==null)
			return new ModelAndView( "redirect:/login", model);
		String email=(String) ss.getAttribute("username");
		Long id=null;
		List<Customer> list=customerService.findAll();
		for(Customer i: list) {
			if(i.getEmail().equals(email)) {
				id=i.getCustomerId();
			}
		}
		Customer customer= customerService.getById(id);
		String fname=request.getParameter("fName");
		customer.setFirstName(fname);
		String lname=request.getParameter("lName");
		customer.setFirstName(lname);
		String address=request.getParameter("address");
		customer.setAddress(address);
		String phone=request.getParameter("phone");
		customer.setPhoneNumber(phone);
		model.addAttribute("customer",customer);
		return new ModelAndView( "site/profile", model);
	}
}
