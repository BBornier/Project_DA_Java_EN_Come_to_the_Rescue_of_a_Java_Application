package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

	/**
	 * Here the FileWriterData class will use the sortSymptomData Class and its methods,
	 * it will allow to write results in a file searchable.
	 * 
	 * @see SortSymptomsData
	 * 
	 * @author BBornier
	 * @version 5.0
	 */

public class FileWriterData {

	/**
	 * 
	 * symptomsSorting Object refers to sortingSymptomsData() method.
	 * 
	 * @see sortingSymptomsData
	 * 
	 */
	
	
	public void writeSymptomsData() throws IOException {
		try {
			
			SortSymptomsData symptomsSorting = new SortSymptomsData();
			
			FileWriter writer = new FileWriter("results.out");
			writer.write("Symptoms List " + symptomsSorting.sortingSymptomsData());
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}