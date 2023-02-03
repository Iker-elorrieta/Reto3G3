package Modelo;

import java.util.Objects;

public class Sala {
	private String codigoSala;
	private int numero;
	private String codigoCine;
	//private Pelicula relacionPeliculas;
	private Sesion[] arraySesiones;
	
	
	
	public Sala(String codigoSala, int numero, String codigoCine) {
		super();
		this.codigoSala = codigoSala;
		this.numero = numero;
		this.codigoCine = codigoCine;
	}
	
	



	@Override
	public String toString() {
		return "Sala [codigoSala=" + codigoSala + ", numero=" + numero + ", codigoCine=" + codigoCine + "]";
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
		return Objects.equals(codigoCine, other.codigoCine) && Objects.equals(codigoSala, other.codigoSala)
				&& numero == other.numero;
	}



	public String getCodigoSala() {
		return codigoSala;
	}



	public int getNumero() {
		return numero;
	}



	public String getCodigoCine() {
		return codigoCine;
	}



	public void setCodigoSala(String codigoSala) {
		this.codigoSala = codigoSala;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public void setCodigoCine(String codigoCine) {
		this.codigoCine = codigoCine;
	}
	

	
	
}
