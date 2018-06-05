import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GameEntry {

	private JFrame frmGameentry;
	private JTextField textFieldTeamName;
	private static GameEnvironment gameE;

	/**
	 * Create the application.
	 * and link with the game environment
	 */
	public GameEntry(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		initialize();
		frmGameentry.setVisible(true);
	}

	public void closeWindow() {
		frmGameentry.dispose();
	}

	public void finishedWindow() {
		gameE.closeGameEntry(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameentry = new JFrame();
		frmGameentry.setResizable(false);
		frmGameentry.setTitle("GameEntry");
		frmGameentry.setBounds(100, 100, 1196, 813);
		frmGameentry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameentry.getContentPane().setLayout(new CardLayout(0, 0));
		frmGameentry.setLocation(270, 100);

		JPanel GameEntry = new JPanel();
		frmGameentry.getContentPane().add(GameEntry, "name_332681350794715");
		GameEntry.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to Heroes Vs Villains Game");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 47));
		lblNewLabel.setBounds(82, 12, 1043, 73);
		GameEntry.add(lblNewLabel);

		JLabel lblTeam = new JLabel("Team Name:");
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setBounds(115, 128, 108, 45);
		GameEntry.add(lblTeam);

		textFieldTeamName = new JTextField();
		textFieldTeamName.setBounds(320, 128, 539, 32);
		GameEntry.add(textFieldTeamName);
		textFieldTeamName.setColumns(10);

		JLabel lblNumberOfCity = new JLabel("Number of City:");
		lblNumberOfCity.setForeground(Color.WHITE);
		lblNumberOfCity.setBounds(115, 269, 122, 21);
		GameEntry.add(lblNumberOfCity);

		JLabel lblNumberOfHeroes = new JLabel("Number Of Heroes");
		lblNumberOfHeroes.setForeground(Color.WHITE);
		lblNumberOfHeroes.setBounds(115, 395, 140, 32);
		GameEntry.add(lblNumberOfHeroes);

		JComboBox comboBoxNumberOfCity = new JComboBox();
		comboBoxNumberOfCity.setBounds(354, 267, 49, 24);
		comboBoxNumberOfCity.addItem(3);
		comboBoxNumberOfCity.addItem(4);
		comboBoxNumberOfCity.addItem(5);
		comboBoxNumberOfCity.addItem(6);

		GameEntry.add(comboBoxNumberOfCity);

		JComboBox comboBoxNumberOfHeroes = new JComboBox();
		comboBoxNumberOfHeroes.setBounds(354, 399, 49, 24);
		comboBoxNumberOfHeroes.addItem(1);
		comboBoxNumberOfHeroes.addItem(2);
		comboBoxNumberOfHeroes.addItem(3);
		GameEntry.add(comboBoxNumberOfHeroes);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 44));
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if the button be clicked  will run this function that take and save name of the if its empty or length< 2 or > 10 character then
			 * show error messenger.
			 * otherwise save number of villain, hero and city in to gameE variables 
			 * and start the next window which is SelectHeroes
			 */
			public void actionPerformed(ActionEvent e) {
				if (textFieldTeamName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Team name");
						
				} else if (textFieldTeamName.getText().length() > 10 || textFieldTeamName.getText().length() < 2 ) {
					JOptionPane.showMessageDialog(null, "Please enter Team name in 2-10 characters");
					
				}else {
					gameE.Team.name = textFieldTeamName.getText();
					gameE.numberOfCity = (Integer) comboBoxNumberOfCity.getSelectedItem();
					gameE.numberOfhero = (Integer) comboBoxNumberOfHeroes.getSelectedItem();
					gameE.numberOfVillain = (Integer) comboBoxNumberOfCity.getSelectedItem();
					finishedWindow();
				}
			}
		});
		btnNewButton.setBounds(901, 605, 205, 80);
		GameEntry.add(btnNewButton);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(GameEntry.class.getResource("/img/gameEntry.png")));
		lblImage.setBounds(0, 0, 1194, 787);
		GameEntry.add(lblImage);
	}
}
