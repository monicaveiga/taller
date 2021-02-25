package operaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Beans.Cliente;

public class OpClientes {
	public ArrayList<Cliente> cltes = new ArrayList<>();

	public OpClientes() {
		Cliente manolo = new Cliente("6666666K", "Manolo", "Gómez García", 22);
		Cliente jimena = new Cliente("22222222L", "Jimena", "López López", 30);
		Cliente manuel = new Cliente("5666666J", "Manuel", "Pereira Torre", 22);
		cltes.add(manuel);
		cltes.add(manolo);
		cltes.add(jimena);
	}
	public void insertarClientes(Cliente cliente) {
		cltes.add(cliente);
		System.out.println("Cliente añadido con éxito");
		verClientes();
	}
	public List<Cliente> consultarPorDNI(String dni) {
		List<Cliente> clientes = cltes.stream().filter(r -> r.getDNI().equals(dni)).collect(Collectors.toList());
		return clientes;
	}
	public List<Cliente> consultarPorNombreYApellidos(String nombre, String apellidos) {
		List<Cliente> clientes = cltes.stream()
				.filter(r -> (nombre).equals(r.getNombre()) && apellidos.equals(r.getApellidos()))
				.collect(Collectors.toList());
		return clientes;
	}
	public List<Cliente> verClientes() {
//		cltes.forEach((clte) -> {
//			System.out.print(clte);
//		});
		cltes.forEach(System.out::println);
		return cltes;
	}
	public void eliminar(String dni) {
		cltes.removeIf(clte -> (clte.getDNI() == dni));
		System.out.println("Cliente eliminado con éxito");
		verClientes();
	}
	public void modificar(Cliente cliente) {
		cltes.forEach((clte) -> {
			if (clte.getDNI().equals(cliente.getDNI())){
				int i = cltes.indexOf(clte);
				cltes.set(i, cliente);
			}
		});
	}
}
