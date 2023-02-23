package Vista;

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
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame implements ActionListener{

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
	Bienvenida vent3;
	int nCliente = 0;//-1
	Metodos mts = new Metodos();
	
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
	 * @param arrayPedidosAL 
	 * @param resumenCin 
	 * @param resumenSes 
	 * @param resumenSal 
	 * @param r 
	 * @param opcionSesion 
	 * @param selectedDate 
	 * @param opcionPeli 
	 * @param nombresPelisCine 
	 * @param precioFinal 
	 * @param opcionCine2 
	 * @param arrayEntradas2 
	 * @param pel2 
	 * @param arrayCines2 
	 */
	public LogIn(Cine[] arrayCines, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, Pedido[] arrayPedidos, int opcionCine, Pelicula[] nombresPelisCine, int opcionPeli, Date selectedDate, int opcionSesion, float precioFinal, int r, int[] resumenSal, int[] resumenSes, int[] resumenCin) {
		
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
		btnAceptar.addActionListener((ActionListener) this);
		btnAceptar.setBounds(321, 227, 105, 23);
		contentPane.add(btnAceptar);
		
		btnCrearusuario = new JButton("Crear un usuario");
		btnCrearusuario.addActionListener((ActionListener) this);
		btnCrearusuario.setBackground(new Color(192, 192, 192));
		btnCrearusuario.setForeground(new Color(0, 0, 0));
		btnCrearusuario.setBounds(14, 227, 143, 23);
		contentPane.add(btnCrearusuario);
		
		btnVolverInicio = new JButton("Volver al Inicio");
		btnVolverInicio.addActionListener((ActionListener) this);
		btnVolverInicio.setBackground(new Color(192, 192, 192));
		btnVolverInicio.setBounds(161, 227, 150, 23);
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar) {
			for(int i=0; i<arrayClientesAL.length; i++) {	
				if (String.valueOf(txtDNI.getText()).equals(arrayClientesAL[i].getDni())){
					if (String.valueOf(txtContrasenya.getPassword()).equals(arrayClientesAL[i].getContrasena())){
//						nCliente = mts.reescribirArrayInts(nCliente);
						nCliente = i;
						lblError.setVisible(false);
						this.dispose();
						vent = new Ticket(arrayCinesAL, pelAL, arrayClientesAL, arrayEntradasAL, arrayPedidosAL, opcionCineAL, nombresPelisCineAL, opcionPeliAL, selectedDateAL, opcionSesionAL, precioFinalAL, rAL, resumenSalAL, resumenSesAL, resumenCinAL, nCliente, null);
						vent.setVisible(true);
					}
				}else {
					lblError.setVisible(true);
				}
			}
		}
		if(e.getSource()==btnCrearusuario) {
			this.dispose();
			vent2 = new SingIn(arrayCinesAL, pelAL, arrayClientesAL, arrayEntradasAL, arrayPedidosAL, opcionCineAL, nombresPelisCineAL, opcionPeliAL, selectedDateAL, opcionSesionAL, precioFinalAL, rAL, resumenSalAL, resumenSesAL, resumenCinAL, 0);
			vent2.setVisible(true);
		}
		if(e.getSource()==btnVolverInicio) {
			this.dispose();
			vent3 = new Bienvenida();
			vent3.setVisible(true);
		}
		
		}
	
}