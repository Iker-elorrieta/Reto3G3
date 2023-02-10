package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

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
	/*	Entrada ent = new Entrada("", 3, cli, null);
		Pelicula pel = new Pelicula("", 134, "", "");
		Sala sal = new Sala("", 3, null);
		Sesion ses = new Sesion("", null, pel);*/
		
		Cine[] arrayCines = new Cine[100];
		Cliente[] arrayClientes = new Cliente[100];
		Entrada[] arrayEntradas = new Entrada[100];
		

		
		
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reto3_grupo3","root","");
			comando=(Statement) conexion.createStatement();
			registroCines = comando.executeQuery("select * from cine");
			int i=0;
			
			while (registroCines.next()) {
				
				arraySalas = new Sala[4];
				Cine cin = new Cine();
				
				cin.setCodigoCine(registroCines.getString("Código_Cine"));
				cin.setNombre(registroCines.getString("Nombre"));
				cin.setDireccion(registroCines.getString("Direccion"));
				Statement comando2=(Statement) conexion.createStatement();
				registroSalas2 = comando2.executeQuery("select * from salas where Código_Cine='"+registroCines.getString("Código_Cine")+"'");
				int contSal=0;
				while (registroSalas2.next()) {
					arraySesiones = new Sesion[2];
					Sala sal = new Sala();
					sal.setCodigoSala(registroSalas2.getString("Código_Sala"));
					sal.setNumero(registroSalas2.getInt("Numero"));
					
					Statement comando3=(Statement) conexion.createStatement();
					registroSesiones2 = comando3.executeQuery("select * from sesión where Código_Sala='"+registroSalas2.getString("Código_Sala")+"'");
					int contSes=0;
					
					while (registroSesiones2.next()) {
					
						Sesion ses = new Sesion();
						ses.setCodigoSesion(registroSesiones2.getString("Código_Sesión"));
						Calendar cal = Calendar.getInstance();
						System.out.println(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[0]);
						cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(registroSesiones2.getTime("Hora").toString().split(":")[0]));
						cal.set(Calendar.MINUTE, Integer.valueOf(registroSesiones2.getTime("Hora").toString().split(":")[1]));
						cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[2]));
						cal.set(Calendar.MONTH, Integer.valueOf(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[1]));
						cal.set(Calendar.YEAR, Integer.valueOf(registroSesiones2.getDate("Fecha_Inicio").toString().split("-")[0]));
						//ses.setFecha(registroSesiones2.getDate("Fecha_Inicio"));
						ses.setFecha(cal.getTime());
						
						Statement comando4=(Statement) conexion.createStatement();
						registroPelis2 = comando4.executeQuery("select * from películas where Código_Película=(select Código_Película from sesión where Código_Sesión='"+registroSesiones2.getString("Código_Sesión")+"')");
						while (registroPelis2.next()) {
							
							pel = new Pelicula();
							pel.setCodigoPelicula(registroPelis2.getString("Código_Película"));
							pel.setDuracion(registroPelis2.getInt("Duración"));
							pel.setNombre(registroPelis2.getString("Nombre"));
							pel.setGenero(registroPelis2.getString("Género"));
							
						}
					//	registroPelis2.close();
						
						ses.setxPeliculas(pel);
						
						arraySesiones[contSes]=ses;
						contSes++;
						
					}
				//	registroSesiones2.close();
					sal.setArraySesiones(arraySesiones);
					
					arraySalas[contSal]=sal;
					contSal++;
				}
			//	registroSalas2.close();
				cin.setArraySalas(arraySalas);
				
				arrayCines[i]=cin;
				i++;
			}
	//		registroCines.close();
		
			registroClientes = comando.executeQuery("select * from clientes");
			int i2=0;
			while (registroClientes.next()) {
				
				
				Cliente cli = new Cliente();
				cli.setDni(registroClientes.getString("DNI"));
				cli.setNombre(registroClientes.getString("Nombre"));
				cli.setApellidos(registroClientes.getString("Apellido"));
				cli.setSexo(registroClientes.getString("Sexo"));
				cli.setContrasena(registroClientes.getString("Contra"));
				
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
				
				arrayEntradas[i3]=ent;
				i3++;
			}
			registroEntradas.close();

			
			comando.close();
			conexion.close();
		} catch(SQLException ex){
				ex.printStackTrace();

		}

		System.out.println(arrayCines[0].getArraySalas()[0].getArraySesiones()[0].getxPeliculas().getNombre());
		System.out.println(arrayCines[0].getArraySalas()[1].getArraySesiones()[0].getxPeliculas().getNombre());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elija un Cine");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(153, 27, 128, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					opcionCine= 0;
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					opcionCine= 1;
				}
				else if(rdbtnNewRadioButton_2.isSelected()) {
					opcionCine= 2;
				}
				else if(rdbtnNewRadioButton_3.isSelected()) {
					opcionCine= 3;
				}
				
				
				if(opcionCine==-1) {
				
				lblNewLabel_1.setVisible(true);
				}else {
				//vent = new SeleccionPeliculas(arrayCines, arrayClientes, arrayEntradas, arrayPelis, arraySalas, arraySesiones, opcionCine);
					vent = new SeleccionPeliculas(arrayCines, arraySalas, arraySesiones, pel, arrayClientes, arrayEntradas, opcionCine);
				vent.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(328, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		rdbtnNewRadioButton = new JRadioButton(arrayCines[0].getNombre());
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(37, 61, 227, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton(arrayCines[1].getNombre());
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(37, 106, 244, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton(arrayCines[2].getNombre());
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(37, 156, 262, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton(arrayCines[3].getNombre());
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(37, 199, 262, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		

		
		JButton btnNewButton_1 = new JButton("Salir");
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
}
