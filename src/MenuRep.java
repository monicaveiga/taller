import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import Beans.Reparacion;
import operaciones.OpReparaciones;

public class MenuRep {
public static void case3(int operation) {
	Scanner scanner = new Scanner(System.in);
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
				"Inserta 11 para buscar por cliente, 12 para para buscar por matricula, 13 para buscar por la fecha de la reparacion,\n 14 para ver la reparación más barata, y 15 para ver la más cara");
		int buscar = scanner.nextInt();
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
		case 14:
			System.out.println("La repación más barata es:");
			System.out.println(opr.reparacionMasBarata());
			break;
		case 15:
			System.out.println("La repación más costosa es:");
			System.out.println(opr.reparacionMasCostosa());
			break;
		default:
			break;
		}
		break;
	case 7:
		System.out.println("inserte el dni del cliente de la reparación a modificar");
		cliente = scanner.next();
		System.out.println("inserte la matricula del vehiculo de la reparación a modificar");
		vehiculo = scanner.next();
		System.out.println("inserte la descripcion de la reparacion");
		scanner.nextLine();
		descripcion = scanner.nextLine();
		System.out.println("inserte la fecha de la reparacion en formato aaaa-mm-dd");
		fecha = Date.valueOf(scanner.next());
		System.out.println("inserte el tiempo de la reparacion a modificar");
		tiempo = Time.valueOf(scanner.next());
		System.out.println("inserte el total de la reparacion");
		totalReparacion = scanner.nextDouble();
		r = new Reparacion(cliente, vehiculo, descripcion, fecha, tiempo, totalReparacion);
		opr.modificarReparacion(r);
		break;
	default:
		scanner.close();
		break;
	}
}
}
