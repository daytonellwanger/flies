
public class Geometry {

	public static double getAngle(double[] from, double[] to) {
		double dX = to[0] - from[0];
		double dY = -(to[1] - from[1]);
		if (dX == 0) {
			return (dY > 0) ? Math.PI / 2 : 3 * Math.PI / 2;
		}
		double a = Math.atan(dY / dX);
		if ((dX <= 0) && (dY >= 0)) { // Q2
			a += Math.PI;
		} else if ((dX <= 0) && (dY <=0)) { // Q3
			a += Math.PI;
		} else if ((dX >= 0) && (dY <= 0)) { // Q4
			a += 2 * Math.PI;
		}
		return a;
	}
	
}
