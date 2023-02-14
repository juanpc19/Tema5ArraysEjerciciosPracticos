package ejercicio2;

import java.util.Scanner;

public class FuncionesEj2 {

	static double baraja[] = { 1, 1, 1, 1, 1, 1, 1, 0.5, 0.5, 0.5 };// atributo que guardara los valores de las cartas

	static double puntuacionJugador1 = 0;// atributo que guardara el valor de la puntuacion del jugador 1

	static double puntuacionJugador2 = 0;// atributo que guardara el valor de la puntuacion del jugador 2

	/**
	 * funcion que sacara cartas mientras el jugador lo indique y sumara el valor de
	 * cada carta a puntuacion
	 * 
	 * @return puntuacion devuelve el valor de la suma total de todas las cartas
	 *         sacadas por un jugador
	 * 
	 */
	static double sacaSuma() {

		int carta = 0;// guardara un valor aleatorio equivalente a una carta cuyo valor posee el
		// atributo baraja

		double puntuacion = 0;// guardara la suma total de los valores de todas las cartas de un jugador

		String decisionJugador = "";// guardara 'si' o 'no' segun el jugador indique

		// creo escaner y lo nombro dogma
		Scanner dogma = new Scanner(System.in);

		// bloque de instrucciones de do while
		do {
			// pregunto al jugador si desea sacar una carta
			System.out.println();
			System.out.println("¿Desea sacar una carta? Indique con 'si' o 'no' ");

			// guardo su respuesta en decisionJugador con escaner
			decisionJugador = dogma.next();

			// si decisionJugador es igual a si
			if (decisionJugador.equals("si")) {

				// doy a carta un valor aleatorio entre 0 y 9
				carta = (int) (Math.random() * 10);
				// sumo valor de posicion carta en array baraja a puntuacion
				puntuacion += baraja[carta];

				// muestro valor de la carta sacada al jugador
				System.out.println();
				System.out.println("El valor de la carta sacada es: " + baraja[carta]);
				// muestro a jugador su puntuacion total actual
				System.out.println();
				System.out.println("Su puntuacion actual es: " + puntuacion);
			}

			// el bucle se seguira ejecutando mientras menor8 devuelva true y el jugador
			// siga pidiendo cartas
		} while (menor8(puntuacion) == true && decisionJugador.equals("si"));

		return puntuacion;
	}

	/**
	 * funcion que evaluara si la puntuacion que se le pasa es menor a 8
	 * 
	 * @param valorPuntuacion parametro de entrada que recibira la puntuacion de un
	 *                        jugador
	 * 
	 * @return resultado devolvera true o false segun la puntuacion introducida sea
	 *         menor a 8 o no
	 */
	static boolean menor8(double valorPuntuacion) {

		boolean resultado = true;// variable que guardara true o false, la inicializo a true
		// si valorPuntuacion < 8
		if (valorPuntuacion >= 8.0) {
			// resultado tomara valor true
			resultado = false;
		}

		return resultado;
	}

	/**
	 * funcion que decidira quien gana el juego
	 * 
	 * @return devolvera 0 si empatan 1 si jugador gana y 2 si jugador 2 gana
	 */
	static int decideGanador() {

		int ganador = 0;// guardara 0, 1, 2 segun quien gane el juego

		// si ambos jugadores tienen la misma puntuacion o ambos se pasan de 7.5
		if (puntuacionJugador1 == puntuacionJugador2
				|| menor8(puntuacionJugador1) == false && menor8(puntuacionJugador2) == false) {
			// el resultado es empate
			ganador = 0;

			// si lo anterior no se cumple y el jugador 1 no se pasa de 7.5 y el jugador 2
			// si se pasa de 7.5
		} else if (menor8(puntuacionJugador1) == true && menor8(puntuacionJugador2) == false) {
			// el ganador es el jugador 1
			ganador = 1;

			// si lo anterior no se cumple y el jugador 2 no se pasa de 7.5 y el jugador 1
			// si se pasa de 7.5
		} else if (menor8(puntuacionJugador2) == true && menor8(puntuacionJugador1) == false) {
			// el ganador es el jugador 2
			ganador = 2;

			// si lo anterior no se cumple y la puntuacion del jugador 1 es mayor que la del
			// jugador 2
		} else if (puntuacionJugador1 > puntuacionJugador2) {
			// el ganador es el jugador 1
			ganador = 1;

			// si lo anterior no se cumple y la puntuacion del jugador 2 es mayor que la del
			// jugador 1
		} else if (puntuacionJugador2 < puntuacionJugador1) {
			// el ganador es el jugador 2
			ganador = 2;
		}

		return ganador;
	}

}
