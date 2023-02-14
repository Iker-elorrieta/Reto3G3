package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Controlador.Metodos;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class FechayHorarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	String[] fechaInicio;
	String[] fechaFinal;
	private JLabel lblNewLabel_2;
	Metodos mts = new Metodos();
	int[] nSala;
	int[] nSesion;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param opcionPeli 
	 * @param nombresPelisCine 
	 * @param nSesion 
	 * @param nSala 
	 * @param opcionCine 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param pel 
	 * @param arrayCines 
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
	public FechayHorarios(Cine[] arrayCines, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine, Pelicula[] nombresPelisCine, int opcionPeli) {
	
		
		
		
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat bd = new SimpleDateFormat("yyyy-MM-dd");
	

		
		
		
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
		
		
		
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date selectedDate = (Date) datePicker.getModel().getValue();
				System.out.println(selectedDate);
			//	String selectedDateDT = dt.format(String.valueOf(selectedDate));
				System.out.println(selectedDate);
				
				if(rdbtnNewRadioButton.isSelected() || rdbtnNewRadioButton_1.isSelected()) {
					
					
						//&& Integer.valueOf(selectedDate.toString().split("-")[2])<=Integer.valueOf(fechaFinal[x].toString().split("-")[2])

					
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
				
//				if() {
//					lblNewLabel_2.setVisible(true);
//				}else {
//					lblNewLabel_2.setVisible(false);
//				}
				
				Date selectedDate = (Date) datePicker.getModel().getValue();
				System.out.println("**selected date**");
				System.out.println(bd.format(selectedDate));
				
				int contSesion=0;
				nSala = new int[arrayCines[opcionCine].getArraySalas().length];
				System.out.println("salas??");
				System.out.println(arrayCines[opcionCine].getArraySalas().length);
				nSesion = new int[2];//2
				System.out.println("For de sla y ses");
				lblNewLabel_2.setVisible(true);
				for(int w=0;w<arrayCines[opcionCine].getArraySalas().length;w++) {
					for(int z=0;z<arrayCines[opcionCine].getArraySalas()[w].getArraySesiones().length;z++) {
						
						Pelicula datosPeli=arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPelicula();
						//System.out.println(datosPeli.getNombre());
						//System.out.println(nombresPelisCine[opcionPeli].getNombre());
						System.out.println(bd.format(arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getFecha()));
						//System.out.println(bd.format(selectedDate));
						if(datosPeli.getCodigoPelicula().equals(nombresPelisCine[opcionPeli].getCodigoPelicula()) && bd.format(arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getFecha()).equals(bd.format(selectedDate))) {
							//y el datepicker equals lo de bdd
							lblNewLabel_2.setVisible(false);
							System.out.println("PeliculaSesiones");
							System.out.println(arrayCines[opcionCine].getArraySalas()[w].getArraySesiones()[z].getxPelicula());
							nSala[contSesion] = w;
							nSesion[contSesion] = z;
							contSesion++;
						}
						
					}
				}
				
				sesion=mts.mostrarSesiones(arrayCines, pel, arrayClientes, arrayEntradas, opcionCine, nSala, nSesion, nombresPelisCine, opcionPeli);
				
				
				if(!(lblNewLabel_2.isVisible())) {
					
				
				rdbtnNewRadioButton = new JRadioButton("Sesion 1:  "+sesion[0]);
				buttonGroup.add(rdbtnNewRadioButton);
				rdbtnNewRadioButton.setBounds(10, 64, 420, 23);
				contentPane.add(rdbtnNewRadioButton);
				rdbtnNewRadioButton.setVisible(false);
				
				rdbtnNewRadioButton_1 = new JRadioButton("Sesion 2:  "+sesion[1]);
				buttonGroup.add(rdbtnNewRadioButton_1);
				rdbtnNewRadioButton_1.setBounds(10, 116, 420, 23);
				contentPane.add(rdbtnNewRadioButton_1);
				rdbtnNewRadioButton_1.setVisible(false);
				}
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
		
		lblNewLabel_2 = new JLabel("*No hay sesiones en esa fecha (abrimos en abril de domingo a miercoles)");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(10, 43, 426, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
	}
}
