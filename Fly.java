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
	private int direction = 1;

	public static void main(String[] args) {
		new Fly();
	}
	
	public Fly() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getWidth());
		System.out.println(screenSize.getHeight());
		location = new int[2];
		fly = new JDialog();
		fly.setSize(SIZE, SIZE);
		fly.getContentPane().setBackground(COLOR);
		fly.setUndecorated(true);
		fly.setAlwaysOnTop(true);
		fly.setVisible(true);
		run();
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
