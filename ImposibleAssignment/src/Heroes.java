
public class Heroes {
	String name, specialAbility, image;
	Integer type, damage;
	Boolean dead = false;
	Integer heal, recoveryRate, maxheal;
	PowerUps powerUpsHero;

	/**
	 * this Constructor is created to set initialize name, type of hero and also set
	 * heal = 100% by default.
	 * 
	 * @param nameHernameHeroo
	 * @param typeHero
	 */

	public Heroes(String nameHero, int typeHero) {
		// TODO Auto-generated constructor stub
		heal = 100;
		maxheal = 100;
		name = nameHero;
		type = typeHero;
		powerUpsHero = new PowerUps(0);
		setSpecialAbility();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "(type " + type + ")";
	}

	/**this function return the name of hero 
	 * @return string that is the name of hero
	 */
	public String getname() {
		return name;
	}

	/**
	 * Set the SpecialAbility, type, image, recoverRate max heal if the max heal is
	 * different with default of the hero depend on what type player select.
	 * 
	 */
	public void setSpecialAbility() {
		if (type == 1) {
			recoveryRate = 5;
			image = "/img/Wizard.png";
			specialAbility = "Getting cheaper price at the store!";
		}

		else if (type == 2) {
			image = "/img/bowman.png";
			recoveryRate = 5;
			specialAbility = "Having a higher chance at winning the game";
			heal = 50;
			maxheal = 50;
		} else if (type == 3) {
			recoveryRate = 5;
			image = "/img/paladin.png";
			specialAbility = "Being stronger and dealing more damage";
			heal = 150;
			maxheal = 150;
		} else if (type == 4) {
			recoveryRate = 5;
			image = "/img/sprite-sheet-151x1001.png";
			specialAbility = "Always know the direction, aka being a map";

		} else if (type == 5) {
			image = "/img/sprite-sheet-2-240x10455.png";
			specialAbility = "Being more defensive and taking less damage";
			recoveryRate = 7;
			heal = 120;
			maxheal = 120;
		} else if (type == 6) {
			image = "/img/warrior2.png";
			recoveryRate = 15;
			specialAbility = "Speeding up recovery rates";

		}

	}

	/**
	 * get the special ability
	 * 
	 * @return sting of that display the special ability of hero
	 */
	public String getSpecialAbility() {

		return specialAbility;

	}

	/**
	 * if heal of hero smaller than 0 return true else return false
	 * 
	 * @return
	 */
	public boolean isDead() {
		if (heal <= 0) {
			dead = true;
		}
		return dead;
	}

}
