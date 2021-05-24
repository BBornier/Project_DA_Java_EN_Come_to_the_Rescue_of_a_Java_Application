package com.hemebiotech.analytics;

import java.io.IOException;

public class AnalyticsCounterV5 {

	public static void main(String[] args) throws IOException {
		
		FileWriterData finalResult = new FileWriterData();
		SortSymptomsData consoleOutput = new SortSymptomsData();
		
		finalResult.writeSymptomsData();
		consoleOutput.sortingSymptomsData();
		
		System.out.println("la console affiche "+ consoleOutput);

	}

}
