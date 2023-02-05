package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Cliente;
import Modelo.Entrada;

class ClienteTest {

	private Entrada[] arrayEntradas= new Entrada[1];
	Entrada obj1 = new Entrada(null, 0, null, null, null, null);
	
Cliente cli0 = new Cliente("4737J", "George", "Smith", "H", "lmao999", null);
	
	@Test
	void test_getters_y_setters() {
		arrayEntradas[0]=obj1;
		Cliente cli = new Cliente("4737J", "George", "Smith", "H", "lmao999", arrayEntradas);
		cli.setDni("4737J");
		cli.setNombre("George");
		cli.setApellidos("Smith");
		cli.setSexo("H");
		cli.setContrasena("lmao999");
		cli.setArrayEntrada(arrayEntradas);
		
		assertEquals(cli.getDni(), "4737J");
		assertEquals(cli.getNombre(), "George");
		assertEquals(cli.getApellidos(), "Smith");
		assertEquals(cli.getSexo(), "H");
		assertEquals(cli.getContrasena(), "lmao999");
		assertEquals(cli.getArrayEntrada(), arrayEntradas);
	
	}
	
	@Test
	void test_toString() {
		String resul = cli0.toString();
		System.out.println(resul);
		assertEquals("Cliente [dni=4737J, nombre=George, apellidos=Smith, sexo=H, contrasena=lmao999]", resul);
	}
	
	
	@Test
	void test_equals() {
		Cliente cli1 = new Cliente("", "", "", "", "", null);
		Cliente cli2 = new Cliente("", "", "", "", "", null);
		
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
