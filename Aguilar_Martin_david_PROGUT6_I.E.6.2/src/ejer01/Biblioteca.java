package ejer01;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Socio> socios = new ArrayList<>();
	static ArrayList<Libro> libros = new ArrayList<>();

	public static void main(String[] args) {
		
		
	}

	public static void catalogo() {
	}

	public static void menu() {
		System.out.println("Escoja una opci�n del men�: ");
		int opcion = entrada.nextInt();
		switch (opcion) {
		case 1:
			a�adirlibro();
			break;
		case 2:
			a�adirsocio();
			break;
		default:
			break;
		}
	}

	public static void a�adirlibro() {
		System.out.println("Introduzca el t�tulo del libro");
		String titulo = entrada.next();
		System.out.println("Introduzca el autor del libro");
		String autor = entrada.next();
		Libro libro = new Libro(titulo, autor);
		libros.add(libro);
	}

	public static void a�adirsocio() {
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
						System.out.println("El libro no est� disponible en este momento");
					} else {
						li.setSocio(socios.stream().filter(so -> so.getnSocio() == nsocio));
					}
				} );
			}
			
		}
		
		
		
		
		
		
	}
	
}