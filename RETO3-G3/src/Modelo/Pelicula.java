package Modelo;

import java.util.Objects;

public class Pelicula {
	private String codigoPelícula;
	private String nombre;
	private int duracion; //(en minutos)
	private String genero;
	private float precio;
	
	public Pelicula(String codigoPelícula, String nombre, int duracion, String genero, float precio) {
		this.codigoPelícula = codigoPelícula;
		this.nombre = nombre;
		this.duracion = duracion;
		this.genero = genero;
		this.precio = precio;
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


	@Override
	public String toString() {
		return "Pelicula [codigoPelícula=" + codigoPelícula + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", genero=" + genero + ", precio=" + precio + "]";
	}


	public String getCodigoPelícula() {
		return codigoPelícula;
	}
	public String getNombre() {
		return nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public String getGenero() {
		return genero;
	}
	public float getPrecio() {
		return precio;
	}
	public void setCodigoPelícula(String codigoPelícula) {
		this.codigoPelícula = codigoPelícula;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
