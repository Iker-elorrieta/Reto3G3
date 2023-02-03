package Modelo;

import java.util.Objects;

public class Cine {
	private String codigoCine;
	private int numeroSalas;
	
	public Cine(String codigoCine, int numeroSalas) {
		this.codigoCine = codigoCine;
		this.numeroSalas = numeroSalas;
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

	@Override
	public String toString() {
		return "Cine [codigoCine=" + codigoCine + ", numeroSalas=" + numeroSalas + "]";
	}

	public String getCodigoCine() {
		return codigoCine;
	}
	public int getNumeroSalas() {
		return numeroSalas;
	}
	public void setCodigoCine(String codigoCine) {
		this.codigoCine = codigoCine;
	}
	public void setNumeroSalas(int numeroSalas) {
		this.numeroSalas = numeroSalas;
	}
	
	
}
