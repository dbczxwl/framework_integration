package com.branch.don.practice_for_springmvc_hibernate.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.branch.don.practice_for_springmvc_hibernate.entity.Customer;

@Controller
public class TestDbController {
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping("/testdb")
	public void showInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.println("TESTDB");

			jdbcTest();

			dataSourceTest();

			jdbcTemplateTest();

			hibernateTest();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void hibernateTest() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Customer("Don", "Branch", "branch@gmail.com"));
		session.getTransaction().commit();
	}

	private void jdbcTemplateTest() {
		List<Customer> list = jdbcTemplate.query("select * from customer", new RowMapper<Customer>() {
			public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setEmail(resultSet.getString("email"));
				return customer;
			}
		});

		if (list != null && list.size() > 0) {
			System.out.println(list);
		} else {
			System.out.println("NULL");
		}
	}

	private void dataSourceTest() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println("默认数据源为：" + dataSource.getClass());
		Statement st2 = connection.createStatement();
		String sql2 = "select * from customer";
		ResultSet rs2 = st2.executeQuery(sql2);
		while (rs2.next()) {
			Customer customer = new Customer();
			customer.setFirstName(rs2.getString("first_name"));
			customer.setLastName(rs2.getString("last_name"));
			customer.setEmail(rs2.getString("email"));
			System.out.println(customer);
		}
	}

	private void jdbcTest() throws ClassNotFoundException, SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();
		String sql = "select * from customer";
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			Customer customer = new Customer();
			customer.setFirstName(rs.getString("first_name"));
			customer.setLastName(rs.getString("last_name"));
			customer.setEmail(rs.getString("email"));
			System.out.println(customer);
		}
		conn.close();
	}

}
