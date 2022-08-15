package aceita;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class MainView {

	private JFrame frame;
	public static JLabel stepDescription = new JLabel("Aguardando partida...");
	public static JTextField banInput;
	public static JCheckBox autobanFlag;
	public static JCheckBox autopickFlag;
	public static JTextField pickInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public MainView() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 309, 131);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, stepDescription, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		stepDescription.setBackground(Color.WHITE);
		stepDescription.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		frame.getContentPane().add(stepDescription);
		
		JLabel banLabel = new JLabel("AutoBan:");
		springLayout.putConstraint(SpringLayout.NORTH, banLabel, 10, SpringLayout.SOUTH, stepDescription);
		springLayout.putConstraint(SpringLayout.WEST, banLabel, 10, SpringLayout.WEST, frame.getContentPane());
		banLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		frame.getContentPane().add(banLabel);
		
		banInput = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, banInput, 32, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, banInput, 7, SpringLayout.EAST, banLabel);
		springLayout.putConstraint(SpringLayout.EAST, banInput, -125, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, stepDescription, -7, SpringLayout.NORTH, banInput);
		frame.getContentPane().add(banInput);
		banInput.setColumns(10);
		
		JLabel pickLabel = new JLabel("AutoPick:");
		springLayout.putConstraint(SpringLayout.NORTH, pickLabel, 13, SpringLayout.SOUTH, banLabel);
		springLayout.putConstraint(SpringLayout.WEST, pickLabel, 10, SpringLayout.WEST, frame.getContentPane());
		pickLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		frame.getContentPane().add(pickLabel);
		
		pickInput = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, pickInput, 7, SpringLayout.SOUTH, banInput);
		springLayout.putConstraint(SpringLayout.EAST, pickInput, 0, SpringLayout.EAST, banInput);
		springLayout.putConstraint(SpringLayout.WEST, pickInput, 5, SpringLayout.EAST, pickLabel);
		frame.getContentPane().add(pickInput);
		pickInput.setColumns(10);
		
		autobanFlag = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.WEST, autobanFlag, 0, SpringLayout.EAST, banInput);
		springLayout.putConstraint(SpringLayout.SOUTH, autobanFlag, -39, SpringLayout.SOUTH, frame.getContentPane());
		autobanFlag.setBackground(Color.WHITE);
		frame.getContentPane().add(autobanFlag);
		
		autopickFlag = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.NORTH, autopickFlag, 6, SpringLayout.SOUTH, autobanFlag);
		springLayout.putConstraint(SpringLayout.WEST, autopickFlag, 0, SpringLayout.EAST, banInput);
		springLayout.putConstraint(SpringLayout.SOUTH, autopickFlag, -12, SpringLayout.SOUTH, frame.getContentPane());
		autopickFlag.setBackground(Color.WHITE);
		frame.getContentPane().add(autopickFlag);
		
		new Thread(new Accepter()).start();
	}

	
}
