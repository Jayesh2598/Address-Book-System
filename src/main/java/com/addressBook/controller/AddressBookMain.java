package com.addressBook.controller;

import com.addressBook.model.AddressBook;
import com.addressBook.model.AddressBookDictionary;
import com.addressBook.model.Contact;

import java.util.*;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program!");

		AddressBookDictionary dictionary = new AddressBookDictionary();
		boolean makeNewAddressBook = true;
		while (makeNewAddressBook) {
			System.out.println(
					"Enter your choice:\n1. Create new Address Book\t2. Access existing Address Book\t3. Exit");
			int choice1 = Integer.parseInt(sc.nextLine());

			switch (choice1) {
			case 1:
				System.out.println("Enter the Address Book's name:");
				String newBookName = sc.nextLine();
				AddressBook newBook = new AddressBook();
				editAddressBook(newBook);
				dictionary.addAddressBook(newBookName, newBook);
				break;
			case 2:
				System.out.println("Enter the Address Book's name:");
				String accessBookName = sc.nextLine();
				AddressBook accessBook = dictionary.accessAddressBook(accessBookName);
				editAddressBook(accessBook);
				dictionary.addAddressBook(accessBookName, accessBook);
				break;
			case 3:
				System.out.println("Thank you for using the application.");
				makeNewAddressBook = false;
				break;
			}
		}
		sc.close();
	}

	public static void editAddressBook(AddressBook book) {
		boolean loop = true;
		while (loop) {
			System.out.println(
					"Enter your choice:\n1. Enter a new contact\n2. Edit an existing contact\n3. Delete an existing contact\n4. Exit from this address book");
			int choice2 = Integer.parseInt(sc.nextLine());

			switch (choice2) {
			case 1:
				System.out.println("Enter the first name:");
				String firstName = sc.nextLine().trim();
				System.out.println("Enter the last name:");
				String lastName = sc.nextLine().trim();
				System.out.println("Enter the address:");
				String address = sc.nextLine().trim();
				System.out.println("Enter the city:");
				String city = sc.nextLine().trim();
				System.out.println("Enter the state:");
				String state = sc.nextLine().trim();
				System.out.println("Enter the ZIP:");
				int zip = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the phone number:");
				long phoneNo = Long.parseLong(sc.nextLine());
				System.out.println("Enter the email:");
				String email = sc.nextLine().trim();
				Contact createContact = new Contact(firstName, lastName, address, city, state, zip, phoneNo, email);
				book.addContact(createContact);
				System.out.println("This contact has been successfully created and registered.");
				break;
			case 2:
				System.out.println("Enter the first name:");
				String fName = sc.nextLine().trim();
				System.out.println("Enter the last name:");
				String lName = sc.nextLine().trim();
				book.editContact(fName, lName);
				break;
			case 3:
				System.out.println("Enter the first name:");
				String FName = sc.nextLine().trim();
				System.out.println("Enter the last name:");
				String LName = sc.nextLine().trim();
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
