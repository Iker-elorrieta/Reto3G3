package Modelo;


import java.util.Objects;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private String sexo;
	private String contrasena;
	private Entrada[] arrayEntrada;
	
	
	public Cliente(String dni, String nombre, String apellidos, String sexo, String contrasena,
			Entrada[] arrayEntrada) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.contrasena = contrasena;
		this.arrayEntrada = arrayEntrada;
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
				+ ", contrasena=" + contrasena + "]";
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
	public String getContrasena() {
		return contrasena;
	}
	public Entrada[] getArrayEntrada() {
		return arrayEntrada;
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
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public void setArrayEntrada(Entrada[] arrayEntrada) {
		this.arrayEntrada = arrayEntrada;
	}
	
	
	
	
	
	
	
	
}
