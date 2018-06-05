import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PowerUpsTest {

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
	void testPowerUps() {
		Integer inte;
		PowerUps power1 = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		PowerUps power0 = new PowerUps(0);
		inte = 0;
		assertEquals(inte,  power0.type);
		inte = 1;
		assertEquals(inte,  power1.type);
		inte = 2;
		assertEquals(inte,  power2.type);
		inte = 3;
		assertEquals(inte,  power3.type);
	}
	@Test
	void testPriceOfPowerUp() {
		Integer price;
		PowerUps power1 = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		PowerUps power0 = new PowerUps(0);
		price = 50;
		assertEquals(null,  power0.price);
		assertEquals(price,  power3.price);
		assertEquals(price,  power2.price);
		assertEquals(price,  power1.price);
		
	}
	@Test
	void testDetailOfPowerUp() {
		PowerUps power1 = new PowerUps(1);
		PowerUps power2 = new PowerUps(2);
		PowerUps power3 = new PowerUps(3);
		PowerUps power0 = new PowerUps(0);
		assertEquals("None",  power0.details);
		assertEquals("Only get 4, 5, 6 at Dice Roll game",  power1.details);
		assertEquals("Know future at Guess game",  power2.details);
		assertEquals("Knowing future result of Paper Scissor Rock",  power3.details);
	}
	@Test
	void testSetPowerUp() {
		Integer price;
		price = 50;
		PowerUps power1 = new PowerUps(1);
		assertEquals(price,  power1.price);
		assertEquals("Only get 4, 5, 6 at Dice Roll game",  power1.details);
		PowerUps power2 = new PowerUps(2);
		assertEquals(price,  power2.price);
		assertEquals("Know future at Guess game",  power2.details);
		PowerUps power3 = new PowerUps(3);
		assertEquals(price,  power3.price);
		assertEquals("Knowing future result of Paper Scissor Rock",  power3.details);
		PowerUps power0 = new PowerUps(0);
		assertEquals(null,  power0.price);
		assertEquals("None",  power0.details);
		
	}

}
