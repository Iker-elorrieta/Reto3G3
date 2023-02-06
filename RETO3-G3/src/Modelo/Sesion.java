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
	private Sala xSala;
	
	

	public Sesion(String codigoSesion, Date fecha, Pelicula xPelicula, Sala xSala) {
		super();
		this.codigoSesion = codigoSesion;
		this.fecha = fecha;
		this.xPelicula = xPelicula;
		this.xSala = xSala;
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
	public Sala getArraySalas() {
		return xSala;
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
	public void setArraySalas(Sala xSala) {
		this.xSala = xSala;
	}
	

	
	
	
	
	
	
	
}
