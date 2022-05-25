package com.branch.don.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringmvcSingleController {
	@RequestMapping("/toMenu")
	public String showMenu() {
		System.out.println("Go to the meun page.");
		return "menu";
	}

}
