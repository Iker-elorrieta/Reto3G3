package Test;

import static org.junit.jupiter.api.Assertions.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Cine;
import Modelo.Entrada;

class EntradaTest {
	DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	
	Date fecha = null;
	Calendar cal = Calendar.getInstance();
	/*cal.set(Calendar.DAY_OF_MONTH, 20);
	cal.set(Calendar.MONTH, 0);
	cal.set(Calendar.YEAR, 2023);
	fecha = cal.getTime();*/
	Entrada ent0 = new Entrada("SH2RYSK", fecha, "2C", "Iron Man 2");
	
	@Test
	void test_getters_y_setters() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha =  cal.getTime();
		
		Entrada ent = new Entrada("", null, "", "");
		ent.setCodigoEntrada("SH2RYSK");
		ent.setFecha(fecha);
		ent.setSala("2C");
		ent.setPelicula("Iron Man 2");
	
		assertEquals(ent.getCodigoEntrada(), "SH2RYSK");
		assertEquals(ent.getFecha(), fecha);
		assertEquals(ent.getSala(), "2C");
		assertEquals(ent.getPelicula(), "Iron Man 2");

	
	}
	
	@Test
	void test_toString() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.YEAR, 2023);
		fecha =  cal.getTime();
		ent0.setFecha(fecha);
		String resul = ent0.toString();
		//System.out.println(ent0.toString());
		assertEquals("Entrada [codigoEntrada=SH2RYSK, fecha=20/12/2023, sala=2C, pelicula=Iron Man 2]", resul);

	}
	
	
	@Test
	void test_equals() {
		Entrada ent1 = new Entrada("", null, "", "");
		Entrada ent2 = new Entrada("", null, "", "");
		
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
