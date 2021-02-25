package Beans;
import java.io.Serializable;
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private String DNI;
    private String Nombre;
    private String Apellidos;
    private int edad;
    public Cliente() {}
    public Cliente(String dNI, String nombre, String apellidos, int edad) {
        super();
        this.DNI = dNI;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.edad = edad;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "\nCliente [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", edad=" + edad + "]\n";
    }
}