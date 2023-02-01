package Modelo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Entrada {
	private String codigoEntrada;
	private Date fecha;
	//private int horario; no poner hora (sacarla del date)
	private String sala;
	private String pelicula;
	
	public Entrada(String codigoEntrada, Date fecha, String sala, String pelicula) {
		this.codigoEntrada = codigoEntrada;
		this.fecha = fecha;
		this.sala = sala;
		this.pelicula = pelicula;
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


	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		
		return "Entrada [codigoEntrada=" + codigoEntrada + ", fecha=" + dt.format(fecha) + ", sala=" + sala + ", pelicula="
				+ pelicula + "]";
	}


	public String getCodigoEntrada() {
		return codigoEntrada;
	}
	public Date getFecha() {
		return fecha;
	}
	public String getSala() {
		return sala;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setCodigoEntrada(String codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	
}
