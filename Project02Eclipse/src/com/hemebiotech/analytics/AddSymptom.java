package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class AddSymptom {
	
	public static void addSymptoms () {
		
		File symptomFile = new File("D:\\Travail\\Formations\\Dev Appli Java\\P2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
		String absolutePath = symptomFile.getAbsolutePath();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n" + "Do you want to add a new symptoms in symptoms.txt ? (Yes/No)");
		String answer = sc.nextLine();
		
		if (answer.equals("Yes")) 
		{
			System.out.println("\n" + "Please, write and enter the new symptom :");
			String symptom = sc.nextLine();
			try {
				FileWriter newSymptom = new FileWriter(symptomFile, true);
				newSymptom.write("\n");
				newSymptom.write(symptom);
				newSymptom.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
			System.out.println("\n" + "Thank you for using our HemeBiotech symptoms application. Have a good day.");
		}
			else if (answer.equals("No"))
		{
			System.out.println("\n" + "No problem. Have a good day.");
		}
			else
				System.out.println("\n" + "Wrong answer, please launch again the program.");
	}

}