package Modelo;

import java.util.Objects;

public class Cine {
	private String codigoCine;
	private String nombre;
	private String direccion;
	//
	private Sala[] arraySalas;
	

	public Cine(String codigoCine, String nombre, String direccion, Sala[] arraySalas) {
		super();
		this.codigoCine = codigoCine;
		this.nombre = nombre;
		this.direccion = direccion;
		this.arraySalas = arraySalas;
	}



	public Cine() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Cine [codigoCine=" + codigoCine + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	public Sala[] getArraySalas() {
		return arraySalas;
	}
	public String getCodigoCine() {
		return codigoCine;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public void setArraySalas(Sala[] arraySalas) {
		/*Sala sala = arraySalas[arraySalas.length];
		Sala[] arrayNuevo = new Sala[arraySalas.length+1];
		for(int i =0;i<arraySalas.length;i++)
		{
			arrayNuevo[i]=arraySalas[i];
		}
		arrayNuevo[arraySalas.length] = sala;
		arraySalas = arrayNuevo;*/
		
		this.arraySalas = arraySalas;
	}
	public void setCodigoCine(String codigoCine) {
		this.codigoCine = codigoCine;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return Objects.equals(codigoCine, other.codigoCine);
	}








	
	
}
