import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HealingItemsTest {

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
	void testHealingItems() {
		Integer inte;
		HealingItems HealingItems1 = new HealingItems(1);
		HealingItems HealingItems2 = new HealingItems(2);
		HealingItems HealingItems3 = new HealingItems(3);
		inte = 1;
		assertEquals(inte,  HealingItems1.type);
		inte = 2;
		assertEquals(inte,  HealingItems2.type);
		inte = 3;
		assertEquals(inte,  HealingItems3.type);
	}
	
	@Test
	void testPriceOfHealingItems() {
		Integer money;
		HealingItems HealingItems1 = new HealingItems(1);
		HealingItems HealingItems2 = new HealingItems(2);
		HealingItems HealingItems3 = new HealingItems(3);
		money = 50;
		assertEquals(money,  HealingItems1.price);
		money = 100;
		assertEquals(money,  HealingItems2.price);
		money = 250;
		assertEquals(money,  HealingItems3.price);
	}
	@Test
	void testDetailOfHealingItems() {
		HealingItems HealingItems1 = new HealingItems(1);
		HealingItems HealingItems2 = new HealingItems(2);
		HealingItems HealingItems3 = new HealingItems(3);
		assertEquals("Increment 2 heal per second duration 10s",  HealingItems1.details);
		assertEquals("Increment 5 heal per second duration 10s",  HealingItems2.details);
		assertEquals("Increment 7 heal per second duration 10s",  HealingItems3.details);
	}
	@Test
	void testHealIncrement() {
		Integer healincrement;
		HealingItems HealingItems1 = new HealingItems(1);
		HealingItems HealingItems2 = new HealingItems(2);
		HealingItems HealingItems3 = new HealingItems(3);
		healincrement = 2;
		assertEquals(healincrement,   HealingItems1.healIncrement);
		healincrement = 5;
		assertEquals(healincrement,   HealingItems2.healIncrement);
		healincrement = 7;
		assertEquals(healincrement,   HealingItems3.healIncrement);
	}
	

	@Test
	void testSetHealingItem() {
		Integer money;
		Integer healincrement;
		healincrement = 2;
		money = 50;
		HealingItems HealingItems1 = new HealingItems(1);
		assertEquals("Increment 2 heal per second duration 10s",  HealingItems1.details);
		assertEquals(healincrement,   HealingItems1.healIncrement);
		assertEquals(money,  HealingItems1.price);
		healincrement = 5;
		money = 100;
		HealingItems HealingItems2 = new HealingItems(2);
		assertEquals("Increment 5 heal per second duration 10s",  HealingItems2.details);
		assertEquals(healincrement,   HealingItems2.healIncrement);
		assertEquals(money,  HealingItems2.price);		
		healincrement = 7;
		money = 250;
		HealingItems HealingItems3 = new HealingItems(3);
		assertEquals("Increment 7 heal per second duration 10s",  HealingItems3.details);
		assertEquals(healincrement,   HealingItems3.healIncrement);
		assertEquals(money,  HealingItems3.price);
	}

}
