package com.service.labmembers.data;

public class Scientist {
	
	private int id;
	private String firstName;
	private String lastName;
	private String specialty;
	private int laboratoryId;
	
	public Scientist(int id, String firstName, String lastName, String specialty) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
	}
	
	public Scientist(int id, String firstName, String lastName, String specialty,int laboratoryId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.laboratoryId = laboratoryId;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public int getLaboratoryId() {
		return laboratoryId;
	}
	public void setLaboratoryId(int laboratoryId) {
		this.laboratoryId = laboratoryId;
	}
	
	
	

}
