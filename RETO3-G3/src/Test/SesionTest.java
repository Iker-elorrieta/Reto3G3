package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Cine;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

class SesionTest {

	//DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	Date fecha = null;
	Calendar cal = Calendar.getInstance();
	
	private Pelicula[] arrayPeliculas= new Pelicula[1];
	Pelicula obj1_p = new Pelicula(null, 0, null, null, null);
	
	private Sala[] arraySalas= new Sala[1];
	Sala obj1_s = new Sala(null, 0, null, null);
	
	private Entrada[] arrayEntradas= new Entrada[1];
	Entrada obj1_e = new Entrada(null, 0, null, null, null, null);
	
//Sesion ses0 = new Sesion("SES934", fecha, fecha, "PEL12345", "SAL23672", arrayPeliculas, arraySalas, arrayEntradas);
	
	@Test
	void test_getters_y_setters() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha =  cal.getTime();
		
		arrayPeliculas[0]=obj1_p;
		arraySalas[0]=obj1_s;
		arrayEntradas[0]=obj1_e;
		Sesion ses = new Sesion("SES934", fecha, fecha, "PEL12345", "SAL23672", arrayPeliculas, arraySalas, arrayEntradas);
		ses.setCodigoSesion("SES934");
		ses.setHora(fecha);
		ses.setFecha(fecha);
		ses.setCodigoPelicula("PEL12345");
		ses.setCodigoSala("SAL23672");
		ses.setArrayPeliculas(arrayPeliculas);
		ses.setArraySalas(arraySalas);
		ses.setArrayEntradas(arrayEntradas);
		
		assertEquals(ses.getCodigoSesion(), "SES934");
		assertEquals(ses.getHora(), fecha);
		assertEquals(ses.getFecha(), fecha);
		assertEquals(ses.getCodigoPelicula(), "PEL12345");
		assertEquals(ses.getCodigoSala(), "SAL23672");
		assertEquals(ses.getArrayPeliculas(), arrayPeliculas);
		assertEquals(ses.getArraySalas(), arraySalas);
		assertEquals(ses.getArrayEntradas(), arrayEntradas);

	
	}
	
	@Test
	void test_toString() {
		
		cal.set(Calendar.HOUR_OF_DAY, 5);
		cal.set(Calendar.MINUTE, 30);
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha =  cal.getTime();
		
		arrayPeliculas[0]=obj1_p;
		arraySalas[0]=obj1_s;
		arrayEntradas[0]=obj1_e;
		Sesion ses0 = new Sesion("SES934", fecha, fecha, "PEL12345", "SAL23672", arrayPeliculas, arraySalas, arrayEntradas);
		String resul = ses0.toString();
		System.out.println(resul);
		assertEquals("Sesion [codigoSesion=SES934, hora=05:30, fecha=20/01/2023, codigoPelicula=PEL12345, codigoSala=SAL23672]", resul);
	}
	
	
	@Test
	void test_equals() {
		Sesion ses1 = new Sesion(null, fecha, fecha, null, null, arrayPeliculas, arraySalas, arrayEntradas);
		Sesion ses2 = new Sesion(null, fecha, fecha, null, null, arrayPeliculas, arraySalas, arrayEntradas);
		
		ses1.setCodigoSesion("DFFD");
		ses2.setCodigoSesion("DFFD");
	boolean resultado = ses1.equals(ses2);
	assertTrue(resultado);
	
	ses1.setCodigoSesion("DFFD");
	ses2.setCodigoSesion("DFDGGDFD");
	boolean resultado2 = ses1.equals(ses2);
	assertFalse(resultado2);
	
	int notAObject=0;
	boolean resultado3 = ses1.equals(notAObject);
	assertFalse(resultado3);
	
	ses1.setCodigoSesion("DFFD");
	ses2.setCodigoSesion(null);
	boolean resultado4 = ses1.equals(ses2);
	assertFalse(resultado4);
	
	boolean resultado5 = ses1.equals(ses1);
	assertTrue(resultado5);
	
	boolean resultado6 = ses1.equals(null);
	assertFalse(resultado6);
	}

}
