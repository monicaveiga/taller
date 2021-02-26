import java.util.Scanner;

import Beans.Cliente;
import DAO.ClientesDAO;
import DAO.ReparacionDAO;
import operaciones.OpFicheros;

public class MenuClte {

	public static void case1(int operation) {
//		OpClientes opcliente = new OpClientes();
		ClientesDAO cdao = new ClientesDAO();
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
			cdao.insertarClientes(clte);
			break;
		case 6:
			System.out.println("Inserta 11 para buscar por DNI, 12 para para buscar por nombre y apellido,\n 13 para ver los 10 clientes con más reparaciones y 14 para ver los cliente ordenador por edad");
			int buscar = scanner.nextInt();
			switch (buscar) {
			case 11:
				System.out.println("inserte el DNI del cliente a buscar");
				dni = scanner.next();
				System.out.println(cdao.consultarPorDNI(dni));
				break;
			case 12:
				System.out.println("inserte el nombre y los apellidos del cliente a buscar");
				String nombreyapellidos = scanner.nextLine();
//				nombre = scanner.nextLine();
//				System.out.println("inserte los apellidos del cliente a buscar");
				apellidos = scanner.nextLine();
				System.out.println(cdao.consultarPorNombreYApellidos(nombreyapellidos));
				break;
			case 13:
//				OpReparaciones oprep =new OpReparaciones();
				ReparacionDAO rdao = new ReparacionDAO();
				System.out.println("Los 10 clientes con más reparaciones son"+rdao.clientesConMasReparaciones());
				break;
			case 14:
				System.out.println("Los clientes ordenados por edad son:");
				System.out.println(cdao.cltesOrdenadosPorEdad());
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
			cdao.modificar(clte);
			System.out.println("lista de clientes tras la modificacion: " + cdao.verClientes());

			break;
		case 8:
			System.out.println("inserte el DNI del cliente a borrar");
			dni = scanner.nextLine();
			cdao.eliminar(dni);
			System.out.println("lista de clientes tras la modificacion: " + cdao.verClientes());
			break;
		case 9:
			OpFicheros opf1 = new OpFicheros();
			opf1.guardarClientes();
			System.out.println("Datos de los clientes guardados correctamente.");
			break;
		case 10:
			OpFicheros opf = new OpFicheros();
			opf.cargarClientes();
			break;
		default:
			scanner.close();
			break;
		}
	}
}
