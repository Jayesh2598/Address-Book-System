package com.addressBook.model;

import java.util.*;

public class AddressBook {
	private List<Contact> addressBook = new ArrayList<Contact>();

	// Getters
	public List<Contact> getAddressBook() {
		return addressBook;
	}

	// Setters
	public void setAddressBook(List<Contact> addressBook) {
		this.addressBook = addressBook;
	}

	// Methods
	public void addContact(Contact contact) {
		addressBook.add(contact);
	}
}