
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * @author npv14
 *
 */
public class PaperScissorRockGame {
	String Hchose = null;
	Random randomstr = new Random();
	Integer count = 0;
	String Vdecided;
	ArrayList<String> Vchose = new ArrayList<>();
	private JFrame frmPaperScissorsRock;
	private static Bosslair bossLairScreen;

	/**
	 * that function decided what Villains will chose by create a random Variable.
	 * 
	 * 
	 * @return A String "Paper", "Scissors" or "Rock"
	 */

	public String getrandom() {
		Vchose.add("Rock");
		Vchose.add("Paper");
		Vchose.add("Scissors");
		int index1 = randomstr.nextInt(Vchose.size());
		return Vchose.get(index1);

	}

	/**
	 * that function takes 2 variables is
	 * 
	 * @param Herochose
	 * @param Villainchose
	 * @return decide Who Win by simple comparisons
	 */
	public String gameplay(String Herochose, String Villainchose) {

		String result = null;
		if (Herochose == "Rock") {
			if (Villainchose == "Rock") {
				result = "Draw";
			}
			if (Villainchose == "Paper") {
				result = "Lose";
			}
			if (Villainchose == "Scissors") {
				result = "Win";
			}
		} else if (Herochose == "Paper") {
			if (Villainchose == "Rock") {
				result = "Win";
			}
			if (Villainchose == "Paper") {
				result = "Draw";
			}
			if (Villainchose == "Scissors") {
				result = "Lose";
			}
		} else {
			if (Villainchose == "Rock") {
				result = "Lose";
			}
			if (Villainchose == "Paper") {
				result = "Win";
			}
			if (Villainchose == "Scissors") {
				result = "Draw";
			}

		}
		return result;
	}
	/**constructor that get input of Bosslair and save is as local variable
	 * and get what villain decided
	 * @param bossLair
	 */
	public PaperScissorRockGame(Bosslair bossLair) {
		bossLairScreen = bossLair;
		initialize();
		frmPaperScissorsRock.setVisible(true);
		Vdecided = getrandom();

	}

	/**
	 * this function dispose the window
	 */
	public void closeWindow() {
		frmPaperScissorsRock.dispose();
	}

	/**
	 *   this function call closePaperScissorRockGame from game bossLair to close this window 
	 */
	public void finishedWindow() {
		bossLairScreen.closePaperScissorRockGame(this);
	}

	/**
	 * this function set up the game display, like buttons, labels, how game display
	 * and show. Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPaperScissorsRock = new JFrame();
		frmPaperScissorsRock.setResizable(false);
		frmPaperScissorsRock.setTitle("Paper, Scissors, Rock game");
		frmPaperScissorsRock.setBounds(100, 100, 640, 554);
		frmPaperScissorsRock.setLocation(550, 250);
		frmPaperScissorsRock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaperScissorsRock.getContentPane().setLayout(null);

		JLabel lblWelcome = new JLabel("Paper, Scissors, Rock");
		lblWelcome.setFont(new Font("Dialog", Font.ITALIC, 36));
		lblWelcome.setBounds(125, 28, 430, 43);
		frmPaperScissorsRock.getContentPane().add(lblWelcome);

		JLabel lblHeroTxt = new JLabel("Hero");
		lblHeroTxt.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
		lblHeroTxt.setBounds(97, 108, 144, 43);
		frmPaperScissorsRock.getContentPane().add(lblHeroTxt);

		JLabel lblVs = new JLabel("Vs");
		lblVs.setFont(new Font("Dialog", Font.ITALIC, 58));
		lblVs.setBounds(277, 83, 85, 75);
		frmPaperScissorsRock.getContentPane().add(lblVs);

		JLabel lblVillains = new JLabel("Villains");
		lblVillains.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
		lblVillains.setBounds(411, 108, 183, 43);
		frmPaperScissorsRock.getContentPane().add(lblVillains);

		JLabel lblHeroname = new JLabel(bossLairScreen.heroSelected.name);
		lblHeroname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHeroname.setBounds(107, 163, 98, 15);
		frmPaperScissorsRock.getContentPane().add(lblHeroname);

		JLabel lblVillainsname = new JLabel(bossLairScreen.villains.name);
		lblVillainsname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVillainsname.setBounds(458, 163, 97, 15);
		frmPaperScissorsRock.getContentPane().add(lblVillainsname);

		JButton btnRock = new JButton("Rock");
		btnRock.setContentAreaFilled(false);
		btnRock.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then Hchose variable will be store as string "Rock"
			 */
			public void actionPerformed(ActionEvent e) {
				Hchose = "Rock";
			}
		});
		btnRock.setBounds(439, 238, 128, 67);
		frmPaperScissorsRock.getContentPane().add(btnRock);

		JButton btnScissors = new JButton("Scissors");
		btnScissors.setContentAreaFilled(false);
		btnScissors.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if this button is clicked then Hchose variable will be store as string "Scissors"
			 */
			public void actionPerformed(ActionEvent e) {
				Hchose = "Scissors";
			}

		});
		btnScissors.setBounds(260, 238, 128, 67);
		frmPaperScissorsRock.getContentPane().add(btnScissors);

		JButton btnPaper = new JButton("Paper");
		btnPaper.setContentAreaFilled(false);
		btnPaper.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 *  if this button is clicked then Hchose variable will be store as string "Paper"
			 */
			public void actionPerformed(ActionEvent e) {
				Hchose = "Paper";

			}
		});
		btnPaper.setBounds(75, 238, 128, 67);
		frmPaperScissorsRock.getContentPane().add(btnPaper);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(206, 338, 203, 125);
		frmPaperScissorsRock.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblHeroChose = new JLabel("Hero ");
		lblHeroChose.setBounds(12, 12, 54, 15);
		panel.add(lblHeroChose);

		JLabel lblVillainsChose = new JLabel("Villains");
		lblVillainsChose.setBounds(12, 39, 54, 15);
		panel.add(lblVillainsChose);

		JLabel lblWinlose = new JLabel("Win/Lose");
		lblWinlose.setFont(new Font("Dialog", Font.ITALIC, 25));
		lblWinlose.setBounds(41, 66, 126, 47);
		panel.add(lblWinlose);

		JLabel lblHerodecide = new JLabel("");
		lblHerodecide.setBounds(78, 12, 70, 15);
		panel.add(lblHerodecide);

		JLabel lblVillainsdecide = new JLabel("");
		lblVillainsdecide.setBounds(78, 39, 70, 15);
		panel.add(lblVillainsdecide);

		JButton btnDecided = new JButton("Decided");
		btnDecided.setForeground(Color.RED);
		btnDecided.setDefaultCapable(false);
		btnDecided.setContentAreaFilled(false);
		btnDecided.addActionListener(new ActionListener() {
			/*
			 * (non-Javadoc) if the hero haven't decided so it will a message box to remind
			 * the hero
			 * all of this else if statement below is decide how the game is work. 
			 * if the player haven't decided then show the message
			 * if the hero selected contains power up type 3 that will help hero in this game it will show the massage and ask if the hero want to use this
			 * if hero want to use or hero is type 2 that have high chance win any game then the hero will have advance to not lose at the first guess(count will increase)
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
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				int decide = 4;
				/**
				 * if hero haven't clicked and button paper, scissor, rock and click decided
				 * it will pop the massage  
				 */
				if (Hchose == null) {
					JOptionPane.showMessageDialog(null, "Hero hasn't decided");
				/**if it not true the the game will start
				 */
				} else {
					
					if (count == 0) {
						if (bossLairScreen.heroSelected.powerUpsHero.type == 3) {
							decide = JOptionPane.showConfirmDialog(null, "Would you like to use power up?", "Power Up", 0);
						}
						if (bossLairScreen.heroSelected.type == 2 || decide == 0) {
							 {
								
								bossLairScreen.heroSelected.powerUpsHero = bossLairScreen.gameE.power0; 
								bossLairScreen.lblPoweruptext.setText(bossLairScreen.heroSelected.powerUpsHero.details);
								
							}
							if (gameplay(Hchose, Vdecided) != "Win") {
								JOptionPane.showMessageDialog(null, "You would not win");
								count++;
							} else {
								lblHerodecide.setText(Hchose);
								lblVillainsdecide.setText(Vdecided);
								lblWinlose.setText(gameplay(Hchose, Vdecided));
							}
						}
						else {
							lblHerodecide.setText(Hchose);
							lblVillainsdecide.setText(Vdecided);
							lblWinlose.setText(gameplay(Hchose, Vdecided));
						}
					}

					else {
						lblHerodecide.setText(Hchose);
						lblVillainsdecide.setText(Vdecided);
						lblWinlose.setText(gameplay(Hchose, Vdecided));
					}
				}
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

				else if (lblWinlose.getText() == "Draw") {
					int i = JOptionPane.showConfirmDialog(null, "Draw", "Result", 2);
					if (i == 0 || i == 2) {
						finishedWindow();

					}
				}
			}
		});
		btnDecided.setBounds(245, 463, 117, 25);
		frmPaperScissorsRock.getContentPane().add(btnDecided);

		JButton btnExit = new JButton("Exit");
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setForeground(Color.GREEN);
		btnExit.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * when this button is clicked then return to the boss lair where that game come from
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(495, 491, 117, 25);
		frmPaperScissorsRock.getContentPane().add(btnExit);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setIcon(new ImageIcon(PaperScissorRockGame.class.getResource("/img/PaperSR.png")));
		lblImage.setBounds(0, 0, 638, 528);
		frmPaperScissorsRock.getContentPane().add(lblImage);
	}
}
