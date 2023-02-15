package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JRadioButton;

import org.junit.jupiter.api.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

class MetodosTest {
	Metodos mts = new Metodos();
	
	

		

	
	
	
	
	@Test
	void test_mostrarCines() {
		//??? selects??
		mts.mostrarCines();
	}
	
	@Test
	void test_mostrarPeliculas() {
		//???
		Cine[] arrayCines = new Cine[1];
		Cine cin = new Cine();
		cin.setCodigoCine("342d");
		cin.setNombre("CINESA");
		cin.setDireccion("4554");
			Sala[] arraySalas = new Sala[1];
			Sala sal = new Sala();
			sal.setCodigoSala("");
			sal.setNumero(3);
				Sesion[] arraySesiones = new Sesion[1];
				Sesion ses = new Sesion();
				ses.setCodigoSesion("");
				Calendar cal = Calendar.getInstance();
				//System.out.println(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[0]);
				cal.set(Calendar.HOUR_OF_DAY, 4);
				cal.set(Calendar.MINUTE, 5);
				cal.set(Calendar.DAY_OF_MONTH, 20);
				cal.set(Calendar.MONTH, 4);
				cal.set(Calendar.YEAR, 2023);
				//ses.setFecha(registroSesiones2.getDate("Fecha_Inicio"));
				ses.setFecha(cal.getTime());
				
				Calendar cal2 = Calendar.getInstance();
				cal2.set(Calendar.DAY_OF_MONTH, 21);
				cal2.set(Calendar.MONTH, 3);
				cal2.set(Calendar.YEAR, 2022);
				ses.setFechaFin(cal2.getTime());
				ses.setPrecio(7);
					Pelicula pel = new Pelicula();
					pel.setCodigoPelicula("");
					pel.setDuracion(120);
					pel.setNombre("");
					pel.setGenero("");
				ses.setxPelicula(pel);
				arraySesiones[0]= ses;
			sal.setArraySesiones(arraySesiones);
			arraySalas[0]= sal;
			
		cin.setArraySalas(arraySalas);
		arrayCines[0]= cin;
		
		
		
		
		int opcionCine = 0;
		int[] nSala = new int[1];
		nSala[0]= 0;
		int[] nSesion = new int[1];
		nSesion[0]= 0;
		
		System.out.println("hgsdgd");
		System.out.println(mts.mostrarPeliculas(arrayCines, opcionCine)[0]);
		assertEquals(mts.mostrarPeliculas(arrayCines, opcionCine)[0], "Pelicula [codigoPelícula=, duracion=120, nombre=, genero=]");
	}
	
	
	
	@Test
	void test_mostrarSesiones() {
		Cine[] arrayCines = new Cine[1];
		Cine cin = new Cine();
		cin.setCodigoCine("342d");
		cin.setNombre("CINESA");
		cin.setDireccion("4554");
			Sala[] arraySalas = new Sala[1];
			Sala sal = new Sala();
			sal.setCodigoSala("");
			sal.setNumero(3);
				Sesion[] arraySesiones = new Sesion[1];
				Sesion ses = new Sesion();
				ses.setCodigoSesion("");
				Calendar cal = Calendar.getInstance();
				//System.out.println(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[0]);
				cal.set(Calendar.HOUR_OF_DAY, 4);
				cal.set(Calendar.MINUTE, 5);
				cal.set(Calendar.DAY_OF_MONTH, 20);
				cal.set(Calendar.MONTH, 4);
				cal.set(Calendar.YEAR, 2023);
				//ses.setFecha(registroSesiones2.getDate("Fecha_Inicio"));
				ses.setFecha(cal.getTime());
				
				Calendar cal2 = Calendar.getInstance();
				cal2.set(Calendar.DAY_OF_MONTH, 21);
				cal2.set(Calendar.MONTH, 3);
				cal2.set(Calendar.YEAR, 2022);
				ses.setFechaFin(cal2.getTime());
				ses.setPrecio(7);
					Pelicula pel = new Pelicula();
					pel.setCodigoPelicula("");
					pel.setDuracion(120);
					pel.setNombre("");
					pel.setGenero("");
				ses.setxPelicula(pel);
				arraySesiones[0]= ses;
			sal.setArraySesiones(arraySesiones);
			arraySalas[0]= sal;
			
		cin.setArraySalas(arraySalas);
		arrayCines[0]= cin;
		
		
		
		
		int opcionCine = 0;
		int[] nSala = new int[1];
		nSala[0]= 0;
		int[] nSesion = new int[1];
		nSesion[0]= 0;
		System.out.println(mts.mostrarSesiones(arrayCines, opcionCine, nSala, nSesion)[0]);
		//mts.mostrarSesiones(arrayCines, opcionCine, nSala, nSesion)[0]
		assertEquals(mts.mostrarSesiones(arrayCines, opcionCine, nSala, nSesion)[0], "04:05 PM - ( Sala 3) - 7.0€");
		
	}
	
	@Test
	void test_reescribirArrays() {
		JRadioButton[] arrayViejo = new JRadioButton[0];
		assertEquals(mts.reescribirArrayButtons(arrayViejo).length, arrayViejo.length+1);
		
		Cine[] arrayViejo2 = new Cine[0];
		assertEquals(mts.reescribirArrayCines(arrayViejo2).length, arrayViejo2.length+1);

		Cliente[] arrayViejo3 = new Cliente[0];
		assertEquals(mts.reescribirArrayClientes(arrayViejo3).length, arrayViejo3.length+1);
		
		Entrada[] arrayViejo4 = new Entrada[0];
		assertEquals(mts.reescribirArrayEntradas(arrayViejo4).length, arrayViejo4.length+1);
		
		Float[] arrayViejo5 = new Float[0];
		assertEquals(mts.reescribirArrayFloats(arrayViejo5).length, arrayViejo5.length+1);
		
		int[] arrayViejo6 = new int[0];
		assertEquals(mts.reescribirArrayInts(arrayViejo6).length, arrayViejo6.length+1);
		
		Sala[] arrayViejo7 = new Sala[0];
		assertEquals(mts.reescribirArraySalas(arrayViejo7).length, arrayViejo7.length+1);
		
		Sesion[] arrayViejo8 = new Sesion[0];
		assertEquals(mts.reescribirArraySesiones(arrayViejo8).length, arrayViejo8.length+1);
		
		String[] arrayViejo9 = new String[0];
		assertEquals(mts.reescribirArrayStrings(arrayViejo9).length, arrayViejo9.length+1);
	}

}
