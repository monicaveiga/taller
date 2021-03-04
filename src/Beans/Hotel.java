package Beans;
import java.io.Serializable;

public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String region;
    private String descripcion;
    private String imgD;
    private String imgH;
    private double puntuacion;
    private double precio;
    private short estrellas;
    private boolean piscina;
    private boolean spa;
    private boolean wifi;
    private boolean parking;
    private boolean recomendado;
    private  int descuento;

    public Hotel() {
    }

	public Hotel(int id, String nombre, String direccion, String ciudad, String region, String descripcion, String imgD,
			String imgH, double puntuacion, double precio, short estrellas, boolean piscina, boolean spa, boolean wifi,
			boolean parking, boolean recomendado, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.region = region;
		this.descripcion = descripcion;
		this.imgD = imgD;
		this.imgH = imgH;
		this.puntuacion = puntuacion;
		this.precio = precio;
		this.estrellas = estrellas;
		this.piscina = piscina;
		this.spa = spa;
		this.wifi = wifi;
		this.parking = parking;
		this.recomendado = recomendado;
		this.descuento = descuento;
	}

	public Hotel(int id, String nombre, String direccion, String ciudad, String region, String descripcion, String imgD,
			String imgH, double precio, short estrellas, boolean piscina, boolean spa, boolean wifi, boolean parking,
			boolean recomendado, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.region = region;
		this.descripcion = descripcion;
		this.imgD = imgD;
		this.imgH = imgH;
		this.precio = precio;
		this.estrellas = estrellas;
		this.piscina = piscina;
		this.spa = spa;
		this.wifi = wifi;
		this.parking = parking;
		this.recomendado = recomendado;
		this.descuento = descuento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImgD() {
		return imgD;
	}

	public void setImgD(String imgD) {
		this.imgD = imgD;
	}

	public String getImgH() {
		return imgH;
	}

	public void setImgH(String imgH) {
		this.imgH = imgH;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public short getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(short estrellas) {
		this.estrellas = estrellas;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public boolean isSpa() {
		return spa;
	}

	public void setSpa(boolean spa) {
		this.spa = spa;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isRecomendado() {
		return recomendado;
	}

	public void setRecomendado(boolean recomendado) {
		this.recomendado = recomendado;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad
				+ ", region=" + region + ", descripcion=" + descripcion + ", imgD=" + imgD + ", imgH=" + imgH
				+ ", puntuacion=" + puntuacion + ", precio=" + precio + ", estrellas=" + estrellas + ", piscina="
				+ piscina + ", spa=" + spa + ", wifi=" + wifi + ", parking=" + parking + ", recomendado=" + recomendado
				+ ", descuento=" + descuento + "]";
	}
}
