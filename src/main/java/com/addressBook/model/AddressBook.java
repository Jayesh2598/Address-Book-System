package com.addressBook.model;

import java.util.*;

public class AddressBook {

	Scanner sc = new Scanner(System.in);

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

	public void editContact(String firstName, String lastName) {
		Contact contact = null;
		for (Contact c : addressBook)
			if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName))
				contact = c;
		if (contact != null) {
			System.out.println("Which fields do you want to change? (For multiple, enter comma separated numbers)");
			System.out.println(
					"1.First Name \t2.Last Name \t3.Address \t4.City \n5.State \t6.Zip \t\t7.Phone number \t8.Email");
			String[] editables = sc.nextLine().trim().split(",");

			for (int i = 0; i < editables.length; i++) { // Changing all the mentioned fields
				switch (editables[i]) {
				case "1":
					System.out.println("Enter the new first name:");
					String newFirstName = sc.nextLine();
					if (newFirstName.equalsIgnoreCase(contact.getFirstName()))
						System.out.println("Field unchanged.");
					else
						contact.setFirstName(newFirstName);
					break;
				case "2":
					System.out.println("Enter the new last name:");
					String newLastName = sc.nextLine();
					if (newLastName.equalsIgnoreCase(contact.getLastName()))
						System.out.println("Field unchanged.");
					else
						contact.setLastName(newLastName);
					break;
				case "3":
					System.out.println("Enter the new address:");
					String newAddress = sc.nextLine();
					if (newAddress.equalsIgnoreCase(contact.getAddress()))
						System.out.println("Field unchanged.");
					else
						contact.setAddress(newAddress);
					break;
				case "4":
					System.out.println("Enter the new city:");
					String newCity = sc.nextLine();
					if (newCity.equalsIgnoreCase(contact.getCity()))
						System.out.println("Field unchanged.");
					else
						contact.setCity(newCity);
					break;
				case "5":
					System.out.println("Enter the new state:");
					String newState = sc.nextLine();
					if (newState.equalsIgnoreCase(contact.getState()))
						System.out.println("Field unchanged.");
					else
						contact.setState(newState);
					break;
				case "6":
					System.out.println("Enter the new Zip:");
					int newZip = Integer.parseInt(sc.nextLine());
					if (newZip == contact.getZip())
						System.out.println("Field unchanged.");
					else
						contact.setZip(newZip);
					break;
				case "7":
					System.out.println("Enter the new phone number:");
					Long newPhNo = Long.parseLong(sc.nextLine());
					if (newPhNo == contact.getPhoneNo())
						System.out.println("Field unchanged.");
					else
						contact.setPhoneNo(newPhNo);
					break;
				case "8":
					System.out.println("Enter the new email:");
					String newEmail = sc.nextLine();
					if (newEmail.equalsIgnoreCase(contact.getEmail()))
						System.out.println("Field unchanged.");
					else
						contact.setEmail(newEmail);
					break;
				default:
					System.out.println("Invalid field number. Please enter comma separated 1-8 number(s)");
					break;

				}
			}
			System.out.println("Contact details have been changed successfully!");
		} else
			System.out.println("No contact with this name exists.");
	}
}