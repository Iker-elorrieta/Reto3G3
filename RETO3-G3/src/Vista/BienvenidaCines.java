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
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

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
	ResultSet registroClientes;
	ResultSet registroEntradas;
	ResultSet registroPelis;
	ResultSet registroSalas;
	ResultSet registroSesiones;
	Statement comando;
	CompraPeliculas vent;

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
		Pelicula[] arrayPelis = new Pelicula[100];
		Sala[] arraySalas = new Sala[100];
		Sesion[] arraySesiones = new Sesion[100];
		
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reto3_grupo3","root"
			,"");
			comando=(Statement) conexion.createStatement();
			registroCines = comando.executeQuery("select * from cine");
			System.out.println(registroCines);
			int i=0;
			while (registroCines.next()) {
				
				Cine cin = new Cine("", "", "", null);
				
				cin.setCodigoCine(registroCines.getString("Código_Cine"));
				cin.setNombre(registroCines.getString("Nombre"));
				cin.setDireccion(registroCines.getString("Direccion"));
				cin.setArraySalas(null);
				
				arrayCines[i]=cin;
				i++;
			}
			
			registroClientes = comando.executeQuery("select * from clientes");
			int i2=0;
			while (registroClientes.next()) {
				
				
				Cliente cli = new Cliente("", "", "", "", "");
				cli.setDni(registroClientes.getString("DNI"));
				cli.setNombre(registroClientes.getString("Nombre"));
				cli.setApellidos(registroClientes.getString("Apellido"));
				cli.setSexo(registroClientes.getString("Sexo"));
				cli.setContrasena(registroClientes.getString("Contra"));
				
				arrayClientes[i2]=cli;
				i2++;
			}
			
			registroEntradas = comando.executeQuery("select * from entrada");
			int i3=0;
			while (registroEntradas.next()) {
				
				
				Entrada ent = new Entrada("", 3, null, null);
				ent.setCodigoEntrada(registroEntradas.getString("Código_Entrada"));
				ent.setPrecio(registroEntradas.getFloat("Precio"));
				ent.setxCliente(null);
				ent.setArraySesiones(null);
				
				arrayEntradas[i3]=ent;
				i3++;
			}
			
			registroPelis = comando.executeQuery("select * from películas");
			int i4=0;
			while (registroPelis.next()) {
				
				
				Pelicula pel = new Pelicula("", 134, "", "");
				pel.setCodigoPelicula(registroPelis.getString("Código_Película"));
				pel.setDuracion(registroPelis.getInt("Duración"));
				pel.setNombre(registroPelis.getString("Nombre"));
				pel.setGenero(registroPelis.getString("Género"));
				
				arrayPelis[i4]=pel;
				i4++;
			}
			
			
			registroSalas = comando.executeQuery("select * from salas");
			int i5=0;
			while (registroSalas.next()) {
				
				
				Sala sal = new Sala("", 23, null);
				sal.setCodigoSala(registroSalas.getString("Código_Sala"));
				sal.setNumero(registroSalas.getInt("Numero"));
				sal.setArraySesiones(null);
				
				arraySalas[i5]=sal;
				i5++;
			}
			
			registroSesiones = comando.executeQuery("select * from sesión");
			int i6=0;
			while (registroSesiones.next()) {
				
				
				Sesion ses = new Sesion("", null, null);
				ses.setCodigoSesion(registroSesiones.getString("Código_Sesión"));
				ses.setFecha(registroSesiones.getDate("Fecha_Inicio"));
				ses.setArrayPeliculas(null);
				
				arraySesiones[i6]=ses;
				i6++;
			}
			
			
			comando.close();
			
			registroCines.close();
			conexion.close();
		} catch(SQLException ex){
				ex.printStackTrace();

		}

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
					vent = new CompraPeliculas(nombrePelis,horaPelis, 0);
					vent.setVisible(true);
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					vent = new CompraPeliculas(nombrePelis,horaPelis, 1);
					vent.setVisible(true);
				}
				else if(rdbtnNewRadioButton_2.isSelected()) {
					vent = new CompraPeliculas(nombrePelis,horaPelis, 2);
					vent.setVisible(true);
				}
				else if(rdbtnNewRadioButton_3.isSelected()) {
					vent = new CompraPeliculas(nombrePelis,horaPelis, 3);
					vent.setVisible(true);
				}
				else {
					System.out.println("No has seleccionado ningún cine");
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
		
		
		registroCines.close();
		conexion.close();
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if ningula peli selecionada se sale, si no al resumen
				
			}
		});
		btnNewButton_1.setBounds(229, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
