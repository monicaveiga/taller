package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    public static final String USER = "alumnos";
    public static final String PASS = "abc123..";
    public static final String URL= "jdbc:mariadb://192.168.1.203/taller";
//    private static Connection conn = null;

    /**
     * Establece conexion con la base de datos taller
     * @return una conexión con la base de datos taller
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            /*if (conn != null) {
                System.out.println("Conectado!");
            }*/
        } catch (SQLException e) {
            System.out.println("Problema al establecer la conexion: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println( "Excepción de Driver: " + e.getMessage() + ", "+e.getClass().getName() );
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
