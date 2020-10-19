package com.addressBook.model;

public class Contact {

	private String firstName, lastName, address, city, state, email;
	private int zip;
	private long phoneNo;

	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Constructor
	public Contact(String firstName, String lastName, String address, String city, String state, int zip, long phoneNo,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getEmail() {
		return email;
	}

	public int getZip() {
		return zip;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public boolean equals(Object o) {
		Contact contact = (Contact) o;
		if (this.firstName.equalsIgnoreCase(contact.firstName) && this.lastName.equalsIgnoreCase(contact.lastName))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return firstName + "\t" + lastName;
	}
}