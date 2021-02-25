package operaciones;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Beans.Cliente;
import Beans.Reparacion;

public class OpReparaciones {
	public ArrayList<Reparacion> reps = new ArrayList<>();

	public OpReparaciones() {
		Reparacion r = new Reparacion("6666666K", "JK987PJ", "Defensa abollada", Date.valueOf("2021-02-23"),
				Time.valueOf("12:00:00"), 300);
		Reparacion r1 = new Reparacion("22222222L", "VHT987R", "Batería descargada", Date.valueOf("2021-02-24"),
				Time.valueOf("12:00:00"), 200);
		Reparacion r2 = new Reparacion("5666666J", "LM654LN", "Faro fundido", Date.valueOf("2021-01-12"),
				Time.valueOf("12:00:00"), 150);
		Reparacion r3 = new Reparacion("5666666J", "LM654LN", "Batería descargada", Date.valueOf("2021-01-12"),
				Time.valueOf("12:00:00"), 400);
		Reparacion r4 = new Reparacion("6666666K", "JK987PJ", "Faro fundido", Date.valueOf("2021-01-15"),
				Time.valueOf("12:00:00"), 150);
		Reparacion r5 = new Reparacion("22222222L", "VHT987R", "Faro fundido", Date.valueOf("2021-01-14"),
				Time.valueOf("12:00:00"), 150);
		Reparacion r6 = new Reparacion("33322222L", "VIT987R", "Líquido frenos", Date.valueOf("2021-01-13"),
				Time.valueOf("12:00:00"), 100);
		Reparacion r7 = new Reparacion("33322222L", "VIT987R", "Faro fundido", Date.valueOf("2021-01-12"),
				Time.valueOf("12:00:00"), 250);
		Reparacion r8 = new Reparacion("76666666J", "LN654LN", "Volante bloqueado", Date.valueOf("2021-01-12"),
				Time.valueOf("12:00:00"), 10);
		Reparacion r9 = new Reparacion("76666666J", "LN654LN", "Frenos estropeados", Date.valueOf("2020-12-12"),
				Time.valueOf("12:00:00"), 300);
		Reparacion r10 = new Reparacion("89822222L", "JK767PJ", "Frenos estropeados", Date.valueOf("2020-11-12"),
				Time.valueOf("12:00:00"), 300);
		Reparacion r11 = new Reparacion("89822222L", "JK767PJ", "Motor estropeado", Date.valueOf("2020-11-12"),
				Time.valueOf("12:00:00"), 500);
		Reparacion r12 = new Reparacion("5666886J", "VHT907R", "Puerta rota", Date.valueOf("2020-11-11"),
				Time.valueOf("12:00:00"), 600);
		Reparacion r13 = new Reparacion("5666886J", "VHT907R", "Vidrio roto", Date.valueOf("2020-11-11"),
				Time.valueOf("12:00:00"), 500);
		Reparacion r14 = new Reparacion("5666886J", "VHT907R", "Vidrio roto", Date.valueOf("2020-11-13"),
				Time.valueOf("00:00:00"), 500);
		Reparacion r15 = new Reparacion("5666886J", "VHT907R", "2 vidrios roto", Date.valueOf("2020-11-11"),
				Time.valueOf("12:00:00"), 1000);
		Reparacion r16 = new Reparacion("88666669K", "VMB987R", "Retrovisor descolgado", Date.valueOf("2020-11-11"),
				Time.valueOf("12:00:00"), 50);
		Reparacion r17 = new Reparacion("88666669K", "VMB987R", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reparacion r18 = new Reparacion("22229922L", "JO087PJ", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reparacion r19 = new Reparacion("22229922L", "JO087PJ", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reparacion r20 = new Reparacion("44996667J", "YU654LN", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reparacion r21 = new Reparacion("44996667J", "YU654LN", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reparacion r22 = new Reparacion("56776669J", "LN554LN", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reparacion r23 = new Reparacion("26622222L", "JL097PJ", "Panorámico descolgado", Date.valueOf("2020-12-11"),
				Time.valueOf("12:00:00"), 50);
		Reparacion r24 = new Reparacion("44996667J", "YU654LN", "Frenos estropeados", Date.valueOf("2020-12-11"),
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

	public void insertarReparacion(Reparacion reparacion) {
		reps.add(reparacion);
		System.out.println("Reparación añadida con éxito");
		verReparaciones();
	}

	public List<Reparacion> buscarPorCliente(String cliente) {
		List<Reparacion> reparaciones = reps.stream().filter(r -> r.getCliente().equals(cliente))
				.collect(Collectors.toList());
		return reparaciones;
	}

	public List<Reparacion> buscarPorVehiculo(String vehiculo) {
		List<Reparacion> reparaciones = reps.stream().filter(r -> r.getVehiculo().equals(vehiculo))
				.collect(Collectors.toList());
		return reparaciones;
	}

	public List<Reparacion> buscarPorFecha(String fecha) {
		List<Reparacion> reparaciones = reps.stream().filter(r -> r.getFecha().equals(Date.valueOf(fecha)))
				.collect(Collectors.toList());
		return reparaciones;
	}

	public List<Reparacion> verReparaciones() {
//		o también: reps.forEach((rep) -> {System.out.print(rep);});
		reps.forEach(System.out::println);
		return reps;
	}

	public void eliminarReparacion(Reparacion reparacion) {
		reps.removeIf(rep -> (rep.getVehiculo() == reparacion.getVehiculo()));
	}

	public void modificarReparacion(Reparacion reparacion) {
		int index = 0;
		for (Reparacion rep : reps) {
			int i = index;
			if (rep.getVehiculo().equals(reparacion.getVehiculo())) {
				i = reps.indexOf(rep);
				reps.set(i, reparacion);
			}
		}
//o con una e.lambda: reps.forEach((rep) -> {if (rep.getVehiculo().equals(reparacion.getVehiculo())) {int i = reps.indexOf(rep);reps.set(i, reparacion);}});
		verReparaciones();
	}

	public Reparacion reparacionMasBarata() {
		List<Reparacion> repSorted = reps.stream().sorted(Comparator.comparingDouble(Reparacion::getTotalReparacion))
				.collect(Collectors.toList());
		return repSorted.get(0);
	}

	public Reparacion reparacionMasCostosa() {
		List<Reparacion> repSorted = reps.stream().sorted(Comparator.comparingDouble(Reparacion::getTotalReparacion))
				.collect(Collectors.toList());
		return repSorted.get(repSorted.size() - 1);
	}

	public List<Cliente> clientesConMasReparaciones() {
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
		 List<Cliente> diezCltes = new ArrayList<>();
		 int i = 0;
		 OpClientes opc = new OpClientes();
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
