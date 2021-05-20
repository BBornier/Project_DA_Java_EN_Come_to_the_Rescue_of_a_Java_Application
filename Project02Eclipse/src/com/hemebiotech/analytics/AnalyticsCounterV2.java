package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AnalyticsCounterV2 {

	public static void main(String[] args) throws IOException {
		try {
			
		/*
		 * Cette ligne charge toutes les lignes en mémoire, dans une liste.
		 */
		List<String> lines = Files.readAllLines(Paths.get("Project02Eclipse/symptoms.txt"));

		/*
		 * Ici, on compte les doublons grâce à la Map. En paramètres, Clé (ligne) et
		 * valeur (nb d'occurrences). Avoir instancié "TreeMap" permet de sortir les
		 * symptômes dans l'ordre alphabétique en affichage de console.
		 * Utilisation du comparateur avec la classe Collator. Cela prendra en compte les accents 
		 * (si l'on veut une version du fichier result.out en français).
		 * 
		 */

		TreeMap<String, Long> comptTri = new TreeMap<>(Collator.getInstance());
		
		for (String symptoms : lines) {

			if (comptTri.containsKey(symptoms)) {
				// si la ligne contient déjà la ligne, on incrémente le compteur qui est associé :
				comptTri.put(symptoms, comptTri.get(symptoms) + 1);
			} else {
				// sinon on ajoute l'association en initialisant le compteur à 1 (1L étant pour le type long) :
				comptTri.put(symptoms, 1L);
			}
		}
			// Sortir la liste des symptômes dans la console :
			Files.lines(Paths.get("Project02Eclipse/symptoms.txt")).forEach(System.out::println);
			// Sortir la TreeMap en brut dans la console :
			System.out.println(comptTri);

		/*
		 * Cette ligne permet d'écrire dans le fichier resultV2.out les résultats.
		 */
			Files.write(Paths.get("resultV2.out"), lines);
		
		/*
		 * Cette partie permet d'écrire dans le fichier resultV3.out les résultats triés, à la ligne et avec le nb d'occurrences.
		 */
				List<String> finallines = comptTri.entrySet()
							.stream()
							.map(entry-> entry.getKey()+": "+entry.getValue())
							.collect(Collectors.toList());
				Files.write(Paths.get("resultV3.out"), finallines);
		
		
			} catch(IOException e) {
				e.printStackTrace();
			
		}
	}
}
