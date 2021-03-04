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

	public void insertarHotel(Hotel hotel) {
		try {
			this.conn = DBConnection.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO vehiculo VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?)");
			ps.setString(1, hotel.getNombre());
			ps.setString(2, hotel.getDireccion());
			ps.setString(3, hotel.getCiudad());
			ps.setString(4, hotel.getRegion());
			ps.setString(5, hotel.getDescripcion());
			ps.setString(6, hotel.getImgD());
			ps.setString(7, hotel.getImgH());
			ps.setDouble(8, hotel.getPrecio());
			ps.setShort(9, hotel.getEstrellas());
			ps.setBoolean(10, hotel.isPiscina());
			ps.setBoolean(11, hotel.isSpa());
			ps.setBoolean(12, hotel.isWifi());
			ps.setBoolean(13, hotel.isParking());
			ps.setBoolean(14, hotel.isRecomendado());
			ps.setInt(15, hotel.getDescuento());
			ps.execute();
			ps.close();
			System.out.println("Hotel añadido con éxito");
		} catch (SQLException e) {
			System.out.println("Error al añadir hotel" + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Hotel> buscarHotelesConFiltros(String[] filters) {
		  String sql = "SELECT * FROM hotel WHERE ";
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
			System.out.println("Error en la base de datos hotel: " + e.getMessage());
			e.printStackTrace();
		}
		return vs;
	}

	public List<Hotel> verHoteles() {
		  String sql = "SELECT * FROM hotel";
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

	public void modificarHotel(Hotel hotel) {
		String sqlUpdate = "UPDATE vehiculo SET matricula = ?, marca = ?, modelo = ?, año = ?, color = ? WHERE matricula = ?";
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			ps.setString(1, hotel.getNombre());
			ps.setString(2, hotel.getDireccion());
			ps.setString(3, hotel.getCiudad());
			ps.setString(4, hotel.getRegion());
			ps.setString(5, hotel.getDescripcion());
			ps.setString(6, hotel.getImgD());
			ps.setString(7, hotel.getImgH());
			ps.setDouble(8, hotel.getPrecio());
			ps.setShort(9, hotel.getEstrellas());
			ps.setBoolean(10, hotel.isPiscina());
			ps.setBoolean(11, hotel.isSpa());
			ps.setBoolean(12, hotel.isWifi());
			ps.setBoolean(13, hotel.isParking());
			ps.setBoolean(14, hotel.isRecomendado());
			ps.setInt(15, hotel.getDescuento());
			ps.execute();
			ps.close();
			System.out.println("Hotel modificado con éxito");
		} catch (SQLException e) {
			System.out.println("Error al modificar hotel" + e.getMessage());
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		HotelesDAO hoteles = new HotelesDAO();
		OpHoteles opv = new OpHoteles();
		for (Hotel h : opv.verVehiculos()) {
			hoteles.insertarHotel(h);
		}
		hoteles.verHoteles();
	}
}
