package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounterV3 {
	public static void main(String[] args) throws IOException {
		try {

			ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

			file.getSymptoms();
			List<String> symptFile = file.getSymptoms();

			TreeMap<String, Long> symptTri = new TreeMap<>();

			for (String symptoms : symptFile) {

				if (symptTri.containsKey(symptoms)) {
					// si la ligne contient déjà la même ligne, on incrémente le compteur qui est
					// associé :
					symptTri.put(symptoms, symptTri.get(symptoms) + 1);
				} else {
					// sinon on ajoute l'association en initialisant le compteur à 1 (1L étant pour
					// le type long) :
					symptTri.put(symptoms, 1L);
				}

			}
			System.out.println(symptTri);

			FileWriter writer = new FileWriter("resultTest.out");
			writer.write("Symptoms List " + symptTri);
			writer.close();

			/*
			 * Ici, on compte les doublons grâce à la Map. En paramètres, on renseigne le
			 * type de Clé (ligne) et le type de valeur (nb d'occurrences). La TreeMap<>
			 * permet de sortir les symptômes dans l'ordre alphabétique et permet de
			 * comptabiliser le nb d'occurences ave cle résultat attendu. J'utilise un
			 * comparateur avec la classe Collator. Cela prendra en compte les accents (si
			 * l'on veut une version du fichier result.out en français ou dans une autre
			 * langue).
			 * 
			 */

			// TreeMap<String, Long> symptoms = new TreeMap<>(Collator.getInstance());

			/*
			 * for (String symptoms : lines) {
			 * 
			 * if (comptTri.containsKey(symptoms)) { // si la ligne contient déjà 1 ligne,
			 * on incrémente le compteur qui est associé : comptTri.put(symptoms,
			 * comptTri.get(symptoms) + 1); } else { // sinon on ajoute l'association en
			 * initialisant le compteur à 1 (1L étant pour le type long) :
			 * comptTri.put(symptoms, 1L); } } // Pour vérifier en sortie la liste des
			 * symptômes avec saut de ligne dans la console :
			 * Files.lines(Paths.get("Project02Eclipse/symptoms.txt")).forEach(System.out::
			 * println); // Pour vérifier en sortie la TreeMap en brut dans la console sans
			 * saut de ligne : System.out.println(comptTri);
			 */

			/*
			 * Cette ligne permet d'écrire dans le fichier resultV2.out les résultats.
			 */
			// Files.write(Paths.get("resultV2.out"), lines);

			/*
			 * Cette partie permet d'écrire les résultats dans le fichier resultV3.out,
			 * triés, à la ligne et avec le nb d'occurrences par symptôme. La Map est ici
			 * transformée en liste. La méthode stream() = flux. Elle permet au programme de
			 * recevoir des données et d'en renvoyer. On prend la liste des associations de
			 * la Map. map() représente ces associations. Avec map(entry-> entry.getKey /
			 * entry.getValue) on récupère chaque clef et chaque valeur du stream. La
			 * méthode Collectors.toList collecte tous les éléments du stream dans une
			 * instance de List.
			 * 
			 */
			/*
			 * List<String> finallines = comptTri.entrySet() .stream() .map(entry->
			 * entry.getKey()+": "+entry.getValue()) .collect(Collectors.toList());
			 * Files.write(Paths.get("resultV3.out"), finallines);
			 */

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
