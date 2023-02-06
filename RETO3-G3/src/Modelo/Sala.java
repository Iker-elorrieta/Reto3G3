package Modelo;

import java.util.Objects;

public class Sala {
	private String codigoSala;
	private int numero;
	private Sesion[] arraySesiones;
	
	


	public Sala(String codigoSala, int numero, Sesion[] arraySesiones) {
		super();
		this.codigoSala = codigoSala;
		this.numero = numero;
		this.arraySesiones = arraySesiones;
	}


	@Override
	public String toString() {
		return "Sala [codigoSala=" + codigoSala + ", numero=" + numero + "]";
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



	public String getCodigoSala() {
		return codigoSala;
	}
	public int getNumero() {
		return numero;
	}
	public Sesion[] getArraySesiones() {
		return arraySesiones;
	}
	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setArraySesiones(Sesion[] arraySesiones) {
		this.arraySesiones = arraySesiones;
	}
	
}
