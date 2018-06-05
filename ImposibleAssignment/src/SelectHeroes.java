import static org.junit.Assert.assertNotNull;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SelectHeroes {

	private JFrame frame;
	private JTextField textField;
	String name, specialAbility = "";
	String type;
	Integer heal, recoveryRate;
	private static GameEnvironment gameE;

	/**
	 * Create the application.
	 */
	public SelectHeroes(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		initialize();
		frame.setVisible(true);
	}

	/**this function for close this window
	 * 
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**this function calls function from GameEnviroment to close this window
	 * 
	 */
	public void finishedWindow() {
		gameE.closeSelectHeroes(this);
	}

	/**
	 * this function find the same name of heroes in the listOfhero stored in Team
	 * class
	 * 
	 * @return true if the hero creates have same name as some of the hero in the
	 *         team else return false
	 */
	public boolean findSameName() {
		String samename = textField.getText();
		boolean result = false;
		switch (gameE.Team.listOfHero.size()) {
		case 1:
			if (gameE.Team.listOfHero.get(0).name.equals(samename))
				result = true;
			break;
		case 2:
			if (gameE.Team.listOfHero.get(0).name.equals(samename)
					|| gameE.Team.listOfHero.get(1).name.equals(samename))
				result = true;
			break;

		default:
			result = false;
			break;

		}
		return result;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1196, 813);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocation(270, 100);
		JLabel lblNewLabel = new JLabel("Hero Selected");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 49));
		lblNewLabel.setBounds(12, 0, 405, 80);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(810, 597, 384, 190);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblHeroname = new JLabel("Name:");
		lblHeroname.setBounds(12, 12, 82, 15);
		panel.add(lblHeroname);

		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(12, 39, 70, 15);
		panel.add(lblType);

		JLabel lblSpecialAbility = new JLabel("Special Ability:");

		lblSpecialAbility.setBounds(12, 70, 111, 15);
		panel.add(lblSpecialAbility);

		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setBounds(12, 141, 70, 15);
		panel.add(lblHealth);

		JLabel lblRecoveryRate = new JLabel("Recovery Rate:");
		lblRecoveryRate.setBounds(12, 168, 111, 15);
		panel.add(lblRecoveryRate);

		JLabel lblNameshow = new JLabel("");
		lblNameshow.setBounds(139, 12, 144, 15);
		panel.add(lblNameshow);

		JLabel lblTypeshow = new JLabel("");
		lblTypeshow.setBounds(139, 39, 70, 15);
		panel.add(lblTypeshow);

		JLabel lblSpecialAbilityShow = new JLabel("");
		lblSpecialAbilityShow.setBounds(12, 89, 359, 50);
		panel.add(lblSpecialAbilityShow);

		JLabel lblHealthshow = new JLabel("");
		lblHealthshow.setBounds(139, 141, 70, 15);
		panel.add(lblHealthshow);

		JLabel lblRateshow = new JLabel("");
		lblRateshow.setBounds(149, 168, 222, 15);
		panel.add(lblRateshow);

		JLabel lblHeroesName = new JLabel("Enter Heroes Name:");
		lblHeroesName.setForeground(Color.WHITE);
		lblHeroesName.setBounds(22, 80, 160, 30);
		frame.getContentPane().add(lblHeroesName);

		textField = new JTextField();
		textField.setBounds(212, 79, 183, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnHero1 = new JButton("");
		btnHero1.setIcon(new ImageIcon(SelectHeroes.class.getResource("/img/Wizard.png")));
		btnHero1.setOpaque(false);
		btnHero1.setContentAreaFilled(false);
		btnHero1.setBorderPainted(false);
		btnHero1.addActionListener(new ActionListener() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) if
			 * you click this button it will get the text from text field if the text file
			 * empty it will return pop the message dialog ask player enter hero name.
			 * Otherwise it will the change the text of some lable in panel to show hero 1
			 * details
			 */
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				if (name.equals("")) {

					JOptionPane.showMessageDialog(null, "Please enter Hero name");
				} else {
					lblNameshow.setText(name);
					lblHealthshow.setText("100");
					lblTypeshow.setText("1");
					lblSpecialAbilityShow.setText("Getting cheaper price at the store!");
					lblRateshow.setText("5 after each battel");

				}
			}
		});
		btnHero1.setBounds(104, 122, 120, 110);
		frame.getContentPane().add(btnHero1);

		JButton btnHero2 = new JButton("");
		btnHero2.setOpaque(false);
		btnHero2.setContentAreaFilled(false);
		btnHero2.setBorderPainted(false);
		btnHero2.setIcon(new ImageIcon(SelectHeroes.class.getResource("/img/bowman.png")));
		btnHero2.addActionListener(new ActionListener() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) if
			 * you click this button it will get the text from text field if the text file
			 * empty it will return pop the message dialog ask player enter hero name.
			 * Otherwise it will the change the text of some lable in panel to show hero 3
			 * details
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				if (name.equals("")) {
					;
					JOptionPane.showMessageDialog(null, "Please enter Hero name");
				} else {
					lblNameshow.setText(name);
					lblHealthshow.setText("50");
					lblTypeshow.setText("2");
					lblSpecialAbilityShow.setText("Having a higher chance at winning the game ");
					lblRateshow.setText("5 after each battel");
				}
			}
		}

		);
		btnHero2.setBounds(1009, 293, 160, 110);
		frame.getContentPane().add(btnHero2);

		JButton btnHero3 = new JButton("");

		btnHero3.setOpaque(false);
		btnHero3.setContentAreaFilled(false);
		btnHero3.setBorderPainted(false);
		btnHero3.setIcon(new ImageIcon(SelectHeroes.class.getResource("/img/paladin.png")));
		btnHero3.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if you click this button it will get the text from text field if the text file empty 
			 * it will return pop the message dialog ask player enter hero name. Otherwise it will the change the text of some lable in panel 
			 * to show hero 3 details
			 */
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				if (name.equals("")) {
					;
					JOptionPane.showMessageDialog(null, "Please enter Hero name");
				} else {
					lblNameshow.setText(name);
					lblHealthshow.setText("150");
					lblTypeshow.setText("3");
					lblSpecialAbilityShow.setText("Being stronger and dealing more damage");
					lblRateshow.setText("5 after each battel");
				}
			}
		}

		);
		btnHero3.setBounds(487, 259, 170, 110);
		frame.getContentPane().add(btnHero3);

		JButton btnHero4 = new JButton("");
		btnHero4.setIcon(new ImageIcon(SelectHeroes.class.getResource("/img/sprite-sheet-151x1001.png")));
		btnHero4.setOpaque(false);
		btnHero4.setContentAreaFilled(false);
		btnHero4.setBorderPainted(false);
		btnHero4.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * if you click this button it will get the text from text field if the text file empty 
			 * it will return pop the message dialog ask player enter hero name. Otherwise it will the change the text of some lable in panel 
			 * to show hero 4 details
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				if (name.equals("")) {
					;
					JOptionPane.showMessageDialog(null, "Please enter Hero name");
				} else {
					lblNameshow.setText(name);
					lblHealthshow.setText("100");
					lblTypeshow.setText("4");
					lblSpecialAbilityShow.setText("Always know the direction, aka being a map");
					lblRateshow.setText("5 after each battel");
				}
			}
		}

		);
		btnHero4.setBounds(27, 623, 160, 137);
		frame.getContentPane().add(btnHero4);

		JButton btnHero5 = new JButton("");
		btnHero5.setIcon(new ImageIcon(SelectHeroes.class.getResource("/img/sprite-sheet-2-240x10455.png")));
		btnHero5.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if you click this button it will get the text from text field if the text file empty 
			 * it will return pop the message dialog ask player enter hero name. Otherwise it will the change the text of some lable in panel 
			 * to show hero 5 details
			 */
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				if (name.equals("")) {
					;
					JOptionPane.showMessageDialog(null, "Please enter Hero name");
				}

				else {
					lblNameshow.setText(name);
					lblHealthshow.setText("120");
					lblTypeshow.setText("5");
					lblSpecialAbilityShow.setText("Being more defensive and taking less damage");
					lblRateshow.setText("7 after each battel");
				}
			}
		}

		);
		btnHero5.setBounds(282, 623, 183, 137);
		btnHero5.setOpaque(false);
		btnHero5.setContentAreaFilled(false);
		btnHero5.setBorderPainted(false);
		frame.getContentPane().add(btnHero5);

		JButton btnHero6 = new JButton("");
		btnHero6.setIcon(new ImageIcon(SelectHeroes.class.getResource("/img/warrior2.png")));
		btnHero6.setOpaque(false);
		btnHero6.setContentAreaFilled(false);
		btnHero6.setBorderPainted(false);
		btnHero6.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * if you click this button it will get the text from text field if the text file empty 
			 * it will return pop the message dialog ask player enter hero name. Otherwise it will the change the text of some lable in panel 
			 * to show hero 6 details
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				if (name.equals("")) {
					;
					JOptionPane.showMessageDialog(null, "Please enter Hero name");
				} else {
					lblNameshow.setText(name);
					lblHealthshow.setText("100");
					lblTypeshow.setText("6");
					lblSpecialAbilityShow.setText("Speeding up recovery rates");
					lblRateshow.setText("15 after each battel");
				}
			}
		}

		);
		btnHero6.setBounds(814, 345, 160, 137);
		frame.getContentPane().add(btnHero6);

		JButton btnSelected = new JButton("Selected");
		btnSelected.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 27));
		btnSelected.setOpaque(false);
		btnSelected.setContentAreaFilled(false);
		btnSelected.setBorderPainted(false);
		btnSelected.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked i will get text from text field and label hero type(lblTypeshow) 
			 * if the name is empty then it will remind enter hero name, if the you haven't chose hero it will remind chose hero
			 * if it found the hero has the same name with one hero in listOfHero in team class it will it will remind to rename the hero
			 * else hero will add to listOfHero with correct type into listOfHero of team( object) in gameE( GameEnvirment)
			 */
			public void actionPerformed(ActionEvent e) {
				specialAbility = lblSpecialAbilityShow.getText();
				name = textField.getText();
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Hero name !!");
				}

				else if (specialAbility.equals("")) {
					JOptionPane.showMessageDialog(null, "Please chose a Hero!");

				} else if (findSameName()) {
					JOptionPane.showMessageDialog(null, "Please enter different Hero name");
				} else {
					gameE.countHero++;
					Heroes newHero = new Heroes(name, Integer.parseInt(lblTypeshow.getText()));
					gameE.Team.addHero(newHero);
					finishedWindow();
				}

			}
		});
		btnSelected.setBounds(514, 676, 183, 54);
		frame.getContentPane().add(btnSelected);

		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(SelectHeroes.class.getResource("/img/Heroselected.png")));
		lblImg.setBounds(0, 0, 1194, 787);
		frame.getContentPane().add(lblImg);
	}
}
