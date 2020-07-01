import java.util.ArrayList;

/**
 * @author lns18qlr
 * 
 */
public class ClockProg2 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Clock> clocks = new ArrayList<>();
		clocks.add(new Clock(0, "Home - UK"));
		clocks.add(new Clock(1, "France"));
		clocks.add(new Clock(2, "Finland"));
		clocks.add(new Clock(3, "Saudi Arabia"));
		clocks.add(new Clock(4, "Azerbaijan"));
		clocks.add(new Clock(5, "Uzbekistan"));
		clocks.add(new Clock(10, "Australia"));
		clocks.add(new Clock(11, "Micronesia"));

		for (Clock clock : clocks) {
			System.out.println(clock.toString());
		}
	}

}
