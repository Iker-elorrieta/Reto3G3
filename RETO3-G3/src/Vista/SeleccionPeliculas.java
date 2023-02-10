package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SeleccionPeliculas extends JFrame {

	private JPanel contentPane;
	String peli1;
	String peli2;
	String peli3;
	String peli4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	FechayHorarios vent;
	BienvenidaCines vent2;
	JLabel lblNewLabel_1;
	int opcionPeli=-1;
	String nombrePelicula;
	Metodos mts = new Metodos();
	Pelicula[] nombresPelisCine;
	int[] nSala;
	int[] nSesion;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param opcionCine 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param pel 
	 * @param arraySesiones 
	 * @param arraySalas 
	 * @param arrayCines 
	 * @param opcionCine 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param arrayCines 
	 * @param opcionCine 
	 * @param arraySesiones 
	 * @param arraySalas 
	 * @param arrayPelis 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param arrayCines 
	 * @param opcionCine 
	 * @param nombrePelis 
	 * @param horaPelis 
	 */
	public SeleccionPeliculas(Cine[] arrayCines, Sala[] arraySalas, Sesion[] arraySesiones, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine) {
		//sin mirar la tabla
		//???pos pelis
		
		
		
		if(opcionCine==0) {
			nombresPelisCine = mts.mostrarPeliculas(arrayCines, arraySalas, arraySesiones, pel, opcionCine);
		}
		else if(opcionCine==1) {
			nombresPelisCine = mts.mostrarPeliculas(arrayCines, arraySalas, arraySesiones, pel, opcionCine);
		}
		else if(opcionCine==2) {
			nombresPelisCine = mts.mostrarPeliculas(arrayCines, arraySalas, arraySesiones, pel, opcionCine);
		}
		else if(opcionCine==3) {
			nombresPelisCine = mts.mostrarPeliculas(arrayCines, arraySalas, arraySesiones, pel, opcionCine);
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Peliculas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 11, 367, 36);
		contentPane.add(lblNewLabel);
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(nombresPelisCine[0].getNombre());
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(19, 64, 295, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(nombresPelisCine[1].getNombre());
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(19, 101, 325, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(nombresPelisCine[2].getNombre());
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(19, 148, 310, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(nombresPelisCine[3].getNombre());
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(19, 189, 295, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					opcionPeli= 0;
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					opcionPeli= 1;
				}
				else if(rdbtnNewRadioButton_2.isSelected()) {
					opcionPeli= 2;
				}
				else if(rdbtnNewRadioButton_3.isSelected()) {
					opcionPeli= 3;
				}
				
				
				if(opcionPeli==-1) {
				
				lblNewLabel_1.setVisible(true);
				}else {
					int contSesion=0;
					nSala = new int[2];
					nSesion = new int[2];
					for(int w=0;w<arrayCines[opcionCine].getArraySalas().length;w++) {
						for(int z=0;z<arrayCines[opcionCine].getArraySalas()[w].getArraySesiones().length;z++) {
							
							Pelicula datosPeli=arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPeliculas();
							if(datosPeli.getCodigoPelicula().equals(nombresPelisCine[opcionPeli].getCodigoPelicula())) {
								System.out.println(arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPeliculas());
								nSala[contSesion] = w;
								nSesion[contSesion] = z;
								contSesion++;
							}
							
						}
					}
				//vent = new FechayHorarios(arrayCines, arrayClientes, arrayEntradas, arrayPelis, arraySalas, arraySesiones, opcionCine, opcionPeli);
					vent = new FechayHorarios(arrayCines, arraySalas, arraySesiones, pel, arrayClientes, arrayEntradas, opcionCine, nSala, nSesion);
				vent.setVisible(true);
				}
				
				
				

				
				
			}
		});
		btnNewButton.setBounds(269, 227, 155, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vent2 = new BienvenidaCines();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vent2.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(170, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("*Seleccione una pelicula");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(19, 236, 141, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		
	
		
		
	}

}
