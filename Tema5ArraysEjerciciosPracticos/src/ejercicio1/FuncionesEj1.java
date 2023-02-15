package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class FuncionesEj1 {

	static int longitud;// guardara la longitud que usare en todos los arrays (tableros) dada por
	// usuario en main

	static int minas;// guardara la cantidad de minas que usare en todos los arrays (tableros) dada
	// por usuario en main

	static int numeroJugador;// guardara el numero introducido por el jugador

	static boolean victoria;// guardara el estado de la partida inicializado por defecto a false

	static char tableroCreado[];// guardara el tablero creado por la funcion creaArray

	static char tableroJugador[];// guardara el tablero del jugador que creara la funcion ejecutaJuego

	/**
	 * 
	 * funcion estatica que creara el tablero para la partida, llenandolo de minas,
	 * 0, 1, o 2
	 * 
	 */
	static void creaTablero() {

		tableroCreado = new char[longitud];// doy a atributo tableroCreado longitud igual a atributo longitud

		int posInsercionAleatoria;// guardara un valor aleatorio a usar como posicion en tableroCreado

		int contador = 0; // guardara cantidad de minas insertadas en tableroCreado

		// lleno el tableroCreado con '0' haciendo uso de la funcion fill de la clase
		// Arrays
		Arrays.fill(tableroCreado, '0');

		// bucle que se ejecutara mientras queden minas a insertar
		while (contador < minas) {

			// inserto una mina en una posicion aleatoria entre 0 y longitud, debido a
			// funcionamiento de Math.random() posInsercionAleatoria tomara un valor maximo
			// de longitud-1
			posInsercionAleatoria = (int) (Math.random() * longitud);

			// si la posInsercionAleatoria no contiene un mina
			if (tableroCreado[posInsercionAleatoria] != '*') {
				// la insertara en dicha posicion
				tableroCreado[posInsercionAleatoria] = '*';
				// y añadira +1 al contador de minas
				contador++;

				// si la posicion donde inserto la mina no es la ultima casilla y la siguiente
				// casilla no contiene una mina
				if (posInsercionAleatoria != longitud - 1 && tableroCreado[posInsercionAleatoria + 1] != '*') {
					// inserto una mina en la siguiente casilla
					tableroCreado[posInsercionAleatoria + 1] = '1';
				}
				// si la posicion donde inserto la mina no es la primera casilla y la anterior
				// casilla no contiene una mina
				if (posInsercionAleatoria != 0 && tableroCreado[posInsercionAleatoria - 1] != '*') {
					// inserto una mina en la anterior casilla
					tableroCreado[posInsercionAleatoria - 1] = '1';
				}
			}
		}

		// recorro el array tableroCreado
		for (int posicion = 0; posicion < longitud; posicion++) {

			// si la posicion actual no es ni la primera ni la ultima casilla, no contiene
			// una mina y las casillas siguiente y anterior son minas
			if (posicion != 0 && posicion != longitud - 1 && tableroCreado[posicion - 1] == '*'
					&& tableroCreado[posicion + 1] == '*' && tableroCreado[posicion] != '*') {
				// inserto valor 2 en la casilla actual
				tableroCreado[posicion] = '2';
			}
		}
	}

	/**
	 * 
	 * funcion estatica que destapara las casillas adyacentes a la seleccionada por
	 * el jugador si estas no son minas o fin de tablero
	 * 
	 */
	static void destapaMultiplesCasillas() {

		// bucle que recorre tableroCreado hacia la izquierda desde la posicion anterior
		// a la indicada por el jugador mientras no se salga del tablero y no encuentre
		// una mina
		for (int incremento = 1; numeroJugador - incremento >= 0
				&& tableroCreado[numeroJugador - incremento] != '*'; incremento++) {
			// destapando la casilla en tableroJugador
			tableroJugador[numeroJugador - incremento] = tableroCreado[numeroJugador - incremento];
		}

		// bucle que recorre tableroCreado hacia la derecha desde la posicion siguiente
		// a la indicada por el jugador mientras no se salga del tablero y no encuentre
		// una mina
		for (int incremento = 1; numeroJugador + incremento <= longitud - 1
				&& tableroCreado[numeroJugador + incremento] != '*'; incremento++) {
			// destapando la casilla en tableroJugador
			tableroJugador[numeroJugador + incremento] = tableroCreado[numeroJugador + incremento];
		}
	}

	/**
	 * 
	 * funcion estatica que contara la cantidad de casillas destapadas con exito por
	 * el jugador modificando el valor de el atributo victoria si el jugador ha
	 * destapado las casillas necesarias
	 * 
	 */
	static void jugadorGana() {

		int contador = 0;// guardara la cantidad de casillas del array tableroJugador que contienen un
		// valor diferente a '?'

		// recorro el array tableroJugador
		for (int posicion = 0; posicion < longitud; posicion++) {

			// si su posicion contiene un elemento diferente a '?' y diferente a una mina
			if (tableroJugador[posicion] != '?' && tableroJugador[posicion] != '*') {
				// la cuento sumando +1 a contador
				contador++;
			}
			// si contador ha tomado un valor igual a longitud - minas significara que solo
			// quedan por destapar las casillas que contienen minas por lo que el jugador
			// habra ganado la partida
			if (contador == longitud - minas) {
				// en ese caso doy a atributo victoria valor igual a true
				victoria = true;
			}
		}
	}

	/**
	 * funcion estatica que creara el tablero del jugador
	 */
	static void creaTableroJugador() {

		tableroJugador = new char[longitud];// doy al atributo tableroJugador una longitud igual a atributo longitud

		// lleno el tablero de '?' haciendo uso de la funcion fill de la clase Arrays
		Arrays.fill(tableroJugador, '?');

	}

}