package Modelo;

import java.util.Objects;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private String sexo;
	private String contraseña;
	
	public Cliente(String dni, String nombre, String apellidos, String sexo, String contraseña) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.contraseña = contraseña;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}


	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo
				+ ", contraseña=" + contraseña + "]";
	}


	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getSexo() {
		return sexo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
	
	
	
}
