package ejer01;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	//Atributos
	private String titulo;
	private String autor;
	private Socio socio;
	
	//Constructores
	
	/**
	 * Constructor que inicializa el libro con el titulo y autor
	 * @param titulo
	 * @param autor
	 */
	public Libro(String titulo, String autor) {
		this.titulo=titulo;
		this.autor=autor;
	}

	//Metodos
	/**
	 * 
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * 
	 * @return
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * 
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * 
	 * @return
	 */
	public Socio getSocio() {
		return socio;
	}
	/**
	 * 
	 * @param socio
	 */
	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + "]";
	}
	
	
	
	
	
}
