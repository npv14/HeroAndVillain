import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class testF {
	int secondsPassed = 0; 
	String timeString;
	Integer hours, minutes, seconds = 0;
	static ArrayList<String> a = new ArrayList<>();
	static Random nam = new Random();
	Timer	mytimer = new Timer();
	TimerTask task = new TimerTask() {
	
		@Override
		public void run() {
			// TODO Auto-generated method stub
			secondsPassed++;
			if(secondsPassed == 10) {
				System.out.println("Stop");
				mytimer.cancel();
				hours = secondsPassed / 3600;
				minutes = (secondsPassed % 3600) / 60;
				seconds = secondsPassed % 60;

				System.out.println(timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds));
			}
		}
	};
	
	public void start() {
		mytimer.scheduleAtFixedRate(task, 1000, 1000);
//		mytimer.sch
		
	}
	public static void getrandom() {
		a.add("Rock");
		a.add("Paper");
		a.add("Scissor");
		int index1 = nam.nextInt(a.size());
		
	
}
	public static void main(String[] args) {
		testF nam = new testF();
		nam.start();
	}
	}
