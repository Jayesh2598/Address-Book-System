package com.addressBook.model;

import java.util.HashMap;

public class AddressBookDictionary {

	private HashMap<String, AddressBook> dictionary = new HashMap<>();

	// Getter
	public HashMap<String, AddressBook> getDictionary() {
		return dictionary;
	}

	// Setter
	public void setDictionary(HashMap<String, AddressBook> dictionary) {
		this.dictionary = dictionary;
	}

	// Methods
	public void addAddressBook(String bookName, AddressBook book) {
		dictionary.put(bookName, book);
	}

	public AddressBook accessAddressBook(String bookName) {
		AddressBook book = dictionary.get(bookName);
		dictionary.remove(bookName);
		return book;
	}
}