package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		char tablero[] = new char[0];

		Scanner dogma = new Scanner(System.in);

		System.out.println("¿Cuantas casillas desea en su tablero? ");

		FuncionesEj1.longitud = dogma.nextInt();

		System.out.println("¿Cuantas minas desea en su tablero? ");

		FuncionesEj1.minas = dogma.nextInt();

		dogma.close();

		tablero=FuncionesEj1.creaArray(tablero);

		FuncionesEj1.ejecutaJuego(tablero);

	}

}
