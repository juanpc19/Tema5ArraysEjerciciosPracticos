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

		// llamo a funcion estatica creaArray dentro de FuncionesEj1
		FuncionesEj1.creaTablero();

		// print para comprobar funcionamiento
		// System.out.println("Arrays tablero creado: " +
		// Arrays.toString(FuncionesEj1.tableroCreado));

		// llamo a funcion estatica creaArray dentro de FuncionesEj1
		FuncionesEj1.creaTableroJugador();

		// llamo a funcion estatica ejecutaJuego dentro de FuncionesEj1
		FuncionesEj1.ejecutaJuego();

		// cierro escaner
		dogma.close();

		// al finalizar la funcione jecutaJuego compruebo el estado de
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
