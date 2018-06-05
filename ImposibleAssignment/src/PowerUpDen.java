import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;

import org.hamcrest.core.Is;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.FlatteningPathIterator;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PowerUpDen {
	Heroes hero1, hero2, hero3, heroSelected;
	private JFrame frmPowerUpDen;
	JLabel lblName, lblType, lblSpecialAbility;
	public static GameEnvironment gameE;

	/**constructor that get input of GameEnvironment and save is as local variable
	 * @param incomingGameE
	 */
	public PowerUpDen(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		initialize();
		frmPowerUpDen.setVisible(true);
	}

	/**this funtion close window of power up den 
	 * 
	 */
	public void closeWindow() {
		frmPowerUpDen.dispose();
	}
	/**
	 * this function call closePowerUpDen from game Environment to close this window 
	 */
	public void finishedWindow() {
		gameE.closePowerUpDen(this);
	}

	/**this function be call when hero used power up that will change the name and power up of hero. 
	 * 
	 */
	public void update() {
		lblName.setText(heroSelected.name);
		lblType.setText(heroSelected.type.toString());
		lblSpecialAbility.setText(heroSelected.powerUpsHero.details);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPowerUpDen = new JFrame();
		frmPowerUpDen.setResizable(false);
		frmPowerUpDen.setTitle("Power Up Den");
		frmPowerUpDen.setBounds(100, 100, 1196, 813);
		frmPowerUpDen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPowerUpDen.getContentPane().setLayout(null);
		frmPowerUpDen.setLocation(270, 100);

		JLabel lblShop = new JLabel("Power Up Den");
		lblShop.setForeground(Color.WHITE);
		lblShop.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 49));
		lblShop.setBounds(435, 12, 421, 80);
		frmPowerUpDen.getContentPane().add(lblShop);

		JLabel lblShopKeeper = new JLabel("");
		lblShopKeeper.setIcon(new ImageIcon(PowerUpDen.class.getResource("/img/girl-2-preview.gif")));
		lblShopKeeper.setBounds(443, 197, 200, 194);
		frmPowerUpDen.getContentPane().add(lblShopKeeper);

		JLabel lblWelcome = new JLabel("Welcome to Power Up Den");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblWelcome.setBounds(78, 91, 389, 177);
		frmPowerUpDen.getContentPane().add(lblWelcome);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setBounds(620, 128, 562, 165);
		frmPowerUpDen.getContentPane().add(panel);
		panel.setVisible(false);

		JLabel labelName = new JLabel("There are some power-ups with different special ability ");
		labelName.setForeground(Color.WHITE);
		labelName.setBounds(12, 12, 408, 15);
		panel.add(labelName);

		JLabel labelType = new JLabel("Power up type:");
		labelType.setForeground(Color.WHITE);
		labelType.setBounds(12, 39, 113, 15);
		panel.add(labelType);

		JLabel lblSpecialAbilityOf = new JLabel("Which special ability of power up is:");
		lblSpecialAbilityOf.setForeground(Color.WHITE);
		lblSpecialAbilityOf.setBounds(12, 70, 310, 15);
		panel.add(lblSpecialAbilityOf);

		JLabel TypeText = new JLabel("");
		TypeText.setForeground(Color.WHITE);
		TypeText.setBounds(131, 39, 70, 15);
		panel.add(TypeText);

		JLabel labelSpecialText = new JLabel("");
		labelSpecialText.setForeground(Color.WHITE);
		labelSpecialText.setBounds(12, 89, 541, 38);
		panel.add(labelSpecialText);

		JLabel lblAmount = new JLabel("Amount in the inventory:");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setBounds(12, 139, 201, 15);
		panel.add(lblAmount);

		JLabel lblNumberOfPowerUp = new JLabel("");
		lblNumberOfPowerUp.setForeground(Color.WHITE);
		lblNumberOfPowerUp.setBounds(252, 139, 70, 15);
		panel.add(lblNumberOfPowerUp);

		JButton btnType1 = new JButton("");
		btnType1.setIcon(new ImageIcon(PowerUpDen.class.getResource("/img/PowerUp1.png")));
		btnType1.setOpaque(false);
		btnType1.setContentAreaFilled(false);
		btnType1.setBorderPainted(false);
		btnType1.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked it will set the text of some some labels in the panel to show the detail and type of the
			 * power up type 1 
			 */
			public void actionPerformed(ActionEvent e) {
				Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power1);
				TypeText.setText("1");
				labelSpecialText.setText("This power help hero only get 4, 5, 6 at Dice Roll game");
				lblNumberOfPowerUp.setText(amount.toString());
				panel.setVisible(true);
				lblWelcome.setVisible(false);
			}
		});
		btnType1.setBounds(125, 412, 184, 110);
		frmPowerUpDen.getContentPane().add(btnType1);

		JButton btnType2 = new JButton("");
		btnType2.setIcon(new ImageIcon(PowerUpDen.class.getResource("/img/PowerUp2.png")));
		btnType2.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if this button is clicked it will set the text of some some labels in the panel to show the detail and type of the
			 * power up type 2 
			 */
			public void actionPerformed(ActionEvent e) {
				Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power2);
				TypeText.setText("2");
				lblNumberOfPowerUp.setText(amount.toString());
				labelSpecialText.setText("This power help hero know future at Guess game");
				panel.setVisible(true);
				lblWelcome.setVisible(false);
			}
		});
		btnType2.setBounds(504, 412, 184, 110);
		btnType2.setOpaque(false);
		btnType2.setContentAreaFilled(false);
		btnType2.setBorderPainted(false);
		frmPowerUpDen.getContentPane().add(btnType2);

		JButton btnType3 = new JButton("");
		btnType3.setIcon(new ImageIcon(PowerUpDen.class.getResource("/img/PowerUp3.png")));
		btnType3.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if this button is clicked it will set the text of some some labels in the panel to show the detail and type of the
			 * power up type 3
			 */
			public void actionPerformed(ActionEvent e) {
				Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power3);
				lblNumberOfPowerUp.setText(amount.toString());
				TypeText.setText("3");
				labelSpecialText.setText("This power help hero knowing future result of Paper Scissor Rock");
				panel.setVisible(true);
				lblWelcome.setVisible(false);

			}
		});
		btnType3.setBounds(910, 412, 184, 121);
		btnType3.setOpaque(false);
		btnType3.setContentAreaFilled(false);
		btnType3.setBorderPainted(false);
		frmPowerUpDen.getContentPane().add(btnType3);

		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Dialog", Font.BOLD, 22));
		btnApply.setForeground(Color.RED);
		btnApply.setOpaque(false);
		btnApply.setContentAreaFilled(false);
		btnApply.setBorderPainted(false);
		btnApply.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if player haven't chose hero, power up or no power up in inventory and this button is clicked then it will show some message dialog
			 * else power up will be apply to hero and remove from power up list in Team. and update information show in panel 
			 */
			public void actionPerformed(ActionEvent e) {
				if (TypeText.getText() == "") {
					JOptionPane.showMessageDialog(null, "Choose Power Up to apply!");
				} else if (heroSelected == null) {
					JOptionPane.showMessageDialog(null, "Choose hero to apply!");
				} else if (heroSelected.type == 2) {
					JOptionPane.showMessageDialog(null, "This hero has all of those power ups");
				} else if (lblNumberOfPowerUp.getText().equals("0")) {
					JOptionPane.showMessageDialog(null, "There is no power ups to use");
				} else if (TypeText.getText() == "1") {
					gameE.Team.listOfPowerUps.remove(gameE.power1);
					heroSelected.powerUpsHero = new PowerUps(1);
					Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power1);
					lblNumberOfPowerUp.setText(amount.toString());
					update();
				} else if (TypeText.getText() == "2") {
					gameE.Team.listOfPowerUps.remove(gameE.power2);
					heroSelected.powerUpsHero = new PowerUps(2);
					Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power2);
					lblNumberOfPowerUp.setText(amount.toString());
					update();
				} else if (TypeText.getText() == "3") {
					gameE.Team.listOfPowerUps.remove(gameE.power3);
					heroSelected.powerUpsHero = new PowerUps(3);
					Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power3);
					lblNumberOfPowerUp.setText(amount.toString());
					update();
				}
			}
		});
		btnApply.setBounds(918, 563, 176, 50);
		frmPowerUpDen.getContentPane().add(btnApply);

		JPanel panelHeroDisplay = new JPanel();
		panelHeroDisplay.setOpaque(false);
		panelHeroDisplay.setLayout(null);
		panelHeroDisplay.setBounds(810, 660, 384, 127);
		frmPowerUpDen.getContentPane().add(panelHeroDisplay);

		JLabel lblNameTxt = new JLabel("Name:");
		lblNameTxt.setForeground(Color.WHITE);
		lblNameTxt.setBounds(12, 12, 82, 15);
		panelHeroDisplay.add(lblNameTxt);

		JLabel lblTypeTxt = new JLabel("Type:");
		lblTypeTxt.setForeground(Color.WHITE);
		lblTypeTxt.setBounds(12, 39, 70, 15);
		panelHeroDisplay.add(lblTypeTxt);

		JLabel lblSpecialAbilityTxt = new JLabel("Power Up:");
		lblSpecialAbilityTxt.setForeground(Color.WHITE);
		lblSpecialAbilityTxt.setBounds(12, 66, 111, 15);
		panelHeroDisplay.add(lblSpecialAbilityTxt);

		lblName = new JLabel("");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(139, 12, 144, 15);
		panelHeroDisplay.add(lblName);

		lblType = new JLabel("");
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(139, 39, 70, 15);
		panelHeroDisplay.add(lblType);

		lblSpecialAbility = new JLabel("");
		lblSpecialAbility.setForeground(Color.WHITE);
		lblSpecialAbility.setBounds(12, 77, 359, 26);
		panelHeroDisplay.add(lblSpecialAbility);

		JLabel lblSelectAHero = new JLabel("Select a hero to Apply: ");
		lblSelectAHero.setForeground(Color.WHITE);
		lblSelectAHero.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblSelectAHero.setBounds(12, 534, 242, 24);
		frmPowerUpDen.getContentPane().add(lblSelectAHero);
		JButton buttonHeroPosition1 = new JButton("");
		buttonHeroPosition1.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then it will show hero 1 details in panel hero display
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero1;
				lblName.setText(hero1.name);
				lblType.setText(hero1.type.toString());
				lblSpecialAbility.setText(hero1.powerUpsHero.details);
			}

		});
		buttonHeroPosition1.setOpaque(false);
		buttonHeroPosition1.setContentAreaFilled(false);
		buttonHeroPosition1.setBorderPainted(false);
		buttonHeroPosition1.setBounds(61, 597, 161, 153);
		buttonHeroPosition1.setVisible(false);
		frmPowerUpDen.getContentPane().add(buttonHeroPosition1);

		JButton buttonHeroPosition2 = new JButton("");
		buttonHeroPosition2.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then it will show hero 2 details in panel hero display
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero2;
				lblName.setText(hero2.name);
				lblType.setText(hero2.type.toString());
				lblSpecialAbility.setText(hero2.powerUpsHero.details);
			}

		});
		buttonHeroPosition2.setOpaque(false);
		buttonHeroPosition2.setContentAreaFilled(false);
		buttonHeroPosition2.setVisible(false);
		buttonHeroPosition2.setBorderPainted(false);
		buttonHeroPosition2.setBounds(286, 597, 170, 153);
		frmPowerUpDen.getContentPane().add(buttonHeroPosition2);
		JButton buttonHeroPosition3 = new JButton("");
		buttonHeroPosition3.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then it will show hero 3 details in panel hero display
			 */
			public void actionPerformed(ActionEvent e) {
				heroSelected = hero3;
				lblName.setText(hero3.name);
				lblType.setText(hero3.type.toString());
				lblSpecialAbility.setText(hero3.powerUpsHero.details);
			}

		});
		buttonHeroPosition3.setOpaque(false);
		buttonHeroPosition3.setContentAreaFilled(false);
		buttonHeroPosition3.setVisible(false);
		buttonHeroPosition3.setBorderPainted(false);
		buttonHeroPosition3.setBounds(545, 597, 170, 153);
		frmPowerUpDen.getContentPane().add(buttonHeroPosition3);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.GREEN);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if this button is clicked then it will close the window then run launch previous place. 
			 * from  game environment 
			 */
			public void actionPerformed(ActionEvent e) {
				gameE.launchPreviousPlace();
				finishedWindow();
			}
		});
		btnExit.setBounds(952, 625, 117, 25);
		frmPowerUpDen.getContentPane().add(btnExit);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setIcon(new ImageIcon(PowerUpDen.class.getResource("/img/powerupden.png")));
		lblImage.setBounds(0, 0, 1194, 787);
		frmPowerUpDen.getContentPane().add(lblImage);
/**
 * this for loop is using for update image of hero when the screen be created
 *  set image of all hero in list of hero.
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
