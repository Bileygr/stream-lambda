package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Executer {

	public static void main(String[] args) throws IOException {
		int nombre_acteurs;
		String chemin_fichier = "C:\\Users\\chesi\\OneDrive\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\films.txt";
		Stream<String> stream;

		Map<String, List<String>> map;

		stream = Files.lines(Paths.get(chemin_fichier));

		// Question 1 
		System.out.println("====================================================================");
		System.out.println("Question 1: Afficher les films et leurs acteurs");
		System.out.println("====================================================================");
		map = stream.map(t -> t.split(";")).collect(Collectors.toMap(t -> t[0], l -> Arrays.asList(l).subList(1, l.length)));

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		   System.out.println("Key : " + entry.getKey() + " - values : " + entry.getValue());
		}
		
		// Question 2
		System.out.println("====================================================================");
		System.out.println("Question 2: Afficher les 50 premiers acteurs");
		System.out.println("====================================================================");
		map.values().stream().flatMap(Collection :: stream)
		.limit(50)
		.forEach(System.out::println);
		
		// Question 3
		System.out.println("====================================================================");
		System.out.println("Question 3: Afficher les 50 premiers acteurs");
		System.out.println("====================================================================");
		nombre_acteurs = (int) map.values().stream().flatMap(Collection :: stream).count();
		System.out.println("Nombre d'acteur: " + nombre_acteurs);
		
		// Question 4
		System.out.println("====================================================================");
		System.out.println("Question 4: Afficher les 50 premiers acteurs");
		System.out.println("====================================================================");
		
		stream.close();
	}

}
