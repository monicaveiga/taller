import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
//		Cliente manolo = new Cliente("6666666K", "Manolo", "G�mez Garc�a", 22);
//		Cliente jimena = new Cliente("22222222L", "Jimena", "L�pez L�pez", 30);
//		Cliente manuel = new Cliente("5666666J", "Manuel", "Pereira Torre", 22);
		int table = 0;
		int operation = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println(
					"Pulsa 1 para administrar clientes, 2 para administrar veh�culos, 3 para reparaciones, y 4 para salir de la aplicaci�n en cualquier momento");
			table = scanner.nextInt();
			if (table == 1 || table == 2) {
				System.out.println("Pulsa 5 para realizar inserciones, 6 para buscar, 7 para modificar, 8 para borrar, 9 para guardar los datos en fichero, y 10 para leerlos desde fichero.");
				operation = scanner.nextInt();
			} else if (table == 3) {
				System.out.println("Pulsa 5 para realizar inserciones, 6 para buscar, y 7 para modificar, 8 para guardar los datos de memoria en fichero, y 9 para cargarlos desde fichero.");
				operation = scanner.nextInt();
			} else if (table == 4) {
				System.out.println("Menu cerrado");
//				break;
			}else {
				scanner.close();
				throw new Exception("N�mero err�neo");
			}
			if (operation < 4 || operation > 19) {
				scanner.close();
				throw new Exception("N�mero de opci�n err�neo");
			} else if (operation == 4) {
				System.out.println("Menu cerrado");
			} else {
				switch (table) {
				case 1:
					MenuUsr.case1(operation);
					break;
				case 2:
					MenuHotel.case2(operation);
					break;
				case 3:
					MenuReserva.case3(operation);
					break;
				default:
					break;
				}
			}

		} while (table != 4 && operation != 4);
		scanner.close();
	}
}
