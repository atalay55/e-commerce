package entities.concretes;

import entities.abstracts.Entity;

public class User implements Entity {
	private int id;
	private String firstName;
	private String surName;
	private String password;
	private String email;
	public User(String firstName, String surName, String password, String email) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.password = password;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
