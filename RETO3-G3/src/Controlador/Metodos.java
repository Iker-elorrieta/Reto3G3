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
		//??? radios?? array?? BDD??
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
					//System.out.println(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[0]);
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
	
	public void radiosDynamicos(Cine[] arrayCines, ButtonGroup buttonGroup, Container contentPane) {
		int contR = 0;
		for (int i = 0; i < arrayCines.length; i++) {

            JRadioButton button1 = new JRadioButton(arrayCines[i].getNombre());
            button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("");
					System.out.println("");
				}
            	
            	
            });
            contR=contR+30;
            button1.setBounds(37, 31+contR, 227, 23);
            buttonGroup.add(button1);
            contentPane.add(button1);
            button1.setVisible(false);
            

            button1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.err.println("Action Performed..************");
                    System.out.println("This is action text.."+button1.getText()); 

                }
            });

        }
	}
	
	
	//hacer radiobutons dinamicamente
	public Pelicula[] mostrarPeliculas(Cine[] arrayCines, Pelicula pel, int opcionCine) {
		//array de todas las pelis del cine
		Pelicula[] eleccionTodasPelis = new Pelicula[144];
		int peliCont=0;
		for(int w=0;w<arrayCines[opcionCine].getArraySalas().length;w++) {
			for(int z=0;z<arrayCines[opcionCine].getArraySalas()[w].getArraySesiones().length;z++) {
				eleccionTodasPelis[peliCont]=arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPelicula();
				peliCont++;
			}
		}
		
		for(int s=0;s<eleccionTodasPelis.length-1;s++)
		{
		    for(int m=s + 1;m<eleccionTodasPelis.length;m++)
		    {

		                if(eleccionTodasPelis[s] != null && eleccionTodasPelis[s].equals(eleccionTodasPelis[m]))
		                {
		                  // array = ArrayUtils.removeElement(array, array[s]); --m;??
		                	eleccionTodasPelis[m] = null; // Mark for deletion later on
		                }
		    } 
		}
		
		int posNombre =0;
		Pelicula[] nombresPelisCine = new Pelicula[100];
		for(int x=0;x<eleccionTodasPelis.length;x++){
			if(eleccionTodasPelis[x]!=null) {
				nombresPelisCine[posNombre]=eleccionTodasPelis[x];
				System.out.println(eleccionTodasPelis[x]);
				posNombre++;
			}
			
	    } 

		//array de todas las pelis del cine sin repetir peliculas
		System.out.println("***Pelis cine "+opcionCine+" (sin repes)***");
		
//		int posNombre =0;
//		int cont=0;
//		int repe=0;
//		for(int sys2=0;sys2<eleccionTodasPelis.length;sys2++) {
//			if(eleccionTodasPelis[sys2].getCodigoPelicula().equals(eleccionTodasPelis[cont].getCodigoPelicula())) {
//				repe++;
//				if(repe==0 || repe==1) {
//					nombresPelisCine[posNombre]=eleccionTodasPelis[sys2];
//					System.out.println(eleccionTodasPelis[sys2].getNombre());
//					posNombre++;
//				}else {
//					repe=0;
//				}
//				
//				cont++;
//			}
		
		return nombresPelisCine;
	}
	
//	   public static Pelicula[] removeDuplicates(Pelicula[] arr) {
//		   Pelicula[] arraySinDup = new Pelicula[4];
//	        int k = 0;
//	        for (int i = 0; i < arr.length; i++) {
//	            if (i == 0 || arr[i].getCodigoPelicula() != arr[i - 1].getCodigoPelicula()) {
//	            	arraySinDup[k++] = arr[i];
//	                System.out.println(arr[i].getCodigoPelicula());
//	            }
//	        }
//	        return arraySinDup;
//	    }

	public String[] mostrarSesiones(Cine[] arrayCines, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine, int[] nSala, int[] nSesion, Pelicula[] nombresPelisCine, int opcionPeli) {
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		String[] hora = new String[2];
		String[] nombrePeli = new String[2];
		int[] nombreSala = new int[2];
		Float[] precioEntrada = new Float[2];
		String[] sesion = new String[2];
		

		
		for(int h=0;h<2;h++) {
			hora[h] = dt.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
			nombrePeli[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getxPelicula().getNombre();
			nombreSala[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getNumero();
			precioEntrada[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getPrecio();
			
			sesion[h]=hora[h]+" PM - "+nombrePeli[h]+"( Sala "+nombreSala[h]+")"+" - "+precioEntrada[h]+"€";
		}
		return sesion;
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
	
	
	
	
}
