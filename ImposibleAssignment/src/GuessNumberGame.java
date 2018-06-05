import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GuessNumberGame {
	/**
	 * create some array list of integer to store some integer and using random to get number that Villain decide for hero to guess
	 */
	Random random = new Random();
	private static Bosslair bossLairScreen;
	private JFrame frmGuessNumber;
	Integer number;
	Integer count = 0;
	ArrayList<String> VChoseHigherLower = new ArrayList<>();
	ArrayList<Integer> VChoseNumber = new ArrayList<>();
	ArrayList<Integer> getNumber = new ArrayList<>();

	Integer VDecidenNumber;
	String VDecideHighLow;
	/**constructor that get input of Bosslair and save is as local variable
	 * @param bossLair
	 * set random higher or lower and number for villain decision
	 */
	public GuessNumberGame(Bosslair bossLair) {
		bossLairScreen = bossLair;
		VDecidenNumber = getRandomNumberVchose();
		VDecideHighLow = getRandomHigherLower();
		initialize();
		frmGuessNumber.setVisible(true);
		number = pickNumber();

	}
	/**
	 * this function dispose the window
	 */
	public void closeWindow() {
		frmGuessNumber.dispose();
	}
	/**
	 *   this function call closeDiceRollsGame from game bossLair to close this window 
	 */
	public void finishedWindow() {
		bossLairScreen.closeGuessNumber(this);
	}

	/**this function decide what the value will be base on higher or lower than villain chose number 
	 * @return integer
	 */
	public Integer pickNumber() {
		Integer result = null;
		getNumber.add(1);
		getNumber.add(2);
		getNumber.add(3);
		getNumber.add(4);
		getNumber.add(5);
		getNumber.add(6);
		getNumber.add(7);
		getNumber.add(8);
		getNumber.add(9);
		getNumber.add(10);
		if (VDecideHighLow == "Lower") {
			int index1 = random.nextInt(getNumber.subList(0, VDecidenNumber - 1).size());
			result = getNumber.get(index1);
		} else {
			int index2 = random.nextInt(getNumber.subList(VDecidenNumber, 10).size());
			result = getNumber.subList(VDecidenNumber, 10).get(index2);
		}
		return result;

	}

	/**this function is use for decide higher or lower of Villain
	 * @return string higher or lower 
	 */
	public String getRandomHigherLower() {
		VChoseHigherLower.add("Higher");
		VChoseHigherLower.add("Lower");
		int index1 = random.nextInt(VChoseHigherLower.size());
		return VChoseHigherLower.get(index1);

	}

	/**this function return a number for hero to guess what is number is
	 * @return
	 */
	public Integer getRandomNumberVchose() {
		VChoseNumber.add(5);
		VChoseNumber.add(7);
		VChoseNumber.add(4);
		VChoseNumber.add(6);
		int index1 = random.nextInt(VChoseNumber.size());
		return VChoseNumber.get(index1);

	}

	private void initialize() {
		frmGuessNumber = new JFrame();
		frmGuessNumber.setResizable(false);
		frmGuessNumber.setTitle("Guess number ");
		frmGuessNumber.setBounds(100, 100, 640, 554);
		frmGuessNumber.setLocation(550, 250);
		frmGuessNumber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuessNumber.getContentPane().setLayout(null);
		JLabel lblWelcome = new JLabel("Guess number between 1 and 10");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Dialog", Font.ITALIC, 36));
		lblWelcome.setBounds(12, 24, 638, 43);
		frmGuessNumber.getContentPane().add(lblWelcome);

		JLabel lblHeroTxt = new JLabel("Hero");
		lblHeroTxt.setForeground(Color.WHITE);
		lblHeroTxt.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
		lblHeroTxt.setBounds(97, 108, 144, 43);
		frmGuessNumber.getContentPane().add(lblHeroTxt);

		JLabel lblVs = new JLabel("Vs");
		lblVs.setForeground(Color.WHITE);
		lblVs.setFont(new Font("Dialog", Font.ITALIC, 58));
		lblVs.setBounds(277, 83, 85, 75);
		frmGuessNumber.getContentPane().add(lblVs);

		JLabel lblVillains = new JLabel("Villains");
		lblVillains.setForeground(Color.WHITE);
		lblVillains.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
		lblVillains.setBounds(411, 108, 183, 43);
		frmGuessNumber.getContentPane().add(lblVillains);

		JLabel lblHeroname = new JLabel(bossLairScreen.heroSelected.name);
		lblHeroname.setForeground(Color.WHITE);
		lblHeroname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHeroname.setBounds(111, 163, 98, 15);
		frmGuessNumber.getContentPane().add(lblHeroname);

		JLabel lblVillainsname = new JLabel(bossLairScreen.villains.name);
		lblVillainsname.setForeground(Color.WHITE);
		lblVillainsname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVillainsname.setBounds(451, 159, 120, 23);
		frmGuessNumber.getContentPane().add(lblVillainsname);

		JLabel lblValliansDecide = new JLabel("Vallians decide:");
		lblValliansDecide.setForeground(Color.WHITE);
		lblValliansDecide.setBounds(89, 225, 120, 23);
		frmGuessNumber.getContentPane().add(lblValliansDecide);

		JLabel lblHigherLower = new JLabel(VDecideHighLow);
		lblHigherLower.setForeground(Color.WHITE);
		lblHigherLower.setBounds(241, 227, 70, 19);
		frmGuessNumber.getContentPane().add(lblHigherLower);

		JLabel lblHeroGuess = new JLabel("Hero Guess:");
		lblHeroGuess.setForeground(Color.WHITE);
		lblHeroGuess.setBounds(88, 260, 117, 15);
		frmGuessNumber.getContentPane().add(lblHeroGuess);

		JLabel lblFirstGuess = new JLabel("First Guess:");
		lblFirstGuess.setForeground(Color.WHITE);
		lblFirstGuess.setBounds(157, 287, 98, 15);
		frmGuessNumber.getContentPane().add(lblFirstGuess);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(305, 282, 57, 24);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		comboBox.addItem(6);
		comboBox.addItem(7);
		comboBox.addItem(8);
		comboBox.addItem(9);
		comboBox.addItem(10);
		// comboBox.getSelectedItem()
		frmGuessNumber.getContentPane().add(comboBox);

		JLabel lblSecondGuess = new JLabel("Second Guess:");
		lblSecondGuess.setForeground(Color.WHITE);
		lblSecondGuess.setBounds(157, 331, 105, 15);
		frmGuessNumber.getContentPane().add(lblSecondGuess);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(305, 326, 57, 24);
		comboBox_1.addItem(1);
		comboBox_1.addItem(2);
		comboBox_1.addItem(3);
		comboBox_1.addItem(4);
		comboBox_1.addItem(5);
		comboBox_1.addItem(6);
		comboBox_1.addItem(7);
		comboBox_1.addItem(8);
		comboBox_1.addItem(9);
		comboBox_1.addItem(10);

		frmGuessNumber.getContentPane().add(comboBox_1);

		JLabel lblThan = new JLabel("than");
		lblThan.setForeground(Color.WHITE);
		lblThan.setBounds(323, 229, 70, 15);
		frmGuessNumber.getContentPane().add(lblThan);

		JLabel lblANumber = new JLabel(VDecidenNumber.toString());
		lblANumber.setForeground(Color.WHITE);
		lblANumber.setBounds(368, 229, 85, 15);
		frmGuessNumber.getContentPane().add(lblANumber);

		JLabel lblNewLabel = new JLabel("The Number is:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(193, 358, 120, 29);
		frmGuessNumber.getContentPane().add(lblNewLabel);

		JLabel lblNumberGuess = new JLabel("number guess");
		lblNumberGuess.setForeground(Color.WHITE);
		lblNumberGuess.setBounds(315, 365, 120, 15);
		frmGuessNumber.getContentPane().add(lblNumberGuess);

		JLabel labelWinLose = new JLabel("Win/Lose");
		labelWinLose.setForeground(Color.WHITE);
		labelWinLose.setFont(new Font("Dialog", Font.ITALIC, 25));
		labelWinLose.setBounds(236, 399, 126, 47);
		frmGuessNumber.getContentPane().add(labelWinLose);
		JButton btnDecided = new JButton("Decided ");
		btnDecided.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		btnDecided.setForeground(Color.WHITE);
		btnDecided.setOpaque(false);
		btnDecided.setBorderPainted(false);
		btnDecided.setContentAreaFilled(false);
		btnDecided.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then the game will start 
			 * if the hero selected contains power up type 2 that will help hero in this game it will show the massage and ask if the hero want to use this
			 * if hero want to use or hero is type 2 that have high chance win any game then the hero will know the future will the hero win this game(count will increase by 1)
			 * if hero lose so hero can chose again and the game will start as normal 
			 * after result hero win or lose:
			 * if hero lose then hero will take damage from the villain then  if hero is dead hero and special ability will be remove from the team 
			 * if hero is last hero of the team then game over show message game over and time 
			 * else if hero win 
			 * if the heal of the villain will be reduce by one.
			 * if heal of the villain is zero then the villain is dead and if number of villain not is zero then open the city where the boss lair from and receive 1000 gold
			 * if the number of villain in the map is zero the show finish the game with team name and time taken  
			 * if the villain is not dead then return to the boss lair and decide hero start another game
			 * if its draw return to the boss lair and decide hero start another game
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				int decide = 4;
				
				if (count == 0) {
					if (bossLairScreen.heroSelected.powerUpsHero.type == 2) {
						decide = JOptionPane.showConfirmDialog(null, "Would you like to use power up?", "Power Up", 0);
					}
					if (bossLairScreen.heroSelected.type == 2 || decide == 0) {
						if (bossLairScreen.heroSelected.powerUpsHero.type == 2) {
							bossLairScreen.heroSelected.powerUpsHero = bossLairScreen.gameE.power0;
							bossLairScreen.lblPoweruptext.setText(bossLairScreen.heroSelected.powerUpsHero.details);
						}
						if (comboBox.getSelectedItem() != number && comboBox_1.getSelectedItem() != number) {
							JOptionPane.showMessageDialog(null, "Your guess is wrong");
							count++;
						} else {
							lblNumberGuess.setText(number.toString());
							if (comboBox.getSelectedItem() == number || comboBox_1.getSelectedItem() == number) {
								labelWinLose.setText("Win");
							} else {
								labelWinLose.setText("Lose");
							}

						}
					} else {
						lblNumberGuess.setText(number.toString());
						if (comboBox.getSelectedItem() == number || comboBox_1.getSelectedItem() == number) {
							labelWinLose.setText("Win");
						} else {
							labelWinLose.setText("Lose");
						}
					}
				}

				else {
					lblNumberGuess.setText(number.toString());
					if (comboBox.getSelectedItem() == number || comboBox_1.getSelectedItem() == number) {
						labelWinLose.setText("Win");
					} else {
						labelWinLose.setText("Lose");
					}
				}

				if (labelWinLose.getText() == "Lose") {
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

				} else if (labelWinLose.getText() == "Win") {
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
							JOptionPane.showMessageDialog(null, "Congratulations Victory team " + bossLairScreen.gameE.Team.name +"!!! Time taken:" + time);
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

		btnDecided.setBounds(241, 458, 133, 38);
		frmGuessNumber.getContentPane().add(btnDecided);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.GREEN);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setOpaque(false);
		btnExit.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * when this button is clicked then return to the boss lair where that game come from
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(509, 471, 117, 25);
		frmGuessNumber.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(GuessNumberGame.class.getResource("/img/guessnumber.png")));
		lblNewLabel_1.setBounds(0, 0, 638, 528);
		frmGuessNumber.getContentPane().add(lblNewLabel_1);

	}
}