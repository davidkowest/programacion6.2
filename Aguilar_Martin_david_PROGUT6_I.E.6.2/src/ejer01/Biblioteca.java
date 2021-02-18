package ejer01;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Socio> socios = new ArrayList<>();
	static ArrayList<Libro> libros = new ArrayList<>();

	public static void main(String[] args) {
		
		menu();
		
		
	}

	public static void catalogo() {
		Libro libro1 = new Libro("Hola", "Adios");
		libros.add(libro1);
		
		Libro libro2 = new Libro("harry potter", "jk rowling");
		libros.add(libro1);
		
		Socio socio1 = new Socio("David Aguilar", 1);
		socios.add(socio1);
	}

	public static void menu() {
		
	int opcion;
		
		do {
			
		
		System.out.println("Escoja una opción del menú: ");
		opcion = entrada.nextInt();
		switch (opcion) {
		case 1:
			añadirlibro();
			break;
		case 2:
			añadirsocio();
			break;
		case 3: consultarLibro();
			break;
		case 4: atenderPeticion();
			break;
		}
		} while (opcion>1 || opcion<5);
	}

	public static void añadirlibro() {
		System.out.println("Introduzca el título del libro");
		String titulo = entrada.next();
		System.out.println("Introduzca el autor del libro");
		String autor = entrada.next();
		Libro libro = new Libro(titulo, autor);
		libros.add(libro);
	}

	public static void añadirsocio() {
		System.out.println("Introduzca el nombre del Socio");
		String nombre = entrada.next();
		System.out.println("Introduzca el numero de socio");
		int nsocio = entrada.nextInt();
		Socio socio = new Socio(nombre, nsocio);
		socios.add(socio);

	}

	public static void consultarLibro() {
		if (libros.size() == 0) {
			System.out.println("No hay libros  en la biblioteca");
		} else {
			libros
			.stream()
			.forEach(li -> System.out.println(li));
		}

	}
	
	public static void atenderPeticion () {
		System.out.println("Introduce el numero de socio");
		int nsocio = entrada.nextInt();
		boolean existe = socios.contains(nsocio);
		
		if (!existe) {
			System.out.println("No existe un socio con ese numero");
		} else {
			System.out.println("Introduce el titulo del libro");
			String titulo = entrada.next();
			existe = libros.contains(titulo);
			if (!existe) {
				System.out.println("No tenemos ese libro");
			} else {
				libros
				.stream()
				.filter(li -> li.getTitulo().equalsIgnoreCase(titulo))
				.forEach(li -> {
					if (li.getSocio()!=null) {
						System.out.println("El libro no está disponible en este momento");
					} else {
						socios
						.stream()
						.filter(so -> so.getnSocio() == nsocio)
						.forEach(so -> li.setSocio(so));
						
						
						
						System.out.println("El socio "+nsocio+" se ha llevado el libro "+titulo);
					}
				} );
			}
			
		}
		
	}
	
	public static void devolverLibro () {
		
	}
	
}