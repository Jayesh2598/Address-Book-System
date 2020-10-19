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
			System.out.println("Enter your choice:\n1. Enter a new contact\n2. Exit");
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
				Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNo, email);
				book.addContact(contact);
				System.out.println("This contact has been successfully created and registered.");
				break;

			case 2:
				System.out.println("Thank you for using the application.");
				loop = false;
				break;
			}
		}
		sc.close();
	}
}
