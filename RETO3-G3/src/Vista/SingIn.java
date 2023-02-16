package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SingIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingIn frame = new SingIn();
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
	public SingIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSingIn = new JLabel("Sing In - Creacion de cuenta");
		lblSingIn.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSingIn.setBounds(26, 11, 301, 49);
		contentPane.add(lblSingIn);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setBounds(26, 81, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 78, 121, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setBounds(26, 112, 56, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido:");
		lblNewLabel_1_2.setBounds(26, 148, 56, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sexo:");
		lblNewLabel_1_3.setBounds(26, 173, 56, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Contrasena:");
		lblNewLabel_1_4.setBounds(26, 204, 68, 14);
		contentPane.add(lblNewLabel_1_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 109, 121, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 139, 121, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 170, 121, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 201, 121, 20);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBounds(299, 227, 89, 23);
		contentPane.add(btnNewButton);
	}

}
