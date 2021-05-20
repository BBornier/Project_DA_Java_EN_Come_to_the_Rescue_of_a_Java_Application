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
		 * Cette ligne charge toutes les lignes en m�moire, dans une liste.
		 */
		List<String> lines = Files.readAllLines(Paths.get("Project02Eclipse/symptoms.txt"));

		/*
		 * Ici, on compte les doublons gr�ce � la Map. En param�tres, Cl� (ligne) et
		 * valeur (nb d'occurrences). Avoir instanci� "TreeMap" permet de sortir les
		 * sympt�mes dans l'ordre alphab�tique en affichage de console.
		 * Utilisation du comparateur avec la classe Collator. Cela prendra en compte les accents 
		 * (si l'on veut une version du fichier result.out en fran�ais).
		 * 
		 */

		TreeMap<String, Long> comptTri = new TreeMap<>(Collator.getInstance());
		
		for (String symptoms : lines) {

			if (comptTri.containsKey(symptoms)) {
				// si la ligne contient d�j� la ligne, on incr�mente le compteur qui est associ� :
				comptTri.put(symptoms, comptTri.get(symptoms) + 1);
			} else {
				// sinon on ajoute l'association en initialisant le compteur � 1 (1L �tant pour le type long) :
				comptTri.put(symptoms, 1L);
			}
		}
			// Sortir la liste des sympt�mes dans la console :
			Files.lines(Paths.get("Project02Eclipse/symptoms.txt")).forEach(System.out::println);
			// Sortir la TreeMap en brut dans la console :
			System.out.println(comptTri);

		/*
		 * Cette ligne permet d'�crire dans le fichier resultV2.out les r�sultats.
		 */
			Files.write(Paths.get("resultV2.out"), lines);
		
		/*
		 * Cette partie permet d'�crire dans le fichier resultV3.out les r�sultats tri�s, � la ligne et avec le nb d'occurrences.
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
