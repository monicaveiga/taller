package operaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Beans.Hotel;

public class OpHoteles {
	public ArrayList<Hotel> vclos = new ArrayList<>();
	public OpHoteles() {
		Hotel v = new Hotel("JK987PJ", "Hyundai", "Kona", 2019, "azul");
		Hotel v1 = new Hotel("VHT987R", "Citroen", "Saxo", 1990, "amarillo dorado");
		Hotel v2 = new Hotel("LM654LN", "Peugeot", "209", 20010, "rojo");
		Hotel v3 = new Hotel("JL987PJ", "Hyundai", "Kona", 2019, "azul");
		Hotel v4 = new Hotel("VIT987R", "Citroen", "Saxo", 1990, "amarillo");
		Hotel v5 = new Hotel("LN654LN", "Peugeot", "209", 20010, "negro");
		Hotel v6 = new Hotel("JK767PJ", "Hyundai", "Kona", 2019, "blanco");
		Hotel v7 = new Hotel("VHT907R", "Citroen", "Saxo", 1990, "dorado");
		Hotel v8 = new Hotel("LM984LN", "Peugeot", "209", 20010, "rosa");
		Hotel v9 = new Hotel("JL097PJ", "Hyundai", "Kona", 2019, "rojo");
		Hotel v10 = new Hotel("VIQ987R", "Citroen", "Saxo", 1990, "verde");
		Hotel v12 = new Hotel("LN554LN", "Peugeot", "209", 20010, "rojo");
		Hotel v13 = new Hotel("JO087PJ", "Hyundai", "Kona", 2019, "azul");
		Hotel v14 = new Hotel("VMB987R", "Citroen", "Saxo", 1990, "negro");
		Hotel v15 = new Hotel("YU654LN", "Peugeot", "209", 20010, "rojo");
		vclos.add(v);
		vclos.add(v1);
		vclos.add(v2);
		vclos.add(v4);
		vclos.add(v5);
		vclos.add(v6);
		vclos.add(v7);
		vclos.add(v8);
		vclos.add(v9);
		vclos.add(v10);
		vclos.add(v3);
		vclos.add(v12);
		vclos.add(v13);
		vclos.add(v14);
		vclos.add(v15);
	}
	public void insertarVehiculos(Hotel vehiculo) {
		vclos.add(vehiculo);
		System.out.println("Vehiculo añadido con éxito");
		verVehiculos();
	}
	public Hotel buscarPorMatricula(String matricula) {
		Hotel vehiculo = vclos.stream()
				.filter(v -> matricula.equals(v.getMatricula()))
				.findAny()
				.orElse(null);
		return vehiculo;
	}
	public List<Hotel> buscarPorMarcaOModelo(String marcaOModelo) {
		List<Hotel> vs = vclos.stream().filter(r -> r.getMarca().equals(marcaOModelo) || r.getModelo().equals(marcaOModelo))
				.collect(Collectors.toList());
		return vs;
	}
	public List<Hotel> buscarPorMarcaModeloOAño(String marcaOModelo) {
		String mm = marcaOModelo;
		List<Hotel> vs;
		vs = vclos.stream().filter(r -> r.getMarca().equals(mm) || r.getModelo().equals(mm)).collect(Collectors.toList());
		return vs;
	}
	public List<Hotel> buscarPorMarcaModeloOAño(int... año) {
		List<Hotel> vs = vclos.stream().filter(r -> r.getAño() == año[0]).collect(Collectors.toList());
		return vs;
	}
	public List<Hotel> verVehiculos() {
//		También: vclos.forEach((v)->{System.out.println(v);});
		vclos.forEach(System.out::println);
		return vclos;
	}
	public void eliminarVehiculos(String matricula) {
		vclos.removeIf(v->v.getMatricula()==matricula);
		System.out.println("Vehiculo eliminado con éxito");
		verVehiculos();
	}
	public void modificarVehiculos(Hotel vehiculo) {
		vclos.forEach((v) -> {
			if (v.getMatricula().equals(vehiculo.getMatricula())) {
				int i = vclos.indexOf(v);
				vclos.set(i, vehiculo);
			}
		});
		System.out.println("Vehiculo modificado con éxito");
		verVehiculos();
	}
}
