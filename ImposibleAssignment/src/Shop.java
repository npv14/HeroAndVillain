import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

/**
 * @author npv14
 *
 */
public class Shop {
	
	boolean foundHeroType1 = false;
	private JFrame frmShop;
	Integer numberOfItem = 0;
	public static GameEnvironment gameE;
	PowerUps selectedPowerUp;
	HealingItems healingItemsSelected;
	JLabel lblName, lblType, lblSpecialAbility;

	/**constructor that get input of GameEnvironment and save is as local variable
	 * @param incomingGameE
	 * call find hero type one function 
	 * 
	 */
	public Shop(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		findHeroType1();
		initialize();
		frmShop.setVisible(true);
	}

	/**
	 * dispose this window
	 */
	public void closeWindow() {
		frmShop.dispose();
	}

	/**
	 * this function call closeShop from game Environment to close this window 
	 */
	public void finishedWindow() {
		gameE.closeShop(this);
	}

	/**that function is using for find hero type 1 in list of hero in team
	 * if hero type found then foundHeroType1 variable is true 
	 * 
	 */
	public void findHeroType1() {
		for (int i = 0; i < gameE.Team.listOfHero.size(); i++) {
			Heroes hero = gameE.Team.listOfHero.get(i);
			if (hero.type == 1) {
				foundHeroType1 = true;
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShop = new JFrame();
		frmShop.setResizable(false);
		frmShop.setTitle("Shop");
		frmShop.setBounds(100, 100, 1196, 813);
		frmShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShop.setLocation(270, 100);
		frmShop.getContentPane().setLayout(null);

		JLabel lblShop = new JLabel("Shop");
		lblShop.setForeground(Color.WHITE);
		lblShop.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 49));
		lblShop.setBounds(534, 12, 150, 80);
		frmShop.getContentPane().add(lblShop);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.setBounds(310, 129, 562, 197);
		frmShop.getContentPane().add(panel);

		JLabel labelName = new JLabel("There are some power ups/healing items with different special ability ");
		labelName.setForeground(Color.WHITE);
		labelName.setBounds(12, 12, 525, 15);
		panel.add(labelName);

		JLabel labelType = new JLabel("type:");
		labelType.setForeground(Color.WHITE);
		labelType.setBounds(149, 39, 45, 15);
		panel.add(labelType);

		JLabel lblSpecialAbilityOf = new JLabel("Description:");
		lblSpecialAbilityOf.setForeground(Color.WHITE);
		lblSpecialAbilityOf.setBounds(12, 70, 92, 15);
		panel.add(lblSpecialAbilityOf);

		JLabel TypeText = new JLabel("");
		TypeText.setForeground(Color.WHITE);
		TypeText.setBounds(240, 39, 70, 15);
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

		JLabel lblPowerUpHealing = new JLabel("Power up/ Healing");
		lblPowerUpHealing.setForeground(Color.WHITE);
		lblPowerUpHealing.setBounds(12, 39, 141, 15);
		panel.add(lblPowerUpHealing);

		JLabel lblQuantityNeed = new JLabel("Quantity need:");
		lblQuantityNeed.setForeground(Color.WHITE);
		lblQuantityNeed.setBounds(367, 139, 111, 15);
		panel.add(lblQuantityNeed);

		JLabel lblTeamgold = new JLabel("TeamGold:");
		lblTeamgold.setForeground(Color.WHITE);
		lblTeamgold.setBounds(12, 170, 92, 15);
		panel.add(lblTeamgold);

		JLabel lblTeamgoldshow = new JLabel(gameE.Team.money.toString());
		lblTeamgoldshow.setForeground(Color.WHITE);
		lblTeamgoldshow.setBackground(Color.WHITE);
		lblTeamgoldshow.setBounds(98, 170, 84, 15);
		panel.add(lblTeamgoldshow);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBackground(Color.BLACK);
		lblPrice.setBounds(377, 170, 45, 15);
		panel.add(lblPrice);

		JLabel lblGoldneedtext = new JLabel("");
		lblGoldneedtext.setForeground(Color.WHITE);
		lblGoldneedtext.setBounds(421, 170, 56, 15);
		panel.add(lblGoldneedtext);

		JComboBox comboBox = new JComboBox();
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
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer allprice = 0;
				numberOfItem = (Integer) comboBox.getSelectedItem();
				if (lblPowerUpHealing.getText() == "Power up") {
					allprice = numberOfItem * selectedPowerUp.price;
					lblGoldneedtext.setText(allprice.toString());
				} else if (lblPowerUpHealing.getText() == "Healing item") {
					allprice = numberOfItem * healingItemsSelected.price;
					lblGoldneedtext.setText(allprice.toString());
				}

			}
		});
		comboBox.setBounds(478, 134, 45, 24);
		panel.add(comboBox);

		JButton btnHeal1 = new JButton("");
		btnHeal1.setOpaque(false);
		btnHeal1.setContentAreaFilled(false);
		btnHeal1.setBorderPainted(false);
		btnHeal1.setIcon(new ImageIcon(Shop.class.getResource("/img/potionRed.png")));
		btnHeal1.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if click this button will set the price the details of healing type 1 the price, number of healing type 1 in inventory 
			 */
			public void actionPerformed(ActionEvent e) {
				labelName.setVisible(true);
				labelType.setVisible(true);
				TypeText.setVisible(true);
				lblNumberOfPowerUp.setVisible(true);
				lblAmount.setVisible(true);
				healingItemsSelected = gameE.HealingItems1;
				numberOfItem = (Integer) comboBox.getSelectedItem();
				Integer price = 0;
				price = numberOfItem * healingItemsSelected.price;

				Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems1);
				TypeText.setText("1");
				lblPowerUpHealing.setText("Healing item");
				lblNumberOfPowerUp.setText(amount.toString());
				labelSpecialText.setText("This power help hero increment 2 heal per second duration 10s");
				panel.setVisible(true);
				lblGoldneedtext.setText((price.toString()));
			}
		});
		btnHeal1.setBounds(128, 555, 128, 128);
		frmShop.getContentPane().add(btnHeal1);

		JButton btnHeal2 = new JButton("");
		btnHeal2.setOpaque(false);
		btnHeal2.setContentAreaFilled(false);
		btnHeal2.setBorderPainted(false);
		btnHeal2.setIcon(new ImageIcon(Shop.class.getResource("/img/potionGreen.png")));
		btnHeal2.setBounds(460, 563, 128, 128);
		btnHeal2.addActionListener(new ActionListener() {
			/*
			 * (non-Javadoc)
			 * * if click this button will set the price the details of healing type 2 the price, number of healing type 2 in inventory 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent e) {
				labelName.setVisible(true);
				labelType.setVisible(true);
				TypeText.setVisible(true);
				lblNumberOfPowerUp.setVisible(true);
				lblAmount.setVisible(true);
				healingItemsSelected = gameE.HealingItems2;
				numberOfItem = (Integer) comboBox.getSelectedItem();
				Integer price = 0;
				price = numberOfItem * healingItemsSelected.price;
				Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems2);
				TypeText.setText("2");
				lblPowerUpHealing.setText("Healing item");
				lblNumberOfPowerUp.setText(amount.toString());
				labelSpecialText.setText("This power help hero increment 5 heal per second duration 10s");
				panel.setVisible(true);
				lblGoldneedtext.setText((price.toString()));
			}
		});
		frmShop.getContentPane().add(btnHeal2);

		JButton btnHeal3 = new JButton("");
		btnHeal3.setOpaque(false);
		btnHeal3.setContentAreaFilled(false);
		btnHeal3.setBorderPainted(false);
		btnHeal3.setIcon(new ImageIcon(Shop.class.getResource("/img/potionBlue.png")));
		btnHeal3.setBounds(783, 563, 128, 128);
		btnHeal3.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if click this button will set the price the details of healing type 3 the price, number of healing type 3 in inventory 
			 */
			public void actionPerformed(ActionEvent e) {
				labelName.setVisible(true);
				labelType.setVisible(true);
				lblAmount.setVisible(true);
				TypeText.setVisible(true);
				lblNumberOfPowerUp.setVisible(true);
				healingItemsSelected = gameE.HealingItems3;
				numberOfItem = (Integer) comboBox.getSelectedItem();
				Integer price = 0;
				price = numberOfItem * healingItemsSelected.price;

				Integer amount = Collections.frequency(gameE.Team.listOfHealing, gameE.HealingItems3);
				TypeText.setText("3");
				lblPowerUpHealing.setText("Healing item");
				lblNumberOfPowerUp.setText(amount.toString());
				labelSpecialText.setText("This power help hero increment 7 heal per second duration 10s");
				panel.setVisible(true);
				lblGoldneedtext.setText((price.toString()));
			}
		});
		frmShop.getContentPane().add(btnHeal3);

		JButton btnBuy = new JButton("Buy");
		btnBuy.setFont(new Font("Dialog", Font.BOLD, 19));
		btnBuy.setForeground(Color.RED);
		btnBuy.setOpaque(false);
		btnBuy.setContentAreaFilled(false);
		btnBuy.setBorderPainted(false);
		btnBuy.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * if no item is chosen the will pop the message show please select the item
			 * if the is selected is the power up then ask if the hero type 1 which is have ability to reduce the price when buying item
			 * then it will get discount of 50%
			 * if team does not have enough gold then show the message display team does not have enough money
			 * if team have enough money then team money will reduce by the cost time quality of the item 
			 * then add the item into list of item using for loop to add into the list and update the labels in panel
			 * it will happen the same as healing item and map  
			 */
			public void actionPerformed(ActionEvent e) {
				numberOfItem = (Integer) comboBox.getSelectedItem();
				if (lblGoldneedtext.getText() == "") {
					JOptionPane.showMessageDialog(null, "Please selected item you want to buy");
				} else if (lblPowerUpHealing.getText() == "Power up") {
					if (foundHeroType1 == true) {
						JOptionPane.showMessageDialog(null, "you will get 50% discount because hero type 1 in team ");
						if (gameE.Team.money < numberOfItem * selectedPowerUp.price * 50 / 100) {
							JOptionPane.showMessageDialog(null, "You do not have enough money");
						} else {
							gameE.Team.money -= (selectedPowerUp.price * numberOfItem * 50 / 100);
							numberOfItem += Collections.frequency(gameE.Team.listOfPowerUps, selectedPowerUp);
							lblNumberOfPowerUp.setText((numberOfItem).toString());
							lblTeamgoldshow.setText(gameE.Team.money.toString());
							for (int i = 0; i < (Integer) comboBox.getSelectedItem(); i++) {
								gameE.Team.listOfPowerUps.add(selectedPowerUp);
							}
						}
					}

					else if (gameE.Team.money < numberOfItem * selectedPowerUp.price) {
						JOptionPane.showMessageDialog(null, "You do not have enough money");
					} else {

						gameE.Team.money -= selectedPowerUp.price * numberOfItem;
						numberOfItem += Collections.frequency(gameE.Team.listOfPowerUps, selectedPowerUp);
						lblNumberOfPowerUp.setText((numberOfItem).toString());
						lblTeamgoldshow.setText(gameE.Team.money.toString());
						for (int i = 0; i < (Integer) comboBox.getSelectedItem(); i++) {
							gameE.Team.listOfPowerUps.add(selectedPowerUp);
						}
					}
				} else if (lblPowerUpHealing.getText() == "This is the map") {
					if (gameE.Team.map == true) {
						JOptionPane.showMessageDialog(null, "You already got map or hero type 4 in team");
					} else if (gameE.Team.money < 300) {
						JOptionPane.showMessageDialog(null, "You do not have enough money");
					}

					else {
						gameE.Team.money -= 300;
						gameE.Team.map = true;
						lblTeamgoldshow.setText(gameE.Team.money.toString());

					}
				}

				else {
					if (foundHeroType1 == true) {
						JOptionPane.showMessageDialog(null, "you will get 50% discount because hero type 1 in team ");
						if (gameE.Team.money < numberOfItem * healingItemsSelected.price * 50 / 100) {
							JOptionPane.showMessageDialog(null, "You do not have enough money");
						} else {
							gameE.Team.money -= (healingItemsSelected.price * numberOfItem * 50 / 100);
							numberOfItem += Collections.frequency(gameE.Team.listOfHealing, healingItemsSelected);
							lblNumberOfPowerUp.setText((numberOfItem).toString());
							lblTeamgoldshow.setText(gameE.Team.money.toString());
							for (int i = 0; i < (Integer) comboBox.getSelectedItem(); i++) {
								gameE.Team.listOfHealing.add(healingItemsSelected);
							}
						}
					}

					else if (gameE.Team.money < numberOfItem * healingItemsSelected.price) {
						JOptionPane.showMessageDialog(null, "You do not have enough money");
					} else {
						gameE.Team.money -= healingItemsSelected.price * numberOfItem;
						numberOfItem += Collections.frequency(gameE.Team.listOfHealing, healingItemsSelected);
						lblNumberOfPowerUp.setText((numberOfItem).toString());
						lblTeamgoldshow.setText(gameE.Team.money.toString());
						for (int i = 0; i < (Integer) comboBox.getSelectedItem(); i++) {
							gameE.Team.listOfHealing.add(healingItemsSelected);
						}
					}

				}
			}

		});
		btnBuy.setBounds(513, 705, 117, 25);
		frmShop.getContentPane().add(btnBuy);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.GREEN);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setOpaque(false);
		btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gameE.launchPreviousPlace();
				finishedWindow();
			}
		});
		btnExit.setBounds(1048, 750, 117, 25);
		frmShop.getContentPane().add(btnExit);
		JButton btnType1 = new JButton("");
		btnType1.setIcon(new ImageIcon(PowerUpDen.class.getResource("/img/PowerUp1.png")));
		btnType1.setOpaque(false);
		btnType1.setContentAreaFilled(false);
		btnType1.setBorderPainted(false);
		btnType1.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if click this button will set the price the details of power up type 1 , the price, number of power up type 1 in inventory 
			 */
			public void actionPerformed(ActionEvent e) {
				labelName.setVisible(true);
				labelType.setVisible(true);
				lblAmount.setVisible(true);
				TypeText.setVisible(true);
				lblNumberOfPowerUp.setVisible(true);
				selectedPowerUp = gameE.power1;
				Integer numberselected = (Integer) comboBox.getSelectedItem();
				Integer price;
				price = numberselected * selectedPowerUp.price;
				Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power1);
				lblPowerUpHealing.setText("Power up");

				TypeText.setText("1");
				labelSpecialText.setText("This power help hero only get 4, 5, 6 at Dice Roll game");
				lblNumberOfPowerUp.setText(amount.toString());
				panel.setVisible(true);
				lblGoldneedtext.setText(price.toString());
			}
		});
		btnType1.setBounds(106, 386, 184, 110);
		frmShop.getContentPane().add(btnType1);

		JButton btnType2 = new JButton("");
		btnType2.setIcon(new ImageIcon(PowerUpDen.class.getResource("/img/PowerUp2.png")));
		btnType2.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if click this button will set the price the details of power up type 2 , the price, number of power up type 2 in inventory 
			 */
			public void actionPerformed(ActionEvent e) {
				labelName.setVisible(true);
				labelType.setVisible(true);
				lblAmount.setVisible(true);
				TypeText.setVisible(true);
				lblNumberOfPowerUp.setVisible(true);
				selectedPowerUp = gameE.power2;
				numberOfItem = (Integer) comboBox.getSelectedItem();
				Integer price = 0;
				price = numberOfItem * selectedPowerUp.price;

				Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power2);
				TypeText.setText("2");
				lblPowerUpHealing.setText("Power up");
				lblNumberOfPowerUp.setText(amount.toString());
				labelSpecialText.setText("This power help hero know future at Guess game");
				panel.setVisible(true);
				lblGoldneedtext.setText((price.toString()));

			}
		});
		btnType2.setBounds(428, 386, 184, 110);
		btnType2.setOpaque(false);
		btnType2.setContentAreaFilled(false);
		btnType2.setBorderPainted(false);
		frmShop.getContentPane().add(btnType2);

		JButton btnType3 = new JButton("");
		btnType3.setIcon(new ImageIcon(PowerUpDen.class.getResource("/img/PowerUp3.png")));
		btnType3.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if click this button will set the price the details of power up type 3, the price, number of power up type 3 in inventory 
			 */
			public void actionPerformed(ActionEvent e) {
				TypeText.setVisible(true);
				lblNumberOfPowerUp.setVisible(true);
				labelName.setVisible(true);
				labelType.setVisible(true);
				lblAmount.setVisible(true);
				selectedPowerUp = gameE.power3;
				Integer numberselected = (Integer) comboBox.getSelectedItem();
				Integer price;
				price = selectedPowerUp.price * numberselected;
				Integer amount = Collections.frequency(gameE.Team.listOfPowerUps, gameE.power3);
				lblPowerUpHealing.setText("Power up");
				lblNumberOfPowerUp.setText(amount.toString());
				TypeText.setText("3");

				labelSpecialText.setText("This power help hero knowing future result of Paper Scissor Rock");
				panel.setVisible(true);
				lblGoldneedtext.setText(price.toString());

			}
		});
		btnType3.setBounds(756, 375, 184, 121);
		btnType3.setOpaque(false);
		btnType3.setContentAreaFilled(false);
		btnType3.setBorderPainted(false);
		frmShop.getContentPane().add(btnType3);

		JButton btnMap = new JButton("Map");
		btnMap.setOpaque(false);
		btnMap.setContentAreaFilled(false);
		btnMap.setBorderPainted(false);
		btnMap.setIcon(new ImageIcon(Shop.class.getResource("/img/map.png")));
		btnMap.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * * if click this button will set the price the details of map , the price 
			 */
			public void actionPerformed(ActionEvent e) {
				lblPowerUpHealing.setText("This is the map");
				TypeText.setVisible(false);
				lblNumberOfPowerUp.setVisible(false);
				labelName.setVisible(false);
				labelType.setVisible(false);
				lblAmount.setVisible(false);
				labelSpecialText.setText("This will show map of the game!");
				lblGoldneedtext.setText("300");

			}
		});
		btnMap.setBounds(1014, 563, 128, 128);
		frmShop.getContentPane().add(btnMap);
		
		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(Shop.class.getResource("/img/shop.png")));
		lblImg.setBounds(0, 0, 1194, 787);
		frmShop.getContentPane().add(lblImg);
	}
}
