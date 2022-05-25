package com.branch.don.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// spring配置,xml文件的加载
@ContextConfiguration(locations = "classpath:applicationContext.xml")
// spring配置,javaConfig配置类的加载
// @ContextConfiguration(classes = SpringConfiguration.class)
public class TestSpringSingleServiceImpl_Injection {
	@Autowired
	SpringSingleService springSingleService;

	@Test
	public void testSpringSingleServiceImpl() {
		// 调用bean对象中的方法
		springSingleService.runSpringSingle();

	}
}
