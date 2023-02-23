package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pedido;
import Modelo.Pelicula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SingIn extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textApellido;
	private JComboBox<String> comboBoxSexo;
	private JPasswordField textContrasenya;
	Ticket vent;
	JButton btnAceptar;
	String[] arrayNuevoCliente = new String[5];
	Metodos mts = new Metodos();

	JLabel lblErrorVacio;
	JLabel lblErrorDNI;
	
	//variables actionListener
		Cine[] arrayCinesAL;
		Pelicula pelAL;
		Cliente[] arrayClientesAL;
		Entrada[] arrayEntradasAL;
		Pedido[] arrayPedidosAL;
		int opcionCineAL;
		Pelicula[] nombresPelisCineAL;
		int opcionPeliAL;
		Date selectedDateAL;
		int opcionSesionAL;
		float precioFinalAL;
		int rAL;
		int[] resumenSalAL;
		int[] resumenSesAL;
		int[] resumenCinAL;
		int nClienteAL;
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param nCliente 
	 * @param resumenCin 
	 * @param resumenSes 
	 * @param resumenSal 
	 * @param r 
	 * @param opcionSesion 
	 * @param selectedDate 
	 * @param opcionPeli 
	 * @param nombresPelisCine 
	 * @param opcionCine 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param pel 
	 * @param arrayCines 
	 * @param arrayPedidos 
	 * @param precioFinal 
	 */
	public SingIn(Cine[] arrayCines, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, Pedido[] arrayPedidos, int opcionCine, Pelicula[] nombresPelisCine, int opcionPeli, Date selectedDate, int opcionSesion, float precioFinal, int r, int[] resumenSal, int[] resumenSes, int[] resumenCin, int nCliente) {
		
		arrayCinesAL = arrayCines;
		pelAL = pel;
		arrayClientesAL = arrayClientes;
		arrayEntradasAL = arrayEntradas;
		arrayPedidosAL = arrayPedidos;
		opcionCineAL = opcionCine;
		nombresPelisCineAL = nombresPelisCine;
		opcionPeliAL = opcionPeli;
		selectedDateAL = selectedDate;
		opcionSesionAL = opcionSesion;
		precioFinalAL = precioFinal;
		rAL = r;
		resumenSalAL = resumenSal;
		resumenSesAL = resumenSes;
		resumenCinAL = resumenCin;
		nClienteAL =nCliente;
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSingIn = new JLabel("Sing In - Creacion de cuenta");
		lblSingIn.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSingIn.setBounds(26, 11, 301, 49);
		contentPane.add(lblSingIn);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(26, 81, 54, 14);
		contentPane.add(lblDNI);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(125, 71, 121, 20);
		contentPane.add(textDNI);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 112, 56, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(26, 148, 89, 14);
		contentPane.add(lblApellido);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(26, 173, 56, 14);
		contentPane.add(lblSexo);
		
		JLabel lblContrasenya = new JLabel("Contrasena:");
		lblContrasenya.setBounds(26, 204, 89, 14);
		contentPane.add(lblContrasenya);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(125, 109, 121, 20);
		contentPane.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(125, 140, 121, 20);
		contentPane.add(textApellido);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBackground(new Color(255, 255, 255));
		btnAceptar.addActionListener((ActionListener)this);
		btnAceptar.setBounds(283, 227, 121, 23);
		contentPane.add(btnAceptar);
		
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "H", "M"}));
		comboBoxSexo.setBounds(125, 169, 121, 22);
		contentPane.add(comboBoxSexo);
		
		textContrasenya = new JPasswordField();
		textContrasenya.setBounds(125, 201, 121, 20);
		contentPane.add(textContrasenya);
		
		lblErrorDNI = new JLabel("*DNI incorrecto");
		lblErrorDNI.setForeground(new Color(255, 0, 0));
		lblErrorDNI.setBounds(283, 74, 141, 14);
		contentPane.add(lblErrorDNI);
		lblErrorDNI.setVisible(false);
		
		lblErrorVacio = new JLabel("*Alguno de los campos esta vacio");
		lblErrorVacio.setForeground(new Color(255, 0, 0));
		lblErrorVacio.setBounds(26, 236, 220, 14);
		contentPane.add(lblErrorVacio);
		lblErrorVacio.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar) {
			if(mts.validarDNI(textDNI.getText())){	
				lblErrorDNI.setVisible(false);
			
					if (String.valueOf(textDNI.getText()).equals("") || String.valueOf(textNombre.getText()).equals("") || String.valueOf(textApellido.getText()).equals("") || String.valueOf(textContrasenya.getPassword()).equals("") || comboBoxSexo.getSelectedItem().toString().equals("")){
						lblErrorVacio.setVisible(true);
					}else {
						//ncliente = -1 y array de clienteNuevo
						
						arrayNuevoCliente[0]= textDNI.getText().toUpperCase();
						arrayNuevoCliente[1]= textNombre.getText();
						arrayNuevoCliente[2]= textApellido.getText();
						arrayNuevoCliente[3]= comboBoxSexo.getSelectedItem().toString();
						arrayNuevoCliente[4]= String.valueOf(textContrasenya.getPassword());
						
						//System.out.println(String.valueOf(textContrasenya.getPassword()));
						
						this.dispose();
						vent = new Ticket(arrayCinesAL, pelAL, arrayClientesAL, arrayEntradasAL, arrayPedidosAL, opcionCineAL, nombresPelisCineAL, opcionPeliAL, selectedDateAL, opcionSesionAL, precioFinalAL, rAL, resumenSalAL, resumenSesAL, resumenCinAL, nClienteAL, arrayNuevoCliente);
						vent.setVisible(true);
					}
			}else {
				lblErrorDNI.setVisible(true);
			}
		}
	
		}
	
}