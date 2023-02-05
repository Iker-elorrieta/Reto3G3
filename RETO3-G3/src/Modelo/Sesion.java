package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Sesion {
	private String codigoSesion;
	private Date hora;
	private Date fecha;
	private String codigoPelicula;
	private String codigoSala;
	private Pelicula[] arrayPeliculas;
	private Sala[] arraySalas;
	private Entrada[] arrayEntradas;
	
	

	public Sesion(String codigoSesion, Date hora, Date fecha, String codigoPelicula, String codigoSala,
			Pelicula[] arrayPeliculas, Sala[] arraySalas, Entrada[] arrayEntradas) {
		super();
		this.codigoSesion = codigoSesion;
		this.hora = hora;
		this.fecha = fecha;
		this.codigoPelicula = codigoPelicula;
		this.codigoSala = codigoSala;
		this.arrayPeliculas = arrayPeliculas;
		this.arraySalas = arraySalas;
		this.arrayEntradas = arrayEntradas;
	}





	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		return "Sesion [codigoSesion=" + codigoSesion + ", hora=" + dt2.format(hora) + ", fecha=" + dt.format(fecha) + ", codigoPelicula="
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
		return Objects.equals(codigoSesion, other.codigoSesion);
	}
	
	
	
	
	
	public String getCodigoSesion() {
		return codigoSesion;
	}
	public Date getHora() {
		return hora;
	}
	public Date getFecha() {
		return fecha;
	}
	public String getCodigoPelicula() {
		return codigoPelicula;
	}
	public String getCodigoSala() {
		return codigoSala;
	}
	public Pelicula[] getArrayPeliculas() {
		return arrayPeliculas;
	}
	public Sala[] getArraySalas() {
		return arraySalas;
	}
	public Entrada[] getArrayEntradas() {
		return arrayEntradas;
	}
	public void setCodigoSesion(String codigoSesion) {
		this.codigoSesion = codigoSesion;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setCodigoPelicula(String codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}
	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}
	public void setArrayPeliculas(Pelicula[] arrayPeliculas) {
		this.arrayPeliculas = arrayPeliculas;
	}
	public void setArraySalas(Sala[] arraySalas) {
		this.arraySalas = arraySalas;
	}
	public void setArrayEntradas(Entrada[] arrayEntradas) {
		this.arrayEntradas = arrayEntradas;
	}
	

	
	
	
	
	
	
	
}
