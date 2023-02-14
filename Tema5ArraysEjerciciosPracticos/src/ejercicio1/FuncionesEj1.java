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

		// recorro tableroCreado
		for (int posicion = 0; posicion < longitud; posicion++) {
			// dando valor 0 a todos sus elementos
			tableroCreado[posicion] = '0';
		}

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

	/**
	 * 
	 * funcion estatica que iniciara el juego y entrara en un bucle que mostrara al jugador
	 * su tablero y le solicitara una casilla a destapar que destapara usando
	 * funcion destapaMultiplesCasillas segun sea oportuno o no, el bucle estara en
	 * ejecucion mientras el jugador no seleccione una casilla con mina o gane la
	 * partida (para esta comprobacion usara la funcion jugadorGana)
	 * 
	 */
	static void ejecutaJuego() {

		// creo escaner y lo nombro dogma
		Scanner dogma = new Scanner(System.in);

		// mensaje por consola de inicio de partida
		System.out.println("¡Empieza el juego!");
		System.out.println();

		// muestro al jugador su tablero
		System.out.println(Arrays.toString(tableroJugador));

		// conjunto de instrucciones de bucle do while
		do {

			// solicito al jugador casilla a destapar
			System.out.println("Indique una casilla a destapar entre 0 y " + (longitud - 1));

			// doy a atributo numeroJugador valor introducido por jugador
			numeroJugador = dogma.nextInt();

			// destapa casilla de tableroJugador en posicion numeroJugador sea mina o no
			tableroJugador[numeroJugador] = tableroCreado[numeroJugador];

			// uso funcion destapaMultiplesCasillas tableroCreado en posicion de
			// numeroJugador no es mina
			if (tableroCreado[numeroJugador] != '*') {
				destapaMultiplesCasillas();
			}

			// uso funcion jugadorGana para comprobar el estado de la partida
			jugadorGana();

			// muestro a jugador su tablero actualizado con las casillas destapadas
			System.out.println(Arrays.toString(tableroJugador));

			// mientras posicion numeroJugador de tableroCreado sea distinto a mina
			// y victoria no sea igual a true el bucle se mantendra en ejecucion
		} while (tableroCreado[numeroJugador] != '*' && victoria != true);

		// cierro escaner
		dogma.close();
	}

}