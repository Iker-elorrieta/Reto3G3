package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Cine;
import Modelo.Sala;

class CineTest {
	private Sala[] arraySalas= new Sala[1];
	Sala obj1 = new Sala(null, 0);
	
Cine cin0 = new Cine("A243F", "Cinesa", "Bilbao", null);
	
	@Test
	void test_getters_y_setters() {
		arraySalas[0]=obj1;
		Cine cin = new Cine("A243F", "Cinesa", "Bilbao", arraySalas);
		cin.setCodigoCine("A243F");
		cin.setNombre("Cinesa");
		cin.setDireccion("Bilbao");
		cin.setArraySalas(arraySalas);
		
		assertEquals(cin.getCodigoCine(), "A243F");
		assertEquals(cin.getNombre(), "Cinesa");
		assertEquals(cin.getDireccion(), "Bilbao");
		assertEquals(cin.getArraySalas(), arraySalas);

	
	}
	
	@Test
	void test_toString() {
		String resul = cin0.toString();
		assertEquals("Cine [codigoCine=A243F, nombre=Cinesa, direccion=Bilbao]", resul);
	}
	
	
	@Test
	void test_equals() {
		Cine cin1 = new Cine("", "", "", null);
		Cine cin2 = new Cine("", "", "", null);
		
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
