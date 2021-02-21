package ejer01;

import java.util.ArrayList;
import java.util.List;

public class Socio {
	//Atributos
		private String nombre;
		private int nSocio;
		private ArrayList<Libro> prestamo = new ArrayList<>();
		
		//Constructores
		/**
		 * constructor que inicializa el socio con el nombre y el numero de socio
		 * @param nombre
		 * @param nSocio
		 */
		public Socio(String nombre, int nSocio) {
			this.nombre=nombre;
			this.nSocio=nSocio;
		}

		//metodos
		/**
		 * 
		 * @return
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * 
		 * @param nombre
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		/**
		 * 
		 * @return
		 */
		public int getnSocio() {
			return nSocio;
		}
		/**
		 * 
		 * @param nSocio
		 */
		public void setnSocio(int nSocio) {
			this.nSocio = nSocio;
		}
		/**
		 * 
		 * @return
		 */
		public ArrayList<Libro> getPrestamo() {
			return prestamo;
		}
		/**
		 * 
		 * @param libro
		 */
		public void setPrestamo(Libro libro) {
			prestamo.add(libro);
		}
		/**
		 * @return
		 */
		@Override
		public String toString() {
			return "Socio [nombre=" + nombre + ", nSocio=" + nSocio + "]";
		}

}
