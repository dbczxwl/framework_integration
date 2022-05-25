package com.branch.don.practice_for_springmvc_hibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.branch.don.practice_for_springmvc_hibernate.entity.Customer;

// Create Controller class
@Controller
public class InfoController {
	// Defined Controller method, and Add RequestMapping
	@RequestMapping("/")
	public String showInfo() {
		// Return View Name
		return "menu";
	}

	@RequestMapping("/showForm")
	public String showTransferModelForm() {
		return "webForm";
	}

	@RequestMapping("/commitForm")
	public String commitForm() {
		return "showParams";
	}

	@RequestMapping("/showBookNameUseRequestParam")
	public String showBookNameUseRequestParam(@RequestParam("bookName") String bookName,Model model) {
		model.addAttribute("msg", "The input value is " + bookName.toUpperCase());
		return "showParams";
	}
	
	@RequestMapping("/showBookName")
	public String showBookName() {
		return "showInfo";
	}

	@RequestMapping("/showAllInfo")
	public String showAllInfo(HttpServletRequest request, Model model) {
		//	bookname 转发过程中在request中不会丢失，不用改	
		
		String result="书不贵，贱卖，贱卖!!!";
		Customer newCustomer = new Customer("yellow", "dog", "yellowdog@gmail.com");
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer("branch","don","branch@gmail.com"));
		customerList.add(new Customer("tom","cat","tomcat@gmail.com"));
		customerList.add(new Customer("hello","kitty","hellokitty@gmail.com"));
		
		model.addAttribute("msg", result);
		model.addAttribute("customer", newCustomer);
		model.addAttribute("customerList",customerList);
		
		request.setAttribute("bookName", request.getParameter("bookName").toUpperCase());
		
		return "showInfo";
	}
	
}
