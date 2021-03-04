package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Hotel;
import operaciones.OpHoteles;

public class HotelesDAO {

	private Connection conn = null;

	public void insertarVehiculos(Hotel vehiculo) {
		try {
			this.conn = DBConnection.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO vehiculo VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?)");
			ps.setString(1, vehiculo.getNombre());
			ps.setString(2, vehiculo.getDireccion());
			ps.setString(3, vehiculo.getCiudad());
			ps.setString(4, vehiculo.getRegion());
			ps.setString(5, vehiculo.getDescripcion());
			ps.setString(6, vehiculo.getImgD());
			ps.setString(7, vehiculo.getImgH());
			ps.setDouble(8, vehiculo.getPrecio());
			ps.setShort(9, vehiculo.getEstrellas());
			ps.setBoolean(10, vehiculo.isPiscina());
			ps.setBoolean(11, vehiculo.isSpa());
			ps.setBoolean(12, vehiculo.isWifi());
			ps.setBoolean(13, vehiculo.isParking());
			ps.setBoolean(14, vehiculo.isRecomendado());
			ps.setInt(15, vehiculo.getDescuento());
			ps.execute();
			ps.close();
			System.out.println("Vehiculo añadido con éxito");
		} catch (SQLException e) {
			System.out.println("Error al añadir vehículo" + e.getMessage());
			e.printStackTrace();
		}
	}

	public Hotel buscarPorNombre(String nombre) {
		Hotel v = null;
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM vehiculo WHERE nombre = " + "'" + nombre + "'");
			while (res.next()) {
				v = new Hotel(res.getInt("id"), res.getString("nombre"), res.getString("direccion"),
						res.getString("ciudad"), res.getString("region"), res.getString("descripcion"),
						res.getString("imgD"), res.getString("imgH"), res.getDouble("precio"),
						res.getShort("estrellas"), res.getBoolean("piscina"), res.getBoolean("spa"),
						res.getBoolean("wifi"), res.getBoolean("parking"), res.getBoolean("recomendado"),
						res.getInt("descuento"));
			}
			res.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos ClientesDAO: " + e.getMessage());
			e.printStackTrace();
		}
		return v;
	}

	public List<Hotel> buscarPorCiudadORegionONombre(String busqueda) {
		String sql = "SELECT * FROM hotel WHERE nombre = " + "'" + busqueda + "'" + " OR ciudad = " + "'" + busqueda
				+ "'" + " OR region= " + "'" + busqueda + "'" + " ORDER BY nombre";
		List<Hotel> vs = new ArrayList<Hotel>();
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Hotel v = new Hotel();
				v.setId(rs.getInt(1));
				v.setNombre(rs.getString(2));
				v.setDireccion(rs.getString(3));
				v.setCiudad(rs.getString(4));
				v.setRegion(rs.getString(5));
				v.setDescripcion(rs.getString(6));
				v.setImgD(rs.getString(7));
				v.setImgH(rs.getString(8));
				v.setPrecio(rs.getDouble(9));
				v.setEstrellas(rs.getShort(10));
				v.setPiscina(rs.getBoolean(11));
				v.setSpa(rs.getBoolean(12));
				v.setWifi(rs.getBoolean(13));
				v.setParking(rs.getBoolean(14));
				v.setRecomendado(rs.getBoolean(15));
				v.setDescuento(rs.getInt(16));
				vs.add(v);
			}
			statement.close();
			rs.close();
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos ClientesDAO: " + e.getMessage());
			e.printStackTrace();
		}
		return vs;
	}

	public List<Hotel> verHotelesYFilter(String[] filters) {
		String sql = "";
		if (filters.length == 0) {
			sql = "SELECT * FROM hotel";
		} else if (filters.length > 0) {
			sql = "SELECT * FROM hotel WHERE ";
			for (String filter : filters) {
				sql += "'" + filter + "'" + "= true && ";
//			if (filter.equals("piscina"))
//				sql += "piscina= true && ";
//			else if (filter.equals("spa"))
//				sql = "spa= true && ";
//			else if (filter.equals("wifi"))
//				sql = "wifi= true && ";
//			else if (filter.equals("parking"))
//				sql = "parking= true && ";
//			else if (filter.equals("recomendado"))
//				sql = "recomendado= true && ";
			}
			sql = sql.substring(0, sql.length() - 3);
		}
		List<Hotel> hs = new ArrayList<Hotel>();
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Hotel h = new Hotel();
				h.setId(rs.getInt(1));
				h.setNombre(rs.getString(2));
				h.setDireccion(rs.getString(3));
				h.setCiudad(rs.getString(4));
				h.setRegion(rs.getString(5));
				h.setDescripcion(rs.getString(6));
				h.setImgD(rs.getString(7));
				h.setImgH(rs.getString(8));
				h.setPrecio(rs.getDouble(9));
				h.setEstrellas(rs.getShort(10));
				h.setPiscina(rs.getBoolean(11));
				h.setSpa(rs.getBoolean(12));
				h.setWifi(rs.getBoolean(13));
				h.setParking(rs.getBoolean(14));
				h.setRecomendado(rs.getBoolean(15));
				h.setDescuento(rs.getInt(16));
				hs.add(h);
			}
			statement.close();
			rs.close();
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos Hotel: " + e.getMessage());
			e.printStackTrace();
		}
		return hs;
	}

	public List<Hotel> buscarPorEstrellas(int[] estrellas) {
		String sql = "SELECT * FROM hotel WHERE ";
		for (int estrella : estrellas) {
			sql += "estrellas= " + estrella + " && ";
		}
		sql = sql.substring(0, sql.length() - 3);
		List<Hotel> hs = new ArrayList<Hotel>();
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Hotel h = new Hotel();
				h.setId(rs.getInt(1));
				h.setNombre(rs.getString(2));
				h.setDireccion(rs.getString(3));
				h.setCiudad(rs.getString(4));
				h.setRegion(rs.getString(5));
				h.setDescripcion(rs.getString(6));
				h.setImgD(rs.getString(7));
				h.setImgH(rs.getString(8));
				h.setPrecio(rs.getDouble(9));
				h.setEstrellas(rs.getShort(10));
				h.setPiscina(rs.getBoolean(11));
				h.setSpa(rs.getBoolean(12));
				h.setWifi(rs.getBoolean(13));
				h.setParking(rs.getBoolean(14));
				h.setRecomendado(rs.getBoolean(15));
				h.setDescuento(rs.getInt(16));
				hs.add(h);
			}
			statement.close();
			rs.close();
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos Hotel: " + e.getMessage());
			e.printStackTrace();
		}
		return hs;
	}

	public boolean eliminarHoteles(String[] hotelesId) {
		boolean eliminar = false;
		String sql = "DELETE FROM hotel WHERE id in (?)";
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			java.sql.Array array = conn.createArrayOf("VARCHAR", hotelesId);
			ps.setArray(1, array);
			ps.execute();
			ps.close();
			eliminar = true;
			System.out.println("Hotel eliminado");
		} catch (SQLException e) {
			System.out.println("Error: método eliminar");
			e.printStackTrace();
		}
		return eliminar;
	}

	public boolean modificarVehiculos(Hotel vehiculo) {
		boolean actualizar = false;
		String sqlUpdate = "UPDATE vehiculo SET matricula = ?, marca = ?, modelo = ?, año = ?, color = ? WHERE matricula = ?";
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			ps.setString(1, vehiculo.getMatricula());
			ps.setString(2, vehiculo.getMarca());
			ps.setString(3, vehiculo.getModelo());
			ps.setInt(4, vehiculo.getAño());
			ps.setString(5, vehiculo.getColor());
			ps.setString(6, vehiculo.getMatricula());
			ps.execute();
			ps.close();
			actualizar = true;
			System.out.println("Vehículo actualizado.");
		} catch (SQLException e) {
			System.out.println("Error: método actualizar");
			e.printStackTrace();
		}
		return actualizar;
	}

	// en la app en el main es cuando debería cerrarse conn, no en cada método creo.
	public static void main(String args[]) {
//        Vehiculo v = new Vehiculo("JK987PJ", "Hyundai", "Kona", 2019, "azul");
		HotelesDAO vs = new HotelesDAO();
		// System.out.println(vs.buscarPorMatricula("JK987PJ"));
//		System.out.println(vs.buscarPorMarcaOModelo("Hyundai"));
//		System.out.println(vs.buscarPorMarcaModeloOAño("Hyundai"));
//		System.out.println(vs.buscarPorMarcaModeloOAño("2019"));
////        List<Vehiculo> vlist = vs.verVehiculos();
//        vlist.stream().map(f->f.toString()).collect(Collectors.toList());
		// System.out.println(vlist.stream().map(f->f.toString()).collect(Collectors.toList()));
		OpHoteles opv = new OpHoteles();
		for (Hotel v : opv.verVehiculos()) {
			vs.insertarVehiculos(v);
		}
		vs.verVehiculos();
	}
}
