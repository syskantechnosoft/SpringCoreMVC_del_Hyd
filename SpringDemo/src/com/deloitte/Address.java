package com.deloitte;

public class Address {
	private int doorNo;
	private String street;
	private String city;
	private String state;
	private String zipcode;

	public Address() {
		super();
	}

	public Address(int doorNo, String street, String city, String state, String zipcode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + "]";
	}

}
