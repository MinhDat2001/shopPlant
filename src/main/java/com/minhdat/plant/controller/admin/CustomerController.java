package com.minhdat.plant.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Customer;
import com.minhdat.plant.domain.Product;
import com.minhdat.plant.service.CategoryService;
import com.minhdat.plant.service.CustomerService;
import com.minhdat.plant.service.ProductService;

@Controller
@RequestMapping("admin/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@RequestMapping("") 
	public ModelAndView list(ModelMap model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return new ModelAndView( "redirect:/admin/login", model);
		List<Customer> list=customerService.findAll();
		
		model.addAttribute("customers",list);
		
		return new ModelAndView( "admin/customer/list", model);
	}
}
