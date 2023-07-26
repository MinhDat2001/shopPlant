package com.minhdat.plant.controller.site;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Cart;
import com.minhdat.plant.domain.Customer;
import com.minhdat.plant.domain.History;
import com.minhdat.plant.service.CartService;
import com.minhdat.plant.service.CustomerService;
import com.minhdat.plant.service.HistoryService;
import com.minhdat.plant.service.ProductService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	CustomerService customerService;
	@Autowired
	HistoryService historyService;
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	@RequestMapping("")
	public ModelAndView cart(ModelMap model, HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("username")==null)
			return new ModelAndView( "redirect:/login", model);
		String email=(String) ss.getAttribute("username");
		Long id=(long) 0;
		List<Customer> list=customerService.findAll();
		for(Customer i: list) {
			if(i.getEmail().equals(email)) {
				id=i.getCustomerId();
			}
		}
		Customer customer=customerService.getById(id);
		double total=0;
		for(Cart i: customer.getCarts()) {
			total+=(i.getQuantity()*i.getCart_product().getPrice());
		}
		System.out.println(customer.getEmail());
		model.addAttribute("customer", customer);
		model.addAttribute("total", (int)total);
		return new ModelAndView( "site/checkout", model);
	}
	@RequestMapping("/authen")
	public ModelAndView authen(ModelMap model, HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("username")==null)
			return new ModelAndView( "redirect:/login", model);
		String email=(String) ss.getAttribute("username");
		Long id=(long) 0;
		List<Customer> list=customerService.findAll();
		for(Customer i: list) {
			if(i.getEmail().equals(email)) {
				id=i.getCustomerId();
			}
		}
		Customer customer=customerService.getById(id);
		for( Cart i : customer.getCarts()) {
			History history=new History(i.getCart_customer(), i.getCart_product(), i.getQuantity(), i.getCart_product().getPrice(), 1);
			historyService.save(history);
			cartService.deleteById(i.getCartId());
			System.out.println(history);
			System.out.println("sdfd"+customer.getFirstName());
		}
		model.addAttribute("customer",customer);
		return new ModelAndView( "redirect:/profile", model);
	}
}
