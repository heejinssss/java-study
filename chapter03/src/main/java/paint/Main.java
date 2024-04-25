package paint;

public class Main {
	public static void main(String[] args) {
		Point point1 = new Point(10, 20);
//		point.setX(10);
//		point.setY(20);
		drawPoint(point1);
//		point.disappear();
		point1.show(false);

		ColorPoint point2 = new ColorPoint(100, 200, "red");
		drawPoint(point2);
	}

	private static void drawPoint(Point point) {
		point.show();
	}

//	private static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
}
