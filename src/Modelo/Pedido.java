package Modelo;

import java.util.Date;
import java.util.Objects;

public class Pedido {
	private String codigoPedido;
	private float importe;
	private Date fechaCompra;
	private Cliente xCliente;
	private Entrada xEntrada;
	
	
	
	public Pedido() {
		super();
	}

	public Pedido(String codigoPedido, float importe, Date fechaCompra, Cliente xCliente, Entrada xEntrada) {
		super();
		this.codigoPedido = codigoPedido;
		this.importe = importe;
		this.fechaCompra = fechaCompra;
		this.xCliente = xCliente;
		this.xEntrada = xEntrada;
	}




	@Override
	public String toString() {
		return "Pedido [codigoPedido=" + codigoPedido + ", importe=" + importe + ", fechaCompra=" + fechaCompra + "]";
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(codigoPedido, other.codigoPedido);
	}
	
	
	
	
	public String getCodigoPedido() {
		return codigoPedido;
	}
	public float getImporte() {
		return importe;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public Cliente getxCliente() {
		return xCliente;
	}
	public Entrada getxEntrada() {
		return xEntrada;
	}
	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public void setxCliente(Cliente xCliente) {
		this.xCliente = xCliente;
	}
	public void setxEntrada(Entrada xEntrada) {
		this.xEntrada = xEntrada;
	}
	
	
}
