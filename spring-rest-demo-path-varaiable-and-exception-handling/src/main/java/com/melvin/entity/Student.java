package com.melvin.entity;

public class Student {

	private String fristname;
	private String lastname;
	private int id;
	
	
	
	public Student() {
		
	}
	public Student(int id,String fristname, String lastname) {
		super();
		this.fristname = fristname;
		this.lastname = lastname;
		this.setId(id);
	}
	public String getFristname() {
		return fristname;
	}
	public void setFristname(String fristname) {
		this.fristname = fristname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
