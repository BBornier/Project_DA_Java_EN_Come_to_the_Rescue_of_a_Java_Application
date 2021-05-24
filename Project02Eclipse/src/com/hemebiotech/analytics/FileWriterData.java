package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterData {

	void writeSymptomsData() throws IOException {
		try {
			SortSymptomsData symptomsSorting = new SortSymptomsData();
			FileWriter writer = new FileWriter("resultV5.out");
			writer.write("Symptoms List " + symptomsSorting);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}