package Controlador;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

public class Metodos {

	public Cine[] mostrarCines() {
		Cine[] arrayCines = new Cine[0];
		Connection conexion;
		try {
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reto3_grupo3","root","");
	
		Statement comando=(Statement) conexion.createStatement();
		ResultSet registroCines = comando.executeQuery("select * from cine");
		int i=0;
		
		while (registroCines.next()) {
			
			Sala[] arraySalas = new Sala[0];
			Cine cin = new Cine();
			
			cin.setCodigoCine(registroCines.getString("Código_Cine"));
			cin.setNombre(registroCines.getString("Nombre"));
			cin.setDireccion(registroCines.getString("Direccion"));
			Statement comando2=(Statement) conexion.createStatement();
			ResultSet registroSalas2 = comando2.executeQuery("select * from salas where Código_Cine='"+registroCines.getString("Código_Cine")+"'");
			int contSal=0;
			while (registroSalas2.next()) {
				Sesion[] arraySesiones = new Sesion[0];
				Sala sal = new Sala();
				sal.setCodigoSala(registroSalas2.getString("Código_Sala"));
				sal.setNumero(registroSalas2.getInt("Numero"));
				
				Statement comando3=(Statement) conexion.createStatement();
				ResultSet registroSesiones2 = comando3.executeQuery("select * from sesión where Código_Sala='"+registroSalas2.getString("Código_Sala")+"'");
				int contSes=0;
				
				while (registroSesiones2.next()) {
				
					Sesion ses = new Sesion();
					ses.setCodigoSesion(registroSesiones2.getString("Código_Sesión"));
					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(registroSesiones2.getTime("Hora").toString().split(":")[0]));
					cal.set(Calendar.MINUTE, Integer.valueOf(registroSesiones2.getTime("Hora").toString().split(":")[1]));
					cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(registroSesiones2.getDate("Fecha").toString().split("-")[2]));
					cal.set(Calendar.MONTH, Integer.valueOf(registroSesiones2.getDate("Fecha").toString().split("-")[1]));
					cal.set(Calendar.YEAR, Integer.valueOf(registroSesiones2.getDate("Fecha").toString().split("-")[0]));
					//ses.setFecha(registroSesiones2.getDate("Fecha_Inicio"));
					ses.setFecha(cal.getTime());
					
					Calendar cal2 = Calendar.getInstance();
					cal2.set(Calendar.DAY_OF_MONTH, Integer.valueOf(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[2]));
					cal2.set(Calendar.MONTH, Integer.valueOf(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[1]));
					cal2.set(Calendar.YEAR, Integer.valueOf(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[0]));
					ses.setFechaFin(cal2.getTime());
					ses.setPrecio(registroSesiones2.getFloat("Precio"));
					
					Statement comando4=(Statement) conexion.createStatement();
					ResultSet registroPelis2 = comando4.executeQuery("select * from películas where Código_Película=(select Código_Película from sesión where Código_Sesión='"+registroSesiones2.getString("Código_Sesión")+"')");
					Pelicula pel = null;
					while (registroPelis2.next()) {
						
						pel = new Pelicula();
						pel.setCodigoPelicula(registroPelis2.getString("Código_Película"));
						pel.setDuracion(registroPelis2.getInt("Duración"));
						pel.setNombre(registroPelis2.getString("Nombre"));
						pel.setGenero(registroPelis2.getString("Género"));
						
					}
				//	registroPelis2.close();
					
					ses.setxPelicula(pel);
					
					arraySesiones = reescribirArraySesiones(arraySesiones);
					arraySesiones[contSes]=ses;
					contSes++;
					
				}
			//	registroSesiones2.close();
				sal.setArraySesiones(arraySesiones);
				
				arraySalas = reescribirArraySalas(arraySalas);
				arraySalas[contSal]=sal;
				contSal++;
			}
		//	registroSalas2.close();
			cin.setArraySalas(arraySalas);
			
			arrayCines = reescribirArrayCines(arrayCines);
			arrayCines[i]=cin;
			i++;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayCines;
		
	}
	
	public Pelicula[] mostrarPeliculas(Cine[] arrayCines, int opcionCine) {
		//array de todas las pelis del cine
		Pelicula[] eleccionTodasPelis = new Pelicula[0];
		int peliCont=0;
		for(int w=0;w<arrayCines[opcionCine].getArraySalas().length;w++) {
			for(int z=0;z<arrayCines[opcionCine].getArraySalas()[w].getArraySesiones().length;z++) {
				eleccionTodasPelis = reescribirArrayPeliculas(eleccionTodasPelis);
				eleccionTodasPelis[peliCont]=arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPelicula();
				peliCont++;
			}
		}
		
		//hacer null los repetidos
		for(int s=0;s<eleccionTodasPelis.length-1;s++)
		{
		    for(int m=s + 1;m<eleccionTodasPelis.length;m++)
		    {

		                if(eleccionTodasPelis[s] != null && eleccionTodasPelis[s].equals(eleccionTodasPelis[m]))
		                {
		                	eleccionTodasPelis[m] = null; // para eliminar luego
		                }
		    } 
		}
		
		//array de todas las pelis del cine sin repetir peliculas
		
		int posNombre =0;
		Pelicula[] nombresPelisCine = new Pelicula[0];
		for(int x=0;x<eleccionTodasPelis.length;x++){
			if(eleccionTodasPelis[x]!=null) {
				nombresPelisCine = reescribirArrayPeliculas(nombresPelisCine);
				nombresPelisCine[posNombre]=eleccionTodasPelis[x];
				System.out.println(eleccionTodasPelis[x]);
				posNombre++;
			}
			
	    } 

		//array de todas las pelis del cine sin repetir peliculas
		System.out.println("***Pelis cine "+opcionCine+" (sin repes)***");
		
		return nombresPelisCine;
	}

	String[] hora;
	
	public String[] mostrarSesiones(Cine[] arrayCines, int opcionCine, int[] nSala, int[] nSesion) {
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		
		
		String[] hora = new String[0];
		String[] nombrePeli = new String[0];
		int[] nombreSala = new int[0];
		Float[] precioEntrada = new Float[0];
		
		String[] sesion = new String[0];

		
		for(int h=0;h<nSesion.length;h++) {
			
			nombrePeli = reescribirArrayStrings(nombrePeli);
			nombreSala = reescribirArrayInts(nombreSala);
			precioEntrada = reescribirArrayFloats(precioEntrada);
			
			hora = reescribirArrayStrings(hora);
			hora[h] = dt.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha()) +" "+ dt2.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
			nombrePeli[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getxPelicula().getNombre();
			nombreSala[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getNumero();
			precioEntrada[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getPrecio();
			
			sesion = reescribirArrayStrings(sesion);
			sesion[h]=hora[h]+" PM - "+nombrePeli[h]+"( Sala "+nombreSala[h]+")"+" - "+precioEntrada[h]+"€";
		}
		return sesion;
	}
	
	public String[] fechasPelicula(Cine[] arrayCines, int opcionCine, int[] nSala, int[] nSesion) {
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		String[] fechas = new String[0];
		for(int h=0;h<nSesion.length;h++) {
			fechas = reescribirArrayStrings(fechas);
			fechas[h] = dt.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
		}
		return fechas;
	}
	
	public Float[] preciosPelicula(Cine[] arrayCines, int opcionCine, int[] nSala, int[] nSesion) {
		Float[] preciosPelicula = new Float[0];
		for(int h=0;h<nSesion.length;h++) {
			preciosPelicula = reescribirArrayFloats(preciosPelicula);
			preciosPelicula[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getPrecio();
		}
		return preciosPelicula;
	}
	
	public Sala[] salasPelicula(Cine[] arrayCines, int opcionCine, int[] nSala, int[] nSesion) {
		Sala[] salasPelicula = new Sala[0];
		for(int h=0;h<nSesion.length;h++) {
			salasPelicula = reescribirArraySalas(salasPelicula);
			salasPelicula[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]];
		}
		return salasPelicula;
	}
	
	
	
public Cliente[] selectArrayClientes(Pelicula[] arrayViejo) {
	return null;
		
	}
	
public Entrada[] selectArrayEntradas(Pelicula[] arrayViejo) {
	return null;
	
}
	
	
	
	
	public Cine[] reescribirArrayCines(Cine[] arrayViejo) {
		// TODO Auto-generated method stub
		Cine[] arrayNuevo = new Cine[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public Sala[] reescribirArraySalas(Sala[] arrayViejo) {
		// TODO Auto-generated method stub
		Sala[] arrayNuevo = new Sala[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public Sesion[] reescribirArraySesiones(Sesion[] arrayViejo) {
		// TODO Auto-generated method stub
		Sesion[] arrayNuevo = new Sesion[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public Entrada[] reescribirArrayEntradas(Entrada[] arrayViejo) {
		// TODO Auto-generated method stub
		Entrada[] arrayNuevo = new Entrada[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public Cliente[] reescribirArrayClientes(Cliente[] arrayViejo) {
		// TODO Auto-generated method stub
		Cliente[] arrayNuevo = new Cliente[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public String[] reescribirArrayStrings(String[] arrayViejo) {
		// TODO Auto-generated method stub
		String[] arrayNuevo = new String[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public int[] reescribirArrayInts(int[] arrayViejo) {
		// TODO Auto-generated method stub
		int[] arrayNuevo = new int[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public Float[] reescribirArrayFloats(Float[] arrayViejo) {
		// TODO Auto-generated method stub
		Float[] arrayNuevo = new Float[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public JRadioButton[] reescribirArrayButtons(JRadioButton[] arrayViejo) {
		// TODO Auto-generated method stub
		JRadioButton[] arrayNuevo = new JRadioButton[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
	public Pelicula[] reescribirArrayPeliculas(Pelicula[] arrayViejo) {
		// TODO Auto-generated method stub
		Pelicula[] arrayNuevo = new Pelicula[arrayViejo.length+1];
		for(int i =0;i<arrayViejo.length;i++)
		{
			arrayNuevo[i]=arrayViejo[i];
		}
		arrayViejo = arrayNuevo;
		return arrayNuevo;
	}
	
}
