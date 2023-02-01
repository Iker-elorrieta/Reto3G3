package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Cine;
import Modelo.Sala;

class SalaTest {

Sala sal0 = new Sala("2B", "X78H");
	
	@Test
	void test_getters_y_setters() {
		Sala sal = new Sala("", "");
	sal.setNombre("2B");
	sal.setCodigoSala("X78H");
		
		assertEquals(sal.getNombre(), "2B");
		assertEquals(sal.getCodigoSala(), "X78H");

	
	}
	
	@Test
	void test_toString() {
		String resul = sal0.toString();
		//System.out.println(resul);
		assertEquals("Sala [nombre=2B, codigoSala=X78H]", resul);

	}
	
	
	@Test
	void test_equals() {
		Sala sal1 = new Sala("", "");
		Sala sal2 = new Sala("", "");
		
		sal1.setCodigoSala("Y9Y9");
		sal2.setCodigoSala("Y9Y9");
	boolean resultado = sal1.equals(sal2);
	assertTrue(resultado);
	
	sal1.setCodigoSala("Y9Y9");
	sal2.setCodigoSala("Y4535539Y9");
	boolean resultado2 = sal1.equals(sal2);
	assertFalse(resultado2);
	
	int notAObject=0;
	boolean resultado3 = sal1.equals(notAObject);
	assertFalse(resultado3);
	
	sal1.setCodigoSala("Y9Y9");
	sal2.setCodigoSala(null);
	boolean resultado4 = sal1.equals(sal2);
	assertFalse(resultado4);
	
	boolean resultado5 = sal1.equals(sal1);
	assertTrue(resultado5);
	
	boolean resultado6 = sal1.equals(null);
	assertFalse(resultado6);
	}

}
