package com.deloitte.entity;

//Entity Bean Class
public class Trainee {
	private int id;
	private String name;
	private String email;
	private long mobile;

	public Trainee() {
		super();
	}

	public Trainee(int id, String name, String email, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
