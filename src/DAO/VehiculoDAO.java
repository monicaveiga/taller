package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Vehiculo;

public class VehiculoDAO {

    private Connection conn = null;

    public void insertarVehiculos(Vehiculo vehiculo) {
        try {
            this.conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO vehiculo VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, vehiculo.getMatricula());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getAño());
            ps.setString(5, vehiculo.getColor());
            ps.execute();
            ps.close();
            System.out.println("Vehiculo añadido con éxito");
        } catch (SQLException e) {
            System.out.println("Error al añadir vehículo" + e.getMessage());
            e.printStackTrace();
        }
    }
    public Vehiculo buscarPorMatricula(String matricula){
        Vehiculo v = null;
        try {
            this.conn= DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM vehiculo WHERE matricula = " + "'"+matricula+"'");
            while(res.next()) {
                v = new Vehiculo(res.getString("matricula"), res.getString("marca"), res.getString("modelo"), res.getInt("año"), res.getString("color"));
            }
            res.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error en la base de datos ClientesDAO: " + e.getMessage());
            e.printStackTrace();
        }
        return v;
    }
    public Vehiculo buscarPorMarcaOModelo(String marcaOModelo){
        Vehiculo v = null;
        try {
            this.conn= DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM vehiculo WHERE marca = " + "'"+marcaOModelo+"'"+" OR modelo = "+ "'"+marcaOModelo+"'");
            while(res.next()) {
                v = new Vehiculo(res.getString("matricula"), res.getString("marca"), res.getString("modelo"), res.getInt("año"), res.getString("color"));
            }
            res.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error en la base de datos ClientesDAO: " + e.getMessage());
            e.printStackTrace();
        }
        return v;
    }
    public Vehiculo buscarPorMarcaModeloOAño(String marcaOModelo, int... año){
        marcaOModelo = marcaOModelo != null ? marcaOModelo : "";
        Vehiculo v = null;
        try {
            this.conn= DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet res=null;
            if(marcaOModelo.length()>0) {
               res = statement.executeQuery("SELECT * FROM vehiculo WHERE marca = " + "'" + marcaOModelo + "'" + " OR modelo = " + "'" + marcaOModelo + "'");
            }else if (año.length>=1){
                res = statement.executeQuery("SELECT * FROM vehiculo WHERE año = " + año);
            }
                while (res.next()) {
                    v = new Vehiculo(res.getString("matricula"), res.getString("marca"), res.getString("modelo"), res.getInt("año"), res.getString("color"));
                }
            res.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error en la base de datos ClientesDAO: " + e.getMessage());
            e.printStackTrace();
        }
        return v;
    }
    public List<Vehiculo> verVehiculos() {
        Statement stm= null;
        ResultSet rs=null;
        String sql="SELECT * FROM vehiculo ORDER BY matricula";
        List<Vehiculo> vs= new ArrayList<Vehiculo>();
        try {
            this.conn= DBConnection.getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Vehiculo v=new Vehiculo();
                v.setMatricula(rs.getString(1));
                v.setMarca(rs.getString(2));
                v.setModelo(rs.getString(3));
                v.setAño(rs.getInt(4));
                v.setColor(rs.getString(5));
                vs.add(v);
            }
            stm.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error:método obtener");
            e.printStackTrace();
        }

        return vs;
    }
    public boolean eliminarVehiculos(String matricula) {
        boolean eliminar=false;
        String sql="DELETE FROM vehiculo WHERE matricula = ?";
        try {
            conn=DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, matricula);
            ps.execute();
            ps.close();
            eliminar=true;
            System.out.println("Cliente eliminado");
        } catch (SQLException e) {
            System.out.println("Error: método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
    public boolean modificarVehiculos(Vehiculo vehiculo) {
        boolean actualizar=false;
        try {
            conn=DBConnection.getConnection();
            //PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps = conn.prepareStatement("UPDATE vehiculo SET matricula = ?, marca = ?, modelo = ?, año = ?, color = ? WHERE matricula = ?");
            ps.setString(1, vehiculo.getMatricula());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getAño());
            ps.setString(5, vehiculo.getColor());
            ps.setString(6, vehiculo.getMatricula());
            ps.execute();
            ps.close();
            actualizar=true;
            System.out.println("Vehículo actualizado.");
        } catch (SQLException e) {
            System.out.println("Error: método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    //en la app en el main es cuando debería cerrarse conn, no en cada método creo.
    public static void main(String args[]) {
//        Vehiculo v = new Vehiculo("JK987PJ", "Hyundai", "Kona", 2019, "azul");
        VehiculoDAO vs = new VehiculoDAO();
        //System.out.println(vs.buscarPorMatricula("JK987PJ"));
        System.out.println(vs.buscarPorMarcaOModelo("Hyundai"));
        System.out.println(vs.buscarPorMarcaModeloOAño("Hyundai"));
        System.out.println(vs.buscarPorMarcaModeloOAño("2019"));
//        List<Vehiculo> vlist = vs.verVehiculos();
//        vlist.stream().map(f->f.toString()).collect(Collectors.toList());
        //System.out.println(vlist.stream().map(f->f.toString()).collect(Collectors.toList()));
    }
}
