package operaciones;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import Beans.Usuario;

public class OpUsuarios {
	public ArrayList<Usuario> cltes = new ArrayList<>();

	public OpUsuarios() {
		Usuario manolo = new Usuario("manolo@users.com", "Manolo", "Gómez García", Date.valueOf("1988-12-27"), "", "España");
		Usuario jimena = new Usuario("22222222L", "Jimena", "López López", Date.valueOf("1988-12-27"), "", "España");
		Usuario manuel = new Usuario("5666666J", "Manuel", "Pereira Torre", Date.valueOf("1988-12-27"), "", "España");
		Usuario pepe = new Usuario("77768666K", "Pepe", "Martínez Vázquez", Date.valueOf("1988-12-27"), "", "España");
		Usuario Lois = new Usuario("43569313N", "Lois", "Barreiro Suarez", Date.valueOf("1988-12-27"), "", "España");
		Usuario María = new Usuario("73456666J", "María", "Becerra Sánchez", Date.valueOf("1988-12-27"), "", "Alemania");
		Usuario Uxia = new Usuario("23456789K", "Uxia", "Gómez García", Date.valueOf("1988-12-27"), "", "Brasil");
		Usuario Antia = new Usuario("33322222L", "Antia", "López López", Date.valueOf("1988-12-27"), "", "España");
		Usuario Filomena = new Usuario("76666666J", "Filomena", "Barcia Torre", Date.valueOf("1988-12-27"), "", "España");
		Usuario Guillermo = new Usuario("89666666K", "Guillermo", "Pérez García", Date.valueOf("1988-12-27"), "", "España");
		Usuario Raul = new Usuario("99992222L", "Raul", "Bermúdez López", Date.valueOf("1988-12-27"), "", "Ghana");
		Usuario Gumersindo = new Usuario("45666666J", "Gumersindo", "Pereira Pereira", Date.valueOf("1988-12-27"), "", "España");
		Usuario Ataulfo = new Usuario("66668956K", "Ataulfo", "Ferreira Vázquez", Date.valueOf("1988-12-27"), "", "España");
		Usuario Xan = new Usuario("89822222L", "Xan", "Maceira López", Date.valueOf("1988-12-27"), "", "España");
		Usuario David = new Usuario("5666886J", "David", "Pereira Torre", Date.valueOf("1988-12-27"), "", "España");
		Usuario Maruxa = new Usuario("88666669K", "Maruxa", "Campos García", Date.valueOf("1988-12-27"), "", "España");
		Usuario Pío = new Usuario("26622222L", "Pío", "López López", Date.valueOf("1988-12-27"), "", "España");
		Usuario Reces = new Usuario("56776669J", "Reces", "Pereira Vélez", Date.valueOf("1988-12-27"), "", "España");
		Usuario Visitación = new Usuario("68866669K", "Visitación", "Bermúdez García", Date.valueOf("1988-12-27"), "", "España");
		Usuario Almudena = new Usuario("22229922L", "Almudena", "Jiménez López", Date.valueOf("1988-12-27"), "", "España");
		Usuario Pedro = new Usuario("44996667J", "Pedro", "Pereira Torre", Date.valueOf("1988-12-27"), "", "España");
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

	public void insertarClientes(Usuario cliente) {
		cltes.add(cliente);
		System.out.println("Cliente añadido con éxito");
		verClientes();
	}

	public Usuario consultarPorDNI(String dni) {
		Usuario cliente = cltes.stream().filter(c -> dni.equals(c.getEmail())).findAny().orElse(null);
		return cliente;
	}

	public List<Usuario> consultarPorNombreYApellidos(String nombre, String apellidos) {
		List<Usuario> clientes = cltes.stream()
				.filter(r -> (nombre).equals(r.getNombre()) && apellidos.equals(r.getApellidos()))
				.collect(Collectors.toList());
		return clientes;
	}

	public List<Usuario> verClientes() {
//		cltes.forEach((clte) -> {
//			System.out.print(clte);
//		});
		cltes.forEach(System.out::println);
		return cltes;
	}

	public void eliminar(String dni) {
		cltes.removeIf(clte -> (clte.getEmail() == dni));
		System.out.println("Cliente eliminado con éxito");
		verClientes();
	}

	public void modificar(Usuario cliente) {
		cltes.forEach((clte) -> {
			if (clte.getEmail().equals(cliente.getEmail())) {
				int i = cltes.indexOf(clte);
				cltes.set(i, cliente);
			}
		});
	}

	public int getEdad(String email) {
		int edad = 0;
		Usuario user = new Usuario();
		Date today = Date.valueOf(LocalDate.now());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(today);
		int thisYear = calendar.get(Calendar.YEAR);
		int thisDay = calendar.get(Calendar.DAY_OF_MONTH);
		int thisMonth = calendar.get(Calendar.MONTH);
		Calendar calendar1 = new GregorianCalendar();
		calendar1.setTime(user.getFechaNacimiento());
		int birthYear = calendar1.get(Calendar.YEAR);
		int birthDay = calendar1.get(Calendar.DAY_OF_MONTH);
		int birthMonth = calendar1.get(Calendar.MONTH);
		if (thisMonth == birthMonth) {
			if (thisDay < birthDay)
				edad = thisYear - birthYear - 1;
			else
				edad = thisYear - birthYear;
		} else if (thisMonth < birthMonth) {
			edad = thisYear - birthYear - 1;
		} else {
			edad = thisYear - birthYear;
		}
		return edad;
	}

}
