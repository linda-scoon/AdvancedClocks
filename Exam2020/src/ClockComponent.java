import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * 
 */

/**
 * @author lns18qlr
 *
 */
public class ClockComponent extends JComponent implements Runnable {

	private Clock clock;

	public ClockComponent(int adj, String location) {
		clock = new Clock(adj, location);
	}

	/**
	 * @param Graphics g
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		clock.draw(g2);
	}

	@Override
	public void run() {
		while (true) {
			clock.update();
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}