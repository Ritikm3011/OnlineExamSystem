package com.entity;

public class Admin {

	private String name;
	private String email;
	private String password;

	public Admin() {
		super();
		this.name = "Admin";
		this.email = "admin@gmail.com";
		this.password = "admin";
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
