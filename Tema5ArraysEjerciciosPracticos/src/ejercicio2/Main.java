package ejercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//creo escaner y lo llamo dogma
		Scanner dogma = new Scanner(System.in);

		//mensaje de inicio de juego
		System.out.println("¡Comienza el juego!");
		System.out.println();

		//mensaje de turno jugador 1
		System.out.println("Es el turno del jugador 1. ");

		//doy a atributo puntuacionJugador1 valor igual al valor devuelto por funcion sacaSuma
		FuncionesEj2.puntuacionJugador1 = FuncionesEj2.sacaSuma();

		//compruebo si valor de puntuacionJugador1 es igual o menor a 7,5 con funcion menor8
		if (FuncionesEj2.menor8(FuncionesEj2.puntuacionJugador1) == false) {
			//de no serlo le comunico al jugador que se ha pasado de 7,5
			System.out.println("¡Te has pasado! ");
			System.out.println();
		}

		//mensaje de turno jugador 2
		System.out.println("Es el turno del jugador 2. ");
		System.out.println();

		//doy a atributo puntuacionJugador1 valor igual al valor devuelto por funcion sacaSuma
		FuncionesEj2.puntuacionJugador2 = FuncionesEj2.sacaSuma();

		//compruebo si valor de puntuacionJugador2 es igual o menor a 7,5 con funcion menor8
		if (FuncionesEj2.menor8(FuncionesEj2.puntuacionJugador2) == false) {
			//de no serlo le comunico al jugador que se ha pasado de 7,5
			System.out.println("¡Te has pasado! ");
			System.out.println();
		}

		//evaluo valor devuelto por funcion decideGanador
		switch (FuncionesEj2.decideGanador()) {

		//si valor igual a 2
		case 2 -> {
			//mensaje de ganador jugador 2
			System.out.println("El ganador es el jugador 2.");
		}
		//si valor igual a 1
		case 1 -> {
			//mensaje de ganador jugador 1
			System.out.println("El ganador es el jugador 1.");
		}
		//si valor igual a 0
		case 0 -> {
			//mensaje de empate
			System.out.println("El resultado es empate.");
		}
		}

		//cierro escaner
		dogma.close();
	}

}
