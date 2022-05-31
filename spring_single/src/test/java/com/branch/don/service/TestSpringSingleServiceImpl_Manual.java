package com.branch.don.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.branch.don.service.impl.SpringSingleServiceImpl;

public class TestSpringSingleServiceImpl_Manual {

	@Test
	public void testSpringSingleServiceImpl() {
		// web项目整合Spring第二步：装配Spring配置文件（BeanFactory）的第三种方法，通过代码实现
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");

		// 获取bean对象
		SpringSingleService springSingleService = (SpringSingleServiceImpl) applicationContext
				.getBean("springSingleServiceImpl");

		// 调用bean对象中的方法
		springSingleService.runSpringSingle();

		// 关闭applicationContext容器
		applicationContext.close();

	}
}
