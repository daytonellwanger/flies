
public class Flies {
	
	private static final int MAXIMUM_FLIES = 20;
	private static final double BIRTH_PROBABILITY = .2;
	private static final int REFRESH_RATE = 1000;
	private static int numFlies = 1;

	public static void main(String[] args) {
		new Fly();
		while (numFlies < MAXIMUM_FLIES) {
			for (int i = 0; i < numFlies; i++) {
				if (Math.random() < BIRTH_PROBABILITY) {
					new Fly();
					numFlies++;
				}
			}
			try {
				Thread.sleep(REFRESH_RATE);
			} catch (Exception ex) {}
		}
	}

}
