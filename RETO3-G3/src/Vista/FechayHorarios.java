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
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class FechayHorarios extends JFrame {

	private JPanel contentPane;
	JDatePickerImpl datePicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FechayHorarios frame = new FechayHorarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FechayHorarios() {
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
		btnNewButton.setBounds(24, 104, 89, 23);
		contentPane.add(btnNewButton);
	}

}
