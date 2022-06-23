package com.minhdat.plant.controller.site;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minhdat.plant.domain.Customer;
import com.minhdat.plant.model.CustomerDto;
import com.minhdat.plant.service.CustomerService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	CustomerService customerService;
	@RequestMapping("")
	public ModelAndView register(ModelMap model) {

		return new ModelAndView( "site/register", model);
	}
	@PostMapping("/authen")
	public ModelAndView authen(ModelMap model,HttpServletRequest request) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String CFpassword=request.getParameter("CFpassword");
		List<Customer> list=customerService.findAll();
		boolean ok=true;
		for(Customer i:list) {
			if(i.getEmail().equals(email)||!CFpassword.equals(password)) {
				ok=false;
				break;
			}
		}
		if(list.size()==0&&CFpassword.equals(password)||ok&&CFpassword.equals(password)) {
			Customer dto=new Customer(email, password);
			customerService.save(dto);
			HttpSession ss= request.getSession();
			ss.setAttribute("username", email);
			return new ModelAndView( "redirect:/profile", model);
		}
		model.addAttribute("message", "Email đã tồn tại hoặc xác nhận mật khẩu không khớp");
		return new ModelAndView( "forward:/register", model);
	}
}
