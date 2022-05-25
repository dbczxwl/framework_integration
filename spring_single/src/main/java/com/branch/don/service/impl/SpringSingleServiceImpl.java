package com.branch.don.service.impl;

import org.springframework.stereotype.Service;

import com.branch.don.service.SpringSingleService;

@Service
public class SpringSingleServiceImpl implements SpringSingleService {

	@Override
	public void runSpringSingle() {
		System.out.println("run spring single");
	}

}
