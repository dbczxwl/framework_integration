package com.branch.don.service.Impl;

import org.springframework.stereotype.Service;

import com.branch.don.service.SpringmvcSingleService;

@Service
public class SpringmvcSingleServiceImpl implements SpringmvcSingleService {
	@Override
	public void getService() {
		System.out.println("Give some service");
	}

}
