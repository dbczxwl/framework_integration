package com.branch.don.service.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.branch.don.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	SessionFactory sessionFactory;

	// 将事务交给Spring管理,步骤3
	@Transactional
	public List<?> getService() {
		System.out.println("Give some service");
		Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();// 手动管理事务
		// <?>代表任意java类型，<? extends T> 表示传入数据值需要是T类型或T的子类，<? suprt T>表示传入数据值需要是T类型或T的超类。
		List<?> customerList = session.createQuery("from Customer").getResultList();
		// session.getTransaction().commit();// 手动管理事务

		return customerList;
	}

}
