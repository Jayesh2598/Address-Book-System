package com.addressBook.controller;

import com.addressBook.model.AddressBook;
import com.addressBook.model.Contact;

import java.util.*;

public class AddressBookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Address Book Program!");

		AddressBook book = new AddressBook();
		boolean loop = true;
		while (loop) {
			System.out.println(
					"Enter your choice:\n1. Enter a new contact\n2. Edit an existing contact\n3. Delete an existing contact\n4. Exit");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
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
				System.out.println("Thank you for using the application.");
				loop = false;
				break;
			}
		}
		sc.close();
	}
}
