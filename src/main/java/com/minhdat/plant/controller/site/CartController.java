package com.minhdat.plant.controller.site;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Cart;
import com.minhdat.plant.domain.Customer;
import com.minhdat.plant.domain.Product;
import com.minhdat.plant.service.CartService;
import com.minhdat.plant.service.CustomerService;
import com.minhdat.plant.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CustomerService customerService;
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
		Customer customer= new Customer();
		List<Customer> list=customerService.findAll();
		for(Customer i: list) {
			if(i.getEmail().equals(email)) {
				customer.setCarts(i.getCarts());
			}
		}
		double total=0;
		for(Cart i: customer.getCarts()) {
			total+=(i.getQuantity()*i.getCart_product().getPrice());
		}
		model.addAttribute("customer", customer);
		model.addAttribute("total", (int)total);
		return new ModelAndView( "site/cart", model);
	}
	
	
	
	@RequestMapping("/{productId}")
	public ModelAndView add(ModelMap model, HttpServletRequest request,@PathVariable("productId") Long productId) {
		HttpSession ss= request.getSession();
		int quantity=Integer.parseInt( request.getParameter("quantity"));
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
		Product product=productService.getById(productId);
		Cart cart=new Cart(customer, product,quantity);
		cartService.save(cart);
		return new ModelAndView( "forward:/cart", model);
	}
}
