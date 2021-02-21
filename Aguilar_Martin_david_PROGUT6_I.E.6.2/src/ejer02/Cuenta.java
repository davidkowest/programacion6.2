package ejer02;
/**
 * @author Davidkowest
 * 
 */
import java.util.Scanner;

public class Cuenta {
	static Scanner entrada = new Scanner(System.in);
	//Atributos
	private int ncuenta;
	private double saldo;
	private double intcuenta;
	private double comision;
	private Cliente cliente;
	
	//Constructores
	
	/**
	 * inicializa con el saldo y la comision
	 * @param saldo
	 * @param comision
	 */
	public Cuenta (double saldo, double comision) {
		this.saldo=saldo;
		this.comision=comision;
		intcuenta=0.1;
		ncuenta = 1000;
	}
	/**
	 * inicializa solamente con el saldo
	 * @param saldo
	 */
	public Cuenta (double saldo) {
		this.saldo=saldo;
		comision=0.6;
		intcuenta=0.1;
		ncuenta=1000;
		
	}

	//Metodos
	/**
	 * 
	 * @return
	 */
	public int getNcuenta() {
		return ncuenta;
	}
	/**
	 * 
	 * @param ncuenta
	 */
	public void setNcuenta(int ncuenta) {
		this.ncuenta = ncuenta;
	}
	/**
	 * 
	 * @return
	 */
	public double getIntcuenta() {
		return intcuenta;
	}

	/**
	 * 
	 * @param intcuenta
	 */
	public void setIntcuenta(double intcuenta) {
		this.intcuenta = intcuenta;
	}
	/**
	 * 
	 * @return
	 */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * 
	 * @param saldo
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	/**
	 * 
	 * @return
	 */
	public double getComision() {
		return comision;
	}
	/**
	 * 
	 * @param comision
	 */
	public void setComision(double comision) {
		this.comision = comision;
	}
	/**
	 * 
	 * @return
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * 
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Cuenta [ncuenta=" + ncuenta + ", saldo=" + saldo + ", intcuenta=" + intcuenta + ", comision=" + comision
				+ "]";
	}

	
}
