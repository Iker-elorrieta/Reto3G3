package Modelo;


import java.util.Objects;

public class Entrada {
	private String codigoEntrada;
	private float precio;
	private String codigoSesion;
	private String dni;
	private Cliente[] arrayCliente;
	private Sesion[] arraySesiones;
	
	
	
	

	public Entrada(String codigoEntrada, float precio, String codigoSesion, String dni, Cliente[] arrayCliente,
			Sesion[] arraySesiones) {
		super();
		this.codigoEntrada = codigoEntrada;
		this.precio = precio;
		this.codigoSesion = codigoSesion;
		this.dni = dni;
		this.arrayCliente = arrayCliente;
		this.arraySesiones = arraySesiones;
	}



	
	
	@Override
	public String toString() {
		return "Entrada [codigoEntrada=" + codigoEntrada + ", precio=" + precio + ", codigoSesion=" + codigoSesion
				+ ", dni=" + dni + "]";
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(codigoEntrada, other.codigoEntrada);
	}
	
	
	
	public String getCodigoEntrada() {
		return codigoEntrada;
	}
	public float getPrecio() {
		return precio;
	}
	public String getCodigoSesion() {
		return codigoSesion;
	}
	public String getDni() {
		return dni;
	}
	public Cliente[] getArrayCliente() {
		return arrayCliente;
	}
	public Sesion[] getArraySesiones() {
		return arraySesiones;
	}
	public void setCodigoEntrada(String codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void setCodigoSesion(String codigoSesion) {
		this.codigoSesion = codigoSesion;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setArrayCliente(Cliente[] arrayCliente) {
		this.arrayCliente = arrayCliente;
	}
	public void setArraySesiones(Sesion[] arraySesiones) {
		this.arraySesiones = arraySesiones;
	}

	
	
	
	
	
	
	
	
	
	
	
}
