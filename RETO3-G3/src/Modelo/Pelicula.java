package Modelo;

import java.util.Objects;

public class Pelicula {
	private String codigoPelicula;
	private int duracion; //(en minutos)
	private String nombre;
	private String genero;
	
	public Pelicula(String codigoPelícula, int duracion, String nombre, String genero) {
		super();
		this.codigoPelicula = codigoPelícula;
		this.duracion = duracion;
		this.nombre = nombre;
		this.genero = genero;
	}



	@Override
	public String toString() {
		return "Pelicula [codigoPelícula=" + codigoPelicula + ", duracion=" + duracion + ", nombre=" + nombre
				+ ", genero=" + genero + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(codigoPelicula, other.codigoPelicula);
	}
	
	
	
	public String getCodigoPelicula() {
		return codigoPelicula;
	}
	public int getDuracion() {
		return duracion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setCodigoPelicula(String codigoPelícula) {
		this.codigoPelicula = codigoPelícula;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	
	
	
	
}
