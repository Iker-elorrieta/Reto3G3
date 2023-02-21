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
	int cambioDia;
	
	int contR;
	JRadioButton[] arraybotones;
	JRadioButton button1;
	int opcionSesion;
	
	int r2;
	int[] resumenSal2;
	int[] resumenSes2;
	int[] resumenCin2;
	
	
	
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
	 * @param resumenCin 
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
	public FechayHorarios(Cine[] arrayCines, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine, Pelicula[] nombresPelisCine, int opcionPeli, int r, int[] resumenSal, int[] resumenSes, int[] resumenCin) {
	
		r2=r;
		resumenSal2 = resumenSal;
		resumenSes2 = resumenSes;
		resumenCin2 = resumenCin;
		
		
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
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker.setForeground(new Color(0, 0, 0));
		datePicker.setBackground(new Color(192, 192, 192));
		datePicker.setBounds(68, 11, 202, 23);
		contentPane.add(datePicker);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(10, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(cambioDia>0) {
					
					for(int h=0;h<arraybotones.length;h++) {
						if(arraybotones[h].isSelected()) {
							opcionSesion= h;
						}
					}
					
				
				Date selectedDate = (Date) datePicker.getModel().getValue();
				System.out.println(selectedDate);
			//	String selectedDateDT = dt.format(String.valueOf(selectedDate));
				System.out.println(selectedDate);
				
				boolean seleccion=false;
				for(int b=0; b<arraybotones.length;b++) {
	
				if(arraybotones[b].isSelected()) {
					seleccion=true;
					lblNewLabel_1.setVisible(false);
					
					JOptionPane.showMessageDialog(null, "Sesion seleccionada correctamente");
					
					
					
					resumenSal2 = mts.reescribirArrayInts(resumenSal2);
					resumenSal2[r2] = nSala[opcionSesion];
					resumenSes2 = mts.reescribirArrayInts(resumenSes2);
					resumenSes2[r2] = nSesion[opcionSesion];
					resumenCin2 = mts.reescribirArrayInts(resumenCin2);
					resumenCin2[r2] = opcionCine;
					r2++;
						vent = new BienvenidaCines(arrayCines, pel, arrayClientes, arrayEntradas, opcionCine, nombresPelisCine, opcionPeli, selectedDate, opcionSesion, r2, resumenSal2, resumenSes2, resumenCin2);
						
							//vent = new BienvenidaCines();
						
						
					
					vent.setVisible(true);
						
				}
				else if(seleccion==false){
					lblNewLabel_1.setVisible(true);
					}
				}
			}else {
				lblNewLabel_1.setVisible(true);
			}
			}
		});
		btnNewButton.setBounds(324, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		cambioDia = 0;
		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//si se selecciona una sesion disponible y luego otra se tiene que poner invisible la anterior
				if(cambioDia>0) {
					for(int b=0; b<arraybotones.length;b++) {
						arraybotones[b].setVisible(false);
					} 
				}
				
				Date selectedDate = (Date) datePicker.getModel().getValue();
				System.out.println("**selected date**");
				System.out.println(bd.format(selectedDate));
				
				//sacar numero de sala y de sesion de la pelicula elegida
				//no se puede poner en metodos porque tendria que devolber dos cosas y porque tambien se usa para poner un label si las peliculas no son correctas o hacer el label invisible si si lo son 
				
				nSala = new int[0];
				nSesion = new int[0];//2
				lblNewLabel_2.setVisible(true);
			
				nSala = mts.reescribirArrayInts(nSala);
				nSala = mts.nSalaPelicula(arrayCines, opcionCine, nSala, nSesion, selectedDate, nombresPelisCine, opcionPeli);
				nSesion = mts.reescribirArrayInts(nSesion);
				nSesion = mts.nSesionPelicula(arrayCines, opcionCine, nSala, nSesion, selectedDate, nombresPelisCine, opcionPeli);
				
				for(int v=0; v<nSesion.length;v++) {
					if(nSesion!=null) {
						lblNewLabel_2.setVisible(false);
					}	
				}
				
				
				
				if(!(lblNewLabel_2.isVisible())) {
					sesion=mts.mostrarSesiones(arrayCines, opcionCine, nSala, nSesion);
					
					contR=0;
					arraybotones = new JRadioButton[0];
					for (int i = 0; i < sesion.length; i++) {

			            button1 = new JRadioButton(sesion[i]);
			            contR=contR+30;
			            button1.setToolTipText(String.valueOf(i));
			            button1.addActionListener(new ActionListener() {
			                @Override
			                public void actionPerformed(ActionEvent e) {
			                    System.err.println("Action Performed..************");
			                    System.out.println("This is action text.."+button1.getText()); 
			                    System.out.println("tool tip text"+button1.getToolTipText());
			                }
			            });
			            button1.setBounds(37, 31+contR, 420, 23);
			            buttonGroup.add(button1);
			            contentPane.add(button1);
			            //lo hago visible false y true porque sino como que tarda en cargar
			            button1.setVisible(false);
			            button1.setVisible(true);
			            arraybotones = mts.reescribirArrayButtons(arraybotones);
			            arraybotones[i] = button1;
			        }
					for(int b=0; b<arraybotones.length;b++) {
						arraybotones[b].setVisible(true);
					}
					cambioDia++;
				}
				if(lblNewLabel_2.isVisible()) {
					if(arraybotones!=null) {
						for(int b=0; b<arraybotones.length;b++) {
							arraybotones[b].setVisible(false);
						} 
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(302, 11, 100, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver al inicio");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					vent = new BienvenidaCines(null, null, null, null, 0, null, 0, null, 0, r, resumenSal, resumenSes, resumenCin);
					
						
							//vent = new BienvenidaCines();
						
				
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
