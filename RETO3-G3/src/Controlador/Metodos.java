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
	Sesion[] arraySesiones;
	
	private final String cine1 = "Codigo_Cine";
	private final String cine2 = "Nombre";
	private final String cine3 = "Direccion";
	
	private final String sala1 = "Codigo_Sala";
	private final String sala2 = "Numero";
	
	private final String sesion1 = "Codigo_Sesion";
	private final String sesion2 = "Hora";
	private final String sesion3 = "Fecha";
	private final String sesion4 = "Fecha_Inicio";
	private final String sesion5 = "Precio";

	private final String pelicula1 = "Codigo_Pelicula";
	private final String pelicula2 = "Duracion";
	private final String pelicula3 = "Nombre";
	private final String pelicula4 = "Genero";
	
	private final String tabla1 = "cine";
	private final String tabla2 = "salas";
	private final String tabla3 = "sesion";
	private final String tabla4 = "peliculas";

	private final String conexion1 = "jdbc:mysql://localhost:3306/reto3_grupo3";
	private final String conexion2 = "root";
	private final String conexion3 = "";
	//"+tabla1+"

	public Cine[] mostrarCines() {
		Cine[] arrayCines = new Cine[0];
		Connection conexion;
		try {
			conexion = (Connection) DriverManager.getConnection(conexion1,conexion2,conexion3);
	
		Statement comando=(Statement) conexion.createStatement();
		ResultSet registroCines = comando.executeQuery("select * from "+tabla1+"");
		int i=0;
		
		while (registroCines.next()) {
			
			Sala[] arraySalas = new Sala[0];
			Cine cin = new Cine();
			
			cin.setCodigoCine(registroCines.getString(cine1));
			cin.setNombre(registroCines.getString(cine2));
			cin.setDireccion(registroCines.getString(cine3));
			Statement comando2=(Statement) conexion.createStatement();
			ResultSet registroSalas2 = comando2.executeQuery("select * from "+tabla2+" where "+cine1+"='"+registroCines.getString(cine1)+"'");
			int contSal=0;
			while (registroSalas2.next()) {
				arraySesiones = new Sesion[0];
				Sala sal = new Sala();
				sal.setCodigoSala(registroSalas2.getString(sala1));
				sal.setNumero(registroSalas2.getInt(sala2));
				
				Statement comando3=(Statement) conexion.createStatement();
				ResultSet registroSesiones2 = comando3.executeQuery("select * from "+tabla3+" where "+sala1+"='"+registroSalas2.getString(sala1)+"'");
				int contSes=0;
				
				while (registroSesiones2.next()) {
				
					Sesion ses = new Sesion();
					ses.setCodigoSesion(registroSesiones2.getString(sesion1));
					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(registroSesiones2.getTime(sesion2).toString().split(":")[0]));
					cal.set(Calendar.MINUTE, Integer.valueOf(registroSesiones2.getTime(sesion2).toString().split(":")[1]));
					cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(registroSesiones2.getDate(sesion3).toString().split("-")[2]));
					cal.set(Calendar.MONTH, Integer.valueOf(registroSesiones2.getDate(sesion3).toString().split("-")[1]));
					cal.set(Calendar.YEAR, Integer.valueOf(registroSesiones2.getDate(sesion3).toString().split("-")[0]));
					//ses.setFecha(registroSesiones2.getDate("Fecha_Inicio"));
					ses.setFecha(cal.getTime());
					
					Calendar cal2 = Calendar.getInstance();
					cal2.set(Calendar.DAY_OF_MONTH, Integer.valueOf(registroSesiones2.getDate(sesion4).toString().split("-")[2]));
					cal2.set(Calendar.MONTH, Integer.valueOf(registroSesiones2.getDate(sesion4).toString().split("-")[1]));
					cal2.set(Calendar.YEAR, Integer.valueOf(registroSesiones2.getDate(sesion4).toString().split("-")[0]));
					ses.setFechaFin(cal2.getTime());
					ses.setPrecio(registroSesiones2.getFloat(sesion5));
					
					Statement comando4=(Statement) conexion.createStatement();
					ResultSet registroPelis2 = comando4.executeQuery("select * from "+tabla4+" where "+pelicula1+"=(select "+pelicula1+" from "+tabla3+" where "+sesion1+"='"+registroSesiones2.getString(sesion1)+"')");
					Pelicula pel = null;
					while (registroPelis2.next()) {
						
						pel = new Pelicula();
						pel.setCodigoPelicula(registroPelis2.getString(pelicula1));
						pel.setDuracion(registroPelis2.getInt(pelicula2));
						pel.setNombre(registroPelis2.getString(pelicula3));
						pel.setGenero(registroPelis2.getString(pelicula4));
						
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
			
			hora[h] = fechasPelicula(arrayCines, opcionCine, nSala, nSesion)[h];
			nombrePeli[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getxPelicula().getNombre();
			nombreSala[h] = salasPelicula(arrayCines, opcionCine, nSala, nSesion)[h].getNumero();
			precioEntrada[h] = preciosPelicula(arrayCines, opcionCine, nSala, nSesion)[h];
			
			sesion = reescribirArrayStrings(sesion);
			sesion[h]=hora[h]+" PM - "+nombrePeli[h]+"( Sala "+nombreSala[h]+")"+" - "+precioEntrada[h]+"€";
		}
		return sesion;
	}
	
	public String[] fechasPelicula(Cine[] arrayCines, int opcionCine, int[] nSala, int[] nSesion) {
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		String[] fechas = new String[0];
		for(int h=0;h<nSesion.length;h++) {
			fechas = reescribirArrayStrings(fechas);
			fechas[h] = dt.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha()) +" "+ dt2.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
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
	
	//
	public Sala[] salasPelicula(Cine[] arrayCines, int opcionCine, int[] nSala, int[] nSesion) {
		Sala[] salasPelicula = new Sala[0];
		for(int h=0;h<nSesion.length;h++) {
			salasPelicula = reescribirArraySalas(salasPelicula);
			salasPelicula[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]];
		}
		return salasPelicula;
	}
	
	
	public int[] nSesionPelicula(Cine[] arrayCines, int opcionCine, int[] nSala, int[] nSesion, Date selectedDate, Pelicula[] nombresPelisCine, int opcionPeli) {
		DateFormat bd = new SimpleDateFormat("yyyy-MM-dd");
		
		int contSesion=0;
		nSala = new int[0];
		nSesion = new int[0];//2
		for(int w=0;w<arrayCines[opcionCine].getArraySalas().length;w++) {
			for(int z=0;z<arrayCines[opcionCine].getArraySalas()[w].getArraySesiones().length;z++) {
				Pelicula datosPeli=arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPelicula();
				if(datosPeli.getCodigoPelicula().equals(nombresPelisCine[opcionPeli].getCodigoPelicula()) && bd.format(arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getFecha()).equals(bd.format(selectedDate))) {
					nSala = reescribirArrayInts(nSala);
					nSala[contSesion] = w;
					nSesion = reescribirArrayInts(nSesion);
					nSesion[contSesion] = z;
					contSesion++;
				}
			}
		}
		return nSesion;
	}
	
	public int[] nSalaPelicula(Cine[] arrayCines, int opcionCine, int[] nSala, int[] nSesion, Date selectedDate, Pelicula[] nombresPelisCine, int opcionPeli) {
		DateFormat bd = new SimpleDateFormat("yyyy-MM-dd");
		
		int contSesion=0;
		nSala = new int[0];
		nSesion = new int[0];//2
		for(int w=0;w<arrayCines[opcionCine].getArraySalas().length;w++) {
			for(int z=0;z<arrayCines[opcionCine].getArraySalas()[w].getArraySesiones().length;z++) {
				Pelicula datosPeli=arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPelicula();
				if(datosPeli.getCodigoPelicula().equals(nombresPelisCine[opcionPeli].getCodigoPelicula()) && bd.format(arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getFecha()).equals(bd.format(selectedDate))) {
					nSala = reescribirArrayInts(nSala);
					nSala[contSesion] = w;
					nSesion = reescribirArrayInts(nSesion);
					nSesion[contSesion] = z;
					contSesion++;
				}
			}
		}
		return nSala;
	}
	
	
	Cliente[] arrayClientes;
	private final String cliente1 = "DNI";
	private final String cliente2 = "Nombre";
	private final String cliente3 = "Apellido";
	private final String cliente4 = "Sexo";
	private final String cliente5 = "Contra";
	
	private final String tablaC = "clientes";
public Cliente[] selectArrayClientes() {
	arrayClientes = new Cliente[0];
	Connection conexion;
	
	try {
		conexion=(Connection) DriverManager.getConnection(conexion1,conexion2,conexion3);
		Statement comando=(Statement) conexion.createStatement();
	
		ResultSet registroClientes = comando.executeQuery("select * from "+tablaC+"");
		int i2=0;
		while (registroClientes.next()) {
			
			
			Cliente cli = new Cliente();
			cli.setDni(registroClientes.getString(cliente1));
			cli.setNombre(registroClientes.getString(cliente2));
			cli.setApellidos(registroClientes.getString(cliente3));
			cli.setSexo(registroClientes.getString(cliente4));
			cli.setContrasena(registroClientes.getString(cliente5));
			
			arrayClientes = reescribirArrayClientes(arrayClientes);
			arrayClientes[i2]=cli;
			i2++;
		}
		registroClientes.close();
		
		comando.close();
		conexion.close();
	} catch(SQLException ex){
			ex.printStackTrace();

	}
	
	
	
	return arrayClientes;
		
	}
	
private final String entrada1 = "Codigo_Entrada";
private final String entrada2 = "Precio";

private final String tablaE = "entrada";
//hacer insert
public Entrada[] selectArrayEntradas() {
	Entrada[] arrayEntradas = new Entrada[0];
	Connection conexion;
	
	try {
		conexion=(Connection) DriverManager.getConnection(conexion1,conexion2,conexion3);
		Statement comando=(Statement) conexion.createStatement();
		
		ResultSet registroEntradas = comando.executeQuery("select * from "+tablaE+"");
		int i3=0;
		while (registroEntradas.next()) {
			
			
			Entrada ent = new Entrada();
			ent.setCodigoEntrada(registroEntradas.getString(entrada1));
			ent.setPrecio(registroEntradas.getFloat(entrada2));
			ent.setxCliente(arrayClientes[i3]);
			ent.setArraySesiones(arraySesiones);
			
			arrayEntradas = reescribirArrayEntradas(arrayEntradas);
			arrayEntradas[i3]=ent;
			i3++;
		}
		registroEntradas.close();

		
		comando.close();
		conexion.close();
	} catch(SQLException ex){
			ex.printStackTrace();

	}
	
	return arrayEntradas;
	
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
