package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pedido;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;



class MetodosTest {
	Metodos mts = new Metodos();
	
	

	
	@Test
	void test_mostrarCines() {
		
		//System.out.println(mts.mostrarCines()[0].getArraySalas()[0].getArraySesiones()[0].getxPelicula().getNombre());
		assertEquals(mts.mostrarCines()[0].getArraySalas()[0].getArraySesiones()[0].getxPelicula().getNombre(),"Handia");
	}
	
	@Test
	void test_mostrarPeliculas2() {
		Cine[] arrayCines = new Cine[1];
		Cine cin = new Cine();
		cin.setCodigoCine("342d");
		cin.setNombre("CINESA");
		cin.setDireccion("4554");
			Sala[] arraySalas = new Sala[1];
			Sala sal = new Sala();
			sal.setCodigoSala("");
			sal.setNumero(3);
				Sesion[] arraySesiones = new Sesion[2];
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
					pel.setCodigoPelicula("XXF");
					pel.setDuracion(120);
					pel.setNombre("");
					pel.setGenero("");
				ses.setxPelicula(pel);
				//sesion2
				Sesion ses2 = new Sesion();
				ses2.setCodigoSesion("");
				ses2.setFecha(cal.getTime());
				ses2.setFechaFin(cal2.getTime());
				ses2.setPrecio(7);
					Pelicula pel2 = new Pelicula();
					pel2.setCodigoPelicula("XXF");
					pel2.setDuracion(120);
					pel2.setNombre("");
					pel2.setGenero("");
				ses2.setxPelicula(pel2);
				
				arraySesiones[0]= ses;
				arraySesiones[1]= ses2;
			sal.setArraySesiones(arraySesiones);
			arraySalas[0]= sal;
			
		cin.setArraySalas(arraySalas);
		arrayCines[0]= cin;
		
		
		
		
		int opcionCine = 0;
		int[] nSala = new int[1];
		nSala[0]= 0;
		int[] nSesion = new int[1];
		nSesion[0]= 0;
		
		//System.out.println(mts.mostrarPeliculas(arrayCines, opcionCine)[0]);
		assertEquals(mts.mostrarPeliculas(arrayCines, opcionCine)[0].toString(), "Pelicula [codigoPelícula=XXF, duracion=120, nombre=, genero=]");
		
		
//		System.out.println(mts.nSalaPelicula(arrayCines, opcionCine, nSesion, nSesion, cal.getTime(), mts.mostrarPeliculas(arrayCines, opcionCine), 0)[0]);
//		System.out.println(mts.nSesionPelicula(arrayCines, opcionCine, nSala, nSesion, cal.getTime(), mts.mostrarPeliculas(arrayCines, opcionCine), 0)[0]);
		assertEquals(mts.nSalaPelicula(arrayCines, opcionCine, nSesion, nSesion, cal.getTime(), mts.mostrarPeliculas(arrayCines, opcionCine), 0)[0],  0);
		assertEquals(mts.nSesionPelicula(arrayCines, opcionCine, nSala, nSesion, cal.getTime(), mts.mostrarPeliculas(arrayCines, opcionCine), 0)[0],  0);
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
//		System.out.println(mts.mostrarSesiones(arrayCines, opcionCine, nSala, nSesion)[0]);
		//mts.mostrarSesiones(arrayCines, opcionCine, nSala, nSesion)[0]
		assertEquals(mts.mostrarSesiones(arrayCines, opcionCine, nSala, nSesion)[0], "20-05-2023 04:05 PM - ( Sala 3) - 7.0€");
//		System.out.println(mts.fechasPelicula(arrayCines, opcionCine, nSala, nSesion)[0]);
//		System.out.println(mts.preciosPelicula(arrayCines, opcionCine, nSala, nSesion)[0]);
//		System.out.println(mts.salasPelicula(arrayCines, opcionCine, nSala, nSesion)[0]);
		
		
		assertEquals(mts.fechasPelicula(arrayCines, opcionCine, nSala, nSesion)[0].toString(), "20-05-2023 04:05");
		assertEquals(mts.salasPelicula(arrayCines, opcionCine, nSala, nSesion)[0].toString(), "Sala [codigoSala=, numero=3]");
		assertEquals(mts.preciosPelicula(arrayCines, opcionCine, nSala, nSesion)[0].toString(), "7.0");
		
		
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
		
		Pedido[] arrayViejo41 = new Pedido[0];
		assertEquals(mts.reescribirArrayPedidos(arrayViejo41).length, arrayViejo41.length+1);
		
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
		
		Pelicula[] arrayViejo10 = new Pelicula[0];
		assertEquals(mts.reescribirArrayPeliculas(arrayViejo10).length, arrayViejo10.length+1);
	}
	
	@Test
	void test_selectArrayClientesyEntradas() {
		
//		System.out.println(mts.selectArrayClientes()[0].getDni());
//		System.out.println(mts.selectArrayEntradas()[0].getCodigoEntrada());
		assertEquals(mts.selectArrayClientes()[0].getDni(),"22761890D");
		assertEquals(mts.selectArrayEntradas()[0].getCodigoEntrada(),"1");
		assertEquals(mts.selectArrayPedidos()[0].getCodigoPedido(),"1");
	}
	
	@Test
	void test_validarDNI() {
		assertFalse(mts.validarDNI("dgsag"));
		assertTrue(mts.validarDNI("64538235M"));
		assertFalse(mts.validarDNI("64538235Z"));
	}
	
	
	@Test
	void test_sumarPrecioyDescuentos() {
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
		
		
		
		
		
		assertEquals(Float.valueOf(mts.sumarPrecioyDescuentos(arrayCines, pel, null, null, null, opcionCine, null, opcionCine, null, opcionCine, opcionCine, nSesion, nSesion, nSesion)),Float.valueOf((float) 7.0));
		
		int[] nSala2 = new int[2];
		nSala2[0]= 0;
		nSala2[1]= 0;
		int[] nSesion2 = new int[2];
		nSesion2[0]= 0;
		nSesion2[1]= 0;
		//System.out.println(Float.valueOf(mts.sumarPrecioyDescuentos(arrayCines, pel, null, null, null, opcionCine, null, opcionCine, null, opcionCine, opcionCine, nSesion2, nSesion2, nSesion2)));
		assertEquals(Float.valueOf(mts.sumarPrecioyDescuentos(arrayCines, pel, null, null, null, opcionCine, null, opcionCine, null, opcionCine, opcionCine, nSesion2, nSesion2, nSesion2)),Float.valueOf((float) 11.2));
		
		int[] nSala3 = new int[3];
		nSala3[0]= 0;
		nSala3[1]= 0;
		nSala3[2]= 0;
		int[] nSesion3 = new int[3];
		nSesion3[0]= 0;
		nSesion3[1]= 0;
		nSesion3[2]= 0;
		//System.out.println(Float.valueOf(mts.sumarPrecioyDescuentos(arrayCines, pel, null, null, null, opcionCine, null, opcionCine, null, opcionCine, opcionCine, nSesion3, nSesion3, nSesion3)));
		assertEquals(Float.valueOf(mts.sumarPrecioyDescuentos(arrayCines, pel, null, null, null, opcionCine, null, opcionCine, null, opcionCine, opcionCine, nSesion3, nSesion3, nSesion3)),Float.valueOf((float) 14.7));
	}
	
	@SuppressWarnings("null")
	@Test
	void test_comprobacionLogInDNI() {
		JTextField txtDNI = new JTextField();
		txtDNI.setBounds(126, 68, 121, 20);
		txtDNI.setColumns(10);
		
		txtDNI.setText("635353H");
		
		Cliente cli = new Cliente();
		cli.setDni("635353H");
		
		Cliente[] arrayClientes = new Cliente[1];
		arrayClientes[0]=cli;
		
		assertTrue(mts.comprobacionLogInDNI(null, arrayClientes, txtDNI, null, 0));
		
		Cliente cli2 = new Cliente();
		cli2.setDni("6737373P");
		
		Cliente[] arrayClientes2 = new Cliente[1];
		arrayClientes2[0]=cli2;
		
		assertFalse(mts.comprobacionLogInDNI(null, arrayClientes2, txtDNI, null, 0));
		
	}
	
	@Test
	void test_comprobacionLogInContra() {
		JPasswordField txtContrasenya = new JPasswordField();
		txtContrasenya.setBounds(126, 103, 121, 20);
		
		txtContrasenya.setText("ola123");
		//txtContrasenya.setPassword("ola123"); ???
		
		Cliente cli = new Cliente();
		cli.setContrasena("ola123");
		
		Cliente[] arrayClientes = new Cliente[1];
		arrayClientes[0]=cli;
		
		assertTrue(mts.comprobacionLogInContra(null, arrayClientes, txtContrasenya, null, 0));
		
		Cliente cli2 = new Cliente();
		cli2.setContrasena("adios234");
		
		Cliente[] arrayClientes2 = new Cliente[1];
		arrayClientes2[0]=cli2;
		
		assertFalse(mts.comprobacionLogInContra(null, arrayClientes2, txtContrasenya, null, 0));
	}
	
	@Test
	void test_guardarTXT() {
		String[] arrayTexto = new String[1];
		String texto = "adadbhsdbhdbhas";
		arrayTexto[0] = texto;
		
		mts.guardarTXT(arrayTexto, 4);
	}
	
	@Test
	void test_guardarBDD() {
	
	}

}
