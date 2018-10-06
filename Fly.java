import javax.swing.JDialog;

public class Fly {
	
	private static final int DIALOG_SIZE = 400;

	public static void main(String[] args) {
		JDialog dialog = new JDialog();
		dialog.setSize(DIALOG_SIZE, DIALOG_SIZE);
		dialog.setVisible(true);
		run();
	}
	
	private static void run() {
		int i = 0;
		while (true) {
			System.out.println("Loop: " + i);
			i++;
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {}
		}
	}

}
