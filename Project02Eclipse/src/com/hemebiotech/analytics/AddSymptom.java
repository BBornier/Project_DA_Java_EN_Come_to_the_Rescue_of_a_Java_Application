package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddSymptom {
	
	public void addSymptoms () throws IOException {
		
		String answer = "Y";
		String symptom;
		String filename = "./symptoms.txt";
		File symptomFile;
		
		Scanner sc = new Scanner(System.in);
		symptomFile = new File(filename);
		
		System.out.println("\n" + "Do you want to add a new symptoms in symptoms.txt ? (Y/N)");
		answer = sc.nextLine();
		
		if (answer == "Y") {
			System.out.println("Please, write and enter the new symptom :");
			symptom = sc.nextLine();
			try {
				FileWriter newSymptom = new FileWriter(filename + "\r\n", true);
				newSymptom.write(symptom);
				newSymptom.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
			
		} else {
			System.out.println("Thank you for using our HemeBiotech symptoms application. Have a good day.");
		}
			
	}

}
