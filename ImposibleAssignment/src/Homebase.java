import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Homebase {
	ArrayList<Integer> RandomEventsInteger = new ArrayList<>();
	Random random = new Random();
	private JFrame frmHeroHomebase;
	private static GameEnvironment gameE;

	public Homebase(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		initialize();
		frmHeroHomebase.setVisible(true);
		randomEvents();
	}

	/**this function for close this window
	 * 
	 */
	public void closeWindow() {
		frmHeroHomebase.dispose();
	}

	/***this function calls function from gameEnviroment to close this window
	 * 
	 */
	public void finishedWindow() {
		gameE.closeHomebase(this);
	}

	/**Function is using to get random integer between 1-4
	 * @return integer between 1-4
	 */
	public Integer getRandomInteger() {
		RandomEventsInteger.add(1);
		RandomEventsInteger.add(4);
		RandomEventsInteger.add(2);
		RandomEventsInteger.add(3);
		int index1 = random.nextInt(RandomEventsInteger.size());
		return RandomEventsInteger.get(index1);

	}

	/**
	 * Function is using to get random integer between 1-3
	 * @return integer between 1-3
	 */
	public Integer getInteger() {
		ArrayList<Integer> RandomInteger = new ArrayList<>();
		RandomInteger.add(1);
		RandomInteger.add(2);
		RandomInteger.add(3);
		int index = random.nextInt(RandomInteger.size());
		return RandomInteger.get(index);
	}

	/**Function get the integer from getInteger and decide random type of HealingItems
	 * @return Healing Items type( depend on number of integer)
	 */
	public HealingItems getRandomHealingItem() {
		HealingItems result = gameE.HealingItems1;
		;
		switch (getInteger()) {
		case 1:
			result = gameE.HealingItems3;
			break;
		case 2:
			result = gameE.HealingItems2;
			break;

		}
		return result;

	}

	/**
	 * Function get the integer from getInteger and decide random type of power up type
	 * @return power up type( depend on number of integer)
	 */
	public PowerUps getRandomPowerUpItem() {
		PowerUps result = gameE.power1;
		
		switch (getInteger()) {
		case 1:
			result = gameE.power2;
			break;
		case 2:
			result = gameE.power3;
			break;

		}
		return result;

	}

	/**
	 * this function create random even happen when hero enter the home base 
	 * its get a random number from get random integer function
	 * in case 1 and 2
	 * the team will be stolen the first items in list of healing or power up. If the team does not have any then show the message.
	 * in case 3 and 4 
	 * The team will be gifted a random healing items type and power up type   
	 */
	public void randomEvents() {
		switch (getRandomInteger()) {
		case 1:
			if (gameE.Team.listOfHealing.size() == 0) {
				JOptionPane.showMessageDialog(null, "Team be stolen Healing items but team does not have any!");
			} else {
				JOptionPane.showMessageDialog(null,
						"Team be stolen Healing items type: " + gameE.Team.listOfHealing.get(0).type.toString());
				gameE.Team.listOfHealing.remove(0);

			}
			break;
		case 2:
			if (gameE.Team.listOfPowerUps.size() == 0) {
				JOptionPane.showMessageDialog(null, "Team be stolen Power Ups but team does not have any!");
			} else {
				JOptionPane.showMessageDialog(null,
						"Team be stolen Power Ups type: " + gameE.Team.listOfPowerUps.get(0).type.toString());
				gameE.Team.listOfPowerUps.remove(0);

			}
			break;
		case 3:
			PowerUps powerUpsAdded =  getRandomPowerUpItem();
			gameE.Team.listOfPowerUps.add(powerUpsAdded);
			JOptionPane.showMessageDialog(null, "Team be gifted Power Ups type: " + powerUpsAdded.type.toString());
			break;
		case 4:
			HealingItems healingItemsAdded = getRandomHealingItem();
			gameE.Team.listOfHealing.add(healingItemsAdded);
			JOptionPane.showMessageDialog(null, "Team be gifted Healing items type: " + healingItemsAdded.type.toString());
			break;

		}

	}

	/** 
	 * 
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frmHeroHomebase = new JFrame();
		frmHeroHomebase.setResizable(false);
		frmHeroHomebase.setTitle("Hero Homebase");
		frmHeroHomebase.setBounds(100, 100, 1196, 813);
		frmHeroHomebase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHeroHomebase.setLocation(270, 100);
		frmHeroHomebase.getContentPane().setLayout(null);

		JButton btnNorth = new JButton("North");
		btnNorth.setForeground(Color.WHITE);
		btnNorth.setOpaque(false);
		btnNorth.setContentAreaFilled(false);
		btnNorth.setBorderPainted(false);
		btnNorth.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will lead to city one and store previous place as home base and close the home base window
			 */
			public void actionPerformed(ActionEvent e) {
				gameE.PreviousPlace = "Homebase";

				gameE.launchCityOne();
				finishedWindow();

			}
		});
		btnNorth.setBounds(394, -7, 355, 38);
		frmHeroHomebase.getContentPane().add(btnNorth);

		JButton btnEast = new JButton("East");
		btnEast.setForeground(Color.WHITE);
		btnEast.setOpaque(false);
		btnEast.setContentAreaFilled(false);
		btnEast.setBorderPainted(false);
		btnEast.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will lead to city two and store previous place as home base and close the home base window
			 */
			public void actionPerformed(ActionEvent e) {
				gameE.PreviousPlace = "Homebase";
				gameE.launchCityTwo();
				finishedWindow();
			}
		});
		btnEast.setBounds(1123, 200, 71, 327);
		frmHeroHomebase.getContentPane().add(btnEast);

		JButton btnSouth = new JButton("South");
		btnSouth.setForeground(Color.WHITE);
		btnSouth.setOpaque(false);
		btnSouth.setContentAreaFilled(false);
		btnSouth.setBorderPainted(false);
		btnSouth.setVisible(false);
		btnSouth.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will lead to city four and store previous place as home base and close the home base window.
			 * in this button if number of city smaller than 3 then it will be invisible else is visible.
			 */
			public void actionPerformed(ActionEvent e) {
				gameE.PreviousPlace = "Homebase";
				gameE.launchCityFour();
				finishedWindow();
			}
		});
		btnSouth.setBounds(523, 749, 204, 38);
		frmHeroHomebase.getContentPane().add(btnSouth);
		if (gameE.numberOfCity > 3) {
			btnSouth.setVisible(true);
		}

		JButton btnWest = new JButton("West");
		btnWest.setForeground(Color.WHITE);
		btnWest.setOpaque(false);
		btnWest.setContentAreaFilled(false);
		btnWest.setBorderPainted(false);
		btnWest.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will lead to city three and store previous place as home base and close the home base window.
			 */
			public void actionPerformed(ActionEvent e) {
				gameE.PreviousPlace = "Homebase";
				gameE.launchCityThree();
				finishedWindow();
			}
		});
		btnWest.setBounds(0, 200, 71, 327);
		frmHeroHomebase.getContentPane().add(btnWest);

		JButton buttonHeroPosition1 = new JButton("");
		buttonHeroPosition1.setOpaque(false);
		buttonHeroPosition1.setContentAreaFilled(false);
		buttonHeroPosition1.setBorderPainted(false);
		buttonHeroPosition1.setBounds(290, 284, 161, 125);
		frmHeroHomebase.getContentPane().add(buttonHeroPosition1);

		JButton buttonHeroPosition2 = new JButton("");
		buttonHeroPosition2.setOpaque(false);
		buttonHeroPosition2.setContentAreaFilled(false);
		buttonHeroPosition2.setBorderPainted(false);
		buttonHeroPosition2.setBounds(505, 468, 161, 150);
		frmHeroHomebase.getContentPane().add(buttonHeroPosition2);

		JButton buttonHeroPosition3 = new JButton("");
		buttonHeroPosition3.setOpaque(false);
		buttonHeroPosition3.setContentAreaFilled(false);
		buttonHeroPosition3.setBorderPainted(false);
		buttonHeroPosition3.setBounds(740, 284, 170, 125);
		frmHeroHomebase.getContentPane().add(buttonHeroPosition3);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(728, 539, 466, 248);
		frmHeroHomebase.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTeam = new JLabel("Team:");
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setBounds(0, 0, 70, 15);
		panel.add(lblTeam);

		JLabel lblTeamgold = new JLabel("TeamGold:");
		lblTeamgold.setForeground(Color.WHITE);
		lblTeamgold.setBounds(223, 0, 91, 15);
		panel.add(lblTeamgold);

		JLabel lblGold = new JLabel(gameE.Team.money.toString());
		lblGold.setForeground(Color.WHITE);
		lblGold.setBounds(326, 0, 92, 15);
		panel.add(lblGold);

		JLabel lblTeamName = new JLabel(gameE.Team.name);
		lblTeamName.setForeground(Color.WHITE);
		lblTeamName.setBounds(108, 0, 84, 15);
		panel.add(lblTeamName);

		JLabel lblHeroName1 = new JLabel("");
		lblHeroName1.setForeground(Color.WHITE);
		lblHeroName1.setBounds(10, 37, 70, 15);
		panel.add(lblHeroName1);

		JLabel lblHeroNameTxt1 = new JLabel("");
		lblHeroNameTxt1.setForeground(Color.WHITE);
		lblHeroNameTxt1.setBounds(92, 37, 70, 15);
		panel.add(lblHeroNameTxt1);

		JLabel lblTypeHero1 = new JLabel("");
		lblTypeHero1.setForeground(Color.WHITE);
		lblTypeHero1.setBounds(182, 37, 44, 15);
		panel.add(lblTypeHero1);

		JLabel lblTypeHeroTxt1 = new JLabel("");
		lblTypeHeroTxt1.setForeground(Color.WHITE);
		lblTypeHeroTxt1.setBounds(226, 37, 44, 15);
		panel.add(lblTypeHeroTxt1);

		JLabel lblHeroheal1 = new JLabel("");
		lblHeroheal1.setForeground(Color.WHITE);
		lblHeroheal1.setBounds(278, 37, 70, 15);
		panel.add(lblHeroheal1);

		JLabel lblHeroHealTxt1 = new JLabel("");
		lblHeroHealTxt1.setForeground(Color.WHITE);
		lblHeroHealTxt1.setBounds(348, 37, 70, 15);
		panel.add(lblHeroHealTxt1);

		JLabel lblHeroName2 = new JLabel("");
		lblHeroName2.setForeground(Color.WHITE);
		lblHeroName2.setBounds(10, 116, 70, 15);
		panel.add(lblHeroName2);

		JLabel lblHeroNameTxt2 = new JLabel("");
		lblHeroNameTxt2.setForeground(Color.WHITE);
		lblHeroNameTxt2.setBounds(92, 116, 70, 15);
		panel.add(lblHeroNameTxt2);

		JLabel lblTypeHero2 = new JLabel("");
		lblTypeHero2.setForeground(Color.WHITE);
		lblTypeHero2.setBounds(182, 116, 44, 15);
		panel.add(lblTypeHero2);

		JLabel lblTypeHeroTxt2 = new JLabel("");
		lblTypeHeroTxt2.setForeground(Color.WHITE);
		lblTypeHeroTxt2.setBounds(226, 116, 44, 15);
		panel.add(lblTypeHeroTxt2);

		JLabel lblHeroheal2 = new JLabel("");
		lblHeroheal2.setForeground(Color.WHITE);
		lblHeroheal2.setBounds(278, 116, 70, 15);
		panel.add(lblHeroheal2);

		JLabel lblHeroHealTxt2 = new JLabel("");
		lblHeroHealTxt2.setForeground(Color.WHITE);
		lblHeroHealTxt2.setBounds(348, 116, 70, 15);
		panel.add(lblHeroHealTxt2);

		JLabel lblHeroName3 = new JLabel("");
		lblHeroName3.setForeground(Color.WHITE);
		lblHeroName3.setBounds(10, 184, 70, 15);
		panel.add(lblHeroName3);

		JLabel lblHeroNameTxt3 = new JLabel("");
		lblHeroNameTxt3.setForeground(Color.WHITE);
		lblHeroNameTxt3.setBounds(92, 184, 70, 15);
		panel.add(lblHeroNameTxt3);

		JLabel lblTypeHero3 = new JLabel("");
		lblTypeHero3.setForeground(Color.WHITE);
		lblTypeHero3.setBounds(182, 184, 44, 15);
		panel.add(lblTypeHero3);

		JLabel lblTypeHeroTxt3 = new JLabel("");
		lblTypeHeroTxt3.setForeground(Color.WHITE);
		lblTypeHeroTxt3.setBounds(226, 184, 44, 15);
		panel.add(lblTypeHeroTxt3);

		JLabel lblHeroheal3 = new JLabel("");
		lblHeroheal3.setForeground(Color.WHITE);
		lblHeroheal3.setBounds(278, 184, 70, 15);
		panel.add(lblHeroheal3);

		JLabel lblHeroHealTxt3 = new JLabel("");
		lblHeroHealTxt3.setForeground(Color.WHITE);
		lblHeroHealTxt3.setBounds(348, 184, 70, 15);
		panel.add(lblHeroHealTxt3);

		JLabel lblSpecialabilityHero1 = new JLabel("");
		lblSpecialabilityHero1.setForeground(Color.WHITE);
		lblSpecialabilityHero1.setBounds(0, 73, 70, 15);
		panel.add(lblSpecialabilityHero1);

		JLabel lblSpecialabilityHero2 = new JLabel("");
		lblSpecialabilityHero2.setForeground(Color.WHITE);
		lblSpecialabilityHero2.setBounds(0, 143, 70, 15);
		panel.add(lblSpecialabilityHero2);

		JLabel lblSpecialabilityHero3 = new JLabel("");
		lblSpecialabilityHero3.setForeground(Color.WHITE);
		lblSpecialabilityHero3.setBounds(0, 211, 70, 15);
		panel.add(lblSpecialabilityHero3);

		JLabel lblSATxt1 = new JLabel("");
		lblSATxt1.setForeground(Color.WHITE);
		lblSATxt1.setBounds(92, 64, 393, 35);
		panel.add(lblSATxt1);

		JLabel lblSATxt2 = new JLabel("");
		lblSATxt2.setForeground(Color.WHITE);
		lblSATxt2.setBounds(92, 137, 393, 35);
		panel.add(lblSATxt2);

		JLabel lblSATxt3 = new JLabel("");
		lblSATxt3.setForeground(Color.WHITE);
		lblSATxt3.setBounds(92, 201, 393, 35);
		panel.add(lblSATxt3);

		JButton btnMap = new JButton("Map");
		btnMap.setOpaque(false);
		btnMap.setContentAreaFilled(false);
		btnMap.setBorderPainted(false);
		btnMap.setIcon(new ImageIcon(Homebase.class.getResource("/img/map.png")));
		btnMap.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * If variable map in gameE is true then it will appear
			 * depend on the number of city it will show the map appropriate.
			 * and open the map window and save previous place as home base.
			 */
			public void actionPerformed(ActionEvent e) {
				switch (gameE.numberOfCity) {
				case 4:
					gameE.launchMap4City();
					break;
				case 5:
					gameE.launchMap5City();
					break;
				case 6:
					gameE.launchMap6City();
					break;
				default:
					gameE.launchMap3City();
					break;
				}
				gameE.PreviousPlace = "Homebase";
				frmHeroHomebase.setVisible(false);
			}
		});
		btnMap.setBounds(1076, -18, 128, 128);
		frmHeroHomebase.getContentPane().add(btnMap);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Homebase.class.getResource("/img/middle1.png")));
		label.setBounds(469, 255, 210, 201);
		frmHeroHomebase.getContentPane().add(label);
		
		JLabel lblImagebackgound = new JLabel("");
		lblImagebackgound.setIcon(new ImageIcon(Homebase.class.getResource("/img/homebase.png")));
		lblImagebackgound.setBounds(1, 0, 1193, 787);
		frmHeroHomebase.getContentPane().add(lblImagebackgound);
		btnMap.setVisible(false);
		/**
		 * those for loop under is using for update all of the labels and map while the window be opened
		 * and load the images and changing in game.
		 */
		if (gameE.Team.map == true) {
			btnMap.setVisible(true);
		}

		for (int i = 0; i < gameE.Team.listOfHero.size(); i++) {
			Heroes hero1 = gameE.Team.listOfHero.get(i);
			if (i == 0) {
				buttonHeroPosition1.setIcon(new ImageIcon(SelectHeroes.class.getResource(hero1.image)));
				lblHeroName1.setText("Hero:");
				lblHeroNameTxt1.setText(hero1.name);
				lblTypeHero1.setText("Type:");
				lblTypeHeroTxt1.setText(hero1.type.toString());
				lblHeroheal1.setText("Heal:");
				lblHeroHealTxt1.setText(hero1.heal.toString());
				lblSpecialabilityHero1.setText("Ability:");
				lblSATxt1.setText(hero1.specialAbility);
			}
			if (i == 1) {
				buttonHeroPosition2.setIcon(new ImageIcon(SelectHeroes.class.getResource(hero1.image)));
				lblHeroName2.setText("Hero:");
				lblHeroNameTxt2.setText(hero1.name);
				lblTypeHero2.setText("Type:");
				lblTypeHeroTxt2.setText(hero1.type.toString());
				lblHeroheal2.setText("Heal:");
				lblHeroHealTxt2.setText(hero1.heal.toString());
				lblSpecialabilityHero2.setText("Ability:");
				lblSATxt2.setText(hero1.specialAbility);

			}
			if (i == 2) {
				buttonHeroPosition3.setIcon(new ImageIcon(SelectHeroes.class.getResource(hero1.image)));
				lblHeroName3.setText("Hero:");
				lblHeroNameTxt3.setText(hero1.name);
				lblTypeHero3.setText("Type:");
				lblTypeHeroTxt3.setText(hero1.type.toString());
				lblHeroheal3.setText("Heal:");
				lblHeroHealTxt3.setText(hero1.heal.toString());
				lblSpecialabilityHero3.setText("Ability:");
				lblSATxt3.setText(hero1.specialAbility);
			}

		}

	}
}
