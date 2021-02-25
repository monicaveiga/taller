package Beans;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Reparacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cliente;
	private String vehiculo;
	private String descripcion;
	private Date fecha;
	private Time tiempo;
	private double totalReparacion;

	public Reparacion() {
	}

	public Reparacion(String cliente, String vehiculo, String descripcion, Date fecha, Time tiempo,
			double totalReparacion) {
		super();
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.tiempo = tiempo;
		this.totalReparacion = totalReparacion;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getTiempo() {
		return tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}

	public double getTotalReparacion() {
		return totalReparacion;
	}

	public void setTotalReparacion(double totalReparacion) {
		this.totalReparacion = totalReparacion;
	}

	@Override
	public String toString() {
		return "\nReparacion [cliente=" + cliente + ", vehiculo=" + vehiculo + ", descripcion=" + descripcion
				+ ", fecha=" + fecha + ", tiempo=" + tiempo + ", totalReparacion=" + totalReparacion + "]\n";
	}
}
