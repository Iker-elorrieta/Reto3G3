package Controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

public class Metodos {

	public void mostrarCines() {
		//??? radios?? array?? BDD??
		
	}
	
	//hacer radiobutons dinamicamente
	public Pelicula[] mostrarPeliculas(Cine[] arrayCines, Sala[] arraySalas, Sesion[] arraySesiones, Pelicula pel, int opcionCine) {
		//array de todas las pelis del cine
		Pelicula[] eleccionTodasPelis = new Pelicula[8];
		String nombrePelicula="";
		int peliCont=0;
		for(int w=0;w<arrayCines[opcionCine].getArraySalas().length;w++) {
			for(int z=0;z<arrayCines[opcionCine].getArraySalas()[w].getArraySesiones().length;z++) {
				eleccionTodasPelis[peliCont]=arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPelicula();
				peliCont++;
			}
		}

		//array de todas las pelis del cine sin repetir peliculas
		System.out.println("***Pelis cine "+opcionCine+" (sin repes)***");
		Pelicula[] nombresPelisCine = new Pelicula[4];
		int posNombre =0;
		int cont=0;
		int repe=0;
		for(int sys2=0;sys2<eleccionTodasPelis.length;sys2++) {
			if(eleccionTodasPelis[sys2].getCodigoPelicula().equals(eleccionTodasPelis[cont].getCodigoPelicula())) {
				repe++;
				if(repe==0 || repe==1) {
					nombresPelisCine[posNombre]=eleccionTodasPelis[sys2];
					//System.out.println(eleccionTodasPelis[sys2].getNombre());
					posNombre++;
				}else {
					repe=0;
				}
				
				cont++;
			}
		}
		return nombresPelisCine;
	}
	

	public String[] mostrarSesiones(Cine[] arrayCines, Sala[] arraySalas, Sesion[] arraySesiones, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine, int[] nSala, int[] nSesion) {
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		String[] hora = new String[2];
		String[] nombrePeli = new String[2];
		int[] nombreSala = new int[2];
		Float[] precioEntrada = new Float[2];
		String[] sesion = new String[2];
		
		
		for(int h=0;h<2;h++) {
			hora[h] = dt2.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
			nombrePeli[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getxPelicula().getNombre();
			nombreSala[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getNumero();
			precioEntrada[h] = arrayEntradas[h].getPrecio();
			
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
