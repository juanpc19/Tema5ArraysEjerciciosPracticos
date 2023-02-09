package ejercicio1;

import java.util.Arrays;

public class FuncionesEj1 {

	static char[] creaArray(int longitud, int minas) {

		char tablaCreada[] = new char[longitud];

		int posInsercionAleatoria;

		int contador = 0;

		while (contador < minas) {
			posInsercionAleatoria = (int) (Math.random() * longitud);
			if (tablaCreada[posInsercionAleatoria] != '*') {
				tablaCreada[posInsercionAleatoria] = '*';
				contador++;

			}
		}

		//dividir for en 3 for 0 , 1 y 2
		for (int posicion = 0; posicion < tablaCreada.length; posicion++) {

			if ((tablaCreada[posicion] == '*') && (tablaCreada[posicion] != tablaCreada[tablaCreada.length - 1])) {
				tablaCreada[posicion + 1] = '1';
				
			} else if ((tablaCreada[posicion] != tablaCreada[0])
					&& (tablaCreada[posicion] != '1')
					&& (tablaCreada[posicion - 1] == '*')
					&& (tablaCreada[posicion + 1] == '*')) {
				tablaCreada[posicion] = '2';
			} 
			

			
			
		}

		System.out.println(Arrays.toString(tablaCreada));

		return tablaCreada;
	}
}
