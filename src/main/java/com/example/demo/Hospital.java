package com.example.demo;

public class Hospital {
	String name;
	String address;
	String pincode;
	int available_capacity;
	int min_age_limit;
	String vaccine;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getAvailable_capacity() {
		return available_capacity;
	}
	public void setAvailable_capacity(int available_capacity) {
		this.available_capacity = available_capacity;
	}
	public int getMin_age_limit() {
		return min_age_limit;
	}
	public void setMin_age_limit(int min_age_limit) {
		this.min_age_limit = min_age_limit;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	@Override
	public String toString() {
		return "Hospital [name=" + name + ", address=" + address + ", pincode=" + pincode + ", available_capacity="
				+ available_capacity + ", min_age_limit=" + min_age_limit + ", vaccine=" + vaccine + "]";
	}
	
}
