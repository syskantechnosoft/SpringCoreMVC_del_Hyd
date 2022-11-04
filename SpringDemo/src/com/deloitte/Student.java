package com.deloitte;

public class Student {

	private int id;
	private String name;
	private Address homeAddress;

	public Student() {
		super();
	}

	public Student(int id, String name, Address homeAddress) {
		super();
		this.id = id;
		this.name = name;
		this.homeAddress = homeAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", homeAddress=" + homeAddress + "]";
	}

}
