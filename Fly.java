import javax.swing.JDialog;

public class Fly {
	
	private static final int DIALOG_SIZE = 400;
	private static final int VELOCITY = 50;
	private static final int SLEEP_TIME = 100;
	
	private JDialog dialog;
	
	private int[] location;
	private int direction = 1;

	public static void main(String[] args) {
		new Fly();
	}
	
	public Fly() {
		location = new int[2];
		dialog = new JDialog();
		dialog.setSize(DIALOG_SIZE, DIALOG_SIZE);
		dialog.setVisible(true);
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
			dialog.setLocation(location[0], location[1]);
			move();
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (Exception ex) {}
		}
	}

}
