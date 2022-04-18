package com.service.labmembers.data;

public class Laboratory {

	public int id;
	public String name;
	public String specialty;
	public int money;
	public int nbEmployees;
	
	public Laboratory() {
		
	}
	
	public Laboratory(String name, int nbEmployees, int id) {
		this.name = name;
		this.nbEmployees = nbEmployees;
		this.id = id;
	}
	
	public Laboratory(int id, String name, String specialty, int money, int nbEmployees) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specialty;
		this.money = money;
		this.nbEmployees = nbEmployees;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getNbEmployees() {
		return nbEmployees;
	}
	public void setNbEmployees(int nbEmployees) {
		this.nbEmployees = nbEmployees;
	}
	
	
	
}
