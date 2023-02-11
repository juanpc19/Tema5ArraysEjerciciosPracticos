package ejercicio1;

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
		FuncionesEj1.creaArray();

		// llamo a funcion estatica ejecutaJuego dentro de FuncionesEj1
		FuncionesEj1.ejecutaJuego();

		// cierro escaner
		dogma.close();

	}
}
