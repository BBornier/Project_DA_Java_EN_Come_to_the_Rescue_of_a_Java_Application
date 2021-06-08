package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Here the SortSymptomData class will use the ReadSymptomDataFromFile Class and
 * its methods. It will count occurrences and sort symptoms in an alphabetical
 * order.
 * 
 * @see ReadSymptomDataFromFile
 * 
 * @see ISymptomReader
 * 
 * @author BBornier
 * 
 * @version 5.0
 * 
 */
public class SortSymptomsData {

	/**
	 * @return symptomsSort. Sort the list in alphabetical order, with occurrences
	 *         number for each symptom. It uses symptomsSort object.
	 */
	public TreeMap<String, Integer> sortingSymptomsData() {

		ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptomsFile = file.getSymptoms();

		TreeMap<String, Integer> symptomsSort = new TreeMap<>();
		for (String listSymptoms : symptomsFile) {
			
	/**
	* If the line contained the same line/symptom, increment the associate line :
	*/
			if (symptomsSort.containsKey(listSymptoms)) {
				symptomsSort.put(listSymptoms, symptomsSort.get(listSymptoms) + 1);
	
	/**
	* Else, pass to the next line, add it and initialize the count to 1 :
	*/
			} else {
				symptomsSort.put(listSymptoms, 1);
			}

		}
		return symptomsSort;
	}
}
