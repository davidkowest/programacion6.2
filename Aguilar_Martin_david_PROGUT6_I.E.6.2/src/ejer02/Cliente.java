package ejer02;

import java.util.ArrayList;

public class Cliente {
	
	// Atributos
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private String dni;
	private ArrayList<Cuenta> cuentascliente = new ArrayList<Cuenta>();
	
	
	// Constructores
	
	/**
	 * Constructor que inicializa con todos los datos de cliente
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param telefono
	 * @param dni
	 */
	public Cliente (String nombre, String apellidos, String direccion, int telefono, String dni) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.telefono=telefono;
		this.dni=dni;
	}

	//Metodos
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
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * 
	 * @return
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * 
	 * @return
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Cuenta> getCuentascliente() {
		return cuentascliente;
	}
	/**
	 * 
	 * @param cuenta
	 */
	public void setCuentascliente(Cuenta cuenta) {
		cuentascliente.add(cuenta);
	}
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + "]";
	}
	
}
