import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @author npv14
 *
 */
public class GameEnvironment {
	/**
	 * Set up the game and prepare all the variables and array list needed during
	 * game. It also contains some global variables that can be called any where in
	 * game.
	 * this creates number of objects prepare before start the game
	 */
	Timer gametimer = new Timer();
	TimerTask task = new TimerTask() {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.TimerTask#run() This funtion counting time when you start the
		 * game. and it's will show up at the end.
		 * 
		 */
		public void run() {
			secondsPassed++;

		}
	};

	int secondsPassed = 0;
	PowerUps power0 = new PowerUps(0);
	PowerUps power1 = new PowerUps(1);
	PowerUps power2 = new PowerUps(2);
	PowerUps power3 = new PowerUps(3);
	HealingItems HealingItems1 = new HealingItems(1);
	HealingItems HealingItems2 = new HealingItems(2);
	HealingItems HealingItems3 = new HealingItems(3);
	boolean progressCityOne, progressCityTwo, progressCityThree, progressCityFour, progressCityFive,
			progressCitySix = false;
	String PreviousPlace = new String();
	Teams Team = new Teams(null);
	CityOne gameCityOne = new CityOne(this);
	CitySix gameCitySix = new CitySix(this);
	CityThree gameCityThree = new CityThree(this);
	CityFour gameCityFour = new CityFour(this);
	CityTwo gameCityTwo = new CityTwo(this);
	CityFive gameCityFive = new CityFive(this);

	Integer numberOfCity, numberOfhero, numberOfVillain;
	Integer countHero = 0;

	/**
	 * This function Using PreviousPlace variable that will be store in some window during the game and
	 * launch the previous place.
	 * 
	 * @param PreviousPlace
	 * 
	 * 
	 */
	public void launchPreviousPlace() {

		if (PreviousPlace == "CityOne") {
			launchCityOne();
		} else if (PreviousPlace == "Homebase") {
			launchHomebase();
		} else if (PreviousPlace == "CityTwo") {
			launchCityTwo();
		} else if (PreviousPlace == "CityThree") {
			launchCityThree();
		} else if (PreviousPlace == "CityFour") {
			launchCityFour();
		} else if (PreviousPlace == "CityFive") {
			launchCityFive();
		} else if (PreviousPlace == "CitySix") {
			launchCitySix();
		}

	}

	/**getTimer() that takes secondsPassed as game start and return as form of hours, minutes and seconds.
	 * @return the string like 00:00:00.
	 */
	public String getTimer() {
		Integer hours, minutes, seconds = 0;
		String timeString;
		hours = secondsPassed / 3600;
		minutes = (secondsPassed % 3600) / 60;
		seconds = secondsPassed % 60;

		return timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
	/**all of those functions below which are launch and close all the screen of the game 
	 * (GameEntry, SelectHeroes(this is contain some if statements that decide how many time it will run), home base, city one, city two, city three
	 * city four, city five, city six, boss lair, map3city, map4city, map5city, map6city, all the games, shop, hospital and power up den. 
	 * 
	 */

	public void launchGameEntry() {
		gametimer.scheduleAtFixedRate(task, 1000, 1000);
		GameEntry gameEntryRun = new GameEntry(this);

	}

	public void closeGameEntry(GameEntry gameEntryScreen) {
		gameEntryScreen.closeWindow();
		// System.out.println(numberOfCity);
		// System.out.println(numberOfhero);
		launchSelectHeroes();

	}

	public void launchSelectHeroes() {
		SelectHeroes SelectHeroesRun = new SelectHeroes(this);

	}

	public void closeSelectHeroes(SelectHeroes SelectHeroesScreen) {
		SelectHeroesScreen.closeWindow();
		if (countHero < numberOfhero && countHero == 1) {
			launchSelectHeroes();
		} else if (countHero < numberOfhero && countHero == 2) {
			launchSelectHeroes();
		} else {

			launchHomebase();
		}

	}

	public void launchHomebase() {
		Homebase gameHomebase = new Homebase(this);

	}

	public void closeHomebase(Homebase gameHomebase) {
		gameHomebase.closeWindow();

	}

	public void launchCityOne() {
		gameCityOne.openWindow();

	}

	public void closeCityOne(CityOne gameCityOne) {
		gameCityOne.closeWindow();

	}

	public void launchCitySix() {
		gameCitySix.openWindow();
	}

	public void closeCitySix(CitySix gameCitySix) {
		gameCitySix.closeWindow();

	}

	public void launchCityThree() {
		gameCityThree.openWindow();

	}

	public void closeCityThree(CityThree gameCityThree) {
		gameCityThree.closeWindow();

	}

	public void launchCityFour() {
		gameCityFour.openWindow();

	}

	public void closeCityFour(CityFour gameCityFour) {
		gameCityFour.closeWindow();

	}

	public void launchCityFive() {
		gameCityFive.openWindow();

	}

	public void closeCityFive(CityFive gameCityFive) {
		gameCityFive.closeWindow();

	}

	public void launchCityTwo() {
		gameCityTwo.openWindow();

	}

	public void closeCityTwo(CityTwo gameCityTwo) {
		gameCityTwo.closeWindow();

	}

	public void launchBosslair() {
		Bosslair gameBosslair = new Bosslair(this);

	}

	public void closeBosslair(Bosslair gameBosslair) {
		gameBosslair.closeWindow();

	}

	public void launchPowerUpDen() {
		PowerUpDen gamePowerUpDen = new PowerUpDen(this);

	}

	public void closePowerUpDen(PowerUpDen gamePowerUpDen) {
		gamePowerUpDen.closeWindow();

	}

	public void launchShop() {
		Shop gameShop = new Shop(this);

	}

	public void closeShop(Shop gameShop) {
		gameShop.closeWindow();

	}

	public void launchHospital() {
		Hospital gameHospital = new Hospital(this);

	}

	public void closeHospital(Hospital gameHospital) {
		gameHospital.closeWindow();

	}

	public void launchMap6City() {
		Map6City gameMap6City = new Map6City(this);

	}

	public void closeMap6City(Map6City gameMap6City) {
		gameMap6City.closeWindow();

	}

	public void launchMap3City() {
		Map3City gameMap3City = new Map3City(this);

	}

	public void closeMap3City(Map3City gameMap3City) {
		gameMap3City.closeWindow();

	}

	public void launchMap4City() {
		Map4City gameMap4City = new Map4City(this);

	}

	public void closeMap4City(Map4City gameMap4City) {
		gameMap4City.closeWindow();

	}

	public void launchMap5City() {
		Map5City gameMap5City = new Map5City(this);

	}

	public void closeMap5City(Map5City gameMap5City) {
		gameMap5City.closeWindow();

	}

	/**run and start the game
	 * @param args
	 */
	public static void main(String[] args) {
		GameEnvironment gamestart = new GameEnvironment();
		gamestart.launchGameEntry();

	}

}
