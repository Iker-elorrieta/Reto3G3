package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Metodos;
import Modelo.Cine;
import Modelo.Cliente;
import Modelo.Entrada;
import Modelo.Pedido;
import Modelo.Pelicula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Resumen extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] sesion;
	Metodos mts = new Metodos();
	int[] nSala;
	int[] nSesion;
	LogIn vent;
	BienvenidaCines vent2;
	private JTable table;
	JButton btnNewButton_1;
	JButton btnNewButton;
	JLabel lblNewLabel_1;
	float sumaPrecios;
	float precioFinal;

	//variables ActionListener
	Cine[] arrayCines2AL;
	Pelicula pel2AL;
	Cliente[] arrayClientes2AL;
	Entrada[] arrayEntradas2AL;
	Pedido[]  arrayPedidosAL;
	int opcionCine2AL;
	Pelicula[] nombresPelisCineAL;
	int opcionPeliAL;
	Date selectedDateAL;
	int opcionSesionAL;
	int rAL;
	int[] resumenSalAL;
	int[] resumenSesAL;
	int[] resumenCinAL;
	
	
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
	 * @param arrayPedidos 
	 * @param selectedDate 
	 * @param opcionSesion 
	 * @param resumenSes 
	 * @param resumenSal 
	 * @param r 
	 * @param resumenCin 
	 */
	public Resumen(Cine[] arrayCines2, Pelicula pel2, Cliente[] arrayClientes2, Entrada[] arrayEntradas2, Pedido[] arrayPedidos, int opcionCine2, Pelicula[] nombresPelisCine, int opcionPeli, Date selectedDate, int opcionSesion, int r, int[] resumenSal, int[] resumenSes, int[] resumenCin) {
		
		
		arrayCines2AL = arrayCines2;
		pel2AL = pel2;
		arrayClientes2AL = arrayClientes2;
		arrayEntradas2AL = arrayEntradas2;
		arrayPedidosAL = arrayPedidos;
		opcionCine2AL = opcionCine2;
		nombresPelisCineAL = nombresPelisCine;
		opcionPeliAL = opcionPeli;
		selectedDateAL = selectedDate;
		opcionSesionAL = opcionSesion;
		rAL = r;
		resumenSalAL = resumenSal;
		resumenSesAL = resumenSes;
		resumenCinAL = resumenCin;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Resumen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(164, 11, 91, 25);
		contentPane.add(lblNewLabel);
		
		DateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat dt2 = new SimpleDateFormat("hh:mm");
		
		
		nSala = new int[0];
		nSesion = new int[0];
		
		nSala = mts.reescribirArrayInts(nSala);
		nSala = mts.nSalaPelicula(arrayCines2, opcionCine2, nSala, nSesion, selectedDate, nombresPelisCine, opcionPeli);
		nSesion = mts.reescribirArrayInts(nSesion);
		nSesion = mts.nSesionPelicula(arrayCines2, opcionCine2, nSala, nSesion, selectedDate, nombresPelisCine, opcionPeli);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 618, 163);
		contentPane.add(scrollPane);
		
		String[][] datosTabla = new String[resumenSes.length][5];
		for(int i = 0;i<resumenSes.length;i++){
			datosTabla[i][0] = arrayCines2[resumenCin[i]].getArraySalas()[resumenSal[i]].getArraySesiones()[resumenSes[i]].getxPelicula().getNombre();
			datosTabla[i][1] = dt.format(arrayCines2[resumenCin[i]].getArraySalas()[resumenSal[i]].getArraySesiones()[resumenSes[i]].getFecha());
			datosTabla[i][2] = dt2.format(arrayCines2[resumenCin[i]].getArraySalas()[resumenSal[i]].getArraySesiones()[resumenSes[i]].getFecha());
			datosTabla[i][3] = String.valueOf(arrayCines2[resumenCin[i]].getArraySalas()[resumenSal[i]].getNumero());
			datosTabla[i][4] = String.valueOf(arrayCines2[resumenCin[i]].getArraySalas()[resumenSal[i]].getArraySesiones()[resumenSes[i]].getPrecio());
			
			
		}
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			datosTabla,
			new String[] {
				"Nombre de la Pelicula",  "Fecha de sesion", "Hora", "Sala", "Precio"
			}
		));
		scrollPane.setViewportView(table);
		
//		JTextArea textArea = new JTextArea();
//		textArea.setBounds(22, 36, 383, 187);
//		contentPane.add(textArea);
//		
//		//textArea.setText("sdsdh\n\nsddf\n\nsddf\n\nsddf\n\nsddf\n\nsddf\n\nsddf\n\nsddf\n\nsdd77f");

//		
//		sesion=mts.mostrarSesiones(arrayCines2, opcionCine2, nSala, nSesion);
//		
//		for(int b=0;b<1;b++) {
//			//textArea.setText(""+nombresPelisCine[b]+"\n");
//			textArea.append(""+sesion[opcionSesion]+"\n");
//		}
		
		btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.addActionListener((ActionListener) this);
		btnNewButton_1.setBounds(286, 234, 119, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("Volver al inicio");
		btnNewButton.addActionListener((ActionListener) this);
		btnNewButton.setBounds(22, 234, 127, 23);
		contentPane.add(btnNewButton);
		
	
		
		precioFinal = mts.sumarPrecioyDescuentos(arrayCines2, pel2, arrayClientes2, arrayEntradas2, arrayPedidos, opcionCine2, nombresPelisCine, opcionPeli, selectedDate, opcionSesion, r, resumenSal, resumenSes, resumenCin);
		
		
		
		lblNewLabel_1 = new JLabel("Precio Final: "+(precioFinal)+"");
		lblNewLabel_1.setBounds(10, 211, 172, 14);
		contentPane.add(lblNewLabel_1);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton_1) {
			this.dispose();
			vent = new LogIn(arrayCines2AL, pel2AL, arrayClientes2AL, arrayEntradas2AL, arrayPedidosAL, opcionCine2AL, nombresPelisCineAL, opcionPeliAL, selectedDateAL, opcionSesionAL, precioFinal, rAL, resumenSalAL, resumenSesAL, resumenCinAL);
			vent.setVisible(true);
		}
		if(e.getSource()==btnNewButton) {
			this.dispose();
			vent2 = new BienvenidaCines(arrayCines2AL, pel2AL, arrayClientes2AL, arrayEntradas2AL, opcionCine2AL, nombresPelisCineAL, opcionPeliAL, selectedDateAL, opcionSesionAL, rAL, resumenSalAL, resumenSesAL, resumenCinAL);
			vent2.setVisible(true);
		}
		
	}
}
