import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

public class Fly {
	
	private static final int SIZE = 40;
	private static final Color COLOR = Color.BLACK;
	private static final int VELOCITY = 5;
	private static final int SLEEP_TIME = 10;
	
	private JDialog fly;
	
	private Dimension screenSize;
	
	private int[] location;
	private double[] destination;
	private int direction = 1;

	public static void main(String[] args) {
		new Fly();
	}
	
	public Fly() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		location = new int[2];
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
	
	private void move() {
		location[0] += direction * VELOCITY;
		location[1] += direction * VELOCITY;
		if (location[0] > 1000 || location[0] < 0) {
			direction *= -1;
		}
	}
	
	private void run() {
		while (true) {
			fly.setLocation(location[0], location[1]);
			move();
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (Exception ex) {}
		}
	}

}
