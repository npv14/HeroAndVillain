import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VillainsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testVillains() {
		Integer type;
		Villains villains1 = new Villains(1);
		Villains villains2 = new Villains(2);
		Villains villains3 = new Villains(3);
		Villains villains4 = new Villains(4);
		Villains villains5 = new Villains(5);
		Villains villains6 = new Villains(6);
		Villains villains7 = new Villains(7);
		type = 1;
		assertEquals(type, villains1.type);
		type = 2;
		assertEquals(type, villains2.type);
		type = 3;
		assertEquals(type, villains3.type);
		type = 4;
		assertEquals(type, villains4.type);
		type = 5;
		assertEquals(type, villains5.type);
		type = 6;
		assertEquals(type, villains6.type);
		type = 7;
		assertEquals(type, villains7.type);
	}

	@Test
	void testSetUpVillains() {
		Integer type, heal, damage;
		Villains villains1 = new Villains(1);
		type = 1;
		heal = 5;
		damage = 25;
		assertEquals(type, villains1.type);
		assertEquals("Yeti", villains1.name);
		assertEquals("Weak, but hard to die!!", villains1.specialAbility);
		assertEquals("Yeti Yeti Yeti Yeti Yeti, Yeti never die", villains1.taunt);
		assertEquals(heal, villains1.heal);
		assertEquals(damage, villains1.damage);
		Villains villains5 = new Villains(5);
		type = 5;
		heal = 3;
		damage = 40;
		assertEquals(type, villains5.type);
		assertEquals("Octopus", villains5.name);
		assertEquals("Roll like the Dice. Advance in dice game", villains5.specialAbility);
		assertEquals("Eight, Eight, Octopus, Octopus", villains5.taunt);
		assertEquals(heal, villains5.heal);
		assertEquals(damage, villains5.damage);
		Villains villains3 = new Villains(3);
		type = 3;
		heal = 3;
		damage = 40;
		assertEquals(type, villains3.type);
		assertEquals("Chest", villains3.name);
		assertEquals("Love guess number.", villains3.specialAbility);
		assertEquals("Chest let guess, let guess, let guess", villains3.taunt);
		assertEquals(heal, villains3.heal);
		assertEquals(damage, villains3.damage);
		Villains villains4 = new Villains(4);
		type = 4;
		heal = 4;
		damage = 50;
		assertEquals(type, villains4.type);
		assertEquals("Giant", villains4.name);
		assertEquals("Higher Damage and harder to beat", villains4.specialAbility);
		assertEquals("Bigger, Bigger, Bigger than me then you can beat me!!", villains4.taunt);
		assertEquals(heal, villains4.heal);
		assertEquals(damage, villains4.damage);
		Villains villains2 = new Villains(2);
		type = 2;
		heal = 4;
		damage = 35;
		assertEquals(type, villains2.type);
		assertEquals("Space Ship", villains2.name);
		assertEquals("I'm strong, I'm strong ", villains2.specialAbility);
		assertEquals("Chew, Chew, Chew. Bum Bum Bum.", villains2.taunt);
		assertEquals(heal, villains2.heal);
		assertEquals(damage, villains2.damage);
		Villains villains6 = new Villains(6);
		type = 6;
		heal = 3;
		damage = 35;
		assertEquals(type, villains6.type);
		assertEquals("Boar", villains6.name);
		assertEquals("I love Rolling the Dice!! let beat me!!", villains6.specialAbility);
		assertEquals("boar, I like grass. Don't eat me", villains6.taunt);
		assertEquals(heal, villains6.heal);
		assertEquals(damage, villains6.damage);
		Villains villains7 = new Villains(7);
		type = 7;
		heal = 5;
		damage = 100;
		assertEquals(type, villains7.type);
		assertEquals("Dragon King", villains7.name);
		assertEquals("Highest Damage and Hightest heal", villains7.specialAbility);
		assertEquals("Dragon is me, If you want to win this game beat me", villains7.taunt);
		assertEquals(heal, villains7.heal);
		assertEquals(damage, villains7.damage);
	}

	@Test
	void testGetname() {
		Villains villains1 = new Villains(1);
		Villains villains2 = new Villains(2);
		Villains villains3 = new Villains(3);
		Villains villains4 = new Villains(4);
		Villains villains5 = new Villains(5);
		Villains villains6 = new Villains(6);
		Villains villains7 = new Villains(7);
		
		assertEquals("Dragon King", villains7.getname());
		assertEquals("Yeti", villains1.getname());
		assertEquals("Space Ship", villains2.getname());
		assertEquals("Octopus", villains5.name);
		assertEquals("Giant", villains4.name);
		assertEquals("Chest", villains3.name);
		assertEquals("Boar", villains6.name);
		
	}

	@Test
	void testToString() {
		Villains villains1 = new Villains(1);
		Villains villains2 = new Villains(2);
		Villains villains3 = new Villains(3);
		Villains villains4 = new Villains(4);
		Villains villains5 = new Villains(5);
		Villains villains6 = new Villains(6);
		Villains villains7 = new Villains(7);
		assertEquals("Name: Yeti, Type: 1, Image /img/yeti.png", villains1.toString());
		assertEquals("Name: Chest, Type: 3, Image /img/chest.png", villains3.toString());
		assertEquals("Name: Giant, Type: 4, Image /img/giant.png", villains4.toString());
		assertEquals("Name: Octopus, Type: 5, Image /img/octopus.png", villains5.toString());
		assertEquals("Name: Boar, Type: 6, Image /img/boar.png", villains6.toString());
		assertEquals("Name: Dragon King, Type: 7, Image /img/bossDragon.png", villains7.toString());
		assertEquals("Name: Space Ship, Type: 2, Image /img/sad.png", villains2.toString());
	}

	@Test
	void testGetTaunt() {
		Villains villains1 = new Villains(1);
		Villains villains2 = new Villains(2);
		Villains villains3 = new Villains(3);
		Villains villains4 = new Villains(4);
		Villains villains5 = new Villains(5);
		Villains villains6 = new Villains(6);
		Villains villains7 = new Villains(7);
		assertEquals("Yeti Yeti Yeti Yeti Yeti, Yeti never die", villains1.getTaunt());
		assertEquals("Chest let guess, let guess, let guess", villains3.getTaunt());
		assertEquals("Bigger, Bigger, Bigger than me then you can beat me!!", villains4.getTaunt());
		assertEquals("Eight, Eight, Octopus, Octopus", villains5.getTaunt());
		assertEquals("boar, I like grass. Don't eat me", villains6.getTaunt());
		assertEquals("Dragon is me, If you want to win this game beat me", villains7.getTaunt());
		assertEquals("Chew, Chew, Chew. Bum Bum Bum.", villains2.getTaunt());
		
	}
	@Test
	void changingInVillains() {
		Integer heal;
		Villains villains1 = new Villains(1);
		villains1.heal -= 1;
		heal = 4;
		assertEquals(heal, villains1.heal);
		villains1.heal -= 1;
		heal = 3;
		assertEquals(heal, villains1.heal);
		villains1.heal -= 1;
		heal = 2;
		assertEquals(heal, villains1.heal);
		villains1.heal -= 1;
		heal = 1;
		assertEquals(heal, villains1.heal);
		villains1.heal -= 1;
		heal = 0;
		assertEquals(heal, villains1.heal);
		
		Villains villains2 = new Villains(2);
		villains2.heal -= 1;
		heal = 3;
		assertEquals(heal, villains2.heal);
		villains2.heal -= 1;
		heal = 2;
		assertEquals(heal, villains2.heal);
		villains2.heal -= 1;
		heal = 1;
		assertEquals(heal, villains2.heal);
		villains2.heal -= 1;
		heal = 0;
		assertEquals(heal, villains2.heal);
		
		Villains villains3 = new Villains(3);
		villains3.heal -= 1;
		heal = 2;
		assertEquals(heal, villains3.heal);
		villains3.heal -= 1;
		heal = 1;
		assertEquals(heal, villains3.heal);
		villains3.heal -= 1;
		heal = 0;
		assertEquals(heal, villains3.heal);
		
		Villains villains4 = new Villains(4);
		villains4.heal -= 1;
		heal = 3;
		assertEquals(heal, villains4.heal);
		villains4.heal -= 1;
		heal = 2;
		assertEquals(heal, villains4.heal);
		villains4.heal -= 1;
		heal = 1;
		assertEquals(heal, villains4.heal);
		villains4.heal -= 1;
		heal = 0;
		
		Villains villains5 = new Villains(5);
		villains5.heal -= 1;
		heal = 2;
		assertEquals(heal, villains5.heal);
		villains5.heal -= 1;
		heal = 1;
		assertEquals(heal, villains5.heal);
		villains5.heal -= 1;
		heal = 0;
		assertEquals(heal, villains5.heal);
		Villains villains6 = new Villains(6);
		villains6.heal -= 1;
		heal = 2;
		assertEquals(heal, villains6.heal);
		villains6.heal -= 1;
		heal = 1;
		assertEquals(heal, villains6.heal);
		villains6.heal -= 1;
		heal = 0;
		assertEquals(heal, villains6.heal);
		Villains villains7 = new Villains(7);
		villains7.heal -= 1;
		heal = 4;
		assertEquals(heal, villains7.heal);
		villains7.heal -= 1;
		heal = 3;
		assertEquals(heal, villains7.heal);
		villains7.heal -= 1;
		heal = 2;
		assertEquals(heal, villains7.heal);
		villains7.heal -= 1;
		heal = 1;
		assertEquals(heal, villains7.heal);
		villains7.heal -= 1;
		heal = 0;
		assertEquals(heal, villains7.heal);
		
	}

}
