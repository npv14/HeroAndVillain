import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeroesTest {

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

	void testGetname() {
		// fail("Not yet implemented");

		Heroes testHero1 = new Heroes(null, 2);
		assertEquals(null, testHero1.getname());
		Heroes testHero = new Heroes("name", 2);
		assertEquals("name", testHero.getname());
		Heroes testHero2 = new Heroes("", 2);
		assertEquals("", testHero2.getname());
	}

	@Test
	void testtoString() {
		Heroes Hero2 = new Heroes("Hero2", 2);
		Heroes Hero1 = new Heroes("Hero1", 1);
		Heroes Hero3 = new Heroes("Hero3", 3);
		Heroes Hero4 = new Heroes("Hero4", 4);
		Heroes Hero5 = new Heroes("Hero5", 5);
		Heroes Hero6 = new Heroes("Hero6", 6);
		assertEquals("Hero1(type 1)", Hero1.toString());
		assertEquals("Hero2(type 2)", Hero2.toString());
		assertEquals("Hero3(type 3)", Hero3.toString());
		assertEquals("Hero4(type 4)", Hero4.toString());
		assertEquals("Hero5(type 5)", Hero5.toString());
		assertEquals("Hero6(type 6)", Hero6.toString());

	}

	@Test
	void testGetSpecialAbility() {
		// fail("Not yet implemented");

		Heroes testHero = new Heroes("name", 2);
		assertEquals("Having a higher chance at winning the game", testHero.getSpecialAbility());
		Heroes testHero1 = new Heroes("name", 1);
		assertEquals("Getting cheaper price at the store!", testHero1.getSpecialAbility());
		Heroes testHero2 = new Heroes("name", 3);
		assertEquals("Being stronger and dealing more damage", testHero2.getSpecialAbility());
		Heroes testHero3 = new Heroes("name", 4);
		assertEquals("Always know the direction, aka being a map", testHero3.getSpecialAbility());
		Heroes testHero4 = new Heroes("name", 5);
		assertEquals("Being more defensive and taking less damage", testHero4.getSpecialAbility());
		Heroes testHero5 = new Heroes("name", 6);
		assertEquals("Speeding up recovery rates", testHero5.getSpecialAbility());

	}

	@Test
	void testIsDead() {

		// fail("Not yet implemented");
		Heroes testHero = new Heroes("name", 2);
		testHero.heal = 0;
		assertEquals(true, testHero.isDead());
		Heroes testHero1 = new Heroes("name", 2);
		testHero1.heal = 100;
		assertEquals(false, testHero1.isDead());
		Heroes testHero2 = new Heroes("name", 2);
		testHero2.heal = -10;
		assertEquals(true, testHero2.isDead());
		Heroes testHero3 = new Heroes("name", 2);
		testHero3.heal = -1000000000;
		assertEquals(true, testHero3.isDead());
		Heroes testHero4 = new Heroes("name", 2);
		testHero4.heal = 1000000000;
		assertEquals(false, testHero4.isDead());
		testHero4.heal = 1;
		assertEquals(false, testHero4.isDead());
	}

	@Test
	void testHeroes() {
		PowerUps power = new PowerUps(0);
		Integer c;
		Heroes Hero2 = new Heroes("Hero2", 2);
		c = 50;

		assertEquals(c, Hero2.heal);
		assertEquals(c, Hero2.maxheal);
		assertEquals(power.type, Hero2.powerUpsHero.type);
		c = 5;
		assertEquals(c, Hero2.recoveryRate);

		Heroes Hero1 = new Heroes("Hero1", 1);
		c = 100;
		assertEquals(c, Hero1.heal);
		assertEquals(c, Hero1.maxheal);
		assertEquals(power.type, Hero1.powerUpsHero.type);
		c = 5;
		assertEquals(c, Hero1.recoveryRate);
		Heroes Hero3 = new Heroes("Hero3", 3);
		c = 150;

		assertEquals(c, Hero3.heal);
		assertEquals(c, Hero3.maxheal);
		assertEquals(power.type, Hero3.powerUpsHero.type);
		c = 5;
		assertEquals(c, Hero3.recoveryRate);
		Heroes Hero4 = new Heroes("Hero4", 4);
		c = 100;

		assertEquals(c, Hero4.heal);
		assertEquals(c, Hero4.maxheal);
		assertEquals(power.type, Hero4.powerUpsHero.type);
		c = 5;
		assertEquals(c, Hero4.recoveryRate);
		Heroes Hero5 = new Heroes("Hero5", 5);
		c = 120;

		assertEquals(c, Hero5.heal);
		assertEquals(c, Hero5.maxheal);
		assertEquals(power.type, Hero5.powerUpsHero.type);
		c = 7;
		assertEquals(c, Hero5.recoveryRate);
		Heroes Hero6 = new Heroes("Hero6", 6);
		c = 100;

		assertEquals(c, Hero6.heal);
		assertEquals(c, Hero6.maxheal);
		assertEquals(power.type, Hero6.powerUpsHero.type);
		c = 15;
		assertEquals(c, Hero6.recoveryRate);
	}
	@Test
	void testChangingInHero() {
		PowerUps power = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		PowerUps power0 = new PowerUps(0);
		Integer c;
		Heroes Hero2 = new Heroes("Hero2", 2);
		Hero2.heal -= 50;
		assertEquals(true, Hero2.isDead());
		Heroes Hero1 = new Heroes("Hero1", 1);
		Hero1.powerUpsHero = power;
		c = 1;
		assertEquals(c, Hero1.powerUpsHero.type);
		Hero1.powerUpsHero = power2;
		c = 2;
		assertEquals(c, Hero1.powerUpsHero.type);
		Heroes Hero3 = new Heroes("Hero3", 3);
		Hero3.heal -= 120;
		assertEquals(false, Hero3.isDead());
		Hero1.powerUpsHero = power0;
		c = 0;
		assertEquals(c, Hero1.powerUpsHero.type);
		Hero3.powerUpsHero = power3;
		c = 3;
		assertEquals(c, Hero3.powerUpsHero.type);
		Hero2.powerUpsHero = power;
		c = 1;
		assertEquals(c, Hero2.powerUpsHero.type);
		Hero1.powerUpsHero = power2;
		c = 2;
		assertEquals(c, Hero1.powerUpsHero.type);
		
	}
}
