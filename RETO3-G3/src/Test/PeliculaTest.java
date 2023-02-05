package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Pelicula;
import Modelo.Sesion;

class PeliculaTest {

	private Sesion[] arraySesiones= new Sesion[1];
	Sesion obj1 = new Sesion(null, null, null, null, null, null, null, null);
	
Pelicula pel0 = new Pelicula("DFDF67", 142, "Scary Movie", "Comedia", arraySesiones);
	
	@Test
	void test_getters_y_setters() {
		arraySesiones[0]=obj1;
		Pelicula pel = new Pelicula("DFDF67", 142, "Scary Movie", "Comedia", arraySesiones);
		pel.setCodigoPelícula("DFDF67");
		pel.setDuracion(142);
		pel.setNombre("Scary Movie");
		pel.setGenero("Comedia");
		pel.setArraySesiones(arraySesiones);
		
		assertEquals(pel.getCodigoPelícula(), "DFDF67");
		assertEquals(pel.getDuracion(), 142);
		assertEquals(pel.getNombre(), "Scary Movie");
		assertEquals(pel.getGenero(), "Comedia");
		assertEquals(pel.getArraySesiones(), arraySesiones);
	
	}
	
	@Test
	void test_toString() {
		String resul = pel0.toString();
		assertEquals("Pelicula [codigoPelícula=DFDF67, duracion=142, nombre=Scary Movie, genero=Comedia]", resul);
	}
	
	
	@Test
	void test_equals() {
		Pelicula pel1 = new Pelicula(null, 0, null, null, arraySesiones);
		Pelicula pel2 = new Pelicula(null, 0, null, null, arraySesiones);
		
		pel1.setCodigoPelícula("ZZ3");
		pel2.setCodigoPelícula("ZZ3");
	boolean resultado = pel1.equals(pel2);
	assertTrue(resultado);
	
	pel1.setCodigoPelícula("ZZ3");
	pel2.setCodigoPelícula("Z3535Z3");
	boolean resultado2 = pel1.equals(pel2);
	assertFalse(resultado2);
	
	int notAObject=0;
	boolean resultado3 = pel1.equals(notAObject);
	assertFalse(resultado3);
	
	pel1.setCodigoPelícula("ZZ3");
	pel2.setCodigoPelícula(null);
	boolean resultado4 = pel1.equals(pel2);
	assertFalse(resultado4);
	
	boolean resultado5 = pel1.equals(pel1);
	assertTrue(resultado5);
	
	boolean resultado6 = pel1.equals(null);
	assertFalse(resultado6);

	}
}
