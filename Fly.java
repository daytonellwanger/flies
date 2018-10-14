import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class Fly {
	
	private static final int SIZE = 40;
	private static final Color COLOR = Color.BLACK;
	private static final int VELOCITY = 5;
	private static final int SLEEP_TIME = 10;
	private static final double CLOSE_TOLERANCE = 10;
	private static final double SUBDESTINATION_RADIUS = 75;
	
	private JDialog fly;
	
	private Dimension screenSize;
	
	private double[] location;
	private double[] destination;
	private double[] subdestination;
	
	public Fly() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		location = new double[2];
		setNewDestination();
		subdestination = new double[2];
		setNewSubdestination();
		fly = new JDialog();
		fly.setSize(SIZE, SIZE);
		fly.getContentPane().setBackground(COLOR);
		fly.setUndecorated(true);
		fly.setAlwaysOnTop(true);
		fly.setVisible(true);
		run();
	}
	
	private double[] getRandomPosition() {
		return new double[] {
				Math.random() * screenSize.getWidth(),
				Math.random() * screenSize.getHeight()
		};
	}
	
	private void setNewDestination() {
		destination = getRandomPosition();
		System.out.println("Destination: " + destination[0] + ", " + destination[1]);
	}
	
	private void setNewSubdestination() {
		if (getDistanceToPoint(destination) < 2 * SUBDESTINATION_RADIUS) {
			subdestination = destination;
		} else {
			double angleToDestination = getAngleToPoint(destination);
			double[] circle = {location[0], location[1]};
			circle[0] += SUBDESTINATION_RADIUS * Math.cos(angleToDestination);
			circle[1] -= SUBDESTINATION_RADIUS * Math.sin(angleToDestination);
			double randomRadius = Math.random() * SUBDESTINATION_RADIUS;
			double randomAngle = Math.random() * 2 * Math.PI;
			subdestination[0] = circle[0] + randomRadius * Math.cos(randomAngle);
			subdestination[1] = circle[1] + randomRadius * Math.sin(randomAngle);
		}
	}
	
	private double getAngleToPoint(double[] point) {
		return Geometry.getAngle(location, point);
	}
	
	private double getDistanceToPoint(double[] point) {
		return Geometry.getDistance(location, point);
	}
	
	private void move() {
		double angleToSubdestination = getAngleToPoint(subdestination);
		location[0] += VELOCITY * Math.cos(angleToSubdestination);
		location[1] -= VELOCITY * Math.sin(angleToSubdestination);
		checkReachedDestination();
	}
	
	private void checkReachedDestination() {
		if (getDistanceToPoint(subdestination) < CLOSE_TOLERANCE) {
			if (subdestination == destination) {
				setNewDestination();
			}
			setNewSubdestination();
		}
	}
	
	private void run() {
		while (true) {
			fly.setLocation((int) Math.round(location[0]), (int) Math.round(location[1]));
			move();
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (Exception ex) {}
		}
	}

}
