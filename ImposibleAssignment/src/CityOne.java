import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class CityOne {
	/**
	 * for easy to update all of the JButton and Panel created as variables of the class
	 */
	JButton buttonHeroPosition1, buttonHeroPosition2, buttonHeroPosition3, btnSouth, btnMap, btnEast, btnWest;
	JPanel panel = new JPanel();
	JLabel lblTeam, lblTeamgold, lblGold, lblTeamName, lblHeroName1, lblHeroNameTxt1, lblTypeHero1, lblTypeHeroTxt1,
			lblHeroheal1, lblHeroHealTxt1, lblHeroName2, lblHeroNameTxt2, lblTypeHero2, lblTypeHeroTxt2, lblHeroheal2,
			lblHeroHealTxt2, lblHeroName3, lblHeroNameTxt3, lblTypeHero3, lblTypeHeroTxt3, lblHeroheal3,
			lblHeroHealTxt3, lblSpecialabilityHero1, lblSpecialabilityHero2, lblSpecialabilityHero3, lblSATxt1,
			lblSATxt2, lblSATxt3;

	private JFrame frmCityOne;

	private static GameEnvironment  gameE;
	private JLabel label;
	private JLabel lblImg;

	/**constructor that get input of GameEnvironment and save is as local variable
	 * @param incomingGameE
	 */
	public CityOne(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		initialize();
		
	}

	/**this function is use for open window as an object of GameEnvironment.
	 *Open the window and decide if number of city higher than 5 set button west visible.
	 * an call update function.
	 */
	public void openWindow() {
		if (gameE.numberOfCity > 5) {
			btnWest.setVisible(true);
		}

		frmCityOne.setVisible(true);
		update();
	}

	/**
	 * set the window invisible
	 */
	public void closeWindow() {
		frmCityOne.setVisible(false);
	}

	/**
	 * this function call closeCityOne from game Environment to close this window 
	 */
	public void finishedWindow() {
		gameE.closeCityOne(this);
	}

	/**create and set up all the label and text field and button
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmCityOne = new JFrame();
		frmCityOne.setResizable(false);
		frmCityOne.setTitle("City 1");
		frmCityOne.setBounds(100, 100, 1196, 813);
		frmCityOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCityOne.setLocation(270, 100);
		frmCityOne.getContentPane().setLayout(null);

		btnEast = new JButton("East");
		btnEast.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEast.setForeground(Color.WHITE);
		btnEast.setOpaque(false);
		btnEast.setContentAreaFilled(false);
		btnEast.setBorderPainted(false);
		btnEast.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will lead to boss lair and store previous place as city one and close the city one window
			 */
			public void actionPerformed(ActionEvent e) {
				gameE.PreviousPlace = "CityOne";
				finishedWindow();
				gameE.launchBosslair();
			}
		});

		btnEast.setBounds(1101, 200, 93, 327);
		frmCityOne.getContentPane().add(btnEast);

		btnSouth = new JButton("South");
		btnSouth.setFont(new Font("Dialog", Font.BOLD, 18));
		btnSouth.setForeground(Color.WHITE);
		btnSouth.setOpaque(false);
		btnSouth.setContentAreaFilled(false);
		btnSouth.setBorderPainted(false);
		btnSouth.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will lead to home base and close the city one window
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameE.launchHomebase();
			}
		});
		btnSouth.setBounds(355, 737, 349, 38);
		frmCityOne.getContentPane().add(btnSouth);

		btnWest = new JButton("West");
		btnWest.setFont(new Font("Dialog", Font.BOLD, 18));
		btnWest.setForeground(Color.WHITE);
		btnWest.setOpaque(false);
		btnWest.setContentAreaFilled(false);
		btnWest.setBorderPainted(false);

		btnWest.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 *   if this button be clicked  it will lead to city six and close the city one window
			 */
			public void actionPerformed(ActionEvent e) {
				
				finishedWindow();
				gameE.launchCitySix();
			}
		});
		btnWest.setBounds(0, 155, 101, 327);
		btnWest.setVisible(false);
		

		frmCityOne.getContentPane().add(btnWest);
	

		buttonHeroPosition1 = new JButton("");
		buttonHeroPosition1.setOpaque(false);
		buttonHeroPosition1.setContentAreaFilled(false);
		buttonHeroPosition1.setBorderPainted(false);
		buttonHeroPosition1.setBounds(271, 284, 161, 142);
		frmCityOne.getContentPane().add(buttonHeroPosition1);

		buttonHeroPosition2 = new JButton("");
		buttonHeroPosition2.setOpaque(false);
		buttonHeroPosition2.setContentAreaFilled(false);
		buttonHeroPosition2.setBorderPainted(false);
		buttonHeroPosition2.setBounds(484, 449, 161, 150);
		frmCityOne.getContentPane().add(buttonHeroPosition2);

		buttonHeroPosition3 = new JButton("");
		buttonHeroPosition3.setOpaque(false);
		buttonHeroPosition3.setContentAreaFilled(false);
		buttonHeroPosition3.setBorderPainted(false);
		buttonHeroPosition3.setBounds(714, 272, 170, 142);
		frmCityOne.getContentPane().add(buttonHeroPosition3);

		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(728, 539, 466, 248);
		frmCityOne.getContentPane().add(panel);
		panel.setLayout(null);

		lblTeam = new JLabel("Team:");
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setBounds(0, 0, 70, 15);
		panel.add(lblTeam);

		lblTeamgold = new JLabel("TeamGold:");
		lblTeamgold.setForeground(Color.WHITE);
		lblTeamgold.setBounds(223, 0, 91, 15);
		panel.add(lblTeamgold);

		lblGold = new JLabel(gameE.Team.money.toString());
		lblGold.setForeground(Color.WHITE);
		lblGold.setBounds(326, 0, 92, 15);
		panel.add(lblGold);

		lblTeamName = new JLabel(gameE.Team.name);
		lblTeamName.setForeground(Color.WHITE);
		lblTeamName.setBounds(108, 0, 84, 15);
		panel.add(lblTeamName);

		lblHeroName1 = new JLabel("");
		lblHeroName1.setForeground(Color.WHITE);
		lblHeroName1.setBounds(10, 37, 70, 15);
		panel.add(lblHeroName1);

		lblHeroNameTxt1 = new JLabel("");
		lblHeroNameTxt1.setForeground(Color.WHITE);
		lblHeroNameTxt1.setBounds(92, 37, 70, 15);
		panel.add(lblHeroNameTxt1);

		lblTypeHero1 = new JLabel("");
		lblTypeHero1.setForeground(Color.WHITE);
		lblTypeHero1.setBounds(182, 37, 44, 15);
		panel.add(lblTypeHero1);

		lblTypeHeroTxt1 = new JLabel("");
		lblTypeHeroTxt1.setForeground(Color.WHITE);
		lblTypeHeroTxt1.setBounds(226, 37, 44, 15);
		panel.add(lblTypeHeroTxt1);

		lblHeroheal1 = new JLabel("");
		lblHeroheal1.setForeground(Color.WHITE);
		lblHeroheal1.setBounds(278, 37, 70, 15);
		panel.add(lblHeroheal1);

		lblHeroHealTxt1 = new JLabel("");
		lblHeroHealTxt1.setForeground(Color.WHITE);
		lblHeroHealTxt1.setBounds(348, 37, 70, 15);
		panel.add(lblHeroHealTxt1);

		lblHeroName2 = new JLabel("");
		lblHeroName2.setForeground(Color.WHITE);
		lblHeroName2.setBounds(10, 116, 70, 15);
		panel.add(lblHeroName2);

		lblHeroNameTxt2 = new JLabel("");
		lblHeroNameTxt2.setForeground(Color.WHITE);
		lblHeroNameTxt2.setBounds(92, 116, 70, 15);
		panel.add(lblHeroNameTxt2);

		lblTypeHero2 = new JLabel("");
		lblTypeHero2.setForeground(Color.WHITE);
		lblTypeHero2.setBounds(182, 116, 44, 15);
		panel.add(lblTypeHero2);

		lblTypeHeroTxt2 = new JLabel("");
		lblTypeHeroTxt2.setForeground(Color.WHITE);
		lblTypeHeroTxt2.setBounds(226, 116, 44, 15);
		panel.add(lblTypeHeroTxt2);

		lblHeroheal2 = new JLabel("");
		lblHeroheal2.setForeground(Color.WHITE);
		lblHeroheal2.setBounds(278, 116, 70, 15);
		panel.add(lblHeroheal2);

		lblHeroHealTxt2 = new JLabel("");
		lblHeroHealTxt2.setForeground(Color.WHITE);
		lblHeroHealTxt2.setBounds(348, 116, 70, 15);
		panel.add(lblHeroHealTxt2);

		lblHeroName3 = new JLabel("");
		lblHeroName3.setForeground(Color.WHITE);
		lblHeroName3.setBounds(10, 184, 70, 15);
		panel.add(lblHeroName3);

		lblHeroNameTxt3 = new JLabel("");
		lblHeroNameTxt3.setForeground(Color.WHITE);
		lblHeroNameTxt3.setBounds(92, 184, 70, 15);
		panel.add(lblHeroNameTxt3);

		lblTypeHero3 = new JLabel("");
		lblTypeHero3.setForeground(Color.WHITE);
		lblTypeHero3.setBounds(182, 184, 44, 15);
		panel.add(lblTypeHero3);

		lblTypeHeroTxt3 = new JLabel("");
		lblTypeHeroTxt3.setForeground(Color.WHITE);
		lblTypeHeroTxt3.setBounds(226, 184, 44, 15);
		panel.add(lblTypeHeroTxt3);

		lblHeroheal3 = new JLabel("");
		lblHeroheal3.setForeground(Color.WHITE);
		lblHeroheal3.setBounds(278, 184, 70, 15);
		panel.add(lblHeroheal3);

		lblHeroHealTxt3 = new JLabel("");
		lblHeroHealTxt3.setForeground(Color.WHITE);
		lblHeroHealTxt3.setBounds(348, 184, 70, 15);
		panel.add(lblHeroHealTxt3);

		lblSpecialabilityHero1 = new JLabel("");
		lblSpecialabilityHero1.setForeground(Color.WHITE);
		lblSpecialabilityHero1.setBounds(0, 73, 70, 15);
		panel.add(lblSpecialabilityHero1);

		lblSpecialabilityHero2 = new JLabel("");
		lblSpecialabilityHero2.setForeground(Color.WHITE);
		lblSpecialabilityHero2.setBounds(0, 143, 70, 15);
		panel.add(lblSpecialabilityHero2);

		lblSpecialabilityHero3 = new JLabel("");
		lblSpecialabilityHero3.setForeground(Color.WHITE);
		lblSpecialabilityHero3.setBounds(0, 211, 70, 15);
		panel.add(lblSpecialabilityHero3);

		lblSATxt1 = new JLabel("");
		lblSATxt1.setForeground(Color.WHITE);
		lblSATxt1.setBounds(92, 64, 393, 35);
		panel.add(lblSATxt1);

		lblSATxt2 = new JLabel("");
		lblSATxt2.setForeground(Color.WHITE);
		lblSATxt2.setBounds(92, 137, 393, 35);
		panel.add(lblSATxt2);

		lblSATxt3 = new JLabel("");
		lblSATxt3.setForeground(Color.WHITE);
		lblSATxt3.setBounds(92, 201, 393, 35);
		panel.add(lblSATxt3);
		btnMap = new JButton("Map");
		btnMap.setOpaque(false);
		btnMap.setContentAreaFilled(false);
		btnMap.setBorderPainted(false);
		btnMap.setIcon(new ImageIcon(Homebase.class.getResource("/img/map.png")));
		btnMap.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * If variable map in gameE is true then it will appear
			 * depend on the number of city it will show the map appropriate.
			 * and open the map window and save previous place as City one .
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
				gameE.PreviousPlace = "CityOne";
				frmCityOne.setVisible(false);
			}
		});
		btnMap.setBounds(1076, -18, 128, 128);
		frmCityOne.getContentPane().add(btnMap);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(CityOne.class.getResource("/img/middle3.png")));
		label.setBounds(474, 236, 210, 201);
		frmCityOne.getContentPane().add(label);
		
		lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(CityOne.class.getResource("/img/city1.png")));
		lblImg.setBounds(-11, 0, 1193, 787);
		frmCityOne.getContentPane().add(lblImg);
		btnMap.setVisible(false);
	}

	/**
	 * that function update all the hero details when you enter game and also if the hero dead 
	 * all information related to this hero will be set as invisible or "" 
	 */
	public void update() {
		if (gameE.Team.map == true) {
			btnMap.setVisible(true);
		}
		if (gameE.Team.map == false) {
			btnMap.setVisible(false);}
		if (gameE.progressCityOne) {
			btnEast.setVisible(false);
		}
		lblGold.setText(gameE.Team.money.toString());
		lblTeamName.setText(gameE.Team.name);
		if (gameE.Team.listOfHero.size() == 1) {
			buttonHeroPosition2.setVisible(false);
			;
			lblHeroName2.setText("");
			lblHeroNameTxt2.setText("");
			lblTypeHero2.setText("");
			lblTypeHeroTxt2.setText("");
			lblHeroheal2.setText("");
			lblHeroHealTxt2.setText("");
			lblSpecialabilityHero2.setText("");
			lblSATxt2.setText("");
			buttonHeroPosition3.setVisible(false);
			;
			lblHeroName3.setText("");
			lblHeroNameTxt3.setText("");
			lblTypeHero3.setText("");
			lblTypeHeroTxt3.setText("");
			lblHeroheal3.setText("");
			lblHeroHealTxt3.setText("");
			lblSpecialabilityHero3.setText("");
			lblSATxt3.setText("");
		} else if (gameE.Team.listOfHero.size() == 2) {
			buttonHeroPosition3.setVisible(false);
			;
			lblHeroName3.setText("");
			lblHeroNameTxt3.setText("");
			lblTypeHero3.setText("");
			lblTypeHeroTxt3.setText("");
			lblHeroheal3.setText("");
			lblHeroHealTxt3.setText("");
			lblSpecialabilityHero3.setText("");
			lblSATxt3.setText("");
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

	
}}