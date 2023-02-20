package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Sesion {
	private String codigoSesion;
	//private Date hora;
	private Date fecha;
	private Date fechaFin;
	private Pelicula xPelicula;
	private float precio;
	
	

	public Sesion(String codigoSesion, Date fecha, Date fechaFin, Pelicula xPelicula, float precio) {
		super();
		this.codigoSesion = codigoSesion;
		this.fecha = fecha;
		this.fechaFin = fechaFin;
		this.xPelicula = xPelicula;
		this.precio = precio;
	}

	public Sesion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		return "Sesion [codigoSesion=" + codigoSesion + ", hora=" + dt2.format(fecha) + ", fecha=" + dt.format(fecha) + ", fechaFin=" + dt.format(fechaFin) + "]";
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

	public Date getFecha() {
		return fecha;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public Pelicula getxPelicula() {
		return xPelicula;
	}

	public void setCodigoSesion(String codigoSesion) {
		this.codigoSesion = codigoSesion;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setxPelicula(Pelicula xPelicula) {
		this.xPelicula = xPelicula;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
