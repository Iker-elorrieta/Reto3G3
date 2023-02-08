package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	JLabel lblNewLabel_1;
	int opcionPeli=-1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
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
	public SeleccionPeliculas(Cine[] arrayCines, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine) {
		
		
		
		if(opcionCine==0) {
			//sin mirar la tabla
			//???pos pelis
			System.out.println(arrayCines[0].getArraySalas()[0].getArraySesiones()[0].getxPeliculas().getNombre());
			peli1=arrayCines[opcionCine].getArraySalas()[0].getArraySesiones()[0].getxPeliculas().getNombre();
			peli2=arrayCines[opcionCine].getArraySalas()[1].getArraySesiones()[4].getxPeliculas().getNombre();
			peli3=arrayCines[opcionCine].getArraySalas()[2].getArraySesiones()[8].getxPeliculas().getNombre();
			peli4=arrayCines[opcionCine].getArraySalas()[3].getArraySesiones()[12].getxPeliculas().getNombre();
		}
		else if(opcionCine==1) {
			peli1=arrayCines[opcionCine].getArraySalas()[4].getArraySesiones()[1].getxPeliculas().getNombre();
			peli2=arrayCines[opcionCine].getArraySalas()[5].getArraySesiones()[5].getxPeliculas().getNombre();
			peli3=arrayCines[opcionCine].getArraySalas()[6].getArraySesiones()[9].getxPeliculas().getNombre();
			peli4=arrayCines[opcionCine].getArraySalas()[7].getArraySesiones()[13].getxPeliculas().getNombre();
		}
		else if(opcionCine==2) {
			peli1=arrayCines[opcionCine].getArraySalas()[8].getArraySesiones()[2].getxPeliculas().getNombre();
			peli2=arrayCines[opcionCine].getArraySalas()[9].getArraySesiones()[6].getxPeliculas().getNombre();
			peli3=arrayCines[opcionCine].getArraySalas()[10].getArraySesiones()[10].getxPeliculas().getNombre();
			peli4=arrayCines[opcionCine].getArraySalas()[11].getArraySesiones()[14].getxPeliculas().getNombre();
		}
		else if(opcionCine==3) {
			peli1=arrayCines[opcionCine].getArraySalas()[12].getArraySesiones()[3].getxPeliculas().getNombre();
			peli2=arrayCines[opcionCine].getArraySalas()[13].getArraySesiones()[7].getxPeliculas().getNombre();
			peli3=arrayCines[opcionCine].getArraySalas()[14].getArraySesiones()[11].getxPeliculas().getNombre();
			peli4=arrayCines[opcionCine].getArraySalas()[15].getArraySesiones()[15].getxPeliculas().getNombre();
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
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(peli1);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(19, 64, 295, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(peli2);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(19, 101, 325, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(peli3);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(19, 148, 310, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(peli4);
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
				//vent = new FechayHorarios(arrayCines, arrayClientes, arrayEntradas, arrayPelis, arraySalas, arraySesiones, opcionCine, opcionPeli);
				vent.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(269, 227, 155, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(170, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("*Seleccione una pelicula");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(19, 236, 141, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
	}

}
