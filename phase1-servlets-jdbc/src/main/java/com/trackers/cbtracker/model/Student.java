package com.trackers.cbtracker.model;

public class Student {
	private int id;
	private String email;
	private String name;
	
	//constructors
	
	public Student(int id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}
	
	
	public Student(String email, String name) {
		this.email = email;
		this.name = name;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", name=" + name + "]";
	}
	

}
