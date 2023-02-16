package Modelo;


import java.util.Objects;

public class Entrada {
	private String codigoEntrada;
	private float precio;
	private Cliente xCliente;
	private Sesion[] arraySesiones;
	
	
	
	

	public Entrada(String codigoEntrada, float precio, Cliente xCliente,
			Sesion[] arraySesiones) {
		super();
		this.codigoEntrada = codigoEntrada;
		this.precio = precio;
		this.xCliente = xCliente;
		this.arraySesiones = arraySesiones;
	}


	public Entrada() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Entrada [codigoEntrada=" + codigoEntrada + ", precio=" + precio + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(codigoEntrada, other.codigoEntrada);
	}
	
	
	
	public String getCodigoEntrada() {
		return codigoEntrada;
	}
	public float getPrecio() {
		return precio;
	}
	public Cliente getxCliente() {
		return xCliente;
	}
	public Sesion[] getArraySesiones() {
		return arraySesiones;
	}
	public void setCodigoEntrada(String codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void setxCliente(Cliente arrayCliente) {
		this.xCliente = arrayCliente;
	}
	public void setArraySesiones(Sesion[] arraySesiones) {
		this.arraySesiones = arraySesiones;
	}

	
	
	
}
