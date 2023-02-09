package ejercicio1;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner dogma = new Scanner(System.in);

		System.out.println("¿Cuantas casillas desea en su tablero? ");

		FuncionesEj1.longitud = dogma.nextInt();

		System.out.println("¿Cuantas minas desea en su tablero? ");

		FuncionesEj1.minas = dogma.nextInt();

		FuncionesEj1.creaArray();

		dogma.close();

	}

}
