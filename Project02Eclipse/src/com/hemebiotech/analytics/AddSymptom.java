package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * AddSymptoms to add new symptoms to the file symptoms.txt. Not asked to be created but it's an idea. 
 *
 * @author BBornier
 * 
 * @version 1.0
 */
public class AddSymptom {
	/**
	 * Method addSymptoms() asks to the User if he wants to add a new symptom to the symptoms.txt file.
	 * A do while loop allow to leave the application or stay to continue to add new symptoms.
	 * New Symptoms are writen in symptoms.txt file. Then the application continue to sort new symptoms and add occurrences.
	 * 
	 * @see SortSymptomsData
	 * @see FileWriterData
	 * 
	 */
	public void addSymptoms() {

		File symptomFile = new File("Project02Eclipse/symptoms.txt");
		String absolutePath = symptomFile.getAbsolutePath();

		Scanner sc = new Scanner(System.in);
		String answer = "Yes";

		do {
			System.out.println("\n" + "Do you want to add another symptom in symptoms.txt ? (Yes/No)");
			answer = sc.nextLine();
			if (answer.equalsIgnoreCase("No")) {
				System.out.println("\n" + "No problem. Have a good day.");
				break;
			} else
				System.out.println("Please, write and enter the new symptom :");
			String symptom = sc.nextLine();
			try {
				FileWriter newSymptom = new FileWriter(symptomFile, true);
				newSymptom.write("\n");
				newSymptom.write(symptom);
				newSymptom.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} while (answer.equalsIgnoreCase("Yes"));
		System.out.println("\n" + "Thank you for using our HemeBiotech symptoms application.");
	}
}