import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import Beans.Cliente;
import Beans.Reparacion;
import Beans.Vehiculo;
import operaciones.OpClientes;
import operaciones.OpReparaciones;
import operaciones.OpVehiculos;

public class MenuOptions {
	public static void menuOptions(int table, int operation) {
		Scanner scanner = new Scanner(System.in);
		int buscar = 0;
		switch (table) {
		case 1:
			OpClientes opcliente = new OpClientes();
			String dni = null;
			String nombre = null;
			String apellidos = null;
			int edad = 0;
			Cliente clte;
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
				buscar = scanner.nextInt();
				switch (buscar) {
				case 11:
					System.out.println("inserte el DNI del cliente a buscar");
					dni = scanner.next();
					System.out.println(opcliente.consultarPorDNI(dni));
					break;
				case 12:
					System.out.println("inserte el nombre del cliente a buscar");
					nombre = scanner.next();
					System.out.println("inserte los apellidos del cliente a buscar");
					apellidos = scanner.nextLine();
					opcliente.consultarPorNombreYApellidos(nombre, apellidos);
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
				System.out.println("lista de clientes tras la modificacion: "+opcliente.verClientes());
				
				break;
			case 8:
				System.out.println("inserte el DNI del cliente a borrar");
				dni = scanner.nextLine();
				opcliente.eliminar(dni);
				System.out.println("lista de clientes tras la modificacion: "+opcliente.verClientes());
				break;
			default:
				break;
			}
			break;
		case 2:
			OpVehiculos opv = new OpVehiculos();
			String modelo = null;
			String matricula = null;
			String marca = null;
			int año = 0;
			String color = null;
			Vehiculo v;
			switch (operation) {
			case 5:
				System.out.println("inserte la matricula del vehiculo");
				matricula = scanner.next();
				System.out.println("inserte el modelo del vehiculo");
				modelo = scanner.next();
				System.out.println("inserte la marca del vehiculo");
				marca = scanner.next();
				System.out.println("inserte el año del vehiculo");
				año = scanner.nextInt();
				System.out.println("inserte el color del vehiculo");
				scanner.nextLine();
				color = scanner.nextLine();
				v = new Vehiculo(matricula, modelo, marca, año, color);
				opv.insertarVehiculos(v);
				break;
			case 6:
				System.out.println(
						"Inserta 11 para buscar por matricula, 12 para para buscar por marca o modelo, y 13 para marca, modelo y color");
				buscar = scanner.nextInt();
				switch (buscar) {
				case 11:
					System.out.println("inserte la matricula del vehiculo a buscar");
					matricula = scanner.next();
					System.out.println(opv.buscarPorMatricula(matricula));
					break;
				case 12:
					System.out.println("inserte la marca o el modelo del vehiculo a buscar");
					String marcaOModelo = scanner.next();
					System.out.println(opv.buscarPorMarcaOModelo(marcaOModelo));
					break;
				case 13:
					System.out.println("inserte la marca, el modelo o el año del vehiculo a buscar");
					String marcaModeloOAño=null;
					if(scanner.hasNext()) {
						marcaModeloOAño = scanner.next();
						System.out.println(opv.buscarPorMarcaModeloOAño(marcaModeloOAño));
					}else if(scanner.hasNextInt()) { 
						año = scanner.nextInt();
						System.out.println(opv.buscarPorMarcaModeloOAño(año));
					}
					break;
				default:
					break;
				}
				break;
			case 7:
				System.out.println("inserte la matricula del vehiculo");
				matricula = scanner.next();
				System.out.println("inserte el modelo del vehiculo");
				modelo = scanner.next();
				System.out.println("inserte la marca del vehiculo");
				marca = scanner.next();
				System.out.println("inserte el año del vehiculo");
				año = scanner.nextInt();
				System.out.println("inserte el color del vehiculo");
				scanner.nextLine();
				color = scanner.nextLine();
				v = new Vehiculo(matricula, modelo, marca, año, color);
				opv.modificarVehiculos(v);
				break;
			case 8:
				System.out.println("inserte la matricula del vehiculo a borrar");
				matricula = scanner.next();
				opv.eliminarVehiculos(matricula);
				break;
			default:
				break;
			}
			break;
		case 3:
			OpReparaciones opr = new OpReparaciones();
			String cliente = null;
			String vehiculo = null;
			String descripcion = null;
			Date fecha;
			Time tiempo;
			double totalReparacion;
			Reparacion r;
			switch (operation) {
			case 5:
				System.out.println("inserte el dni del cliente");
				cliente = scanner.next();
				System.out.println("inserte la matricula del vehiculo");
				vehiculo= scanner.next();
				System.out.println("inserte la descripcion de la reparacion");
				scanner.nextLine();
				descripcion = scanner.nextLine();
				System.out.println("inserte la fecha de la reparacion en formato aaaa-mm-dd");
				fecha = Date.valueOf(scanner.next());
				System.out.println("inserte el tiempo de la reparacion");
				tiempo = Time.valueOf(scanner.next());
				System.out.println("inserte el total de la reparacion");
				totalReparacion = scanner.nextDouble();
				r = new Reparacion(cliente, vehiculo, descripcion, fecha, tiempo, totalReparacion);
				opr.insertarReparacion(r);
				break;
			case 6:
				System.out.println(
						"Inserta 11 para buscar por cliente, 12 para para buscar por matricula, y 13 para buscar por la fecha de la reparacion");
				buscar = scanner.nextInt();
				switch (buscar) {
				case 11:
					System.out.println("inserte el dni del cliente de la reparacion a buscar");
					cliente = scanner.next();
					System.out.println(opr.buscarPorCliente(cliente));
					break;
				case 12:
					System.out.println("inserte la matricula del vehiculo de la reparacion a buscar");
					vehiculo = scanner.next();
					System.out.println(opr.buscarPorVehiculo(vehiculo));
					break;
				case 13:
					System.out.println("inserte la fecha de la reparacion a buscar");
					String fechaS = scanner.next();
					System.out.println(opr.buscarPorFecha(fechaS));
					break;
				default:
					break;
				}
				break;
			case 7:
				System.out.println("inserte el dni del cliente de la reparación a modificar");
				cliente = scanner.next();
				System.out.println("inserte la matricula del vehiculo de la reparación a modificar");
				matricula = scanner.next();
				System.out.println("inserte la descripcion de la reparacion");
				scanner.nextLine();
				descripcion = scanner.nextLine();
				System.out.println("inserte la fecha de la reparacion en formato aaaa-mm-dd");
				fecha = Date.valueOf(scanner.next());
				System.out.println("inserte el tiempo de la reparacion a modificar");
				tiempo = Time.valueOf(scanner.next());
				System.out.println("inserte el total de la reparacion");
				totalReparacion = scanner.nextDouble();
				r = new Reparacion(cliente, matricula, descripcion, fecha, tiempo, totalReparacion);
				opr.modificarReparacion(r);
				break;
			default:
				break;
			}
			scanner.close();
			break;
		default:
			break;
		}
}}
