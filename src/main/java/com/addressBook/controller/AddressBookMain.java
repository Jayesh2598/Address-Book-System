package com.addressBook.controller;

import com.addressBook.model.AddressBook;
import com.addressBook.model.AddressBookDictionary;
import com.addressBook.model.Contact;

import java.util.*;

public class AddressBookMain {

	static Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program!");

		AddressBookDictionary dictionary = new AddressBookDictionary();
		boolean playAddressBooks = true;
		while (playAddressBooks) {
			System.out.println(
					"Enter your choice:\n1. Create new Address Book\n2. Access existing Address Book\n3. Search persons\n4. Exit");
			int choice1 = Integer.parseInt(SC.nextLine());

			switch (choice1) {
			case 1:
				System.out.println("Enter the Address Book's name:");
				String newBookName = SC.nextLine();
				AddressBook newBook = new AddressBook();
				editAddressBook(newBook);
				dictionary.addAddressBook(newBookName, newBook);
				break;
			case 2:
				System.out.println("Enter the Address Book's name:");
				String accessBookName = SC.nextLine();
				AddressBook accessBook = dictionary.accessAddressBook(accessBookName);
				editAddressBook(accessBook);
				dictionary.addAddressBook(accessBookName, accessBook);
				break;
			case 3:
				System.out.println("Enter your choice:\n1. In a City \t2. In a State");
				int choice3 = Integer.parseInt(SC.nextLine());
				switch (choice3) {
				case 1:
					System.out.println("Enter city:");
					String city = SC.nextLine();
					dictionary.searchByCity(city);
					break;
				case 2:
					System.out.println("Enter state:");
					String state = SC.nextLine();
					dictionary.searchByState(state);
					break;
				default:
					System.out.println("Invalid entry.");
					break;
				}
				break;
			case 4:
				System.out.println("Thank you for using the application.");
				playAddressBooks = false;
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
		SC.close();
	}

	public static void editAddressBook(AddressBook book) {
		boolean loop = true;
		while (loop) {
			System.out.println(
					"Enter your choice:\n1. Enter a new contact\n2. Edit an existing contact\n3. Delete an existing contact\n4. Exit from this address book");
			int choice2 = Integer.parseInt(SC.nextLine());

			switch (choice2) {
			case 1:
				System.out.println("Enter the first name:");
				String firstName = SC.nextLine().trim();
				System.out.println("Enter the last name:");
				String lastName = SC.nextLine().trim();
				Contact createContact = new Contact(firstName, lastName);
				if (book.duplicateCheck(createContact))
					System.out.println(firstName + " " + lastName + " contact already exists.");
				else {
					System.out.println("Enter the address:");
					createContact.setAddress(SC.nextLine().trim());
					System.out.println("Enter the city:");
					createContact.setCity(SC.nextLine().trim());
					System.out.println("Enter the state:");
					createContact.setState(SC.nextLine().trim());
					System.out.println("Enter the ZIP:");
					createContact.setZip(Integer.parseInt(SC.nextLine()));
					System.out.println("Enter the phone number:");
					createContact.setPhoneNo(Long.parseLong(SC.nextLine()));
					System.out.println("Enter the email:");
					createContact.setEmail(SC.nextLine().trim());
					book.addContact(createContact);
					System.out.println("This contact has been successfully created and registered.");
				}
				break;
			case 2:
				System.out.println("Enter the first name:");
				String fName = SC.nextLine().trim();
				System.out.println("Enter the last name:");
				String lName = SC.nextLine().trim();
				book.editContact(fName, lName);
				break;
			case 3:
				System.out.println("Enter the first name:");
				String FName = SC.nextLine().trim();
				System.out.println("Enter the last name:");
				String LName = SC.nextLine().trim();
				book.deleteContact(FName, LName);
				break;
			case 4:
				System.out.println("Exiting from this address book.");
				loop = false;
				break;
			}
		}
	}
}
