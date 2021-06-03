package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

	/**
	 * Here the SortSymptomData class will use the readSymptomData Class and its methods.
	 * It will count occurrences and sort data in an alphabetical order.  
	 * 
	 * @see ReadSymptomDataFromFile
	 * 
	 * @author BBornier
	 * @version 5.0
	 *
	 */
public class SortSymptomsData {
	
	/** 
	 * 
	 * It will read the symptoms file,
	 * @see BufferReader
	 * 
	 * put it in a list,
	 * @see List
	 * 
	 * sort the list in alphabetical order and with occurrences number for each symptom.
	 * It uses symptomsTri object.
	 * 
	 * @return symptomsTri
	 *  
	 */

	public TreeMap<String, Integer> sortingSymptomsData() {
		
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
			return symptomsTri;
	}
}
