package Beans;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String hotel;
	private Date fecha;
	private Time hora;
	private boolean cancelada;
	private boolean completada;
	private double totalReserva;
	public Reserva() {
	}
	public Reserva(String usuario, String hotel, Date fecha, Time hora, boolean cancelada, boolean completada,
			double totalReserva) {
		super();
		this.usuario = usuario;
		this.hotel = hotel;
		this.fecha = fecha;
		this.hora = hora;
		this.cancelada = cancelada;
		this.completada = completada;
		this.totalReserva = totalReserva;
	}
	
	public Reserva(String usuario, String hotel, Date fecha, Time hora, double totalReserva) {
		super();
		this.usuario = usuario;
		this.hotel = hotel;
		this.fecha = fecha;
		this.hora = hora;
		this.totalReserva = totalReserva;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public boolean isCancelada() {
		return cancelada;
	}
	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}
	public boolean isCompletada() {
		return completada;
	}
	public void setCompletada(boolean completada) {
		this.completada = completada;
	}
	public double getTotalReserva() {
		return totalReserva;
	}
	public void setTotalReserva(double totalReserva) {
		this.totalReserva = totalReserva;
	}
	@Override
	public String toString() {
		return "Reserva [usuario=" + usuario + ", hotel=" + hotel + ", fecha=" + fecha + ", hora=" + hora
				+ ", cancelada=" + cancelada + ", completada=" + completada + ", totalReserva=" + totalReserva + "]";
	}
}
