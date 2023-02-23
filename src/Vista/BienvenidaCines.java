package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pedido;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.util.Date;

public class BienvenidaCines extends JFrame implements ActionListener {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] nombreCines=new String[4];
	String[] nombrePelis=new String[16];
	Time[] horaPelis=new Time[32];
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	JRadioButton rdbtnNewRadioButton_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Connection conexion;
	ResultSet registroCines;
	ResultSet registroSalas2;
	ResultSet registroSesiones2;
	ResultSet registroPelis2;
	ResultSet registroClientes;
	ResultSet registroEntradas;
	Statement comando;
	SeleccionPeliculas vent;
	Resumen vent2;
	int opcionCine = -1;
	JLabel lblNewLabel_1;
	Sala[] arraySalas;
	Sesion[] arraySesiones;
	Pelicula pel;
	Metodos mts = new Metodos();
	Cine[] arrayCines;
	Cliente[] arrayClientes;
	Entrada[] arrayEntradas;
	Pedido[] arrayPedidos;
	JButton btnNewButton_1;
	JButton btnNewButton;
	int contR;
	
	JRadioButton button1;
	JRadioButton[] arraybotones;
	
	//variables action lisener o event..
	int rAL;
	int[] resumenSalAL;
	int[] resumenSesAL;
	int[] resumenCinAL;
	Cine[] arrayCines2AL;
	Pelicula pel2AL;
	Cliente[] arrayClientes2AL;
	Entrada[] arrayEntradas2AL;
	int opcionCine2AL;
	Pelicula[] nombresPelisCineAL;
	int opcionPeliAL;
	Date selectedDateAL;
	int opcionSesionAL;
	
	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					//int dato = 0;
//					BienvenidaCines frame = new BienvenidaCines();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param opcionPeli 
	 * @param nombresPelisCine 
	 * @param opcionCine2 
	 * @param arrayEntradas2 
	 * @param arrayClientes2 
	 * @param pel2 
	 * @param arrayCines2 
	 * @param opcionPeli 
	 * @param nombresPelisCine 
	 * @param opcionCine2 
	 * @param arrayEntradas2 
	 * @param arrayClientes2 
	 * @param pel2 
	 * @param arrayCines2 
	 * @param selectedDate 
	 * @param opcionSesion 
	 * @param resumenSes 
	 * @param resumenSal 
	 * @param resumenSes 
	 * @param resumenSal 
	 * @param r 
	 * @param resumenCin 
	 * @throws SQLException 
	 */
	public BienvenidaCines(Cine[] arrayCines2, Pelicula pel2, Cliente[] arrayClientes2, Entrada[] arrayEntradas2, int opcionCine2, Pelicula[] nombresPelisCine, int opcionPeli, Date selectedDate, int opcionSesion, int r, int[] resumenSal, int[] resumenSes, int[] resumenCin) {
//hay que hacer una array de sisiones y que si x valor es null no te lo sume (al volver es todo null)
		rAL = r;
		resumenSalAL = resumenSal;
		resumenSesAL = resumenSes;
		resumenCinAL = resumenCin;
		arrayCines2AL = arrayCines2;
		pel2AL = pel2;
		arrayClientes2AL = arrayClientes2;
		arrayEntradas2AL = arrayEntradas2;
		opcionCine2AL = opcionCine2;
		nombresPelisCineAL = nombresPelisCine;
		opcionPeliAL = opcionPeli;
		selectedDateAL = selectedDate;
		opcionSesionAL = opcionSesion;
		
		
		arrayCines = mts.mostrarCines();
		arrayClientes = mts.selectArrayClientes();
		arrayEntradas = mts.selectArrayEntradas();
		arrayPedidos = mts.selectArrayPedidos();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
				contR=0;
				arraybotones = new JRadioButton[0];
				for (int i = 0; i < arrayCines.length; i++) {

		            button1 = new JRadioButton(arrayCines[i].getNombre());
		            contR=contR+30;
		            button1.setToolTipText(String.valueOf(i));
		            button1.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
//		                    System.err.println("Action Performed..************");
//		                    System.out.println("This is action text.."+button1.getText()); 
//		                    System.out.println("tool tip text"+button1.getToolTipText());
		                }
		            });
		            button1.setBounds(37, 31+contR, 227, 23);
		            buttonGroup.add(button1);
		            contentPane.add(button1);
		            arraybotones = mts.reescribirArrayButtons(arraybotones);
		            arraybotones[i] = button1;
		        }
				
				
	
	
		
		
		
		JLabel lblNewLabel = new JLabel("Elija un Cine");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(153, 27, 128, 28);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener((ActionListener)this);
		btnNewButton.setBounds(328, 227, 89, 23);
		contentPane.add(btnNewButton);
		

		//dynamic
	

		
		btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener((ActionListener)this);
		btnNewButton_1.setBounds(229, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		lblNewLabel_1 = new JLabel("*No has seleccionado ningún cine");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(37, 231, 182, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		

		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			for(int h=0;h<arraybotones.length;h++) {
				if(arraybotones[h].isSelected()) {
					opcionCine= h;
				}
			}

			if(opcionCine==-1) {
			
			lblNewLabel_1.setVisible(true);
			}else {
				//cerrar this ventana
				this.dispose();
				vent = new SeleccionPeliculas(arrayCines, pel, arrayClientes, arrayEntradas, opcionCine, rAL, resumenSalAL, resumenSesAL, resumenCinAL);
			vent.setVisible(true);
			}
			
			
		}
		if(e.getSource()==btnNewButton_1) {
			//if arraycines es null exit y si no va a resumen
			if(arrayCines2AL == null) {
				System.exit(0);
			}else {
//				System.out.println("**resumen nums**");
//				for(int p=0;p<2;p++) {
//					System.out.println(resumenSal[p]);
//					System.out.println(resumenSes[p]);
//				}
				this.dispose();
				vent2 = new Resumen(arrayCines2AL, pel2AL, arrayClientes2AL, arrayEntradas2AL,arrayPedidos , opcionCine2AL, nombresPelisCineAL, opcionPeliAL, selectedDateAL, opcionSesionAL, rAL, resumenSalAL, resumenSesAL, resumenCinAL);
				vent2.setVisible(true);
			}

			
			
			
		}
	
	}

	
	
}
