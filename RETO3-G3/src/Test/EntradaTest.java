package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Sesion;

class EntradaTest {

	Cliente xCliente = new Cliente("", "", "", "", "");
	
	private Sesion[] arraySesiones= new Sesion[1];
	Sesion obj1_s = new Sesion(null, null, null);
	
Entrada ent0 = new Entrada("FDG557", (float) 4.7, xCliente, arraySesiones);
	
	@Test
	void test_getters_y_setters() {
		arraySesiones[0]=obj1_s;
		Entrada ent = new Entrada("FDG557", (float) 4.7, xCliente, arraySesiones);
		ent.setCodigoEntrada("FDG557");
		ent.setPrecio((float) 4.7);
		ent.setArrayCliente(xCliente);
		ent.setArraySesiones(arraySesiones);
		
		
		assertEquals(ent.getCodigoEntrada(), "FDG557");
		assertEquals(ent.getPrecio(), (float) 4.7);
		assertEquals(ent.getArrayCliente(), xCliente);
		assertEquals(ent.getArraySesiones(), arraySesiones);
	}
	
	@Test
	void test_toString() {
		String resul = ent0.toString();
		System.out.println(resul);
		assertEquals("Entrada [codigoEntrada=FDG557, precio=4.7]", resul);
	}
	
	
	@Test
	void test_equals() {
		Entrada ent1 = new Entrada(null, 0, xCliente, arraySesiones);
		Entrada ent2 = new Entrada(null, 0, xCliente, arraySesiones);
		
		ent1.setCodigoEntrada("Z824");
		ent2.setCodigoEntrada("Z824");
	boolean resultado = ent1.equals(ent2);
	assertTrue(resultado);
	
	ent1.setCodigoEntrada("Z824");
	ent2.setCodigoEntrada("LSJSH24");
	boolean resultado2 = ent1.equals(ent2);
	assertFalse(resultado2);
	
	int notAObject=0;
	boolean resultado3 = ent1.equals(notAObject);
	assertFalse(resultado3);
	
	ent1.setCodigoEntrada("Z824");
	ent2.setCodigoEntrada(null);
	boolean resultado4 = ent1.equals(ent2);
	assertFalse(resultado4);
	
	boolean resultado5 = ent1.equals(ent1);
	assertTrue(resultado5);
	
	boolean resultado6 = ent1.equals(null);
	assertFalse(resultado6);
	}

}
