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
		Usuario manolo = new Usuario("manolo@users.com", "Manolo", "G�mez Garc�a", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario jimena = new Usuario("22222222L", "Jimena", "L�pez L�pez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario manuel = new Usuario("5666666J", "Manuel", "Pereira Torre", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario pepe = new Usuario("77768666K", "Pepe", "Mart�nez V�zquez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Lois = new Usuario("43569313N", "Lois", "Barreiro Suarez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Mar�a = new Usuario("73456666J", "Mar�a", "Becerra S�nchez", Date.valueOf("1988-12-27"), "", "Alemania");
		Usuario Uxia = new Usuario("23456789K", "Uxia", "G�mez Garc�a", Date.valueOf("1988-12-27"), "", "Brasil");
		Usuario Antia = new Usuario("33322222L", "Antia", "L�pez L�pez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Filomena = new Usuario("76666666J", "Filomena", "Barcia Torre", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Guillermo = new Usuario("89666666K", "Guillermo", "P�rez Garc�a", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Raul = new Usuario("99992222L", "Raul", "Berm�dez L�pez", Date.valueOf("1988-12-27"), "", "Ghana");
		Usuario Gumersindo = new Usuario("45666666J", "Gumersindo", "Pereira Pereira", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Ataulfo = new Usuario("66668956K", "Ataulfo", "Ferreira V�zquez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Xan = new Usuario("89822222L", "Xan", "Maceira L�pez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario David = new Usuario("5666886J", "David", "Pereira Torre", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Maruxa = new Usuario("88666669K", "Maruxa", "Campos Garc�a", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario P�o = new Usuario("26622222L", "P�o", "L�pez L�pez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Reces = new Usuario("56776669J", "Reces", "Pereira V�lez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Visitaci�n = new Usuario("68866669K", "Visitaci�n", "Berm�dez Garc�a", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Almudena = new Usuario("22229922L", "Almudena", "Jim�nez L�pez", Date.valueOf("1988-12-27"), "", "Espa�a");
		Usuario Pedro = new Usuario("44996667J", "Pedro", "Pereira Torre", Date.valueOf("1988-12-27"), "", "Espa�a");
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

	public void insertarClientes(Usuario cliente) {
		cltes.add(cliente);
		System.out.println("Cliente a�adido con �xito");
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
		System.out.println("Cliente eliminado con �xito");
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
