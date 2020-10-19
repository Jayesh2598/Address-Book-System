package com.addressBook.controller;

import java.util.*;

import com.addressBook.model.Contact;

public class AddressBookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Address Book Program!");
		System.out.println("You can create a new contact.");

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
		String email = sc.next().trim();
		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNo, email);
		System.out.println("The contact has been successfully created.");
		sc.close();
	}
}
