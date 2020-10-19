package com.addressBook.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBookDictionary {

	private Map<String, AddressBook> dictionary = new HashMap<>();
	private Map<String, Set<Contact>> cityPersons = new HashMap<>();
	private Map<String, Set<Contact>> statePersons = new HashMap<>();

	// Getter
	public Map<String, AddressBook> getDictionary() {
		return dictionary;
	}

	public Map<String, Set<Contact>> getCityPersons() {
		return cityPersons;
	}

	public Map<String, Set<Contact>> getStatePersons() {
		return statePersons;
	}

	// Setter
	public void setDictionary(Map<String, AddressBook> dictionary) {
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
	
	public Set<Contact> searchByCity(String cityName) {
		Set<Contact> personsOfCity = new HashSet<Contact>();
		for(Map.Entry<String, AddressBook> entry : dictionary.entrySet()) {
			Set<Contact> listOfPersons = entry.getValue()
										.getAddressBook().stream()
										.filter(contact -> contact.getCity().equalsIgnoreCase(cityName))
										.collect(Collectors.toSet());
			listOfPersons.stream().forEach(contact -> personsOfCity.add(contact));
		}
		return personsOfCity;
	}	
	
	public Set<Contact> searchByState(String stateName) {
		Set<Contact> personsOfState = new HashSet<Contact>();
		for(Map.Entry<String, AddressBook> entry : dictionary.entrySet()) {
			Set<Contact> listOfPersons = entry.getValue()
										.getAddressBook().stream()
										.filter(Contact -> Contact.getState().equalsIgnoreCase(stateName))
										.collect(Collectors.toSet());
			listOfPersons.stream().forEach(contact -> personsOfState.add(contact));
		}
		return personsOfState;
	}

	public void makeMaps() {
		//Entering values into cityPersons map
		Set<String> distinctCities = new HashSet<String>();
		for(Map.Entry<String, AddressBook> entry : dictionary.entrySet()) {
			distinctCities = entry.getValue()
								.getAddressBook()
								.stream()
								.map(contact -> contact.getCity().toLowerCase())
								.collect(Collectors.toSet());
		}
		distinctCities.stream().forEach(city -> cityPersons.put(city, searchByCity(city)));
		
		//Entering values into statePersons map
		Set<String> distinctStates = new HashSet<String>();
		for(Map.Entry<String, AddressBook> entry : dictionary.entrySet()) {
			distinctStates = entry.getValue()
								.getAddressBook()
								.stream()
								.map(contact -> contact.getState().toLowerCase())
								.collect(Collectors.toSet());
		}
		distinctStates.stream().forEach(state -> statePersons.put(state, searchByState(state)));
	}
}