package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BienvenidaCines extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] cines=new String[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BienvenidaCines frame = new BienvenidaCines();
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
	public BienvenidaCines() {
		try {
			Connection conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reto3_grupo3","root"
			,"");
			Statement comando=(Statement) conexion.createStatement();
			ResultSet registroCines = comando.executeQuery("select Nombre from cine");
			int i=0;
			while (registroCines.next()) {
				
			cines[i]=registroCines.getString("Nombre");
			i++;
				
			System.out.println(registroCines.getString("Nombre"));
			}
			conexion.close();
			} catch(SQLException ex){
				ex.printStackTrace();

	}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elija un Cine");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(153, 27, 128, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(328, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(cines[0]);
		rdbtnNewRadioButton.setBounds(37, 61, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(cines[1]);
		rdbtnNewRadioButton_1.setBounds(37, 106, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(cines[2]);
		rdbtnNewRadioButton_2.setBounds(37, 156, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(cines[3]);
		rdbtnNewRadioButton_3.setBounds(37, 207, 153, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if ningula peli selecionada se sale, si no al resumen
				
			}
		});
		btnNewButton_1.setBounds(229, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
