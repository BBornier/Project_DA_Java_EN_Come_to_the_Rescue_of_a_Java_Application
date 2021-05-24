package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounterV4 {
	public static void main(String[] args) throws IOException {
		try {
			
			ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
			file.getSymptoms();
			List<String> symptomsFile = file.getSymptoms();
				
				
				TreeMap<String, Integer> symptomsTri = new TreeMap<>();	
				for (String listSymptoms : symptomsFile) {
					if (symptomsTri.containsKey(listSymptoms)) {
						symptomsTri.put(listSymptoms, symptomsTri.get(listSymptoms) + 1);
					} else {
						symptomsTri.put(listSymptoms, 1);						
					}
				
				FileWriter writer = new FileWriter("resultV4.out");
				writer.write("Symptoms List " + symptomsTri);
				writer.close();
			
			}
				
				System.out.println(symptomsTri);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
	}
}
	
	