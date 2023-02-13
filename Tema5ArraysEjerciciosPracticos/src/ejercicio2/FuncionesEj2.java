package ejercicio2;

import java.util.Scanner;

public class FuncionesEj2 {

	// funcion ejecutajuego

	// funcion decide ganador

	// funcion tirada (sacacarta)

	static double baraja[] = { 1, 1, 1, 1, 1, 1, 1, 0.5, 0.5, 0.5 };

	static double puntuacionJugador1 = 0;

	static double puntuacionJugador2 = 0;

	static double sacaCarta() {

		int carta = 0;

		double puntuacion = 0;

		int decisionJugador = 0;

		Scanner dogma = new Scanner(System.in);

		do {

			System.out.println("¿Desea sacar una carta? De ser asi pulse 1, en caso contrario pulse 0 para plantarse.");

			decisionJugador = dogma.nextInt();

			if (decisionJugador == 1) {
				carta = (int) (Math.random() * 11);

				puntuacion += baraja[carta];
			}

		} while (puntuacion <= 7.5 && decisionJugador != 0);

		return puntuacion;
	}

	static int decideGanador() {

		int ganador = 0;

		if (puntuacionJugador1 < puntuacionJugador2) {
			ganador = 2;

		} else if (puntuacionJugador1 > puntuacionJugador2) {
			ganador = 1;

		} else {
			ganador = 0;
		}

		return ganador;
	}

	static void ejecutaJuego() {

		System.out.println("¡Comienza el juego!");

		System.out.println();

		System.out.println("Es el turno del jugador 1. ");

		puntuacionJugador1 = sacaCarta();

		System.out.println();

		System.out.println("Es el turno del jugador 2. ");

		puntuacionJugador2 = sacaCarta();

		switch (decideGanador()) {

		case 2 -> {
			System.out.println("El ganador es el jugador 2.");
		}
		case 1 -> {
			System.out.println("El ganador es el jugador 1.");
		}
		case 0 -> {
			System.out.println("El resultado es empate.");
		}
		}

	}

}
