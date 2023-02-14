package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Modelo.Pelicula;
import Modelo.Sesion;

class SesionTest {

	//DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	Date fecha = null;
	Calendar cal = Calendar.getInstance();
	
	Pelicula xPelicula = new Pelicula(null, 0, null, null);
	
Sesion ses0 = new Sesion("SES934", fecha, fecha, xPelicula, 0);
	
	@Test
	void test_getters_y_setters() {
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha =  cal.getTime();
		
		Sesion ses = new Sesion("SES934", fecha, fecha, xPelicula, 0);
		ses.setCodigoSesion("SES934");
		ses.setFecha(fecha);
		ses.setxPelicula(xPelicula);
		ses.setPrecio(0);
		
		assertEquals(ses.getCodigoSesion(), "SES934");
		assertEquals(ses.getFecha(), fecha);
		assertEquals(ses.getxPelicula(), xPelicula);
		assertEquals(ses.getPrecio(), 0);
	}
	
	@Test
	void test_toString() {
		
		cal.set(Calendar.HOUR_OF_DAY, 5);
		cal.set(Calendar.MINUTE, 30);
		cal.set(Calendar.DAY_OF_MONTH, 20);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2023);
		fecha =  cal.getTime();
		
		Sesion ses0 = new Sesion("SES934", fecha, fecha, xPelicula, 0);
		String resul = ses0.toString();
		System.out.println(resul);
		assertEquals("Sesion [codigoSesion=SES934, hora=05:30, fecha=20/01/2023, fechaFin=20/01/2023]", resul);
	}
	
	
	@Test
	void test_equals() {
		Sesion ses1 = new Sesion(null, fecha, fecha, xPelicula, 0);
		Sesion ses2 = new Sesion(null, fecha, fecha, xPelicula, 0);
		
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
