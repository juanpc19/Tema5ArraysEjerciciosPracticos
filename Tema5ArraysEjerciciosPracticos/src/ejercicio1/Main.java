package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// creo escaner y lo llamo dogma
		Scanner dogma = new Scanner(System.in);

		// solicito a jugador valor para atributo longitud
		System.out.println("¿Cuantas casillas desea en su tablero? ");

		// asigno a atributo longitud valor mediante escaner
		FuncionesEj1.longitud = dogma.nextInt();

		// solicito a jugador valor para atributo minas
		System.out.println("¿Cuantas minas desea en su tablero? ");

		// asigno a atributo minas valor mediante escaner
		FuncionesEj1.minas = dogma.nextInt();

		// llamo a funcion estatica creaTablero dentro de FuncionesEj1
		FuncionesEj1.creaTablero();

		// llamo a funcion estatica creaArray dentro de FuncionesEj1
		FuncionesEj1.creaTableroJugador();

		// mensaje por consola de inicio de partida
		System.out.println("¡Empieza el juego!");
		System.out.println();

		// muestro al jugador su tablero
		System.out.println(Arrays.toString(FuncionesEj1.tableroJugador));

		// conjunto de instrucciones de bucle do while
		do {

			// solicito al jugador casilla a destapar
			System.out.println("Indique una casilla a destapar entre 0 y " + (FuncionesEj1.longitud - 1));

			// doy a atributo numeroJugador valor introducido por jugador
			FuncionesEj1.numeroJugador = dogma.nextInt();

			// destapa casilla de tableroJugador en posicion numeroJugador sea mina o no
			FuncionesEj1.tableroJugador[FuncionesEj1.numeroJugador] = FuncionesEj1.tableroCreado[FuncionesEj1.numeroJugador];

			// uso funcion destapaMultiplesCasillas tableroCreado en posicion de
			// numeroJugador no es mina
			if (FuncionesEj1.tableroCreado[FuncionesEj1.numeroJugador] != '*') {
				FuncionesEj1.destapaMultiplesCasillas();
			}

			// uso funcion jugadorGana para comprobar el estado de la partida
			FuncionesEj1.jugadorGana();

			// muestro a jugador su tablero actualizado con las casillas destapadas
			System.out.println(Arrays.toString(FuncionesEj1.tableroJugador));

			// mientras posicion numeroJugador de tableroCreado sea distinto a mina
			// y victoria no sea igual a true el bucle se mantendra en ejecucion
		} while (FuncionesEj1.tableroCreado[FuncionesEj1.numeroJugador] != '*' && FuncionesEj1.victoria != true);

		// cierro escaner
		dogma.close();

		// al finalizar el bucle compruebo el estado de
		// victoria, de ser este true significa que el jugador ha ganado
		if (FuncionesEj1.victoria == true) {
			// se lo comunico al jugador con mensaje
			System.out.println("¡Enhorabuena, ha ganado!");

			// de lo contrario significa que la salida de la funcion se debe a que la
			// casilla seleccionada era un mina por lo que el jugador ha perdido
		} else {
			// se lo comunico al jugador con mensaje
			System.out.println("Lo siento, ha perdido.");
		}

	}
}
