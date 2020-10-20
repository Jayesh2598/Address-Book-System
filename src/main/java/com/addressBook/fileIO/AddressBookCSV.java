package com.addressBook.fileIO;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.addressBook.model.Contact;
import com.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookCSV {

	public static String AddressBookCSVFile = "src/main/java/com/addressBook/AddressBook-CSV.csv";
	
	public void writeToCSVFile(List<Contact> personsList) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try(Writer writer = Files.newBufferedWriter(Paths.get(AddressBookCSVFile));){
			StatefulBeanToCsvBuilder<Contact> builder = new StatefulBeanToCsvBuilder<>(writer);
			StatefulBeanToCsv<Contact> beanWriter = builder.build();
			beanWriter.write(personsList);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void readCSVFile() {
		try(Reader reader = Files.newBufferedReader(Paths.get(AddressBookCSVFile));
				CSVReader csvReader = new CSVReader(reader);){
			String[] next;
			while((next = csvReader.readNext()) != null) {
				System.out.println("First Name - " + next[3]);
				System.out.println("Last Name - " + next[4]);
				System.out.println("Address - " + next[0]);
				System.out.println("City - " + next[1]);
				System.out.println("State - " + next[6]);
				System.out.println("Zip - " + next[7]);
				System.out.println("Phone - " + next[5]);
				System.out.println("Email - " + next[2]+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
