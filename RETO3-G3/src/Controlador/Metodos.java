package Controlador;

import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

public class Metodos {

	private void textoGIT() {
		// TODO Auto-generated method stub
System.out.println("texhfaaaffdadddadggghhfsd ");
	}
	
	public Pelicula[] mostrarPeliculas(Cine[] arrayCines, Sala[] arraySalas, Sesion[] arraySesiones, Pelicula pel, int opcionCine) {
		// TODO Auto-generated method stub
		//array de todas las pelis del cine
		Pelicula[] eleccionTodasPelis = new Pelicula[8];
		String nombrePelicula="";
		int peliCont=0;
		for(int w=0;w<arrayCines[opcionCine].getArraySalas().length;w++) {
			for(int z=0;z<arrayCines[opcionCine].getArraySalas()[w].getArraySesiones().length;z++) {
				eleccionTodasPelis[peliCont]=arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPeliculas();
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
}
