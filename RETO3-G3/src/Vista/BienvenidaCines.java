package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Modelo.Cine;

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
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reto3_grupo3","root"
			,"");
			comando=(Statement) conexion.createStatement();
			registroCines = comando.executeQuery("select * from cine");
			System.out.println(registroCines);
			int i=0;
			while (registroCines.next()) {
				nombreCines[i]=registroCines.getString("Nombre");
				//Cine ci = new Cine(title, title, title, null);
				//ci.setNombre(registroCines.getString("Nombre"));
				//Cine[] arrayCines = new Cine[10];
				i++;
			}
			
			
			ResultSet registroPelis = comando.executeQuery("select * from películas");
			int j=0;
			while (registroPelis.next()) {
				nombrePelis[j]=registroPelis.getString("Nombre");
				j++;
			}
			ResultSet registroHoras = comando.executeQuery("select * from sesión");
			int k=0;
			while (registroHoras.next()) {
				horaPelis[k]=registroHoras.getTime("Hora");
				k++;
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
		
		rdbtnNewRadioButton = new JRadioButton(nombreCines[0]);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(37, 61, 227, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton(nombreCines[1]);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(37, 106, 244, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton(nombreCines[2]);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(37, 156, 262, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton(nombreCines[3]);
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
