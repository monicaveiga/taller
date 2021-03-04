package operaciones;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Beans.Usuario;
import Beans.Reserva;

public class OpReservas {
	public ArrayList<Reserva> reps = new ArrayList<>();

	public OpReservas() {
		Reserva r = new Reserva("6666666K", "JK987PJ", "Defensa abollada", Date.valueOf("2021-02-23"),
				Time.valueOf("12:00:00"), 300);
		Reserva r1 = new Reserva("22222222L", "VHT987R", "Batería descargada", Date.valueOf("2021-02-24"),
				Time.valueOf("12:00:00"), 200);
		Reserva r2 = new Reserva("5666666J", "LM654LN", "Faro fundido", Date.valueOf("2021-01-12"),
				Time.valueOf("12:00:00"), 150);
		Reserva r3 = new Reserva("5666666J", "LM654LN", "Batería descargada", Date.valueOf("2021-01-12"),
				Time.valueOf("12:00:00"), 400);
		Reserva r4 = new Reserva("6666666K", "JK987PJ", "Faro fundido", Date.valueOf("2021-01-15"),
				Time.valueOf("12:00:00"), 150);
		Reserva r5 = new Reserva("22222222L", "VHT987R", "Faro fundido", Date.valueOf("2021-01-14"),
				Time.valueOf("12:00:00"), 150);
		Reserva r6 = new Reserva("33322222L", "VIT987R", "Líquido frenos", Date.valueOf("2021-01-13"),
				Time.valueOf("12:00:00"), 100);
		Reserva r7 = new Reserva("33322222L", "VIT987R", "Faro fundido", Date.valueOf("2021-01-12"),
				Time.valueOf("12:00:00"), 250);
		Reserva r8 = new Reserva("76666666J", "LN654LN", "Volante bloqueado", Date.valueOf("2021-01-12"),
				Time.valueOf("12:00:00"), 10);
		Reserva r9 = new Reserva("76666666J", "LN654LN", "Frenos estropeados", Date.valueOf("2020-12-12"),
				Time.valueOf("12:00:00"), 300);
		Reserva r10 = new Reserva("89822222L", "JK767PJ", "Frenos estropeados", Date.valueOf("2020-11-12"),
				Time.valueOf("12:00:00"), 300);
		Reserva r11 = new Reserva("89822222L", "JK767PJ", "Motor estropeado", Date.valueOf("2020-11-12"),
				Time.valueOf("12:00:00"), 500);
		Reserva r12 = new Reserva("5666886J", "VHT907R", "Puerta rota", Date.valueOf("2020-11-11"),
				Time.valueOf("12:00:00"), 600);
		Reserva r13 = new Reserva("5666886J", "VHT907R", "Vidrio roto", Date.valueOf("2020-11-11"),
				Time.valueOf("12:00:00"), 500);
		Reserva r14 = new Reserva("5666886J", "VHT907R", "Vidrio roto", Date.valueOf("2020-11-13"),
				Time.valueOf("00:00:00"), 500);
		Reserva r15 = new Reserva("5666886J", "VHT907R", "2 vidrios roto", Date.valueOf("2020-11-11"),
				Time.valueOf("12:00:00"), 1000);
		Reserva r16 = new Reserva("88666669K", "VMB987R", "Retrovisor descolgado", Date.valueOf("2020-11-11"),
				Time.valueOf("12:00:00"), 50);
		Reserva r17 = new Reserva("88666669K", "VMB987R", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reserva r18 = new Reserva("22229922L", "JO087PJ", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reserva r19 = new Reserva("22229922L", "JO087PJ", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reserva r20 = new Reserva("44996667J", "YU654LN", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reserva r21 = new Reserva("44996667J", "YU654LN", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reserva r22 = new Reserva("56776669J", "LN554LN", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reserva r23 = new Reserva("26622222L", "JL097PJ", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reserva r24 = new Reserva("44996667J", "YU654LN", "Frenos estropeados", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);

		reps.add(r2);
		reps.add(r1);
		reps.add(r);
		reps.add(r3);
		reps.add(r4);
		reps.add(r5);
		reps.add(r6);
		reps.add(r7);
		reps.add(r8);
		reps.add(r9);
		reps.add(r10);
		reps.add(r11);
		reps.add(r12);
		reps.add(r13);
		reps.add(r14);
		reps.add(r15);
		reps.add(r16);
		reps.add(r17);
		reps.add(r18);
		reps.add(r19);
		reps.add(r20);
		reps.add(r21);
		reps.add(r22);
		reps.add(r23);
		reps.add(r24);
	}

	public void insertarReparacion(Reserva reparacion) {
		reps.add(reparacion);
		System.out.println("Reparación añadida con éxito");
		verReparaciones();
	}

	public List<Reserva> buscarPorCliente(String cliente) {
		List<Reserva> reparaciones = reps.stream().filter(r -> r.getCliente().equals(cliente))
				.collect(Collectors.toList());
		return reparaciones;
	}

	public List<Reserva> buscarPorVehiculo(String vehiculo) {
		List<Reserva> reparaciones = reps.stream().filter(r -> r.getVehiculo().equals(vehiculo))
				.collect(Collectors.toList());
		return reparaciones;
	}

	public List<Reserva> buscarPorFecha(String fecha) {
		List<Reserva> reparaciones = reps.stream().filter(r -> r.getFecha().equals(Date.valueOf(fecha)))
				.collect(Collectors.toList());
		return reparaciones;
	}

	public List<Reserva> verReparaciones() {
//		o también: reps.forEach((rep) -> {System.out.print(rep);});
		reps.forEach(System.out::println);
		return reps;
	}

	public void eliminarReparacion(Reserva reparacion) {
		reps.removeIf(rep -> (rep.getVehiculo() == reparacion.getVehiculo()));
	}

	public void modificarReparacion(Reserva reparacion) {
		int index = 0;
		for (Reserva rep : reps) {
			int i = index;
			if (rep.getVehiculo().equals(reparacion.getVehiculo())) {
				i = reps.indexOf(rep);
				reps.set(i, reparacion);
			}
		}
//o con una e.lambda: reps.forEach((rep) -> {if (rep.getVehiculo().equals(reparacion.getVehiculo())) {int i = reps.indexOf(rep);reps.set(i, reparacion);}});
		verReparaciones();
	}

	public Reserva reparacionMasBarata() {
		List<Reserva> repSorted = reps.stream().sorted(Comparator.comparingDouble(Reserva::getTotalReparacion))
				.collect(Collectors.toList());
		return repSorted.get(0);
	}

	public Reserva reparacionMasCostosa() {
		List<Reserva> repSorted = reps.stream().sorted(Comparator.comparingDouble(Reserva::getTotalReparacion))
				.collect(Collectors.toList());
		return repSorted.get(repSorted.size() - 1);
	}

	public List<Usuario> clientesConMasReparaciones() {
		// mapa cuya clave son los clientes(dni) y cuyo valor es el número de veces que
		// aparece
		Map<String, Integer> mapaRepeticiones = reps.stream()
				.collect(Collectors.toMap(rep -> rep.getCliente(), value -> 1, Integer::sum));
		//System.out.println(mapaRepeticiones);
		// Ahora ordenamos según el valor de las repeticiones:
		Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
		mapaRepeticiones.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEachOrdered(x -> mapaOrdenado.put(x.getKey(), x.getValue()));
		//System.out.println(mapaOrdenado);
		//convertimos el hasmhap en lista:
		 List<String> clientes = mapaOrdenado.keySet().stream()
	                .collect(Collectors.toList());
		 //creamos la lista que va a albergar a los 10 cltes
		 List<Usuario> diezCltes = new ArrayList<>();
		 int i = 0;
		 OpUsuarios opc = new OpUsuarios();
		 //hacemos un bucle para iterar 10 veces por la lista ya ordenada y pasamos un cliente de cada vez a la lista 10cltes
		for (String cliente : clientes) {
			if(i==10)
				break;
			i++;
			diezCltes.add(opc.consultarPorDNI(cliente));
		}
		return diezCltes;
	}
}
