import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.LocalTime;

/**
 * Clock object
 * 
 * @author lns18qlr
 *
 */
public class Clock {
	private int hour;
	private int min;
	private int sec;
	private String location;
	private int adj;

	/**
	 * 
	 * @param adj
	 * @param location
	 */
	public Clock(int adj, String location) {
		LocalTime t = LocalTime.now();
		this.adj = adj;
		this.location = location;
		hour = t.getHour();
		min = t.getMinute();
		sec = t.getSecond();
		update();
	}

	/**
	 * adjusts hour
	 */
	public void update() {

		hour += adj;
	}

	@Override
	public String toString() {
		return hour + ":" + min + ":" + sec + " in " + location + " (" + adj + " hour difference)]";
	}

	/**
	 * 
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		int x = 0;
		int y = 0;

		int width = 100;
		int height = 100;

		Ellipse2D.Double clockFace = new Ellipse2D.Double(x, y, width, height);
		Ellipse2D.Double centre = new Ellipse2D.Double(width / 2, height / 2, 10, 10);

		g2.fill(centre);
		g2.draw(clockFace);
		g2.drawString(location, 50, 110);

		Point2D.Double centrePoint = new Point2D.Double(width / 2, height / 2);

		// hours
		int r = width / 2;
		int hourLength = r;
		double xh = x + ((r * hourLength) / 100) * Math.asin(getAngleHour(this.hour));
		double yh = y - ((r * hourLength / 100) * Math.acos(getAngleHour(this.hour)));

		g2.setStroke(new BasicStroke(2));
		Point2D endHour = new Point2D.Double(xh, yh);
		Line2D hourHand = new Line2D.Double(centrePoint, endHour);
		g2.draw(hourHand);

		// minutes
		int minuteLength = 10;
		double xm = x + ((r * minuteLength) / 100) * Math.asin(getAngleMin(this.min));
		double ym = y - ((r * minuteLength / 100) * Math.acos(getAngleMin(this.min)));
		g2.setStroke(new BasicStroke(2));
		Point2D endMinute = new Point2D.Double(xm, ym);
		Line2D MinuteHand = new Line2D.Double(centrePoint, endMinute);
		g2.draw(MinuteHand);

		// seconds
		int secLength = 20;
		double xs = x + ((r * secLength) / 100) * Math.asin(getAngleSec(this.sec));
		double ys = y - ((r * secLength / 100) * Math.acos(getAngleSec(this.sec)));
		g2.setStroke(new BasicStroke(2));
		Point2D endSec = new Point2D.Double(xs, ys);
		Line2D SecHand = new Line2D.Double(centrePoint, endSec);
		g2.draw(SecHand);
	}

	private double getAngleMin(int min2) {
		return min2;
	}

	private double getAngleSec(int sec2) {
		return sec2;
	}

	/**
	 * 
	 * @param hour2
	 * @return
	 */
	private double getAngleHour(int hour2) {
		return hour2;
	}

}
