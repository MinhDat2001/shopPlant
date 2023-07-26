//package com.minhdat.plant.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.minhdat.plant.domain.Account;
//import com.minhdat.plant.repository.test;
//
//
//@RestController
//public class testcontroller {
//
//	@Autowired 
//	private test s;
//	@GetMapping("/tri")
//	@ResponseBody
//	public List<Account> show(){
//		List<Account> l=s.findAll();
//		for(Account i :l) {
//			System.out.println(i);
//		}
//		return l;
//	}
//}
