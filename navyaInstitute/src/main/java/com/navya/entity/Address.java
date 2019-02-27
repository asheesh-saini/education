package com.navya.entity;

public class Address {
	private String homeNo;
	private String StreetName;
	private String area;
	private String city;
	private String state;
	private String pincode;
	private String id;

	public String getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [homeNo=" + homeNo + ", StreetName=" + StreetName + ", area=" + area + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}
	
}
