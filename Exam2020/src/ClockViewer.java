import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Displays the clocks
 * 
 * @author lns18qlr
 *
 */
public class ClockViewer {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ClockComponent clock = new ClockComponent(0, "Home");
		ClockComponent clock2 = new ClockComponent(1, "France");
		ClockComponent clock3 = new ClockComponent(2, "Finland");
		ClockComponent clock4 = new ClockComponent(3, "Saudi Arabia");
		ClockComponent clock5 = new ClockComponent(4, "Azerbaijan");
		ClockComponent clock6 = new ClockComponent(5, "Uzbekistan");
		ClockComponent clock7 = new ClockComponent(10, "Australia");
		ClockComponent clock8 = new ClockComponent(11, "Micronesia");

		Thread t = new Thread(clock);
		Thread t2 = new Thread(clock2);
		Thread t3 = new Thread(clock3);
		Thread t4 = new Thread(clock4);
		Thread t5 = new Thread(clock5);
		Thread t6 = new Thread(clock6);
		Thread t7 = new Thread(clock7);
		Thread t8 = new Thread(clock8);

		t.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();

		JFrame frame = new JFrame("Clocks");
		frame.setSize(600, 600);
		frame.setLayout(new GridLayout(2, 4));
		frame.add(clock);
		frame.add(clock2);
		frame.add(clock3);
		frame.add(clock4);
		frame.add(clock5);
		frame.add(clock6);
		frame.add(clock7);
		frame.add(clock8);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
