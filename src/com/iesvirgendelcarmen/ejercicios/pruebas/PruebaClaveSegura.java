package com.iesvirgendelcarmen.ejercicios.pruebas;

import java.util.Scanner;

import com.iesvirgendelcarmen.ejercicios.ClaveSegura;

public class PruebaClaveSegura {
	final static String  FUENTE_CARACTERES = "aAbBcCdDeEfFgGhHiIjJkKlLm-"
			+ "MnNñÑoOpPqQrRsStTuUvVwWxXyYzZ0123456789¿?()=@.:,;!¡&{}";
	public static void main(String[] args) {
		
		System.out.println("Indica la longitud máxima de la clave (max 1000)");
		Scanner sc = new Scanner(System.in);
		String sLongitudClave = sc.next();
		sc.close();
		
		if (!sLongitudClave.matches("[0-9]{1,3}") || sLongitudClave.charAt(0) == '0') {
			System.out.println("No es válido el dato");
			return; //sale del método main, por lo tanto acaba el programa
		}
		
		int iLongituClave = Integer.parseInt(sLongitudClave);
		System.out.println("Tu clave va a tener una longitud " + iLongituClave );
		//String posibleClave = "";
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < iLongituClave; i++) {
			//System.out.println("Caracter recibido: " + obtenerCaracterAleatoriamente());
			//posibleClave += obtenerCaracterAleatoriamente();  //ineficiente, se crean tantos String como iLongitudClave
			stringBuilder.append(obtenerCaracterAleatoriamente());
		}
		//System.out.println(stringBuilder.toString());
		ClaveSegura claveSegura = new ClaveSegura();
		claveSegura.setClave(stringBuilder.toString());
		System.out.printf("%s ¿es clave segura? %b%n", 
				claveSegura.getClave(), claveSegura.esClaveSegura());
	}
	
	public static char obtenerCaracterAleatoriamente() {
//		int posicion = (int) (Math.random() * FUENTE_CARACTERES.length());
//		return FUENTE_CARACTERES.charAt(posicion);
		return FUENTE_CARACTERES.charAt(
				(int) (Math.random() * FUENTE_CARACTERES.length()));
	}
	
	

}
