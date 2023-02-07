package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class CompraPeliculas extends JFrame {

	private JPanel contentPane;
	String peli1;
	String peli2;
	String peli3;
	String peli4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	FechayHorarios vent;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param opcion 
	 * @param nombrePelis 
	 * @param horaPelis 
	 */
	public CompraPeliculas(String[] nombrePelis, Time[] horaPelis, int opcion) {
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
		
		if(opcion==0) {
			peli1=nombrePelis[0];
			peli2=nombrePelis[4];
			peli3=nombrePelis[8];
			peli4=nombrePelis[12];
		}
		else if(opcion==1) {
			peli1=nombrePelis[1];
			peli2=nombrePelis[5];
			peli3=nombrePelis[9];
			peli4=nombrePelis[13];
		}
		else if(opcion==2) {
			peli1=nombrePelis[2];
			peli2=nombrePelis[6];
			peli3=nombrePelis[10];
			peli4=nombrePelis[14];
		}
		else if(opcion==3) {
			peli1=nombrePelis[3];
			peli2=nombrePelis[7];
			peli3=nombrePelis[11];
			peli4=nombrePelis[15];
		}
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(peli1);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(19, 64, 295, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(peli2);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(19, 101, 325, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(peli3);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(19, 148, 310, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(peli4);
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(19, 189, 295, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Comprar Pelicula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					vent = new FechayHorarios(peli1,peli2,peli3,peli4,horaPelis,opcion, 0);
					vent.setVisible(true);
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					vent = new FechayHorarios(peli1,peli2,peli3,peli4,horaPelis,opcion,1);
					vent.setVisible(true);
				}
				else if(rdbtnNewRadioButton_2.isSelected()) {
					vent = new FechayHorarios(peli1,peli2,peli3,peli4,horaPelis,opcion,2);
					vent.setVisible(true);
				}
				else if(rdbtnNewRadioButton_3.isSelected()) {
					vent = new FechayHorarios(peli1,peli2,peli3,peli4,horaPelis,opcion,3);
					vent.setVisible(true);
				}
				else {
					System.out.println("No has seleccionado ningún cine");
				}
			}
		});
		btnNewButton.setBounds(269, 227, 155, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(170, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
