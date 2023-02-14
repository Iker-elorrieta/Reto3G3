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
	//ResultSet registroPelis;
	//ResultSet registroSalas;
	//ResultSet registroSesiones;
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

		arrayCines = new Cine[0];
		arrayClientes = new Cliente[0];
		arrayEntradas = new Entrada[0];
		

		
		
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reto3_grupo3","root","");
			Statement comando=(Statement) conexion.createStatement();
			
			arrayCines=mts.mostrarCines();
		
			registroClientes = comando.executeQuery("select * from clientes");
			int i2=0;
			while (registroClientes.next()) {
				
				
				Cliente cli = new Cliente();
				cli.setDni(registroClientes.getString("DNI"));
				cli.setNombre(registroClientes.getString("Nombre"));
				cli.setApellidos(registroClientes.getString("Apellido"));
				cli.setSexo(registroClientes.getString("Sexo"));
				cli.setContrasena(registroClientes.getString("Contra"));
				
				arrayClientes = mts.reescribirArrayClientes(arrayClientes);
				arrayClientes[i2]=cli;
				i2++;
			}
			registroClientes.close();
			
			registroEntradas = comando.executeQuery("select * from entrada");
			int i3=0;
			while (registroEntradas.next()) {
				
				
				Entrada ent = new Entrada();
				ent.setCodigoEntrada(registroEntradas.getString("Código_Entrada"));
				ent.setPrecio(registroEntradas.getFloat("Precio"));
				ent.setxCliente(arrayClientes[i3]);
				ent.setArraySesiones(arraySesiones);
				
				arrayEntradas = mts.reescribirArrayEntradas(arrayEntradas);
				arrayEntradas[i3]=ent;
				i3++;
			}
			registroEntradas.close();

			
			comando.close();
			conexion.close();
		} catch(SQLException ex){
				ex.printStackTrace();

		}

		//reescribir arrays
				
		System.out.println(arrayCines[0].getArraySalas()[0].getArraySesiones()[0].getxPelicula().getNombre());
		System.out.println(arrayCines[0].getArraySalas()[1].getArraySesiones()[0].getxPelicula().getNombre());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
//				rdbtnNewRadioButton.setVisible(true);
//				rdbtnNewRadioButton_1.setVisible(true);
//				rdbtnNewRadioButton_2.setVisible(true);
//				rdbtnNewRadioButton_3.setVisible(true);
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
				
				btnNewButton.setVisible(true);
				btnNewButton_1.setVisible(true);
			}
		});
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//radios dynamicos
	
		
		lblNewLabel_2 = new JLabel("Bienvenido A");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBounds(60, 45, 335, 73);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\nNuestro Cine");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel_2_1.setBounds(60, 130, 335, 73);
		panel.add(lblNewLabel_2_1);
		
		lblNewLabel_2_2 = new JLabel(":)");
		lblNewLabel_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel_2_2.setBounds(140, 188, 126, 73);
		panel.add(lblNewLabel_2_2);
		
		
		JLabel lblNewLabel = new JLabel("Elija un Cine");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(153, 27, 128, 28);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//for
				//System.out.println(buttonGroup.getSelection());
				for(int h=0;h<arraybotones.length;h++) {
					//buttonGroup.getSelection();
					//buttonGroup.;
					if(arraybotones[h].isSelected()) {
						opcionCine= h;
					}
				}
//				if(rdbtnNewRadioButton.isSelected()) {
//					opcionCine= 0;
//				}
//				else if(rdbtnNewRadioButton_1.isSelected()) {
//					opcionCine= 1;
//				}
//				else if(rdbtnNewRadioButton_2.isSelected()) {
//					opcionCine= 2;
//				}
//				else if(rdbtnNewRadioButton_3.isSelected()) {
//					opcionCine= 3;
//				}
				
				
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
		btnNewButton.setVisible(false);

		//dynamic
	

		
		btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				//System.exit(0);
				
			}
		});
		btnNewButton_1.setBounds(229, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		lblNewLabel_1 = new JLabel("*No has seleccionado ningún cine");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(37, 231, 182, 14);
		contentPane.add(lblNewLabel_1);
		
//		rdbtnNewRadioButton = new JRadioButton(arrayCines[0].getNombre());
//		buttonGroup.add(rdbtnNewRadioButton);
//		rdbtnNewRadioButton.setBounds(37, 61, 227, 23);
//		contentPane.add(rdbtnNewRadioButton);
//		
//		rdbtnNewRadioButton_1 = new JRadioButton(arrayCines[1].getNombre());
//		buttonGroup.add(rdbtnNewRadioButton_1);
//		rdbtnNewRadioButton_1.setBounds(37, 106, 244, 23);
//		contentPane.add(rdbtnNewRadioButton_1);
//		
//		rdbtnNewRadioButton_2 = new JRadioButton(arrayCines[2].getNombre());
//		buttonGroup.add(rdbtnNewRadioButton_2);
//		rdbtnNewRadioButton_2.setBounds(37, 156, 262, 23);
//		contentPane.add(rdbtnNewRadioButton_2);
//		
//		rdbtnNewRadioButton_3 = new JRadioButton(arrayCines[3].getNombre());
//		buttonGroup.add(rdbtnNewRadioButton_3);
//		rdbtnNewRadioButton_3.setBounds(37, 199, 262, 23);
//		contentPane.add(rdbtnNewRadioButton_3);
		
//		rdbtnNewRadioButton_3.setVisible(false);
//		rdbtnNewRadioButton_2.setVisible(false);
//		rdbtnNewRadioButton_1.setVisible(false);
//		rdbtnNewRadioButton.setVisible(false);
		lblNewLabel_1.setVisible(false);
		

		

		

		
	}
}
