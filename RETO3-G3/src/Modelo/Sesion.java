package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Sesion {
	private String codigoSesion;
	//private Date hora;
	private Date fecha;
	private Pelicula xPelicula;
	
	

	public Sesion(String codigoSesion, Date fecha, Pelicula xPelicula) {
		super();
		this.codigoSesion = codigoSesion;
		this.fecha = fecha;
		this.xPelicula = xPelicula;
	}

	@Override
	public String toString() {
		DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		return "Sesion [codigoSesion=" + codigoSesion + ", hora=" + dt2.format(fecha) + ", fecha=" + dt.format(fecha) + "]";
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
	public Pelicula getArrayPeliculas() {
		return xPelicula;
	}
	public void setCodigoSesion(String codigoSesion) {
		this.codigoSesion = codigoSesion;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setArrayPeliculas(Pelicula xPelicula) {
		this.xPelicula = xPelicula;
	}
	

	
	
	
	
	
	
	
}
