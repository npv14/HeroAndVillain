import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class Bosslair {
	/** for implement of the game, some variables created to make easier to update and keep track of the hero, villain and changing in the window 
	 */
	public Heroes hero1, hero2, hero3, heroSelected;
	JButton buttonHeroPosition2, buttonHeroPosition1, buttonHeroPosition3;
	JLabel lblHealth, lblHealv, lblPoweruptext;
	Villains villains;
	Integer typeGame;
	Random random = new Random();
	private JFrame frmBossLair;

	ArrayList<Integer> typeVillain = new ArrayList<>();
	public static GameEnvironment gameE;
	/**constructor that get input of GameEnvironment and save is as local variable
	 * @param incomingGameE
	 */
	public Bosslair(GameEnvironment incomingGameE) {

		gameE = incomingGameE;
		initialize();
		frmBossLair.setVisible(true);

	}

	/**this call makes this window dispose
	 * 
	 */
	public void closeWindow() {
		frmBossLair.dispose();
	}
	
	/**
	 * this function call closeBosslair from game Environment to close this window 
	 */
	public void finishedWindow() {
		gameE.closeBosslair(this);
	}

	/**
	 * this function will create a new window of dice roll game
	 */
	public void launchDiceRollsGame() {
		DiceRollsGame gameDiceRollsGame = new DiceRollsGame(this);

	}

	/**this function will close dice roll game window. 
	 * @param gameDiceRollsGame the window of dice roll game want to close
	 */
	public void closeDiceRollsGame(DiceRollsGame gameDiceRollsGame) {
		gameDiceRollsGame.closeWindow();
		frmBossLair.setVisible(true);

	}

	/**
	 * this function will create a new window of paper scissors rock game
	 */
	public void launchPaperScissorsRock() {
		PaperScissorRockGame gamePaperScissorRockGame = new PaperScissorRockGame(this);

	}

	/**
	 this function will close paper scissors rock game window. 
	 * @param gamePaperScissorRockGame the window of paper scissors rock game want to close
	 * 	 */
	public void closePaperScissorRockGame(PaperScissorRockGame gamePaperScissorRockGame) {
		gamePaperScissorRockGame.closeWindow();
		frmBossLair.setVisible(true);

	}

	/**
	 * * this function will create a new window of guess number game
	 */
	public void launchGuessNumber() {
		GuessNumberGame gameGuessNumberGame = new GuessNumberGame(this);

	}

	/**
	  this function will close guess number game window. 
	 * @param gameGuessNumberGame the window of guess number game want to close
	 */
	public void closeGuessNumber(GuessNumberGame gameGuessNumberGame) {
		gameGuessNumberGame.closeWindow();
		frmBossLair.setVisible(true);

	}

	/**
	 * this function to create a random roll for villain just takes the number
	 * between 1-6
	 * 
	 * @return return an integer number between 1-6
	 */
	public Integer getTypeVillain() {
		if( gameE.numberOfVillain == 1) {
			return 7;
		}
		typeVillain.add(5);
		typeVillain.add(1);
		typeVillain.add(4);
		typeVillain.add(6);
		typeVillain.add(2);
		typeVillain.add(3);
		int index1 = random.nextInt(typeVillain.size());
		return typeVillain.get(index1);

	}

	/**
	 * * this function to create a random integer takes the number
	 * between 1-3
	 * 
	 * @return an integer betweem 1-3
	 */
	public Integer getRandomGame() {
		typeVillain.add(1);
		typeVillain.add(2);
		typeVillain.add(3);
		int index1 = random.nextInt(typeVillain.size());
		return typeVillain.get(index1);

	}

	/**
	 * Initialize the contents of the frmBossLair.
	 */
	public void initialize() {
		frmBossLair = new JFrame();
		frmBossLair.setTitle("Boss Lair");
		frmBossLair.setBounds(100, 100, 1196, 813);
		frmBossLair.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBossLair.setLocation(270, 100);
		frmBossLair.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Select a hero to fight: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(12, 504, 242, 24);
		frmBossLair.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 447, 228);
		frmBossLair.getContentPane().add(panel);
		panel.setOpaque(false);
//		panel.setContentAreaFilled(false);
//		panel.setBorderPainted(false);

		JLabel lblNameTxt = new JLabel("Name:");
		lblNameTxt.setForeground(Color.WHITE);
		lblNameTxt.setBounds(12, 12, 82, 15);
		panel.add(lblNameTxt);

		JLabel lblTypeTxt = new JLabel("Type:");
		lblTypeTxt.setForeground(Color.WHITE);
		lblTypeTxt.setBounds(12, 39, 70, 15);
		panel.add(lblTypeTxt);

		JLabel lblSpecialAbilityTxt = new JLabel("Special Ability:");
		lblSpecialAbilityTxt.setForeground(Color.WHITE);
		lblSpecialAbilityTxt.setBounds(12, 70, 111, 15);
		panel.add(lblSpecialAbilityTxt);

		JLabel lblHealthTxt = new JLabel("Health:");
		lblHealthTxt.setForeground(Color.WHITE);
		lblHealthTxt.setBounds(12, 141, 70, 15);
		panel.add(lblHealthTxt);

		JLabel lblRecoveryRateTxt = new JLabel("Recovery Rate:");
		lblRecoveryRateTxt.setForeground(Color.WHITE);
		lblRecoveryRateTxt.setBounds(12, 168, 111, 15);
		panel.add(lblRecoveryRateTxt);

		JLabel lblName = new JLabel("");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(139, 12, 144, 15);
		panel.add(lblName);

		JLabel lblType = new JLabel("");
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(139, 39, 70, 15);
		panel.add(lblType);

		JLabel lblSpecialAbility = new JLabel("");
		lblSpecialAbility.setForeground(Color.WHITE);
		lblSpecialAbility.setBounds(12, 89, 359, 50);
		panel.add(lblSpecialAbility);

		lblHealth = new JLabel("");
		lblHealth.setForeground(Color.WHITE);
		lblHealth.setBounds(139, 141, 70, 15);
		panel.add(lblHealth);

		JLabel lblRecoveryRate = new JLabel("");
		lblRecoveryRate.setForeground(Color.WHITE);
		lblRecoveryRate.setBounds(149, 168, 235, 15);
		panel.add(lblRecoveryRate);
		
		JLabel lblPowerUp = new JLabel("Power Up:");
		lblPowerUp.setForeground(Color.WHITE);
		lblPowerUp.setBounds(12, 190, 82, 15);
		panel.add(lblPowerUp);
		
		lblPoweruptext = new JLabel("");
		lblPoweruptext.setForeground(Color.WHITE);
		lblPoweruptext.setBounds(106, 190, 342, 15);
		panel.add(lblPoweruptext);
		buttonHeroPosition1 = new JButton("");
		buttonHeroPosition1.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked it will set the text for some label in the panel and display detail of 
			 * hero 1 and save hero selected as hero 1
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero1;
				lblName.setText(hero1.name);
				lblHealth.setText(hero1.heal.toString());
				lblType.setText(hero1.type.toString());
				lblSpecialAbility.setText(hero1.specialAbility);
				lblRecoveryRate.setText(hero1.recoveryRate.toString() + " after each battle");
				lblPoweruptext.setText(hero1.powerUpsHero.details);
			}

		});
		buttonHeroPosition1.setOpaque(false);
		buttonHeroPosition1.setContentAreaFilled(false);
		buttonHeroPosition1.setBorderPainted(false);
		buttonHeroPosition1.setBounds(25, 594, 161, 153);
		buttonHeroPosition1.setVisible(false);
		frmBossLair.getContentPane().add(buttonHeroPosition1);

		buttonHeroPosition2 = new JButton("");
		buttonHeroPosition2.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if this button is clicked it will set the text for some label in the panel and display detail of 
			 * hero 2 and save hero selected as hero 2
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero2;
				lblName.setText(hero2.name);
				lblHealth.setText(hero2.heal.toString());
				lblType.setText(hero2.type.toString());
				lblSpecialAbility.setText(hero2.specialAbility);
				lblRecoveryRate.setText(hero2.recoveryRate.toString() + " after each battle");
				lblPoweruptext.setText(hero2.powerUpsHero.details);
			}

		});

		buttonHeroPosition2.setOpaque(false);
		buttonHeroPosition2.setContentAreaFilled(false);
		buttonHeroPosition2.setBorderPainted(false);
		buttonHeroPosition2.setBounds(209, 594, 161, 150);
		buttonHeroPosition2.setVisible(false);
		frmBossLair.getContentPane().add(buttonHeroPosition2);

		buttonHeroPosition3 = new JButton("");
		buttonHeroPosition3.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 *  if this button is clicked it will set the text for some label in the panel and display detail of 
			 * hero 3 and save hero selected as hero 3
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero3;
				lblName.setText(hero3.name);
				lblHealth.setText(hero3.heal.toString());
				lblType.setText(hero3.type.toString());
				lblSpecialAbility.setText(hero3.specialAbility);
				lblRecoveryRate.setText(hero3.recoveryRate.toString() + " after each battle");
				lblPoweruptext.setText(hero3.powerUpsHero.details);
			}

		});
		buttonHeroPosition3.setOpaque(false);
		buttonHeroPosition3.setContentAreaFilled(false);
		buttonHeroPosition3.setVisible(false);
		buttonHeroPosition3.setBorderPainted(false);
		buttonHeroPosition3.setBounds(375, 594, 170, 153);
		frmBossLair.getContentPane().add(buttonHeroPosition3);

		JButton btnFight = new JButton("Fight");
		btnFight.setFont(new Font("Dialog", Font.ITALIC, 18));
		btnFight.setContentAreaFilled(false);
		btnFight.setBorderPainted(false);
		btnFight.setOpaque(false);
		btnFight.setForeground(Color.RED);
		btnFight.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if you click fight button this will open different game depend on what type of villain is
			 * if type villain is 5 and 6 its only open dice roll game
			 * and if villain type 3 then it only open guess number game 
			 * and otherwise then it will open random game
			 */
			public void actionPerformed(ActionEvent e) {
				if (lblType.getText() == ""|| heroSelected.isDead()) {
					JOptionPane.showMessageDialog(null, "Please selected a hero to fight");
				} else {
					if (villains.type == 5 || villains.type == 6) {
						launchDiceRollsGame();

					} else if (villains.type == 3) {
						launchGuessNumber();
					} else {
						typeGame = getRandomGame();
						if (typeGame == 1) {
							launchDiceRollsGame();

						} else if (typeGame == 2) {
							launchGuessNumber();

						} else {
							launchPaperScissorsRock();
						}
					}

					frmBossLair.setVisible(false);

				}

			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.GREEN);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then it will close this boss lair window and launch previous place in game environment and launch previous city where the boss lair come from
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameE.launchPreviousPlace();
			}
		});
		btnExit.setBounds(1123, 750, 59, 25);
		frmBossLair.getContentPane().add(btnExit);
		btnFight.setBounds(539, 636, 117, 32);
		frmBossLair.getContentPane().add(btnFight);

		JLabel lblMonster = new JLabel("");

		lblMonster.setBounds(706, 558, 321, 217);
		frmBossLair.getContentPane().add(lblMonster);

		villains = new Villains(getTypeVillain());
		lblMonster.setIcon(new ImageIcon(Bosslair.class.getResource(villains.image)));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(750, 443, 432, 118);
		frmBossLair.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNametext = new JLabel("I am ");
		lblNametext.setForeground(Color.WHITE);
		lblNametext.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNametext.setBounds(26, 12, 50, 15);
		panel_1.add(lblNametext);

		JLabel lblVname = new JLabel(villains.name);
		lblVname.setForeground(Color.WHITE);
		lblVname.setFont(new Font("Dialog", Font.BOLD, 18));
		lblVname.setBounds(75, 7, 169, 25);
		panel_1.add(lblVname);

		JLabel lblTaunt = new JLabel(villains.taunt);
		lblTaunt.setForeground(Color.WHITE);
		lblTaunt.setBounds(12, 49, 420, 23);
		panel_1.add(lblTaunt);

		JLabel lblSpecialV = new JLabel(villains.specialAbility);
		lblSpecialV.setForeground(Color.WHITE);
		lblSpecialV.setBounds(12, 84, 420, 23);
		panel_1.add(lblSpecialV);

		JLabel lblHeal = new JLabel("Heal:");
		lblHeal.setForeground(Color.WHITE);
		lblHeal.setBounds(302, 13, 50, 15);
		panel_1.add(lblHeal);

		lblHealv = new JLabel(villains.heal.toString());
		lblHealv.setForeground(Color.WHITE);
		lblHealv.setBounds(350, 12, 70, 15);
		panel_1.add(lblHealv);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon(Bosslair.class.getResource("/img/bosslair2.png")));
		lblNewLabel_1.setBounds(0, 0, 1194, 787);
		frmBossLair.getContentPane().add(lblNewLabel_1);
		/**
		 * this for loop is using to show if that hero in list of hero if list contains only 1 hero so only button 1 show up 
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
