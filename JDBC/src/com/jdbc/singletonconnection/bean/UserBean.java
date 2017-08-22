package com.jdbc.singletonconnection.bean;

public class UserBean {

	private String name;
	private String email;
	private int age;
	private long phone;


	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public long getPhone() {
		return phone;
	}


	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "UserBean [name=" + name + ", email=" + email + ", age=" + age + ", phone=" + phone + "]";
	}




}
