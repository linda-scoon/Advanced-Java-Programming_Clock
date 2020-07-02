import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * @author lns18qlr
 * The clock class, creates a clock face of the time declared in the constructor
 */
public class Clock {

	private double hour;
	private double minutes;
	private double centre;
	private double outDiameter;// Outer circle
	private double inDiameter;// Inner circle
	private int x;
	private int y;

	/**
	 * 
	 * @param hour
	 * @param minutes
	 */
	public Clock(int hour, int minutes) {
		this.hour = hour * 5.0;// Converting to minutes(12 hours around a clock face, to make 60 minutes=12*5)
		this.minutes = minutes;

		outDiameter = 380;
		inDiameter = 20;
		x = 0;//point of origin for clock
		y = 0;
		centre = outDiameter / 2;

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
		 * 360 degrees = 60 minutes, therefore 1 minute = 360/60 degrees 
		 * Convert to radians: minutes * PI/180
		 */
		int dpm = 360 / 60;
		hour = hour * dpm * (Math.PI / 180);
		minutes = Math.toRadians(minutes * dpm);

		// For debugging
		System.out.println(hour + "|| " + hour + "|| " + minutes + "|| " + minutes);

		/*
		 * MINUTES AND HOUR HANDS
		 * Coordinates of the circle cosine angle = y/radius, sine angle = x/radius 
		 * Therefore y = radius * cosine angle, x = radius * sine angle
		 * The base of the angle starts from o'clock
		 */
		double hourY = ((outDiameter / 2.0) - 50) * Math.cos(hour);// subtracting 50 inorder to shorten the hour hand 
		double hourX = ((outDiameter / 2.0) - 50) * Math.sin(hour);

		double minuteY = (outDiameter / 2.0) * Math.cos(minutes);
		double minuteX = (outDiameter / 2.0) * Math.sin(minutes);

		// For debugging
		System.out.println(hourY + "|| " + hourX + "|| " + minuteY + "|| " + minuteX);

		// Hour hand
		Point2D.Double p1 = new Point2D.Double(centre + x, centre - y);
		Point2D.Double p2 = new Point2D.Double(centre + hourX, centre - hourY);//add and subtract centre because origin is at centre
		Line2D.Double hHand = new Line2D.Double(p1, p2);
		g2.setStroke(new BasicStroke(4));
		g2.draw(hHand);

		// Minute hand
		Point2D.Double p3 = new Point2D.Double(centre + minuteX, centre - minuteY);
		Line2D.Double mHand = new Line2D.Double(p1, p3);
		g2.setStroke(new BasicStroke(2));
		g2.draw(mHand);

		//Clock Face
		for (double i = 0; i <= 12; i++) {

			double hours = i * 5.0;
			double Y1 = ((outDiameter / 2) * Math.cos(Math.toRadians(hours * dpm)));
			double X1 = ((outDiameter / 2) * Math.sin(Math.toRadians(hours * dpm)));

			double Y2 = (((outDiameter / 2) - 30) * Math.cos(Math.toRadians(hours * dpm)));
			double X2 = (((outDiameter / 2) - 30) * Math.sin(Math.toRadians(hours * dpm)));

			Point2D.Double p4 = new Point2D.Double(centre + X1, centre - Y1);
			Point2D.Double p5 = new Point2D.Double(centre + X2, centre - Y2);

			g2.draw(new Line2D.Double(p4, p5));

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
