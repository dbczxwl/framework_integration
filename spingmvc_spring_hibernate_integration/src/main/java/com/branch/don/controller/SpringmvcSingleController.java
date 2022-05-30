package com.branch.don.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.branch.don.service.SpringmvcSingleService;

@Controller
public class SpringmvcSingleController {
	@Autowired
	private SpringmvcSingleService springmvcSingleService;
	
	@RequestMapping("/toMenu")
	public String showMenu() {
		System.out.println("Go to the meun page.");
		springmvcSingleService.getService();
		return "menu";
	}

}
