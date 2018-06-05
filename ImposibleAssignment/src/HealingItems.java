import java.util.Timer;;

public class HealingItems {
	Integer type, price, healIncrement;
	String details;
	Timer time;
	
	
	/** this constructor get input is integer and set type of healing item
	 * @param healingItem
	 */
	public HealingItems(Integer healingItem) {
			// TODO Auto-generated constructor stub
		type = healingItem;
		setHealingItem();
	}

	/**
	 * this function set all variables of healing item base on what type it is. 
	 */
	public void setHealingItem() {
		if(type == 1){
			price = 50;
			details = "Increment 2 heal per second duration 10s";
			healIncrement = 2;
		}
		else if (type == 0) {
			details = "None";
			
		}
		else if (type == 2) {
			price = 100;
			healIncrement = 5;
			details = "Increment 5 heal per second duration 10s";
		}
		else {
			price = 250;
			healIncrement = 7;
			details = "Increment 7 heal per second duration 10s";
		}
	}
	}