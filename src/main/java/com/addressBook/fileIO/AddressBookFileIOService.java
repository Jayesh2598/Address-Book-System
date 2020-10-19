package com.addressBook.fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.addressBook.model.Contact;

public class AddressBookFileIOService {

	public static String AddressBookFile = "src/main/java/com/addressBook/AddressBook-File.txt";

	public void writeToFile(List<Contact> addressBook) {
		StringBuffer contactBuffer = new StringBuffer();
		addressBook.forEach(contact -> {
			String contactDetails = contact.writeContact().concat("\n");
			contactBuffer.append(contactDetails);
		});

		try {
			Files.write(Paths.get(AddressBookFile), contactBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> readFile() {
		List<String> fileEntries = new ArrayList<>();
		try {
			fileEntries = Files.lines(new File(AddressBookFile).toPath()).map(line -> line.trim())
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileEntries;
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(AddressBookFile).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
}
