package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Cine;

class CineTest {

	Cine cin0 = new Cine("2BH", 7);
	
	@Test
	void test_getters_y_setters() {
		Cine cin = new Cine("CX2", 8);
		cin.setCodigoCine("CX2");
		cin.setNumeroSalas(8);
		
		assertEquals(cin.getCodigoCine(), "CX2");
		assertEquals(cin.getNumeroSalas(), 8);

	
	}
	
	@Test
	void test_toString() {
		String resul = cin0.toString();
		assertEquals("Cine [codigoCine=2BH, numeroSalas=7]", resul);

	}
	
	
	@Test
	void test_equals() {
		Cine cin1 = new Cine("", 0);
		Cine cin2 = new Cine("", 0);
		
		cin1.setCodigoCine("CX2");
		cin2.setCodigoCine("CX2");
	boolean resultado = cin1.equals(cin2);
	assertTrue(resultado);
	
	cin1.setCodigoCine("DGFDG8");
	cin2.setCodigoCine("998HHG");
	boolean resultado2 = cin1.equals(cin2);
	assertFalse(resultado2);
	
	int notAObject=0;
	boolean resultado3 = cin1.equals(notAObject);
	assertFalse(resultado3);
	
	cin1.setCodigoCine("DGFDG8");
	cin2.setCodigoCine(null);
	boolean resultado4 = cin1.equals(cin2);
	assertFalse(resultado4);
	
	boolean resultado5 = cin1.equals(cin1);
	assertTrue(resultado5);
	
	boolean resultado6 = cin1.equals(null);
	assertFalse(resultado6);
	}
	

}
