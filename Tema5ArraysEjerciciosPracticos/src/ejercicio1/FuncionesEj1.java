package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class FuncionesEj1 {

	static int longitud = 0;

	static int minas = 0;

	static char[] creaArray(char tablaMain[]) {

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

		// print para comprobar funcion quitar al finalizar ejercicio
		System.out.println(Arrays.toString(tablaCreada));

		return tablaCreada;
	}

	static void ejecutaJuego(char tablaMain[]) {

		char tablaCopiada[] = tablaMain;

		int numero = 0;

		int contador = 0;

		Scanner dogma = new Scanner(System.in);

		while (tablaCopiada[numero] != '*' && contador <= longitud - minas) {

			System.out.println("Indique una casilla a destapar entre 0 y " + longitud);

			numero = dogma.nextInt();

			for (int posicion = 0; posicion < tablaCopiada.length; posicion++) {

				if (tablaCopiada[numero] == tablaCopiada[posicion]) {
					System.out.println(tablaCopiada[posicion]);
				}
			}
			contador++;

		}
	}

}
