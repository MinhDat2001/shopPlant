package com.minhdat.plant.controller.site;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Category;
import com.minhdat.plant.domain.Product;
import com.minhdat.plant.model.ProductDto;
import com.minhdat.plant.service.CategoryService;
import com.minhdat.plant.service.ProductService;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("shop")
public class ShopController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@RequestMapping("")
	public ModelAndView list(ModelMap model) {
		List<Product> list=productService.findAll();
		List<Category> cate= categoryService.findAll();
		model.addAttribute("products",list);
		model.addAttribute("categories",cate);
		
		return new ModelAndView( "site/shop", model);
	}	
	@RequestMapping("/search")
	public ModelAndView search(ModelMap model, HttpServletRequest request) {
		List<Product> list=productService.findAll();
		List<Product> listSearch=new ArrayList<>();
		long cateId = Long.parseLong( request.getParameter("selectcategory"));
		boolean ok=false;
		if(cateId==0) ok=true;
		try {
			long from = Long.parseLong( request.getParameter("priceFrom"));
			long to = Long.parseLong( request.getParameter("priceTo"));
			for(Product i: list) {
				if(i.getCategory().getCategoryId()==cateId||ok&&i.getPrice()>=from&&i.getPrice()<=to) {
					listSearch.add(i);
				}
			}
		}catch (Exception e) {
			for(Product i: list) {
				if(i.getCategory().getCategoryId()==cateId||ok) {
					listSearch.add(i);
				}
			}
		}
		
		List<Category> cate= categoryService.findAll();
		model.addAttribute("products",listSearch);
		model.addAttribute("categories",cate);
		
		return new ModelAndView( "site/shop", model);
	}
	@RequestMapping("{productId}")
	public ModelAndView productDetail(ModelMap model, @PathVariable("productId") Long productId) {
		Optional<Product> opt= productService.findById(productId);
		
		ProductDto dto=new ProductDto();
		if(opt.isPresent()) {
			Product entity=opt.get();
			
			BeanUtils.copyProperties(entity, dto);
			
			model.addAttribute("product", dto);
			if(dto.getQuantity()>0) {
				model.addAttribute("inStock", true);
			}
			return new ModelAndView("site/product-details",model);
		}
		
		return new ModelAndView( "site/shop", model);
	}
}
