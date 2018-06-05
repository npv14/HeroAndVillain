import java.util.ArrayList;
import java.util.Collections;

public class Teams {
	String name;
	Integer money;
	boolean map = false;
	ArrayList<Heroes> listOfHero = new ArrayList<>();
	ArrayList<PowerUps> listOfPowerUps = new ArrayList<>();
	ArrayList<HealingItems> listOfHealing = new ArrayList<>();
	ArrayList<String> listOfSpecialAbilities = new ArrayList<>();

	// ArrayList<map> listOfMap;
	/**
	 * This is constructor that initialize variable name = team name and initial
	 * money = 1000
	 * 
	 * @param teamName
	 *            is the input
	 */
	public Teams(String teamName) {
		// TODO Auto-generated constructor stub
		name = teamName;
		money = 100;

	}

	/**
	 * add hero into the list of team
	 * 
	 * @param newHeroes
	 * @return string that show how the team can be display
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = new String();
		for (Heroes hero : listOfHero) {
			result += hero.name + "(type " + hero.type + "), \n";

		}
		return result;

	}

	/**this function is using for add hero in list of hero and if the hero == 4 then map variable will be true then its will be use for 
	 * decide whether or not button map be showed up.
	 * and add the hero in list of hero and add the special ability of hero in to list of special ability
	 * @param newHeroes
	 */
	public void addHero(Heroes newHeroes) {
		if (newHeroes.type == 4) {
			map = true;
		}
		listOfHero.add(newHeroes);
		addSpecialAbilitiesofHero(newHeroes);
	}

	/**
	 * add Powerups into list of Powerups
	 * 
	 * @param newPowerUps
	 */
	public void addPowerUps(PowerUps newPowerUps) {
		listOfPowerUps.add(newPowerUps);
	}

	/**
	 * add new Healing Items in list of HealingItems
	 * 
	 * @param newHealingItems
	 */
	public void addHealingItems(HealingItems newHealingItems) {
		listOfHealing.add(newHealingItems);
	}

	/**
	 * remove hero from the hero list
	 * 
	 * @param nameHero
	 */
	public void removeHero(Heroes nameHero) {
		if (nameHero.type == 4) {
			map = false;
		}
		listOfHero.remove(nameHero);
	}

	/**
	 * remove Power Ups from the list of PowerUps
	 * 
	 * @param namePowerUps
	 */
	public void removePowerUps(PowerUps namePowerUps) {
		listOfPowerUps.remove(namePowerUps);
	}

	/**
	 * remove Healing Items from the list of healingItems
	 * 
	 * @param nameHealingItems
	 */
	public void removeHealingItems(HealingItems nameHealingItems) {
		listOfHealing.remove(nameHealingItems);
	}

	/**this function uses to add the special ability of hero in to list of special abilities of team.  
	 * @param nameHero
	 */
	public void addSpecialAbilitiesofHero(Heroes nameHero) {
		listOfSpecialAbilities.add(nameHero.getSpecialAbility());

	}

	/**this function return the name of team as type string 
	 * @return name of team
	 */
	public String getname() {
		return name;
	}

	public static void main(String[] args) {
		Heroes namvu = new Heroes("namvu", 1);
		Teams Team1 = new Teams("Team1");
		Heroes Hero1 = new Heroes("Hero1", 1);
		Heroes Hero2 = new Heroes("Hero2", 2);
		PowerUps power1 = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		Team1.addHero(Hero1);
		Team1.addHero(Hero2);
		Team1.addHero(namvu);
		Team1.addPowerUps(power1);
		// Team1.addPowerUps(power2);
		Team1.addPowerUps(power3);
		Team1.addPowerUps(power1);
		Team1.addPowerUps(power1);
		Team1.listOfHero.get(1).heal = -20;
		System.out.println(Team1.listOfHero.get(2));
		
		System.out.println(Team1.listOfHero);
		// System.out.println(Team1.listOfSpecialAbilities);
		System.out.println(Team1);
		System.out.println(Collections.frequency(Team1.listOfPowerUps, power2));
	}

}
