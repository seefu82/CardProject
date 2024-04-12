import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardGUI window = new CardGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CardGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 446, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel imageLabel = new JLabel("Image goes here");
		imageLabel.setBounds(10, 51, 400, 378);
		frame.getContentPane().add(imageLabel);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 340, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel attackValueLabel = new JLabel("New label");
		attackValueLabel.setBounds(90, 440, 100, 100);
		frame.getContentPane().add(attackValueLabel);

		JLabel hpValueLabel = new JLabel("New label");
		hpValueLabel.setBounds(332, 440, 100, 100);
		frame.getContentPane().add(hpValueLabel);

		JLabel attackLabel = new JLabel("Attack");
		attackLabel.setBounds(0, 440, 100, 100);
		frame.getContentPane().add(attackLabel);

		JLabel hpLabel = new JLabel("Hit Points");
		hpLabel.setBounds(196, 440, 100, 100);
		frame.getContentPane().add(hpLabel);
	}
}
