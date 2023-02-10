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

		for (int posicion = 0; posicion < longitud; posicion++) {
			tablaCreada[posicion] = '0';
		}

		while (contador < minas) {

			posInsercionAleatoria = (int) (Math.random() * longitud);

			if (tablaCreada[posInsercionAleatoria] != '*') {
				tablaCreada[posInsercionAleatoria] = '*';
				contador++;

				if (posInsercionAleatoria != longitud - 1 && tablaCreada[posInsercionAleatoria + 1] != '*') {
					tablaCreada[posInsercionAleatoria + 1] = '1';
				}

				if (posInsercionAleatoria != 0 && tablaCreada[posInsercionAleatoria - 1] != '*') {
					tablaCreada[posInsercionAleatoria - 1] = '1';
				}
			}

		}

		for (int posicion = 0; posicion < longitud; posicion++) {

			if (posicion != 0 && posicion != longitud - 1 && tablaCreada[posicion - 1] == '*'
					&& tablaCreada[posicion + 1] == '*' && tablaCreada[posicion] != '*') {

				tablaCreada[posicion] = '2';
			}
		}

		// print para comprobar funcion quitar al finalizar ejercicio
		System.out.println(Arrays.toString(tablaCreada));

		return tablaCreada;
	}

	static void ejecutaJuego(char tablaMain[]) {

		char tablaJugador[] = new char[longitud];

		int numero;

		Scanner dogma = new Scanner(System.in);

		// rellena array jugador con ?
		for (int posicion = 0; posicion < longitud; posicion++) {
			tablaJugador[posicion] = '?';
		}

		do {

			System.out.println("Indique una casilla a destapar entre 0 y " + (longitud - 1));

			numero = dogma.nextInt();

			tablaJugador[numero] = tablaMain[numero];

			if (numero==0 && tablaMain[numero + 1] == tablaMain[numero])  {
				tablaJugador[numero] = tablaMain[numero];

			} else if (numero == longitud-1 && tablaMain[numero - 1] == tablaMain[numero])  {
				tablaJugador[numero] = tablaMain[numero];

			}

			System.out.println(Arrays.toString(tablaJugador));

		} while (tablaMain[numero] !='*');
		
		System.out.println("Ha perdido.");
	}

}
