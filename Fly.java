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
	
	private JDialog fly;
	
	private Dimension screenSize;
	
	private double[] location;
	private double[] destination;

	public static void main(String[] args) {
		new Fly();
	}
	
	public Fly() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		location = new double[2];
		setNewDestination();
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
	
	private double getAngleToPoint(double[] point) {
		return Geometry.getAngle(location, point);
	}
	
	private double getDistanceToPoint(double[] point) {
		return Geometry.getDistance(location, point);
	}
	
	private void move() {
		double angleToDestination = getAngleToPoint(destination);
		location[0] += VELOCITY * Math.cos(angleToDestination);
		location[1] -= VELOCITY * Math.sin(angleToDestination);
		checkReachedDestination();
	}
	
	private void checkReachedDestination() {
		if (getDistanceToPoint(destination) < CLOSE_TOLERANCE) {
			setNewDestination();
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
