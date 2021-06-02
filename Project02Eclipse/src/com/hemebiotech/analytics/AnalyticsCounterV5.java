package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


/**
 * AnalyticsCounterV5 is the main class where the program starts.
 * <p> 
 * <ul>
 * <li> It will invoke class and method that :</li>
 * <li> will read a symptom file,</li>
 * @see ReadSymptomDataFromFile
 * <li> sort symptoms,</li>
 * @see SortSymptomsData
 * <li> count occurrences</li> 
 * @see SortSymptomsData
 * <li> add occurences,</li>
 * @see SortSymptomsData
 * <li> and finally write results in a new file.</li> 
 * @see FileWriterData
 * </ul>
 * </p>
 * 
 * 
 * @author BBornier
 * @version 5.0
 */

public class AnalyticsCounterV5 {

	/**
	 * Beginning of the program.
	 * @param args
	 * 
	 * Handle exceptions.
	 * @throws IOException
	 * 
	 */

	public static void main(String[] args) throws IOException {
		
		/** 
		 * Here, we invoke the method writeSymptomsData that will write results in the file result.out.   
		 * 
		 * @see FileWriterData
		 * 
		 */
		
		FileWriterData finalResult = new FileWriterData();	
		finalResult.writeSymptomsData();
		
		/**
		 * Here we invoke our TreeMap from SortSymptomData class and check if everything is ok with console output.  
		 * The for loop is used to sort results with lines break.
		 * 
		 * @see SortSymptomsData
		 * 
		 * consoleOutput Object uses sortinSymptomsData method.
		 * @see sortingSymptomsData
		 * 
		 */
		
		SortSymptomsData consoleOutput = new SortSymptomsData();
		
		TreeMap<String, Integer> symptoms = consoleOutput.sortingSymptomsData();
		for (Map.Entry<String, Integer> entry : symptoms.entrySet())
			System.out.println("Symptoms : " + entry.getKey() + ": " +entry.getValue());	
		
	}

}
