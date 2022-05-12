package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Executer {

	public static void main(String[] args) throws IOException {
		int nombre_acteurs;
		String selection;
		boolean termine = false;
		String chemin_fichier = "C:\\Users\\chesi\\OneDrive\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\films.txt";
		Stream<String> stream;

		Map<String, List<String>> map;
		stream = Files.lines(Paths.get(chemin_fichier));
		map = stream.map(t -> t.split(";")).collect(Collectors.toMap(t -> t[0], l -> Arrays.asList(l).subList(1, l.length)));

		do {
			System.out.print("Veuillez sélectionner une des questions de 1 à 9 si vous voulez quitter appuyez sur 'q': ");
			try (Scanner saisie = new Scanner(System.in)) {
				selection = saisie.next();
			}
			
			switch(selection) {
				case "1":
					// Question 1 
					System.out.println("====================================================================");
					System.out.println("Question 1: Afficher les films et leurs acteurs");
					System.out.println("====================================================================");
			
					for (Map.Entry<String, List<String>> entry : map.entrySet()) {
					   System.out.println("Key : " + entry.getKey() + " - values : " + entry.getValue());
					}
					break;
					
				case "2":
					// Question 2
					System.out.println("====================================================================");
					System.out.println("Question 2: Afficher les 50 premiers acteurs");
					System.out.println("====================================================================");
					map.values().stream().flatMap(Collection :: stream)
					.limit(50)
					.forEach(System.out::println);
					break;
				
				case "3":
					// Question 3
					System.out.println("====================================================================");
					System.out.println("Question 3: Afficher les 50 premiers acteurs");
					System.out.println("====================================================================");
					nombre_acteurs = (int) map.values().stream().flatMap(Collection :: stream).count();
					System.out.println("Nombre d'acteur: " + nombre_acteurs);
					break;
				
				case "4":
					// Question 4
					System.out.println("====================================================================");
					System.out.println("Question 4: Obtenir le nombre d'acteurs réel");
					System.out.println("====================================================================");
					int nombre_acteurs_reel = (int) map.values().stream().flatMap(Collection :: stream).distinct().count();
					System.out.println("Nombre réel d'acteurs: " + nombre_acteurs_reel);
					break;
					
				case "5":
					// Question 5
					System.out.println("====================================================================");
					System.out.println("Question 5: Obtenir le nombre d'acteurs réel");
					System.out.println("====================================================================");
					nombre_acteurs_reel = (int) map.values().stream().flatMap(Collection :: stream).distinct().count();
					System.out.println("Nombre réel d'acteurs: " + nombre_acteurs_reel);
					break;
				
				case "6":
					// Question 6
					System.out.println("====================================================================");
					System.out.println("Question 6: Obtenir le nombre d'acteurs réel");
					System.out.println("====================================================================");
					map.values().stream().flatMap(List::stream).collect(Collectors.groupingBy(s -> s)).forEach((s, film) -> System.out.println(s + " : " + film.stream().count()));
					break;
					
				case "7":
					// Question 7
					System.out.println("====================================================================");
					System.out.println("Question 7: Obtenir le nombre d'acteurs réel");
					System.out.println("====================================================================");
					map.values().stream().map(Function.identity()).forEach(System.out::println);
					break;
					
				case "8":
					// Question 8
					System.out.println("====================================================================");
					System.out.println("Question 8: Affiche les acteurs et le nombre de film dans lesquels\n ils ont joué");
					System.out.println("====================================================================");
					map.values().stream().flatMap(List::stream).collect(Collectors.groupingBy(s -> s))
				      .forEach((s, users) -> System.out.println(s + " : " + users.stream().count()));
					break;
					
				case "9":
					// Question 9
					System.out.println("====================================================================");
					System.out.println("Question 9: L'acteur ayant dans le plus de film");
					System.out.println("====================================================================");
					Map < String, List < String >> listActors = map.values().stream().flatMap(List::stream).collect(Collectors.groupingBy(s -> s));
				    System.out.println("Acteur ayant joué le plus de films : " + listActors.values().stream().max(Comparator.comparing(List::size)).map(List -> List.get(0)).orElse(null));
					break;
					
				case "q":
					termine = true;
					break;
			}
		}while(termine == false);
		System.out.println("Fin.");
		stream.close();
	}

}
