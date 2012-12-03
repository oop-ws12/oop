
public class Point {
	public static Point add(Point p1, Point p2) {
		return new Point(p1.getX() + p2.getX(), p1.getY() + p2.getY());
	}
	
	private final int x;
	private final int y;
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	@Override
	public String toString() {
		return String.format("Point(%d, %d)", x, y);
	}
}
