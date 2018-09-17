package com.nibor.main;

import com.nibor.rajo.Proceso;

public class Main {

	public static void main(String[] args) {
		Proceso proceso = new Proceso();
		//Seteamos datos iniciales
		proceso.valoresIniciales();
		proceso.valorizarBloques();
	}
}