package operaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Beans.Vehiculo;

public class OpVehiculos {
	public ArrayList<Vehiculo> vclos = new ArrayList<>();
	public OpVehiculos() {
		Vehiculo v = new Vehiculo("JK987PJ", "Hyundai", "Kona", 2019, "azul");
		Vehiculo v1 = new Vehiculo("VHT987R", "Citroen", "Saxo", 1990, "amarillo dorado");
		Vehiculo v2 = new Vehiculo("LM654LN", "Peugeot", "209", 20010, "rojo");
		Vehiculo v3 = new Vehiculo("JL987PJ", "Hyundai", "Kona", 2019, "azul");
		Vehiculo v4 = new Vehiculo("VIT987R", "Citroen", "Saxo", 1990, "amarillo");
		Vehiculo v5 = new Vehiculo("LN654LN", "Peugeot", "209", 20010, "negro");
		Vehiculo v6 = new Vehiculo("JK767PJ", "Hyundai", "Kona", 2019, "blanco");
		Vehiculo v7 = new Vehiculo("VHT907R", "Citroen", "Saxo", 1990, "dorado");
		Vehiculo v8 = new Vehiculo("LM984LN", "Peugeot", "209", 20010, "rosa");
		Vehiculo v9 = new Vehiculo("JL097PJ", "Hyundai", "Kona", 2019, "rojo");
		Vehiculo v10 = new Vehiculo("VIQ987R", "Citroen", "Saxo", 1990, "verde");
		Vehiculo v12 = new Vehiculo("LN554LN", "Peugeot", "209", 20010, "rojo");
		Vehiculo v13 = new Vehiculo("JO087PJ", "Hyundai", "Kona", 2019, "azul");
		Vehiculo v14 = new Vehiculo("VMB987R", "Citroen", "Saxo", 1990, "negro");
		Vehiculo v15 = new Vehiculo("YU654LN", "Peugeot", "209", 20010, "rojo");
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
	public void insertarVehiculos(Vehiculo vehiculo) {
		vclos.add(vehiculo);
		System.out.println("Vehiculo añadido con éxito");
		verVehiculos();
	}
	public Vehiculo buscarPorMatricula(String matricula) {
		Vehiculo vehiculo = vclos.stream()
				.filter(v -> matricula.equals(v.getMatricula()))
				.findAny()
				.orElse(null);
		return vehiculo;
	}
	public List<Vehiculo> buscarPorMarcaOModelo(String marcaOModelo) {
		List<Vehiculo> vs = vclos.stream().filter(r -> r.getMarca().equals(marcaOModelo) || r.getModelo().equals(marcaOModelo))
				.collect(Collectors.toList());
		return vs;
	}
	public List<Vehiculo> buscarPorMarcaModeloOAño(String marcaOModelo) {
		String mm = marcaOModelo;
		List<Vehiculo> vs;
		vs = vclos.stream().filter(r -> r.getMarca().equals(mm) || r.getModelo().equals(mm)).collect(Collectors.toList());
		return vs;
	}
	public List<Vehiculo> buscarPorMarcaModeloOAño(int... año) {
		List<Vehiculo> vs = vclos.stream().filter(r -> r.getAño() == año[0]).collect(Collectors.toList());
		return vs;
	}
	public List<Vehiculo> verVehiculos() {
//		También: vclos.forEach((v)->{System.out.println(v);});
		vclos.forEach(System.out::println);
		return vclos;
	}
	public void eliminarVehiculos(String matricula) {
		vclos.removeIf(v->v.getMatricula()==matricula);
		System.out.println("Vehiculo eliminado con éxito");
		verVehiculos();
	}
	public void modificarVehiculos(Vehiculo vehiculo) {
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
