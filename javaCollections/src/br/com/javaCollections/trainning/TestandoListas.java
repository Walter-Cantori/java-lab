package br.com.javaCollections.trainning;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
	public static void main(String[] args) {
		String aula1 = "foo";
		String aula2 = "bar";
		String aula3 = "baz";
		
		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas);
		
		aulas.remove(0);
		
		System.out.println(aulas);
		
		for (String aula : aulas) {
			System.out.println(aula);
		}
		
		String primeiraAula = aulas.get(0);
		System.out.println("A primeira aula é " + primeiraAula);
		
		for (int i = 0; i < aulas.size(); i++) {
			System.out.println(aulas.get(i));
		}
		
		aulas.forEach(aula -> {
			System.out.println("percorrendo: " + aula);
		});
		
		aulas.add("asas");
		Collections.sort(aulas);
		System.out.println(aulas);
	}
}
