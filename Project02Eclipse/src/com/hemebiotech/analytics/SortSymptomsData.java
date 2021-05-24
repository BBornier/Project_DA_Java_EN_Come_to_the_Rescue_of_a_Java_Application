package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class SortSymptomsData {

	public static void sortingSymptomsData() {
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

		}
	}
}
