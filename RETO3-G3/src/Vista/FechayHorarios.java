package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Modelo.Cine;
import Modelo.Cliente;
import Modelo.DateLabelFormatter;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class FechayHorarios extends JFrame {

	private JPanel contentPane;
	JDatePickerImpl datePicker;
	String sesion1;
	String sesion2;
	BienvenidaCines vent;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String[] sesion;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	
	Float[] precioEntrada;
	int[] nombreSala;
	String[] nombrePeli;
	String[] hora;
	JLabel lblNewLabel_1;
	
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
	 * @param opcionPeli 
	 * @param opcionCine 
	 * @param arraySesiones 
	 * @param arraySalas 
	 * @param arrayPelis 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param arrayCines 
	 * @param opcionPeli 
	 * @param opcionCine 
	 * @param arraySesiones 
	 * @param arraySalas 
	 * @param arrayPelis 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param arrayCines 
	 * @param opcion2 
	 * @param opcion 
	 * @param horaPelis 
	 * @param peli4 
	 * @param peli3 
	 * @param peli2 
	 * @param peli1 
	 * @param peli4 
	 * @param peli3 
	 * @param peli2 
	 * @param peli1 
	 * @param horaPelis 
	 * @param nombrePelis 
	 */
	public FechayHorarios(Cine[] arrayCines, Sala[] arraySalas, Sesion[] arraySesiones, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine, int[] nSala, int[] nSesion) {
		
		//sesiones
		//como sacar la sala de una peli
		//como sacar las sesiones de una peli
		int w=0;
//		arrayCines[opcionCine].getArraySalas()[nSala[0]].getArraySesiones()[nSesion[0]].getxPeliculas();
//		System.out.println("FechayCosas");
//		System.out.println(arrayCines[opcionCine].getArraySalas()[nSala[0]].getArraySesiones()[nSesion[0]].getxPeliculas());
//		System.out.println(arrayCines[opcionCine].getArraySalas()[nSala[0]].getArraySesiones()[nSesion[0]].getFecha());
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		hora = new String[2];
		nombrePeli = new String[2];
		nombreSala = new int[2];
		precioEntrada = new Float[2];
		sesion = new String[2];
		
		
		for(int h=0;h<2;h++) {
			hora[h] = dt2.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
			nombrePeli[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getxPeliculas().getNombre();
			nombreSala[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getNumero();
			precioEntrada[h] = arrayEntradas[h].getPrecio();
			sesion[h]=hora[h]+"-"+nombrePeli[h]+"( Sala "+nombreSala[h]+")"+"-"+precioEntrada[h]+"€";
		}
		
//		String hora1 = dt2.format(arrayCines[opcionCine].getArraySalas()[nSala[0]].getArraySesiones()[nSesion[0]].getFecha());
//		String nombrePeli1 = arrayCines[opcionCine].getArraySalas()[nSala[0]].getArraySesiones()[nSesion[0]].getxPeliculas().getNombre();
//		int nombreSala1 = arrayCines[opcionCine].getArraySalas()[nSala[0]].getNumero();
//		Float precioEntrada1 = arrayEntradas[0].getPrecio();
//		sesion1=hora1+"-"+nombrePeli1+"( Sala "+nombreSala1+")"+"-"+precioEntrada1+"€";
//		
//		
//		String hora2 = dt2.format(arrayCines[opcionCine].getArraySalas()[nSala[1]].getArraySesiones()[nSesion[1]].getFecha());
//		String nombrePeli2 = arrayCines[opcionCine].getArraySalas()[nSala[1]].getArraySesiones()[nSesion[1]].getxPeliculas().getNombre();
//		int nombreSala2 = arrayCines[opcionCine].getArraySalas()[nSala[1]].getNumero();
//		Float precioEntrada2 = arrayEntradas[1].getPrecio();
//		sesion2=hora2+"-"+nombrePeli2+"( Sala "+nombreSala2+")"+"-"+precioEntrada2+"€";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		contentPane.setLayout(null);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(68, 11, 202, 23);
		contentPane.add(datePicker);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(10, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		rdbtnNewRadioButton = new JRadioButton("Sesion 1:  "+sesion[0]);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(10, 64, 342, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setVisible(false);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Sesion 2:  "+sesion[1]);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(10, 116, 322, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setVisible(false);
		
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date selectedDate = (Date) datePicker.getModel().getValue();
				System.out.println(selectedDate);
				
				if(rdbtnNewRadioButton.isSelected()) {
					JOptionPane.showMessageDialog(null, "Sesion seleccionada correctamente");
					try {
						vent = new BienvenidaCines();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vent.setVisible(true);
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					JOptionPane.showMessageDialog(null, "Sesion seleccionada correctamente");
					try {
						vent = new BienvenidaCines();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vent.setVisible(true);
				}
				else {
					//label
					//JOptionPane.showMessageDialog(null, "Sesion no seleccionada");
					lblNewLabel_1.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(324, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				rdbtnNewRadioButton.setText("Sesion 1: "+sesion[0]);
//				rdbtnNewRadioButton_1.setText("Sesion 2: "+sesion[1]);
				rdbtnNewRadioButton.setVisible(true);
				rdbtnNewRadioButton_1.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(302, 11, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver al inicio");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vent = new BienvenidaCines();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vent.setVisible(true);
				
				
			}
		});
		btnNewButton_2.setBounds(177, 227, 137, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("*Sesion no seleccionada");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(240, 205, 173, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
	}
}
