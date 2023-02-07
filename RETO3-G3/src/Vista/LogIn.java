package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String nombre;
	int contLogin=0;
	Connection conexion;
	ResultSet registroLogin;
	Statement comando;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public LogIn() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(38, 58, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(38, 132, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(38, 83, 125, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(38, 157, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("LOG IN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(183, 11, 77, 43);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reto3_grupo3","root"
					,"");
					comando=(Statement) conexion.createStatement();
					registroLogin = comando.executeQuery("select Nombre from clientes");
					System.out.println(registroLogin);
					while (registroLogin.next()) {
						if(textField.getText().equals(registroLogin.getString("Nombre"))) {
							contLogin=1;
						}
						//Cine ci = new Cine(title, title, title, null);
						//ci.setNombre(registroCines.getString("Nombre"));
						//Cine[] arrayCines = new Cine[10];
						
					}
				} catch(SQLException ex){
					ex.printStackTrace();

			}
				if(contLogin==1) {
					System.out.println("Login correcto");
				}
				else {
					System.out.println("Login incorrecto");
				}
			}
		});
		btnNewButton.setBounds(35, 215, 89, 23);
		contentPane.add(btnNewButton);
	}
}
