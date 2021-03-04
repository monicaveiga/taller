package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Usuario;

public class UsuariosDAO {

	private Connection conn = null;

	public void insertarClientes(Usuario cliente) {
		try {
			this.conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO cliente VALUES (?, ?, ?, ?)");
			ps.setString(1, cliente.getEmail());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDireccion());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al añadir cliente" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Cliente añadido con éxito");
	}

	public Usuario consultarPorDNI(String email) {
		Usuario clte = null;
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM usuario WHERE email = " + "'" + email + "'");
			while (res.next()) {
				clte = new Usuario(res.getString("email"), res.getString("nombre"), res.getString("apellidos"),
						res.getDate("fechaNacimiento"), res.getString("direccion"), res.getString("paisResidencia"));
			}
			res.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos ClientesDAO: " + e.getMessage());
			e.printStackTrace();
		}
		return clte;
	}

	public List<Usuario> consultarPorNombreYApellidos(String nombreYApellidos) {
		Statement stm = null;
		ResultSet rs = null;
//		String sql = "SELECT * FROM cliente WHERE CONCAT(`nombre`," + "' " + "'"
//				+ ",`apellidos`) = " + "'" + nombre + "'"+"' "+"'"+"'"+ apellidos+ "'";
		String sql = "SELECT * FROM cliente WHERE CONCAT(`nombre`," + "' " + "'" + ",`apellidos`) = " + "'"
				+ nombreYApellidos + "'";
		List<Usuario> cltes = new ArrayList<Usuario>();
		try {
			this.conn = DBConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Usuario c = new Usuario();
				c.setEmail(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setApellidos(rs.getString(3));
				c.setFechaNacimiento(rs.getDate(4));
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

	public List<Usuario> cltesOrdenadosPorEdad() {
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM cliente ORDER BY edad";
		List<Usuario> cltes = new ArrayList<Usuario>();
		try {
			this.conn = DBConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
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
			e.printStackTrace();
		}
		return cltes;
	}

	public List<Usuario> verClientes() {
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM cliente ORDER BY Apellidos";
		List<Usuario> cltes = new ArrayList<Usuario>();
		try {
			this.conn = DBConnection.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
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

	public boolean modificar(Usuario cliente) {
		boolean actualizar = false;
		try {
			conn = DBConnection.getConnection();
			// PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps = conn
					.prepareStatement("UPDATE usuario SET email = ?, nombre = ?, apellidos = ?, direccion = ? WHERE email = ?");
			ps.setString(1, cliente.getEmail());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDireccion());
			ps.setString(5, cliente.getEmail());
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
		UsuariosDAO cltes = new UsuariosDAO();
//		System.out.println(cltes.consultarPorNombreYApellidos("Jimena López López"));
		System.out.println(cltes.cltesOrdenadosPorEdad());
//		cltes.consultarPorDNI("22222222L");
		// System.out.println(cltes.verClientes());
//		List<Cliente> clist = cltes.verClientes();
//		clist.stream().map(f -> f.toString()).collect(Collectors.toList());
//		System.out.println(clist.stream().map(f->f.toString()).collect(Collectors.toList()));
	}

}
