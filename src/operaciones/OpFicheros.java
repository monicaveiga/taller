package operaciones;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Beans.Usuario;
import Beans.Reserva;
import Beans.Hotel;

public class OpFicheros {
	public static void main(String[] args) {
	OpFicheros fi = new OpFicheros();
//	fi.escribirClientes();
//	fi.escribirReparaciones();
//	fi.escribirVehiculos();
	fi.guardarUsuarios();
//	fi.leerReparaciones();
	fi.guardarReservas();
	}
	OpUsuarios opc = new OpUsuarios();
	OpReservas opr = new OpReservas();
	OpHoteles opv = new OpHoteles();

	public void guardarUsuarios() {
		FileInputStream in = null;
		byte[] buffer = new byte[4096];
		try {
			in = new FileInputStream("datosUsrs.txt");
			int leerDatos = 0;
			do {
				leerDatos = in.read(buffer);
			}while(leerDatos!=-1);
			ObjectInputStream leerObj = new ObjectInputStream(in);
			ArrayList<Usuario> cltes= (ArrayList<Usuario>) leerObj.readObject();
			leerObj.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void guardarHoteles() {
		FileInputStream in = null;
		byte[] buffer = new byte[4096];
		try {
			in = new FileInputStream("datosHoteles.txt");
			int leerDatos = 0;
			do {
				leerDatos = in.read(buffer);
			}while(leerDatos!=-1);
			ObjectInputStream leerObj = new ObjectInputStream(in);
			ArrayList<Hotel> vclos= (ArrayList<Hotel>) leerObj.readObject();
			leerObj.close();
			System.out.println(vclos.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void guardarReservas() {
		FileInputStream in = null;
		byte[] buffer = new byte[4096];
		try {
			in = new FileInputStream("datosRes.txt");
			int leerDatos = 0;
			do {
				leerDatos = in.read(buffer);
			}while(leerDatos!=-1);
			ObjectInputStream leerObj = new ObjectInputStream(in);
			ArrayList<Reserva> reps= (ArrayList<Reserva>) leerObj.readObject();
			leerObj.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void cargarUsuarios() {
		byte[] buffer = new byte[4096];
		try {
			FileOutputStream escribirCltes= new FileOutputStream("datosUsrs.txt");
			ObjectOutputStream out = new ObjectOutputStream(escribirCltes);
			out.writeObject(opc.verClientes());
			out.write(buffer);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarHoteles() {
		byte[] buffer = new byte[4096];
		try {
			FileOutputStream escribirVehiculos = new FileOutputStream("datosHoteles.txt");
			ObjectOutputStream out = new ObjectOutputStream(escribirVehiculos);
			out.writeObject(opv.verVehiculos());
			out.write(buffer);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cargarReservas() {
		byte[] buffer = new byte[4096];
		try {
			FileOutputStream escribirReps= new FileOutputStream("datosRes.txt");
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
