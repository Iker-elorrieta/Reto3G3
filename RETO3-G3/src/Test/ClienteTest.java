package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Cine;
import Modelo.Cliente;

class ClienteTest {

Cliente cli0 = new Cliente("365353H", "pako", "gomez", "H", "2424");
	
	@Test
	void test_getters_y_setters() {
		Cliente cli = new Cliente("365353H", "pako", "gomez", "H", "2424");
		cli.setDni("365353H");
		cli.setNombre("pako");
		cli.setApellidos("gomez");
		cli.setSexo("H");
		cli.setContrasena("2424");
		
		assertEquals(cli.getDni(), "365353H");
		assertEquals(cli.getNombre(), "pako");
		assertEquals(cli.getApellidos(), "gomez");
		assertEquals(cli.getSexo(), "H");
		assertEquals(cli.getContrasena(), "2424");
		
	}
	
	@Test
	void test_toString() {
		String resul = cli0.toString();
		assertEquals("Cliente [dni=365353H, nombre=pako, apellidos=gomez, sexo=H, contrasena=2424]", resul);

	}
	
	
	@Test
	void test_equals() {
		Cliente cli1 = new Cliente("", "", "", "", "");
		Cliente cli2 = new Cliente("", "", "", "", "");
		
		cli1.setDni("365353H");
		cli2.setDni("365353H");
	boolean resultado = cli1.equals(cli2);
	assertTrue(resultado);
	
	cli1.setDni("3LL5353H");
	cli2.setDni("3GDF3H");
	boolean resultado2 = cli1.equals(cli2);
	assertFalse(resultado2);
	
	int notAObject=0;
	boolean resultado3 = cli1.equals(notAObject);
	assertFalse(resultado3);
	
	cli1.setDni("365353H");
	cli2.setDni(null);
	boolean resultado4 = cli1.equals(cli2);
	assertFalse(resultado4);
	
	boolean resultado5 = cli1.equals(cli1);
	assertTrue(resultado5);
	
	boolean resultado6 = cli1.equals(null);
	assertFalse(resultado6);
	}

}
