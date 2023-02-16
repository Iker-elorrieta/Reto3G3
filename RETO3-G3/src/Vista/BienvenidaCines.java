package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;
import Modelo.Sala;
import Modelo.Sesion;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import java.util.Date;

public class BienvenidaCines extends JFrame {

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
	int opcionCine = -1;
	JLabel lblNewLabel_1;
	Sala[] arraySalas;
	Sesion[] arraySesiones;
	Pelicula pel;
	Metodos mts = new Metodos();
	Cine[] arrayCines;
	Cliente[] arrayClientes;
	Entrada[] arrayEntradas;
	private JPanel panel;
	JButton btnNewButton_1;
	JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_2;
	int contR;
	
	JRadioButton button1;
	JRadioButton[] arraybotones;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BienvenidaCines frame = new BienvenidaCines();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public BienvenidaCines() throws SQLException {

		arrayCines = mts.mostrarCines();
		arrayClientes = mts.selectArrayClientes();
		arrayEntradas = mts.selectArrayEntradas();
		
				
		System.out.println(arrayCines[0].getArraySalas()[0].getArraySesiones()[0].getxPelicula().getNombre());
		System.out.println(arrayCines[0].getArraySalas()[1].getArraySesiones()[0].getxPelicula().getNombre());
		
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
		                    System.err.println("Action Performed..************");
		                    System.out.println("This is action text.."+button1.getText()); 
		                    System.out.println("tool tip text"+button1.getToolTipText());
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int h=0;h<arraybotones.length;h++) {
					if(arraybotones[h].isSelected()) {
						opcionCine= h;
					}
				}

				if(opcionCine==-1) {
				
				lblNewLabel_1.setVisible(true);
				}else {
					//cerrar this ventana
					vent = new SeleccionPeliculas(arrayCines, pel, arrayClientes, arrayEntradas, opcionCine);
				vent.setVisible(true);
				}
			}
		});
		
		
		btnNewButton.setBounds(328, 227, 89, 23);
		contentPane.add(btnNewButton);
		

		//dynamic
	

		
		btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				System.exit(0);
				
				
			}
		});
		btnNewButton_1.setBounds(229, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		lblNewLabel_1 = new JLabel("*No has seleccionado ningún cine");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(37, 231, 182, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		

		
	}

	public BienvenidaCines(int click) {
		// TODO Auto-generated constructor stub
	}
}
