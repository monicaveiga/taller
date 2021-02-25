import java.util.Scanner;

import Beans.Cliente;
import operaciones.OpClientes;

public class Option1 {

	public static void case1(int operation) {
		OpClientes opcliente = new OpClientes();
		String dni = null;
		String nombre = null;
		String apellidos = null;
		int edad = 0;
		Cliente clte;
		Scanner scanner = new Scanner(System.in);
		switch (operation) {
		case 5:
			System.out.println("inserte el DNI del cliente");
			dni = scanner.next();
			System.out.println("inserte el nombre del cliente");
			nombre = scanner.next();
			System.out.println("inserte los apellidos del cliente");
			apellidos = scanner.nextLine();
			System.out.println("inserte la edad del cliente");
			edad = scanner.nextInt();
			clte = new Cliente(dni, nombre, apellidos, edad);
			opcliente.insertarClientes(clte);
			break;
		case 6:
			System.out.println("Inserta 11 para buscar por DNI y 12 para para buscar por nombre y apellido");
			int buscar = scanner.nextInt();
			switch (buscar) {
			case 11:
				System.out.println("inserte el DNI del cliente a buscar");
				dni = scanner.next();
				System.out.println(opcliente.consultarPorDNI(dni));
				break;
			case 12:
				System.out.println("inserte el nombre del cliente a buscar");
				scanner.nextLine();
				nombre = scanner.nextLine();
				System.out.println("inserte los apellidos del cliente a buscar");
				apellidos = scanner.nextLine();
				System.out.println(opcliente.consultarPorNombreYApellidos(nombre, apellidos));
				break;
			default:
				break;
			}
			break;
		case 7:
			System.out.println("inserte el DNI del cliente a modificar");
			dni = scanner.nextLine();
			System.out.println("inserte el nombre del cliente");
			nombre = scanner.nextLine();
			System.out.println("inserte los apellidos del cliente a modificar");
			apellidos = scanner.nextLine();
			System.out.println("inserte la edad del cliente");
			edad = scanner.nextInt();
			clte = new Cliente(dni, nombre, apellidos, edad);
			opcliente.modificar(clte);
			System.out.println("lista de clientes tras la modificacion: " + opcliente.verClientes());

			break;
		case 8:
			System.out.println("inserte el DNI del cliente a borrar");
			dni = scanner.nextLine();
			opcliente.eliminar(dni);
			System.out.println("lista de clientes tras la modificacion: " + opcliente.verClientes());
			break;
		default:
			scanner.close();
			break;
		}
	}
}
