import javax.swing.JDialog;

public class Fly {
	
	private static final int DIALOG_SIZE = 400;
	private static final int VELOCITY = 5;
	private static final int SLEEP_TIME = 100;
	
	private JDialog dialog;

	public static void main(String[] args) {
		new Fly();
	}
	
	public Fly() {
		dialog = new JDialog();
		dialog.setSize(DIALOG_SIZE, DIALOG_SIZE);
		dialog.setVisible(true);
		run();
	}
	
	private void run() {
		int x = 0;
		int y = 0;
		while (true) {
			dialog.setLocation(x, y);
			x += VELOCITY;
			y += VELOCITY;
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (Exception ex) {}
		}
	}

}
