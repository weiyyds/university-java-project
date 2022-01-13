package com.kuang.entity;

public class Student {
	private int id;
	private String username;
	private int age;
	private String telephone;
	private String address;
	
	public Student() {
		super();
	}

	public Student(int id, String username, int age, String telephone, String address) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.telephone = telephone;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", age=" + age + ", telephone=" + telephone
				+ ", address=" + address + "]";
	}
	
	
}
