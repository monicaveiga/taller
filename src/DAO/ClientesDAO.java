package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Cliente;
import operaciones.OpClientes;

public class ClientesDAO {

	private Connection conn = null;

	public void insertarClientes(Cliente cliente) {
		try {
			this.conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO cliente VALUES (?, ?, ?, ?)");
			ps.setString(1, cliente.getDNI());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setInt(4, cliente.getEdad());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al añadir cliente" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Cliente añadido con éxito");
	}

	public Cliente consultarPorDNI(String dni) {
		Cliente clte = null;
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM cliente WHERE dni = " + "'" + dni + "'");
			while (res.next()) {
				clte = new Cliente(res.getString("DNI"), res.getString("nombre"), res.getString("apellidos"),
						res.getInt("edad"));
			}
			System.out.println(clte);
			res.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos ClientesDAO: " + e.getMessage());
			e.printStackTrace();
		}
		return clte;
	}

	public List<Cliente> consultarPorNombreYApellidos(String nombreYApellidos) {
		Statement stm = null;
		ResultSet rs = null;
//		String sql = "SELECT * FROM cliente WHERE CONCAT(`nombre`," + "' " + "'"
//				+ ",`apellidos`) = " + "'" + nombre + "'"+"' "+"'"+"'"+ apellidos+ "'";
		String sql = "SELECT * FROM cliente WHERE CONCAT(`nombre`," + "' " + "'"
				+ ",`apellidos`) = " + "'" + nombreYApellidos + "'";
		List<Cliente> cltes = new ArrayList<Cliente>();
		try {
			this.conn = DBConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setDNI(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setApellidos(rs.getString(3));
				c.setEdad(rs.getInt(4));
				cltes.add(c);
			}
			stm.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cltes;
	}
	public List<Cliente> cltesOrdenadosPorEdad() {
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM cliente ORDER BY edad";
		List<Cliente> cltes = new ArrayList<Cliente>();
		try {
			this.conn = DBConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setDNI(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setApellidos(rs.getString(3));
				c.setEdad(rs.getInt(4));
				cltes.add(c);
			}
			stm.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cltes;
	}
	public List<Cliente> verClientes() {
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM cliente ORDER BY Apellidos";
		List<Cliente> cltes = new ArrayList<Cliente>();
		try {
			this.conn = DBConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setDNI(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setApellidos(rs.getString(3));
				c.setEdad(rs.getInt(4));
				cltes.add(c);
			}
			stm.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cltes;
	}

	public boolean eliminar(String dni) {
		boolean eliminar = false;
		String sql = "DELETE FROM cliente WHERE DNI = ?";
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dni);
			ps.execute();
			ps.close();
			eliminar = true;
			System.out.println("Cliente eliminado");
		} catch (SQLException e) {
			System.out.println("Error: método eliminar");
			e.printStackTrace();
		}
		return eliminar;
	}

	public boolean modificar(Cliente cliente) {
		boolean actualizar = false;
		try {
			conn = DBConnection.getConnection();
			// PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps = conn
					.prepareStatement("UPDATE cliente SET DNI = ?, nombre = ?, apellidos = ?, edad = ? WHERE DNI = ?");
			ps.setString(1, cliente.getDNI());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setInt(4, cliente.getEdad());
			ps.setString(5, cliente.getDNI());
			ps.execute();
			ps.close();
			actualizar = true;
		} catch (SQLException e) {
			System.out.println("Error: método actualizar");
			e.printStackTrace();
		}
		return actualizar;
	}

	// en la app en el main es cuando debería cerrarse conn, no en cada método creo.
	public static void main(String args[]) {
		ClientesDAO cltes = new ClientesDAO();
//		System.out.println(cltes.consultarPorNombreYApellidos("Jimena López López"));
		System.out.println(cltes.cltesOrdenadosPorEdad());
//		cltes.consultarPorDNI("22222222L");
		//System.out.println(cltes.verClientes());
//		List<Cliente> clist = cltes.verClientes();
//		clist.stream().map(f -> f.toString()).collect(Collectors.toList());
//		System.out.println(clist.stream().map(f->f.toString()).collect(Collectors.toList()));
	}

}
