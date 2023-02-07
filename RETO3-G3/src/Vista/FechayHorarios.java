package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Modelo.DateLabelFormatter;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class FechayHorarios extends JFrame {

	private JPanel contentPane;
	JDatePickerImpl datePicker;
	String sesion1;
	String sesion2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param opcion2 
	 * @param opcion 
	 * @param horaPelis 
	 * @param peli4 
	 * @param peli3 
	 * @param peli2 
	 * @param peli1 
	 * @param peli4 
	 * @param peli3 
	 * @param peli2 
	 * @param peli1 
	 * @param horaPelis 
	 * @param i 
	 * @param i 
	 * @param nombrePelis 
	 */
	public FechayHorarios(String peli1, String peli2, String peli3, String peli4, Time[] horaPelis, int opcion, int opcion2) {
		if(opcion==0&opcion2==0) {
			sesion1=horaPelis[0]+"-"+peli1;
			sesion2=horaPelis[1]+"-"+peli1;
		}
		else if(opcion==0&opcion2==1) {
			sesion1=horaPelis[2]+"-"+peli2;
			sesion2=horaPelis[3]+"-"+peli2;
		}
		else if(opcion==0&opcion2==2) {
			sesion1=horaPelis[4]+"-"+peli3;
			sesion2=horaPelis[5]+"-"+peli3;
		}
		else if(opcion==0&opcion2==3) {
			sesion1=horaPelis[6]+"-"+peli4;
			sesion2=horaPelis[7]+"-"+peli4;
		}
		
		else if(opcion==1&opcion2==0) {
			sesion1=horaPelis[8]+"-"+peli1;
			sesion2=horaPelis[9]+"-"+peli1;
		}
		else if(opcion==1&opcion2==1) {
			sesion1=horaPelis[10]+"-"+peli2;
			sesion2=horaPelis[11]+"-"+peli2;
		}
		else if(opcion==1&opcion2==2) {
			sesion1=horaPelis[12]+"-"+peli3;
			sesion2=horaPelis[13]+"-"+peli3;
		}
		else if(opcion==1&opcion2==3) {
			sesion1=horaPelis[14]+"-"+peli4;
			sesion2=horaPelis[15]+"-"+peli4;
		}
		
		else if(opcion==2&opcion2==0) {
			sesion1=horaPelis[16]+"-"+peli1;
			sesion2=horaPelis[17]+"-"+peli1;
		}
		else if(opcion==2&opcion2==1) {
			sesion1=horaPelis[18]+"-"+peli2;
			sesion2=horaPelis[19]+"-"+peli2;
		}
		else if(opcion==2&opcion2==2) {
			sesion1=horaPelis[20]+"-"+peli3;
			sesion2=horaPelis[21]+"-"+peli3;
		}
		else if(opcion==2&opcion2==3) {
			sesion1=horaPelis[22]+"-"+peli4;
			sesion2=horaPelis[23]+"-"+peli4;
		}
		
		else if(opcion==3&opcion2==0) {
			sesion1=horaPelis[24]+"-"+peli1;
			sesion2=horaPelis[25]+"-"+peli1;
		}
		else if(opcion==3&opcion2==1) {
			sesion1=horaPelis[26]+"-"+peli2;
			sesion2=horaPelis[27]+"-"+peli2;
		}
		else if(opcion==3&opcion2==2) {
			sesion1=horaPelis[28]+"-"+peli3;
			sesion2=horaPelis[29]+"-"+peli3;
		}
		else if(opcion==3&opcion2==3) {
			sesion1=horaPelis[30]+"-"+peli4;
			sesion2=horaPelis[31]+"-"+peli4;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		contentPane.setLayout(null);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(68, 11, 202, 23);
		contentPane.add(datePicker);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(10, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date selectedDate = (Date) datePicker.getModel().getValue();
				System.out.println(selectedDate);
				
			}
		});
		btnNewButton.setBounds(324, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(sesion1);
		rdbtnNewRadioButton.setBounds(10, 64, 342, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(sesion2);
		rdbtnNewRadioButton_1.setBounds(10, 116, 322, 23);
		contentPane.add(rdbtnNewRadioButton_1);
	}
}
