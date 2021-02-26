package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import Beans.Reparacion;

public class ReparacionDAO {

    private Connection conn = null;

    public void insertarReparacion(Reparacion reparacion) {
        try {
            this.conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO reparacion VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, reparacion.getCliente());
            ps.setString(2, reparacion.getVehiculo());
            ps.setString(3, reparacion.getDescripcion());
            ps.setDate(4, reparacion.getFecha());
            ps.setTime(5, reparacion.getTiempo());
            ps.setDouble(6, reparacion.getTotalReparacion());
            ps.execute();
            ps.close();
            System.out.println("Reparacion a�adida con �xito");
        } catch (SQLException e) {
            System.out.println("Error al a�adir reparacion" + e.getMessage());
            e.printStackTrace();
        }
    }
    public List<Reparacion> buscarPorCliente(String cliente){
    	String sql = "SELECT * FROM reparacion WHERE cliente = " + "'" + cliente + "'" + " ORDER BY fecha";
		List<Reparacion> reparaciones = new ArrayList<Reparacion>();
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reparacion r = new Reparacion();
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
    public List<Reparacion> buscarPorVehiculo(String vehiculo){
    	String sql = "SELECT * FROM reparacion WHERE vehiculo = " + "'" + vehiculo + "'" + " ORDER BY fecha";
		List<Reparacion> reparaciones = new ArrayList<Reparacion>();
		try {
			this.conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reparacion r = new Reparacion();
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
    public List<Reparacion> buscarPorFecha(String fecha){
            String sql = "SELECT * FROM reparacion WHERE fecha = " + "'"+Date.valueOf(fecha)+"'" + " ORDER BY fecha";
    		List<Reparacion> reparaciones = new ArrayList<Reparacion>();
    		try {
    			this.conn = DBConnection.getConnection();
    			Statement statement = conn.createStatement();
    			ResultSet rs = statement.executeQuery(sql);
    			while (rs.next()) {
    				Reparacion r = new Reparacion();
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
    public List<Reparacion> verReparaciones() {
        Statement stm= null;
        ResultSet rs=null;
        String sql="SELECT * FROM reparacion ORDER BY vehiculo";
        List<Reparacion> reparacion= new ArrayList<Reparacion>();
        try {
            this.conn= DBConnection.getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Reparacion r=new Reparacion();
                r.setCliente(rs.getString(1));
                r.setVehiculo(rs.getString(2));
                r.setDescripcion(rs.getString(3));
                r.setFecha(rs.getDate(4));
                r.setTiempo(rs.getTime(5));
                r.setTotalReparacion(rs.getDouble(6));
                reparacion.add(r);
            }
            stm.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error:m�todo obtener");
            e.printStackTrace();
        }
        return reparacion;
    }
    public boolean eliminarReparacion(Reparacion reparacion) {
        boolean eliminar=false;
        String sql="DELETE FROM reparacion WHERE vehiculo = ?";
        try {
            conn=DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, reparacion.getVehiculo());
            ps.execute();
            ps.close();
            eliminar=true;
            System.out.println("reparacion eliminada");
        } catch (SQLException e) {
            System.out.println("Error: m�todo eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
    public boolean modificarReparacion(Reparacion reparacion) {
        boolean actualizar=false;
        try {
            conn=DBConnection.getConnection();
            //PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps = conn.prepareStatement("UPDATE reparacion SET cliente = ?, vehiculo = ?, descripcion = ?, fecha = ?, tiempo = ?, totalReparacion = ? WHERE vehiculo = ?");
            ps.setString(1, reparacion.getCliente());
            ps.setString(2, reparacion.getVehiculo());
            ps.setString(3, reparacion.getDescripcion());
            ps.setDate(4, reparacion.getFecha());
            ps.setTime(5, reparacion.getTiempo());
            ps.setDouble(6, reparacion.getTotalReparacion());
            ps.setString(7, reparacion.getVehiculo());
            ps.execute();
            ps.close();
            actualizar=true;
            System.out.println("Reparacion actualizada.");
        } catch (SQLException e) {
            System.out.println("Error: m�todo actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    //en la app en el main es cuando deber�a cerrarse conn, no en cada m�todo creo.
    public static void main(String args[]) {
        Reparacion r = new Reparacion("22222222L", "JK987PJ", "Faro fundido", Date.valueOf("2021-02-24"), Time.valueOf("12:00:00"), 150);
        ReparacionDAO re = new ReparacionDAO();
        re.insertarReparacion(r);
        //re.eliminarReparacion(r);
        //re.modificarReparacion(r);
        //System.out.println(re.buscarPorCliente("22222222L"));
        //System.out.println(re.buscarPorVehiculo("JK987PJ"));
        //System.out.println(re.buscarPorFecha("2021-02-24"));
//        List<Reparacion> rlist = re.verReparaciones();
//        rlist.stream().map(f->f.toString()).collect(Collectors.toList());
        //System.out.println(rlist.stream().map(f->f.toString()).collect(Collectors.toList()));
    }
}
