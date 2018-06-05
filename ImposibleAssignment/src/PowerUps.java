

public class PowerUps {

	Integer price;
	Integer type;
	String details;

/**the constructor need input an integer then decide what type and attribute of the power up is base on the input integer 
 ** @param typePowerUp
 */
public PowerUps(Integer typePowerUp) {
	// TODO Auto-generated constructor stub
	type =typePowerUp;
	setPowerUp();
}

/**this function is set up the price detail of power up 
 * 
 */
public void setPowerUp() {
	if(type == 1){
		price = 50;
		details = "Only get 4, 5, 6 at Dice Roll game";
		
	}
	else if (type == 0) {
		details = "None";
		
	}
	else if (type == 2) {
		price = 50;
		details = "Know future at Guess game";
	}
	else {
		price = 50;
		details = "Knowing future result of Paper Scissor Rock";
	}
}
}
