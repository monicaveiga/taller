package operaciones;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Beans.Cliente;

public class OpClientes {
	public ArrayList<Cliente> cltes = new ArrayList<>();

	public OpClientes() {
		Cliente manolo = new Cliente("6666666K", "Manolo", "Gómez García", 27);
		Cliente jimena = new Cliente("22222222L", "Jimena", "López López", 31);
		Cliente manuel = new Cliente("5666666J", "Manuel", "Pereira Torre", 24);
		Cliente pepe = new Cliente("77768666K", "Pepe", "Martínez Vázquez", 22);
		Cliente Lois = new Cliente("43569313N", "Lois", "Barreiro Suarez", 18);
		Cliente María = new Cliente("73456666J", "María", "Becerra Sánchez", 48);
		Cliente Uxia = new Cliente("23456789K", "Uxia", "Gómez García", 46);
		Cliente Antia = new Cliente("33322222L", "Antia", "López López", 50);
		Cliente Filomena= new Cliente("76666666J", "Filomena", "Barcia Torre", 40);
		Cliente Guillermo = new Cliente("89666666K", "Guillermo", "Pérez García", 22);
		Cliente Raul = new Cliente("99992222L", "Raul", "Bermúdez López", 30);
		Cliente Gumersindo = new Cliente("45666666J", "Gumersindo", "Pereira Pereira", 35);
		Cliente Ataulfo= new Cliente("66668956K", "Ataulfo", "Ferreira Vázquez", 26);
		Cliente Xan= new Cliente("89822222L", "Xan", "Maceira López", 34);
		Cliente David = new Cliente("5666886J", "David", "Pereira Torre", 23);
		Cliente Maruxa = new Cliente("88666669K", "Maruxa", "Campos García", 32);
		Cliente Pío = new Cliente("26622222L", "Pío", "López López", 30);
		Cliente Reces= new Cliente("56776669J", "Reces", "Pereira Vélez", 22);
		Cliente Visitación = new Cliente("68866669K", "Visitación", "Bermúdez García", 35);
		Cliente Almudena= new Cliente("22229922L", "Almudena", "Jiménez López", 30);
		Cliente Pedro = new Cliente("44996667J", "Pedro", "Pereira Torre", 22);
		cltes.add(manuel);
		cltes.add(David);
		cltes.add(Maruxa);
		cltes.add(Pío);
		cltes.add(Reces);
		cltes.add(Visitación);
		cltes.add(Almudena);
		cltes.add(Pedro);
		cltes.add(Xan);
		cltes.add(Ataulfo);
		cltes.add(Gumersindo);
		cltes.add(Raul);
		cltes.add(Guillermo);
		cltes.add(Filomena);
		cltes.add(Antia);
		cltes.add(Uxia);
		cltes.add(María);
		cltes.add(Lois);
		cltes.add(pepe);
		cltes.add(manolo);
		cltes.add(jimena);
	}
	public void insertarClientes(Cliente cliente) {
		cltes.add(cliente);
		System.out.println("Cliente añadido con éxito");
		verClientes();
	}
	public Cliente consultarPorDNI(String dni) {
		Cliente cliente = cltes.stream()
				.filter(c -> dni.equals(c.getDNI())).
				findAny()
				.orElse(null);
		return cliente;
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
	public List<Cliente> cltesOrdenadosPorEdad(){
		Map<String, Integer> mapaEdades= cltes.stream()
				.collect(Collectors.toMap(Cliente::getDNI, Cliente::getEdad));
		
		//ordenamos el mapa por valor/edad:
		Map<String, Integer> mapaOrdenado= new LinkedHashMap<>();
        mapaEdades.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEachOrdered(x -> mapaOrdenado.put(x.getKey(), x.getValue()));
        //convertimos el mapa en lista
        List<String> DNIs = mapaOrdenado.keySet().stream()
                .collect(Collectors.toList());
        //lista que albergará los cltes ordenados:
        List<Cliente> clientesPorEdad = new ArrayList<>();
        OpClientes opc = new OpClientes();
       for (String dni : DNIs) {
    	   clientesPorEdad.add(opc.consultarPorDNI(dni));
	}
        
        return clientesPorEdad;
	}
	public static void main(String[] args) {
		OpClientes opc = new OpClientes();
		System.out.println(opc.cltesOrdenadosPorEdad());
	}
}
