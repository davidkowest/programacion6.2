package ejer01;

import java.util.ArrayList;
import java.util.List;

public class Socio {
	//Atributos
		private String nombre;
		private int nSocio;
		private ArrayList<Libro> prestamo = new ArrayList<>();
		
		//Constructores
		
		public Socio(String nombre, int nSocio) {
			this.nombre=nombre;
			this.nSocio=nSocio;
		}

		//metodos
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getnSocio() {
			return nSocio;
		}

		public void setnSocio(int nSocio) {
			this.nSocio = nSocio;
		}

		public ArrayList<Libro> getPrestamo() {
			return prestamo;
		}

		public void setPrestamo(Libro libro) {
			prestamo.add(libro);
		}

		@Override
		public String toString() {
			return "Socio [nombre=" + nombre + ", nSocio=" + nSocio + "]";
		}

}
