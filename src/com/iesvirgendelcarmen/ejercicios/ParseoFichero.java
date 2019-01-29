package com.iesvirgendelcarmen.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseoFichero {

	public static void main(String[] args) throws FileNotFoundException {
		String dosCaracteres = "";
		boolean hayArgumento = args.length != 0;
		if ( hayArgumento && args[0].length() >= 2 ) {
			dosCaracteres = args[0].toLowerCase().substring(0, 2);
		}
		//	System.out.println("¿Hay argumento? " + hayArgumento);
		//listas para almacenar datos:
		List<String> nombresEmpiezanPorA = new ArrayList<>();
		List<String> nombresNoAcabanEnVocal = new ArrayList<>();
		List<String> nombresMasLargos = new ArrayList<>();
		List<String> nombresMasCortos = new ArrayList<>();
		List<String> nombresCoincidentes = new ArrayList<>();

		File inputFile = new File("ficheros/nombres_mujer.txt");
		Scanner sc = new Scanner(inputFile);

		int contador = 0;
		String linea;
		int iPalabraMayor = 0;
		int iPalabraMenor = Integer.MAX_VALUE;
		while (sc.hasNextLine()) {
			linea =  sc.nextLine();
			contador++;  //nos dice el número de nombres leídos
			if ( hayArgumento ) {
				//System.out.println("Buscando el  nombre ... " + args[0]);
				//if ( args[0] == linea) ¡¡¡¡MAL!!!! los String se comparan con equals
				if ( args[0].equalsIgnoreCase(linea)) {
					System.out.println("Existe el nombre " + args[0]);
					return;
				}
				if ( dosCaracteres.length() >= 2 &&
						linea.toLowerCase().startsWith(dosCaracteres)) {
					nombresCoincidentes.add(linea);
				}
				continue;
			}

			//nombres mas largos
			if (linea.length() == iPalabraMayor) {
				nombresMasLargos.add(linea);
			}
			else if (linea.length() > iPalabraMayor) {
				nombresMasLargos.clear();  //vaciamos la lista
				nombresMasLargos.add(linea);
				iPalabraMayor = linea.length();
			}
			//nombres mas cortos
			if (linea.length() == iPalabraMenor) {
				nombresMasCortos.add(linea);
			}
			else if (linea.length() < iPalabraMenor) {
				nombresMasCortos.clear();  //vaciamos la lista
				nombresMasCortos.add(linea);
				iPalabraMenor = linea.length();
			}
			//nombres que empiezan por a
			if (linea.matches("^[AaÁá].*"))
				nombresEmpiezanPorA.add(linea);
			//nombres que no acaban en vocal
			if (linea.toLowerCase().matches(".*[^aeiouáéóíú]$"))
				nombresNoAcabanEnVocal.add(linea);

		}
		sc.close();
		if ( !hayArgumento ) {
			System.out.println("Nº nombre de mujer leídos: " + contador);
			System.out.println("Nombre que empiezan por a " + nombresEmpiezanPorA);
			System.out.println("Nombre que acaban en consonante " + nombresNoAcabanEnVocal);
			System.out.println("Nombre mas largos: " + nombresMasLargos);
			System.out.println("Nombre mas cortos: " + nombresMasCortos);
		}
		else {
			System.out.println("No existe el nombre de mujer " + args[0]);
			if (nombresCoincidentes.size() > 0) {
				System.out.println("Nombres de mujer coincidentes");
				System.out.println(nombresCoincidentes);
			}
		}


	}

}
