import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class Hospital {
	/**
	 * for implement of this window, some variables created to make easier to update
	 * and keep track of the hero and changing when something change in the window
	 */
	JLabel lblName, lblType, lblheal, lblTime;
	Heroes hero1, hero2, hero3, heroSelected;
	HealingItems healingItemsSelected;
	private JFrame frmHospital;
	int secondsPassedheal = 1;
	public static GameEnvironment gameE;

	/**
	 * **constructor that get input of GameEnvironment and save is as local variable
	 * 
	 * @param incomingGameE
	 */
	public Hospital(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		initialize();
		frmHospital.setVisible(true);
	}

	/**
	 * set dispose the window
	 */
	public void closeWindow() {
		frmHospital.dispose();
	}
	

	/**
	 * this function call closeHospital from game Environment to close this window 

	 */
	public void finishedWindow() {
		gameE.closeHospital(this);
	}

	/**that update function is using for update the screen when healing is using.
	 * create timer and time task
	 * if the heal of the hero plus increment of healing items then heal hero = hero max  heal 
	 * and stop the healing and set secondsPassedheal back as start
	 * else increase hero heal and update the label showing in the window
	 * 
	 * 
	 */
	public void update() {
		secondsPassedheal = 1;
		Timer healtimer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				Integer second = (Integer) secondsPassedheal;
				if (heroSelected.heal + healingItemsSelected.healIncrement >= heroSelected.maxheal) {
					heroSelected.heal = heroSelected.maxheal;
					healtimer.cancel();
					secondsPassedheal = 1;
					lblTime.setText("");
					lblheal.setText(heroSelected.heal.toString());
				} else {
					heroSelected.heal += healingItemsSelected.healIncrement;
					lblheal.setText(heroSelected.heal.toString());
					lblTime.setText(second.toString());
					secondsPassedheal++;
					if (secondsPassedheal == 11) {
						secondsPassedheal = 1;
						healtimer.cancel();
						lblTime.setText("");
					}
				}

			}
		};
		healtimer.scheduleAtFixedRate(task, 1000, 1000);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHospital = new JFrame();
		frmHospital.setResizable(false);
		frmHospital.setTitle("Hospital");
		frmHospital.setBounds(100, 100, 1196, 813);
		frmHospital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHospital.getContentPane().setLayout(null);
		frmHospital.setLocation(270, 100);
		JLabel lblHospital = new JLabel("Hospital");
		lblHospital.setForeground(Color.WHITE);
		lblHospital.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 49));
		lblHospital.setBounds(454, 40, 241, 80);
		frmHospital.getContentPane().add(lblHospital);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setBounds(620, 128, 562, 165);
		frmHospital.getContentPane().add(panel);

		JLabel labelName = new JLabel("There are some type of healing items with different special ability ");
		labelName.setForeground(Color.WHITE);
		labelName.setBounds(12, 12, 522, 15);
		panel.add(labelName);

		JLabel labelType = new JLabel("Healing type:");
		labelType.setForeground(Color.WHITE);
		labelType.setBounds(12, 39, 113, 15);
		panel.add(labelType);

		JLabel lblDescription = new JLabel("Which Description is:");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setBounds(12, 70, 310, 15);
		panel.add(lblDescription);

		JLabel TypeText = new JLabel("");
		TypeText.setForeground(Color.WHITE);
		TypeText.setBounds(131, 39, 70, 15);
		panel.add(TypeText);

		JLabel labelDescriptionText = new JLabel("");
		labelDescriptionText.setForeground(Color.WHITE);
		labelDescriptionText.setBounds(12, 89, 541, 38);
		panel.add(labelDescriptionText);

		JLabel lblAmount = new JLabel("Amount in the inventory:");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setBounds(12, 139, 201, 15);
		panel.add(lblAmount);

		JLabel lblNumberOfPowerUp = new JLabel("");
		lblNumberOfPowerUp.setForeground(Color.WHITE);
		lblNumberOfPowerUp.setBounds(252, 139, 70, 15);
		panel.add(lblNumberOfPowerUp);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.GREEN);
		btnExit.setOpaque(false);
		btnExit.setBorderPainted(false);
		btnExit.setContentAreaFilled(false);
		btnExit.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if player click this button then it will return back to the city where they come from by using 
			 * launchPreviousPlace in game environment
			 */
			public void actionPerformed(ActionEvent e) {
				gameE.launchPreviousPlace();
				finishedWindow();
			}
		});
		btnExit.setBounds(995, 583, 76, 25);
		frmHospital.getContentPane().add(btnExit);

		JButton bntHealing1 = new JButton("");

		bntHealing1.setOpaque(false);
		bntHealing1.setContentAreaFilled(false);
		bntHealing1.setBorderPainted(false);
		bntHealing1.setIcon(new ImageIcon(Hospital.class.getResource("/img/potionRed.png")));
		bntHealing1.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if you click this button it show information about healing type 1 into the panel 
			 * and find number of healing type 1 in you inventory
			 */
			public void actionPerformed(ActionEvent e) {
				healingItemsSelected = gameE.HealingItems1;
				Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems1);
				TypeText.setText("1");
				labelDescriptionText.setText("This power help hero increment 2 heal per second duration 10s");
				lblNumberOfPowerUp.setText(amount.toString());
			}
		});
		bntHealing1.setBounds(163, 355, 128, 128);
		frmHospital.getContentPane().add(bntHealing1);

		JButton bntHealing2 = new JButton("");
		bntHealing2.setOpaque(false);
		bntHealing2.setContentAreaFilled(false);
		bntHealing2.setBorderPainted(false);
		bntHealing2.setOpaque(false);
		bntHealing2.setIcon(new ImageIcon(Hospital.class.getResource("/img/potionGreen.png")));
		bntHealing2.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if you click this button it show information about healing type 2 into the panel 
			 * and find number of healing type 2 in you inventory
			 */
			
			public void actionPerformed(ActionEvent e) {
				healingItemsSelected = gameE.HealingItems2;
				Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems2);
				TypeText.setText("2");
				labelDescriptionText.setText("This power help hero increment 5 heal per second duration 10s");
				lblNumberOfPowerUp.setText(amount.toString());
			}
		});
		bntHealing2.setBounds(511, 355, 128, 128);
		frmHospital.getContentPane().add(bntHealing2);

		JButton bntHealing3 = new JButton("");
		bntHealing3.setOpaque(false);
		bntHealing3.setContentAreaFilled(false);
		bntHealing3.setBorderPainted(false);
		bntHealing3.setOpaque(false);
		bntHealing3.setIcon(new ImageIcon(Hospital.class.getResource("/img/potionBlue.png")));
		bntHealing3.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 *  if you click this button it show information about healing type 3 into the panel 
			 * and find number of healing type 3 in you inventory
			 */
			public void actionPerformed(ActionEvent e) {
				healingItemsSelected = gameE.HealingItems3;
				Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems3);
				TypeText.setText("3");
				labelDescriptionText.setText("This power help hero increment 7 heal per second duration 10s");
				lblNumberOfPowerUp.setText(amount.toString());
			}
		});
		bntHealing3.setBounds(875, 355, 128, 128);
		frmHospital.getContentPane().add(bntHealing3);
		JPanel panelHeroDisplay = new JPanel();
		panelHeroDisplay.setOpaque(false);
		panelHeroDisplay.setLayout(null);
		panelHeroDisplay.setBounds(917, 660, 277, 127);
		frmHospital.getContentPane().add(panelHeroDisplay);

		JLabel lblNameTxt = new JLabel("Name:");
		lblNameTxt.setForeground(Color.WHITE);
		lblNameTxt.setBounds(12, 12, 82, 15);
		panelHeroDisplay.add(lblNameTxt);

		JLabel lblTypeTxt = new JLabel("Type:");
		lblTypeTxt.setForeground(Color.WHITE);
		lblTypeTxt.setBounds(12, 39, 70, 15);
		panelHeroDisplay.add(lblTypeTxt);

		JLabel lblSpecialAbilityTxt = new JLabel("Heal:");
		lblSpecialAbilityTxt.setForeground(Color.WHITE);
		lblSpecialAbilityTxt.setBounds(12, 66, 53, 15);
		panelHeroDisplay.add(lblSpecialAbilityTxt);

		lblName = new JLabel("");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(106, 12, 144, 15);
		panelHeroDisplay.add(lblName);

		lblType = new JLabel("");
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(106, 39, 70, 15);
		panelHeroDisplay.add(lblType);

		lblheal = new JLabel("");
		lblheal.setForeground(Color.WHITE);
		lblheal.setBounds(106, 67, 70, 14);
		panelHeroDisplay.add(lblheal);

		lblTime = new JLabel("");
		lblTime.setForeground(Color.WHITE);
		lblTime.setBounds(188, 66, 70, 15);
		panelHeroDisplay.add(lblTime);

		JButton btnUse = new JButton("Use");
		btnUse.setContentAreaFilled(false);
		btnUse.setBorderPainted(false);
		btnUse.setOpaque(false);
		btnUse.setFont(new Font("Dialog", Font.BOLD, 19));
		btnUse.setForeground(Color.RED);
		btnUse.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then start using healing item if use haven't chose healing item or hero. It will pop up message and remind the player to choose hero or healing items
			 * if hero is full heal then it will show message hero is full heal 
			 * if healing is using for another hero than you can use another healing item for hero 
			 * if healing is using then you change hero selected then the healing of new hero selected will increase and the heal of old hero selected will stay remain
			 * if there is no healing item type that you selected in inventory then show message no healing item to use
			 * else start increase hero heal and call function update.   
			 */
			public void actionPerformed(ActionEvent e) {
				if (TypeText.getText() == "") {
					JOptionPane.showMessageDialog(null, "Choose Healing items to Use!");
				} else if (heroSelected == null) {
					JOptionPane.showMessageDialog(null, "Choose hero to use!");
				} else if (heroSelected.heal == heroSelected.maxheal) {
					JOptionPane.showMessageDialog(null, "Hero is full heal!");
				} else if (secondsPassedheal != 1) {
					JOptionPane.showMessageDialog(null, "Healing is using. Please wait!!");
				}

				else if (lblNumberOfPowerUp.getText().equals("0")) {
					JOptionPane.showMessageDialog(null, "There is no Healing item to use");
				} else if (TypeText.getText() == "1") {
					gameE.Team.listOfHealing.remove(gameE.HealingItems1);
					Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems1);
					lblNumberOfPowerUp.setText(amount.toString());
					update();
				} else if (TypeText.getText() == "2") {
					gameE.Team.listOfHealing.remove(gameE.HealingItems2);
					Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems2);
					lblNumberOfPowerUp.setText(amount.toString());
					update();
				} else if (TypeText.getText() == "3") {
					gameE.Team.listOfHealing.remove(gameE.HealingItems3);
					Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems3);
					lblNumberOfPowerUp.setText(amount.toString());
					update();
				}
			}
		});
		btnUse.setBounds(941, 496, 177, 56);
		frmHospital.getContentPane().add(btnUse);

		JLabel lblSelectAHero = new JLabel("Select a hero to Use: ");
		lblSelectAHero.setForeground(Color.WHITE);
		lblSelectAHero.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblSelectAHero.setBounds(12, 528, 242, 24);
		frmHospital.getContentPane().add(lblSelectAHero);
		JButton buttonHeroPosition1 = new JButton("");
		buttonHeroPosition1.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then hero selected will assign as hero 1 and set text in some labels in hero display heal heal and another attribute  
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero1;
				lblName.setText(hero1.name);
				lblType.setText(hero1.type.toString());
				lblheal.setText(hero1.heal.toString());
			}

		});
		buttonHeroPosition1.setOpaque(false);
		buttonHeroPosition1.setContentAreaFilled(false);
		buttonHeroPosition1.setBorderPainted(false);
		buttonHeroPosition1.setBounds(61, 597, 161, 153);
		buttonHeroPosition1.setVisible(false);
		frmHospital.getContentPane().add(buttonHeroPosition1);

		JButton buttonHeroPosition2 = new JButton("");
		buttonHeroPosition2.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then hero selected will assign as hero 2 and set text in some labels in hero display heal heal and another attribute
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero2;
				lblName.setText(hero2.name);
				lblType.setText(hero2.type.toString());
				lblheal.setText(hero2.heal.toString());
			}

		});
		buttonHeroPosition2.setOpaque(false);
		buttonHeroPosition2.setContentAreaFilled(false);
		buttonHeroPosition2.setVisible(false);
		buttonHeroPosition2.setBorderPainted(false);
		buttonHeroPosition2.setBounds(286, 597, 170, 153);
		frmHospital.getContentPane().add(buttonHeroPosition2);
		JButton buttonHeroPosition3 = new JButton("");
		buttonHeroPosition3.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then hero selected will assign as hero 3 and set text in some labels in hero display heal heal and another attribute
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero3;
				lblName.setText(hero3.name);
				lblType.setText(hero3.type.toString());
				lblheal.setText(hero3.heal.toString());
			}

		});
		buttonHeroPosition3.setOpaque(false);
		buttonHeroPosition3.setContentAreaFilled(false);
		buttonHeroPosition3.setVisible(false);
		buttonHeroPosition3.setBorderPainted(false);
		buttonHeroPosition3.setBounds(545, 597, 170, 153);
		frmHospital.getContentPane().add(buttonHeroPosition3);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Hospital.class.getResource("/img/hospital.png")));
		label.setBounds(0, 0, 1194, 787);
		frmHospital.getContentPane().add(label);
		/**
		 * this for loop is using to show if that hero in list of hero. if list contains only 1 hero so only button 1 show up 
		 * and so on
		 */
		for (int i = 0; i < gameE.Team.listOfHero.size(); i++) {
			Heroes hero = gameE.Team.listOfHero.get(i);
			if (i == 0) {
				hero1 = hero;
				buttonHeroPosition1.setVisible(true);
				buttonHeroPosition1.setIcon(new ImageIcon(SelectHeroes.class.getResource(hero.image)));
			}
			if (i == 1) {
				hero2 = hero;
				buttonHeroPosition2.setVisible(true);
				buttonHeroPosition2.setIcon(new ImageIcon(SelectHeroes.class.getResource(hero.image)));

			}

			if (i == 2) {
				hero3 = hero;
				buttonHeroPosition3.setVisible(true);
				buttonHeroPosition3.setIcon(new ImageIcon(SelectHeroes.class.getResource(hero.image)));

			}

		}

	}
}
