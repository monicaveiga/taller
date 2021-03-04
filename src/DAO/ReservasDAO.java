package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Reserva;
import Beans.Usuario;

public class ReservasDAO {

	private Connection conn = null;

	public void insertarReparacion(Reserva reserva) {
		try {
			this.conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reparacion VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, reserva.getUsuario());
			ps.setString(2, reserva.getHotel());
			ps.setDate(4, reserva.getFecha());
			ps.setTime(5, reserva.getHora());
			ps.setDouble(6, reserva.getTotalReserva());
			ps.execute();
			ps.close();
			System.out.println("Reparacion añadida con éxito");
		} catch (SQLException e) {
			System.out.println("Error al añadir reparacion" + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Reserva> buscarPorCliente(String cliente) {
		String sql = "SELECT * FROM reparacion WHERE cliente = " + "'" + cliente + "'" + " ORDER BY fecha";
		List<Reserva> reparaciones = new ArrayList<Reserva>();
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setFecha(Date.valueOf(rs.getString(1)));
				reparaciones.add(r);
			}
			statement.close();
			rs.close();
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos de reservas: " + e.getMessage());
			e.printStackTrace();
		}
		return reparaciones;
	}

	public List<Reserva> buscarPorHotel(String hotel) {
		String sql = "SELECT * FROM reserva WHERE hotel= " + "'" + hotel + "'" + " ORDER BY fecha";
		List<Reserva> reparaciones = new ArrayList<Reserva>();
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setFecha(Date.valueOf(rs.getString(1)));
				reparaciones.add(r);
			}
			statement.close();
			rs.close();
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos ReparacionDAO: " + e.getMessage());
			e.printStackTrace();
		}
		return reparaciones;
	}

	public List<Reserva> buscarPorFecha(String fecha) {
		String sql = "SELECT * FROM reserva WHERE fecha = " + "'" + Date.valueOf(fecha) + "'" + " ORDER BY fecha";
		List<Reserva> reparaciones = new ArrayList<Reserva>();
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setFecha(Date.valueOf(rs.getString(1)));
				reparaciones.add(r);
			}
			statement.close();
			rs.close();
			rs.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos de reservas: " + e.getMessage());
			e.printStackTrace();
		}
		return reparaciones;
	}

	public List<Reserva> verReservas() {
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM reserva ORDER BY hotel";
		List<Reserva> reparacion = new ArrayList<Reserva>();
		try {
			this.conn = DBConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setUsuario(rs.getString(1));
				r.setHotel(rs.getString(2));
				r.setFecha(rs.getDate(4));
				r.setHora(rs.getTime(5));
				r.setTotalReserva(rs.getDouble(6));
				reparacion.add(r);
			}
			stm.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error:método obtener");
			e.printStackTrace();
		}
		return reparacion;
	}

	public boolean eliminarReparacion(Reserva reparacion) {
		boolean eliminar = false;
		String sql = "DELETE FROM reparacion WHERE vehiculo = ?";
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, reparacion.getHotel());
			ps.execute();
			ps.close();
			eliminar = true;
			System.out.println("reparacion eliminada");
		} catch (SQLException e) {
			System.out.println("Error: método eliminar");
			e.printStackTrace();
		}
		return eliminar;
	}

	public boolean modificarReparacion(Reserva reparacion) {
		boolean actualizar = false;
		try {
			conn = DBConnection.getConnection();
			// PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE reparacion SET cliente = ?, vehiculo = ?, descripcion = ?, fecha = ?, tiempo = ?, totalReparacion = ? WHERE vehiculo = ?");
			ps.setString(1, reparacion.getUsuario());
			ps.setString(2, reparacion.getHotel());
			ps.setDate(4, reparacion.getFecha());
			ps.setTime(5, reparacion.getHora());
			ps.setDouble(6, reparacion.getTotalReserva());
			ps.setString(7, reparacion.getHotel());
			ps.execute();
			ps.close();
			actualizar = true;
			System.out.println("Reparacion actualizada.");
		} catch (SQLException e) {
			System.out.println("Error: método actualizar");
			e.printStackTrace();
		}
		return actualizar;
	}

	public List<Usuario> clientesConMasReparaciones() {
		String sqlQuery1 = "SELECT c.*, COUNT(r.cliente) AS NumReparaciones FROM cliente as c LEFT JOIN reparacion as r ON c.dni = r.cliente GROUP BY r.cliente ORDER BY NumReparaciones DESC LIMIT 10";
		Statement stm = null;
		ResultSet rs = null;
		List<Usuario> cltes = new ArrayList<Usuario>();
		try {
			this.conn = DBConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sqlQuery1);
			while (rs.next()) {
				Usuario c = new Usuario();
				c.setEmail(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setApellidos(rs.getString(3));
				c.setDireccion(rs.getString(4));
				cltes.add(c);
			}
			stm.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error:método obtener");
			e.printStackTrace();
		}

		return cltes;
	}

	public Reserva reservaMasBarata() {
		Reserva rep = null;
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery(
					"SELECT* FROM reparacion WHERE totalReparacion=(SELECT MIN(totalReparacion) FROM reparacion)");
			while (res.next()) {
				rep = new Reserva(res.getString("usuario"), res.getString("hotel"),res.getArray("habitaciones"),
						res.getDate("fecha"), res.getTime("hora"), res.getDouble("totalReserva"));
			}
			res.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos Reserva: " + e.getMessage());
			e.printStackTrace();
		}
		return rep;
	}

	public Reserva reparacionMasCostosa() {
		Reserva rep = null;
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery(
					"SELECT* FROM reserva WHERE totalReserva=(SELECT MAX(totalReserva) FROM reserva)");
			while (res.next()) {
				rep = new Reserva(res.getString("usuario"), res.getString("hotel"), res.getArray("habitaciones"),
						res.getDate("fecha"), res.getTime("hora"), res.getDouble("totalReserva"));
			}
			res.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos ReparacionDAO: " + e.getMessage());
			e.printStackTrace();
		}
		return rep;
	}
}
