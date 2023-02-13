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

		String decisionJugador = "";

		Scanner dogma = new Scanner(System.in);

		do {

			System.out.println();
			System.out.println("¿Desea sacar una carta? Indique con 'si' o 'no' ");

			decisionJugador = dogma.next();

			if (decisionJugador.equals("si")) {

				carta = (int) (Math.random() * 10);
				puntuacion += baraja[carta];

				System.out.println();
				System.out.println("El valor de la carta sacada es: " + baraja[carta]);
				System.out.println();
				System.out.println("Su puntuacion actual es: " + puntuacion);
			}

		} while (puntuacion <= 7.5 && decisionJugador.equals("si"));

		return puntuacion;
	}

	static void menor8(double valorPuntuacion) {

		if (valorPuntuacion >= 8.0) {
			System.out.println("¡Te has pasado! ");
		}
	}

	static int decideGanador() {

		int ganador = 0;

		if (puntuacionJugador1 < puntuacionJugador2 && puntuacionJugador2 <= 7.5) {
			ganador = 2;

		} else if (puntuacionJugador1 > puntuacionJugador2 || puntuacionJugador2 >= 8.0) {
			ganador = 1;

		} else {
			ganador = 0;
		}

		return ganador;
	}

	// sacar tanto como sea posible de aqui yponer en main llamando a funciones con
	// clase nombre funcion
	static void ejecutaJuego() {

		System.out.println("¡Comienza el juego!");

		System.out.println();

		System.out.println("Es el turno del jugador 1. ");

		puntuacionJugador1 = sacaCarta();

		menor8(puntuacionJugador1);

		System.out.println();

		if (puntuacionJugador1 >= 8) {
			System.out.println("El ganador es el jugador 2.");

		} else {

			System.out.println("Es el turno del jugador 2. ");

			puntuacionJugador2 = sacaCarta();

			System.out.println();

			menor8(puntuacionJugador2);

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
}
