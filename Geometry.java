
public class Geometry {

	public static double getAngle(double[] from, double[] to) {
		double dX = to[0] - from[0];
		double dY = -(to[1] - from[1]);
		return Math.atan2(dY, dX);
	}
	
}
