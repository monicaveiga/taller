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
		vclos.add(v);
		vclos.add(v1);
		vclos.add(v2);
	}
	public void insertarVehiculos(Vehiculo vehiculo) {
		vclos.add(vehiculo);
		System.out.println("Vehiculo añadido con éxito");
		verVehiculos();
	}
	public List<Vehiculo> buscarPorMatricula(String matricula) {
		List<Vehiculo> vs = vclos.stream().filter(r -> r.getMatricula().equals(matricula)).collect(Collectors.toList());
		return vs;
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
//		vclos.forEach((v)->{
//			System.out.println(v);
//		});
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
