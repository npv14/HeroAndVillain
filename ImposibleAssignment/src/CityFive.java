import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class CityFive {
	/**
	 * for easy to update all of the JButton and Panel created as variables of the class
	 */
	JButton buttonHeroPosition1, buttonHeroPosition2, buttonHeroPosition3, btnEast, btnMap;
	JPanel panel = new JPanel();
	JLabel lblTeam, lblTeamgold, lblGold, lblTeamName, lblHeroName1, lblHeroNameTxt1, lblTypeHero1, lblTypeHeroTxt1,
			lblHeroheal1, lblHeroHealTxt1, lblHeroName2, lblHeroNameTxt2, lblTypeHero2, lblTypeHeroTxt2, lblHeroheal2,
			lblHeroHealTxt2, lblHeroName3, lblHeroNameTxt3, lblTypeHero3, lblTypeHeroTxt3, lblHeroheal3,
			lblHeroHealTxt3, lblSpecialabilityHero1, lblSpecialabilityHero2, lblSpecialabilityHero3, lblSATxt1,
			lblSATxt2, lblSATxt3;

	private JFrame frmCity;

	private static GameEnvironment gameE;
	private JLabel label;
	
	/**constructor that get input of GameEnvironment and save is as local variable
	 * @param incomingGameE
	 */
    public CityFive(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		initialize();
		
	}
    /**this function is use for open window as an object of GameEnvironment.
	 * an call update function.
	 **/
    public void openWindow() {
    	update();
    	frmCity.setVisible(true);
	}
    /**
	 * set the window invisible
	 */
	public void closeWindow() {
		frmCity.setVisible(false);
	}
	/**
	 * this function call closeCityTwo from game Environment to close this window 
	 */
	public void finishedWindow() {
		gameE.closeCityFive(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmCity = new JFrame();
		frmCity.setResizable(false);
		frmCity.setTitle("City 5");
		frmCity.setBounds(100, 100, 1196, 813);
		frmCity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCity.setLocation(270, 100);
		frmCity.getContentPane().setLayout(null);

		JButton btnNorth = new JButton("North");
		btnNorth.setForeground(Color.WHITE);
		btnNorth.setOpaque(false);
		btnNorth.setContentAreaFilled(false);
		btnNorth.setBorderPainted(false);
		btnNorth.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will open city four  window and close the city five window
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameE.launchCityFour();
			}
		});
		btnNorth.setBounds(354, 0, 349, 38);
		frmCity.getContentPane().add(btnNorth);

		btnEast = new JButton("East");
		btnEast.setBorderPainted(false);
		btnEast.setContentAreaFilled(false);
		btnEast.setOpaque(false);
		btnEast.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will open boss lair window and close the city five window
			 * and save Previous Place as city five
			 */
			public void actionPerformed(ActionEvent e) {
				gameE.PreviousPlace = "CityFive";
				finishedWindow();
				gameE.launchBosslair();
			}
		});
		btnEast.setBounds(1123, 200, 71, 327);
		frmCity.getContentPane().add(btnEast);

		JButton btnSouth = new JButton("South");
		btnSouth.setOpaque(false);
		btnSouth.setContentAreaFilled(false);
		btnSouth.setBorderPainted(false);
		btnSouth.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button be clicked  it will open hospital window and close the city five window
			 * and save Previous Place as city five
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameE.PreviousPlace = "CityFive";
				gameE.launchHospital();
			}
		});
		btnSouth.setBounds(354, 749, 349, 38);
		frmCity.getContentPane().add(btnSouth);

		buttonHeroPosition1 = new JButton("");
		buttonHeroPosition1.setOpaque(false);
		buttonHeroPosition1.setContentAreaFilled(false);
		buttonHeroPosition1.setBorderPainted(false);
		buttonHeroPosition1.setBounds(227, 284, 161, 142);
		frmCity.getContentPane().add(buttonHeroPosition1);

		buttonHeroPosition2 = new JButton("");
		buttonHeroPosition2.setOpaque(false);
		buttonHeroPosition2.setContentAreaFilled(false);
		buttonHeroPosition2.setBorderPainted(false);
		buttonHeroPosition2.setBounds(455, 466, 161, 150);
		frmCity.getContentPane().add(buttonHeroPosition2);

		buttonHeroPosition3 = new JButton("");
		buttonHeroPosition3.setOpaque(false);
		buttonHeroPosition3.setContentAreaFilled(false);
		buttonHeroPosition3.setBorderPainted(false);
		buttonHeroPosition3.setBounds(651, 284, 170, 142);
		frmCity.getContentPane().add(buttonHeroPosition3);

		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(728, 539, 466, 248);
		frmCity.getContentPane().add(panel);
		panel.setLayout(null);

		lblTeam = new JLabel("Team:");
		lblTeam.setBounds(0, 0, 70, 15);
		panel.add(lblTeam);

		lblTeamgold = new JLabel("TeamGold:");
		lblTeamgold.setBounds(223, 0, 91, 15);
		panel.add(lblTeamgold);

		lblGold = new JLabel(gameE.Team.money.toString());
		lblGold.setBounds(326, 0, 92, 15);
		panel.add(lblGold);

		lblTeamName = new JLabel(gameE.Team.name);
		lblTeamName.setBounds(108, 0, 84, 15);
		panel.add(lblTeamName);

		lblHeroName1 = new JLabel("");
		lblHeroName1.setBounds(10, 37, 70, 15);
		panel.add(lblHeroName1);

		lblHeroNameTxt1 = new JLabel("");
		lblHeroNameTxt1.setBounds(92, 37, 70, 15);
		panel.add(lblHeroNameTxt1);

		lblTypeHero1 = new JLabel("");
		lblTypeHero1.setBounds(182, 37, 44, 15);
		panel.add(lblTypeHero1);

		lblTypeHeroTxt1 = new JLabel("");
		lblTypeHeroTxt1.setBounds(226, 37, 44, 15);
		panel.add(lblTypeHeroTxt1);

		lblHeroheal1 = new JLabel("");
		lblHeroheal1.setBounds(278, 37, 70, 15);
		panel.add(lblHeroheal1);

		lblHeroHealTxt1 = new JLabel("");
		lblHeroHealTxt1.setBounds(348, 37, 70, 15);
		panel.add(lblHeroHealTxt1);

		lblHeroName2 = new JLabel("");
		lblHeroName2.setBounds(10, 116, 70, 15);
		panel.add(lblHeroName2);

		lblHeroNameTxt2 = new JLabel("");
		lblHeroNameTxt2.setBounds(92, 116, 70, 15);
		panel.add(lblHeroNameTxt2);

		lblTypeHero2 = new JLabel("");
		lblTypeHero2.setBounds(182, 116, 44, 15);
		panel.add(lblTypeHero2);

		lblTypeHeroTxt2 = new JLabel("");
		lblTypeHeroTxt2.setBounds(226, 116, 44, 15);
		panel.add(lblTypeHeroTxt2);

		lblHeroheal2 = new JLabel("");
		lblHeroheal2.setBounds(278, 116, 70, 15);
		panel.add(lblHeroheal2);

		lblHeroHealTxt2 = new JLabel("");
		lblHeroHealTxt2.setBounds(348, 116, 70, 15);
		panel.add(lblHeroHealTxt2);

		lblHeroName3 = new JLabel("");
		lblHeroName3.setBounds(10, 184, 70, 15);
		panel.add(lblHeroName3);

		lblHeroNameTxt3 = new JLabel("");
		lblHeroNameTxt3.setBounds(92, 184, 70, 15);
		panel.add(lblHeroNameTxt3);

		lblTypeHero3 = new JLabel("");
		lblTypeHero3.setBounds(182, 184, 44, 15);
		panel.add(lblTypeHero3);

		lblTypeHeroTxt3 = new JLabel("");
		lblTypeHeroTxt3.setBounds(226, 184, 44, 15);
		panel.add(lblTypeHeroTxt3);

		lblHeroheal3 = new JLabel("");
		lblHeroheal3.setBounds(278, 184, 70, 15);
		panel.add(lblHeroheal3);

		lblHeroHealTxt3 = new JLabel("");
		lblHeroHealTxt3.setBounds(348, 184, 70, 15);
		panel.add(lblHeroHealTxt3);

		lblSpecialabilityHero1 = new JLabel("");
		lblSpecialabilityHero1.setBounds(0, 73, 70, 15);
		panel.add(lblSpecialabilityHero1);

		lblSpecialabilityHero2 = new JLabel("");
		lblSpecialabilityHero2.setBounds(0, 143, 70, 15);
		panel.add(lblSpecialabilityHero2);

		lblSpecialabilityHero3 = new JLabel("");
		lblSpecialabilityHero3.setBounds(0, 211, 70, 15);
		panel.add(lblSpecialabilityHero3);

		lblSATxt1 = new JLabel("");
		lblSATxt1.setBounds(92, 64, 393, 35);
		panel.add(lblSATxt1);

		lblSATxt2 = new JLabel("");
		lblSATxt2.setBounds(92, 137, 393, 35);
		panel.add(lblSATxt2);

		lblSATxt3 = new JLabel("");
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
			 *  If variable map in gameE is true then it will appear
			 * depend on the number of city it will show the map appropriate.
			 * and open the map window and save previous place as City five.
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
				gameE.PreviousPlace = "CityFive";
				frmCity.setVisible(false);
			}
		});
		btnMap.setBounds(1076, -18, 128, 128);
		frmCity.getContentPane().add(btnMap);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(CityFive.class.getResource("/img/middle3.png")));
		label.setBounds(423, 246, 210, 201);
		frmCity.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CityFive.class.getResource("/img/city5.png")));
		lblNewLabel.setBounds(0, 0, 1194, 787);
		frmCity.getContentPane().add(lblNewLabel);
		btnMap.setVisible(false);
	}
	/**that function update all the hero details when you enter game and also if the hero dead 
	 * all information related to this hero will be set as invisible or "" 
	 * 
	 */
	public void update() {
		if (gameE.Team.map == true) {
			btnMap.setVisible(true);
		}
		if (gameE.Team.map == false) {
			btnMap.setVisible(false);
		}
		if (gameE.progressCityFive) {
			btnEast.setVisible(false);
		}
		lblTeamName.setText(gameE.Team.name);
		lblGold.setText(gameE.Team.money.toString());
		if(gameE.Team.listOfHero.size() == 1) {
			buttonHeroPosition2.setVisible(false);;
			lblHeroName2.setText("");
			lblHeroNameTxt2.setText("");
			lblTypeHero2.setText("");
			lblTypeHeroTxt2.setText("");
			lblHeroheal2.setText("");
			lblHeroHealTxt2.setText("");
			lblSpecialabilityHero2.setText("");
			lblSATxt2.setText("");
			buttonHeroPosition3.setVisible(false);;
			lblHeroName3.setText("");
			lblHeroNameTxt3.setText("");
			lblTypeHero3.setText("");
			lblTypeHeroTxt3.setText("");
			lblHeroheal3.setText("");
			lblHeroHealTxt3.setText("");
			lblSpecialabilityHero3.setText("");
			lblSATxt3.setText("");}
		else if (gameE.Team.listOfHero.size() == 2) {
			buttonHeroPosition3.setVisible(false);;
			lblHeroName3.setText("");
			lblHeroNameTxt3.setText("");
			lblTypeHero3.setText("");
			lblTypeHeroTxt3.setText("");
			lblHeroheal3.setText("");
			lblHeroHealTxt3.setText("");
			lblSpecialabilityHero3.setText("");
			lblSATxt3.setText("");}
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
