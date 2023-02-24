package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pedido;

class PedidoTest {

	Date fecha = null;
	Calendar cal = Calendar.getInstance();
	
	Cliente xCliente = new Cliente();
	Entrada xEntrada = new Entrada();
	
	
Pedido ped0 = new Pedido("X34", (float) 4.7, fecha, xCliente, xEntrada);
	
	@Test
	void test_getters_y_setters() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha =  cal.getTime();
		
		Pedido ped = new Pedido("X34", (float) 4.7, fecha, xCliente, xEntrada);
		ped.setCodigoPedido("X34");
		ped.setImporte((float) 4.7);
		ped.setFechaCompra(fecha);
		ped.setxCliente(xCliente);
		ped.setxEntrada(xEntrada);
		
		
		assertEquals(ped.getCodigoPedido(), "X34");
		assertEquals(ped.getImporte(), (float) 4.7);
		assertEquals(ped.getFechaCompra(), fecha);
		assertEquals(ped.getxCliente(), xCliente);
		assertEquals(ped.getxEntrada(), xEntrada);
		
	}
	
	@Test
	void test_toString() {
		
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha =  cal.getTime();
		
		Pedido ped0 = new Pedido("X34", (float) 4.7, fecha, xCliente, xEntrada);
		String resul = ped0.toString();
		System.out.println(resul);
		assertEquals("Pedido [codigoPedido=X34, importe=4.7, fechaCompra=20/01/2023]", resul);
	}
	
	
	@Test
	void test_equals() {
		Pedido ped1 = new Pedido();
		Pedido ped2 = new Pedido();
		
		ped1.setCodigoPedido("44GHS");
		ped2.setCodigoPedido("44GHS");
	boolean resultado = ped1.equals(ped2);
	assertTrue(resultado);
	
	ped1.setCodigoPedido("44GHS");
	ped2.setCodigoPedido("554GHS");
	boolean resultado2 = ped1.equals(ped2);
	assertFalse(resultado2);
	
	int notAObject=0;
	boolean resultado3 = ped1.equals(notAObject);
	assertFalse(resultado3);
	
	ped1.setCodigoPedido("44GHS");
	ped2.setCodigoPedido(null);
	boolean resultado4 = ped1.equals(ped2);
	assertFalse(resultado4);
	
	boolean resultado5 = ped1.equals(ped1);
	assertTrue(resultado5);
	
	boolean resultado6 = ped1.equals(null);
	assertFalse(resultado6);
	}

}
