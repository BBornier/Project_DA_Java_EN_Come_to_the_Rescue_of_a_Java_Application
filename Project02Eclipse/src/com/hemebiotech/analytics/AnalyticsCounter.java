package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * AnalyticsCounter is the main class where the program starts.
 *
 * @author BBornier
 * 
 * @version 5.0
 */
public class AnalyticsCounter {

	/**
	 * Execute the writing of datas in the file results.out. 
	 * <p>
	 * Test the TreeMap with console output.
	 * <p> 
	 * Invoke the method writeSymptomsData that will write results in the file results.out.
	 * <p>
	 * Invoke our TreeMap from SortSymptomData class and check if everything
	 * is ok with console output. The for loop is used to sort results with lines
	 * break.
	 * <p>
	 * ConsoleOutput Object uses sortinSymptomsData method.
	 * 
	 * @throws IOException Handle exceptions.
	 * 
	 * @see FileWriterData
	 * 
	 * @see SortSymptomsData
	 */
	public static void main(String[] args) throws IOException {

		FileWriterData finalResult = new FileWriterData();
		finalResult.writeSymptomsData();

		SortSymptomsData consoleOutput = new SortSymptomsData();

		System.out.println("Symptoms List :" + "\n");
		
		TreeMap<String, Integer> symptoms = consoleOutput.sortingSymptomsData();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet())
			System.out.println(entry.getKey() + ": " + entry.getValue());

	}

}
