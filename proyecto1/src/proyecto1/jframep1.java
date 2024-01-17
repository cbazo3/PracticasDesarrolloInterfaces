package proyecto1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
	
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class jframep1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframep1 frame = new jframep1();
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
	public jframep1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("aceptar");
		btnNewButton.setBounds(10, 10, 85, 262);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancelar");
		btnNewButton_1.setBounds(387, 10, 85, 262);
		contentPane.add(btnNewButton_1);
	}
}
