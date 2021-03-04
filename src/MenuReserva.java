import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import Beans.Reserva;
import DAO.ReservasDAO;
import operaciones.OpFicheros;

public class MenuReserva {
public static void case3(int operation) {
	Scanner scanner = new Scanner(System.in);
//	OpReparaciones opr = new OpReparaciones();
	ReservasDAO rdao = new ReservasDAO();
	String cliente = null;
	String vehiculo = null;
	String descripcion = null;
	Date fecha;
	Time tiempo;
	double totalReparacion;
	Reserva r;
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
//		r = new Reserva(cliente, vehiculo, descripcion, fecha, tiempo, totalReparacion);
//		rdao.insertarReparacion(r);
		break;
	case 6:
		System.out.println(
				"Inserta 11 para buscar por cliente, 12 para para buscar por matricula, 13 para buscar por la fecha de la reparacion,\n 14 para ver la reparación más barata, y 15 para ver la más cara");
		int buscar = scanner.nextInt();
		switch (buscar) {
		case 11:
			System.out.println("inserte el dni del cliente de la reparacion a buscar");
			cliente = scanner.next();
			System.out.println(rdao.buscarPorCliente(cliente));
			break;
		case 12:
			System.out.println("inserte la matricula del vehiculo de la reparacion a buscar");
			vehiculo = scanner.next();
			System.out.println(rdao.buscarPorHotel(vehiculo));
			break;
		case 13:
			System.out.println("inserte la fecha de la reparacion a buscar");
			String fechaS = scanner.next();
			System.out.println(rdao.buscarPorFecha(fechaS));
			break;
		case 14:
			System.out.println("La repación más barata es:");
			System.out.println(rdao.reparacionMasBarata());
			break;
		case 15:
			System.out.println("La repación más costosa es:");
			System.out.println(rdao.reparacionMasCostosa());
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
//		r = new Reserva(cliente, vehiculo, descripcion, fecha, tiempo, totalReparacion);
//		rdao.modificarReparacion(r);
		break;
	case 8:
		OpFicheros opf = new OpFicheros();
		opf.guardarReservas();
		System.out.println("Datos de las reparaciones guardadas correctamente.");
		break;
	case 9:
		OpFicheros opf1 = new OpFicheros();
		opf1.cargarReservas();
		break;
	default:
		scanner.close();
		break;
	}
}
}
