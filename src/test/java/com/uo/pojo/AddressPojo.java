package com.uo.pojo;

public class AddressPojo {
	private String company;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private String homePhone;
	private String mobilePhhone;
	private String notes;
	private String addressTitle;
	
	public AddressPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AddressPojo(String company, String address1, String address2, String city, String state, String zipcode,
			String homePhone, String mobilePhhone, String notes, String addressTitle) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.homePhone = homePhone;
		this.mobilePhhone = mobilePhhone;
		this.notes = notes;
		this.addressTitle = addressTitle;
	}


	public String getNotes() {
		return notes;
	}


	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhhone() {
		return mobilePhhone;
	}

	public String getAddressTitle() {
		return addressTitle;
	}


	@Override
	public String toString() {
		return "AddressPojo [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + ", homePhone=" + homePhone + ", mobilePhhone="
				+ mobilePhhone + ", notes=" + notes + ", addressTitle=" + addressTitle + "]";
	}


	




}
