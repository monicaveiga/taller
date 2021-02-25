package Beans;
import java.io.Serializable;

public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String matricula;
    private String marca;
    private String modelo;
    private int año;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, String modelo, int año, String color) {
        super();
        this.modelo=modelo;
        this.matricula = matricula;
        this.marca = marca;
        this.año = año;
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "\nVehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", año=" + año
                + ", color=" + color + "]\n";
    }
}
