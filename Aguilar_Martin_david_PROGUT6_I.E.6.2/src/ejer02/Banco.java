package ejer02;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;



public class Banco {
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Cuenta> cuentas = new ArrayList<>();
	static ArrayList<Cliente> clientes = new ArrayList<>();

	public static void main(String[] args) {
		catalogo();
		menu();
	}
	/**
	 * Metodo para generar dos clientes de pruebas para el banco
	 */
	public static void catalogo() {
		Cliente cliente1 = new Cliente("David", "Aguilar Martin", "calle falsa 123", 654654564, "25897845q");
		clientes.add(cliente1);

		Cliente cliente2 = new Cliente("Pedro", "Perez", "calle verdadera 456", 954648575, "254612378s");
		clientes.add(cliente2);
	}
	/**
	 * Metodo para arrancar un menu de banco
	 */
	public static void menu() {

		int opcion = 0;

		do {
			boolean continua;
			do {

				try {
					continua = false;
					System.out.println("Escoja una opción del menú: \n");
					System.out.println("1.- Nuevo cliente");
					System.out.println("2.- Nueva cuenta");
					System.out.println("3.- Listar clientes y cuentas");
					System.out.println("4.- Ingresar dinero");
					System.out.println("5.- Sacar dinero");
					System.out.println("6.- Consultar saldo");
					System.out.println("7.- Revision mensual");
					System.out.println("8.- Cambiar comision mensual");
					System.out.println("9.- Salir");
					opcion = entrada.nextInt();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);
			switch (opcion) {
			case 1:
				nuevoCliente();
				break;
			case 2:
				nuevaCuenta();
				break;
			case 3:
				listarCliente();
				break;
			case 4:
				ingresarDinero();
				break;
			case 5:
				sacarDinero();
				break;
			case 6:
				consultarSaldo();
				break;
			case 7:
				revisionMensual();
				break;
			case 8:
				cambiarComision();
				break;
			}
		} while (opcion != 9);
	}
	/**
	 * metodo para arrancar una nueva cuenta
	 */
	public static void nuevaCuenta() {
		if (cuentas.size() >= 1000) {
			System.out.println("Ha llegado al limite de cuentas del servidor");
		} else {
			System.out.println("Introduzca el DNI del cliente");
			String dni = entrada.next();

			if (buscaCliente(dni)) {
				double saldo = 0;
				boolean continua;
				do {
					try {
						continua = false;
						System.out.println("Introduce el saldo con el que quieres iniciar la cuenta");
						saldo = entrada.nextDouble();
					} catch (Exception e) {
						continua = true;
						System.err.println("Formato no valido");
						entrada.next();
					}

				} while (continua);

				Cuenta cuenta = new Cuenta(saldo);
				cuentas.add(cuenta);
				int cont = 0;
				for (Cuenta contador : cuentas) {
					cont++;
				}
				cuenta.setNcuenta(cuenta.getNcuenta() + cont);
				for (Cliente cliente : clientes) {
					if (cliente.getDni() == dni) {
						cuenta.setCliente(cliente);
						cliente.setCuentascliente(cuenta);
						break;
					}
				}

			} else {
				System.out.println("No existe ningun cliente con ese DNI");
			}
		}

	}
	/**
	 * metodo para buscar cliente, si existe devuelve booleano
	 * @param dni
	 * @return
	 */
	public static boolean buscaCliente(String dni) {
		boolean existe = false;
		for (Cliente cliente : clientes) {
			if (cliente.getDni().equalsIgnoreCase(dni)) {
				existe = true;
				break;
			}

		}
		return existe;
	}
	/**
	 * Metodo para crear un nuevo cliente, con limite de 1000 clientes
	 */
	public static void nuevoCliente() {
		if (clientes.size() >= 1000) {
			System.out.println("Ha llegado al limite de clientes del servidor");
		} else {
			System.out.println("Introduzca el DNI del cliente");
			String dni = entrada.next();

			if (!buscaCliente(dni)) {

				System.out.println("Introduce el nombre del cliente");
				String nombre = entrada.next();
				System.out.println("Introduce los apellidos del cliente");
				String apellidos = entrada.next();
				System.out.println("Introduce la direccion del cliente");
				String direccion = entrada.next();

				int telefono = 0;
				boolean continua = false;
				do {
					try {
						continua = false;
						System.out.println("Introduce el telefono del cliente");
						telefono = entrada.nextInt();
					} catch (Exception e) {
						continua = true;
						System.err.println("Formato no valido");
						entrada.next();
					}

				} while (continua);

				Cliente cliente = new Cliente(nombre, apellidos, direccion, telefono, dni);
				clientes.add(cliente);
			} else {
				System.out.println("Ya existe un cliente con ese DNI");
			}
		}

	}
	/**
	 * Metodo que te imprime el listado de clientes
	 */
	public static void listarCliente() {
		if (clientes.size() == 0) {
			System.out.println("No hay clientes en el banco");
		} else {
			clientes.stream().forEach(cl -> System.out.println(cl));
		}
		System.out.println("================================================");
		if (cuentas.size() == 0) {
			System.out.println("No hay cuentas en el banco");
		} else {
			cuentas.stream().forEach(cu -> System.out.println(cu));
		}

	}
	/**
	 * Metodo para ingresar saldo a la cuenta
	 */
	public static void ingresarDinero() {
		if (cuentas.size() == 0) {
			System.out.println("No existe ninguna cuenta creada");
		} else {
			double saldo = 0;
			int ncuenta = 0;
			boolean continua;
			do {
				try {
					continua = false;
					System.out.println("Introduce el numero de cuenta a la que ingresar el dinero\n");
					for (Cuenta cuenta : cuentas) {
						System.out.println(cuenta.getNcuenta() + "\t\n");
					}
					ncuenta = entrada.nextInt();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);

			do {
				try {
					continua = false;
					System.out.println("Introduce la cantidad de dinero que vas a ingresar");
					saldo = entrada.nextDouble();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);

			for (Cuenta cuenta : cuentas) {

				if (cuenta.getNcuenta() == ncuenta) {

					cuenta.setSaldo(cuenta.getSaldo() + saldo);
					break;
				} else {
					System.out.println("El numero de cuenta introducido no coincide con ninguno de la base de datos");
				}
			}

		}

	}
	/**
	 * Metodo para sacar saldo de la cuenta
	 */
	public static void sacarDinero() {
		if (cuentas.size() == 0) {
			System.out.println("No existe ninguna cuenta creada");
		} else {
			double saldo = 0;
			int ncuenta = 0;
			boolean continua;
			do {
				try {
					continua = false;
					System.out.println("Introduce el numero de cuenta a la que retirar el dinero\n");
					for (Cuenta cuenta : cuentas) {
						System.out.println(cuenta.getNcuenta() + "\t" + cuenta.getCliente() + "\n");
					}
					ncuenta = entrada.nextInt();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);

			do {
				try {
					continua = false;
					System.out.println("Introduce la cantidad de dinero que vas a sacar");
					saldo = entrada.nextInt();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);
			for (Cuenta cuenta : cuentas) {

				if (cuenta.getNcuenta() == ncuenta) {
					if (cuenta.getSaldo() - saldo < 0) {
						System.out.println("No tienes suficientes fondos, has sacado " + cuenta.getSaldo() + " euros");
						cuenta.setSaldo(0);
					} else {
						cuenta.setSaldo(cuenta.getSaldo() - saldo);
						System.out.println("Has sacado el dinero correctamente");
						System.out.println("El saldo restante es " + cuenta.getSaldo() + " euros");
					}

					break;
				} else {
					System.out.println("El numero de cuenta introducido no coincide con ninguno de la base de datos");
				}
			}

		}

	}
	/**
	 * Metodo para consultar el saldo de la cuenta
	 */
	public static void consultarSaldo() {
		if (cuentas.size() == 0) {
			System.out.println("No existe ninguna cuenta creada");
		} else {
			int ncuenta = 0;
			boolean continua;
			do {
				try {
					continua = false;
					System.out.println("Introduce el numero de cuenta");
					for (Cuenta cuenta : cuentas) {
						System.out.println(cuenta.getNcuenta() + "\t" + cuenta.getCliente() + "\n");
					}
					ncuenta = entrada.nextInt();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);

			for (Cuenta cuenta : cuentas) {

				if (cuenta.getNcuenta() == ncuenta) {
					System.out.println("El saldo de la cuenta es: " + cuenta.getSaldo());
				} else {
					System.out.println("No hay ninguna cuenta con ese numero");
				}
			}
		}
	}
	/**
	 * Metodo para cambiar la comision de la cuenta
	 */
	public static void cambiarComision() {
		if (cuentas.size() == 0) {
			System.out.println("No existe ninguna cuenta creada");
		} else {
			double comision = 0;
			int ncuenta = 0;
			boolean continua;
			do {
				try {
					continua = false;
					System.out.println("Introduce el numero de cuenta");
					for (Cuenta cuenta : cuentas) {
						System.out.println(cuenta.getNcuenta() + "\t\n");
					}
					ncuenta = entrada.nextInt();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);
			for (Cuenta cuenta : cuentas) {

				if (cuenta.getNcuenta() == ncuenta) {
					do {
						try {
							continua = false;
							System.out.println("Introduce la nueva comision");
							comision = entrada.nextDouble();
						} catch (Exception e) {
							continua = true;
							System.err.println("Formato no valido");
							entrada.next();
						}

					} while (continua);
					if (comision >= 0.0) {
						cuenta.setComision(comision);
					} else {
						System.out.println("La comision tiene que ser mayor que 0");
					}

				} else {
					System.out.println("No hay ninguna cuenta con ese numero");
				}
			}
		}
	}
	/**
	 * Metodo para calcular la revision mensual
	 */
	public static void revisionMensual() {
		if (cuentas.size() == 0) {
			System.out.println("No existe ninguna cuenta creada");
		} else {
			int ncuenta = 0;
			boolean continua;
			do {
				try {
					continua = false;
					System.out.println("Introduce el numero de cuenta");
					for (Cuenta cuenta : cuentas) {
						System.out.println(cuenta.getNcuenta() + "\t\n");
					}
					ncuenta = entrada.nextInt();
				} catch (Exception e) {
					continua = true;
					System.err.println("Formato no valido");
					entrada.next();
				}

			} while (continua);
			for (Cuenta cuenta : cuentas) {

				if (cuenta.getNcuenta() == ncuenta) {
					cuenta.setSaldo(cuenta.getSaldo() + (cuenta.getSaldo() * cuenta.getIntcuenta() / 100)
							- cuenta.getComision());
					System.out.println("Tras la revision, el dinero de su cuenta es: " + cuenta.getSaldo());
				} else {
					System.out.println("El numero de cuenta no coincide con ningun numero de cuenta existente");
				}
			}

		}

	}

}
