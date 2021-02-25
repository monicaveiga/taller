package operaciones;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Beans.Cliente;
import Beans.Reparacion;
import Beans.Vehiculo;

public class OpFicheros {
	public static void main(String[] args) {
	OpFicheros fi = new OpFicheros();
//	fi.escribirClientes();
//	fi.escribirReparaciones();
//	fi.escribirVehiculos();
	fi.guardarClientes();
//	fi.leerReparaciones();
	fi.guardarReparaciones();
	}
	OpClientes opc = new OpClientes();
	OpReparaciones opr = new OpReparaciones();
	OpVehiculos opv = new OpVehiculos();

	public void guardarClientes() {
		FileInputStream in = null;
		byte[] buffer = new byte[4096];
		try {
			in = new FileInputStream("datosCltes.txt");
			int leerDatos = 0;
			do {
				leerDatos = in.read(buffer);
			}while(leerDatos!=-1);
			ObjectInputStream leerObj = new ObjectInputStream(in);
			ArrayList<Cliente> cltes= (ArrayList<Cliente>) leerObj.readObject();
			leerObj.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void guardarVehiculos() {
		FileInputStream in = null;
		byte[] buffer = new byte[4096];
		try {
			in = new FileInputStream("datosVehiculos.txt");
			int leerDatos = 0;
			do {
				leerDatos = in.read(buffer);
			}while(leerDatos!=-1);
			ObjectInputStream leerObj = new ObjectInputStream(in);
			ArrayList<Vehiculo> vclos= (ArrayList<Vehiculo>) leerObj.readObject();
			leerObj.close();
			System.out.println(vclos.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void guardarReparaciones() {
		FileInputStream in = null;
		byte[] buffer = new byte[4096];
		try {
			in = new FileInputStream("datosReps.txt");
			int leerDatos = 0;
			do {
				leerDatos = in.read(buffer);
			}while(leerDatos!=-1);
			ObjectInputStream leerObj = new ObjectInputStream(in);
			ArrayList<Reparacion> reps= (ArrayList<Reparacion>) leerObj.readObject();
			leerObj.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void cargarClientes() {
		byte[] buffer = new byte[4096];
		try {
			FileOutputStream escribirCltes= new FileOutputStream("datosCltes.txt");
			ObjectOutputStream out = new ObjectOutputStream(escribirCltes);
			out.writeObject(opc.cltesOrdenadosPorEdad());
			out.write(buffer);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarVehiculos() {
		byte[] buffer = new byte[4096];
		try {
			FileOutputStream escribirVehiculos = new FileOutputStream("datosVehiculos.txt");
			ObjectOutputStream out = new ObjectOutputStream(escribirVehiculos);
			out.writeObject(opv.verVehiculos());
			out.write(buffer);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cargarReparaciones() {
		byte[] buffer = new byte[4096];
		try {
			FileOutputStream escribirReps= new FileOutputStream("datosReps.txt");
			ObjectOutputStream out = new ObjectOutputStream(escribirReps);
			out.writeObject(opr.verReparaciones());
			out.write(buffer);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
