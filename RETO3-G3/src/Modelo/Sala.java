package Modelo;

import java.util.Objects;

public class Sala {
	private String nombre;
	private String codigoSala;
	//private Pelicula relacionPeliculas;
	
	public Sala(String nombre, String codigoSala) {
		this.nombre = nombre;
		this.codigoSala = codigoSala;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(codigoSala, other.codigoSala);
	}


	@Override
	public String toString() {
		return "Sala [nombre=" + nombre + ", codigoSala=" + codigoSala + "]";
	}


	public String getNombre() {
		return nombre;
	}
	public String getCodigoSala() {
		return codigoSala;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}
	
	
}
