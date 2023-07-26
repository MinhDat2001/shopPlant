package com.minhdat.plant.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Category;
import com.minhdat.plant.domain.Product;
import com.minhdat.plant.service.CategoryService;
import com.minhdat.plant.service.ProductService;

@Controller
@RequestMapping("admin/products")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@RequestMapping("") 
	public ModelAndView list(ModelMap model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return new ModelAndView( "redirect:/admin/login", model);
		List<Product> list=productService.findAll();
		
		model.addAttribute("products",list);
		
		return new ModelAndView( "admin/product/list", model);
	}
	@RequestMapping("/add")
	public ModelAndView add(ModelMap model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return new ModelAndView( "redirect:/admin/login", model);
		List<Category> list=categoryService.findAll();
		model.addAttribute("categories",list);
		return new ModelAndView( "admin/product/addOrEdit", model);
	}
	
	@RequestMapping("/delete/{productId}")
	public ModelAndView delete(ModelMap model, @PathVariable("productId") Long productId,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return new ModelAndView( "redirect:/admin/login", model);
		productService.deleteById(productId);
		return new ModelAndView( "redirect:/admin/products", model);
	}
}
