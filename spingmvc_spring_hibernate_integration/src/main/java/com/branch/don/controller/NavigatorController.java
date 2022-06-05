package com.branch.don.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.branch.don.service.CustomerService;

@Controller
public class NavigatorController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/toMenu")
	public String showMenu() {
		System.out.println("Go to the meun page.");
		List<?> customerList = customerService.getService();
		System.out.println(customerList);
		
		return "menu";
	}

}
