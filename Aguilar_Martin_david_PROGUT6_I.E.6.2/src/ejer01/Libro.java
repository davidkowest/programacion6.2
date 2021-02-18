package ejer01;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	//Atributos
	private String titulo;
	private String autor;
	private Socio socio;
	
	//Constructores
	

	public Libro(String titulo, String autor) {
		this.titulo=titulo;
		this.autor=autor;
	}

	//Metodos
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + "]";
	}
	
	
	
	
	
}
