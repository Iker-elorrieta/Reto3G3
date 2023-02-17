package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Resumen extends JFrame {

	private JPanel contentPane;
	String[] sesion;
	Metodos mts = new Metodos();
	int[] nSala;
	int[] nSesion;
	LogIn vent;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param opcionPeli 
	 * @param nombresPelisCine 
	 * @param opcionCine2 
	 * @param arrayEntradas2 
	 * @param arrayClientes2 
	 * @param pel2 
	 * @param arrayCines2 
	 * @param selectedDate 
	 */
	public Resumen(Cine[] arrayCines2, Pelicula pel2, Cliente[] arrayClientes2, Entrada[] arrayEntradas2, int opcionCine2, Pelicula[] nombresPelisCine, int opcionPeli, Date selectedDate) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Resumen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(164, 11, 91, 25);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 36, 383, 187);
		contentPane.add(textArea);
		
		//textArea.setText("sdsdh\n\nsddf\n\nsddf\n\nsddf\n\nsddf\n\nsddf\n\nsddf\n\nsddf\n\nsdd77f");
		nSala = new int[0];
		nSesion = new int[0];
		
		nSala = mts.reescribirArrayInts(nSala);
		nSala = mts.nSalaPelicula(arrayCines2, opcionCine2, nSala, nSesion, selectedDate, nombresPelisCine, opcionPeli);
		nSesion = mts.reescribirArrayInts(nSesion);
		nSesion = mts.nSesionPelicula(arrayCines2, opcionCine2, nSala, nSesion, selectedDate, nombresPelisCine, opcionPeli);
		
		sesion=mts.mostrarSesiones(arrayCines2, opcionCine2, nSala, nSesion);
		
		for(int b=0;b<2;b++) {
			//textArea.setText(""+nombresPelisCine[b]+"\n");
			textArea.append(""+sesion[b]+"\n");
		}
		
		JButton btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vent = new LogIn(arrayClientes2);
				vent.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(286, 234, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Volver al inicio");
		btnNewButton.setBounds(22, 234, 127, 23);
		contentPane.add(btnNewButton);
	}
}
