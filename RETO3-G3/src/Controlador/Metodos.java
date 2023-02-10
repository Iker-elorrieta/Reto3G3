package Controlador;

import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

public class Metodos {


	
	public Pelicula[] mostrarPeliculas(Cine[] arrayCines, Sala[] arraySalas, Sesion[] arraySesiones, Pelicula pel, int opcionCine) {
		// TODO Auto-generated method stub
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
