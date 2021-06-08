package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Here the FileWriterData class will use the sortSymptomData Class and its
 * methods. 
 * <p>
 * Will allow to write results in a file searchable.
 * 
 * @author BBornier
 * 
 * @version 5.0
 */
public class FileWriterData {

	/**
	 * Creation of 2 objects : fileOutput and writer.
	 * <p>
	 * fileOuput will be used with the sortingSymptomData method. In order to be used in the TreeMap.
	 * <p>
	 * writer will be used to write in results.out file. Will write a title "Symptoms List :" 
	 * and then all symptoms with the sum of their occurrences.
	 * <p>
	 * Creation of a new TreeMap object, symptomSort, with its for loop to write results with line breaks.
	 * 
	 * @throws IOException Handle exceptions while writing in a file.
	 *
	 * @see SortSymptomsData
	 */
	public void writeSymptomsData() throws IOException {

		try {
			SortSymptomsData fileOutput = new SortSymptomsData();

			FileWriter writer = new FileWriter("results.out");
			writer.write("Symptoms List :" + "\n");
			writer.write("\n");

			TreeMap<String, Integer> symptomsSort = fileOutput.sortingSymptomsData();
			for (Map.Entry<String, Integer> entry : symptomsSort.entrySet())
				writer.write(entry.getKey() + "= " + entry.getValue() + "\r\n");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}