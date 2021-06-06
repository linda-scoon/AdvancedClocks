import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.LocalTime;

/**
 * @author lns18qlr The clock class, creates a clock face of the time declared
 *         in the constructor
 */
public class Clock {

	private double hour;
	private double minutes;
	private double centre;
	private double outDiameter;// Outer circle
	private double inDiameter;// Inner circle
	private int x;
	private int y;
	private String location;
	private double sec;
	private LocalTime t;
	private int adj;

	/**
	 * 
	 * @param hour
	 * @param minutes
	 */

	public Clock(int adj, String location) {
		this.adj = adj;
		this.location = location;
		outDiameter = 100;
		inDiameter = 10;
		x = 0;// point of origin for clock
		y = 0;
		centre = outDiameter / 2;
		update();
	}

	public void update() {
		// Converting to minutes(12 hours around a clock face, to make 60 minutes=12*5)
		t = LocalTime.now();
		hour = (t.getHour() + adj) * 5.0;
		minutes = t.getMinute();
		sec = t.getSecond();
	}

	/**
	 * 
	 * @param g2
	 */
	public void draw(Graphics2D g2) {

		// Inner circle
		Ellipse2D.Double inCircle = new Ellipse2D.Double(x + centre - inDiameter / 2, y + centre - inDiameter / 2,
				inDiameter, inDiameter);
		g2.setStroke(new BasicStroke(2));
		g2.fill(inCircle);
		g2.draw(inCircle);

		// Outer circle
		Ellipse2D.Double outCircle = new Ellipse2D.Double(x, y, outDiameter, outDiameter);
		g2.draw(outCircle);

		/*
		 * 360 degrees = 60 minutes, therefore 1 minute = 360/60 degrees Convert to
		 * radians: minutes * PI/180
		 */
		int dpm = 360 / 60;
		hour = hour * dpm * (Math.PI / 180);
		minutes = Math.toRadians(minutes * dpm);
		sec = Math.toRadians(sec * dpm);

		// For debugging
//		System.out.println(hour + "|| " + hour + "|| " + minutes + "|| " + minutes);

		/*
		 * MINUTES AND HOUR HANDS Coordinates of the circle cosine angle = y/radius,
		 * sine angle = x/radius Therefore y = radius * cosine angle, x = radius * sine
		 * angle The base of the angle starts from o'clock
		 */
		double hourY = ((outDiameter / 2.0) - 10) * Math.cos(hour);// subtracting 50 inorder to shorten the hour hand
		double hourX = ((outDiameter / 2.0) - 10) * Math.sin(hour);

		double minuteY = ((outDiameter / 2.0) - 7) * Math.cos(minutes);
		double minuteX = ((outDiameter / 2.0) - 7) * Math.sin(minutes);

		double secY = (outDiameter / 2.0) * Math.cos(sec);
		double secX = (outDiameter / 2.0) * Math.sin(sec);

		// For debugging
//		System.out.println(hourY + "|| " + hourX + "|| " + minuteY + "|| " + minuteX);

		// Hour hand
		Point2D.Double p1 = new Point2D.Double(centre + x, centre - y);
		Point2D.Double p2 = new Point2D.Double(centre + hourX, centre - hourY);// add and subtract centre because origin
																				// is at centre
		Line2D.Double hHand = new Line2D.Double(p1, p2);
		g2.setStroke(new BasicStroke(4));
		g2.draw(hHand);

		// Minute hand
		Point2D.Double p3 = new Point2D.Double(centre + minuteX, centre - minuteY);
		Line2D.Double mHand = new Line2D.Double(p1, p3);
		g2.setStroke(new BasicStroke(2));
		g2.setColor(new Color(39, 245, 123));
		g2.draw(mHand);
		g2.setColor(new Color(0, 0, 0));

		// Minute hand
		Point2D.Double spoint = new Point2D.Double(centre + secX, centre - secY);
		Line2D.Double sHand = new Line2D.Double(p1, spoint);
		g2.setStroke(new BasicStroke(2));
		g2.draw(sHand);

		// Clock Face
		for (double i = 0; i <= 12; i++) {

			double hours = i * 5.0;
			double Y1 = ((outDiameter / 2) * Math.cos(Math.toRadians(hours * dpm)));
			double X1 = ((outDiameter / 2) * Math.sin(Math.toRadians(hours * dpm)));

			double Y2 = (((outDiameter / 2) - 5) * Math.cos(Math.toRadians(hours * dpm)));
			double X2 = (((outDiameter / 2) - 5) * Math.sin(Math.toRadians(hours * dpm)));

			Point2D.Double p4 = new Point2D.Double(centre + X1, centre - Y1);
			Point2D.Double p5 = new Point2D.Double(centre + X2, centre - Y2);

			g2.draw(new Line2D.Double(p4, p5));

			g2.drawString(location, 25, 120);

		}

	}

	/**
	 * 
	 * @return Hour
	 */
	public double getHour() {
		return hour;
	}

	/**
	 * 
	 * @return Minutes
	 */
	public double getMinutes() {
		return minutes;
	}

	/**
	 * 
	 * @return Centre
	 */
	public double getCentre() {
		return centre;
	}

	/**
	 * 
	 * @return outDiameter
	 */
	public double getOutDiameter() {
		return outDiameter;
	}

	/**
	 * 
	 * @return inDiameter
	 */
	public double getInDiameter() {
		return inDiameter;
	}

	/**
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

}

//import java.awt.BasicStroke;
//import java.awt.Graphics2D;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Line2D;
//import java.awt.geom.Point2D;
//import java.time.LocalTime;
//
///**
// * Clock object
// * 
// * @author lns18qlr
// *
// */
//public class Clock {
//	private double hour;
//	private double min;
//	private double mid;
//	private double outDiameter;// Outer circle
//	private double inDiameter;// Inner circle
//	private int x;
//	private int y;
//	private int sec;
//	private String location;
//	private int adj;
//
//	/**
//	 * 
//	 * @param adj
//	 * @param location
//	 */
//	public Clock(int adj, String location) {
////		LocalTime t = LocalTime.now();
//		this.adj = adj;
//		this.location = location;
////		hour = t.getHour();
////		min = t.getMinute();
////		sec = t.getSecond();
//
////		this.hour = 5;// Converting to minutes(12 hours around a clock face, to make 60 minutes=12*5)
////		this.min = 30;
//
//		outDiameter = 100;
//		inDiameter = 10;
//		x = 0;// point of origin for clock
//		y = 0;
//		mid = outDiameter / 2;
//
//		update();
//	}
//
//	/**
//	 * adjusts hour
//	 */
//	public void update() {
////		hour += adj;
//	}
//
//	@Override
//	public String toString() {
//		return hour + ":" + min + ":" + sec + " in " + location + " (" + adj + " hour difference)]";
//	}
//
//	/**
//	 * 
//	 * @param g2
//	 */
//	public void draw(Graphics2D g2) {
//		Ellipse2D.Double clockFace = new Ellipse2D.Double(x, y, outDiameter, outDiameter);
//		Ellipse2D.Double centre = new Ellipse2D.Double(outDiameter / 2, outDiameter / 2, inDiameter, inDiameter);
//
//		g2.fill(centre);
//		g2.draw(clockFace);
//		g2.drawString(location, 25, 120);
//
////		Point2D.Double centrePoint = new Point2D.Double(width / 2, height / 2);
//
//		/*
//		 * 360 degrees = 60 minutes, therefore 1 minute = 360/60 degrees Convert to
//		 * radians: minutes * PI/180
//		 */
//		int dpm = 360 / 60;
//		hour = hour * dpm * (Math.PI / 180);
//		min = Math.toRadians(min * dpm);
//
//		// For debugging
////		System.out.println(hour + "|| " + hour + "|| " + min + "|| " + min);
//
//		/*
//		 * MINUTES AND HOUR HANDS Coordinates of the circle cosine angle = y/radius,
//		 * sine angle = x/radius Therefore y = radius * cosine angle, x = radius * sine
//		 * angle The base of the angle starts from o'clock
//		 */
//		double hourY = ((outDiameter / 2.0) - 50) * Math.cos(hour);// subtracting 50 inorder to shorten the hour hand
//		double hourX = ((outDiameter / 2.0) - 50) * Math.sin(hour);
//
//		double minuteY = ((outDiameter / 2.0) - 20) * Math.cos(min);
//		double minuteX = ((outDiameter / 2.0) - 20) * Math.sin(min);
//
//		// For debugging
//		System.out.println(hourY + "|| " + hourX + "|| " + minuteY + "|| " + minuteX);
//
//		// Hour hand
//		Point2D.Double p1 = new Point2D.Double(mid + x, mid - y);
//		Point2D.Double p2 = new Point2D.Double(mid + hourX, mid - hourY);// add and subtract centre because origin is at
//																			// centre
//		Line2D.Double hHand = new Line2D.Double(p1, p2);
//		g2.setStroke(new BasicStroke(4));
//		g2.draw(hHand);
//
//		// Minute hand
////		Point2D.Double p3 = new Point2D.Double(mid + minuteX, mid - minuteY);
////		Line2D.Double mHand = new Line2D.Double(p1, p3);
////		g2.setStroke(new BasicStroke(2));
////		g2.draw(mHand);
//
//		// seconds
//		double sy = (outDiameter / 2.0) * Math.cos(min);
//		double sx = (outDiameter / 2.0) * Math.sin(min);
//
////		// sec hand
////		Point2D.Double p4 = new Point2D.Double(mid + sx, mid - sy);
////		Point2D.Double p5 = new Point2D.Double(mid + hourX, mid - hourY);// add and subtract centre because origin is at
////																			// centre
////		Line2D.Double sHand = new Line2D.Double(p4, p5);
////		g2.setStroke(new BasicStroke(4));
////		g2.draw(sHand);
//	}
//
//}