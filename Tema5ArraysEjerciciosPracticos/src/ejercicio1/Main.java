package ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		char tablero[] = new char[0];

		// cerrar el escaner solo cuando este todo hecho sino puede dar error
		// cerrarlo desde el main que deberia cerrar tambien el de la funcion
		Scanner dogma = new Scanner(System.in);

		System.out.println("¿Cuantas casillas desea en su tablero? ");

		FuncionesEj1.longitud = dogma.nextInt();

		System.out.println("¿Cuantas minas desea en su tablero? ");

		FuncionesEj1.minas = dogma.nextInt();

		tablero = FuncionesEj1.creaArray(tablero);

		FuncionesEj1.ejecutaJuego(tablero);

	}

}
