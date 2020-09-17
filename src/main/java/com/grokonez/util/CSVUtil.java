package com.grokonez.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.grokonez.entity.User;

public class CSVUtil {

	
	public static List<User> parseCSVFile(InputStream is) {
		List<User> users = new ArrayList<>();
		BufferedReader bufferedReader = null;
		CSVParser csvParser = null;
		
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(is));
			csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			
			Iterable<CSVRecord> records = csvParser.getRecords();
			
			for(CSVRecord record: records) {
				User user = new User(
						Long.parseLong(record.get("id")),
								record.get("name"),
								record.get("address"),
								Integer.parseInt(record.get("age"))
						);
				users.add(user);
			}
		} catch(Exception ex) {
			System.out.println("Exception occurred while parsing csv file");
			ex.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				csvParser.close();
			} catch(Exception ex) {
				System.out.println("Exception occurred while closing reader and parser");
				ex.printStackTrace();
			}
		}
		
		return users;
	}
}
