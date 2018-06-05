
public class Villains {
	String name, taunt, specialAbility, image;
	Integer damage, heal, type;
	/**
	 * @param typeEnter as integer that will decide which type of villains( boss) is
	 * and it will run setUpVillains to get all initial variables for villain 
	 */
	public Villains(Integer typeEnter) {
		// TODO Auto-generated constructor stub3
		type = typeEnter;
		setUpVillains();
		
 }
	/**decide all of variables base on the type.
	 * the super villain is villain type 7 it got really high damage and heal
	 * 
	 */
	public void setUpVillains() {
		if (type == 1) {
			name = "Yeti";
			image = "/img/yeti.png";
			specialAbility = "Weak, but hard to die!!";
			taunt = "Yeti Yeti Yeti Yeti Yeti, Yeti never die";
			heal = 5;
			damage = 25;
		}

		else if (type == 2) {
			name = "Space Ship";
			image = "/img/sad.png";
			specialAbility = "I'm strong, I'm strong ";
			taunt = "Chew, Chew, Chew. Bum Bum Bum.";
			heal = 4;
			damage = 35;
		} else if (type == 5) {
			name = "Octopus";
			image = "/img/octopus.png";
			specialAbility = "Roll like the Dice. Advance in dice game";
			taunt = "Eight, Eight, Octopus, Octopus";
			heal = 3;
			damage = 40;
		} else if (type == 4) {
			name = "Giant";
			image = "/img/giant.png";
			specialAbility = "Higher Damage and harder to beat";
			taunt = "Bigger, Bigger, Bigger than me then you can beat me!!";
			heal = 4;
			damage = 50;
		} else if (type == 3) {
			name = "Chest";
			image = "/img/chest.png";
			specialAbility = "Love guess number.";
			taunt = "Chest let guess, let guess, let guess";
			heal = 3;
			damage = 40;
		} else if (type == 6) {
			name = "Boar";
			image = "/img/boar.png";
			specialAbility = "I love Rolling the Dice!! let beat me!!";
			taunt = "boar, I like grass. Don't eat me";
			heal = 3;
			damage = 35;}
		else if (type == 7) {
			name = "Dragon King";
			image = "/img/bossDragon.png";
			specialAbility = "Highest Damage and Hightest heal";
			taunt = "Dragon is me, If you want to win this game beat me";
			heal = 5;
			damage = 100;
		
		}
	}

	/**this function will return villain name as type of string
	 * @return name of villain
	 */
	public String getname() {
		return name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * this function will display the object it's easy to test and check what type and what villain is
	 */
	@Override
	public String toString() {
		
		return "Name: " + name + ", Type: " + type.toString() +", Image " + image ;
	}

	/**this function will return villain Taunt as type of string
	 * @return taunt of villain
	 */
	public String getTaunt() {
		return taunt;
	}
	
		
	
	

}
