package operaciones;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
//		Reparacion r3 = new Reparacion("5666666J", "LM654LN", "Faro fundido", Date.valueOf("2020-12-01"),
//				Time.valueOf("12:00:00"), 100);
		reps.add(r2);
		reps.add(r1);
		reps.add(r);
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
//		reps.forEach((rep) -> {
//			System.out.print(rep);
//		});
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
			//reps.forEach((rep) -> {
//			if (rep.getVehiculo().equals(reparacion.getVehiculo())) {
//				int i = reps.indexOf(rep);
//				reps.set(i, reparacion);
//			}
//		});
		verReparaciones();
	}
}
