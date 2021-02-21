package ejer01;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Socio> socios = new ArrayList<>();
	static ArrayList<Libro> libros = new ArrayList<>();

	public static void main(String[] args) {

		catalogo();
		menu();

	}

	/**
	 * Metodo para iniciar la biblioteca con dos libros y dos usuarios
	 */
	public static void catalogo() {
		Libro libro1 = new Libro("Hola", "Adios");
		libros.add(libro1);

		Libro libro2 = new Libro("harry_potter", "jk rowling");
		libros.add(libro2);

		Socio socio1 = new Socio("David Aguilar", 0);
		socios.add(socio1);
		Socio socio2 = new Socio("Pedro Jimenez", 1);
		socios.add(socio2);
	}

	/**
	 * Metodo para arrancar el menu de la biblioteca
	 */
	public static void menu() {

		int opcion = 0;

		do {
			boolean continua;
			do {
				try {
					continua = false;
					System.out.println("Escoja una opción del menú: \n");
					System.out.println("1.- Añadir libro");
					System.out.println("2.- Añadir Socio");
					System.out.println("3.- Ver catalogo de la biblioteca");
					System.out.println("4.- Ver listado de socios");
					System.out.println("5.- Atender peticion");
					System.out.println("6.- Borrar socio");
					System.out.println("7.- Salir");
					opcion = entrada.nextInt();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);
			switch (opcion) {
			case 1:
				añadirlibro();
				break;
			case 2:
				añadirsocio();
				break;
			case 3:
				consultarLibro();
				break;
			case 4:
				consultarSocio();
				break;
			case 5:
				atenderPeticion();
				break;
			case 6:
				borrarSocio();
				break;
			}
		} while (opcion != 7);
	}

	/**
	 * Metodo para añadir libro a la biblioteca
	 */
	public static void añadirlibro() {
		System.out.println("Introduzca el título del libro");
		String titulo = entrada.next();
		System.out.println("Introduzca el autor del libro");
		String autor = entrada.next();
		Libro libro = new Libro(titulo, autor);
		libros.add(libro);
	}

	/**
	 * Metodo para añadir socios a la biblioteca
	 */
	public static void añadirsocio() {
		System.out.println("Introduzca el nombre del Socio");
		String nombre = entrada.next();
		boolean continua;
		int nsocio = 0;
		do {
			try {
				continua = false;
				System.out.println("Introduzca el numero de socio");
				nsocio = entrada.nextInt();
			} catch (Exception e) {
				continua = true;
				System.err.println("Formato no valido");
				entrada.next();
			}

		} while (continua);

		if (buscaSocio(nsocio)) {
			System.out.println("Ya existe un usuario con ese numero de socio");
		} else {
			Socio socio = new Socio(nombre, nsocio);
			socios.add(socio);
		}

	}

	/**
	 * Metodo para consultar los libros de la biblioteca
	 */
	public static void consultarLibro() {
		if (libros.size() == 0) {
			System.out.println("No hay libros  en la biblioteca");
		} else {
			libros.stream().forEach(li -> System.out.println(li));
		}

	}
	/**
	 * Metodo para consultar los socios de la biblioteca
	 */
	public static void consultarSocio() {
		if (socios.size() == 0) {
			System.out.println("No hay socios  en la biblioteca");
		} else {
			socios.stream().forEach(so -> System.out.println(so));
		}

	}
	/**
	 * Metodo para consultar los prestamos de la biblioteca
	 */
	public static void consultarPrestamo() {

		boolean continua;
		int nsocio = 0;
		do {
			try {
				continua = false;
				System.out.println("Introduzca el numero de socio");
				nsocio = entrada.nextInt();
			} catch (Exception e) {
				continua = true;
				System.err.println("Formato no valido");
				entrada.next();
			}

		} while (continua);

		int numsocio = nsocio;
		if (buscaSocio(nsocio)) {
			socios.stream().filter(so -> so.getnSocio() == numsocio);
		} else {
			System.out.println("No existe un socio con ese numero");
		}
	}
	/**
	 * Metodo para que los usuarios pidan libros de la biblioteca
	 */
	public static void atenderPeticion() {
		int nsocio = 0;
		boolean continua;
		do {
			try {
				continua = false;
				System.out.println("Introduce el numero de socio");
				nsocio = entrada.nextInt();
			} catch (Exception e) {
				continua = true;
				System.err.println("Formato no valido");
				entrada.next();
			}

		} while (continua);
		int numsocio = nsocio;
		if (buscaSocio(nsocio)) {
			System.out.println("Introduce el titulo del libro");
			String titulo = entrada.next();
			if (buscaLibro(titulo)) {
				libros.stream().filter(li -> li.getTitulo().equalsIgnoreCase(titulo)).forEach(li -> {
					if (li.getSocio() != null) {
						System.out.println("El libro no está disponible en este momento");
					} else {
						socios.stream().filter(so -> so.getnSocio() == numsocio).forEach(so -> li.setSocio(so));

						socios.stream().filter(so -> so.getnSocio() == numsocio).forEach(so -> so.setPrestamo(li));

						System.out.println("El socio " + numsocio + " se ha llevado el libro " + titulo);
					}
				});
			} else {
				System.out.println("No existe un titulo con ese nombre");
			}
		} else {
			System.out.println("No existe ese socio");
		}
		for (int i = 0; i < socios.get(0).getPrestamo().size(); i++) {
			System.out.println(socios.get(0).getPrestamo().get(i).getTitulo());
		}

	}
	/**
	 * Metodo para buscar socios, devuelve booleano
	 * @param nsocio
	 * @return
	 */
	public static boolean buscaSocio(int nsocio) {
		boolean existe = false;
		for (Socio socio : socios) {
			if (socio.getnSocio() == nsocio) {
				existe = true;
				break;
			}

		}
		return existe;
	}
	/**
	 * Metodo para buscar libro, devuelve booleano
	 * @param titulo
	 * @return
	 */
	public static boolean buscaLibro(String titulo) {
		boolean existe = false;
		for (Libro libro : libros) {
			if (libro.getTitulo().contains(titulo)) {
				existe = true;
				break;
			}
		}
		return existe;
	}
	/**
	 * Metodo para borrar socios de la biblioteca
	 */
	public static void borrarSocio() {
		boolean continua;
		int nsocio = 0;
		do {
			try {
				continua = false;
				System.out.println("Introduce el numero de socio");
				nsocio = entrada.nextInt();
			} catch (Exception e) {
				continua = true;
				System.err.println("Formato no valido");
				entrada.next();
			}

		} while (continua);
		boolean existe = false;
		int indice = 0;

		for (Socio socio : socios) {

			if (socio.getnSocio() == nsocio) {
				existe = true;

				if (socio.getPrestamo().size() > 0) {
					for (int i = 0; i < socio.getPrestamo().size(); i++) {
						System.out.println("El socio tenia prestados los siguientes libros: \n");
						for (int j = 0; i < socios.get(0).getPrestamo().size(); i++) {
							System.out.println(socios.get(0).getPrestamo().get(i).getTitulo());
						}

						indice = socios.indexOf(socio);
						socios.remove(indice);
						break;
					}
				} else {
					indice = socios.indexOf(socio);
					socios.remove(indice);
					break;
				}

			}

		}
		if (!existe) {
			System.out.println("Este socio no existe");
		}
	}
}