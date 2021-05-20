package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		
		try {
		/* Lecture du fichier symptoms.txt via le BufferedReader */
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();
		
		//HashMap<String, Integer> occurrences = new HashMap<String, Integer>();
		
		
		int i = 0;
		while (line != null) {
			i++;
			System.out.println("symptom : " + line);
			
			line = reader.readLine(); // get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("\n");
		writer.close();
		reader.close();
		
		} catch  (IOException e) {
			e.printStackTrace();
		}
	}
}