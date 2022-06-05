package com.branch.don.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
// 类名和表明相同@Table可以省略
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	// 属性名和列名相同@Column可以省略
	// 在springboot下jpa默认会将属性的驼峰命名自动匹配表列名的下划线分割，而单独的hibernate此种情况下需要用Colum显示说明
	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;

	@Column
	String email;

	// @Transient注解的属性不会被持久化
	@Transient
	String exceptString;

	public Customer() {

	}

	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExceptString() {
		return exceptString;
	}

	public void setExceptString(String exceptString) {
		this.exceptString = exceptString;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

}
