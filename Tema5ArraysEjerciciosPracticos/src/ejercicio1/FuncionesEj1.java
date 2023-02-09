package ejercicio1;

import java.util.Arrays;

public class FuncionesEj1 {

	static int longitud = 0;

	static int minas = 0;

	static char[] creaArray() {

		char tablaCreada[] = new char[longitud];

		int posInsercionAleatoria;

		int contador = 0;

		for (int posicion = 0; posicion < tablaCreada.length; posicion++) {
			tablaCreada[posicion] = '0';
		}

		while (contador < minas) {

			posInsercionAleatoria = (int) (Math.random() * longitud);

			if (tablaCreada[posInsercionAleatoria] != '*') {
				tablaCreada[posInsercionAleatoria] = '*';
				contador++;

				if (posInsercionAleatoria != tablaCreada.length - 1 && tablaCreada[posInsercionAleatoria + 1] != '*') {
					tablaCreada[posInsercionAleatoria + 1] = '1';
				}

				if (posInsercionAleatoria != 0 && tablaCreada[posInsercionAleatoria - 1] != '*') {
					tablaCreada[posInsercionAleatoria - 1] = '1';
				}
			}

		}

		for (int posicion = 0; posicion < tablaCreada.length; posicion++) {

			if (posicion != 0 && posicion != tablaCreada.length - 1 && tablaCreada[posicion - 1] == '*'
					&& tablaCreada[posicion + 1] == '*' && tablaCreada[posicion] != '*') {

				tablaCreada[posicion] = '2';
			}
		}

		//print para comprobar funcion quitar al finalizar ejercicio
		System.out.println(Arrays.toString(tablaCreada));

		return tablaCreada;
	}
}
