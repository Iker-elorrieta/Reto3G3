package Modelo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Entrada {
	private String codigoEntrada;
	private float precio;
	private String codigoSesion;
	private String dni;
	//private int horario; no poner hora (sacarla del date)
	//sala y pelicula se sacan con las fk de las otros obj
	private Cliente[] arrayCliente;
	
	
	public Entrada(String codigoEntrada, float precio, String codigoSesion, String dni) {
		super();
		this.codigoEntrada = codigoEntrada;
		this.precio = precio;
		this.codigoSesion = codigoSesion;
		this.dni = dni;
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
		return Objects.equals(codigoEntrada, other.codigoEntrada) && Objects.equals(codigoSesion, other.codigoSesion)
				&& Objects.equals(dni, other.dni) && Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio);
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
	
	
	

	
}
