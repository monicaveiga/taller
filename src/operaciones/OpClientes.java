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
		Cliente manolo = new Cliente("6666666K", "Manolo", "G�mez Garc�a", 27);
		Cliente jimena = new Cliente("22222222L", "Jimena", "L�pez L�pez", 31);
		Cliente manuel = new Cliente("5666666J", "Manuel", "Pereira Torre", 24);
		Cliente pepe = new Cliente("77768666K", "Pepe", "Mart�nez V�zquez", 22);
		Cliente Lois = new Cliente("43569313N", "Lois", "Barreiro Suarez", 18);
		Cliente Mar�a = new Cliente("73456666J", "Mar�a", "Becerra S�nchez", 48);
		Cliente Uxia = new Cliente("23456789K", "Uxia", "G�mez Garc�a", 46);
		Cliente Antia = new Cliente("33322222L", "Antia", "L�pez L�pez", 50);
		Cliente Filomena= new Cliente("76666666J", "Filomena", "Barcia Torre", 40);
		Cliente Guillermo = new Cliente("89666666K", "Guillermo", "P�rez Garc�a", 22);
		Cliente Raul = new Cliente("99992222L", "Raul", "Berm�dez L�pez", 30);
		Cliente Gumersindo = new Cliente("45666666J", "Gumersindo", "Pereira Pereira", 35);
		Cliente Ataulfo= new Cliente("66668956K", "Ataulfo", "Ferreira V�zquez", 26);
		Cliente Xan= new Cliente("89822222L", "Xan", "Maceira L�pez", 34);
		Cliente David = new Cliente("5666886J", "David", "Pereira Torre", 23);
		Cliente Maruxa = new Cliente("88666669K", "Maruxa", "Campos Garc�a", 32);
		Cliente P�o = new Cliente("26622222L", "P�o", "L�pez L�pez", 30);
		Cliente Reces= new Cliente("56776669J", "Reces", "Pereira V�lez", 22);
		Cliente Visitaci�n = new Cliente("68866669K", "Visitaci�n", "Berm�dez Garc�a", 35);
		Cliente Almudena= new Cliente("22229922L", "Almudena", "Jim�nez L�pez", 30);
		Cliente Pedro = new Cliente("44996667J", "Pedro", "Pereira Torre", 22);
		cltes.add(manuel);
		cltes.add(David);
		cltes.add(Maruxa);
		cltes.add(P�o);
		cltes.add(Reces);
		cltes.add(Visitaci�n);
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
		cltes.add(Mar�a);
		cltes.add(Lois);
		cltes.add(pepe);
		cltes.add(manolo);
		cltes.add(jimena);
	}
	public void insertarClientes(Cliente cliente) {
		cltes.add(cliente);
		System.out.println("Cliente a�adido con �xito");
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
		System.out.println("Cliente eliminado con �xito");
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
        //lista que albergar� los cltes ordenados:
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
