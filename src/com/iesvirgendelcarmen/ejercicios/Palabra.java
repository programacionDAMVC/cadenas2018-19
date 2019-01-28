package com.iesvirgendelcarmen.ejercicios;

/**
 * Clase que aporta funciones sobre el 
 * contenido de una palabra
 * @author Manuel Molino
 * @version 1.0
 */

public class Palabra {

	private String contenido;
	
	/**
	 * Constructor
	 * @param contenido palabra 
	 */
	public Palabra(String contenido) {
		this.contenido = contenido;
	}
	
	/**
	 * @return número de letras
	 */
	public int obtenerNumeroLetras() {
		return contenido.length();
	}
	
	/**
	 * @return si y solo sí la palabra empieza por vocal
	 */
	public boolean empiezaPorVocal() {
		
		//return contenido.toLowerCase().startsWith("a") || 
		//contenido.toLowerCase.startsWith("á") || contenido.toLowerCase().starsWith("e")
		//.......
		return contenido.toLowerCase().matches("^[aeiouáéíóúü].*$");
	}
	
	/**
	 * @return true, si y solo sí la palabra acaba por vocal
	 */
	public boolean acabaEnVocal() {
		
		//return contenido.toLowerCase().endsWith("a") || .....
		return contenido.toLowerCase().matches("^.*[aeiouáéíóúü]$");
		
	}
	
	/**
	 * @return número de vocales de la palabra
	 */
	public int obtenerNumeroVocales() { 
		int contador = 0;
		for (int i = 0; i < contenido.length(); i++) {
//			if (contenido.toLowerCase().charAt(i) == 'a'
//					|| contenido.toLowerCase().charAt(i) == 'á' ) ....
//			contador++;
		if	(("" + contenido.toLowerCase().charAt(i)).matches("[aeiouáéíóúü]"))
			contador++;
		}
		return contador;
	}
	
	/**
	 * @return true, si y solo sí la palabra contiena alguna h
	 */
	public boolean contieneH() {
		return contenido.toLowerCase().contains("h");
	}
	
	/**
	 * @return true, si y solo sí la palabra es un palíndromo
	 */
	public boolean esPalindromo() {
//		StringBuilder stringBuilder = new StringBuilder(contenido);
//		StringBuilder stringBuilderReverse = stringBuilder.reverse();
//		String contenidoReverse = stringBuilderReverse.toString();
//		return contenido.equalsIgnoreCase(contenidoReverse);
		return contenido.equalsIgnoreCase(
				new StringBuilder(contenido).reverse().toString());
	}
	
	/**
	 * @param palabra que es la palabra a comparar
	 * @return true, si y solo sí la palabra es la misma que el atributo, 
	 * ignorando mayúsculas y minúsculas
	 */
	public boolean sonIguales(String palabra) {
		return contenido.equalsIgnoreCase(palabra);
	}
	
//	public static void main(String[] args) {
//		Palabra p = new Palabra("Al");
//		System.out.println(p.esPalindromo());
//	}
	
}
