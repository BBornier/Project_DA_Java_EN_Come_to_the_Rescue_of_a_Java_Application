package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddSymptom {
	
	public static void addSymptoms () {
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to add a new symptoms in symptoms.txt ? say Y or N");
		String answer = sc.nextLine();
		
		if (answer == "Y") {
			System.out.println("Please, write and enter the new symptom :");
			String symptom = sc.nextLine();
			try {
				FileWriter newSymptom = new FileWriter("Project02Eclipse/symptoms.txt" + "\r\n");
				newSymptom.write(symptom);
				newSymptom.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			else 
				System.out.println("Thank you for using our symptoms application. Have a good day.");
				
			
		
		
	}

}
