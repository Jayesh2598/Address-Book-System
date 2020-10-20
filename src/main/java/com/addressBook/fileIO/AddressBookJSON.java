package com.addressBook.fileIO;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.addressBook.model.Contact;
import com.google.gson.Gson;

public class AddressBookJSON {
	public static String AddressBookJSONFile = "src/main/java/com/addressBook/AddressBook-JSON.json";

	public void writeToJsonFile(List<Contact> contactList) throws IOException {
		Writer writer = Files.newBufferedWriter(Paths.get(AddressBookJSONFile));
		new Gson().toJson(contactList, writer);
		writer.close();
	}

	public void readJSONFile() {
		List<Contact> contactList = new ArrayList<>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(AddressBookJSONFile));
			contactList.addAll(Arrays.asList(new Gson().fromJson(reader, Contact[].class)));
			System.out.println(contactList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
