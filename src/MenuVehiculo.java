import java.util.Scanner;

import Beans.Vehiculo;
import DAO.VehiculoDAO;
import operaciones.OpFicheros;

public class MenuVehiculo {
	public static void case2(int operation) {
		Scanner scanner = new Scanner(System.in);
//		OpVehiculos opv = new OpVehiculos();
		VehiculoDAO vdao = new VehiculoDAO();
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
			vdao.insertarVehiculos(v);
			break;
		case 6:
			System.out.println(
					"Inserta 11 para buscar por matricula, 12 para para buscar por marca o modelo, y 13 para marca, modelo y color");
			int buscar = scanner.nextInt();
			switch (buscar) {
			case 11:
				System.out.println("inserte la matricula del vehiculo a buscar");
				matricula = scanner.next();
				System.out.println(vdao.buscarPorMatricula(matricula));
				break;
			case 12:
				System.out.println("inserte la marca o el modelo del vehiculo a buscar");
				String marcaOModelo = scanner.next();
				System.out.println(vdao.buscarPorMarcaOModelo(marcaOModelo));
				break;
			case 13:
				System.out.println("inserte la marca, el modelo o el año del vehiculo a buscar");
				String marcaModeloOAño = null;
				if (scanner.hasNext()) {
					marcaModeloOAño = scanner.next();
					System.out.println(vdao.buscarPorMarcaModeloOAño(marcaModeloOAño));
				} else if (scanner.hasNextInt()) {
					año = scanner.nextInt();
					System.out.println(vdao.buscarPorMarcaModeloOAño(año));
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
			vdao.modificarVehiculos(v);
			break;
		case 8:
			System.out.println("inserte la matricula del vehiculo a borrar");
			matricula = scanner.next();
			vdao.eliminarVehiculos(matricula);
			break;
		case 9:
			OpFicheros opf1 = new OpFicheros();
			opf1.guardarVehiculos();
			System.out.println("Datos de los vehículos guardados correctamente.");
			break;
		case 10:
			OpFicheros opf = new OpFicheros();
			opf.cargarVehiculos();
			break;
		default:
			scanner.close();
			break;
		}
	}
}
