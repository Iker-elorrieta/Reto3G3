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
	
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
//		DateFormat dt2 = new SimpleDateFormat("hh:mm");
//		
//		hora = new String[2];
//		nombrePeli = new String[2];
//		nombreSala = new int[2];
//		precioEntrada = new Float[2];
//		sesion = new String[2];
//		
		fechaInicio = new String[2];
		fechaFinal = new String[2];
//		
//		
//		for(int h=0;h<2;h++) {
//			hora[h] = dt2.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
//			nombrePeli[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getxPelicula().getNombre();
//			nombreSala[h] = arrayCines[opcionCine].getArraySalas()[nSala[h]].getNumero();
//			precioEntrada[h] = arrayEntradas[h].getPrecio();
//			
//			sesion[h]=hora[h]+" PM - "+nombrePeli[h]+"( Sala "+nombreSala[h]+")"+" - "+precioEntrada[h]+"€";
//			
//			fechaInicio[h] = dt.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
//			fechaFinal[h] = dt.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFechaFin());
//		}
//		
		for(int h=0;h<2;h++) {
			fechaInicio[h] = dt.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFecha());
			fechaFinal[h] = dt.format(arrayCines[opcionCine].getArraySalas()[nSala[h]].getArraySesiones()[nSesion[h]].getFechaFin());
		}
		
		sesion=mts.mostrarSesiones(arrayCines, arraySalas, arraySesiones, pel, arrayClientes, arrayEntradas, opcionCine, nSala, nSesion);
		
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
		rdbtnNewRadioButton.setBounds(10, 64, 420, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setVisible(false);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Sesion 2:  "+sesion[1]);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(10, 116, 420, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setVisible(false);
		
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date selectedDate = (Date) datePicker.getModel().getValue();
				System.out.println(selectedDate);
			//	String selectedDateDT = dt.format(String.valueOf(selectedDate));
				System.out.println(selectedDate);
				
				if(rdbtnNewRadioButton.isSelected() || rdbtnNewRadioButton_1.isSelected()) {
					
					
						//&& Integer.valueOf(selectedDate.toString().split("-")[2])<=Integer.valueOf(fechaFinal[x].toString().split("-")[2])
						if(!(Integer.valueOf(dt.format(selectedDate).split("-")[1])==03)) {
							//JOptionPane.showMessageDialog(null, "No hay sesiones disponibles en esa fecha");
							lblNewLabel_2.setVisible(true);
						}else {
							lblNewLabel_2.setVisible(false);
					
					JOptionPane.showMessageDialog(null, "Sesion seleccionada correctamente");
					try {
						vent = new BienvenidaCines();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vent.setVisible(true);
						}
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
		
		lblNewLabel_2 = new JLabel("*No hay sesiones disponibles en esa fecha (solo habrimos en marzo :D)");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(10, 43, 426, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
	}
}
