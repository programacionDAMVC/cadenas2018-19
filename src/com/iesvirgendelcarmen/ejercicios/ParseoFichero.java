package com.iesvirgendelcarmen.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseoFichero {

	public static void main(String[] args) throws FileNotFoundException {
		boolean hayArgumento = args.length !=0;
		//listas para almacenar datos:
		List<String> nombresEmpiezanPorA = new ArrayList<>();
		List<String> nombresNoAcabanEnVocal = new ArrayList<>();

		File inputFile = new File("ficheros/nombres_mujer.txt");
		Scanner sc = new Scanner(inputFile);
		
		int contador = 0;
		String linea;
		int iPalabraMayor = 0;
		while (sc.hasNextLine()) {
			linea =  sc.nextLine();
			contador++;
			if (linea.matches("^[AaÁá].*"))
				nombresEmpiezanPorA.add(linea);
			if (linea.toLowerCase().matches(".*[^aeiouáéóíú]$"))
				nombresNoAcabanEnVocal.add(linea);
			
		}
		sc.close();
		System.out.println("Nº líneas leídas: " + contador);
		System.out.println(nombresEmpiezanPorA);
		System.out.println(nombresNoAcabanEnVocal);
	}

}
