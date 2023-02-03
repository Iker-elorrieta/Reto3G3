package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Cine;
import Modelo.Pelicula;

class PeliculaTest {

	Pelicula pel0 = new Pelicula("GDG5", "Harry Potter", 120, "Fantasy", (float) 4.5);
	
	@Test
	void test_getters_y_setters() {
		Pelicula pel = new Pelicula("", "", 0, "", 0);
		pel.setCodigoPelícula("GDG5");
		pel.setNombre("Harry Potter");
		pel.setDuracion(120);
		pel.setGenero("Fantasy");
		pel.setPrecio((float) 4.5);
		
		assertEquals(pel.getCodigoPelícula(), "GDG5");
		assertEquals(pel.getNombre(), "Harry Potter");
		assertEquals(pel.getDuracion(), 120);
		assertEquals(pel.getGenero(), "Fantasy");
		assertEquals(pel.getPrecio(), (float) 4.5);

	
	}
	
	@Test
	void test_toString() {
		String resul = pel0.toString();
		//System.out.println(resul);
		assertEquals("Pelicula [codigoPelícula=GDG5, nombre=Harry Potter, duracion=120, genero=Fantasy, precio=4.5]", resul);

	}
	
	
	@Test
	void test_equals() {
		Pelicula pel1 = new Pelicula("", "", 0, "", 0);
		Pelicula pel2 = new Pelicula("", "", 0, "", 0);
		
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
