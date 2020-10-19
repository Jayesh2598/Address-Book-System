package com.addressBook.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
	
	public void searchByCity(String cityName) {
		Set<Contact> personsByCity = new HashSet<Contact>();
		for(Map.Entry<String, AddressBook> entry : dictionary.entrySet()) {
			Set<Contact> listOfPersons = entry.getValue()
											.getAddressBook()
											.stream()
											.filter(contact -> contact.getCity().equalsIgnoreCase(cityName))
											.collect(Collectors.toSet());
			listOfPersons.stream().forEach(contact -> personsByCity.add(contact));
		}
		if(personsByCity.size()>0)
			personsByCity.stream().forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getLastName()));
		else
			System.out.println("No contact from this city registered.\n");
	}	
	
	public void searchByState(String stateName) {
		Set<Contact> personsByState = new HashSet<Contact>();
		for(Map.Entry<String, AddressBook> entry : dictionary.entrySet()) {
			Set<Contact> listOfPersons = entry.getValue()
											.getAddressBook()
											.stream()
											.filter(Contact -> Contact.getState().equalsIgnoreCase(stateName))
											.collect(Collectors.toSet());
			listOfPersons.stream().forEach(contact -> personsByState.add(contact));
		}
		if(personsByState.size()>0)
			personsByState.stream().forEach(contact -> System.out.println(contact.getFirstName()+" "+contact.getLastName()));
		else
			System.out.println("No contact from this state registered.\n");
	}
}