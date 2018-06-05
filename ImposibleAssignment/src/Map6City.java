

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Map6City {

	private JFrame frmMapcity;

	public static GameEnvironment gameE;
	/**constructor that get input of GameEnvironment and save is as local variable
	 * @param incomingGameE
	 */
	public Map6City(GameEnvironment incomingGameE) {
		gameE = incomingGameE;
		initialize();
		frmMapcity.setVisible(true);
	}
	/**this call makes this window dispose
	 * 
	 */
	public void closeWindow() {
		frmMapcity.dispose();
	}
	/**
	 * this function call closeMap6City from game Environment to close this window 
	 */
	public void finishedWindow() {
		gameE.closeMap6City(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() {
		
		frmMapcity = new JFrame();
		frmMapcity.setTitle("Map6city");
		frmMapcity.setBounds(100, 100, 1196, 813);
		frmMapcity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMapcity.setLocation(270, 100);
		frmMapcity.getContentPane().setLayout(null);
		
		JLabel lblNesw = new JLabel("NESW");
		lblNesw.setIcon(new ImageIcon(Map5City.class.getResource("/img/NESW.png")));
		lblNesw.setBounds(1084, 0, 98, 98);
		frmMapcity.getContentPane().add(lblNesw);
		
		JLabel lblHomebase = new JLabel("HomeBase");
		lblHomebase.setForeground(Color.RED);
		lblHomebase.setFont(new Font("Dialog", Font.BOLD, 19));
		lblHomebase.setBounds(549, 327, 126, 57);
		frmMapcity.getContentPane().add(lblHomebase);
		
		JLabel lblCityTwo = new JLabel("CityTwo");
		lblCityTwo.setForeground(Color.RED);
		lblCityTwo.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCityTwo.setBounds(825, 337, 86, 36);
		frmMapcity.getContentPane().add(lblCityTwo);
		
		JLabel lblCityThree = new JLabel("CityThree");
		lblCityThree.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCityThree.setForeground(Color.RED);
		lblCityThree.setBounds(325, 337, 111, 36);
		frmMapcity.getContentPane().add(lblCityThree);
		
		JLabel lblCityOne = new JLabel("CityOne");
		lblCityOne.setForeground(Color.RED);
		lblCityOne.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCityOne.setBounds(549, 200, 87, 30);
		frmMapcity.getContentPane().add(lblCityOne);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setForeground(Color.WHITE);
		lblShop.setBounds(923, 348, 70, 15);
		frmMapcity.getContentPane().add(lblShop);
		
		JLabel lblPowerUpDen = new JLabel("Power Up Den");
		lblPowerUpDen.setForeground(Color.WHITE);
		lblPowerUpDen.setBounds(824, 393, 111, 15);
		frmMapcity.getContentPane().add(lblPowerUpDen);
		
		JLabel lblBossLair = new JLabel("Boss Lair");
		lblBossLair.setForeground(Color.WHITE);
		lblBossLair.setBounds(821, 308, 87, 15);
		frmMapcity.getContentPane().add(lblBossLair);
		
		JLabel label = new JLabel("Boss Lair");
		label.setForeground(Color.WHITE);
		label.setBounds(655, 210, 87, 15);
		frmMapcity.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Boss Lair");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(226, 348, 87, 15);
		frmMapcity.getContentPane().add(label_1);
		
		JLabel lblHospital = new JLabel("Hospital");
		lblHospital.setForeground(Color.WHITE);
		lblHospital.setBackground(Color.WHITE);
		lblHospital.setBounds(332, 404, 70, 15);
		frmMapcity.getContentPane().add(lblHospital);
		
		JLabel lblCityfour = new JLabel("CityFour");
		lblCityfour.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCityfour.setForeground(Color.RED);
		lblCityfour.setBounds(549, 493, 91, 24);
		frmMapcity.getContentPane().add(lblCityfour);
		
		JLabel label_2 = new JLabel("Boss Lair");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(458, 498, 87, 15);
		frmMapcity.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Power Up Den");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(652, 500, 111, 15);
		frmMapcity.getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("City Five");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(533, 625, 103, 15);
		frmMapcity.getContentPane().add(lblNewLabel);
		
		JLabel label_4 = new JLabel("Boss Lair");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(643, 625, 87, 15);
		frmMapcity.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Hospital");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(549, 681, 70, 15);
		frmMapcity.getContentPane().add(label_5);
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.GREEN);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * this function will dispose the window and run launch previous place in game environment
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				gameE.launchPreviousPlace();
			}
		});
		btnExit.setBounds(1084, 750, 117, 25);
		frmMapcity.getContentPane().add(btnExit);
	
		
		JLabel lblNewLabel_1 = new JLabel("City Six");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(325, 203, 87, 24);
		frmMapcity.getContentPane().add(lblNewLabel_1);
		
		JLabel label_6 = new JLabel("Boss Lair");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(325, 165, 87, 15);
		frmMapcity.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Shop");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(243, 208, 59, 15);
		frmMapcity.getContentPane().add(label_7);
		
		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(Map5City.class.getResource("/img/map@@.png")));
		lblImg.setBounds(0, 0, 1194, 787);
		frmMapcity.getContentPane().add(lblImg);
}
		
}
