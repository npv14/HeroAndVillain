import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.management.relation.RoleUnresolvedList;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DiceRollsGame {
	ArrayList<Integer> Roll = new ArrayList<>();
	ArrayList<Integer> AdvanceRoll = new ArrayList<>();
	Random random = new Random();
	Integer heroRoll, villainsRoll;
	private static Bosslair bossLairScreen;
	private JFrame frmDiceRollGame;
	/**
	 * this function to create a random roll for villain just takes the number
	 * between 1-6
	 * 
	 * @return return an integer number between 1-6
	 */
	public Integer getRandomRoll() {
		Roll.add(5);
		Roll.add(1);
		Roll.add(4);
		Roll.add(6);
		Roll.add(2);
		Roll.add(3);
		int index1 = random.nextInt(Roll.size());
		return Roll.get(index1);

	}

	/**
	 * this function to create a random  advance roll just takes the number
	 * between 4-6
	 * 
	 * @return return an integer number between 4-6
	 */
	public Integer getAdvanceRandomRoll() {
		AdvanceRoll.add(5);
		AdvanceRoll.add(4);
		AdvanceRoll.add(6);
		int index1 = random.nextInt(AdvanceRoll.size());
		return AdvanceRoll.get(index1);

	}

	/**
	 * this is how game play and decide who win and lose
	 * 
	 * @param heroDice
	 *            this variable is result of hero throw the dice
	 * @param villainDice
	 *            this variable is result of Villain throw the dice
	 * @return a string is Win, lose or Draw
	 */
	public String gamePlay(Integer heroDice, Integer villainDice) {
		String result = null;
		if (heroDice > villainDice) {
			result = "Win";
		} else if (heroDice == villainDice) {
			result = "Draw";
		} else {
			result = "Lose";
		}
		return result;
	}
	/**constructor that get input of Bosslair and save is as local variable
	 * @param bossLair
	 */
	public DiceRollsGame(Bosslair bossLair) {
		bossLairScreen = bossLair;
		initialize();
		frmDiceRollGame.setVisible(true);

	}
	/**
	 * this function dispose the window
	 */
	public void closeWindow() {
		frmDiceRollGame.dispose();
	}
	/**
	 *   this function call closeDiceRollsGame from game bossLair to close this window 
	 */
	public void finishedWindow() {
		bossLairScreen.closeDiceRollsGame(this);
	}

	private void initialize() {
		frmDiceRollGame = new JFrame();
		frmDiceRollGame.setResizable(false);
		frmDiceRollGame.setTitle("Dice Rolls game");
		frmDiceRollGame.setBounds(100, 100, 640, 554);
		frmDiceRollGame.setLocation(550, 250);
		frmDiceRollGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDiceRollGame.getContentPane().setLayout(null);
		JLabel lblWelcome = new JLabel("Dice Rolls");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(230, 28, 192, 43);
		lblWelcome.setFont(new Font("Dialog", Font.ITALIC, 36));
		frmDiceRollGame.getContentPane().add(lblWelcome);

		JLabel lblHeroTxt = new JLabel("Hero");
		lblHeroTxt.setForeground(Color.WHITE);
		lblHeroTxt.setBounds(97, 108, 144, 43);
		lblHeroTxt.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
		frmDiceRollGame.getContentPane().add(lblHeroTxt);

		JLabel lblVs = new JLabel("Vs");
		lblVs.setForeground(Color.WHITE);
		lblVs.setBounds(277, 83, 85, 75);
		lblVs.setFont(new Font("Dialog", Font.ITALIC, 58));
		frmDiceRollGame.getContentPane().add(lblVs);

		JLabel lblVillains = new JLabel("Villains");
		lblVillains.setForeground(Color.WHITE);
		lblVillains.setBounds(411, 108, 183, 43);
		lblVillains.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
		frmDiceRollGame.getContentPane().add(lblVillains);

		JLabel lblHeroname = new JLabel(bossLairScreen.heroSelected.name);
		lblHeroname.setForeground(Color.WHITE);
		lblHeroname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHeroname.setBounds(107, 163, 98, 15);
		frmDiceRollGame.getContentPane().add(lblHeroname);

		JLabel lblVillainsname = new JLabel(bossLairScreen.villains.name);
		lblVillainsname.setForeground(Color.WHITE);
		lblVillainsname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVillainsname.setBounds(443, 159, 116, 22);
		frmDiceRollGame.getContentPane().add(lblVillainsname);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(219, 330, 203, 125);
		frmDiceRollGame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblHeroChose = new JLabel("Hero  got");
		lblHeroChose.setForeground(Color.WHITE);
		lblHeroChose.setBounds(12, 12, 70, 15);
		panel.add(lblHeroChose);

		JLabel lblVillainsChose = new JLabel("Villain got");
		lblVillainsChose.setForeground(Color.WHITE);
		lblVillainsChose.setBounds(12, 39, 83, 15);
		panel.add(lblVillainsChose);

		JLabel lblWinlose = new JLabel("Win/Lose");
		lblWinlose.setForeground(Color.WHITE);
		lblWinlose.setFont(new Font("Dialog", Font.ITALIC, 25));
		lblWinlose.setBounds(41, 66, 126, 47);
		panel.add(lblWinlose);

		JLabel lblHeroDiceResult = new JLabel("");
		lblHeroDiceResult.setBounds(97, 12, 70, 15);
		panel.add(lblHeroDiceResult);

		JLabel lblVillainsdDiceResult = new JLabel("");
		lblVillainsdDiceResult.setBounds(97, 39, 70, 15);
		panel.add(lblVillainsdDiceResult);
		JButton btnNewButton = new JButton("Rolls The Dice");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 19));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			/*
			 * (non-Javadoc) if click this button roll then the game will start 
			 * if the hero selected contains power up type 1 that will help hero in this game it will show the massage and ask if the hero want to use this
			 *  if hero want to use or hero is type 2 that have high chance win any game then the hero will have advance to use advance roll that only get 4, 5, 6
			 *  after result hero win or lose:
			 * if hero lose then hero will take damage from the villain then  if hero is dead hero and special ability will be remove from the team 
			 * if hero is last hero of the team then game over show message game over and time 
			 * else if hero win 
			 * if the heal of the villain will be reduce by one.
			 * if heal of the villain is zero then the villain is dead and if number of villain not is zero then open the city where the boss lair from and receive 1000 gold
			 * if the number of villain in the map is zero the show finish the game with team name and time taken  
			 * if the villain is not dead then return to the boss lair and decide hero start another game
			 * if its draw return to the boss lair and decide hero start another game
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				String result;
				int decide = 4;
				if (bossLairScreen.heroSelected.powerUpsHero.type == 1) {
					decide = JOptionPane.showConfirmDialog(null, "Would you like to use power up?", "Power Up", 0);
				}
				if (bossLairScreen.heroSelected.type == 2 || decide == 0) {
						bossLairScreen.heroSelected.powerUpsHero = bossLairScreen.gameE.power0;
						bossLairScreen.lblPoweruptext.setText(bossLairScreen.heroSelected.powerUpsHero.details);
					
					heroRoll = getAdvanceRandomRoll();
				}

				else {
					heroRoll = getRandomRoll();
				}

				lblHeroDiceResult.setText(heroRoll.toString());
				if (bossLairScreen.villains.type == 5 || bossLairScreen.villains.type == 6 ) {
					villainsRoll = getAdvanceRandomRoll();
				}

				else {
					villainsRoll = getRandomRoll();
				}

				lblVillainsdDiceResult.setText(villainsRoll.toString());
				result = gamePlay(heroRoll, villainsRoll);
				lblWinlose.setText(result);

				if (lblWinlose.getText() == "Lose") {
					bossLairScreen.heroSelected.heal -= bossLairScreen.villains.damage;
					if (bossLairScreen.heroSelected.heal
							+ bossLairScreen.heroSelected.recoveryRate <= bossLairScreen.heroSelected.maxheal) {
						bossLairScreen.heroSelected.heal += bossLairScreen.heroSelected.recoveryRate;

					}

					bossLairScreen.lblHealth.setText(bossLairScreen.heroSelected.heal.toString());
					if (bossLairScreen.heroSelected.isDead()) {
						bossLairScreen.gameE.Team.removeHero(bossLairScreen.heroSelected);
						if (bossLairScreen.gameE.Team.listOfHero.size() == 0) {
							String time = bossLairScreen.gameE.getTimer();
							JOptionPane.showMessageDialog(null,
									"All heroes are dead,finally Game Over Finish Assignment hehe!!! Time taken:" + time);
							bossLairScreen.closeWindow();
							closeWindow();

						}
						bossLairScreen.gameE.Team.removeHero(bossLairScreen.heroSelected);
						if (bossLairScreen.heroSelected == bossLairScreen.hero1) {
							bossLairScreen.buttonHeroPosition1.setVisible(false);
						}
						if (bossLairScreen.heroSelected == bossLairScreen.hero2) {
							bossLairScreen.buttonHeroPosition2.setVisible(false);
						}
						if (bossLairScreen.heroSelected == bossLairScreen.hero3) {
							bossLairScreen.buttonHeroPosition3.setVisible(false);
						}

					}
					if (bossLairScreen.gameE.Team.listOfHero.size() != 0) {
						int i = JOptionPane.showConfirmDialog(null, "Hero Lose", "Result", 2);
						if (i == 0 || i == 2) {
							finishedWindow();
						}

					}

				} else if (lblWinlose.getText() == "Win") {
					if (bossLairScreen.heroSelected.heal
							+ bossLairScreen.heroSelected.recoveryRate <= bossLairScreen.heroSelected.maxheal) {
						bossLairScreen.heroSelected.heal += bossLairScreen.heroSelected.recoveryRate;

					}
					bossLairScreen.villains.heal -= 1;
					bossLairScreen.lblHealth.setText(bossLairScreen.heroSelected.heal.toString());
					bossLairScreen.lblHealv.setText(bossLairScreen.villains.heal.toString());

					if (bossLairScreen.villains.heal == 0) {
						bossLairScreen.gameE.numberOfVillain -= 1;
						if (bossLairScreen.gameE.numberOfVillain == 0) {
							String time = bossLairScreen.gameE.getTimer();
							JOptionPane.showMessageDialog(null, "Congratulations Victory team " + bossLairScreen.gameE.Team.name +"!!! Time taken: " + time);
							bossLairScreen.closeWindow();
							closeWindow();
						} else {
							bossLairScreen.gameE.Team.money += 1000;
							bossLairScreen.finishedWindow();

							if (bossLairScreen.gameE.PreviousPlace == "CityOne") {
								bossLairScreen.gameE.progressCityOne = true;
							} else if (bossLairScreen.gameE.PreviousPlace == "CityTwo") {
								bossLairScreen.gameE.progressCityTwo = true;
							} else if (bossLairScreen.gameE.PreviousPlace == "CityThree") {
								bossLairScreen.gameE.progressCityThree = true;
							} else if (bossLairScreen.gameE.PreviousPlace == "CityFour") {
								bossLairScreen.gameE.progressCityFour = true;
							} else if (bossLairScreen.gameE.PreviousPlace == "CityFive") {
								bossLairScreen.gameE.progressCityFive = true;
							} else if (bossLairScreen.gameE.PreviousPlace == "CitySix") {
								bossLairScreen.gameE.progressCitySix = true;
							}
							bossLairScreen.gameE.launchPreviousPlace();

							int i = JOptionPane.showConfirmDialog(null,
									"You defeated the Villain in this city." + "you recieved 1000 Gold.", "Victory", 2);

							closeWindow();
							if (i == 0 || i == 2) {
								closeWindow();
							}
						}
					}

					else if (bossLairScreen.villains.heal != 0) {
						int i = JOptionPane.showConfirmDialog(null, "Hero Win", "Result", 2);
						if (i == 0 || i == 2) {
							finishedWindow();

						}

					}
				}

			}
		});

		btnNewButton.setBounds(219, 233, 203, 67);
		frmDiceRollGame.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.GREEN);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setOpaque(false);
		btnExit.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(521, 491, 117, 25);
		frmDiceRollGame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DiceRollsGame.class.getResource("/img/dice.png")));
		lblNewLabel.setBounds(0, 0, 638, 528);
		frmDiceRollGame.getContentPane().add(lblNewLabel);

	}
}
