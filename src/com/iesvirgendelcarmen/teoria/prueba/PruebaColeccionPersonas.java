package com.iesvirgendelcarmen.teoria.prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iesvirgendelcarmen.teoria.Persona;
// gabriel jesús ; gonzález  del amo; martínez; 25; 25.25
// jesús ; gonzález ; martínez; 55; 55,25
//jesús ; gonzález ; martínez; 5dfsdfsd; 55,25    Este no se usar para crear objeto Persona


public class PruebaColeccionPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Persona> listaPersonas = new ArrayList<>();
		System.out.println("Introduce nombre, apellidos, edad y peso");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[;\\n]");
		String nombresRegex = "[a-zA-ZñÑáÁéÉíÍóÓúÚüÜ\\s]+";
		String enteroRegex  = "\\d+";  // [0-9]+
		String realRegex    = "([\\d]+|[\\d]+\\.[\\d]+)";   // 2 34  2,26  22,5888
		String nombre, apellido1, apellido2, edad, peso;
		int edadNumero;
		float pesoNumero;
		//Persona persona;
		for (int i = 0; i < 5; i++) {
			nombre = sc.next().trim();
			apellido1 = sc.next().trim();
			apellido2 = sc.next().trim();
			edad   = sc.next().trim();
			peso   = sc.next().trim();

			if ( edad.matches(enteroRegex) && peso.matches(realRegex) ) {
				edadNumero = Integer.parseInt(edad);  //entran nada mas que nº enteros
				pesoNumero = Float.parseFloat(peso);  //entran nada mas que nº reales
				if (nombre.matches(nombresRegex) && apellido1.matches(nombresRegex) &&
						apellido2.matches(nombresRegex) && (edadNumero > 0 && edadNumero < 150)
						&& (pesoNumero > 0 && pesoNumero < 400)) {
//					persona = new Persona(nombre, apellido1, apellido2, edadNumero, pesoNumero);
//					listaPersonas.add(persona);
					listaPersonas.add(new Persona(nombre, apellido1, apellido2, 
							edadNumero, pesoNumero));
					
				}
			}
			//			System.out.printf("Leido: %S %S, %s %s %s%n", 
			//					apellido1, apellido2, nombre, edad, peso);
		}
		sc.close();
		//System.out.println(listaPersonas);
//		for (Persona persona : listaPersonas) {
//			System.out.println(persona);
//		}
		listaPersonas.forEach(System.out::println);
	}

}
