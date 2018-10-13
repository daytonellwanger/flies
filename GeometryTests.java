
public class GeometryTests {

	public static void main(String[] args) {
		testGetAngle(0, 0, 1, 1, -Math.PI / 4);
		testGetAngle(0, 0, 0, -1, Math.PI / 2);
	}
	
	private static void testGetAngle(double x1, double y1,
										double x2, double y2,
										double expected) {
		double[] from = new double[] {x1, y1};
		double[] to = new double[] {x2, y2};
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + Geometry.getAngle(from, to));
	}

}
