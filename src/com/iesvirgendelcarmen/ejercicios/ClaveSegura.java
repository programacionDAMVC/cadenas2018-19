package com.iesvirgendelcarmen.ejercicios;

public class ClaveSegura {

	private String clave;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean esClaveSegura() {
		return tieneAlMenos8Caracter() && tieneAlMenos1LetraMinuscula()
				&& tieneAlMenos1LetraMayuscula() && tieneAlMenos1Numero()
				&& tienAlMenos1CaracterAlfaNumerico();
	}

	private boolean tienAlMenos1CaracterAlfaNumerico() {
		for (int i = 0; i < clave.length(); i++) {
		if ( !Character.isLetterOrDigit(clave.charAt(i)) ) 
			return true;
	}
	return false;
	}

	private boolean tieneAlMenos1Numero() {
		// TODO Auto-generated method stub
		return clave.matches("^.*[0-9].*$");
	}

	private boolean tieneAlMenos1LetraMayuscula() {
//		for (int i = 0; i < clave.length(); i++) {
//			if (Character.isUpperCase(clave.charAt(i))) 
//				return true;
//		}
//		return false;
		return clave.matches("^.*[A-ZÑÁÉÍÓÚÜ].*$");
	}

	private boolean tieneAlMenos1LetraMinuscula() {
		return clave.matches("^.*[a-zñáéíóúü].*$");
	}

	private boolean tieneAlMenos8Caracter() {
		return clave.length() >= 8;
		//return clave.matches("[.]{8,}");
	}

//	public static void main(String[] args) {
//		ClaveSegura c = new ClaveSegura();
//		c.setClave("344M{{á{{{{{{{{");
//		System.out.println(c.esClaveSegura());
//	}

}
