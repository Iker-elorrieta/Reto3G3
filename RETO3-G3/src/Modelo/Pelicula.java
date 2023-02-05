package Modelo;

import java.util.Objects;

public class Pelicula {
	private String codigoPelícula;
	private int duracion; //(en minutos)
	private String nombre;
	private String genero;
	private Sesion[] arraySesiones;
	
	public Pelicula(String codigoPelícula, int duracion, String nombre, String genero, Sesion[] arraySesiones) {
		super();
		this.codigoPelícula = codigoPelícula;
		this.duracion = duracion;
		this.nombre = nombre;
		this.genero = genero;
		this.arraySesiones = arraySesiones;
	}



	@Override
	public String toString() {
		return "Pelicula [codigoPelícula=" + codigoPelícula + ", duracion=" + duracion + ", nombre=" + nombre
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
		return Objects.equals(codigoPelícula, other.codigoPelícula);
	}
	
	
	
	public String getCodigoPelícula() {
		return codigoPelícula;
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
	public Sesion[] getArraySesiones() {
		return arraySesiones;
	}
	public void setCodigoPelícula(String codigoPelícula) {
		this.codigoPelícula = codigoPelícula;
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
	public void setArraySesiones(Sesion[] arraySesiones) {
		this.arraySesiones = arraySesiones;
	}
	
	
	
	
	
	
	
}
