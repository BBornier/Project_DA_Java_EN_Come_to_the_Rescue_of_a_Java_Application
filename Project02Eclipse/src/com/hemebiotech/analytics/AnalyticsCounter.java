package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0; // counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				
				System.out.println("number of headaches: " + headCount);
			} else if (line.equals("rush")) {
				
			} else if (line.contains("pupils")) {
				
			}

			line = reader.readLine(); // get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: ");
		writer.write("rash: ");
		writer.write("dialated pupils: ");
		writer.close();
	}
}
