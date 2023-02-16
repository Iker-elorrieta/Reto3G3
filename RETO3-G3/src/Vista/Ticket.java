package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Ticket extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
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
	public Ticket() {
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
		
		JButton btnNewButton = new JButton("Guardar Ticket");
		btnNewButton.setBounds(164, 210, 139, 40);
		contentPane.add(btnNewButton);
	}
}
