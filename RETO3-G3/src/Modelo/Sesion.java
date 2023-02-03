package Modelo;

import java.util.Objects;

public class Sesion {
	private String codigoSesion;
	private String hora;
	private String fecha;
	private String codigoPelicula;
	private String codigoSala;
	
	private Pelicula[] arrayPeliculas;
	private Sala[] arraySalas;
	private Entrada[] arrayEntradas;
	
	public Sesion(String codigoSesion, String hora, String fecha, String codigoPelicula, String codigoSala) {
		super();
		this.codigoSesion = codigoSesion;
		this.hora = hora;
		this.fecha = fecha;
		this.codigoPelicula = codigoPelicula;
		this.codigoSala = codigoSala;
	}


	@Override
	public String toString() {
		return "Sesion [codigoSesion=" + codigoSesion + ", hora=" + hora + ", fecha=" + fecha + ", codigoPelicula="
				+ codigoPelicula + ", codigoSala=" + codigoSala + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesion other = (Sesion) obj;
		return Objects.equals(codigoPelicula, other.codigoPelicula) && Objects.equals(codigoSala, other.codigoSala)
				&& Objects.equals(codigoSesion, other.codigoSesion) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora);
	}

	public String getCodigoSesion() {
		return codigoSesion;
	}
	public String getHora() {
		return hora;
	}
	public String getFecha() {
		return fecha;
	}
	public String getCodigoPelicula() {
		return codigoPelicula;
	}
	public String getCodigoSala() {
		return codigoSala;
	}
	public void setCodigoSesion(String codigoSesion) {
		this.codigoSesion = codigoSesion;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setCodigoPelicula(String codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}
	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}
	
	
	
	
	
	
	
}
