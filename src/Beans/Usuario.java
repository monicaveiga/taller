package Beans;

import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String contraseña;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String paisResidencia;
	private Date fechaNacimiento;

	public Usuario() {
	}
	public Usuario(String email, String nombre, String apellidos, Date fechaNacimiento,
			String direccion, String paisResidencia) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.paisResidencia = paisResidencia;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPaisResidencia() {
		return paisResidencia;
	}
	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", contraseña=" + contraseña + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", direccion=" + direccion + ", paisResidencia=" + paisResidencia + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}

}