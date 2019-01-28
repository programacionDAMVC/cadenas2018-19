package com.iesvirgendelcarmen.ejercicios.pruebas;

import java.util.Scanner;

import com.iesvirgendelcarmen.ejercicios.Palabra;



public class PruebaPalabras {

	public static void main(String[] args) {
		System.out.println("introduce una palabra");
		Scanner sc = new Scanner(System.in);
		String palabra = sc.next();
		sc.close();
		if (palabra.toLowerCase().matches("[a-zñáéóíúü]+")) {
			Palabra p = new Palabra(palabra);
			System.out.printf("La palabra %s tiene %d letras, tiene %d vocales, "
					+ "empieza por vocal %b, acabe en vocal %b y es un palíndromo %b%n", 
					palabra, p.obtenerNumeroLetras(), p.obtenerNumeroVocales(), 
					p.empiezaPorVocal(), p.acabaEnVocal(), p.esPalindromo());
		}
		else
			System.out.printf("%s no es una palabra%n", palabra);

	}

}
