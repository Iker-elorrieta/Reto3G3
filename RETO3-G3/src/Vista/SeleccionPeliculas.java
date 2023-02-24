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
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SeleccionPeliculas extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String peli1;
	String peli2;
	String peli3;
	String peli4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	FechayHorarios vent;
	BienvenidaCines vent2;
	JLabel lblNewLabel_1;
	int opcionPeli=-1;
	String nombrePelicula;
	Metodos mts = new Metodos();
	Pelicula[] nombresPelisCine;
	int[] nSala;
	int[] nSesion;
	JButton btnNewButton;
	JButton btnNewButton_1;
	
	//botones
	int contR;
	JRadioButton[] arraybotones;
	JRadioButton button1;
	
	//variables para el actionEvent
	Cine[] arrayCinesAE;
	Pelicula pelAE;
	Cliente[] arrayClientesAE;
	Entrada[] arrayEntradasAE;
	int opcionCineAE;
	int rAE;
	int[] resumenSalAE; 
	int[] resumenSesAE; 
	int[] resumenCinAE;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param opcionCine 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param pel 
	 * @param arraySesiones 
	 * @param arraySalas 
	 * @param arrayCines 
	 * @param opcionCine 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param arrayCines 
	 * @param opcionCine 
	 * @param arraySesiones 
	 * @param arraySalas 
	 * @param arrayPelis 
	 * @param arrayEntradas 
	 * @param arrayClientes 
	 * @param arrayCines 
	 * @param opcionCine 
	 * @param resumenSes 
	 * @param resumenSal 
	 * @param r 
	 * @param resumenCin 
	 * @param nombrePelis 
	 * @param horaPelis 
	 */
	public SeleccionPeliculas(Cine[] arrayCines, Pelicula pel, Cliente[] arrayClientes, Entrada[] arrayEntradas, int opcionCine, int r, int[] resumenSal, int[] resumenSes, int[] resumenCin) {
		arrayCinesAE=arrayCines;
		pelAE=pel;
		arrayClientesAE=arrayClientes;
		arrayEntradasAE=arrayEntradas;
		opcionCineAE = opcionCine;
		rAE = r;
		resumenSalAE = resumenSal;
		resumenSesAE= resumenSes;
		resumenCinAE = resumenCin;
		
			nombresPelisCine = mts.mostrarPeliculas(arrayCines, opcionCine);
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Peliculas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 11, 367, 36);
		contentPane.add(lblNewLabel);
		
		
		contR=0;
		arraybotones = new JRadioButton[0];
		for (int i = 0; i < arrayCines.length; i++) {

            button1 = new JRadioButton(nombresPelisCine[i].getNombre());
            contR=contR+30;
            button1.setToolTipText(String.valueOf(i));
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    System.err.println("Action Performed..************");
//                    System.out.println("This is action text.."+button1.getText()); 
//                    System.out.println("tool tip text"+button1.getToolTipText());
                }
            });
            button1.setBounds(37, 31+contR, 227, 23);
            buttonGroup.add(button1);
            contentPane.add(button1);
            arraybotones = mts.reescribirArrayButtons(arraybotones);
            arraybotones[i] = button1;
        }
		
		
		
		btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener((ActionListener) this);
		btnNewButton.setBounds(269, 227, 155, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener((ActionListener)this);
		btnNewButton_1.setBounds(170, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("*Seleccione una pelicula");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(19, 236, 141, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			
		
		for(int h=0;h<arraybotones.length;h++) {
			if(arraybotones[h].isSelected()) {
				opcionPeli= h;
			}
		}
		
		
		if(opcionPeli==-1) {
		
		lblNewLabel_1.setVisible(true);
		}else {
			this.dispose();
			vent = new FechayHorarios(arrayCinesAE, pelAE, arrayClientesAE, arrayEntradasAE, opcionCineAE, nombresPelisCine, opcionPeli, rAE, resumenSalAE, resumenSesAE, resumenCinAE);
		vent.setVisible(true);
		}
	}
		
		if(e.getSource()==btnNewButton_1 && resumenSesAE.length==0) {
		this.dispose();
		vent2 = new BienvenidaCines(null, null, null, null, 0, null, 0, null, 0, rAE, resumenSalAE, resumenSesAE, resumenCinAE);
		vent2.setVisible(true);
	}
		
	}
	
	
}
