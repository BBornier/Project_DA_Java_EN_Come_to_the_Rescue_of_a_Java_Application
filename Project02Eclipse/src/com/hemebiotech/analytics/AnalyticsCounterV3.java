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
					// si la ligne contient d�j� la m�me ligne, on incr�mente le compteur qui est
					// associ� :
					symptTri.put(symptoms, symptTri.get(symptoms) + 1);
				} else {
					// sinon on ajoute l'association en initialisant le compteur � 1 (1L �tant pour
					// le type long) :
					symptTri.put(symptoms, 1L);
				}

			}
			System.out.println(symptTri);

			FileWriter writer = new FileWriter("resultTest.out");
			writer.write("Symptoms List " + symptTri);
			writer.close();

			/*
			 * Ici, on compte les doublons gr�ce � la Map. En param�tres, on renseigne le
			 * type de Cl� (ligne) et le type de valeur (nb d'occurrences). La TreeMap<>
			 * permet de sortir les sympt�mes dans l'ordre alphab�tique et permet de
			 * comptabiliser le nb d'occurences ave cle r�sultat attendu. J'utilise un
			 * comparateur avec la classe Collator. Cela prendra en compte les accents (si
			 * l'on veut une version du fichier result.out en fran�ais ou dans une autre
			 * langue).
			 * 
			 */

			// TreeMap<String, Long> symptoms = new TreeMap<>(Collator.getInstance());

			/*
			 * for (String symptoms : lines) {
			 * 
			 * if (comptTri.containsKey(symptoms)) { // si la ligne contient d�j� 1 ligne,
			 * on incr�mente le compteur qui est associ� : comptTri.put(symptoms,
			 * comptTri.get(symptoms) + 1); } else { // sinon on ajoute l'association en
			 * initialisant le compteur � 1 (1L �tant pour le type long) :
			 * comptTri.put(symptoms, 1L); } } // Pour v�rifier en sortie la liste des
			 * sympt�mes avec saut de ligne dans la console :
			 * Files.lines(Paths.get("Project02Eclipse/symptoms.txt")).forEach(System.out::
			 * println); // Pour v�rifier en sortie la TreeMap en brut dans la console sans
			 * saut de ligne : System.out.println(comptTri);
			 */

			/*
			 * Cette ligne permet d'�crire dans le fichier resultV2.out les r�sultats.
			 */
			// Files.write(Paths.get("resultV2.out"), lines);

			/*
			 * Cette partie permet d'�crire les r�sultats dans le fichier resultV3.out,
			 * tri�s, � la ligne et avec le nb d'occurrences par sympt�me. La Map est ici
			 * transform�e en liste. La m�thode stream() = flux. Elle permet au programme de
			 * recevoir des donn�es et d'en renvoyer. On prend la liste des associations de
			 * la Map. map() repr�sente ces associations. Avec map(entry-> entry.getKey /
			 * entry.getValue) on r�cup�re chaque clef et chaque valeur du stream. La
			 * m�thode Collectors.toList collecte tous les �l�ments du stream dans une
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
