import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
//		Cliente manolo = new Cliente("6666666K", "Manolo", "Gómez García", 22);
//		Cliente jimena = new Cliente("22222222L", "Jimena", "López López", 30);
//		Cliente manuel = new Cliente("5666666J", "Manuel", "Pereira Torre", 22);
		Scanner scanner = new Scanner(System.in);
		int table = 0;
		int operation = 0;
		do {
			System.out.println(
					"Pulsa 1 si quieres trabajar con clientes, 2 si quieres trabajar con vehículos y 3 para reparaciones");
			table = scanner.nextInt();
			if (table == 1 || table == 2) {
				System.out
						.println("Pulsa 5 para realizar inserciones, 6 para buscar, 7 para modificar y 8 para borrar");
				operation = scanner.nextInt();
			} else if (table == 3) {
				System.out.println("Pulsa 5 para realizar inserciones, 6 para buscar, y 7 para modificar");
				operation = scanner.nextInt();
			} else if (table == 4) {
				System.out.println("Adios");
				break;
			} else {
				scanner.close();
				throw new Exception("Número erróneo");
			}
			if (operation < 4 || operation > 8) {
				scanner.close();
				throw new Exception("Número de opción erróneo");
			} else if (operation == 4) {
				System.out.println("adios");
				break;
			} else {
				MenuOptions.menuOptions(table, operation);
				scanner.close();
			}
		} while (table != 4 && operation != 4);
	}
}
