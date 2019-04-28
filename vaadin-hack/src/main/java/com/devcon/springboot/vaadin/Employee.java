package com.devcon.springboot.vaadin;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String position;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String firstName, String lastName, String position) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
