package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pelicula;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Ticket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Metodos mts = new Metodos();

	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the frame.
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
	 * @param nCliente 
	 */
	public Ticket(Cine[] arrayCines, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine, Pelicula[] nombresPelisCine, int opcionPeli, Date selectedDate, int opcionSesion, int r, int[] resumenSal, int[] resumenSes, int[] resumenCin, int nCliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Su Compra a sido efectuada");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 29));
		lblNewLabel.setBounds(10, 70, 414, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblConExitod = new JLabel("con exito :D");
		lblConExitod.setFont(new Font("Trebuchet MS", Font.PLAIN, 29));
		lblConExitod.setBounds(10, 126, 414, 50);
		contentPane.add(lblConExitod);
		
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		JButton btnNewButton = new JButton("Guardar Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//guardar en BDD y txt
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				String[] stringTxT = new String[0];
				for(int i = 0;i<resumenSes.length;i++)
				{
					stringTxT = mts.reescribirArrayStrings(stringTxT);
					stringTxT[i] = "Nombre de Cine: "+arrayCines[resumenCin[i]].getNombre()
							+"\n Cliente: "+arrayClientes[nCliente].getNombre()
							+"\n DNI de Cliente: "+arrayClientes[nCliente].getDni()
							+"\n Direccion: "+arrayCines[resumenCin[i]].getDireccion()
							+"\n Nombre de Pelicula: "+arrayCines[resumenCin[i]].getArraySalas()[resumenSal[i]].getArraySesiones()[resumenSes[i]].getxPelicula().getNombre() 
							+"\n Fecha de compra: "+ dt.format(ts) +" "+ dt2.format(ts)
							+"\n Fecha de emision: "+ dt.format(arrayCines[resumenCin[i]].getArraySalas()[resumenSal[i]].getArraySesiones()[resumenSes[i]].getFecha()) +" "+ dt2.format(arrayCines[resumenCin[i]].getArraySalas()[resumenSal[i]].getArraySesiones()[resumenSes[i]].getFecha())
							+"\n Sala: "+ String.valueOf(arrayCines[resumenCin[i]].getArraySalas()[resumenSal[i]].getNumero()) 
							+"\n Precio: "+ String.valueOf(arrayCines[resumenCin[i]].getArraySalas()[resumenSal[i]].getArraySesiones()[resumenSes[i]].getPrecio())
							+"\n\n";	
				}
				
				for(int i = 0;i<resumenSes.length;i++)
				{
					System.out.println(stringTxT[i]);
				}
				
				//esto en un metodo v
				// los datos del cine, las películas seleccionadas, con el nombre de la sala, el precio y los datos del cliente, la fecha y hora de la compra/impresión
				
				
				
				File file = new File("Ticket.txt");
				
				BufferedWriter fichero;
				
					try {
						fichero = new BufferedWriter(new FileWriter(file));
					for(int i =0;i<stringTxT.length;i++)
					{
						fichero.write(stringTxT[i].toString());
					}
					fichero.close();
					JOptionPane.showMessageDialog(null,
							"Los mensajes en memoria, han sido guardados en el fichero MENSAJES.TXT",
							"éxito!",
							JOptionPane.INFORMATION_MESSAGE);
					
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton.setBounds(164, 210, 139, 40);
		contentPane.add(btnNewButton);
	}
}
