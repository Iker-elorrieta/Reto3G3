package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JPasswordField txtContrasenya;

	JButton btnCrearusuario;
	JButton btnVolverInicio;
	JLabel lblError;
	JButton btnAceptar;
	JLabel lblDNI;
	JLabel lblContrasenya;
	JLabel lblTitulo;
	Ticket vent;
	SingIn vent2;
	BienvenidaCines vent3;

	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public LogIn(Cliente[] arrrydeClientes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Log in - Registro");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTitulo.setBounds(27, 11, 186, 49);
		contentPane.add(lblTitulo);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(27, 71, 56, 14);
		contentPane.add(lblDNI);
		
		lblContrasenya = new JLabel("Contrasena:");
		lblContrasenya.setBounds(27, 106, 89, 14);
		contentPane.add(lblContrasenya);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(126, 68, 121, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			for(int i=0; i<arrrydeClientes.length; i++) {	
				if (String.valueOf(txtDNI.getText()).equals(arrrydeClientes[i].getDni())){
					if (String.valueOf(txtContrasenya.getPassword()).equals(arrrydeClientes[i].getContrasena())){
						vent = new Ticket();
						vent.setVisible(true);
					}
				}else {
					lblError.setVisible(true);
				}
			}
			}
		});
		btnAceptar.setBounds(335, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCrearusuario = new JButton("Crear un usuario");
		btnCrearusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vent2 = new SingIn();
				vent2.setVisible(true);
			}
		});
		btnCrearusuario.setBackground(new Color(192, 192, 192));
		btnCrearusuario.setForeground(new Color(0, 0, 0));
		btnCrearusuario.setBounds(14, 227, 151, 23);
		contentPane.add(btnCrearusuario);
		
		btnVolverInicio = new JButton("Volver al Inicio");
		btnVolverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vent3 = new BienvenidaCines(null, null, null, null, 0, null, 0, null, 0, null, null);
				vent3.setVisible(true);
			}
		});
		btnVolverInicio.setBackground(new Color(192, 192, 192));
		btnVolverInicio.setBounds(175, 227, 150, 23);
		contentPane.add(btnVolverInicio);
		
		lblError = new JLabel("*Su usuario no esta registrado en la base de datos");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(14, 199, 312, 14);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		txtContrasenya = new JPasswordField();
		txtContrasenya.setBounds(126, 103, 121, 20);
		contentPane.add(txtContrasenya);
	}
}