package com.minhdat.plant.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Category;
import com.minhdat.plant.model.CategoryDto;
import com.minhdat.plant.service.CategoryService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@GetMapping("add")
	public String add(Model model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return "redirect:/admin/login";
		model.addAttribute("category", new CategoryDto());
		
		return "admin/categories/addOrEdit";
	}
	@GetMapping("edit/{categoryId}")
	public String edit(HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return "redirect:/admin/login";
		return "admin/categories/addOrEdit";
	}
	@GetMapping("delete/{categoryId}")
	public String delete(HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return "redirect:/admin/login";
		return "redirect:admin/categories";
	}
	@RequestMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, CategoryDto dto,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return new ModelAndView( "redirect:/admin/login", model);
		Category entity=new Category();
		System.out.println("id : "+dto.getCategoryId()+" name: "+ dto.getName());
		BeanUtils.copyProperties(dto, entity);
		categoryService.save(entity); 
		model.addAttribute("message", "Category is save!");
		return new ModelAndView( "forward:/admin/categories", model);
	}

	@GetMapping("")
	public ModelAndView list(ModelMap model,HttpServletRequest request) {
		HttpSession ss= request.getSession();
		if(ss.getAttribute("admin")==null)
			return new ModelAndView( "redirect:/admin/login", model);
		List<Category> list=categoryService.findAll();
		
		model.addAttribute("categories",list);
		
		return new ModelAndView( "admin/categories/list", model);
	}
}
