import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeamsTest {

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
	void testAddHero() {
//		fail("Not yet implemented");
		Heroes Hero1 = new Heroes("Hero1", 1);
		Heroes Hero2 = new Heroes("Hero2", 2);
		Heroes Hero3 = new Heroes("Hero3", 3);
		Heroes Hero5 = new Heroes("Hero5", 5);
		Heroes Hero4 = new Heroes("Hero4", 4);
		Heroes Hero6 = new Heroes("Hero6", 6);
		
		Teams Team1 = new Teams("Team1");
		Team1.addHero(Hero1);
		assertEquals(1, Team1.listOfHero.size());
		Team1.addHero(Hero2);
		assertEquals(2, Team1.listOfHero.size());
		Team1.addHero(Hero3);
		assertEquals(3, Team1.listOfHero.size());
		Team1.addHero(Hero4);
		assertEquals(4, Team1.listOfHero.size());
		Team1.addHero(Hero5);
		assertEquals(5, Team1.listOfHero.size());
		Team1.addHero(Hero6);
		assertEquals(6, Team1.listOfHero.size());
	}

	@Test
	void testAddPowerUps() {
		Teams Teamtest = new Teams("test");
		PowerUps power1 = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		PowerUps power0 = new PowerUps(0);
		Teamtest.addPowerUps(power0);
		assertEquals(1, Teamtest.listOfPowerUps.size());
		Teamtest.addPowerUps(power0);
		assertEquals(2, Teamtest.listOfPowerUps.size());
		Teamtest.addPowerUps(power0);
		assertEquals(3, Teamtest.listOfPowerUps.size());
		Teamtest.addPowerUps(power1);
		assertEquals(4, Teamtest.listOfPowerUps.size());
		Teamtest.addPowerUps(power2);
		assertEquals(5, Teamtest.listOfPowerUps.size());
		Teamtest.addPowerUps(power3);
		assertEquals(6, Teamtest.listOfPowerUps.size());
		Teamtest.addPowerUps(power1);
		assertEquals(7, Teamtest.listOfPowerUps.size());
		
//		fail("Not yet implemented");
	}
	@Test 
	void testGetPowerUp(){
		Teams Teamtest = new Teams("test");
		PowerUps power1 = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		PowerUps power0 = new PowerUps(0);
		Teamtest.addPowerUps(power1);
		Teamtest.addPowerUps(power2);
		Teamtest.addPowerUps(power3);
		Teamtest.addPowerUps(power0);
		Teamtest.addPowerUps(power0);
		Teamtest.addPowerUps(power3);
		Teamtest.addPowerUps(power2);
		Teamtest.addPowerUps(power1);
		assertEquals(power0, Teamtest.listOfPowerUps.get(3));
		assertEquals(power0, Teamtest.listOfPowerUps.get(4));
		assertEquals(power1, Teamtest.listOfPowerUps.get(0));
		assertEquals(power1, Teamtest.listOfPowerUps.get(7));
		assertEquals(power2, Teamtest.listOfPowerUps.get(1));
		assertEquals(power2, Teamtest.listOfPowerUps.get(6));
		assertEquals(power3, Teamtest.listOfPowerUps.get(2));
		assertEquals(power3, Teamtest.listOfPowerUps.get(5));
	}
	@Test
	void testPowerUpCollectionFrequency(){
		Teams Teamtest = new Teams("test");
		PowerUps power1 = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		PowerUps power0 = new PowerUps(0);
		Teamtest.addPowerUps(power1);
		Teamtest.addPowerUps(power2);
		Teamtest.addPowerUps(power3);
		Teamtest.addPowerUps(power0);
		Teamtest.addPowerUps(power0);
		Teamtest.addPowerUps(power3);
		Teamtest.addPowerUps(power2);
		Teamtest.addPowerUps(power1);
		Teamtest.addPowerUps(power1);
		assertEquals(2, Collections.frequency(Teamtest.listOfPowerUps, power3));
		assertEquals(2, Collections.frequency(Teamtest.listOfPowerUps, power0));
		assertEquals(2, Collections.frequency(Teamtest.listOfPowerUps, power2));
		assertEquals(3, Collections.frequency(Teamtest.listOfPowerUps, power1));
	}
	@Test
	void testAddHealingItems() {
//		fail("Not yet implemented");
		Teams Teamtest = new Teams("test");
		HealingItems HealingItems1 = new HealingItems(1);
		HealingItems HealingItems2 = new HealingItems(2);
		HealingItems HealingItems3 = new HealingItems(3);
		Teamtest.addHealingItems(HealingItems3);
		assertEquals(1, Teamtest.listOfHealing.size());
		Teamtest.addHealingItems(HealingItems3);
		assertEquals(2, Teamtest.listOfHealing.size());
		Teamtest.addHealingItems(HealingItems2);
		assertEquals(3, Teamtest.listOfHealing.size());
		Teamtest.addHealingItems(HealingItems1);
		assertEquals(4, Teamtest.listOfHealing.size());
		Teamtest.addHealingItems(HealingItems2);
		assertEquals(5, Teamtest.listOfHealing.size());
		Teamtest.addHealingItems(HealingItems1);
		assertEquals(6, Teamtest.listOfHealing.size());
		Teamtest.addHealingItems(HealingItems3);
		assertEquals(7, Teamtest.listOfHealing.size());
		
	}
	@ Test 
	void getHealingItems() {
		Teams Teamtest = new Teams("test");
		HealingItems HealingItems1 = new HealingItems(1);
		HealingItems HealingItems2 = new HealingItems(2);
		HealingItems HealingItems3 = new HealingItems(3);
		Teamtest.addHealingItems(HealingItems3);
		Teamtest.addHealingItems(HealingItems3);
		Teamtest.addHealingItems(HealingItems1);
		Teamtest.addHealingItems(HealingItems1);
		Teamtest.addHealingItems(HealingItems2);
		Teamtest.addHealingItems(HealingItems2);
		assertEquals(HealingItems1, Teamtest.listOfHealing.get(3));
		assertEquals(HealingItems2, Teamtest.listOfHealing.get(4));
		assertEquals(HealingItems3, Teamtest.listOfHealing.get(0));
		assertEquals(HealingItems3, Teamtest.listOfHealing.get(1));
		assertEquals(HealingItems1, Teamtest.listOfHealing.get(2));
		assertEquals(HealingItems2, Teamtest.listOfHealing.get(5));
		
	}
	
	@Test
	void testHealingItemsCollectionFrequency() {
		Teams Teamtest = new Teams("test");
		HealingItems HealingItems1 = new HealingItems(1);
		HealingItems HealingItems2 = new HealingItems(2);
		HealingItems HealingItems3 = new HealingItems(3);
		Teamtest.addHealingItems(HealingItems3);
		Teamtest.addHealingItems(HealingItems3);
		Teamtest.addHealingItems(HealingItems1);
		Teamtest.addHealingItems(HealingItems1);
		Teamtest.addHealingItems(HealingItems2);
		Teamtest.addHealingItems(HealingItems2);
		assertEquals(2, Collections.frequency(Teamtest.listOfHealing, HealingItems2));
		assertEquals(2, Collections.frequency(Teamtest.listOfHealing, HealingItems1));
		assertEquals(2, Collections.frequency(Teamtest.listOfHealing, HealingItems3));
	}
	@Test
	void testRemoveHero() {
		Heroes Hero1 = new Heroes("Hero1", 1);
		Heroes Hero2 = new Heroes("Hero2", 2);
		Heroes Hero3 = new Heroes("Hero3", 3);
		Heroes Hero5 = new Heroes("Hero5", 5);
		Heroes Hero4 = new Heroes("Hero4", 4);
		Heroes Hero6 = new Heroes("Hero6", 6);
		Teams Team1 = new Teams("Team1");
		Team1.addHero(Hero1);
		Team1.addHero(Hero2);
		Team1.addHero(Hero3);
		Team1.addHero(Hero4);
		Team1.addHero(Hero5);
		Team1.addHero(Hero6);
		Team1.removeHero(Hero1);
		assertEquals(5, Team1.listOfHero.size());
		Team1.removeHero(Hero2);
		assertEquals(4, Team1.listOfHero.size());
		Team1.removeHero(Hero3);
		assertEquals(3, Team1.listOfHero.size());
		Team1.removeHero(Hero4);
		assertEquals(2, Team1.listOfHero.size());
		Team1.removeHero(Hero5);
		assertEquals(1, Team1.listOfHero.size());
		Team1.removeHero(Hero6);
		assertEquals(0, Team1.listOfHero.size());
		
		
	}

	@Test
	void testRemovePowerUps() {
//		fail("Not yet implemented");
		Teams Teamtest = new Teams("test");
		PowerUps power1 = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		PowerUps power0 = new PowerUps(0);
		Teamtest.addPowerUps(power1);
		Teamtest.addPowerUps(power2);
		Teamtest.addPowerUps(power3);
		Teamtest.addPowerUps(power0);
		Teamtest.addPowerUps(power0);
		Teamtest.addPowerUps(power3);
		Teamtest.addPowerUps(power2);
		Teamtest.addPowerUps(power1);
		Teamtest.removePowerUps(power0);
		assertEquals(7, Teamtest.listOfPowerUps.size());
		assertEquals(1, Collections.frequency(Teamtest.listOfPowerUps, power0));
		Teamtest.removePowerUps(power0);
		assertEquals(6, Teamtest.listOfPowerUps.size());
		assertEquals(0, Collections.frequency(Teamtest.listOfPowerUps, power0));
		Teamtest.removePowerUps(power1);
		assertEquals(5, Teamtest.listOfPowerUps.size());
		assertEquals(1, Collections.frequency(Teamtest.listOfPowerUps, power1));
		Teamtest.removePowerUps(power2);
		assertEquals(4, Teamtest.listOfPowerUps.size());
		assertEquals(1, Collections.frequency(Teamtest.listOfPowerUps, power2));
		Teamtest.removePowerUps(power3);
		assertEquals(3, Teamtest.listOfPowerUps.size());
		assertEquals(1, Collections.frequency(Teamtest.listOfPowerUps, power3));
		Teamtest.removePowerUps(power3);
		assertEquals(2, Teamtest.listOfPowerUps.size());
		assertEquals(0, Collections.frequency(Teamtest.listOfPowerUps, power0));
		Teamtest.removePowerUps(power1);
		assertEquals(1, Teamtest.listOfPowerUps.size());
		assertEquals(0, Collections.frequency(Teamtest.listOfPowerUps, power0));
		Teamtest.removePowerUps(power2);
		assertEquals(0, Teamtest.listOfPowerUps.size());
		assertEquals(0, Collections.frequency(Teamtest.listOfPowerUps, power0));
		
		
	}

	@Test
	void testRemoveHealingItems() {
		Teams Teamtest = new Teams("test");
		HealingItems HealingItems1 = new HealingItems(1);
		HealingItems HealingItems2 = new HealingItems(2);
		HealingItems HealingItems3 = new HealingItems(3);
		Teamtest.addHealingItems(HealingItems3);
		Teamtest.addHealingItems(HealingItems3);
		Teamtest.addHealingItems(HealingItems1);
		Teamtest.addHealingItems(HealingItems1);
		Teamtest.addHealingItems(HealingItems2);
		Teamtest.addHealingItems(HealingItems2);
		Teamtest.removeHealingItems(HealingItems3);
		assertEquals(5, Teamtest.listOfHealing.size());
		assertEquals(1, Collections.frequency(Teamtest.listOfHealing, HealingItems3));
		Teamtest.removeHealingItems(HealingItems3);
		assertEquals(4, Teamtest.listOfHealing.size());
		assertEquals(0, Collections.frequency(Teamtest.listOfHealing, HealingItems3));
		Teamtest.removeHealingItems(HealingItems2);
		assertEquals(3, Teamtest.listOfHealing.size());
		assertEquals(1, Collections.frequency(Teamtest.listOfHealing, HealingItems2));
		Teamtest.removeHealingItems(HealingItems1);
		assertEquals(2, Teamtest.listOfHealing.size());
		assertEquals(1, Collections.frequency(Teamtest.listOfHealing, HealingItems1));
		Teamtest.removeHealingItems(HealingItems2);
		assertEquals(1, Teamtest.listOfHealing.size());
		assertEquals(0, Collections.frequency(Teamtest.listOfHealing, HealingItems2));
		Teamtest.removeHealingItems(HealingItems1);
		assertEquals(0, Teamtest.listOfHealing.size());
		assertEquals(0, Collections.frequency(Teamtest.listOfHealing, HealingItems1));
		
		
		
	}

	@Test
	void testAddSpecialAbilitiesofHero() {
		Heroes namvu = new Heroes("namvu", 1);
		Teams Team1 = new Teams("Team1");
		Heroes Hero1 = new Heroes("Hero1", 1);
		Heroes Hero2 = new Heroes("Hero2", 2);
		
		Team1.addHero(Hero1);
		Team1.addHero(Hero2);
		Team1.addHero(namvu);
		assertEquals(Team1.listOfSpecialAbilities.get(0), Hero1.getSpecialAbility());
		assertEquals(Team1.listOfSpecialAbilities.get(1), Hero2.getSpecialAbility());
	}

	@Test
	void testGetname() {
		//fail("Not yet implemented");
		Teams Team1 = new Teams("Team1");
		assertEquals("Team1", Team1.getname());
	}

}
