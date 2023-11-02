package desafio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class desafio4 {

	static String[] nombre = new String[3];
	static String[] apellido = new String[3];
	static int[] nro_camisa = new int[3];
	static String desicion_suplente;
	static boolean desicion = false;
	static boolean respuestaAgregarJugadorIncorrecta = false;
	static String[] nombre_supl = new String[4];
	static String[] apellido_supl = new String[4];
	static int[] nro_camisa_supl = new int[4];
	static boolean mod_camisa = false;
	static String modificacion;
	int camisa_modificada;

	public static void IngresaDatos() {
		Scanner entrada = new Scanner(System.in);

		for (int i = 0; i < nombre.length; i++) {

			System.out.println("Ingresa el nombre del jugador");
			nombre[i] = entrada.next();

			System.out.println("ingrese el apellido del jugador");
			apellido[i] = entrada.next();

			System.out.println("ingrese el numero de la camiseta");
			nro_camisa[i] = entrada.nextInt();
		}
	}

	public static void agregarJugador() {
		Scanner entrada = new Scanner(System.in);
		while (respuestaAgregarJugadorIncorrecta == false) {
			try {

				System.out.println("Desea ingresar otro jugador? Si / No");
				desicion_suplente = entrada.next().toLowerCase();

				if (!desicion_suplente.equals("si") && !desicion_suplente.equals("no")) {
					respuestaAgregarJugadorIncorrecta = true;
					throw new InputMismatchException();

				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debes ingresar un dato valido.");
				respuestaAgregarJugadorIncorrecta = false;
			}

			if (desicion_suplente.equals("si")) {

				for (int i = 0; i < nombre.length; i++) {
					nombre_supl[i] = nombre[i];
					apellido_supl[i] = apellido[i];
					nro_camisa_supl[i] = nro_camisa[i];
				}

				System.out.println("Ingrese nombre del jugador suplene");
				nombre_supl[3] = entrada.next();

				System.out.println("Ingrese apellido del jugador suplene");
				apellido_supl[3] = entrada.next();

				System.out.println("Ingrese el numero de la camisa ");
				nro_camisa_supl[3] = entrada.nextInt();
			}

			System.out.println();

			if (desicion_suplente.equals("no")) {
				respuestaAgregarJugadorIncorrecta = true;
				analizarDatosTresJugadores();

			}

		}

	}

	public static void analizarDatosTresJugadores() {
		Scanner entrada = new Scanner(System.in);

		while (mod_camisa == false) {

			for (int i = 0; i < nro_camisa.length; i++) {
				System.out.println("Nombre jugador : " + nombre[i]);
				System.out.println("apellido jugador : " + apellido[i]);
				System.out.println("numero de camisa de jugador : " + nro_camisa[i]);
			}

			System.out.println("¿Desea hacer algun cambio? si/ no");
			modificacion = entrada.next().toLowerCase();

			if (modificacion.equals("si")) {

				System.out.println("¿Qué numero de camisa desea modificar?");
				int camisa_modificada = entrada.nextInt();

				for (int i = 0; i < nro_camisa.length; i++) {

					if (nro_camisa[i] == camisa_modificada) {

						System.out.println("ingrese nombre");
						nombre[i] = entrada.next();

						System.out.println("ingrese apellido");
						apellido[i] = entrada.next();

						System.out.println("ingrese camisa");
						nro_camisa[i] = entrada.nextInt();

						for (int j = 0; j < nro_camisa.length; j++) {
							System.out.println(
									"Datos de los jugadores actualizados: " + nombre[j] + apellido[j] + nro_camisa[j]);
						}
					}

				}

			}
			if (modificacion.equals("no")) {
				mod_camisa = true;
			}
		}
	}

	public static void analizarDatosCuatroJugadores() {
		Scanner entrada = new Scanner(System.in);
		while (mod_camisa == false) {

			for (int i = 0; i < nro_camisa_supl.length; i++) {
				System.out.println("Nombre jugador : " + nombre_supl[i]);
				System.out.println("apellido jugador : " + apellido_supl[i]);
				System.out.println("numero de camisa de jugador : " + nro_camisa_supl[i]);
			}

			System.out.println("¿Desea hacer algun cambio? si/ no");
			modificacion = entrada.next().toLowerCase();

			if (modificacion.equals("si")) {

				System.out.println("¿Qué numero de camisa desea modificar?");
				int camisa_modificada = entrada.nextInt();

				for (int i = 0; i < nro_camisa_supl.length; i++) {

					if (nro_camisa_supl[i] == camisa_modificada) {

						System.out.println("ingrese nombre");
						nombre_supl[i] = entrada.next();

						System.out.println("ingrese apellido");
						apellido_supl[i] = entrada.next();

						System.out.println("ingrese camisa");
						nro_camisa_supl[i] = entrada.nextInt();

						for (int j = 0; j < nro_camisa_supl.length; j++) {
							System.out.println(
									"Datos de los jugadores actualizados: " + nombre_supl[j] + apellido_supl[j] + nro_camisa_supl[j]);
						}
					}

				}

			}
			if (modificacion.equals("no")) {
				mod_camisa = true;
			}
		}
	}

	public static void main(String[] args) {

		IngresaDatos();
		agregarJugador();
		
	}
}